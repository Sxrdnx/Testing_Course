package com.cursosandroidant.auth

class AuthException(val authEvent: AuthEvents,  msg: String? = null): Exception(msg)