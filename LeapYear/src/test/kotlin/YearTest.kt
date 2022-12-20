import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class YearTest {
    private val years = listOf(
        1997 to false,
        1996 to true,
        1600 to true,
        1800 to false
    )

    @TestFactory
    fun isLeap() =
        years.map { (year, leapOutput) ->
            dynamicTest("$year is $leapOutput") {
                expectThat(year.isLeap()).isEqualTo(leapOutput)
            }
        }
}
