package com.example.ultimatenote2_0

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "user_table")
data class User (

    @PrimaryKey(autoGenerate = true)
    val id:Int=0,
    @ColumnInfo  val nameTitle:String,
    @ColumnInfo val lastNote:String
): Parcelable