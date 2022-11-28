class FizzBuzzer(private val printer: Printer) {
    fun calculate(number: Int) {
        when {
            number.isDivisibleBy(15) -> printer.printLine("FizzBuzz")
            number.isDivisibleBy(5) -> printer.printLine("Buzz")
            number.isDivisibleBy(3) -> printer.printLine("Fizz")
            else -> printer.printLine(number.toString())
        }
    }
}

fun Int.isDivisibleBy(value: Int): Boolean = this % value == 0

