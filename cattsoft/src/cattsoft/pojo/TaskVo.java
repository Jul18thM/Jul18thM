package cattsoft.pojo;

public class TaskVo extends Task {
    private Emp emp;

    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }

    @Override
    public String toString() {
        return "TaskVo [emp=" + emp + ", getId()=" + getId() + ", getTaskName()=" + getTaskName()
                + ", getTaskBeginTime()=" + getTaskBeginTime() + ", getTaskEndTime()=" + getTaskEndTime()
                + ", getTaskState()=" + getTaskState() + ", getStaffId()=" + getStaffId() + ", getEmpId()=" + getEmpId()
                + ", getTaskDescription()=" + getTaskDescription() + "]";
    }
    
}
