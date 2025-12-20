package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.example.demo.entity.Complaint;
import com.example.demo.entity.Complaint;
import com.example.demo.entity.User;
import java.util.List;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
    List<Complaint> findByUserId(Long userId);
    List<Complaint> findByCustomer(User user);
List<Complaint> findAllByOrderByPriorityScoreDescSubmittedOnAsc();

    
}
