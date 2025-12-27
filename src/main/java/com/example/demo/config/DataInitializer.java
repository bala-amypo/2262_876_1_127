package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.entity.PriorityRule;
import com.example.demo.repository.PriorityRuleRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private PriorityRuleRepository priorityRuleRepository;

    @Override
    public void run(String... args) throws Exception {
        // Initialize priority rules
        if (priorityRuleRepository.count() == 0) {
            PriorityRule rule1 = new PriorityRule();
            rule1.setRuleName("High Severity Rule");
            rule1.setCategory("Technical");
            rule1.setDescription("High priority for technical issues");
            rule1.setBaseScore(80);
            rule1.setWeight(1.5);
            rule1.setActive(true);
            priorityRuleRepository.save(rule1);

            PriorityRule rule2 = new PriorityRule();
            rule2.setRuleName("Billing Priority");
            rule2.setCategory("Billing");
            rule2.setDescription("Medium priority for billing issues");
            rule2.setBaseScore(60);
            rule2.setWeight(1.2);
            rule2.setActive(true);
            priorityRuleRepository.save(rule2);

            PriorityRule rule3 = new PriorityRule();
            rule3.setRuleName("General Inquiry");
            rule3.setCategory("General");
            rule3.setDescription("Low priority for general inquiries");
            rule3.setBaseScore(30);
            rule3.setWeight(1.0);
            rule3.setActive(true);
            priorityRuleRepository.save(rule3);
        }
    }
}