package cattsoft.service;

import java.util.List;

import cattsoft.pojo.Task;
import cattsoft.pojo.TaskVo;

public interface TaskService {
    List<Task> taskList(String emp_id);

    int taskCount(String emp_id);

    Task taskDetail(int id);

    TaskVo getDetail(int id);

    // 制定任务
    int addTask(String task_name, String task_begin_time, String task_end_time, String task_state, String staff_id,
            String emp_id, String task_description);

    List<TaskVo> unDoTask(String emp_id, String state);

    List<TaskVo> doingTask(String emp_id, String state);

    // 根据id删除任务
    int deleteByPrimaryKey(Integer id);

    // 调整未实施任务
    int updateUnDoPlanById(Integer id, String task_name, String task_begin_time, String taskEndTime, String staff_id,
            String task_description);

    // 根据员工用户名查询taskLlist
    List<TaskVo> getListByStaffId(String staff_id);

    // 根据staff_id获取task数量
    int getTaskCountByStaffId(String staff_id);
}
