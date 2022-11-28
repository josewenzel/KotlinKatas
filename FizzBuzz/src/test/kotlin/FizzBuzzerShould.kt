import io.mockk.junit5.MockKExtension
import io.mockk.spyk
import io.mockk.verify
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class FizzBuzzerShould {
    private val printer = spyk<Printer>()
    private val fizzBuzzer = FizzBuzzer(printer)

    private val nonSpecialCases = listOf(
        1 to "1",
        2 to "2",
        4 to "4"
    )

    @TestFactory
    fun `print out a number if input does not fall under specific rule`() =
        nonSpecialCases.map { (input, expectedInPrinter) ->
            dynamicTest("$input should print $expectedInPrinter") {
                fizzBuzzer.calculate(input)
                verify { printer.printLine(expectedInPrinter) }
            }
        }

}