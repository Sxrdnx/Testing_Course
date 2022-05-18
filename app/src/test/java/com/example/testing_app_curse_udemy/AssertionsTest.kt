package com.example.testing_app_curse_udemy


import org.junit.Test
import com.google.common.truth.Truth.assertThat
import com.google.common.truth.Truth.assertWithMessage

class AssertionsTest{
    @Test
    fun getCorrectLuckyNumbers(){
        val assertions = Assertions()
        val valueExpected = arrayOf(1,17)
       //assertThat(valueExpected).isEqualTo(assertions.getLuckyNumbers())
        assertWithMessage("custom message in assert").that(valueExpected).isEqualTo(assertions.getLuckyNumbers())

    }

}