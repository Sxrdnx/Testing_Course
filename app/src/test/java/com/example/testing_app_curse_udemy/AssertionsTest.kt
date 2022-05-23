package com.example.testing_app_curse_udemy


import org.junit.Test
import com.google.common.truth.Truth.assertThat
import com.google.common.truth.Truth.assertWithMessage
import kotlin.random.Random

class AssertionsTest{
    @Test
    fun getCorrectLuckyNumbers(){
        val assertions = Assertions()
        val valueExpected = arrayOf(1,17)
       //assertThat(valueExpected).isEqualTo(assertions.getLuckyNumbers())
        assertWithMessage("custom message in assert").that(valueExpected).isEqualTo(assertions.getLuckyNumbers())
    }

    @Test
    fun checkNoSameUsers(){
        val user1 = User("pepe",18,true)
        val user2 = User("pepe",19,true)
        assertThat(user1).isNotSameInstanceAs(user2)
    }
    
    @Test
    fun checkSameUsers(){
        val user1 = User("pepe",18,true)
        val user2 = user1
        assertThat(user2).isSameInstanceAs(user1)
    }

    @Test(timeout = 1_000)
    fun testWithTimeOut(){
        val array = arrayOf(1,2,3,4)
        Thread.sleep(Random.nextLong(950,1_050))
        assertThat(array.size).isEqualTo(4)
    }

    @Test
    fun isAdult() {
    }

}

