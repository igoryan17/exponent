import org.jfree.ui.RefineryUtilities;

import java.io.IOException;

/**
 * Created by igoryan on 02.04.16.
 */
public class App {
    public static void main(String[] args) throws IOException {
        DataCollector collector = new MyDataCollector(8, 100);
        Plotter plotter = new Plotter(collector.makeBigExpirements(), collector.getCountProcesses());
        plotter.pack();
        RefineryUtilities.centerFrameOnScreen(plotter);
        plotter.setVisible(true);
    }
}
