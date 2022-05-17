package com.dasonick.beautymodelapp.ui.main.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.dasonick.beautymodelapp.base.Category
import com.dasonick.beautymodelapp.databinding.CategoriesFragmentBinding

class CategoriesFragment : Fragment() {

    companion object {
        fun newInstance() = CategoriesFragment()
    }

    private val viewModel: CategoriesViewModel by activityViewModels()
    private lateinit var binding: CategoriesFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CategoriesFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.categoriesRecycler.apply {
            layoutManager = GridLayoutManager(context, 2)
        }

        viewModel.getData().observe(viewLifecycleOwner) {
            binding.categoriesRecycler.adapter = CategoriesRecyclerAdapter(it, findNavController())
        }
    }
}