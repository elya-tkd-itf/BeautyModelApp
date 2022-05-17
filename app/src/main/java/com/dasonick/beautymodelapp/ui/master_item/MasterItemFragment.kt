package com.dasonick.beautymodelapp.ui.master_item

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dasonick.beautymodelapp.R

class MasterItemFragment : Fragment() {

    companion object {
        fun newInstance() = MasterItemFragment()
    }

    private lateinit var viewModel: MasterItemViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.master_item_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MasterItemViewModel::class.java)
        // TODO: Use the ViewModel
    }
}