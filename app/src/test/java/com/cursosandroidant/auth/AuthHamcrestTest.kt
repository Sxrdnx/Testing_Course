package com.cursosandroidant.auth

import android.app.appsearch.AppSearchSession
import com.cursosandroidant.auth.AuthEvents.*
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*

import org.junit.Assert.assertThrows
import org.junit.Test
import java.lang.NullPointerException

class AuthHamcrestTest {
   //given-when-then -> regla para nombrar tests
    @Test
    fun loginUser_correctData_returnsSuccessEvent(){
        val result = userAuthenticationTDD("ant@gmail.com","1234")
        assertThat(USER_EXIST, `is` (result))
    }

    @Test
    fun loginUser_wrongData_returnsFailEvent(){
        val isAuthenticated = userAuthenticationTDD("ola@gmail.com","1234")
        assertThat(NOT_USER_EXIST, `is` (isAuthenticated) )
    }

    @Test
    fun loginUser_emptyEmail_returnsFailEvent(){
        val isAuthenticated = userAuthenticationTDD("","1234")
        assertThat(EMPTY_EMAIL,`is` (isAuthenticated))
    }

    @Test
    fun loginUser_emptyPassword_returnsFailEvent(){
        val isAuthenticated = userAuthenticationTDD("ant@gmail.com" ,"")
        assertThat(isAuthenticated, `is` (EMPTY_PASSWORD))
    }

    @Test
    fun loginUser_emptyForm_returnsFailEvent(){
        val isAuthenticated = userAuthenticationTDD("" ,"")
        assertThat(isAuthenticated, `is`(EMPTY_FORM))
    }

    @Test
    fun loginUser_invalidEmail_returnsFailEvent(){
        val isAuthenticated = userAuthenticationTDD("ant@gmailcom" ,"1234")
        assertThat(isAuthenticated, `is`(INVALID_EMAIL))
    }

   @Test
   fun checkNames_differentUsers_match(){
       assertThat("Maria", both(containsString("a")).and(containsString("i")))
   }
    @Test
    fun checkData_emailPassword_noMatch(){
        val email = "ant@gmail.com"
        val pass = "123"
        assertThat(email, not(`is`(pass)))
    }

    @Test
    fun checkExist_newEmail_returnsString(){
        val oldEmail = "ant@gmail.com"
        val newEmail = "new@gmail.com"
        val emails = arrayOf(oldEmail,newEmail)
        assertThat(emails, hasItemInArray(newEmail))
    }

    @Test
    fun checkDomain_arrayEmails_returnsString(){
        val oldEmail = "ant@gmail.com"
        val newEmail = "new@gmail.com"
        val nextEmail ="email@yahoo.com"
        val emails = arrayListOf(oldEmail,newEmail)
        val newEmails = arrayListOf(oldEmail,newEmail,nextEmail)
        assertThat(emails, everyItem(endsWith("gmail.com")))
    }
  /*
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
    }*/
}