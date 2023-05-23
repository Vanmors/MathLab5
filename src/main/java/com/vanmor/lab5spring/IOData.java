package com.vanmor.lab5spring;


import com.vanmor.lab5spring.Charts.UploadChart;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class IOData {


    @GetMapping("/")
    public String welcomePage() {
        return "welcomePage";
    }

    @GetMapping("/data")
    public String input(Model model) {
        model.addAttribute("form", new Form());
        return "index";
    }

    @GetMapping("/func")
    public String function(Model model) {
        model.addAttribute("form", new Form());
        return "functions";
    }


    @GetMapping("/resultTable")
    public String outTable(@ModelAttribute Form form, Model model) {
        Function function = new Function();
        double[][] points = function.convertToArray(form.getInputData());
        LagrangeMethod lagrangeMethod = new LagrangeMethod();
        NewtonMethod newtonMethod = new NewtonMethod();
        newtonMethod.getCountValue(points, form.getX());
//        UploadChart.points = points;
        Double result = 0.0;
        UploadChart.points = points;
        UploadChart.x = form.getX();
        UploadChart.number = 0;

        if (form.getMethod() == 1) {
            result = lagrangeMethod.L(points, form.getX());
            model.addAttribute("result", result);
            model.addAttribute("resultTable", lagrangeMethod.interpolation(points));
        }
        else if (form.getMethod() == 2){
            result = newtonMethod.getCountValue(points, form.getX());
            model.addAttribute("result", result);
            model.addAttribute("resultTable", newtonMethod.interpolation(points));
        }
        else {
            model.addAttribute("result", null);
        }
        UploadChart.result = result;

        return "resultTable";
    }

    @GetMapping("/resultFunc")
    public String outFunc(@ModelAttribute Form form, Model model) {
        Function function = new Function();
        LagrangeMethod lagrangeMethod = new LagrangeMethod();
        NewtonMethod newtonMethod = new NewtonMethod();
        
        double[][] points = function.calculateFunc(form.getInputData(), form.getNumberOfFunction());
        double result = 0;
        UploadChart.points = points;
        UploadChart.x = form.getX();
        UploadChart.number = form.getNumberOfFunction();
        
        if (form.getMethod() == 1) {
            result = lagrangeMethod.L(points, form.getX());
            model.addAttribute("resultFunc", result);
            model.addAttribute("resultTable", lagrangeMethod.interpolation(points));
        }
        else if (form.getMethod() == 2){
            result = newtonMethod.getCountValue(points, form.getX());
            model.addAttribute("resultFunc", result);
            model.addAttribute("resultTable", newtonMethod.interpolation(points));
        }
        else {
            model.addAttribute("resultFunc", null);
        }
        UploadChart.result = result;
        
        return "resultFunction";
    }


}
