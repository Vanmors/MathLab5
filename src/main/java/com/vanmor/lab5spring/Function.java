package com.vanmor.lab5spring;

import java.util.ArrayList;

public class Function {

    public double f(double x, int number) {
        switch (number) {
            case (1) -> {
                return Math.sqrt(x);
            }
            case (2) -> {
                return Math.pow(x, 2) + 3 * x - 2;
            }
            case (3) -> {
                return Math.sin(x);
            }
        }
        return x;
    }


    public double[][] convertToArray(ArrayList<Double> inputData) {
        double[][] result = new double[2][inputData.size() / 2];
        for (int i = 0; i < inputData.size() / 2; i++) {
            result[0][i] = inputData.get(i);
        }
        int count = 0;
        for (int i = inputData.size() / 2; i < inputData.size(); i++) {
            result[1][count] = inputData.get(i);
            count++;
        }

        return result;
    }


    public double[][] calculateFunc(ArrayList<Double> inputData, int numberOfFunction) {
        double[][] result = new double[2][inputData.size()];
        for (int i = 0; i < inputData.size(); i++) {
            result[0][i] = inputData.get(i);
        }
        for (int i = 0; i < inputData.size(); i++) {
            result[1][i] = f(result[0][i], numberOfFunction);
        }

        return result;
    }

    public boolean checkNanTable(double[][] result) {
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                if (Double.isNaN(result[i][j]) || Double.isInfinite(result[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }


    public boolean checkDuplicates(double[][] points) {
        for (int i = 0; i < points[0].length - 1; i++) {
            for (int j = i + 1; j < points[0].length; j++) {
                if (points[0][i] == points[0][j]) {
                    return false;
                }
            }
        }
        return true;
    }

}
