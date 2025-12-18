package com.example.demo.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/rules")

public class PriorityRuleController{
    @Autowired
    PriorityRuleService service;

    @GetMapping("/all")
    public List<PriorityRule> getAllRules(){
        return service.getAllRules();
    }
}
