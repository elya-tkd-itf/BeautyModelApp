package com.dasonick.beautymodelapp.ui.new_service

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.dasonick.beautymodelapp.R
import com.dasonick.beautymodelapp.base.BeautyService
import com.dasonick.beautymodelapp.databinding.NewFragmentBinding
import com.dasonick.beautymodelapp.databinding.RegistrationFragmentBinding

class NewServiceFragment : Fragment() {

    companion object {
        fun newInstance() = NewServiceFragment()
    }

    private lateinit var viewModel: NewViewModel
    private lateinit var binding: NewFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = NewFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(NewViewModel::class.java)
        // TODO: Use the ViewModel
        binding.newServiceOk.setOnClickListener {
            viewModel.addService(
                BeautyService(
                    0,
                    binding.newServiceName.text.toString(),
                    binding.newServiceDesk.text.toString(),
                    binding.newServiceCost.text.toString().toInt(),
                    binding.newServiceUrl.text.toString(),
                    requireContext().getSharedPreferences(
                        getString(R.string.preference_file_key),
                    Context.MODE_PRIVATE)?.getString("id", "1")!!.toInt(),
                    requireContext().getSharedPreferences(
                        getString(R.string.preference_file_key),
                        Context.MODE_PRIVATE)?.getString("name", "Igor")!!
                ),
                requireContext().getSharedPreferences(
                    getString(R.string.preference_file_key),
                    Context.MODE_PRIVATE)?.getString("token", "null")!!
            )
            findNavController().navigate(R.id.action_newServiceFragment_to_myServicesFragment2)
        }
    }
}