package cattsoft.pojo;

import java.sql.Date;

public class PlanTimes extends Plan{
    private Date beginTimeStart;//开始任务的起始时间
    
    private Date beginTimeEnd;//开始任务的结束时间
    
    private Date EndTimeStart;//结束任务的起始时间
    
    private Date EndTimeEnd;//结束任务的结束时间

    public Date getBeginTimeStart() {
        return beginTimeStart;
    }

    public void setBeginTimeStart(Date beginTimeStart) {
        this.beginTimeStart = beginTimeStart;
    }

    public Date getBeginTimeEnd() {
        return beginTimeEnd;
    }

    public void setBeginTimeEnd(Date beginTimeEnd) {
        this.beginTimeEnd = beginTimeEnd;
    }

    public Date getEndTimeStart() {
        return EndTimeStart;
    }

    public void setEndTimeStart(Date endTimeStart) {
        EndTimeStart = endTimeStart;
    }

    public Date getEndTimeEnd() {
        return EndTimeEnd;
    }

    public void setEndTimeEnd(Date endTimeEnd) {
        EndTimeEnd = endTimeEnd;
    }
    
    
}
