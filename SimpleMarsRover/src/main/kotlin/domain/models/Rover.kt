package domain.models

data class Rover(val x: Int, val y: Int, val direction: Direction) {
    fun turnRight(): Rover = Rover(x, y, direction.right())

    fun turnLeft(): Rover = Rover(x, y, direction.left())

    fun move(): Rover = when (direction) {
        Direction.North -> moveNorth()
        Direction.East -> moveEast()
        Direction.South -> moveSouth()
        Direction.West -> moveWest()
    }

    private fun moveSouth() = when (y) {
        0 -> Rover(x, 0, direction)
        else -> Rover(x, y - 1, direction)
    }

    private fun moveNorth() = when (y) {
        10 -> Rover(x, 0, direction)
        else -> Rover(x, y + 1, direction)
    }

    private fun moveWest(): Rover = when (x) {
        0 -> Rover(10, y, direction)
        else -> Rover(x - 1, y, direction)
    }

    private fun moveEast(): Rover = when (x) {
        10 -> Rover(0, y, direction)
        else -> Rover(x + 1, y, direction)
    }

    override fun toString(): String = "$x:$y:${direction.name.first()}"
}
