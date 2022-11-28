import io.mockk.*
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.extension.ExtendWith
import kotlin.test.Test

@ExtendWith(MockKExtension::class)
class FizzBuzzerShould {
    private val printer = spyk<Printer>();
    private val fizzBuzzer = FizzBuzzer(printer);

    @Test
    fun `print out 1 if input is 1`() {
        fizzBuzzer.calculate(1);

        verify { printer.printLine("1") }
    }
}