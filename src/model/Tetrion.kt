package model

import model.tetromino.Tetromino

class Tetrion {

    val board: List<MutableList<TetrionCellState>> = (1..24).asIterable()
        .map {
            (1..10).asIterable().map { TetrionCellState.EMPTY }.toMutableList()
        }.toList()

    fun updateBoard(fieldsForUpdate: List<Pair<Int, Int>>, value: TetrionCellState) {
        for (tetrominoBlock in fieldsForUpdate) {
            val row = board[tetrominoBlock.second + 4]
            row[tetrominoBlock.first] = value
        }
    }

    fun setNewTetrominoPosition(tetromino: Tetromino) {
        updateBoard(tetromino.tetrominoPosition, TetrionCellState.MOVING_TETROMINO)
    }

    fun eraseOldTetrominoPosition(tetromino: Tetromino) {
        updateBoard(tetromino.tetrominoPosition, TetrionCellState.EMPTY)
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
