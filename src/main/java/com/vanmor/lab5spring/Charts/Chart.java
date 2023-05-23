package com.vanmor.lab5spring.Charts;

import com.vanmor.lab5spring.Function;
import org.jfree.chart.*;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.apache.commons.math3.analysis.interpolation.SplineInterpolator;
import org.apache.commons.math3.analysis.polynomials.PolynomialSplineFunction;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.data.general.Dataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.*;
import java.util.function.UnaryOperator;

public class Chart {

    public JFreeChart drawChart(double[][] points, double x, double result, int number) {

        XYSeries series = new XYSeries("Points");

        UnaryOperator<Double> f1 = Math::sqrt;

        UnaryOperator<Double> f3 = Math::sin;

        UnaryOperator<Double> f2 = (o) -> 2 * Math.pow(o, 2) + 3 * x - 2;


        double min = points[0][0];
        double max = points[0][points.length - 1];

        double minY = points[1][0];

        double maxY = points[1][points.length - 1];


        if (number == 1) {
            for (double i = min - 0.5; i <= max + 0.5; i += 0.1) {
                series.add(i, f1.apply(i));
            }
        } else if (number == 2) {
            for (double i = min - 0.5; i <= max + 0.5; i += 0.1) {
                series.add(i, f2.apply(i));
            }
        } else if (number == 3) {
            for (double i = min - 0.5; i <= max + 0.5; i += 0.1) {
                series.add(i, f3.apply(i));
            }
        } else {

        for (int i = 0; i < points[0].length; i++) {
            series.add(points[0][i], points[1][i]);
        }
    }


        XYDataset dataset = new XYSeriesCollection(series);

        JFreeChart lineChart = ChartFactory.createXYLineChart("Fi(x)", "x",
                "Y", dataset, PlotOrientation.VERTICAL,
                true, true, false);

        XYPlot plot = lineChart.getXYPlot();
        XYSplineRenderer renderer = new XYSplineRenderer();
        renderer.setPrecision(8);
        plot.setRenderer(renderer);


        plot.setDataset(dataset);

        renderer.setSeriesShapesVisible(0, false); // 0 - индекс серии данных

        return lineChart;
    }
}
