package com.dasonick.beautymodelapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dasonick.beautymodelapp.base.BeautyService
import com.dasonick.beautymodelapp.base.Person
import com.dasonick.beautymodelapp.model.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private var repo = Repository()
    private var person = MutableLiveData<Person>()

    fun updateData(token: String): LiveData<Person>{
        viewModelScope.launch(Dispatchers.IO){
            person.postValue(repo.getMyInfo(token))
        }
        return person
    }
}