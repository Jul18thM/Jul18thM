package cattsoft.mapper;

import cattsoft.pojo.Plan;
import cattsoft.pojo.PlanVo;
import cattsoft.pojo.PlanWithBLOBs;

import java.sql.Date;
import java.util.List;

public interface PlanMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(PlanWithBLOBs record);

    int insertSelective(PlanWithBLOBs record);

    int updateByPrimaryKeySelective(PlanWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(PlanWithBLOBs record);

    int updateByPrimaryKey(Plan record);

    // 根据task_id查询planList
    List<Plan> plans(String task_id);

    // 根据id查询单个Plan
    Plan getPlanById(int id);

    // 根据id更新Plan
    int updatePlanById(int id, String plan_state, String feedback, String plan_description, String plan_feedback);

    // 新建一个计划
    int createNewPlan(Integer task_id, String plan_name, String plan_state, String feedback, Date begintime,
            Date plan_end_time, String plan_description);
    
    //根据id删除计划
    int deletePlanById(Integer id);
    
    //根据员工用户名查询对应的plan
    List<PlanVo> getPlanListByUsername(String username);
}