package com.cursosandroidant.calculator

/****
 * Project: Calculator
 * From: com.cursosandroidant.clcaulator
 * Created by Alain Nicolás Tello on 14/12/21 at 20:03
 * All rights reserved 2021.
 *
 * All my Udemy Courses:
 * https://www.udemy.com/user/alain-nicolas-tello/
 * Web: www.alainnicolastello.com
 ***/
class CalculatorUtils(private val operations: Operations, private val listener: OnResolveListener) {
    fun checkOrResolve(operation: String, isFromResolve: Boolean){
        operations.tryResolve(operation, isFromResolve, listener)
    }

    fun addOperator(operator: String, operation: String, callback:()->Unit) {
        val lastElement = if (operation.isEmpty()) ""
        else operation.substring(operation.length - 1)

        if (operator == Constants.OPERATOR_SUB){
               if (operation.isEmpty() || lastElement != Constants.OPERATOR_SUB && lastElement != Constants.POINT){
                callback()
            }
        } else {
            if (operation.isNotEmpty() && lastElement != Constants.POINT){
                callback()
            }
        }
    }

    fun addPoint(operation: String, callback: () -> Unit) {
        if (!operation.contains(Constants.POINT)){
            callback()
        } else {
            val operator = operations.getOperator(operation)
            val values = operations.divideOperation(operator, operation)

            if (values.isNotEmpty()){
                val numberOne = values[0]!!
                if (values.size > 1){
                    val numberTwo = values[1]!!
                    if (numberOne.contains(Constants.POINT) && !numberTwo.contains(Constants.POINT)){
                        callback()
                    }
                } else {
                    if (numberOne.contains(Constants.POINT)){
                        callback()
                    }
                }
            }
        }
    }
}