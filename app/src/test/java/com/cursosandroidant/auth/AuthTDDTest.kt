package com.cursosandroidant.auth

import com.cursosandroidant.auth.AuthEvents.*
import com.google.common.truth.Truth.assertThat
import org.junit.Assert.assertThrows
import org.junit.Test
import java.lang.NullPointerException

class AuthTDDTest {


    @Test
    fun login_completeFrom_existUser_returnsSuccessEvent(){
        val isAuthenticated = userAuthenticationTDD("ant@gmail.com","1234")
        assertThat(isAuthenticated).isEqualTo(USER_EXIST)
    }

    @Test
    fun login_completeForm_notExistUser_returnsFailEvent(){
        val isAuthenticated = userAuthenticationTDD("ola@gmail.com","1234")
        assertThat(isAuthenticated).isEqualTo(NOT_USER_EXIST)
    }

    @Test
    fun login_emptyEmail_returnsFailEvent(){
        val isAuthenticated = userAuthenticationTDD("","1234")
        assertThat(isAuthenticated).isEqualTo(EMPTY_EMAIL)
    }

    @Test
    fun login_emptyPassword_returnsFailEvent(){
        val isAuthenticated = userAuthenticationTDD("ant@gmail.com" ,"")
        assertThat(isAuthenticated).isEqualTo(EMPTY_PASSWORD)
    }

    @Test
    fun login_emptyForm_returnsFailEvent(){
        val isAuthenticated = userAuthenticationTDD("" ,"")
        assertThat(isAuthenticated).isEqualTo(EMPTY_FORM)
    }

    @Test
    fun login_completeForm_invalidEmail_returnsFailEvent(){
        val isAuthenticated = userAuthenticationTDD("ant@gmailcom" ,"1234")
        assertThat(isAuthenticated).isEqualTo(INVALID_EMAIL)
    }

    @Test
    fun login_completeForm_invalidPassword_returnsFailEvent(){
        val isAuthenticated = userAuthenticationTDD("ant@gmail.com" ,"123W")
        assertThat(isAuthenticated).isEqualTo(INVALID_PASSWORD)

    }

    @Test
    fun login_completeForm_invalidUser_returnsFailEvent(){
        val isAuthenticated = userAuthenticationTDD("ant@gmailcom" ,"123W")
        assertThat(isAuthenticated).isEqualTo(INVALID_USER)
    }

    @Test(expected = AuthException::class)
    fun login_nullEmail_returnsException(){
        val isAuthenticated = userAuthenticationTDD(null ,"123W")
        assertThat(isAuthenticated).isEqualTo(NULL_EMAIL)
    }

    @Test
    fun login_nullPassword_returnsException(){
        assertThrows(AuthException::class.java){
            println(userAuthenticationTDD( "ant@gmailcom",null))
        }
    }

    @Test
    fun login_nullForm_returnsException(){
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
    fun login_completeForm_errorLengthPassword_returnsFailEvent(){
        val result = userAuthenticationTDD("ant@gmail.com" ,"12345")
        assertThat(result).isEqualTo(LENGTH_PASSWORD_INVALID)
    }
}