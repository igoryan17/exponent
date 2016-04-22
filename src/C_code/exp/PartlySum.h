//
// Created by igoryan on 01.04.16.
//

#ifndef EXP_PARTLYSUM_H
#define EXP_PARTLYSUM_H


#include <cmath>

class PartlySum {
public:
    PartlySum(int startNumber, int membersCount) : startNumber(startNumber), membersCount(membersCount) { }

    double calculate();

private:
    int startNumber;
    int membersCount;

    double member(int n) {
        if (n == 0) {
            return 1;
        }
    double res = 1;
        for (int i = 0; i < n; ++i) {
            res /= i + 1;
        }
    }
};


#endif //EXP_PARTLYSUM_H
