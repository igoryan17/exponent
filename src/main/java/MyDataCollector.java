import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by igoryan on 01.04.16.
 */
public class MyDataCollector extends DataCollector {
    public final String EXECUTE_FILE_PATH = " src/C_code/exp/bin/exp ";
    public static final String MPI_COMMAND = "mpirun -np ";
    public final int membersCount;
    public static final int points = 20;

    public MyDataCollector(int countTests, int membersCount) {
        super(countTests);
        this.membersCount = membersCount;
        countProcesses = new int[points];
        for (int i = 0; i < countProcesses.length; ++i) {
            countProcesses[i] = i + 1;
        }
    }

    protected double getValueFromSeries(double[] values) {
        double sum = 0;
        for (int i = 0; i < values.length; ++i) {
            sum += values[i];
        }
        return sum / (double) values.length;
    }

    protected double parseOutput(String s) {
        return Double.parseDouble(s);
    }

    protected String getCommandToExperiments(int processesCount) {
        return MPI_COMMAND + Integer.toString(processesCount) + EXECUTE_FILE_PATH + Integer.toString(membersCount);
    }

    protected double getResultFromString(String out) {
        return Double.parseDouble(out);
    }
}
