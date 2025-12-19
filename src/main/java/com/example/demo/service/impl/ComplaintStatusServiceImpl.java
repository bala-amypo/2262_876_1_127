package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import java.util.*;
import com.example.demo.repository.ComplaintStatusRepository;
import com.example.demo.service.ComplaintStatusService;
import com.example.demo.entity.ComplaintStatus;

@Service
public class ComplaintStatusServiceImpl implements ComplaintStatusService{
    @Autowired
    ComplaintStatusRepository repo;

    public ComplaintStatus getComplaintStatus(Long id){
        return repo.findById(id).orElseThrow();
    }
}