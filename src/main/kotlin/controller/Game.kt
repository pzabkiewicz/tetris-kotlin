package controller

import model.tetromino.Tetromino

object Game {

    fun generateTetromino(): Tetromino = Tetromino.newRandom()
}
