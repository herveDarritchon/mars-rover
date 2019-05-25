package com.orange.kata

data class Rover(val x: Int, val y: Int, val orientation: Orientation) {

    fun move(moveOrder: String): Rover {
        val commands = moveOrder.toList()
        if (commands.isNotEmpty()) {
            return this
                    .handleCommand(firstCommand(moveOrder))
                    .move(remainingCommands(moveOrder))
        }
        return Rover(x, y, orientation)
    }

    private fun remainingCommands(moveOrder: String) = moveOrder.drop(1)

    private fun firstCommand(moveOrder: String) = moveOrder[0]

    private fun handleCommand(command: Char): Rover {
        return when (command) {
            'f' -> Rover(x, y + 1, orientation)
            'b' -> Rover(x, y - 1, orientation)
            'l' -> Rover(x, y, Orientation.from(orientation.left))
            'r' -> Rover(x, y, Orientation.from(orientation.right))
            else -> Rover(x, y, orientation)
        }
    }

}

enum class Orientation(val value: Char, val left: Char, val right: Char) {
    North('N', 'W', 'E'),
    West('W', 'S', 'N'),
    South('S', 'E', 'W'),
    East('E', 'N', 'S');

    companion object {
        private val map = values().associateBy(Orientation::value)

        fun from(char: Char): Orientation {
            return map[char]
                    ?: throw Exception("Orientation is not allowed $char")
        }
    }
}