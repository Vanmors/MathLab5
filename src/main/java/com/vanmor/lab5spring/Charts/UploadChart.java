package com.vanmor.lab5spring.Charts;

import com.vanmor.lab5spring.Form;
import jakarta.servlet.http.HttpServletResponse;
import org.jfree.chart.ChartRenderingInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import static org.jfree.chart.ChartUtils.writeChartAsJPEG;

@Controller
public class UploadChart {

    public static double[][] points;
    public static double x;
    public static Double result;
    public static int number;

    @GetMapping("/chart")
    public void handleChart(HttpServletResponse response, Form form, Model model) throws IOException {
        response.setContentType("image/jpeg");
        model.addAttribute("form", form);
        OutputStream out = response.getOutputStream();
        Chart drawChart = new Chart();

        writeChartAsJPEG(out, drawChart.drawChart(points, x, result, number), 600, 600);

    }

}
