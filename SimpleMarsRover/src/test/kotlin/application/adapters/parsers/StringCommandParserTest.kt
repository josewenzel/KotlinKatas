package application.adapters.parsers

import domain.models.MoveCommand
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.api.expectThrows
import strikt.assertions.containsExactly

class StringCommandParserTest {
    private val parser = StringCommandParser()

    @Test
    fun `returns move command for M`() {
        val parsedCommands = parser.parse("M")

        expectThat(parsedCommands).containsExactly(MoveCommand.Move)
    }

    @Test
    fun `returns right command for R`() {
        val parsedCommands = parser.parse("R")

        expectThat(parsedCommands).containsExactly(MoveCommand.Right)
    }

    @Test
    fun `returns left command for L`() {
        val parsedCommands = parser.parse("L")

        expectThat(parsedCommands).containsExactly(MoveCommand.Left)
    }

    @Test
    fun `returns a list of commands for MRL`() {
        val parsedCommands = parser.parse("MRL")

        expectThat(parsedCommands).containsExactly(MoveCommand.Move, MoveCommand.Right, MoveCommand.Left)
    }

    @Test
    fun `throws for an unknown character`() {
        expectThrows<Error> { parser.parse("A") }
    }
}
