package com.cursosandroidant.auth

import com.cursosandroidant.auth.AuthEvents.*
import com.google.common.truth.Truth.assertThat
import org.junit.Assert.assertThrows
import org.junit.Test
import java.lang.NullPointerException

class AuthTDDTest {
   //given-when-then -> regla para nombrar tests
    @Test
    fun loginUser_correctData_returnsSuccessEvent(){
        val isAuthenticated = userAuthenticationTDD("ant@gmail.com","1234")
        assertThat(isAuthenticated).isEqualTo(USER_EXIST)
    }

    @Test
    fun loginUser_wrongData_returnsFailEvent(){
        val isAuthenticated = userAuthenticationTDD("ola@gmail.com","1234")
        assertThat(isAuthenticated).isEqualTo(NOT_USER_EXIST)
    }

    @Test
    fun loginUser_emptyEmail_returnsFailEvent(){
        val isAuthenticated = userAuthenticationTDD("","1234")
        assertThat(isAuthenticated).isEqualTo(EMPTY_EMAIL)
    }

    @Test
    fun loginUser_emptyPassword_returnsFailEvent(){
        val isAuthenticated = userAuthenticationTDD("ant@gmail.com" ,"")
        assertThat(isAuthenticated).isEqualTo(EMPTY_PASSWORD)
    }

    @Test
    fun loginUser_emptyForm_returnsFailEvent(){
        val isAuthenticated = userAuthenticationTDD("" ,"")
        assertThat(isAuthenticated).isEqualTo(EMPTY_FORM)
    }

    @Test
    fun loginUser_invalidEmail_returnsFailEvent(){
        val isAuthenticated = userAuthenticationTDD("ant@gmailcom" ,"1234")
        assertThat(isAuthenticated).isEqualTo(INVALID_EMAIL)
    }

    @Test
    fun loginUser_invalidPassword_returnsFailEvent(){
        val isAuthenticated = userAuthenticationTDD("ant@gmail.com" ,"123W")
        assertThat(isAuthenticated).isEqualTo(INVALID_PASSWORD)
    }

    @Test
    fun loginUser_invalidUser_returnsFailEvent(){
        val isAuthenticated = userAuthenticationTDD("ant@gmailcom" ,"123W")
        assertThat(isAuthenticated).isEqualTo(INVALID_USER)
    }

    @Test(expected = AuthException::class)
    fun loginUser_nullEmail_returnsAuthException(){
        val isAuthenticated = userAuthenticationTDD(null ,"123W")
        assertThat(isAuthenticated).isEqualTo(NULL_EMAIL)
    }

    @Test
    fun loginUSer_nullPassword_returnsAuthException(){
        assertThrows(AuthException::class.java){
            println(userAuthenticationTDD( "ant@gmailcom",null))
        }
    }

    @Test
    fun loginUser_nullData_returnsAuthException(){
        try {
            val result = userAuthenticationTDD(null ,null)
            assertThat(NULL_FORM).isEqualTo(result)
        }catch (e: Exception){
            (e as? AuthException)?.let {
                assertThat(NULL_FORM).isEqualTo(it.authEvent)
            }
        }
    }

    @Test
    fun loginUser_errorLengthPassword_returnsFailEvent(){
        val result = userAuthenticationTDD("ant@gmail.com" ,"12345")
        assertThat(result).isEqualTo(LENGTH_PASSWORD_INVALID)
    }
}