package model.tetromino

import model.Tetrion

abstract class TurnControl {

    // TODO: Replace to proper instance of TurnControl
    companion object {
        fun getInstance(tetrominoType: TetrominoType): TurnControl =
            when (tetrominoType) {
                TetrominoType.I -> ITurnControl()
                TetrominoType.T -> TTurnControl()
                TetrominoType.O -> OTurnControl()
                TetrominoType.L -> LTurnControl()
                TetrominoType.J -> JTurnControl()
                TetrominoType.S -> STurnControl()
                TetrominoType.Z -> ZTurnControl()
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

class LTurnControl : TurnControl() {
    private val turnDirSigns = mutableListOf(
         1 to 1, -1 to 1, -1 to -1, 1 to -1,
        -2 to 0, 0 to -2, 2 to 0, 0 to 2)

    override fun performTurn(turnCounter: Int, tetromino: Tetromino, tetrion: Tetrion) {
        val oldPosition = tetromino.tetrominoPosition
        val newPosition = mutableListOf<Pair<Int, Int>>()

        for (i in oldPosition.indices) {
            if (i == 1) {
                newPosition.add(i, oldPosition[i].copy())
                continue
            }

            val idx = if (i == 3) i.plus(turnCounter.plus(1)) else i.plus(turnCounter).rem(4)
            val signs = turnDirSigns[idx]
            newPosition.add(i,
                (oldPosition[i].first + signs.first) to (oldPosition[i].second + signs.second))
        }


        tetrion.eraseOldTetrominoPosition(tetromino)
        tetromino.tetrominoPosition = newPosition
        tetrion.setNewTetrominoPosition(tetromino)
    }
}

class JTurnControl : TurnControl() {
    private val turnDirSigns = mutableListOf(
        1 to 1, -1 to 1, -1 to -1, 1 to -1,
        0 to -2, 2 to 0, 0 to 2, -2 to 0)

    override fun performTurn(turnCounter: Int, tetromino: Tetromino, tetrion: Tetrion) {
        val oldPosition = tetromino.tetrominoPosition
        val newPosition = mutableListOf<Pair<Int, Int>>()

        for (i in oldPosition.indices) {
            if (i == 1) {
                newPosition.add(i, oldPosition[i].copy())
                continue
            }

            val idx = when(i) {
                0 -> i.plus(turnCounter)
                2 -> i.times(2).plus(turnCounter)
                else -> i.minus(1).plus(turnCounter).rem(4)
            }
            val signs = turnDirSigns[idx]
            newPosition.add(i,
                (oldPosition[i].first + signs.first) to (oldPosition[i].second + signs.second))
        }


        tetrion.eraseOldTetrominoPosition(tetromino)
        tetromino.tetrominoPosition = newPosition
        tetrion.setNewTetrominoPosition(tetromino)
    }
}

class ITurnControl : TurnControl() {
    private val turnDirSigns = mutableListOf(
        1 to 2, -2 to 1, -1 to -2, 2 to -1,
        0 to 1, -1 to 0, 0 to -1, 1 to 0,
        -2 to -1, 1 to -2, 2 to 1, -1 to 2
    )

    override fun performTurn(turnCounter: Int, tetromino: Tetromino, tetrion: Tetrion) {
        val oldPosition = tetromino.tetrominoPosition
        val newPosition = mutableListOf<Pair<Int, Int>>()

        for (i in oldPosition.indices) {
            val idx = when (i) {
                0 -> i.plus(turnCounter)
                3 -> i.times(3).minus(1).plus(turnCounter)
                else -> i.plus(turnCounter - 1).rem(4).plus(4)
            }
            val signs = turnDirSigns[idx]
            newPosition.add(i,
                (oldPosition[i].first + signs.first) to (oldPosition[i].second + signs.second)
            )
        }


        tetrion.eraseOldTetrominoPosition(tetromino)
        tetromino.tetrominoPosition = newPosition
        tetrion.setNewTetrominoPosition(tetromino)
    }
}

class OTurnControl : TurnControl() {
    override fun performTurn(turnCounter: Int, tetromino: Tetromino, tetrion: Tetrion) {}
}

class STurnControl : TurnControl() {
    private val turnDirSigns = mutableListOf(
        1 to 1, -1 to 1, -1 to -1, 1 to -1,
        0 to 2, -2 to 0, 0 to -2, 2 to 0,
        1 to -1, 1 to 1, -1 to 1, -1 to -1
    )

    override fun performTurn(turnCounter: Int, tetromino: Tetromino, tetrion: Tetrion) {
        val oldPosition = tetromino.tetrominoPosition
        val newPosition = mutableListOf<Pair<Int, Int>>()

        for (i in oldPosition.indices) {
            if (i == 3) {
                newPosition.add(i, oldPosition[i].copy())
                continue
            }

            val signs = turnDirSigns[i.times(4).plus(turnCounter)]
            newPosition.add(i,
                (oldPosition[i].first + signs.first) to (oldPosition[i].second + signs.second)
            )
        }


        tetrion.eraseOldTetrominoPosition(tetromino)
        tetromino.tetrominoPosition = newPosition
        tetrion.setNewTetrominoPosition(tetromino)
    }
}

class ZTurnControl : TurnControl() {
    private val turnDirSigns = mutableListOf(
        2 to -1, 0 to 2, -2 to 0, 0 to -1,
        1 to 0, -1 to 1, -1 to -1, 1 to 0,
        0 to -1, 0 to 0, 0 to 0, 0 to 1,
        -1 to 0, -1 to -1, 1 to -1, 1 to 2
    )

    override fun performTurn(turnCounter: Int, tetromino: Tetromino, tetrion: Tetrion) {
        val oldPosition = tetromino.tetrominoPosition
        val newPosition = mutableListOf<Pair<Int, Int>>()

        for (i in oldPosition.indices) {
            val signs = turnDirSigns[i.times(4).plus(turnCounter)]
            newPosition.add(i,
                (oldPosition[i].first + signs.first) to (oldPosition[i].second + signs.second)
            )
        }


        tetrion.eraseOldTetrominoPosition(tetromino)
        tetromino.tetrominoPosition = newPosition
        tetrion.setNewTetrominoPosition(tetromino)
    }
}
