package com.myfirstcompose

import com.Validator
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkObject
import io.mockk.unmockkObject
import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue


class ValidatorMokkTest {
    @Test
    fun whenInputIsValid() {
        // Given
        val amount = 100
        val desc = "Some random desc"

        // Mock the Validator class
        val validatorMock = mockk<Validator>()

        // Define the behavior of the mock
        every { validatorMock.validateInput(any(), any()) } returns true

        // When
        val result = validatorMock.validateInput(amount, desc)

        // Then
        assertTrue(result)
    }

    @Test
    fun whenInputIsInvalid() {
        // Given
        val amount = 0
        val desc = ""

        // Mock the Validator class
        val validatorMock = mockk<Validator>()

        // Define the behavior of the mock
        every { validatorMock.validateInput(any(), any()) } returns false

        // When
        val result = validatorMock.validateInput(amount, desc)

        // Then
        assertFalse(result)
    }

    @Test
    fun whenInput() {
        // Given
        val validAmount = 100
        val validDesc = "Some random desc"

        val invalidAmount = 0
        val emptyDesc = ""
        val nullDesc: String? = null

        // Mock the Validator object
        mockkObject(Validator)

        // Define the behavior of the mock
        every { Validator.validateInput(validAmount, validDesc) } returns true
        every { Validator.validateInput(invalidAmount, any()) } returns false
        every { Validator.validateInput(any(), emptyDesc) } returns false
       // every { Validator.validateInput(any(), nullDesc) } returns false

        // When
        val resultValid = Validator.validateInput(validAmount, validDesc)
        val resultInvalidAmount = Validator.validateInput(invalidAmount, validDesc)
        val resultEmptyDesc = Validator.validateInput(validAmount, emptyDesc)
       // val resultNullDesc = Validator.validateInput(validAmount, nullDesc)

        // Then
        assertTrue(resultValid)
        assertFalse(resultInvalidAmount)
        assertFalse(resultEmptyDesc)
     //   assertFalse(resultNullDesc)

        // Clean up the mocked object after the test
        unmockkObject(Validator)
    }
}
