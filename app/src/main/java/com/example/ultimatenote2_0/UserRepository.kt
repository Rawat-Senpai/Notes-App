package com.example.ultimatenote2_0

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.asFlow
import kotlinx.coroutines.flow.Flow

class UserRepository (private val userDao:UserDao){

    val readAllData: LiveData<List<User>> = userDao.getAllData()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(user: User) {
        userDao.insert(user)
    }
    suspend fun updateUser(user: User){
        userDao.update(user)
    }
    suspend fun deleteUser(user: User){
        userDao.deleteUser(user)
    }

//    fun searchDatabase(searchQuery:String): Flow<List<User>> {
//        return userDao.searchDatabase(searchQuery).asFlow()
//    }

}