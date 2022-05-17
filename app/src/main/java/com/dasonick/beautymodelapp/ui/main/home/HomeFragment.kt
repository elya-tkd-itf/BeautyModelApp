package com.dasonick.beautymodelapp.ui.main.home

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.dasonick.beautymodelapp.R
import com.dasonick.beautymodelapp.databinding.BeautyServicesFragmentBinding
import com.dasonick.beautymodelapp.databinding.HomeFragmentBinding
import com.dasonick.beautymodelapp.ui.main.beauty_services.BeautyServicesRecyclerAdapter
import kotlinx.coroutines.runBlocking

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: HomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HomeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        // TODO: Use the ViewModel
        binding.recommendedServicesRecycler.apply {
            layoutManager = GridLayoutManager(context, 2)
        }

        val token = context?.getSharedPreferences(
            getString(R.string.preference_file_key),
            Context.MODE_PRIVATE)?.getString("token", null)

        val town = requireContext().getSharedPreferences(
            getString(R.string.preference_file_key),
            Context.MODE_PRIVATE
        ).getString("town", null)

        viewModel.getData(
            town!!, token!!
        ).observe(viewLifecycleOwner) {
            if (it != null) {
                Log.wtf("recommendedServices", it.size.toString())
                binding.recommendedServicesRecycler.adapter =
                    HomeServicesRecyclerAdapter(it, findNavController())
            }
        }

        viewModel.getMasters(
            town!!, token
        ).observe(viewLifecycleOwner) {
            if (it != null) {
                Log.wtf("getMasters", it.size.toString())
                if (it.isNotEmpty()) binding.topMaster1.text = it[0].name
                if (it.size > 1) binding.topMaster2.text = it[1].name
                if (it.size > 2) binding.topMaster3.text =it[2].name
            }
        }
    }
}