import io.mockk.junit5.MockKExtension
import io.mockk.spyk
import io.mockk.verify
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class FizzBuzzerTest {
    private val printer = spyk<Printer>()
    private val fizzBuzzer = FizzBuzzer(printer)

    private val nonSpecialCases = listOf(
        1 to "1",
        2 to "2",
        3 to "Fizz",
        4 to "4",
        5 to "Buzz",
        6 to "Fizz",
        7 to "7",
        8 to "8",
        9 to "Fizz",
        10 to "Buzz",
        11 to "11",
        12 to "Fizz",
        13 to "13",
        14 to "14",
        15 to "FizzBuzz"
    )

    @TestFactory
    fun `calculate returns`() =
        nonSpecialCases.map { (input, expectedInPrinter) ->
            dynamicTest("$expectedInPrinter if input is $input") {
                fizzBuzzer.calculate(input)
                verify { printer.printLine(expectedInPrinter) }
            }
        }
}