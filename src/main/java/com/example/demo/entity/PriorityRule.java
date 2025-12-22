@Entity
public class PriorityRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    private String category;
    private String description;
    private String rulename;

    private int baseScore;
    private int weight;

    @Column(nullable = false)
    private boolean active;

    @PrePersist
    public void onCreate() {
        this.active = true;
        if (this.weight == 0) {
            this.weight = 1;
        }
    }

    public Long getId() { return id; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getRulename() { return rulename; }
    public void setRulename(String rulename) { this.rulename = rulename; }

    public int getBaseScore() { return baseScore; }
    public void setBaseScore(int baseScore) { this.baseScore = baseScore; }

    public int getWeight() { return weight; }
    public void setWeight(int weight) { this.weight = weight; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public PriorityRule() {
        this.baseScore = 10;
    }

    public PriorityRule(String category, String description,
                        String rulename, int baseScore, int weight) {
        this.category = category;
        this.description = description;
        this.rulename = rulename;
        this.baseScore = baseScore;
        this.weight = weight;
        this.active = true;
    }
}
