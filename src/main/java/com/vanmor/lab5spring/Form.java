package com.vanmor.lab5spring;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;

@Getter
@Setter
public class Form {
    private ArrayList<Double> inputData;
    private double x;
    private int numberOfFunction;
    private int method;
}
