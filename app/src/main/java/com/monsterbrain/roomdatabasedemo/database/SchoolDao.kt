package com.monsterbrain.roomdatabasedemo.database

import androidx.room.Dao
import androidx.room.Query
import com.monsterbrain.roomdatabasedemo.model.Student
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import com.monsterbrain.roomdatabasedemo.model.School

@Dao
interface SchoolDao {
    @Query("SELECT * FROM School")
    fun getAllSchools(): List<School>

    @Insert(onConflict = IGNORE)
    fun insertSchool(school: School): Long
}