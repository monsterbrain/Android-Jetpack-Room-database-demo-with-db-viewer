package com.monsterbrain.roomdatabasedemo.util

import com.monsterbrain.roomdatabasedemo.model.School
import com.monsterbrain.roomdatabasedemo.model.Student
import kotlin.random.Random

object Helper {
    private val firstNames = arrayOf("John", "Jim", "Carrey", "Watson", "Jacob", "Paul")
    private val lastNames = arrayOf("Micheal", "Jackson", "Johny", "Wicky", "Woody", "Ronald")
    private val addresses = arrayOf(
        "St John Street. KS Road.",
        "St Patrick Street. GM Road.",
        "St Paul's Road. VV Road",
        "WB Street. JK Road")

    fun getRandomStudent(classId: Long, schoolId: Long): Student {
        return Student(null,
            "${firstNames.getRandItem()} ${lastNames.getRandItem()}",
            addresses.getRandItem(),
            classId, schoolId)
    }

    fun getRandomSchool(name:String): School {
        return School(null,
            name,
            addresses.getRandItem())
    }
}

/**
 * return a random item from the array
 * @receiver Array<T>
 * @return T
 */
private fun <T> Array<T>.getRandItem(): T {
    return this[Random.nextInt(size)]
}
