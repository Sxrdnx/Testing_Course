package com.cursosandroidant.auth

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class AuthTest {
    @Test
    fun login_complete_return_true() {
        val isAuthenticated = userAuthentication("ant@gmail.com","1234")
        assertThat(isAuthenticated).isTrue()
    }

    @Test
    fun login_complete_return_false() {
        val isAuthenticated = userAuthentication("olat@gmail.com","1234")
        assertThat(isAuthenticated).isFalse()
    }
    @Test
    fun login_emptyEmail_return_false() {
        val isAuthenticated = userAuthentication("","1234")
        assertThat(isAuthenticated).isFalse()
    }


    @Test
    fun login_nullEmail_return_false() {
        val isAuthenticated = userAuthentication(null,"1234")
        assertThat(isAuthenticated).isFalse()
    }

    @Test
    fun login_nullPassword_return_false(){
        val isAuthenticated = userAuthentication("ant@gmail.com",null)
        assertThat(isAuthenticated).isFalse()
    }
}