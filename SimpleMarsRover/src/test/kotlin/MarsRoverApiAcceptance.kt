import application.MarsRoverApi
import application.adapters.parsers.StringCommandParser
import domain.ports.io.Console
import domain.services.MarsRoverService
import io.mockk.spyk
import io.mockk.verify
import org.junit.jupiter.api.Test
import strikt.api.expectThrows

class MarsRoverApiAcceptance {
    private val console = spyk<Console>()
    private val commandParser = StringCommandParser()
    private val marsRoverService = MarsRoverService()
    private val marsRoverApi = MarsRoverApi(marsRoverService, commandParser, console)

    @Test
    fun `move around a grid`() {
        marsRoverApi.execute("MRMMLM")
        verify { console.print("2:2:N") }
    }

    @Test
    fun `throw if there is a wrong character`() {
        expectThrows<Error> { marsRoverApi.execute("MRMMPLM") }
    }
}
