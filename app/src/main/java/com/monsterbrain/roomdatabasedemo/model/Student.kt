package com.monsterbrain.roomdatabasedemo.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Student")
data class Student(
    @NonNull @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val name: String = "",
    val address: String = "",
    val classId: Long? = null,
    val schoolId: Long? = null
)