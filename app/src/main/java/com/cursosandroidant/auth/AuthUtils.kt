package com.cursosandroidant.auth

import com.cursosandroidant.auth.AuthEvents.*



fun userAuthentication(email: String?, password: String?): Boolean {
    if (email == "ant@gmail.com" && password == "1234"){
        return true
    }
    return false
}


fun userAuthenticationTDD(email: String?, password: String?): AuthEvents {
    if (email == null && password == null) throw AuthException(NULL_FORM)

    if (email == null ) throw AuthException(NULL_EMAIL)

    if (password == null) throw AuthException(NULL_PASSWORD)

    if (email.isEmpty() && password.isEmpty()) return EMPTY_FORM

    if (email.isEmpty()) return EMPTY_EMAIL

    if (password.isEmpty()) return  EMPTY_PASSWORD

    if (!isValidPasswordLength(password))
       return LENGTH_PASSWORD_INVALID
    else{
        val passwordNumeric = password.toIntOrNull()

        return if(!isEmailValid(email)  && passwordNumeric ==null )
            return INVALID_USER

        else if (!isEmailValid(email))
            INVALID_EMAIL

        else if ( passwordNumeric ==null )
            INVALID_PASSWORD
        else{
            if (email == "ant@gmail.com" && password == "1234"){
                USER_EXIST
            }else
                return NOT_USER_EXIST
        }
    }
}

fun isEmailValid(email: String): Boolean {
    val EMAIL_REGEX = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"
    return EMAIL_REGEX.toRegex().matches(email);
}

fun isValidPasswordLength(password: String): Boolean{
    return password.length == 4
}