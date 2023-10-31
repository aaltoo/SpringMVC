package ru.pavlov.springmvc.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {

        // System.out.println("Hello " + name + " " + surname);
        model.addAttribute("message", "Hello " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage() {
        return "first/goodbye";
    }

    public double calculate(double a, double b, String action) {
        switch (action) {
            case "multiplication":
                return a * b;
            case "addition":
                return a + b;
            case "subtraction":
                return a - b;
            case "division":
                return a / b;
            default:
                return 0;
        }
    }

    @GetMapping("/calculator")
    public String calculatorPage(@RequestParam("a") double a,
                                 @RequestParam("b") double b,
                                 @RequestParam("action") String action,
                                 Model model) {

        model.addAttribute("result", calculate(a, b, action));

        return "first/calculator";
    }
}
