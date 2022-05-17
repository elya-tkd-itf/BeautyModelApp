package com.dasonick.beautymodelapp.ui.main

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.dasonick.beautymodelapp.R
import com.dasonick.beautymodelapp.databinding.MainFragmentBinding
import com.dasonick.beautymodelapp.helpers.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainFragment : Fragment() {//TODO("Add my params")

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.bottomNavigation.setupWithNavController(
            listOf(
                R.navigation.home_fragment_graph,
                R.navigation.categories_fragment_graph,
                R.navigation.my_services_fragment_graph,
                R.navigation.my_profile_fragment_graph
            ),
            childFragmentManager,
            R.id.main_container_view,
            requireActivity().intent
        )
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

    }
}