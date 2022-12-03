import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class ToRomanTest {
    private val cases = listOf(
        1 to "I",
        2 to "II",
        3 to "III",
        4 to "IV",
        5 to "V",
        6 to "VI",
        7 to "VII",
        8 to "VIII",
        9 to "IX",
        10 to "X",
        11 to "XI",
        12 to "XII",
        13 to "XIII",
        14 to "XIV",
        15 to "XV",
        40 to "XL",
        50 to "L",
        90 to "XC",
        100 to "C",
        400 to "CD",
        500 to "D",
        900 to "CM",
        1000 to "M"
    )

    @TestFactory
    fun `that toRoman returns`() =
        cases.map { (arabic, romanConversion) ->
            dynamicTest("$romanConversion for $arabic") {
                expectThat(arabic.toRoman()).isEqualTo(romanConversion)
            }
        }

    @TestFactory
    fun `that toRomanRecursive returns`() =
        cases.map { (arabic, romanConversion) ->
            dynamicTest("$romanConversion for $arabic") {
                expectThat(arabic.toRoman2()).isEqualTo(romanConversion)
            }
        }
}
