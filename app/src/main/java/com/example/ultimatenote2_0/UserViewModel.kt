package com.example.ultimatenote2_0

import android.app.Application
import android.app.DownloadManager
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asFlow
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel (application: Application): AndroidViewModel(application){

    val readAllData: LiveData<List<User>>
    val repository:UserRepository

    init {
        val userDao= UserDatabase.getDatabase(application).userDao()
        repository= UserRepository(userDao)
        readAllData= repository.readAllData
    }


    fun insert(user:User){
        viewModelScope.launch(Dispatchers.IO){
            repository.insert(user)
        }
    }

    fun updateUser(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateUser(user)
        }

    }
    fun deleteUser(user: User){
        viewModelScope.launch (Dispatchers.IO ){
            repository.deleteUser(user)
        }

    }


}