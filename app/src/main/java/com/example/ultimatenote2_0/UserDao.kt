package com.example.ultimatenote2_0

import androidx.lifecycle.LiveData
import androidx.room.*
import java.util.concurrent.Flow

@Dao
interface  UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Update
    suspend fun update(user: User)

    @Query("Select * From user_table ")
    fun getAllData (): LiveData<List<User>>
//
//    @Query("Select * From user_table Where nameTitle Like :searchQuery Or lastNote Like:searchQuery")
//    fun searchDatabase(searchQuery:String ):LiveData<List<User>>
}