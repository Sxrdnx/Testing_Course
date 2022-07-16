package com.cursosandroidant.calculator

import com.google.common.truth.Truth
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.Spy
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CalculatorUtilsSpyTest {
    /**
     * la anotacion nos permite tener el objeto parcialmente simulado a diferencia de un mock que no obtiene ninguna logica de negocio de la clase solo es un mock
     */
    @Spy
    lateinit var operations: Operations
    @Mock
    lateinit var listener: OnResolveListener

    lateinit var calculatorUtils: CalculatorUtils

    @Before
    fun setUp(){
        calculatorUtils = CalculatorUtils(operations,listener)
    }


    @Test
    fun call_addPoint_invalidPoint_noReturn(){
        val operation="2.1-."
        var isCorrect = false
        calculatorUtils.addPoint(operation){
            isCorrect = true
        }
        Truth.assertThat(isCorrect).isFalse()
        verify(operations).getOperator(operation)
    }

    @Test
    fun call_addPoint_validSecondPoint_noReturn(){
        val operation="2.1-3"
        var isCorrect = false
        calculatorUtils.addPoint(operation){
            isCorrect = true
        }
        Truth.assertThat(isCorrect).isTrue()
        verify(operations).getOperator(operation)
    }

}