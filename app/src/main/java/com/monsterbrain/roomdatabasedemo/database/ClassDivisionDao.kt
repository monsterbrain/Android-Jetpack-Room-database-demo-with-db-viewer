package com.monsterbrain.roomdatabasedemo.database

import androidx.room.Dao
import androidx.room.Query
import com.monsterbrain.roomdatabasedemo.model.Student
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import com.monsterbrain.roomdatabasedemo.model.ClassDivision
import com.monsterbrain.roomdatabasedemo.model.School

@Dao
interface ClassDivisionDao {
    @Query("SELECT * FROM ClassDivision")
    fun getAllClassDivisions(): List<ClassDivision>

    @Insert(onConflict = IGNORE)
    fun insertClassDivision(school: ClassDivision): Long
}