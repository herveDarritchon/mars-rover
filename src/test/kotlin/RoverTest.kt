package com.orange.kata

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RoverTest {

    private lateinit var aNewRover: Rover

    @BeforeAll
    fun beforeAllTestCases() {
        println("Runs once before all test cases.")
        aNewRover = Rover(0, 0, Orientation.North)
    }

    @Test
    fun `a new Rover should be at its inital position when landing`() {

        Assertions.assertThat(aNewRover.x).isEqualTo(0)
        Assertions.assertThat(aNewRover.y).isEqualTo(0)
        Assertions.assertThat(aNewRover.orientation).isEqualTo(Orientation.North)
        // ↑
        // is equivalent to
        // ↓
        Assertions.assertThat(aNewRover).isEqualTo(Rover(0, 0, Orientation.North))
    }

    @Test
    fun `a new Rover that don't move should be at (0,0)`() {
        aNewRover.move("")
        Assertions.assertThat(aNewRover).isEqualTo(Rover(0, 0, Orientation.North))
    }

    @Test
    fun `a new Rover heading 'N' going forward finished at (0,1)`() {
        val movingRover = aNewRover.move("f")
        Assertions.assertThat(movingRover).isEqualTo(Rover(0, 1, Orientation.North))
    }

    @Test
    fun `a new Rover heading 'N' going backward finished at (0,-1)`() {
        val movingRover = aNewRover.move("b")
        Assertions.assertThat(movingRover).isEqualTo(Rover(0, -1, Orientation.North))
    }

    @Test
    fun `a new Rover heading 'N' turning left finished at (0,0) with orientation 'W'`() {
        val turningRover = aNewRover.move("l")
        Assertions.assertThat(turningRover).isEqualTo(Rover(0, 0, Orientation.West))
    }

    @Test
    fun `a new Rover heading 'N' turning right finished at (0,0) with orientation 'E'`() {
        val turningRover = aNewRover.move("r")
        Assertions.assertThat(turningRover).isEqualTo(Rover(0, 0, Orientation.East))
    }

    @Test
    fun `a new Rover heading 'N' going forward twice finished at (0,2)`() {
        val movingRover = aNewRover.move("ff")
        Assertions.assertThat(movingRover).isEqualTo(Rover(0, 2, Orientation.North))
    }

    @Test
    fun `a new Rover heading 'N' going backward twice finished at (0,-2)`() {
        val movingRover = aNewRover.move("bb")
        Assertions.assertThat(movingRover).isEqualTo(Rover(0, -2, Orientation.North))
    }

    @Test
    fun `a new Rover heading 'N' turning right thice finished at (0,0) with orientation 'W'`() {
        val turningRover = aNewRover.move("rrr")
        Assertions.assertThat(turningRover).isEqualTo(Rover(0, 0, Orientation.West))
    }

    @Test
    fun `a new Rover heading 'N' turning left thrice finished at (0,0) with orientation 'E'`() {
        val turningRover = aNewRover.move("lll")
        Assertions.assertThat(turningRover).isEqualTo(Rover(0, 0, Orientation.East))
    }
}