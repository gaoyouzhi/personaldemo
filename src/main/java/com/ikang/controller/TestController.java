package com.ikang.controller;

import com.ikang.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private RuleService ruleService;

    @GetMapping("/showRules")
    public String showRules(){
        return ruleService.firstRule();
    }

    @GetMapping("/testBoot")
    public String testBoot(){
        return "123456";
    }

}
