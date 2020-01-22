package model.tetromino

import MoveDirection
import model.Tetrion
import kotlin.random.Random

enum class TetrominoType(val initPosition: List<Pair<Int, Int>>) {
    I(listOf(Pair(4, -4), Pair(4, -3), Pair(4, -2), Pair(4, -1))),
    T(listOf(Pair(3, -2), Pair(4, -2), Pair(5, -2), Pair(4, -1))),
    O(listOf(Pair(4, -2), Pair(5, -2), Pair(4, -1), Pair(5, -1))),
    L(listOf(Pair(4, -3), Pair(4, -2), Pair(4, -1), Pair(5, -1))),
    J(listOf(Pair(4, -3), Pair(4, -2), Pair(3, -1), Pair(4, -1))),
    S(listOf(Pair(4, -2), Pair(5, -2), Pair(3, -1), Pair(4, -1))),
    Z(listOf(Pair(3, -2), Pair(4, -2), Pair(4, -1), Pair(5, -1)));
}

class Tetromino(tetrominoType: TetrominoType,
                var position: List<Pair<Int, Int>>,
                var turnCounter: Int = 0) {

    private val turnControl = TurnControl(tetrominoType)

    constructor(tetrominoType: TetrominoType) : this(tetrominoType, tetrominoType.initPosition)

    companion object {
        const val MAX_TURN_COUNTER_VAL = 4

        fun newRandom(): Tetromino {
            val idx = Random.nextInt(TetrominoType.values().size)
            val randomTetrominoType = TetrominoType.values()[idx]

            return Tetromino(randomTetrominoType)
        }
    }

    fun dontMove() {}
    fun moveRight(tetrion: Tetrion) = move(MoveDirection.RIGHT, tetrion)
    fun moveLeft(tetrion: Tetrion) = move(MoveDirection.LEFT, tetrion)
    fun moveUp(tetrion: Tetrion) = move(MoveDirection.UP, tetrion)
    fun moveDown(tetrion: Tetrion) = move(MoveDirection.DOWN, tetrion)

    fun turn(tetrion: Tetrion) {
        turnControl.performTurn(turnCounter, this, tetrion)
        turnCounter = turnCounter.inc().rem(MAX_TURN_COUNTER_VAL)
    }

    private fun move(moveDirection: MoveDirection, tetrion: Tetrion) {

        val newPosition = position.asIterable()
            .map { (it.first + moveDirection.horizontalNumVal) to (it.second + moveDirection.verticalNumVal) }
            .toList()

        // TODO: validation - detection of frozen tetrominos
        when (moveDirection) {
            MoveDirection.LEFT -> {
                for (block in newPosition)
                    if (block.first < 0) return
            }
            MoveDirection.RIGHT -> {
                for (block in newPosition)
                    if (block.first >= tetrion.board[0].size) return

            }
            MoveDirection.DOWN -> {
                for (block in newPosition)
                    if (block.second >= tetrion.board.size - Tetrion.TOP_MARGIN_HEIGHT) return
            }
        }

        tetrion.eraseOldTetrominoPosition(this)
        position = newPosition
        tetrion.setNewTetrominoPosition(this)
    }

}
