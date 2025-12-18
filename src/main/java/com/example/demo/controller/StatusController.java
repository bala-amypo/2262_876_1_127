package com.example.demo.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/status")
public class StatusController{

    @Autowired
    ComplaintStatusService service;

    @GetMapping("/history/{id}")
    public getComplaintStatus(@PathVariable long id){
        service.getComplaintStatus(id);
    }
}
