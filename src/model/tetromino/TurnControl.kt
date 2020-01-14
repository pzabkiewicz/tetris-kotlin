package model.tetromino

import model.Tetrion

class TurnControl(val tetrominoType: TetrominoType) {

    val turnable = Turnable.getInstance(tetrominoType)

    fun performTurn(turnCounter: Int, tetromino: Tetromino, tetrion: Tetrion) {
        val oldPosition = tetromino.tetrominoPosition
        val newPosition = mutableListOf<Pair<Int, Int>>()

        // calculate new position
        turnable.execute(turnCounter, oldPosition, newPosition)

        // perform validation

        // if validation OK - perform turn
        tetrion.eraseOldTetrominoPosition(tetromino)
        tetromino.tetrominoPosition = newPosition
        tetrion.setNewTetrominoPosition(tetromino)
    }
}


