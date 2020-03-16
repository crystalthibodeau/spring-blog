package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
class HelloController {

    @GetMapping("/hello") //url/hello ========= //same as doGet method in servlet -- no extends http needed
    @ResponseBody
    public String hello() {
        return "Hello from Spring!";
    }


//    @GetMapping("/hello/{name}")
//    @ResponseBody
//    public String sayHello(@PathVariable String name ){
//        return "Hello " + name ;
//        //cannot include ? on url for part of name. ? = start of new query
//        //# does not read anything after
//        //spaces are readable but replaced with %20 in url
//        //%40 == @ in url
//    }

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
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

    @GetMapping("/join")
    public String showJoinForm() {
        return "join";
    }

    @PostMapping("/join")
    public String joinCohort(@RequestParam(name = "cohort") String cohort, Model model) {
        model.addAttribute("cohort", "Welcome to " + cohort + "!");
        return "join";
    }

    @GetMapping("/fruit")
    public String fruit(Model model){
        List<String> fruitBasket = new ArrayList<>();
        fruitBasket.add("apple");
        fruitBasket.add("kiwi");
        fruitBasket.add("pear");
        fruitBasket.add("mango");
        fruitBasket.add("watermelon");
        fruitBasket.add("grapes");
        fruitBasket.add("starfruit");
        fruitBasket.add("papaya");
        fruitBasket.add("japanese pear");
        fruitBasket.add("pineapple");
        fruitBasket.add("lemon");
        fruitBasket.add("jackfruit");
        model.addAttribute("fruitBasket", fruitBasket);

        return "fruit";




    }
}