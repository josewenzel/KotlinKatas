package domain.models

enum class Direction {
    North,
    East,
    South,
    West;

    fun right(): Direction {
        return when (this) {
            North -> East
            East -> South
            South -> West
            West -> North
        }
    }

    fun left(): Direction {
        return when (this) {
            North -> West
            West -> South
            South -> East
            East -> North
        }
    }
}
