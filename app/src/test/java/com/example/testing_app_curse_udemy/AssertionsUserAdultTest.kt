package com.example.testing_app_curse_udemy

import com.google.common.truth.Truth.assertThat
import org.junit.After

import org.junit.Before
import org.junit.Rule

import org.junit.Test

class  AssertionsUserAdultTest {
    private lateinit var bot : User
    private lateinit var juan : User

    @get:Rule
    val locationESRule = LocationESRule()

    @Before
    fun setUp(){
        bot = User("6XSD",2,false)
        juan = User("juan",18,true)
        println("Before")
    }

    @After
    fun tearDown(){
        bot= User()
        juan = User()
        println("After")
    }


    @Test
    fun isAdult() {
        /*val assertions = Assertions()
        assertThat(assertions.isAdult(bot)).isTrue()
        assertThat(assertions.isAdult(juan)).isTrue()*/
        assertThat(locationESRule.assertion?.isAdult(juan)).isTrue()
        assertThat(locationESRule.assertion?.isAdult(bot)).isTrue()
    }
}