package com.example.demo.service;

import com.example.demo.repository.ComplaintStatusRepository;
import java.util.*;

public interface ComplaintStatusService extends ComplaintStatusRepository{
    public getComplaintStatus(long id);
}