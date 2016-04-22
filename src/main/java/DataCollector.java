import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by igoryan on 01.04.16.
 */
public abstract class DataCollector {
    protected final int countTests;
    protected int[] countProcesses;

    protected DataCollector(int countTests) {
        this.countTests = countTests;
    }

    protected double makeExperiments(int proccesesCount) throws IOException {
        double[] values = new double[countTests];
        for (int i = 0; i < countTests; ++i) {
            String res = execute(getCommandToExperiments(countTests));
            values[i] = parseOutput(res);
        }
        return getValueFromSeries(values);
    }

    protected abstract double getValueFromSeries(double[] values);

    protected abstract double parseOutput(String s);

    protected abstract String getCommandToExperiments(int processesCount);

    protected abstract double getResultFromString(String out);

    public static String execute(String command) throws IOException {
        Process p = Runtime.getRuntime().exec(command);
        BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String out = stdInput.readLine();
        return out;
    }

    protected double[] makeBigExpirements() throws IOException {
        double[] times = new double[countProcesses.length];
        for (int i = 0; i < countProcesses.length; ++i) {
            times[i] = makeExperiments(countProcesses[i]);
        }
        return times;
    }

    public int[] getCountProcesses() {
        return countProcesses;
    }
}
