
using System;

public class Solution
{
    private int[][]? matrix;
    private int rows;
    private int columns;

    public int MinFlips(int[][] matrix)
    {
        this.matrix = matrix;
        rows = matrix.Length;
        columns = matrix[0].Length;
        if (rows == 0 || columns == 0)
        {
            return 0;
        }

        bool horizontal = true;
        return Math.Min(CountFlips(horizontal), CountFlips(!horizontal));
    }

    private int CountFlips(bool horizontal)
    {
        int numberOfFlips = 0;
        int endAxisOne = horizontal ? rows : columns;
        int endAxisTwo = horizontal ? columns : rows;

        for (int pivot = 0; pivot < endAxisOne; ++pivot)
        {
            int indexOne = 0;
            int indexTwo = endAxisTwo - 1;
            while (indexOne < indexTwo)
            {
                numberOfFlips += GetData(pivot, indexOne, horizontal) ^ GetData(pivot, indexTwo, horizontal);
                ++indexOne;
                --indexTwo;
            }
        }
        return numberOfFlips;
    }

    private int GetData(int indexOne, int indexTwo, bool horizontal)
    {
        return horizontal ? matrix[indexOne][indexTwo] : matrix[indexTwo][indexOne];
    }
}
