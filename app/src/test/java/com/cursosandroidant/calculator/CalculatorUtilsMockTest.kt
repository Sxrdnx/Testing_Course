package com.cursosandroidant.calculator

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CalculatorUtilsMockTest{
    @Mock
    lateinit var operations: Operations
    @Mock
    lateinit var listener: OnResolveListener

    lateinit var calculatorUtils: CalculatorUtils

    @Before
    fun setUp(){
        calculatorUtils = CalculatorUtils(operations,listener)
    }

    @Test
    fun call_checkOrResolve_noReturn(){
        val operation = "-5x2.5"
        val isFromResolve = true
        calculatorUtils.checkOrResolve(operation,isFromResolve)
        verify(operations).tryResolve(operation,isFromResolve,listener)
    }

    @Test
    fun call_addOperator_validSub_noReturn(){
        val operator = "-"
        val operation = "4+"
        var isCorrect = false
        calculatorUtils.addOperator(operator,operation){
            isCorrect = true
        }
        assertThat(isCorrect).isTrue()
    }

    @Test
    fun call_addOperator_invalidSub_noReturn(){
        val operator = "-"
        val operation = "4-"
        var isCorrect = false
        calculatorUtils.addOperator(operator,operation){
            isCorrect = true
        }
        assertThat(isCorrect).isFalse()
    }

    @Test
    fun call_addPoint_firstPoint_noReturn(){
        val operation="2-"
        var isCorrect = false
        calculatorUtils.addPoint(operation){
             isCorrect = true
        }
        assertThat(isCorrect).isTrue()
        verifyNoInteractions(operations)//verifica que este objeto no sea llamada , o sea usado ya que eso indica otros escenarios
    }

    @Test
    fun call_addPoint_secondPoint_noReturn(){
        val operation="2.1-"
        val operator = "-"
        var isCorrect = false

        `when`(operations.getOperator(operation)).thenReturn("-")//retorna un valor de un metodo llamado ,esto cuando usamos moks
        `when`(operations.divideOperation(operator,operation)).thenReturn(arrayOf("2.1"))

        calculatorUtils.addPoint(operation){
            isCorrect = true
        }
        assertThat(isCorrect).isTrue()
    }


}