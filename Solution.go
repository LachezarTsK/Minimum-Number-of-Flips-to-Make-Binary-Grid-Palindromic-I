
package main

import "fmt"

var matrix [][]int
var rows int
var columns int

func minFlips(grid [][]int) int {
    matrix = grid
    rows = len(matrix)
    columns = len(matrix[0])
    if rows == 0 || columns == 0 {
        return 0
    }

    horizontal := true
    return min(countFlips(horizontal), countFlips(!horizontal))
}

func countFlips(horizontal bool) int {
    numberOfFlips := 0
    endAxisOne := Ternary(horizontal, rows, columns)
    endAxisTwo := Ternary(horizontal, columns, rows)

    for pivot := 0; pivot < endAxisOne; pivot++ {
        indexOne := 0
        indexTwo := endAxisTwo - 1
        for indexOne < indexTwo {
            numberOfFlips += getData(pivot, indexOne, horizontal) ^ getData(pivot, indexTwo, horizontal)
            indexOne++
            indexTwo--
        }
    }
    return numberOfFlips
}

func getData(indexOne int, indexTwo int, horizontal bool) int {
    if horizontal {
        return matrix[indexOne][indexTwo]
    }
    return matrix[indexTwo][indexOne]
}

func Ternary[T any](condition bool, first T, second T) T {
    if condition {
        return first
    }
    return second
}
