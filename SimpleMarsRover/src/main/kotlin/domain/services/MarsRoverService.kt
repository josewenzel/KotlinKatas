package domain.services

import domain.models.Direction
import domain.models.MoveCommand
import domain.models.Rover

class MarsRoverService {
    private val defaultRover = Rover(
        x = 0,
        y = 0,
        direction = Direction.North
    )

    fun moveRover(commands: List<MoveCommand>, rover: Rover = defaultRover): Rover =
        commands.fold(rover) { current, commandToExecute ->
            when (commandToExecute) {
                MoveCommand.Right -> current.turnRight()
                MoveCommand.Left -> current.turnLeft()
                MoveCommand.Move -> current.move()
            }
        }
}
