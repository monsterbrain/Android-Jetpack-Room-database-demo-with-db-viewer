package com.monsterbrain.roomdatabasedemo.database

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import com.monsterbrain.roomdatabasedemo.model.Student
import androidx.room.Room

@Database(entities = [Student::class], version = 1, exportSchema = false)
abstract class SchoolDatabase : RoomDatabase() {
    private var instance: SchoolDatabase? = null

    abstract fun studentDao(): StudentDao

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

    fun getDatabase(context: Context): SchoolDatabase {
        if (instance == null) {
            instance = Room.databaseBuilder(context, SchoolDatabase::class.java, "School_DB")
                .allowMainThreadQueries()
                .build()
        }
        return instance as SchoolDatabase
    }

    fun destroyInstance() {
        instance = null
    }
}