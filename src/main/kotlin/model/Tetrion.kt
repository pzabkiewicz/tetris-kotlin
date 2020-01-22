package model

import model.tetromino.Tetromino

class Tetrion {

    val board: List<MutableList<TetrionCellState>> = (1..(HEIGHT)).asIterable()
        .map {
            (1..WIDTH).asIterable().map { TetrionCellState.EMPTY }.toMutableList()
        }.toList()

    companion object {
        const val HEIGHT = 24
        const val WIDTH = 10
        const val TOP_MARGIN_HEIGHT = 4
    }

    fun updateBoard(fieldsForUpdate: List<Pair<Int, Int>>, value: TetrionCellState) {
        for (tetrominoBlock in fieldsForUpdate) {
            val row = board[tetrominoBlock.second + TOP_MARGIN_HEIGHT]
            row[tetrominoBlock.first] = value
        }
    }

    fun setNewTetrominoPosition(tetromino: Tetromino) {
        updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
    }

    fun eraseOldTetrominoPosition(tetromino: Tetromino) {
        updateBoard(tetromino.position, TetrionCellState.EMPTY)
    }

    fun printBoard() {
        println()
        for (row in board) {
            for (col in row) {
                when (col) {
                    TetrionCellState.EMPTY -> print("* ")
                    TetrionCellState.MOVING_TETROMINO -> print("o ")
                    TetrionCellState.FROZEN_TETROMINO -> print("x ")
                }
            }
            println()
        }
    }
}

enum class TetrionCellState {
    EMPTY, FROZEN_TETROMINO, MOVING_TETROMINO
}
