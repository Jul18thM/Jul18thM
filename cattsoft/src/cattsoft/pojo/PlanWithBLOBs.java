package cattsoft.pojo;

public class PlanWithBLOBs extends Plan {
    private String planDescription;

    private String planFeedback;

    public String getPlanDescription() {
        return planDescription;
    }

    public void setPlanDescription(String planDescription) {
        this.planDescription = planDescription == null ? null : planDescription.trim();
    }

    public String getPlanFeedback() {
        return planFeedback;
    }

    public void setPlanFeedback(String planFeedback) {
        this.planFeedback = planFeedback == null ? null : planFeedback.trim();
    }
}