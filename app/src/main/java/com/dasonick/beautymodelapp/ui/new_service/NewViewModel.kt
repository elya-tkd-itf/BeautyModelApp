package com.dasonick.beautymodelapp.ui.new_service

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dasonick.beautymodelapp.base.BeautyService
import com.dasonick.beautymodelapp.base.Person
import com.dasonick.beautymodelapp.model.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewViewModel : ViewModel() {
    private var repo = Repository()
    fun addService(service: BeautyService, token: String) {
        viewModelScope.launch(Dispatchers.IO){
            repo.createBeautyService(service, token)
        }
    }
}