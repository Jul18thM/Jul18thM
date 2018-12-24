package cattsoft.pojo;

import java.util.Date;

public class Task {
    private Integer id;

    private String task_name;

    private Date task_begin_time;

    private Date task_end_time;

    private String task_state;

    private String staff_id;

    private String emp_id;

    private String task_description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaskName() {
        return task_name;
    }

    public void setTaskName(String task_name) {
        this.task_name = task_name == null ? null : task_name.trim();
    }

    public Date getTaskBeginTime() {
        return task_begin_time;
    }

    public void setTaskBeginTime(Date task_begin_time) {
        this.task_begin_time = task_begin_time;
    }

    public Date getTaskEndTime() {
        return task_end_time;
    }

    public void setTaskEndTime(Date task_end_time) {
        this.task_end_time = task_end_time;
    }

    public String getTaskState() {
        return task_state;
    }

    public void setTaskState(String task_state) {
        this.task_state = task_state == null ? null : task_state.trim();
    }

    public String getStaffId() {
        return staff_id;
    }

    public void setStaffId(String staff_id) {
        this.staff_id = staff_id == null ? null : staff_id.trim();
    }

    public String getEmpId() {
        return emp_id;
    }

    public void setEmpId(String emp_id) {
        this.emp_id = emp_id == null ? null : emp_id.trim();
    }

    public String getTaskDescription() {
        return task_description;
    }

    public void setTaskDescription(String task_description) {
        this.task_description = task_description == null ? null : task_description.trim();
    }
}