package model.tetromino

import model.Tetrion
import model.TetrionCellState
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test


class TetrominoTest {

    @Nested
    inner class ITetrominoTest {

        @Test
        fun `right position after 1 turn from origin position`() {
            // given
            val tetromino = Tetromino(TetrominoType.I)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(5 to -2, 4 to -2, 3 to -2, 2 to -2)

            // when
            tetromino.turn(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position after 2 turns from origin position`() {
            // given
            val tetromino = Tetromino(TetrominoType.I)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(3 to -1, 3 to -2, 3 to -3, 3 to -4)
            val turns = 2

            // when
            (1..turns).forEach { _ -> tetromino.turn(tetrion) }

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position after 3 turns from origin position`() {
            // given
            val tetromino = Tetromino(TetrominoType.I)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(2 to -3, 3 to -3, 4 to -3, 5 to -3)
            val turns = 3

            // when
            (1..turns).forEach { _ -> tetromino.turn(tetrion) }

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position after 4 turns from origin position`() {
            // given
            val tetromino = Tetromino(TetrominoType.I)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(4 to -4, 4 to -3, 4 to -2, 4 to -1)
            val turns = 4

            // when
            (1..turns).forEach { _ -> tetromino.turn(tetrion) }

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position if turn from default position next to right margin`() {
            // given
            val initTetrominoPosition = listOf(9 to -4, 9 to -3, 9 to -2, 9 to -1)
            val tetromino = Tetromino(TetrominoType.I, initTetrominoPosition)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(9 to -2, 8 to -2, 7 to -2, 6 to -2)

            // when
            tetromino.turn(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position if turn from 1-turn-position next to right margin`() {
            // given
            val initTetrominoPosition = listOf(9 to -2, 8 to -2, 7 to -2, 6 to -2)
            val tetromino = Tetromino(TetrominoType.I, initTetrominoPosition, 1)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(7 to -1, 7 to -2, 7 to -3, 7 to -4)

            // when
            tetromino.turn(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position if turn from 2-turn-position next to right margin`() {
            // given
            val initTetrominoPosition = listOf(9 to -1, 9 to -2, 9 to -3, 9 to -4)
            val tetromino = Tetromino(TetrominoType.I, initTetrominoPosition, 2)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(6 to -3, 7 to -3, 8 to -3, 9 to -3)

            // when
            tetromino.turn(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position if turn from 3-turn-position next to right margin`() {
            // given
            val initTetrominoPosition = listOf(6 to -3, 7 to -3, 8 to -3, 9 to -3)
            val tetromino = Tetromino(TetrominoType.I, initTetrominoPosition, 3)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(8 to -4, 8 to -3, 8 to -2, 8 to -1)

            // when
            tetromino.turn(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position if turn from default position next to left margin`() {
            // given
            val initTetrominoPosition = listOf(0 to -4, 0 to -3, 0 to -2, 0 to -1)
            val tetromino = Tetromino(TetrominoType.I, initTetrominoPosition)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(3 to -2, 2 to -2, 1 to -2, 0 to -2)

            // when
            tetromino.turn(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position if turn from 1-turn-position next to left margin`() {
            // given
            val initTetrominoPosition = listOf(3 to -2, 2 to -2, 1 to -2, 0 to -2)
            val tetromino = Tetromino(TetrominoType.I, initTetrominoPosition, 1)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(1 to -1, 1 to -2, 1 to -3, 1 to -4)

            // when
            tetromino.turn(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position if turn from 2-turn-position next to left margin`() {
            // given
            val initTetrominoPosition = listOf(0 to -1, 0 to -2, 0 to -3, 0 to -4)
            val tetromino = Tetromino(TetrominoType.I, initTetrominoPosition, 2)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(0 to -3, 1 to -3, 2 to -3, 3 to -3)

            // when
            tetromino.turn(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position if turn from 3-turn-position next to left margin`() {
            // given
            val initTetrominoPosition = listOf(0 to -3, 1 to -3, 2 to -3, 3 to -3)
            val tetromino = Tetromino(TetrominoType.I, initTetrominoPosition, 3)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(2 to -4, 2 to -3, 2 to -2, 2 to -1)

            // when
            tetromino.turn(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        // TODO: turns next to bottom

        @Test
        fun `right position if turn from 1-turn-position next to bottom margin`() {
            // given
            val initTetrominoPosition = listOf(5 to 19, 4 to 19, 3 to 19, 2 to 19)
            val tetromino = Tetromino(TetrominoType.I, initTetrominoPosition, 1)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(3 to 19, 3 to 18, 3 to 17, 3 to 16)

            // when
            tetromino.turn(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position if turn from 2-turn-position next to bottom margin`() {
            // given
            val initTetrominoPosition = listOf(3 to 19, 3 to 18, 3 to 17, 3 to 16)
            val tetromino = Tetromino(TetrominoType.I, initTetrominoPosition, 2)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(2 to 17, 3 to 17, 4 to 17, 5 to 17)

            // when
            tetromino.turn(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position if turn from 3-turn-position next to bottom margin`() {
            // given
            val initTetrominoPosition = listOf(0 to -3, 1 to -3, 2 to -3, 3 to -3)
            val tetromino = Tetromino(TetrominoType.I, initTetrominoPosition, 3)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(2 to -4, 2 to -3, 2 to -2, 2 to -1)

            // when
            tetromino.turn(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        // TODO: corners

        @Test
        fun `right position after moving right from origin position`() {
            // given
            val tetromino = Tetromino(TetrominoType.I)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(5 to -4, 5 to -3, 5 to -2, 5 to -1)

            // when
            tetromino.moveRight(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `do not move right if next to right margin`() {
            // given
            val tetrominoPosition = listOf(9 to -4, 9 to -3, 9 to -2, 9 to -1)
            val tetromino = Tetromino(TetrominoType.I, tetrominoPosition)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(9 to -4, 9 to -3, 9 to -2, 9 to -1)

            // when
            tetromino.moveRight(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position after moving left from origin position`() {
            // given
            val tetromino = Tetromino(TetrominoType.I)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(3 to -4, 3 to -3, 3 to -2, 3 to -1)

            // when
            tetromino.moveLeft(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `do not move left if next to left margin`() {
            // given
            val tetrominoPosition = listOf(0 to -4, 0 to -3, 0 to -2, 0 to -1)
            val tetromino = Tetromino(TetrominoType.I, tetrominoPosition)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(0 to -4, 0 to -3, 0 to -2, 0 to -1)

            // when
            tetromino.moveLeft(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position after moving down from origin position`() {
            // given
            val tetromino = Tetromino(TetrominoType.I)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(4 to -3, 4 to -2, 4 to -1, 4 to 0)

            // when
            tetromino.moveDown(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `do not move down if next to bottom margin`() {
            // given
            val tetrominoPosition = listOf(4 to 16, 4 to 17, 4 to 18, 4 to 19)
            val tetromino = Tetromino(TetrominoType.I, tetrominoPosition)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(4 to 16, 4 to 17, 4 to 18, 4 to 19)

            // when
            tetromino.moveDown(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }
    }

    @Nested
    inner class OTetrominoTest {

        @Test
        fun `right position after 1 turn from origin position`() {
            // given
            val tetromino = Tetromino(TetrominoType.O)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(4 to -2, 5 to -2, 4 to -1, 5 to -1)

            // when
            tetromino.turn(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position after 2 turns from origin position`() {
            // given
            val tetromino = Tetromino(TetrominoType.O)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(4 to -2, 5 to -2, 4 to -1, 5 to -1)
            val turns = 2

            // when
            (1..turns).forEach{ _ -> tetromino.turn(tetrion) }

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position after 3 turns from origin position`() {
            // given
            val tetromino = Tetromino(TetrominoType.O)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(4 to -2, 5 to -2, 4 to -1, 5 to -1)
            val turns = 3

            // when
            (1..turns).forEach{ _ -> tetromino.turn(tetrion) }

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position after 4 turns from origin position`() {
            // given
            val tetromino = Tetromino(TetrominoType.O)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(4 to -2, 5 to -2, 4 to -1, 5 to -1)
            val turns = 4

            // when
            (1..turns).forEach{ _ -> tetromino.turn(tetrion) }

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position if turn next to right margin`() {
            // given
            val initTetrominoPosition = listOf(8 to -2, 9 to -2, 8 to -1, 9 to -1)
            val tetromino = Tetromino(TetrominoType.O, initTetrominoPosition)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(8 to -2, 9 to -2, 8 to -1, 9 to -1)

            // when
            tetromino.turn(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position after moving right from origin position`() {
            // given
            val tetromino = Tetromino(TetrominoType.O)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(5 to -2, 6 to -2, 5 to -1, 6 to -1)

            // when
            tetromino.moveRight(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `do not move right if next to right margin`() {
            // given
            val initTetrominoPosition = listOf(8 to -2, 9 to -2, 8 to -1, 9 to -1)
            val tetromino = Tetromino(TetrominoType.O, initTetrominoPosition)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(8 to -2, 9 to -2, 8 to -1, 9 to -1)

            // when
            tetromino.moveRight(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position after moving left from origin position`() {
            // given
            val tetromino = Tetromino(TetrominoType.O)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(3 to -2, 4 to -2, 3 to -1, 4 to -1)

            // when
            tetromino.moveLeft(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `do not move left if next to left margin`() {
            // given
            val initTetrominoPosition = listOf(0 to -2, 1 to -2, 0 to -1, 1 to -1)
            val tetromino = Tetromino(TetrominoType.O, initTetrominoPosition)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(0 to -2, 1 to -2, 0 to -1, 1 to -1)

            // when
            tetromino.moveLeft(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position after moving down from origin position`() {
            // given
            val tetromino = Tetromino(TetrominoType.O)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(4 to -1, 5 to -1, 4 to 0, 5 to 0)

            // when
            tetromino.moveDown(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `do not move down if next to bottom margin`() {
            // given
            val initTetrominoPosition = listOf(4 to 18, 5 to 18, 4 to 19, 5 to 19)
            val tetromino = Tetromino(TetrominoType.O, initTetrominoPosition)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(4 to 18, 5 to 18, 4 to 19, 5 to 19)

            // when
            tetromino.moveDown(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }
    }

    @Nested
    inner class LTetrominoTest {

        @Test
        fun `right position after 1 turn from origin position`() {
            // given
            val tetromino = Tetromino(TetrominoType.L)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(5 to -2, 4 to -2, 3 to -2, 3 to -1)

            // when
            tetromino.turn(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position after 2 turns from origin position`() {
            // given
            val tetromino = Tetromino(TetrominoType.L)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(4 to -1, 4 to -2, 4 to -3, 3 to -3)
            val turns = 2

            // when
            (1..turns).forEach{ _ -> tetromino.turn(tetrion) }

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position after 3 turns from origin position`() {
            // given
            val tetromino = Tetromino(TetrominoType.L)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(3 to -2, 4 to -2, 5 to -2, 5 to -3)
            val turns = 3

            // when
            (1..turns).forEach{ _ -> tetromino.turn(tetrion) }

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position after 4 turns from origin position`() {
            // given
            val tetromino = Tetromino(TetrominoType.L)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(4 to -3, 4 to -2, 4 to -1, 5 to -1)
            val turns = 4

            // when
            (1..turns).forEach{ _ -> tetromino.turn(tetrion) }

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position if turn from default position next to right margin`() {
            // given
            val initTetrominoPosition = listOf(8 to -3, 8 to -2, 8 to -1, 9 to -1)
            val tetromino = Tetromino(TetrominoType.L, initTetrominoPosition)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(9 to -2, 8 to -2, 7 to -2, 7 to -1)

            // when
            tetromino.turn(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position if turn from 1-turn-position next to right margin`() {
            // given
            val initTetrominoPosition = listOf(9 to -2, 8 to -2, 7 to -2, 7 to -1)
            val tetromino = Tetromino(TetrominoType.L, initTetrominoPosition, 1)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(8 to -1, 8 to -2, 8 to -3, 7 to -3)

            // when
            tetromino.turn(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position if turn from 2-turn-position next to right margin`() {
            // given
            val initTetrominoPosition = listOf(9 to -1, 9 to -2, 9 to -3, 8 to -3)
            val tetromino = Tetromino(TetrominoType.L, initTetrominoPosition, 2)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(7 to -2, 8 to -2, 9 to -2, 9 to -3)

            // when
            tetromino.turn(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position if turn from 3-turn-position next to right margin`() {
            // given
            val initTetrominoPosition = listOf(7 to -2, 8 to -2, 9 to -2, 9 to -3)
            val tetromino = Tetromino(TetrominoType.L, initTetrominoPosition, 3)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(8 to -3, 8 to -2, 8 to -1, 9 to -1)

            // when
            tetromino.turn(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position after moving right from origin position`() {
            // given
            val tetromino = Tetromino(TetrominoType.L)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(5 to -3, 5 to -2, 5 to -1, 6 to -1)

            // when
            tetromino.moveRight(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `do not move right if next to right margin`() {
            // given
            val initTetrominoPosition = listOf(8 to -3, 8 to -2, 8 to -1, 9 to -1)
            val tetromino = Tetromino(TetrominoType.L, initTetrominoPosition)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(8 to -3, 8 to -2, 8 to -1, 9 to -1)

            // when
            tetromino.moveRight(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position after moving left from origin position`() {
            // given
            val tetromino = Tetromino(TetrominoType.L)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(3 to -3, 3 to -2, 3 to -1, 4 to -1)

            // when
            tetromino.moveLeft(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `do not move left if next to left margin`() {
            // given
            val initTetrominoPosition = listOf(0 to -3, 0 to -2, 0 to -1, 1 to -1)
            val tetromino = Tetromino(TetrominoType.L, initTetrominoPosition)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(0 to -3, 0 to -2, 0 to -1, 1 to -1)

            // when
            tetromino.moveLeft(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position after moving down from origin position`() {
            // given
            val tetromino = Tetromino(TetrominoType.L)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(4 to -2, 4 to -1, 4 to 0, 5 to 0)

            // when
            tetromino.moveDown(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `do not move down if next to bottom margin`() {
            // given
            val initTetrominoPosition = listOf(4 to 17, 4 to 18, 4 to 19, 5 to 19)
            val tetromino = Tetromino(TetrominoType.L, initTetrominoPosition)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(4 to 17, 4 to 18, 4 to 19, 5 to 19)

            // when
            tetromino.moveDown(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }
    }

    @Nested
    inner class JTetrominoTest {

        @Test
        fun `right position after 1 turn from origin position`() {
            // given
            val tetromino = Tetromino(TetrominoType.J)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(5 to -2, 4 to -2, 3 to -3, 3 to -2)

            // when
            tetromino.turn(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position after 2 turns from origin position`() {
            // given
            val tetromino = Tetromino(TetrominoType.J)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(4 to -1, 4 to -2, 5 to -3, 4 to -3)
            val turns = 2

            // when
            (1..turns).forEach { _ -> tetromino.turn(tetrion) }

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position after 3 turns from origin position`() {
            // given
            val tetromino = Tetromino(TetrominoType.J)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(3 to -2, 4 to -2, 5 to -1, 5 to -2)
            val turns = 3

            // when
            (1..turns).forEach { _ -> tetromino.turn(tetrion) }

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position after 4 turns from origin position`() {
            // given
            val tetromino = Tetromino(TetrominoType.J)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(4 to -3, 4 to -2, 3 to -1, 4 to -1)
            val turns = 4

            // when
            (1..turns).forEach { _ -> tetromino.turn(tetrion) }

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position if turn from default position next to right margin`() {
            // given
            val initTetrominoPosition = listOf(9 to -3, 9 to -2, 8 to -1, 9 to -1)
            val tetromino = Tetromino(TetrominoType.J, initTetrominoPosition)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(9 to -2, 8 to -2, 7 to -3, 7 to -2)

            // when
            tetromino.turn(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position if turn from 1-turn-position next to right margin`() {
            // given
            val initTetrominoPosition = listOf(9 to -2, 8 to -2, 7 to -3, 7 to -2)
            val tetromino = Tetromino(TetrominoType.J, initTetrominoPosition, 1)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(8 to -1, 8 to -2, 9 to -3, 8 to -3)

            // when
            tetromino.turn(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position if turn from 2-turn-position next to right margin`() {
            // given
            val initTetrominoPosition = listOf(8 to -1, 8 to -2, 9 to -3, 8 to -3)
            val tetromino = Tetromino(TetrominoType.J, initTetrominoPosition, 2)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(7 to -2, 8 to -2, 9 to -1, 9 to -2)

            // when
            tetromino.turn(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position if turn from 3-turn-position next to right margin`() {
            // given
            val initTetrominoPosition = listOf(7 to -2, 8 to -2, 9 to -1, 9 to -2)
            val tetromino = Tetromino(TetrominoType.J, initTetrominoPosition, 3)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(8 to -3, 8 to -2, 7 to -1, 8 to -1)

            // when
            tetromino.turn(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position after moving right from origin position`() {
            // given
            val tetromino = Tetromino(TetrominoType.J)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(5 to -3, 5 to -2, 4 to -1, 5 to -1)

            // when
            tetromino.moveRight(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `do not move right if next to right margin`() {
            // given
            val initTetrominoPosition = listOf(9 to -3, 9 to -2, 8 to -1, 9 to -1)
            val tetromino = Tetromino(TetrominoType.J, initTetrominoPosition)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(9 to -3, 9 to -2, 8 to -1, 9 to -1)

            // when
            tetromino.moveRight(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position after moving left from origin position`() {
            // given
            val tetromino = Tetromino(TetrominoType.J)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(3 to -3, 3 to -2, 2 to -1, 3 to -1)

            // when
            tetromino.moveLeft(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `do not move left if next to left margin`() {
            // given
            val initTetrominoPosition = listOf(1 to -3, 1 to -2, 0 to -1, 1 to -1)
            val tetromino = Tetromino(TetrominoType.J, initTetrominoPosition)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(1 to -3, 1 to -2, 0 to -1, 1 to -1)

            // when
            tetromino.moveLeft(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position after moving down from origin position`() {
            // given
            val tetromino = Tetromino(TetrominoType.J)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(4 to -2, 4 to -1, 3 to 0, 4 to 0)

            // when
            tetromino.moveDown(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `do not move down if next to bottom margin`() {
            // given
            val initTetrominoPosition = listOf(4 to 17, 4 to 18, 3 to 19, 4 to 19)
            val tetromino = Tetromino(TetrominoType.J, initTetrominoPosition)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(4 to 17, 4 to 18, 3 to 19, 4 to 19)

            // when
            tetromino.moveDown(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }
    }

    @Nested
    inner class STetrominoTest {

        @Test
        fun `right position after 1 turn from origin position`() {
            // given
            val tetromino = Tetromino(TetrominoType.S)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(5 to -1, 5 to 0, 4 to -2, 4 to -1)

            // when
            tetromino.turn(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position after 2 turns from origin position`() {
            // given
            val tetromino = Tetromino(TetrominoType.S)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(4 to 0, 3 to 0, 5 to -1, 4 to -1)
            val turns = 2

            // when
            (1..turns).forEach { _ -> tetromino.turn(tetrion) }

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position after 3 turns from origin position`() {
            // given
            val tetromino = Tetromino(TetrominoType.S)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(3 to -1, 3 to -2, 4 to 0, 4 to -1)
            val turns = 3

            // when
            (1..turns).forEach { _ -> tetromino.turn(tetrion) }

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position after 4 turns from origin position`() {
            // given
            val tetromino = Tetromino(TetrominoType.S)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(4 to -2, 5 to -2, 3 to -1, 4 to -1)
            val turns = 4

            // when
            (1..turns).forEach { _ -> tetromino.turn(tetrion) }

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position if turn from default position next to right margin`() {
            // given
            val initTetrominoPosition = listOf(8 to -2, 9 to -2, 7 to -1, 8 to -1)
            val tetromino = Tetromino(TetrominoType.S, initTetrominoPosition)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(9 to -1, 9 to 0, 8 to -2, 8 to -1)

            // when
            tetromino.turn(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position if turn from 1-turn-position next to right margin`() {
            // given
            val initTetrominoPosition = listOf(9 to -1, 9 to 0, 8 to -2, 8 to -1)
            val tetromino = Tetromino(TetrominoType.S, initTetrominoPosition, 1)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(8 to 0, 7 to 0, 9 to -1, 8 to -1)

            // when
            tetromino.turn(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position if turn from 2-turn-position next to right margin`() {
            // given
            val initTetrominoPosition = listOf(8 to 0, 7 to 0, 9 to -1, 8 to -1)
            val tetromino = Tetromino(TetrominoType.S, initTetrominoPosition, 2)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(7 to -1, 7 to -2, 8 to 0, 8 to -1)

            // when
            tetromino.turn(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position if turn from 3-turn-position next to right margin`() {
            // given
            val initTetrominoPosition = listOf(8 to -1, 8 to -2, 9 to 0, 9 to -1)
            val tetromino = Tetromino(TetrominoType.S, initTetrominoPosition, 3)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(8 to -2, 9 to -2, 7 to -1, 8 to -1)

            // when
            tetromino.turn(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position after moving right from origin position`() {
            // given
            val tetromino = Tetromino(TetrominoType.S)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(5 to -2, 6 to -2, 4 to -1, 5 to -1)

            // when
            tetromino.moveRight(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `do not move right if next to right margin`() {
            // given
            val initTetrominoPosition = listOf(8 to -2, 9 to -2, 7 to -1, 8 to -1)
            val tetromino = Tetromino(TetrominoType.S, initTetrominoPosition)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(8 to -2, 9 to -2, 7 to -1, 8 to -1)

            // when
            tetromino.moveRight(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position after moving left from origin position`() {
            // given
            val tetromino = Tetromino(TetrominoType.S)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(3 to -2, 4 to -2, 2 to -1, 3 to -1)

            // when
            tetromino.moveLeft(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `do not move left if next to left margin`() {
            // given
            val initTetrominoPosition = listOf(1 to -2, 2 to -2, 0 to -1, 1 to -1)
            val tetromino = Tetromino(TetrominoType.S, initTetrominoPosition)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(1 to -2, 2 to -2, 0 to -1, 1 to -1)

            // when
            tetromino.moveLeft(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position after moving down from origin position`() {
            // given
            val tetromino = Tetromino(TetrominoType.S)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(4 to -1, 5 to -1, 3 to 0, 4 to 0)

            // when
            tetromino.moveDown(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `do not move down if next to bottom margin`() {
            // given
            val initTetrominoPosition = listOf(4 to 18, 5 to 18, 3 to 19, 4 to 19)
            val tetromino = Tetromino(TetrominoType.S, initTetrominoPosition)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(4 to 18, 5 to 18, 3 to 19, 4 to 19)

            // when
            tetromino.moveDown(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }
    }

    @Nested
    inner class ZTetrominoTest {

        @Test
        fun `right position after 1 turn from origin position`() {
            // given
            val tetromino = Tetromino(TetrominoType.Z)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(5 to -3, 5 to -2, 4 to -2, 4 to -1)

            // when
            tetromino.turn(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position after 2 turns from origin position`() {
            // given
            val tetromino = Tetromino(TetrominoType.Z)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(5 to -1, 4 to -1, 4 to -2, 3 to -2)
            val turns = 2

            // when
            (1..turns).forEach { _ -> tetromino.turn(tetrion) }

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position after 3 turns from origin position`() {
            // given
            val tetromino = Tetromino(TetrominoType.Z)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(3 to -1, 3 to -2, 4 to -2, 4 to -3)
            val turns = 3

            // when
            (1..turns).forEach { _ -> tetromino.turn(tetrion) }

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position after 4 turns from origin position`() {
            // given
            val tetromino = Tetromino(TetrominoType.Z)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(3 to -2, 4 to -2, 4 to -1, 5 to -1)
            val turns = 4

            // when
            (1..turns).forEach { _ -> tetromino.turn(tetrion) }

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position if turn from default position next to right margin`() {
            // given
            val initTetrominoPosition = listOf(7 to -2, 8 to -2, 8 to -1, 9 to -1)
            val tetromino = Tetromino(TetrominoType.Z, initTetrominoPosition)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(9 to -3, 9 to -2, 8 to -2, 8 to -1)

            // when
            tetromino.turn(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position if turn from 1-turn-position next to right margin`() {
            // given
            val initTetrominoPosition = listOf(9 to -3, 9 to -2, 8 to -2, 8 to -1)
            val tetromino = Tetromino(TetrominoType.Z, initTetrominoPosition, 1)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(9 to -1, 8 to -1, 8 to -2, 7 to -2)

            // when
            tetromino.turn(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position if turn from 2-turn-position next to right margin`() {
            // given
            val initTetrominoPosition = listOf(9 to -1, 8 to -1, 8 to -2, 7 to -2)
            val tetromino = Tetromino(TetrominoType.Z, initTetrominoPosition, 2)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(7 to -1, 7 to -2, 8 to -2, 8 to -3)

            // when
            tetromino.turn(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position if turn from 3-turn-position next to right margin`() {
            // given
            val initTetrominoPosition = listOf(8 to -1, 8 to -2, 9 to -2, 9 to -3)
            val tetromino = Tetromino(TetrominoType.Z, initTetrominoPosition, 3)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(7 to -2, 8 to -2, 8 to -1, 9 to -1)

            // when
            tetromino.turn(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position after moving right from origin position`() {
            // given
            val tetromino = Tetromino(TetrominoType.Z)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(4 to -2, 5 to -2, 5 to -1, 6 to -1)

            // when
            tetromino.moveRight(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `do not move right if next to right margin`() {
            // given
            val initTetrominoPosition = listOf(7 to -2, 8 to -2, 8 to -1, 9 to -1)
            val tetromino = Tetromino(TetrominoType.Z, initTetrominoPosition)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(7 to -2, 8 to -2, 8 to -1, 9 to -1)

            // when
            tetromino.moveRight(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position after moving left from origin position`() {
            // given
            val tetromino = Tetromino(TetrominoType.Z)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(2 to -2, 3 to -2, 3 to -1, 4 to -1)

            // when
            tetromino.moveLeft(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `do not move left if next to left margin`() {
            // given
            val initTetrominoPosition = listOf(0 to -2, 1 to -2, 1 to -1, 2 to -1)
            val tetromino = Tetromino(TetrominoType.Z, initTetrominoPosition)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(0 to -2, 1 to -2, 1 to -1, 2 to -1)

            // when
            tetromino.moveLeft(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position after moving down from origin position`() {
            // given
            val tetromino = Tetromino(TetrominoType.Z)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(3 to -1, 4 to -1, 4 to 0, 5 to 0)

            // when
            tetromino.moveDown(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `do not move down if next to bottom margin`() {
            // given
            val initTetrominoPosition = listOf(3 to 18, 4 to 18, 4 to 19, 5 to 19)
            val tetromino = Tetromino(TetrominoType.Z, initTetrominoPosition)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(3 to 18, 4 to 18, 4 to 19, 5 to 19)

            // when
            tetromino.moveDown(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }
    }

    @Nested
    inner class TTetrominoTest {

        @Test
        fun `right position after 1 turn from origin position`() {
            // given
            val tetromino = Tetromino(TetrominoType.T)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(4 to -3, 4 to -2, 4 to -1, 3 to -2)

            // when
            tetromino.turn(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position after 2 turns from origin position`() {
            // given
            val tetromino = Tetromino(TetrominoType.T)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(5 to -2, 4 to -2, 3 to -2, 4 to -3)
            val turns = 2

            // when
            (1..turns).forEach{ _ -> tetromino.turn(tetrion) }

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position after 3 turns from origin position`() {
            // given
            val tetromino = Tetromino(TetrominoType.T)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(4 to -1, 4 to -2, 4 to -3, 5 to -2)
            val turns = 3

            // when
            (1..turns).forEach{ _ -> tetromino.turn(tetrion) }

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position after 4 turns from origin position`() {
            // given
            val tetromino = Tetromino(TetrominoType.T)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(3 to -2, 4 to -2, 5 to -2, 4 to -1)
            val turns = 4

            // when
            (1..turns).forEach{ _ -> tetromino.turn(tetrion) }

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position if turn from default position next to right margin`() {
            // given
            val initTetrominoPosition = listOf(7 to -2, 8 to -2, 9 to -2, 8 to -1)
            val tetromino = Tetromino(TetrominoType.T, initTetrominoPosition)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(8 to -3, 8 to -2, 8 to -1, 7 to -2)

            // when
            tetromino.turn(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position if turn from 1-turn-position next to right margin`() {
            // given
            val initTetrominoPosition = listOf(9 to -3, 9 to -2, 9 to -1, 8 to -2)
            val tetromino = Tetromino(TetrominoType.T, initTetrominoPosition, 1)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(9 to -2, 8 to -2, 7 to -2, 8 to -3)

            // when
            tetromino.turn(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position if turn from 2-turn-position next to right margin`() {
            // given
            val initTetrominoPosition = listOf(9 to -2, 8 to -2, 7 to -2, 8 to -3)
            val tetromino = Tetromino(TetrominoType.T, initTetrominoPosition, 2)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(8 to -1, 8 to -2, 8 to -3, 9 to -2)

            // when
            tetromino.turn(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position if turn from 3-turn-position next to right margin`() {
            // given
            val initTetrominoPosition = listOf(8 to -1, 8 to -2, 8 to -3, 9 to -2)
            val tetromino = Tetromino(TetrominoType.T, initTetrominoPosition, 3)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(7 to -2, 8 to -2, 9 to -2, 8 to -1)

            // when
            tetromino.turn(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position after moving right from origin position`() {
            // given
            val tetromino = Tetromino(TetrominoType.T)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(4 to -2, 5 to -2, 6 to -2, 5 to -1)

            // when
            tetromino.moveRight(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `do not move right if next to right margin`() {
            // given
            val initTetrominoPosition = listOf(7 to -2, 8 to -2, 9 to -2, 8 to -1)
            val tetromino = Tetromino(TetrominoType.T, initTetrominoPosition)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(7 to -2, 8 to -2, 9 to -2, 8 to -1)

            // when
            tetromino.moveRight(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position after moving left from origin position`() {
            // given
            val tetromino = Tetromino(TetrominoType.T)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(2 to -2, 3 to -2, 4 to -2, 3 to -1)

            // when
            tetromino.moveLeft(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `do not move left if next to left margin`() {
            // given
            val initTetrominoPosition = listOf(0 to -2, 1 to -2, 2 to -2, 1 to -1)
            val tetromino = Tetromino(TetrominoType.T, initTetrominoPosition)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(0 to -2, 1 to -2, 2 to -2, 1 to -1)

            // when
            tetromino.moveLeft(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `right position after moving down from origin position`() {
            // given
            val tetromino = Tetromino(TetrominoType.T)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(3 to -1, 4 to -1, 5 to -1, 4 to 0)

            // when
            tetromino.moveDown(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }

        @Test
        fun `do not move down if next to bottom margin`() {
            // given
            val initTetrominoPosition = listOf(3 to 18, 4 to 18, 5 to 18, 4 to 19)
            val tetromino = Tetromino(TetrominoType.T, initTetrominoPosition)
            val tetrion = Tetrion()
            tetrion.updateBoard(tetromino.position, TetrionCellState.MOVING_TETROMINO)
            val expectedPosition = listOf(3 to 18, 4 to 18, 5 to 18, 4 to 19)

            // when
            tetromino.moveDown(tetrion)

            // then
            assertThat(tetromino.position).isEqualTo(expectedPosition)
        }
    }

}
