package model.tetromino

abstract class Turnable {
    companion object {
        fun getInstance(tetrominoType: TetrominoType): Turnable =
            when (tetrominoType) {
                TetrominoType.I -> ITurnable()
                TetrominoType.T -> TTurnable()
                TetrominoType.O -> OTurnable()
                TetrominoType.L -> LTurnable()
                TetrominoType.J -> JTurnable()
                TetrominoType.S -> STurnable()
                TetrominoType.Z -> ZTurnable()
            }
    }

    protected abstract val turnDirSigns: MutableList<Pair<Int, Int>>

    abstract fun execute(turnCounter: Int, oldPosition: List<Pair<Int, Int>>, newPosition: MutableList<Pair<Int, Int>>)
}

class ZTurnable : Turnable() {
    override val turnDirSigns: MutableList<Pair<Int, Int>>
        get() = mutableListOf(
            2 to -1, 0 to 2, -2 to 0, 0 to -1,
            1 to 0, -1 to 1, -1 to -1, 1 to 0,
            0 to -1, 0 to 0, 0 to 0, 0 to 1,
            -1 to 0, -1 to -1, 1 to -1, 1 to 2
        )

    override fun execute(
        turnCounter: Int,
        oldPosition: List<Pair<Int, Int>>,
        newPosition: MutableList<Pair<Int, Int>>
    ) {

        for (i in oldPosition.indices) {
            val signs = turnDirSigns[i.times(4).plus(turnCounter)]
            newPosition.add(
                i,
                (oldPosition[i].first + signs.first) to (oldPosition[i].second + signs.second)
            )
        }

    }
}

class STurnable : Turnable() {
    override val turnDirSigns: MutableList<Pair<Int, Int>>
        get() = mutableListOf(
            1 to 1, -1 to 1, -1 to -1, 1 to -1,
            0 to 2, -2 to 0, 0 to -2, 2 to 0,
            1 to -1, 1 to 1, -1 to 1, -1 to -1
        )

    override fun execute(
        turnCounter: Int,
        oldPosition: List<Pair<Int, Int>>,
        newPosition: MutableList<Pair<Int, Int>>
    ) {

        for (i in oldPosition.indices) {
            if (i == 3) {
                newPosition.add(i, oldPosition[i].copy())
                continue
            }

            val signs = turnDirSigns[i.times(4).plus(turnCounter)]
            newPosition.add(
                i,
                (oldPosition[i].first + signs.first) to (oldPosition[i].second + signs.second)
            )
        }

    }
}

class JTurnable : Turnable() {
    override val turnDirSigns: MutableList<Pair<Int, Int>>
        get() = mutableListOf(
            1 to 1, -1 to 1, -1 to -1, 1 to -1,
            0 to -2, 2 to 0, 0 to 2, -2 to 0
        )

    override fun execute(
        turnCounter: Int,
        oldPosition: List<Pair<Int, Int>>,
        newPosition: MutableList<Pair<Int, Int>>
    ) {

        for (i in oldPosition.indices) {
            if (i == 1) {
                newPosition.add(i, oldPosition[i].copy())
                continue
            }

            val idx = when (i) {
                0 -> i.plus(turnCounter)
                2 -> i.times(2).plus(turnCounter)
                else -> i.minus(1).plus(turnCounter).rem(4)
            }
            val signs = turnDirSigns[idx]
            newPosition.add(
                i,
                (oldPosition[i].first + signs.first) to (oldPosition[i].second + signs.second)
            )
        }

    }
}

class LTurnable : Turnable() {
    override val turnDirSigns: MutableList<Pair<Int, Int>>
        get() = mutableListOf(
            1 to 1, -1 to 1, -1 to -1, 1 to -1,
            -2 to 0, 0 to -2, 2 to 0, 0 to 2
        )

    override fun execute(
        turnCounter: Int,
        oldPosition: List<Pair<Int, Int>>,
        newPosition: MutableList<Pair<Int, Int>>
    ) {

        for (i in oldPosition.indices) {
            if (i == 1) {
                newPosition.add(i, oldPosition[i].copy())
                continue
            }

            val idx = if (i == 3) i.plus(turnCounter.plus(1)) else i.plus(turnCounter).rem(4)
            val signs = turnDirSigns[idx]
            newPosition.add(
                i,
                (oldPosition[i].first + signs.first) to (oldPosition[i].second + signs.second)
            )
        }

    }
}

class OTurnable : Turnable() {
    override val turnDirSigns: MutableList<Pair<Int, Int>>
        get() = mutableListOf()

    override fun execute(
        turnCounter: Int,
        oldPosition: List<Pair<Int, Int>>,
        newPosition: MutableList<Pair<Int, Int>>
    ) {
        oldPosition.forEach { newPosition.add(it) }
    }
}

class TTurnable : Turnable() {
    override val turnDirSigns: MutableList<Pair<Int, Int>>
        get() = mutableListOf(1 to -1, 1 to 1, -1 to 1, -1 to -1)

    override fun execute(
        turnCounter: Int,
        oldPosition: List<Pair<Int, Int>>,
        newPosition: MutableList<Pair<Int, Int>>
    ) {

        for (i in oldPosition.indices) {
            if (i == 1) {
                newPosition.add(i, oldPosition[i].copy())
                continue
            }

            val signs = turnDirSigns[i.plus(turnCounter).rem(4)]
            newPosition.add(
                i,
                (oldPosition[i].first + signs.first) to (oldPosition[i].second + signs.second)
            )

        }
    }
}

class ITurnable : Turnable() {

    override val turnDirSigns: MutableList<Pair<Int, Int>>
        get() = mutableListOf(
            1 to 2, -2 to 1, -1 to -2, 2 to -1,
            0 to 1, -1 to 0, 0 to -1, 1 to 0,
            -2 to -1, 1 to -2, 2 to 1, -1 to 2
        )

    override fun execute(
        turnCounter: Int,
        oldPosition: List<Pair<Int, Int>>,
        newPosition: MutableList<Pair<Int, Int>>
    ) {

        for (i in oldPosition.indices) {
            val idx = when (i) {
                0 -> i.plus(turnCounter)
                3 -> i.times(3).minus(1).plus(turnCounter)
                else -> i.plus(turnCounter - 1).rem(4).plus(4)
            }
            val signs = turnDirSigns[idx]
            newPosition.add(
                i,
                (oldPosition[i].first + signs.first) to (oldPosition[i].second + signs.second)
            )
        }

    }
}
