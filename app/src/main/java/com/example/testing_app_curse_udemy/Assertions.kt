package com.example.testing_app_curse_udemy

class Assertions {
    private val user = User("andres",24)
    private var location = "US"

    fun setLocation(location:String){
        this.location= location
    }
    fun getLuckyNumbers() = arrayOf(8,17)

    fun getName()= user.name

    fun checkHuman()= user.isHuman

    fun checkHuman(user: User?)=user?.isHuman

    fun isAdult(user: User): Boolean {
        if (!user.isHuman) return true
        return if (location =="US") user.age >= 21
        else user.age >= 18
    }
}