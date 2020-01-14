import controller.Game
import model.Tetrion
import model.TetrionCellState
import model.tetromino.Tetromino
import java.util.*

/**
 * Rules:
 * 1. Ruch
 *  a) pierwszy ruch:
 *      - mozliwy?
 *        :Y -> wykonaj kolejny ruch
 *        :N -> koniec gry
 *  b) normalny ruch:
 *      - ...
 * 2. Obrot
 * - Przed obrotem sprawdz czy mozliwe
 *   :Y -> Obroc, :N -> nie rob nic
 */

fun main() {

    val board = Tetrion()
    var tetromino: Tetromino

    val input = Scanner(System.`in`)
    while (true) {
        tetromino = Game.generateTetromino()
        board.updateBoard(tetromino.tetrominoPosition, TetrionCellState.MOVING_TETROMINO)
        board.printBoard()

        val options = """OPTIONS:
            |G - generating new Tetromino
            |C - continue
        """.trimMargin()
        println(options)

        if (input.next() == "G") {
            board.eraseOldTetrominoPosition(tetromino)
            tetromino = Game.generateTetromino()
        } else break
    }

    loop@ while (true) {
        val options = """OPTIONS:
            |R - move right
            |L - move left
            |T - turn
            |C - continue
        """.trimMargin()
        println(options)

        when (input.next()) {
            "R" -> tetromino.moveRight(board)
            "L" -> tetromino.moveLeft(board)
            "T" -> tetromino.turn(board)
            "C" -> break@loop
            else -> println("Such option doesn't exist.")
        }

        board.printBoard()
    }

}

enum class MoveDirection(val numVal: Int) {
    RIGHT(1), LEFT(-1)
}





