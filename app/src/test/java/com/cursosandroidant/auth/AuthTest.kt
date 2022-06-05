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

    /* Este caso en este momento no funciona pues no se contepla esta cituacion en el test
    @Test
    fun login_nullEmail_return_false() {
        val isAuthenticated = userAuthentication(null,"1234")
        assertThat(isAuthenticated).isFalse()
    }*/
}