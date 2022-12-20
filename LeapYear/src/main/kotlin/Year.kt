typealias Year = Int

fun Year.isLeap() : Boolean {
    return this % 4 == 0 && this % 100 != 0 || this % 400 == 0
}