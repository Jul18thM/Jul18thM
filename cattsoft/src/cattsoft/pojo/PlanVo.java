package cattsoft.pojo;

public class PlanVo extends Plan {
    private Task task;

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return "PlanVo [task=" + task + ", getPlanDescription()=" + getPlanDescription() + ", getPlanFeedback()="
                + getPlanFeedback() + ", getId()=" + getId() + ", getPlanName()=" + getPlanName() + ", getPlanState()="
                + getPlanState() + ", getFeedback()=" + getFeedback() + ", getPlanBeginDate()=" + getPlanBeginDate()
                + ", getPlanEndDate()=" + getPlanEndDate() + ", getTaskId()=" + getTaskId() + "]";
    }
    
}
