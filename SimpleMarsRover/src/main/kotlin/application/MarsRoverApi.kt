package application

import domain.ports.io.Console
import domain.ports.parsers.CommandParser
import domain.services.MarsRoverService

class MarsRoverApi(
    private val marsRoverService: MarsRoverService,
    private val parser: CommandParser,
    private val console: Console
) {
    fun execute(inputCommands: String) {
        val commandsToExecute = parser.parse(inputCommands)
        val roverAfterAllCommands = marsRoverService.moveRover(commandsToExecute)
        console.print(roverAfterAllCommands.toString())
    }
}
