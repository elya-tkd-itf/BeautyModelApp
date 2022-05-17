package com.dasonick.beautymodelapp.ui.main.beauty_services

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.dasonick.beautymodelapp.R
import com.dasonick.beautymodelapp.base.BeautyService
import com.dasonick.beautymodelapp.databinding.BeautyServicesFragmentBinding
import com.dasonick.beautymodelapp.databinding.CategoriesFragmentBinding
import com.dasonick.beautymodelapp.model.Repository
import com.dasonick.beautymodelapp.ui.main.categories.CategoriesRecyclerAdapter
import com.dasonick.beautymodelapp.ui.main.categories.CategoriesViewModel

class BeautyServicesFragment : Fragment() {

    companion object {
        fun newInstance() = BeautyServicesFragment()
    }

    private val viewModel: BeautyServicesViewModel by activityViewModels()
    private lateinit var binding: BeautyServicesFragmentBinding
    private var categoryId: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = BeautyServicesFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        categoryId = arguments?.getInt("category")

        binding.beautyServicesRecycler.apply {
            layoutManager = GridLayoutManager(context, 2)
        }

        val town = requireContext().getSharedPreferences(
            getString(R.string.preference_file_key),
            Context.MODE_PRIVATE
        ).getString("town", null)

        val token = requireContext().getSharedPreferences(
            getString(R.string.preference_file_key),
            Context.MODE_PRIVATE
        ).getString("token", null)

        viewModel.getData(categoryId!!, town!!, token!!).observe(viewLifecycleOwner) {
            //Log.wtf("list")
            binding.beautyServicesRecycler.adapter = BeautyServicesRecyclerAdapter(it, findNavController())
        }
    }
}