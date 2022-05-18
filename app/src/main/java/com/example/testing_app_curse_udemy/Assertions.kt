package com.example.testing_app_curse_udemy

class Assertions {
    private val user = User("andres",24)

    fun getLuckyNumbers() = arrayOf(8,17)

    fun getName()= user.name

    fun checkHuman()= user.isHuman

    fun checkHuman(user: User?)=user?.isHuman

    fun isAdult(user: User): Boolean {
        return if (!user.isHuman) true else user.age >= 18
    }
}