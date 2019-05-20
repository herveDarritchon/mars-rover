package com.orange.kata

import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

class SampleTest {

    companion object {
        @BeforeAll
        @JvmStatic
        fun beforeAllTestCases() {
            println("Runs once before all test cases.")
        }

        @AfterAll
        @JvmStatic
        fun afterAllTestCases() {
            println("Runs once after all test cases.")
        }
    }

    @Test
    fun simpleTestCase() {
        println("A simple test case.")

        val numberTwo = 2

        // Junit native assertion
        assertEquals(2, numberTwo)
    }

    @Test
    fun `a method should return its parameter value`() {
        val s = Sample().aMethod("a")

        // jAssert assertion example
        org.assertj.core.api.Assertions.assertThat(s).isEqualTo("a")
    }
}
