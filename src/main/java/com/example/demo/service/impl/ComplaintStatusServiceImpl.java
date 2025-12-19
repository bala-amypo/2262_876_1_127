package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import java.util.*;
import com.example.demo.repository.ComplaintStatusRepository;
import com.example.demo.service.ComplaintStatusService;
import com.example.demo.entity.ComplaintStatus;
import jakarta.persistence.*;

@Service
public class ComplaintStatusServiceImpl implements ComplaintStatusService{
    @Autowired
    ComplaintStatusRepository repo;

    public List<ComplaintStatus> getComplaintStatus(Long id) {
        
    return repo.findByComplaintId(id)
            .orElseThrow(() ->
                new EntityNotFoundException("ComplaintStatus not found with id: " + id)
            );
    }

   // List<ComplaintStatus> findByComplaintId(Long complaintId){
//     List<ComplaintStatus> statuses =
//             repo.findByComplaintId(complaintId);

//     if (statuses.isEmpty()) {
//         throw new EntityNotFoundException(
//             "No status found for complaint id: " + complaintId
//         );
//     }

//     return statuses;
//    }

}
