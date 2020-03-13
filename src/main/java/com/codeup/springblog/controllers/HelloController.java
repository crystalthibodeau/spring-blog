package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
class HelloController {

    @GetMapping("/hello") //url/hello ========= //same as doGet method in servlet -- no extends http needed
    @ResponseBody
    public String hello() {
        return "Hello from Spring!";
    }


    @GetMapping("/hello/{name}")
    @ResponseBody
    public String sayHello(@PathVariable String name ){
        return "Hello " + name ;
        //cannot include ? on url for part of name. ? = start of new query
        //# does not read anything after
        //spaces are readable but replaced with %20 in url
        //%40 == @ in url
    }

    @RequestMapping(path = "/increment/{number}", method = RequestMethod.GET)
    @ResponseBody
    public String addOne(@PathVariable int number) {
        return number + " plus one is " + (number + 1) + "!";
    }

    @GetMapping("/multiply/{number}/{number2}")
//    @RequestMapping(path = "/increment/{number}", method = RequestMethod.GET) //GetMapping alternative
    @ResponseBody
    public String multiplyTwoNumbers(@PathVariable int number, @PathVariable int number2) {
        return number + " multiplied by " + number2 + " is " + (number * number2) + "!";
    }
}