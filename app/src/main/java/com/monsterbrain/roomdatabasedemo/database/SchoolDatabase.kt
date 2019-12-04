package com.monsterbrain.roomdatabasedemo.database

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import com.monsterbrain.roomdatabasedemo.model.Student
import androidx.room.Room
import com.monsterbrain.roomdatabasedemo.model.ClassDivision
import com.monsterbrain.roomdatabasedemo.model.School

@Database(entities = [Student::class, School::class, ClassDivision::class], version = 1, exportSchema = false)
abstract class SchoolDatabase : RoomDatabase() {
    private var instance: SchoolDatabase? = null

    abstract fun studentDao(): StudentDao
    abstract fun schoolDao(): SchoolDao
    abstract fun classDivisionDao(): ClassDivisionDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: SchoolDatabase? = null

        fun getDatabase(context: Context): SchoolDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SchoolDatabase::class.java,
                    "school_database"
                ).allowMainThreadQueries().build()
                INSTANCE = instance
                return instance
            }
        }
    }

    fun destroyInstance() {
        instance = null
    }
}