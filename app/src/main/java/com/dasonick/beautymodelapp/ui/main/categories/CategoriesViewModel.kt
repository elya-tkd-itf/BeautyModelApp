package com.dasonick.beautymodelapp.ui.main.categories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dasonick.beautymodelapp.base.Category
import com.dasonick.beautymodelapp.data.CategoriesData

class CategoriesViewModel : ViewModel() {

    private var data: MutableLiveData<List<Category>>? = null

    fun getData(): LiveData<List<Category>> {
        if (data == null) {
            data = MutableLiveData()
            loadData()
        }
        return data as LiveData<List<Category>>
    }

    private fun loadData() {
        data?.postValue(CategoriesData.getCategories())
    }
}