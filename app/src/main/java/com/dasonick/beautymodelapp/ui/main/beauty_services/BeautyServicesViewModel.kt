package com.dasonick.beautymodelapp.ui.main.beauty_services

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dasonick.beautymodelapp.base.BeautyService
import com.dasonick.beautymodelapp.base.Category
import com.dasonick.beautymodelapp.data.BeautyServicesData
import com.dasonick.beautymodelapp.data.CategoriesData
import com.dasonick.beautymodelapp.model.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BeautyServicesViewModel : ViewModel() {
    private var data: MutableLiveData<List<BeautyService>>? = null
    private var category = 0
    private lateinit var town: String
    private var repo = Repository()

    fun getData(category: Int, town: String, token: String): LiveData<List<BeautyService>> {
        this.category = category
        this.town = town
        if (data == null) {
            data = MutableLiveData()
            loadData(token)
        }
        return data as LiveData<List<BeautyService>>
    }

    private fun loadData(token: String) {
        viewModelScope.launch(Dispatchers.IO){
            data?.postValue(repo.getServicesByCategory(category, town, token))
        }
    }
}