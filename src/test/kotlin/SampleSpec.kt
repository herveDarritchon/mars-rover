import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.junit.jupiter.api.Assertions

object SampleSpec : Spek({
    given("a sample test") {
        val sample = Sample()
        on("first step") {
            val step = sample.aMethod("step1")
            it("should return step1 for aMethod call with param 'step1'.") {
                Assertions.assertEquals("step1", step)
            }
        }
        on("second step") {
            val step = sample.aMethod("step2")
            it("should return step2 for aMethod call with param 'step2'.") {
                Assertions.assertEquals("step2", step)
            }
        }
    }
})