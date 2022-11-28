class FizzBuzzer(private val printer: Printer) {
    fun calculate(number: Int) {
        if (number % 3 == 0) printer.printLine("Fizz")
        printer.printLine(number.toString())
    }
}
