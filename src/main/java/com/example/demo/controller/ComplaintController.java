package com.example.demo.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.demo.entity.Complaint;
import com.example.demo.service.ComplaintService;

@RestController
@RequestMapping("/complaints")
public class ComplaintController{

    @Autowired
    ComplaintService service;

    @PostMapping("/submit")
    public Complaint submitComplaint(@RequestBody Complaint complaint){
        return service.submitComplaint(complaint);
    }
}
