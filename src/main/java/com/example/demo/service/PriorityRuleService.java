public interface PriorityRuleService {

    List<PriorityRule> getAllRules();

    List<PriorityRule> getActiveRules();

    int calculatePriorityScore(Complaint complaint);
}
