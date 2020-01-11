package model.tetromino

import model.Tetrion

abstract class TurnControl {

    // TODO: Replace to proper instance of TurnControl
    companion object {
        fun getInstance(tetrominoType: TetrominoType): TurnControl =
            when (tetrominoType) {
                TetrominoType.I -> TTurnControl()
                TetrominoType.T -> TTurnControl()
                TetrominoType.O -> TTurnControl()
                TetrominoType.L -> TTurnControl()
                TetrominoType.J -> TTurnControl()
                TetrominoType.S -> TTurnControl()
                TetrominoType.Z -> TTurnControl()
            }
    }

    abstract fun performTurn(turnCounter: Int, tetromino: Tetromino, tetrion: Tetrion)
}

class TTurnControl : TurnControl() {
    private val turnDirSigns = mutableListOf(1 to -1, 1 to 1, -1 to 1, -1 to -1)

    override fun performTurn(turnCounter: Int, tetromino: Tetromino, tetrion: Tetrion) {
        val oldPosition = tetromino.tetrominoPosition
        val newPosition = mutableListOf<Pair<Int, Int>>()

        for (i in oldPosition.indices) {
            if (i == 1) {
                newPosition.add(i, oldPosition[i].copy())
                continue
            }

            val signs = turnDirSigns[i.plus(turnCounter).rem(4)]
            newPosition.add(i,
                (oldPosition[i].first + signs.first) to (oldPosition[i].second + signs.second))
        }

        tetrion.eraseOldTetrominoPosition(tetromino)
        tetromino.tetrominoPosition = newPosition
        tetrion.setNewTetrominoPosition(tetromino)
    }
}
