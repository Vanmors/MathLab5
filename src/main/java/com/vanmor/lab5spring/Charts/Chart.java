package com.vanmor.lab5spring.Charts;

import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Chart {

    public JFreeChart drawChart(double[][] points, double x, double result) {

        XYSeries series = new XYSeries("Points");
        XYSeries series1 = new XYSeries("lines");

        XYSeriesCollection dataset = new XYSeriesCollection();
        for (int i = 0; i < points[0].length; i++) {
            series.add(points[0][i], points[1][i]);
        }
        series.add(x, result);

        dataset.addSeries(series);
//        for (int i = 0; i < points[0].length; i++) {
//            series1.add(points[0][i], points[1][i]);
//        }
//
//        dataset.addSeries(series1);

        JFreeChart lineChart = ChartFactory.createXYLineChart("Fi(x)", "x",
                "Y", dataset, PlotOrientation.VERTICAL,
                true, true, false);


        XYPlot plot = (XYPlot) lineChart.getPlot();

        // Создаем экземпляр XYLineAndShapeRenderer
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

        // Устанавливаем форму отображения для первой серии данных в виде точек
//        renderer.setSeriesShapesVisible(0, true);

        // Устанавливаем форму отображения для второй серии данных в виде линий
//        renderer.setSeriesLinesVisible(1, true);

        // Устанавливаем форму отображения для второй серии данных в виде точек
//        renderer.setSeriesShapesVisible(1, false);

        // Устанавливаем renderer для XYPlot
        plot.setRenderer(renderer);

        return lineChart;
    }
}
