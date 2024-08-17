
import kotlin.math.min

class Solution {

    private lateinit var matrix: Array<IntArray>
    private var rows = 0
    private var columns = 0

    fun minFlips(matrix: Array<IntArray>): Int {
        this.matrix = matrix
        rows = matrix.size
        columns = matrix[0].size
        if (rows == 0 || columns == 0) {
            return 0
        }

        val horizontal = true
        return min(countFlips(horizontal), countFlips(!horizontal))
    }

    private fun countFlips(horizontal: Boolean): Int {
        var numberOfFlips = 0
        val endAxisOne = if (horizontal) rows else columns
        val endAxisTwo = if (horizontal) columns else rows

        for (pivot in 0..<endAxisOne) {
            var indexOne = 0
            var indexTwo = endAxisTwo - 1
            while (indexOne < indexTwo) {
                numberOfFlips += getData(pivot, indexOne, horizontal) xor getData(pivot, indexTwo, horizontal)
                ++indexOne
                --indexTwo
            }
        }
        return numberOfFlips
    }

    private fun getData(indexOne: Int, indexTwo: Int, horizontal: Boolean): Int {
        return if (horizontal) matrix[indexOne][indexTwo] else matrix[indexTwo][indexOne]
    }
}
