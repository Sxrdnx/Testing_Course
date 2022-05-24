package com.example.testing_app_curse_udemy

import com.google.common.truth.Truth.assertThat
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized


@RunWith(value = Parameterized::class)
class ParameterizedTest(var currentValue:Boolean,var currentUser: User) {

    @get:Rule
    val locationESRule = LocationESRule()

    companion object{
        @Parameterized.Parameters @JvmStatic
        fun getUsers()= arrayOf(
            arrayOf(false,User("Pedro",12)),
            arrayOf(true,User("roberto",34)),
            arrayOf(true,User("bot",2,false)),
            arrayOf(true,User("ana",45))
        )
    }

    @Test
    fun isAdult() {
      //  assertThat(locationESRule.assertion?.isAdult(currentUser)).isTrue()
        assertThat(currentValue).isEqualTo(locationESRule.assertion?.isAdult(currentUser))
    }
}