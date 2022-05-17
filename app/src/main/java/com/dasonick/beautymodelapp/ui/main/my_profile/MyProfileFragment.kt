package com.dasonick.beautymodelapp.ui.main.my_profile

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.dasonick.beautymodelapp.R
import com.dasonick.beautymodelapp.databinding.MainFragmentBinding
import com.dasonick.beautymodelapp.databinding.MyProfileFragmentBinding

class MyProfileFragment : Fragment() {

    companion object {
        fun newInstance() = MyProfileFragment()
    }

    private lateinit var viewModelMy: MyProfileViewModel
    private lateinit var binding: MyProfileFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MyProfileFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModelMy = ViewModelProvider(this).get(MyProfileViewModel::class.java)

        binding.exit.setOnClickListener {
            val prefs = requireContext().getSharedPreferences(
                getString(R.string.preference_file_key),
                Context.MODE_PRIVATE
            )
            with(prefs.edit()) {
                putString("token", null)
                apply()
            }
            findNavController().navigate(R.id.action_myProfileFragment_to_loginFragment2)
        }
    }
}