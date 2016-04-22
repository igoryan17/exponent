//
// Created by igoryan on 01.04.16.
//

#include "PartlySum.h"
double PartlySum::calculate() {
    double currentMember = member(startNumber);
    double sum = currentMember;
    for (int i = 1; i < membersCount; ++i) {
        currentMember /= startNumber + i;
        sum += currentMember;
    }
    return sum;
}