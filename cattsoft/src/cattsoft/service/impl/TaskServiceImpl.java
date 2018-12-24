package cattsoft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cattsoft.mapper.TaskMapper;
import cattsoft.pojo.Task;
import cattsoft.pojo.TaskVo;
import cattsoft.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskMapper taskMapper;

    public List<Task> taskList(String emp_id) {
        return taskMapper.taskList(emp_id);
    }

    public int taskCount(String emp_id) {
        return taskMapper.taskCount(emp_id);
    }

    public Task taskDetail(int id) {
        return taskMapper.taskDetail(id);
    }

    public TaskVo getDetail(int id) {
        return taskMapper.getDetail(id);
    }

    // 制定任务
    public int addTask(String task_name, String task_begin_time, String task_end_time, String task_state,
            String staff_id, String emp_id, String task_description) {
        return taskMapper.addTask(task_name, task_begin_time, task_end_time, task_state, staff_id, emp_id,
                task_description);
    }

    public List<TaskVo> unDoTask(String emp_id, String state) {
        return taskMapper.unDoTask(emp_id, state);
    }

    public List<TaskVo> doingTask(String emp_id, String state) {
        return taskMapper.doingTask(emp_id, state);
    }

    // 根据id删除任务
    public int deleteByPrimaryKey(Integer id) {
        return taskMapper.deleteByPrimaryKey(id);
    }

    // 调整未实施任务
    public int updateUnDoPlanById(Integer id, String task_name, String task_begin_time, String taskEndTime,
            String staff_id, String task_description) {
        return taskMapper.updateUnDoPlanById(id, task_name, task_begin_time, taskEndTime, staff_id, task_description);
    }

    // 根据员工用户名查询taskLlist
    public List<TaskVo> getListByStaffId(String staff_id) {
        return taskMapper.getListByStaffId(staff_id);
    };

    // 根据staff_id获取task数量
    public int getTaskCountByStaffId(String staff_id) {
        return taskMapper.getTaskCountByStaffId(staff_id);
    };
}
