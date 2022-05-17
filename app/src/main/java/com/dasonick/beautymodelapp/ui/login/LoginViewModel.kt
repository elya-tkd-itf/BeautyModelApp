package com.dasonick.beautymodelapp.ui.login

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dasonick.beautymodelapp.R
import com.dasonick.beautymodelapp.base.Person
import com.dasonick.beautymodelapp.model.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private var repo = Repository()
    private var goToMain = MutableLiveData<Boolean>()

    fun onLoginButtonClicked(phoneNumber: String, password: String, context: Context) {
        viewModelScope.launch(Dispatchers.IO){
            val token = repo.authByPhoneNumber(phoneNumber, password)
            if (token != null) {
                val prefs = context.getSharedPreferences(context.getString(R.string.preference_file_key), Context.MODE_PRIVATE)
                with (prefs.edit()) {
                    putString("token", token)
                    apply()
                }
                goToMain.postValue(true)
            } else Log.d("onLoginButtonClicked", "no token in base")
        }
    }

    fun goToMain() : LiveData<Boolean> = goToMain

    private var person = MutableLiveData<Person>()

    fun updateData(token: String): LiveData<Person>{
        viewModelScope.launch(Dispatchers.IO){
            person.postValue(repo.getMyInfo(token))
        }
        return person
    }
}