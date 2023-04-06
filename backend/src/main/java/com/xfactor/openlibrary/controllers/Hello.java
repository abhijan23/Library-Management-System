package com.xfactor.openlibrary.controllers;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    @GetMapping("/hello")
    public String hello(@RequestParam String name, @RequestParam int num, @RequestParam double n1, @RequestParam double n2, @RequestParam char ch) {

        return "Hello "+name+"!! "+ num + "Sum=" + (n1+n2)+ " "+ch;
    }
    @GetMapping("/hi/{name}/{clg_name}/{roll}")
    public String hi(@PathVariable String name , @PathVariable char clg_name, @PathVariable int roll){
        return "Hi "+name+"!!" + clg_name + roll;
    }
    @GetMapping("/mixed/{name}/{clg_name}/{roll}")
    public String mixed(@PathVariable String name , @PathVariable char clg_name, @PathVariable int roll, @RequestParam double percentage){
        return "Hi "+name+"!!" + clg_name + roll+percentage;
    }
    @GetMapping("/json/{name}/{age}")
    public HashMap<String, String> json(@PathVariable String name, @PathVariable int age){
        HashMap<String, String> HM = new HashMap<>();
        HM.put("name", name);
        HM.put("age", String.valueOf(age));
        return HM;
    }
}
