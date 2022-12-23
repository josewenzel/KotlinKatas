package domain.ports.parsers

import domain.models.MoveCommand

interface CommandParser {
    fun parse(command: String): List<MoveCommand>
}
