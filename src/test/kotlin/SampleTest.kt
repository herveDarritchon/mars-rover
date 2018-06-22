import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

/**
 * Created by Hervé Darritchon on 18/06/2018.
 */
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
        assertEquals(2, numberTwo)
    }
}

object CalculatorSpec : Spek({
    given("a sample test") {
        val sample = Sample()
        on("first step") {
            val step = sample.aMethod("step1")
            it("should return step1 for aMethod call with param 'step1'.") {
                assertEquals("step1", step)
            }
        }
        on("second step") {
            val step = sample.aMethod("step2")
            it("should return step2 for aMethod call with param 'step2'.") {
                assertEquals("step2", step)
            }
        }
    }
})
