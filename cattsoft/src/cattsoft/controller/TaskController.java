package cattsoft.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cattsoft.pojo.Task;
import cattsoft.pojo.TaskVo;
import cattsoft.service.TaskService;

@Controller
public class TaskController {
    @Autowired
    TaskService taskService;

    @RequestMapping(value = "/taskList")
    public ModelAndView taskList(@RequestParam("emp_id") String emp_id) {
        ModelAndView mav = new ModelAndView();
        int tc = taskService.taskCount(emp_id);
        List<Task> taskList = taskService.taskList(emp_id);
        mav.addObject("taskList", taskList);
        mav.addObject("tc", tc);
        mav.setViewName("task-list");
        return mav;
    }

    @RequestMapping(value = "/taskDetail")
    public ModelAndView taskDetail(@RequestParam("id") Integer id) {
        ModelAndView mav = new ModelAndView();
        TaskVo td = taskService.getDetail(id);
        String name = td.getEmp().getName();
        mav.addObject("name", name);
        mav.addObject("td", td);
        int task_id = td.getId();
        mav.setViewName("plans?task_id=" + task_id);
        return mav;
    }

    @RequestMapping(value = "/addTask")
    public ModelAndView addTask(@RequestParam("taskname") String task_name,
            @RequestParam("begintime") String task_begin_time, @RequestParam("endtime") String task_end_time,
            @RequestParam("type") String task_state, @RequestParam("staff_id") String staff_id,
            @RequestParam("emp_id") String emp_id, @RequestParam("details") String task_description) {
        ModelAndView mav = new ModelAndView();
        int i = taskService.addTask(task_name, task_begin_time, task_end_time, task_state, staff_id, emp_id,
                task_description);
        if (i == 1) {
            mav.setViewName("taskList?emp_id" + emp_id);
        } else {
            mav.addObject("msg", "新增任务失败");
            mav.addObject("tn", task_name);
            mav.addObject("td", task_description);
            mav.setViewName("task-add");
        }
        return mav;
    }

    @RequestMapping(value = "/unDoTask")
    public ModelAndView unDoTask(@RequestParam("emp_id") String emp_id) {
        ModelAndView mav = new ModelAndView();
        String state = "未实施";
        List<TaskVo> udt = taskService.unDoTask(emp_id, state);
        mav.addObject("udt", udt);
        mav.setViewName("task-update");
        return mav;
    }

    @RequestMapping(value = "udtDetail")
    public ModelAndView udtDetail(@RequestParam("id") Integer id) {
        ModelAndView mav = new ModelAndView();
        TaskVo td = taskService.getDetail(id);
        String name = td.getEmp().getName();
        mav.addObject("name", name);
        mav.addObject("td", td);
        mav.setViewName("task-doupdate");
        return mav;
    }

    @RequestMapping(value = "/doingTask")
    public ModelAndView doingTask(@RequestParam("emp_id") String emp_id) {
        ModelAndView mav = new ModelAndView();
        String state = "实施中";
        List<TaskVo> dt = taskService.doingTask(emp_id, state);
        mav.addObject("dc", dt.size());
        mav.addObject("dt", dt);
        mav.setViewName("task-track");
        return mav;
    }

    @RequestMapping(value = "/deleteTaskById")
    public ModelAndView deleteTaskById(@RequestParam("id") String ids, @RequestParam("emp_id") String emp_id) {
        ModelAndView mav = new ModelAndView();
        String a[] = ids.split(",");
        for (int i = 0; i < a.length; i++) {
            Integer id = Integer.parseInt(a[i]);
            taskService.deleteByPrimaryKey(id);
        }
        mav.setViewName("unDoTask?emp_id=" + emp_id);
        return mav;
    }

    /**
     * 根据id更新未完成计划
     * @throws UnsupportedEncodingException 
     */
    @RequestMapping(value = "/updateUnDoPlanById")
    public ModelAndView updateUnDoPlanById(@RequestParam("id") Integer id, @RequestParam("taskname") String taskname,
            @RequestParam("begintime") String task_begin_time, @RequestParam("endtime") String taskEndTime,
            @RequestParam("staff_id") String staff_id, @RequestParam("details") String taskdescription,
            @RequestParam("emp_id") String emp_id) throws UnsupportedEncodingException {
        ModelAndView mav = new ModelAndView();
        String  task_name = new String(taskname.getBytes("ISO8859_1"), "utf8");
        String  task_description = new String(taskdescription.getBytes("ISO8859_1"), "utf8");
        taskService.updateUnDoPlanById(id, task_name, task_begin_time, taskEndTime, staff_id, task_description);
        mav.addObject("msg", "success");
        mav.setViewName("task-doupdate");
        return mav;
    }
    
    /**
     * 根据员工用户名查询taskList
     */
    @RequestMapping(value="getListByStaffId")
    public ModelAndView getListByStaffId(@RequestParam("staffid") String staff_id) {
        ModelAndView mav = new ModelAndView();
        List<TaskVo> taskList =taskService.getListByStaffId(staff_id);
        int tc = taskService.getTaskCountByStaffId(staff_id);
        mav.addObject("taskList", taskList);
        mav.addObject("tc", tc);
        mav.setViewName("task-list");
        return mav;
    }
}
