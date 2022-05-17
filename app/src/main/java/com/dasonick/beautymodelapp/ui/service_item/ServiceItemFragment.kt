package com.dasonick.beautymodelapp.ui.service_item

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dasonick.beautymodelapp.R

class ServiceItemFragment : Fragment() {

    companion object {
        fun newInstance() = ServiceItemFragment()
    }

    private lateinit var viewModel: ServiceItemViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.service_item_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ServiceItemViewModel::class.java)
        // TODO: Use the ViewModel
    }
}