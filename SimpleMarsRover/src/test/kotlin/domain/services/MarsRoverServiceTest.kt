package domain.services

import domain.models.Direction
import domain.models.MoveCommand
import domain.models.Rover
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class MarsRoverServiceTest {
    private val marsRoverService = MarsRoverService()

    @TestFactory
    fun turnRight() =
        listOf(
            1 to Direction.East,
            2 to Direction.South,
            3 to Direction.West,
            4 to Direction.North
        ).map { (times, expectedDirection) ->
            dynamicTest("$times times makes rover face ${expectedDirection.name}") {
                val commands = List(times) { _ -> MoveCommand.Right }

                val finalPosition = marsRoverService.moveRover(commands)
                expectThat(finalPosition).isEqualTo(Rover(0, 0, expectedDirection))
            }
        }

    @TestFactory
    fun turnLeft() =
        listOf(
            1 to Direction.West,
            2 to Direction.South,
            3 to Direction.East,
            4 to Direction.North
        ).map { (times, expectedDirection) ->
            dynamicTest("$times times makes rover face ${expectedDirection.name}") {
                val commands = List(times) { _ -> MoveCommand.Left }

                val finalPosition = marsRoverService.moveRover(commands)
                expectThat(finalPosition).isEqualTo(Rover(0, 0, expectedDirection))
            }
        }

    @TestFactory
    fun moveNorth() =
        listOf(
            1 to 1,
            2 to 2,
            3 to 3,
            4 to 4
        ).map { (times, expectedY) ->
            dynamicTest("$times times makes rover y position $expectedY") {
                val initialRover = Rover(0, 0, Direction.North)
                val commands = List(times) { _ -> MoveCommand.Move }

                val finalPosition = marsRoverService.moveRover(commands, initialRover)
                expectThat(finalPosition).isEqualTo(Rover(0, expectedY, Direction.North))
            }
        }

    @TestFactory
    fun moveEast() =
        listOf(
            1 to 1,
            2 to 2,
            3 to 3,
            4 to 4
        ).map { (times, expectedX) ->
            dynamicTest("$times times makes rover x position $expectedX") {
                val initialRover = Rover(0, 0, Direction.East)
                val commands = List(times) { _ -> MoveCommand.Move }

                val finalPosition = marsRoverService.moveRover(commands, initialRover)
                expectThat(finalPosition).isEqualTo(Rover(expectedX, 0, Direction.East))
            }
        }

    @TestFactory
    fun moveSouth() =
        listOf(
            1 to 4,
            2 to 3,
            3 to 2,
            4 to 1
        ).map { (times, expectedY) ->
            dynamicTest("$times times makes rover y position $expectedY") {
                val initialRover = Rover(0, 5, Direction.South)
                val commands = List(times) { _ -> MoveCommand.Move }

                val finalPosition = marsRoverService.moveRover(commands, initialRover)
                expectThat(finalPosition).isEqualTo(Rover(0, expectedY, Direction.South))
            }
        }

    @TestFactory
    fun moveWest() =
        listOf(
            1 to 4,
            2 to 3,
            3 to 2,
            4 to 1
        ).map { (times, expectedX) ->
            dynamicTest("$times times makes rover x position $expectedX") {
                val initialRover = Rover(5, 0, Direction.West)
                val commands = List(times) { _ -> MoveCommand.Move }

                val finalPosition = marsRoverService.moveRover(commands, initialRover)
                expectThat(finalPosition).isEqualTo(Rover(expectedX, 0, Direction.West))
            }
        }

    @Test
    fun wrapsNorth() {
        val initialRover = Rover(0, 10, Direction.North)
        val commands = listOf(MoveCommand.Move)

        val finalPosition = marsRoverService.moveRover(commands, initialRover)
        expectThat(finalPosition).isEqualTo(Rover(0, 0, Direction.North))
    }

    @Test
    fun wrapsEast() {
        val initialRover = Rover(10, 0, Direction.East)
        val commands = listOf(MoveCommand.Move)

        val finalPosition = marsRoverService.moveRover(commands, initialRover)
        expectThat(finalPosition).isEqualTo(Rover(0, 0, Direction.East))
    }

    @Test
    fun wrapsSouth() {
        val initialRover = Rover(0, 0, Direction.South)
        val commands = listOf(MoveCommand.Move)

        val finalPosition = marsRoverService.moveRover(commands, initialRover)
        expectThat(finalPosition).isEqualTo(Rover(0, 0, Direction.South))
    }

    @Test
    fun wrapsWest() {
        val initialRover = Rover(0, 0, Direction.West)
        val commands = listOf(MoveCommand.Move)

        val finalPosition = marsRoverService.moveRover(commands, initialRover)
        expectThat(finalPosition).isEqualTo(Rover(10, 0, Direction.West))
    }
}
