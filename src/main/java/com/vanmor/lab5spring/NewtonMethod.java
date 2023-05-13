package com.vanmor.lab5spring;

public class NewtonMethod {
    private double getDivider(int n, int index, double[][] points) {
        double divider = 1;
        for (int i = 0; i < n; i++) {
            if (i != index)
                divider *= points[0][index] - points[0][i];
        }
        return divider;
    }

    private double getF(double[][] points, int n) {
        double f = 0;
        for (int i = 0; i < n; i++) {
            f += points[1][i] / getDivider(n, i, points);
        }
        return f;
    }

    public Double getCountValue(double[][] points, double x) {
        double y = points[1][0];
        double cf = 1;
        for (int i = 2; i <= points[0].length; i++) {
            cf *= x - points[0][i - 2];
            y += cf * getF(points, i);
        }
        if (Double.isNaN(y) || Double.isInfinite(y)) {
            return null;
        }
        else {
            return y;
        }
    }

    public double[][] interpolation(double[][] points) {
        Function function = new Function();
        double result[][] = new double[points[0].length][points[0].length + 1];
        for (int i = 0; i < points[0].length; i++) {
            result[i][0] = points[0][i];
            result[i][1] = points[1][i];
        }
        int countOfIterations = result.length - 1;
        for (int j = 1; j < points[0].length; j++) {
            for (int i = 0; i < countOfIterations; i++) {
                result[i][j + 1] = result[i + 1][j] - result[i][j];
            }
            countOfIterations--;
        }

        if (function.checkNanTable(result)) {
            return result;
        }
        else {
            return null;
        }
    }

}
