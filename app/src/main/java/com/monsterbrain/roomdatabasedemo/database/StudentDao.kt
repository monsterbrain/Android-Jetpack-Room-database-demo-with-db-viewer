package com.monsterbrain.roomdatabasedemo.database

import androidx.room.Dao
import androidx.room.Query
import com.monsterbrain.roomdatabasedemo.model.Student
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE

@Dao
interface StudentDao {
    @Query("SELECT * FROM Student")
    fun getAllStudents(): List<Student>

    @Query("SELECT * FROM Student WHERE id= :id")
    fun loadStudentById(id: Long): Student

    @Query("SELECT * FROM Student where id= :name")
    fun findStudentByName(name: String): List<Student>

    @Insert(onConflict = IGNORE)
    fun insertStudent(student: Student)

    @Insert(onConflict = IGNORE)
    fun insertMultipleRecord(students: List<Student>)

    @Delete
    fun deleteStudent(student: Student)
}