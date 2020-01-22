package model.tetromino

import model.Tetrion
import model.TetrionCellState

// TODO: Learn about accessibility of classes like protected, sealed and so on.. to make this class not visible outside the package 'tetromino'
class TurnControl(tetrominoType: TetrominoType) {

    private val turnable = Turnable.getInstance(tetrominoType)

    fun performTurn(turnCounter: Int, tetromino: Tetromino, tetrion: Tetrion) {
        var newPosition = turnable.execute(turnCounter, tetromino.position)

        val rules = Rules()
        // perform validation
        val brokenRuleSolution = rules.margin(newPosition)
        var counter = 0

        while (rules.validateAll(newPosition) && counter < 3) {
            brokenRuleSolution.behaviour(tetromino, tetrion)
            newPosition = turnable.execute(turnCounter, tetromino.position).toMutableList()
            counter++
        }

        // if validation OK - perform turn
        tetrion.eraseOldTetrominoPosition(tetromino)
        tetromino.position = newPosition
        tetrion.setNewTetrominoPosition(tetromino)
    }

}

abstract class Rule {

    abstract val behaviour: (tetromino: Tetromino, tetrion: Tetrion) -> Unit

    companion object {
        // TODO: The numbers shouldn't be hardcoded. Move to constants
        val isBlockBehindLeftMargin: (Pair<Int, Int>) -> Boolean =
            { blockNewPos -> blockNewPos.first < 0 }

        val isBlockBehindRightMargin: (Pair<Int, Int>) -> Boolean =
            { blockNewPos -> blockNewPos.first > Tetrion.WIDTH - 1 }

        val isBlockBehindBottomMargin: (Pair<Int, Int>) -> Boolean =
            { blockNewPos -> blockNewPos.second >= Tetrion.HEIGHT - Tetrion.TOP_MARGIN_HEIGHT }

        val isTetrominoOnOccupiedField: (Pair<Int, Int>, List<MutableList<TetrionCellState>>) -> Boolean =
            { blockNewPos, board -> TetrionCellState.FROZEN_TETROMINO == board[blockNewPos.first][blockNewPos.second] }

        val isOccupiedOnRight: (Int, Pair<Int, Int>, List<Pair<Int, Int>>) -> Boolean =
            { idx, blockNewPos, oldPostion -> oldPostion[idx].first < blockNewPos.first }

        val isOccupiedOnLeft: (Int, Pair<Int, Int>, List<Pair<Int, Int>>) -> Boolean =
            { idx, blockNewPos, oldPostion -> oldPostion[idx].first > blockNewPos.first }
    }

}

class NotBrokenRule : Rule() {

    override val behaviour: (tetromino: Tetromino, tetrion: Tetrion) -> Unit
        get() = { tetromino, _ -> tetromino.dontMove() }
}

class BehindLeftMarginRule : Rule() {

    override val behaviour: (tetromino: Tetromino, tetrion: Tetrion) -> Unit
        get() = { tetromino, tetrion -> tetromino.moveRight(tetrion) }
}

class BehindRightMarginRule : Rule() {

    override val behaviour: (tetromino: Tetromino, tetrion: Tetrion) -> Unit
        get() = { tetromino, tetrion -> tetromino.moveLeft(tetrion) }
}

class BehindBottomMarginRule : Rule() {
    override val behaviour: (tetromino: Tetromino, tetrion: Tetrion) -> Unit
        get() = { tetromino, tetrion -> tetromino.moveUp(tetrion) }
}

class OnOccupiedFieldOnLeftRule : Rule() {

    override val behaviour: (tetromino: Tetromino, tetrion: Tetrion) -> Unit
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
}

class OnOccupiedFieldOnRightRule : Rule() {

    override val behaviour: (tetromino: Tetromino, tetrion: Tetrion) -> Unit
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
}

class OnOccupiedFieldUnderRule : Rule() {

    override val behaviour: (tetromino: Tetromino, tetrion: Tetrion) -> Unit
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
}


class Rules {

    fun margin(newPosition: MutableList<Pair<Int, Int>>): Rule {

        for (item in newPosition) {
            when {
                Rule.isBlockBehindLeftMargin(item) -> return BehindLeftMarginRule()
                Rule.isBlockBehindRightMargin(item) -> return BehindRightMarginRule()
                Rule.isBlockBehindBottomMargin(item) -> return BehindBottomMarginRule()
            }
        }
        return NotBrokenRule()
    }

    fun onFrozen(
        oldPosition: MutableList<Pair<Int, Int>>,
        newPosition: MutableList<Pair<Int, Int>>,
        tetrion: Tetrion
    ): Rule {

        for ((index, item) in newPosition.withIndex()) {
            if (Rule.isTetrominoOnOccupiedField(item, tetrion.board))
                when {
                    Rule.isOccupiedOnLeft(index, item, oldPosition) -> return OnOccupiedFieldOnLeftRule()
                    Rule.isOccupiedOnRight(index, item, oldPosition) -> return OnOccupiedFieldOnRightRule()
                    // TODO: isOccupied
                }
        }
        return NotBrokenRule()
    }


    fun validateAll(newPosition: MutableList<Pair<Int, Int>>) = newPosition
        .stream()
        .anyMatch {
            Rule.isBlockBehindLeftMargin(it)
                    || Rule.isBlockBehindRightMargin(it)
                    || Rule.isBlockBehindBottomMargin(it)
        }
}


