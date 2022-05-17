package com.dasonick.beautymodelapp.ui.main.home

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dasonick.beautymodelapp.base.BeautyService
import com.dasonick.beautymodelapp.base.Person
import com.dasonick.beautymodelapp.model.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private var data: MutableLiveData<List<BeautyService>>? = null
    private var masters: MutableLiveData<List<Person>>? = null
    private lateinit var town: String
    private var repo = Repository()

    fun getData(town: String, token: String): LiveData<List<BeautyService>> {
        this.town = town
        if (data == null) {
            data = MutableLiveData()
            loadData(token)
        }
        return data as LiveData<List<BeautyService>>
    }

    fun getMasters(town: String, token: String): LiveData<List<Person>> {
        this.town = town
        if (masters == null) {
            masters = MutableLiveData()
            loadMasters(token)
        }
        return masters as LiveData<List<Person>>
    }

    private fun loadData(token: String) {
        viewModelScope.launch(Dispatchers.IO){
            data?.postValue(repo.getRecommendedServices(town, token))
        }
    }

    private fun loadMasters(token: String) {
        viewModelScope.launch(Dispatchers.IO){
            masters?.postValue(repo.getTopOfMastersInTown(town, token))
        }
    }
}