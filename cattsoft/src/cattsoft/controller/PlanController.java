package cattsoft.controller;

import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cattsoft.pojo.Plan;
import cattsoft.pojo.PlanVo;
import cattsoft.service.PlanService;

@Controller
public class PlanController {
    @Autowired
    PlanService planService;

    /**
     * 跟據task_id查詢plan
     */
    @RequestMapping(value = "/plans")
    public ModelAndView plans(@RequestParam("task_id") String task_id) {
        ModelAndView mav = new ModelAndView();
        List<Plan> plans = planService.plans(task_id);
        int pc = plans.size();
        mav.addObject("pc", pc);
        mav.addObject("plans", plans);
        mav.setViewName("task-details");
        return mav;
    }

    /**
     * 根据id查询对应的Plan细节
     */
    @RequestMapping(value = "/planDetail")
    public ModelAndView planDetail(@RequestParam("id") Integer id) {
        ModelAndView mav = new ModelAndView();
        Plan plan = planService.getPlanById(id);
        mav.addObject("plan", plan);
        mav.setViewName("plan-update");
        return mav;
    }

    /**
     * 根据id更新Plan
     * 
     * @throws UnsupportedEncodingException
     * 
     */
    @RequestMapping(value = "/changePlan")
    public ModelAndView changePlan(@RequestParam("type") String planstate, @RequestParam("back") String feedbacks,
            @RequestParam("id") Integer id, @RequestParam("details") String plandescription,
            @RequestParam("back_details") String planfeedback) throws UnsupportedEncodingException {
        ModelAndView mav = new ModelAndView();
        String plan_state = new String(planstate.getBytes("ISO8859_1"), "utf8");
        String feedback = new String(feedbacks.getBytes("ISO8859_1"), "utf8");
        String plan_feedback = new String(planfeedback.getBytes("ISO8859_1"), "utf8");
        String plan_description = new String(plandescription.getBytes("ISO8859_1"), "utf8");
        planService.updatePlanById(id, plan_state, feedback, plan_description, plan_feedback);
        mav.addObject("msg", "success");
        mav.setViewName("plan-update");
        return mav;
    }

    /**
     * 创建一个新的plan
     * 
     * @throws UnsupportedEncodingException
     */
    @RequestMapping(value = "createNewPlan")
    public ModelAndView createNewPlan(@RequestParam("taskid") Integer task_id,
            @RequestParam("planname") String planname, @RequestParam("type") String planstate,
            @RequestParam("back") String feedbacks, @RequestParam("begintime") Date plan_beigin_time,
            @RequestParam("endtime") Date plan_end_time, @RequestParam("details") String plandescription)
            throws UnsupportedEncodingException {
        ModelAndView mav = new ModelAndView();
        String plan_state = new String(planstate.getBytes("ISO8859_1"), "utf8");
        String feedback = new String(feedbacks.getBytes("ISO8859_1"), "utf8");
        String plan_name = new String(planname.getBytes("ISO8859_1"), "utf8");
        String plan_description = new String(plandescription.getBytes("ISO8859_1"), "utf8");
        planService.createNewPlan(task_id, plan_name, plan_state, feedback, plan_beigin_time, plan_end_time,
                plan_description);
        mav.addObject("msg", "success");
        mav.setViewName("plan-add");
        return mav;
    }
    
    /**
     * 根据id删除计划
     */
    @RequestMapping(value="/deletePlanById")
    public ModelAndView deletePlanById(@RequestParam("id") String ids,@RequestParam("taskid") String task_id) {
        ModelAndView mav = new ModelAndView();
        String a[] = ids.split(",");
        for(int i=0;i<a.length;i++) {
            Integer id = Integer.parseInt(a[i]);
            planService.deletePlanById(id);
        }
        mav.setViewName("plans?task_id="+task_id);
        return mav;
    }
    
    /**
     * 根据员工用户名查询对应的plan
     */
    @RequestMapping(value="/getPlanListByUsername")
    public ModelAndView getPlanListByUsername(@RequestParam("username") String username) {
        ModelAndView mav = new ModelAndView();
        List<PlanVo> plan =  planService.getPlanListByUsername(username);
        mav.addObject("plan", plan);
        mav.setViewName("plan-list");
        return mav;
    };
}
