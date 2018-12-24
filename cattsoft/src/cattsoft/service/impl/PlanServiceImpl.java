package cattsoft.service.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cattsoft.mapper.PlanMapper;
import cattsoft.pojo.Plan;
import cattsoft.pojo.PlanVo;
import cattsoft.service.PlanService;

@Service
public class PlanServiceImpl implements PlanService {
    @Autowired
    PlanMapper planMapper;

    // 根据task_id查询plan
    public List<Plan> plans(String task_id) {
        return planMapper.plans(task_id);
    }

    // 根据id查询单个Plan
    public Plan getPlanById(int id) {
        return planMapper.getPlanById(id);
    }

    // 根据id更新Plan
    public int updatePlanById(int id, String plan_state, String feedback, String plan_description,
            String plan_feedback) {
        return planMapper.updatePlanById(id, plan_state, feedback, plan_description, plan_feedback);
    }

    // 新建一个计划
    public int createNewPlan(Integer task_id, String plan_name, String plan_state, String feedback,
            Date plan_beigin_time, Date plan_end_time, String plan_description) {
        return planMapper.createNewPlan(task_id, plan_name, plan_state, feedback, plan_beigin_time, plan_end_time,
                plan_description);
    }

    // 根据id删除计划
    public int deletePlanById(Integer id) {
        return planMapper.deletePlanById(id);
    };

    // 根据员工用户名查询对应的plan
    public List<PlanVo> getPlanListByUsername(String username) {
        return planMapper.getPlanListByUsername(username);
    };
}
