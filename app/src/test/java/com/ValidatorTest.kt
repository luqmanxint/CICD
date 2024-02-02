package com

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ValidatorTest {

    @Test
    fun whenInputIsValid() {
        val amount = 100
        val desc="Some random desc"
        val result=Validator.validateInput(amount,desc)
        assertEquals(true, result)
    }
    @Test
    fun whenInputIsInvalid() {
        val amount = 0
        val desc=""
        val result=Validator.validateInput(amount,desc)
        assertEquals(false, result)
    }
}