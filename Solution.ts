
function minFlips(matrix: number[][]): number {
    this.matrix = matrix;
    this.rows = matrix.length;
    this.columns = matrix[0].length;
    if (this.rows === 0 || this.columns === 0) {
        return 0;
    }

    let horizontal = true;
    return Math.min(countFlips(horizontal), countFlips(!horizontal));
};

function countFlips(horizontal: boolean): number {
    let numberOfFlips = 0;
    let endAxisOne = horizontal ? this.rows : this.columns;
    let endAxisTwo = horizontal ? this.columns : this.rows;

    for (let pivot = 0; pivot < endAxisOne; ++pivot) {
        let indexOne = 0;
        let indexTwo = endAxisTwo - 1;
        while (indexOne < indexTwo) {
            numberOfFlips += getData(pivot, indexOne, horizontal) ^ getData(pivot, indexTwo, horizontal);
            ++indexOne;
            --indexTwo;
        }
    }
    return numberOfFlips;
}

function getData(indexOne: number, indexTwo: number, horizontal: boolean): number {
    return horizontal ? this.matrix[indexOne][indexTwo] : this.matrix[indexTwo][indexOne];
}
