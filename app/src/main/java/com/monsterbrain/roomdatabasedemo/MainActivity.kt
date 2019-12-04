package com.monsterbrain.roomdatabasedemo

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.monsterbrain.roomdatabasedemo.database.SchoolDatabase
import com.monsterbrain.roomdatabasedemo.model.ClassDivision
import com.monsterbrain.roomdatabasedemo.util.Helper

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
        val schoolNames = arrayOf("St. Johns School", "Xavior School", "Mount Blanc School", "London School", "International School", "Margaret School")
        repeat(schoolNames.size) {
            val school = Helper.getRandomSchool(schoolNames[it])
            val schoolId = schoolDatabase.schoolDao().insertSchool(school)

            for (i in 1..10) {
                val classDivisionId = schoolDatabase.classDivisionDao().insertClassDivision(
                    ClassDivision(null, "STD $i", schoolId)
                )
                repeat(10) {
                    // add 10 random students with details
                    val student = Helper.getRandomStudent(classDivisionId, schoolId)
                    schoolDatabase.studentDao().insertStudent(student)
                }
            }
        }
        Log.i(TAG, "initializeDatabase: []")

        // todo set data initialized to true
//        val prefs = getSharedPreferences(packageName + "_preference", Context.MODE_PRIVATE)
//        return prefs.getBoolean(PREFS_DATABASE_INITIALIZED, false)
    }

    private fun isDatabaseInitialized(): Boolean {
        val prefs = getSharedPreferences(packageName + "_preference", Context.MODE_PRIVATE)
        return prefs.getBoolean(PREFS_DATABASE_INITIALIZED, false)
    }

    companion object {
        const val PREFS_DATABASE_INITIALIZED = "db_initialized"
        const val TAG = "MainActivity"
    }
}
