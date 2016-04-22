#include <iostream>
#include <mpi.h>
#include <cmath>
#include <mutex>
#include "PartlySum.h"

int main(int argc, char *argv[]) {
    if (argc != 2) {
        return -1;
    }

    double start, end;
    double result;

    MPI::Init(argc, argv);
    const int membersCount = atoi(argv[1]);
    int size = 0;
    size = MPI::COMM_WORLD.Get_size();
    int rank = 0;
    rank = MPI::COMM_WORLD.Get_rank();

    if (rank == 0) {
        start = MPI::Wtime();
    }

    int membersInPart = membersCount / size;
    int startNumber = rank * membersInPart;
    if (rank == (size - 1)) {
        membersInPart = membersCount - startNumber;
    }

    PartlySum sumCalculator(startNumber, membersInPart);

    double res = sumCalculator.calculate();

    MPI::COMM_WORLD.Barrier();

/*    std::cout
    << "process " << rank
    << " calculate value " << res
    << " in start:" << startNumber
    << " count:" << membersInPart << std::endl;*/

    MPI::COMM_WORLD.Reduce(&res, &result, 1, MPI_DOUBLE, MPI_SUM, 0);
    end = MPI::Wtime();
    MPI::Finalize();
    if (rank == 0) {
        std::cout << end - start << std::endl;
        std::cout << "exp is " << result << std::endl;
    }
    return 0;
}

