
#include <vector>
#include <memory>
#include <algorithm>
using namespace std;

class Solution {

    unique_ptr< vector<vector<int>>> matrix;
    size_t rows{};
    size_t columns{};

public:
    int minFlips(const vector<vector<int>>& matrix) {
        this->matrix = make_unique< vector<vector<int>>>(matrix);
        rows = matrix.size();
        columns = matrix[0].size();
        if (rows == 0 || columns == 0) {
            return 0;
        }

        bool horizontal = true;
        return min(countFlips(horizontal), countFlips(!horizontal));
    }

private:
    int countFlips(bool horizontal) const {
        int numberOfFlips = 0;
        size_t endAxisOne = horizontal ? rows : columns;
        size_t endAxisTwo = horizontal ? columns : rows;

        for (size_t pivot = 0; pivot < endAxisOne; ++pivot) {
            size_t indexOne = 0;
            size_t indexTwo = endAxisTwo - 1;
            while (indexOne < indexTwo) {
                numberOfFlips += getData(pivot, indexOne, horizontal) ^ getData(pivot, indexTwo, horizontal);
                ++indexOne;
                --indexTwo;
            }
        }
        return numberOfFlips;
    }

    int getData(int indexOne, int indexTwo, bool horizontal) const {
        return horizontal ? (*matrix)[indexOne][indexTwo] : (*matrix)[indexTwo][indexOne];
    }
};
