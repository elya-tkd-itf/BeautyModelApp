package com.dasonick.beautymodelapp.ui.main.my_services

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.dasonick.beautymodelapp.R
import com.dasonick.beautymodelapp.databinding.MyServicesFragmentBinding
import com.dasonick.beautymodelapp.databinding.NewFragmentBinding

class MyServicesFragment : Fragment() {

    companion object {
        fun newInstance() = MyServicesFragment()
    }

    private lateinit var viewModel: MyServicesViewModel
    private lateinit var binding: MyServicesFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MyServicesFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MyServicesViewModel::class.java)
        // TODO: Use the ViewModel
        binding.addServiceBtn.setOnClickListener {
            findNavController().navigate(R.id.action_myServicesFragment2_to_newServiceFragment)
        }
    }
}