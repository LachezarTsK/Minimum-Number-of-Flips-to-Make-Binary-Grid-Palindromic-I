
public class Solution {

    private int[][] matrix;
    private int rows;
    private int columns;

    public int minFlips(int[][] matrix) {
        this.matrix = matrix;
        rows = matrix.length;
        columns = matrix[0].length;
        if (rows == 0 || columns == 0) {
            return 0;
        }

        boolean horizontal = true;
        return Math.min(countFlips(horizontal), countFlips(!horizontal));
    }

    private int countFlips(boolean horizontal) {
        int numberOfFlips = 0;
        int endAxisOne = horizontal ? rows : columns;
        int endAxisTwo = horizontal ? columns : rows;

        for (int pivot = 0; pivot < endAxisOne; ++pivot) {
            int indexOne = 0;
            int indexTwo = endAxisTwo - 1;
            while (indexOne < indexTwo) {
                numberOfFlips += getData(pivot, indexOne, horizontal) ^ getData(pivot, indexTwo, horizontal);
                ++indexOne;
                --indexTwo;
            }
        }
        return numberOfFlips;
    }

    private int getData(int indexOne, int indexTwo, boolean horizontal) {
        return horizontal ? matrix[indexOne][indexTwo] : matrix[indexTwo][indexOne];
    }
}
