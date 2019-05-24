package com.orange.kata

data class Rover(val x: Int, val y: Int, val orientation: Orientation) {

    // TODO renommer la fonction sous forme de verbe
    fun moves(moveOrder: String): Rover {
        val commands = moveOrder.toList()
        if (commands.isNotEmpty()) {
            // TODO refactorer de manière de manière explicite la différence entre la recursion et la première commande
            return this.handleCommand(moveOrder[0]).moves(moveOrder.drop(1))
        }
        return Rover(x, y, orientation)
    }

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