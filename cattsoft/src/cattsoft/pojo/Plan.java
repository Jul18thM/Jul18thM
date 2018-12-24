package cattsoft.pojo;

import java.util.Date;

public class Plan {
    private Integer id;

    private String planName;

    private String planState;

    private String feedback;

    private Date planBeginDate;

    private Date planEndDate;

    private Integer taskId;
    
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName == null ? null : planName.trim();
    }

    public String getPlanState() {
        return planState;
    }

    public void setPlanState(String planState) {
        this.planState = planState == null ? null : planState.trim();
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback == null ? null : feedback.trim();
    }

    public Date getPlanBeginDate() {
        return planBeginDate;
    }

    public void setPlanBeginDate(Date planBeginDate) {
        this.planBeginDate = planBeginDate;
    }

    public Date getPlanEndDate() {
        return planEndDate;
    }

    public void setPlanEndDate(Date planEndDate) {
        this.planEndDate = planEndDate;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }
}