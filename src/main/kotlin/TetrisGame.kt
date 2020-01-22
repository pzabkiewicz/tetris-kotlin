import controller.Game
import model.Tetrion
import model.TetrionCellState
import model.tetromino.Tetromino
import java.util.*

fun main() {

    val board = Tetrion()
    var tetromino: Tetromino

    val input = Scanner(System.`in`)
    while (true) {
        tetromino = Game.generateTetromino()
        board.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
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
            |U - move up
            |D - move down
            |T - turn
            |C - continue
        """.trimMargin()
        println(options)

        when (input.next()) {
            "R" -> tetromino.moveRight(board)
            "L" -> tetromino.moveLeft(board)
            "U" -> tetromino.moveUp(board)
            "D" -> tetromino.moveDown(board)
            "T" -> tetromino.turn(board)
            "C" -> break@loop
            else -> println("Such option doesn't exist.")
        }

        board.printBoard()
    }

}

enum class MoveDirection(val horizontalNumVal: Int, val verticalNumVal: Int) {
    RIGHT(1, 0),
    LEFT(-1, 0),
    UP(0, -1),
    DOWN(0, 1)
}





