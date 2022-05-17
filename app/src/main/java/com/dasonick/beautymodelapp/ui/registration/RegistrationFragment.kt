package com.dasonick.beautymodelapp.ui.registration

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import com.dasonick.beautymodelapp.R
import com.dasonick.beautymodelapp.databinding.RegistrationFragmentBinding
import kotlinx.coroutines.runBlocking

class RegistrationFragment : Fragment() {

    companion object {
        fun newInstance() = RegistrationFragment()
    }

    private lateinit var viewModel: RegistrationViewModel
    private lateinit var binding: RegistrationFragmentBinding
    private var town: String? = null
    private var type: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = RegistrationFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RegistrationViewModel::class.java)

        viewModel.goToMain().observe(viewLifecycleOwner) {
            val token = context?.getSharedPreferences(
                getString(R.string.preference_file_key),
                Context.MODE_PRIVATE)?.getString("token", null)
            if (it) viewModel.goToMain().observe(viewLifecycleOwner){
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
                            findNavController().navigate(R.id.action_registrationFragment_to_mainFragment)
                        }
                    }
                }
            }
        }

        binding.regTown.adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            resources.getStringArray(R.array.Towns)
        )

        binding.regType.adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            resources.getStringArray(R.array.Types)
        )

        binding.reg.setOnClickListener {
            if (town != null && type != null)
                viewModel.onRegButtonClicked(
                    binding.regName.text.toString(),
                    binding.regNumber.text.toString(),
                    town!!, type!!,
                    binding.regPassword.text.toString(),
                    requireContext())
        }

        binding.regTown.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>,
                                        view: View, position: Int, id: Long) {
                town = resources.getStringArray(R.array.Towns)[position]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                //TODO("Not yet implemented")
            }
        }
        binding.regType.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>,
                                        view: View, position: Int, id: Long) {
                type = position
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                //TODO("Not yet implemented")
            }
        }
    }
}