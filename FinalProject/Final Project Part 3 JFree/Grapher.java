import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Grapher {
    public void graphQuadratic(double lower, double upper, double increment, String outputName) {
        XYSeries series = new XYSeries(outputName);
        PolynomialFunction formula = new PolynomialFunction(new double[]{3, -4, 1}); // y = x^2 - 4x + 3

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputName + ".csv"))) {
            writer.write("x,y\n");
            for (double x = lower; x <= upper; x += increment) {
                double y = formula.value(x);
                writer.write(x + "," + y + "\n");
                series.add(x, y);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        XYSeriesCollection dataset = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory.createXYLineChart(outputName, "X", "Y", dataset);
        try {
            ChartUtils.saveChartAsPNG(new File(outputName + ".png"), chart, 800, 600);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void graphSine(double lower, double upper, double increment, String outputName) {
        XYSeries series = new XYSeries(outputName);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputName + ".csv"))) {
            writer.write("x,y\n");
            for (double x = lower; x <= upper; x += increment) {
                double y = -2 * Math.sin(x) + 1;
                writer.write(x + "," + y + "\n");
                series.add(x, y);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        XYSeriesCollection dataset = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory.createXYLineChart(outputName, "X", "Y", dataset);
        try {
            ChartUtils.saveChartAsPNG(new File(outputName + ".png"), chart, 800, 600);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void graphAbsolute(double lower, double upper, double increment, String outputName) {
        XYSeries series = new XYSeries(outputName);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputName + ".csv"))) {
            writer.write("x,y\n");
            for (double x = lower; x <= upper; x += increment) {
                double y = Math.abs(x) - 2;
                writer.write(x + "," + y + "\n");
                series.add(x, y);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        XYSeriesCollection dataset = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory.createXYLineChart(outputName, "X", "Y", dataset);
        try {
            ChartUtils.saveChartAsPNG(new File(outputName + ".png"), chart, 800, 600);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
