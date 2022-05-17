package com.dasonick.beautymodelapp.ui.login

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.dasonick.beautymodelapp.R
import com.dasonick.beautymodelapp.databinding.BeautyServicesFragmentBinding
import com.dasonick.beautymodelapp.databinding.LoginFragmentBinding
import kotlinx.coroutines.runBlocking

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var viewModel: LoginViewModel
    private lateinit var binding: LoginFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = LoginFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val token = context?.getSharedPreferences(
            getString(R.string.preference_file_key),
            Context.MODE_PRIVATE)?.getString("token", null)
        if (token != null)
            findNavController().navigate(R.id.action_loginFragment_to_mainFragment)

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        // TODO: Use the ViewModel
        binding.login.setOnClickListener {
            viewModel.onLoginButtonClicked(binding.loginPhone.text.toString(),
                binding.loginPassword.text.toString(), requireContext())
        }
        binding.toReg.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registrationFragment)
        }
        viewModel.goToMain().observe(viewLifecycleOwner){
            val token = context?.getSharedPreferences(
                getString(R.string.preference_file_key),
                Context.MODE_PRIVATE)?.getString("token", null)
            if (it) runBlocking {
                viewModel.updateData(token!!).observe(viewLifecycleOwner){ person ->
                    if (person != null) {
                        val prefs = requireContext().getSharedPreferences(
                            getString(R.string.preference_file_key),
                            Context.MODE_PRIVATE
                        )
                        with(prefs.edit()) {
                            putString("name", person.name)
                            putString("username", person.phone)
                            putString("town", person.town)
                            putInt("type", person.type.value)
                            apply()
                        }
                    }
                }
                findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
            }
        }
    }
}