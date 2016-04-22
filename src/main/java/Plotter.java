import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
/**
 * Created by igoryan on 02.04.16.
 */
public class Plotter extends ApplicationFrame {
    private double[] times;
    private int[] processes;

    public Plotter(double[] times, int[] processes) {
        super("the time dependence of the processes");
        this.times = times;
        this.processes = processes;
        JFreeChart lineChart = ChartFactory.createLineChart(
                "graph",
                "number processes",
                "time",
                createDataset(),
                PlotOrientation.VERTICAL,
                false, false, false);
        ChartPanel chartPanel = new ChartPanel(lineChart);
        setContentPane(chartPanel);
    }

    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < processes.length; ++i) {
            dataset.addValue(times[i], "seconds", Integer.toString(processes[i]));
        }
        return dataset;
    }
}
