class FizzBuzzer(private val printer: Printer) {
    fun calculate(number: Int) {
        printer.printLine(number.toString())
    }
}
