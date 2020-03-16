package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MathController {

    //            /add/3/and/4	7
@GetMapping("add/{num1}/and/{num2}")
@ResponseBody

public int add(@PathVariable int num1, @PathVariable int num2 ) {
    return num1 + num2;
}


//            /subtract/3/from/10	7
@GetMapping("/subtract/{num1}/from/{num2}")
@ResponseBody
public int subtract(@PathVariable int num1, @PathVariable int num2) {
    return num2 - num1;
}

//            /multiply/4/and/5	20
@GetMapping("/multiply/{num1}/and{num2}")
@ResponseBody
public int multiply(@PathVariable int num1, @PathVariable int num2) {
    return num1 * num2;
}

//            /divide/6/by/3	2
    @GetMapping("/divide/{num1}/by/{num2}")
    @ResponseBody
    public double divide(@PathVariable int num1, @PathVariable int num2) {
    return (double) num1 / num2;
    }

}
