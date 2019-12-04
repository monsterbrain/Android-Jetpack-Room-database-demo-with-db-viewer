package com.monsterbrain.roomdatabasedemo.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ClassDivision")
data class ClassDivision(
    @NonNull @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val name: String = "",
    val schoolId: Long? = null
)