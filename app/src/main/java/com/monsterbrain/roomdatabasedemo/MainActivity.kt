package com.monsterbrain.roomdatabasedemo

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.monsterbrain.roomdatabasedemo.database.SchoolDatabase
import com.monsterbrain.roomdatabasedemo.model.Student
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var schoolDatabase: SchoolDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        schoolDatabase = SchoolDatabase.getDatabase(this)

        if (isDatabaseInitialized()) {

        } else {
            initializeDatabase()
        }
    }

    private fun initializeDatabase() {
        val student = Student(null, "Hello", "ABC Street", 100, 200)
        schoolDatabase.studentDao().insertStudent(student)
    }

    private fun isDatabaseInitialized(): Boolean {
        val prefs = getSharedPreferences(packageName + "_preference", Context.MODE_PRIVATE)
        return prefs.getBoolean(PREFS_DATABASE_INITIALIZED, false)
    }

    companion object {
        const val PREFS_DATABASE_INITIALIZED = "db_initialized"
    }
}
