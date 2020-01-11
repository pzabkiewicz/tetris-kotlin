package model.tetromino

import MoveDirection
import model.Tetrion
import kotlin.random.Random
import kotlin.streams.toList

enum class TetrominoType(val initPosition: List<Pair<Int, Int>>) {
    I(listOf(Pair(4, -4), Pair(4, -3), Pair(4, -2), Pair(4, -1))),
    T(listOf(Pair(3, -2), Pair(4, -2), Pair(5, -2), Pair(4, -1))),
    O(listOf(Pair(4, -2), Pair(5, -2), Pair(4, -1), Pair(5, -1))),
    L(listOf(Pair(4, -3), Pair(4, -2), Pair(4, -1), Pair(5, -1))),
    J(listOf(Pair(4, -3), Pair(4, -2), Pair(3, -1), Pair(4, -1))),
    S(listOf(Pair(4, -2), Pair(5, -2), Pair(3, -1), Pair(4, -1))),
    Z(listOf(Pair(3, -2), Pair(4, -2), Pair(4, -1), Pair(5, -1)));
}

class Tetromino(val tetrominoType: TetrominoType) {

    var tetrominoPosition: List<Pair<Int, Int>> = tetrominoType.initPosition
    var turnCounter = 0

    companion object {
        fun newRandom(): Tetromino {
            val idx = Random.nextInt(TetrominoType.values().size)
            val randomTetrominoType = TetrominoType.values()[idx]

            return Tetromino(randomTetrominoType)
        }
    }

    fun moveRight(tetrion: Tetrion) = move(MoveDirection.RIGHT, tetrion)
    fun moveLeft(tetrion: Tetrion) = move(MoveDirection.LEFT, tetrion)

    fun turn(tetrion: Tetrion) {
        val turnControl = TurnControl.getInstance(tetrominoType)
        turnControl.performTurn(turnCounter, this, tetrion)
        turnCounter = turnCounter.inc().rem(4)
    }

    private fun move(moveDirection: MoveDirection, tetrion: Tetrion) {

        val newPosition = tetrominoPosition.stream()
            .map { (it.first + moveDirection.numVal) to it.second }
            .toList()

        // TODO: validation - detecion of frozen tetrominos
        when (moveDirection) {
            MoveDirection.LEFT -> {
                for (block in newPosition) {
                    if (block.first < 0) return
                }
            }
            MoveDirection.RIGHT -> {
                for (block in newPosition) {
                    if (block.first >= tetrion.board[0].size) return
                }
            }
        }

        tetrion.eraseOldTetrominoPosition(this)
        tetrominoPosition = newPosition
        tetrion.setNewTetrominoPosition(this)
    }

}
