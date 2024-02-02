package com.myfirstcompose

import com.Validator
import org.amshove.kluent.shouldBeEqualTo
import org.junit.Test
import org.amshove.kluent.shouldBeTrue

class ValidatorKluentTest {

    @Test
    fun whenInputIsValid() {
        // Given
        val amount = 100
        val desc = "Some random desc"

        // When
        val result = Validator.validateInput(amount, desc)

        // Then
        result.shouldBeTrue()
    }

    @Test
    fun whenInputIsValid_alternativeAssertion() {
        // Given
        val amount = 100
        val desc = "Some random desc"

        // When
        val result = Validator.validateInput(amount, desc)

        // Then
        result.shouldBeEqualTo<Boolean>(true)
    }
    @Test
    fun whenInputIsInvalid() {
        // Given
        val amount = 0
        val desc = ""

        // When
        val result = Validator.validateInput(amount, desc)

        // Then
        result.shouldBeEqualTo<Boolean>(false)
    }
}
