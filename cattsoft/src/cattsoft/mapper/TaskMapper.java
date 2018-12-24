package cattsoft.mapper;

import cattsoft.pojo.Task;
import cattsoft.pojo.TaskExample;
import cattsoft.pojo.TaskVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TaskMapper {
    long countByExample(TaskExample example);

    int deleteByExample(TaskExample example);

    // 根据id删除任务
    int deleteByPrimaryKey(Integer id);

    // 制定任务
    int addTask(String task_name, String task_begin_time, String task_end_time, String task_state, String staff_id,
            String emp_id, String task_description);

    int insertSelective(Task record);

    List<Task> selectByExampleWithBLOBs(TaskExample example);

    List<Task> selectByExample(TaskExample example);

    Task selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Task record, @Param("example") TaskExample example);

    int updateByExampleWithBLOBs(@Param("record") Task record, @Param("example") TaskExample example);

    int updateByExample(@Param("record") Task record, @Param("example") TaskExample example);

    int updateByPrimaryKeySelective(Task record);

    int updateByPrimaryKeyWithBLOBs(Task record);

    int updateByPrimaryKey(Task record);

    int taskCount(String emp_id);

    // 根据主管username获取任务列表
    List<Task> taskList(String emp_id);

    // 根据id获取任务详情
    Task taskDetail(int id);

    // 根据id获取任务详情
    TaskVo getDetail(int id);

    List<TaskVo> unDoTask(String emp_id, String state);

    List<TaskVo> doingTask(String emp_id, String state);

    // 调整未实施任务
    int updateUnDoPlanById(Integer id, String task_name, String task_begin_time, String taskEndTime, String staff_id,
            String task_description);
    
    //根据员工用户名查询taskLlist
    List<TaskVo> getListByStaffId(String staff_id);
    
    //根据staff_id获取task数量
    int getTaskCountByStaffId(String staff_id);
}