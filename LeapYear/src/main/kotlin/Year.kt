typealias Year = Int

fun Int.isDivisibleBy(divisor: Int) = this % divisor == 0

fun Year.isLeap(): Boolean {
    return this.isDivisibleBy(4) &&
        !this.isDivisibleBy(100) ||
        this.isDivisibleBy(400)
}
