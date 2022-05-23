package com.example.testing_app_curse_udemy

import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class LocationESRule: TestRule {
    var assertion : Assertions? = null
    override fun apply(base: Statement, description: Description): Statement {
        return object :Statement(){
            override fun evaluate() {
                //configuracion de la regla para nuestro test
                assertion = Assertions()
                assertion?.setLocation("ES")
                try {
                    base.evaluate()
                }finally {
                    assertion = null
                }
            }
        }
    }
}