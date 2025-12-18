package com.example.demo.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController("/complaints")
public class ComplaintController{

    @PostMapping("/submit")
    public Complaint submitComplaint(@RequestBody )
}
