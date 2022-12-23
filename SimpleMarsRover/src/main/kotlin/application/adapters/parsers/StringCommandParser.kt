package application.adapters.parsers

import domain.models.MoveCommand
import domain.ports.parsers.CommandParser

class StringCommandParser : CommandParser {
    override fun parse(command: String): List<MoveCommand> = command.map {
        when (it) {
            'M' -> MoveCommand.Move
            'R' -> MoveCommand.Right
            'L' -> MoveCommand.Left
            else -> throw Error("Unknown command")
        }
    }
}
