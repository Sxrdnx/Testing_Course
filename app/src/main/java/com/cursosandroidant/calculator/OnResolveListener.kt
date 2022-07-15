package com.cursosandroidant.calculator

/****
 * Project: Calculator
 * From: com.cursosandroidant.calculator
 * Created by Alain Nicolás Tello on 14/12/21 at 20:04
 * All rights reserved 2021.
 *
 * All my Udemy Courses:
 * https://www.udemy.com/user/alain-nicolas-tello/
 * Web: www.alainnicolastello.com
 ***/
interface OnResolveListener {
    fun onShowResult(result: Double, isFromResolve: Boolean)
    fun onShowMessage(errorRes: Int)
}
