package cattsoft.service;

import java.sql.Date;
import java.util.List;

import cattsoft.pojo.Plan;
import cattsoft.pojo.PlanVo;

public interface PlanService {
    // 根据task_id查询plan
    List<Plan> plans(String task_id);

    // 根据id查询单个Plan
    Plan getPlanById(int id);

    // 根据id更新Plan
    int updatePlanById(int id, String plan_state, String feedback, String plan_description, String plan_feedback);

    // 新建一个计划
    int createNewPlan(Integer task_id, String plan_name, String plan_state, String feedback, Date plan_beigin_time,
            Date plan_end_time, String plan_description);

    // 根据id删除计划
    int deletePlanById(Integer id);

    // 根据员工用户名查询对应的plan
    List<PlanVo> getPlanListByUsername(String username);
}
