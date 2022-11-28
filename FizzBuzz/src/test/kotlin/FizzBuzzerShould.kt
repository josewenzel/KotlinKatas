import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.extension.ExtendWith
import kotlin.test.Test

@ExtendWith(MockKExtension::class)
class FizzBuzzerShould {
    @MockK
    lateinit var printer: Printer;

    @Test
    fun `print out 1 if input is 1`() {
        val fizzBuzzer = FizzBuzzer(printer);

        fizzBuzzer.calculate(1);

        verify { printer.print("1") }
    }
}