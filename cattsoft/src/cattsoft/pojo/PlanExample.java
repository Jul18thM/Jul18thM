package cattsoft.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PlanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PlanExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPlanNameIsNull() {
            addCriterion("plan_name is null");
            return (Criteria) this;
        }

        public Criteria andPlanNameIsNotNull() {
            addCriterion("plan_name is not null");
            return (Criteria) this;
        }

        public Criteria andPlanNameEqualTo(String value) {
            addCriterion("plan_name =", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameNotEqualTo(String value) {
            addCriterion("plan_name <>", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameGreaterThan(String value) {
            addCriterion("plan_name >", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameGreaterThanOrEqualTo(String value) {
            addCriterion("plan_name >=", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameLessThan(String value) {
            addCriterion("plan_name <", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameLessThanOrEqualTo(String value) {
            addCriterion("plan_name <=", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameLike(String value) {
            addCriterion("plan_name like", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameNotLike(String value) {
            addCriterion("plan_name not like", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameIn(List<String> values) {
            addCriterion("plan_name in", values, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameNotIn(List<String> values) {
            addCriterion("plan_name not in", values, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameBetween(String value1, String value2) {
            addCriterion("plan_name between", value1, value2, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameNotBetween(String value1, String value2) {
            addCriterion("plan_name not between", value1, value2, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanStateIsNull() {
            addCriterion("plan_state is null");
            return (Criteria) this;
        }

        public Criteria andPlanStateIsNotNull() {
            addCriterion("plan_state is not null");
            return (Criteria) this;
        }

        public Criteria andPlanStateEqualTo(String value) {
            addCriterion("plan_state =", value, "planState");
            return (Criteria) this;
        }

        public Criteria andPlanStateNotEqualTo(String value) {
            addCriterion("plan_state <>", value, "planState");
            return (Criteria) this;
        }

        public Criteria andPlanStateGreaterThan(String value) {
            addCriterion("plan_state >", value, "planState");
            return (Criteria) this;
        }

        public Criteria andPlanStateGreaterThanOrEqualTo(String value) {
            addCriterion("plan_state >=", value, "planState");
            return (Criteria) this;
        }

        public Criteria andPlanStateLessThan(String value) {
            addCriterion("plan_state <", value, "planState");
            return (Criteria) this;
        }

        public Criteria andPlanStateLessThanOrEqualTo(String value) {
            addCriterion("plan_state <=", value, "planState");
            return (Criteria) this;
        }

        public Criteria andPlanStateLike(String value) {
            addCriterion("plan_state like", value, "planState");
            return (Criteria) this;
        }

        public Criteria andPlanStateNotLike(String value) {
            addCriterion("plan_state not like", value, "planState");
            return (Criteria) this;
        }

        public Criteria andPlanStateIn(List<String> values) {
            addCriterion("plan_state in", values, "planState");
            return (Criteria) this;
        }

        public Criteria andPlanStateNotIn(List<String> values) {
            addCriterion("plan_state not in", values, "planState");
            return (Criteria) this;
        }

        public Criteria andPlanStateBetween(String value1, String value2) {
            addCriterion("plan_state between", value1, value2, "planState");
            return (Criteria) this;
        }

        public Criteria andPlanStateNotBetween(String value1, String value2) {
            addCriterion("plan_state not between", value1, value2, "planState");
            return (Criteria) this;
        }

        public Criteria andFeedbackIsNull() {
            addCriterion("feedback is null");
            return (Criteria) this;
        }

        public Criteria andFeedbackIsNotNull() {
            addCriterion("feedback is not null");
            return (Criteria) this;
        }

        public Criteria andFeedbackEqualTo(String value) {
            addCriterion("feedback =", value, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackNotEqualTo(String value) {
            addCriterion("feedback <>", value, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackGreaterThan(String value) {
            addCriterion("feedback >", value, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackGreaterThanOrEqualTo(String value) {
            addCriterion("feedback >=", value, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackLessThan(String value) {
            addCriterion("feedback <", value, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackLessThanOrEqualTo(String value) {
            addCriterion("feedback <=", value, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackLike(String value) {
            addCriterion("feedback like", value, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackNotLike(String value) {
            addCriterion("feedback not like", value, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackIn(List<String> values) {
            addCriterion("feedback in", values, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackNotIn(List<String> values) {
            addCriterion("feedback not in", values, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackBetween(String value1, String value2) {
            addCriterion("feedback between", value1, value2, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackNotBetween(String value1, String value2) {
            addCriterion("feedback not between", value1, value2, "feedback");
            return (Criteria) this;
        }

        public Criteria andPlanBeginDateIsNull() {
            addCriterion("plan_begin_date is null");
            return (Criteria) this;
        }

        public Criteria andPlanBeginDateIsNotNull() {
            addCriterion("plan_begin_date is not null");
            return (Criteria) this;
        }

        public Criteria andPlanBeginDateEqualTo(Date value) {
            addCriterion("plan_begin_date =", value, "planBeginDate");
            return (Criteria) this;
        }

        public Criteria andPlanBeginDateNotEqualTo(Date value) {
            addCriterion("plan_begin_date <>", value, "planBeginDate");
            return (Criteria) this;
        }

        public Criteria andPlanBeginDateGreaterThan(Date value) {
            addCriterion("plan_begin_date >", value, "planBeginDate");
            return (Criteria) this;
        }

        public Criteria andPlanBeginDateGreaterThanOrEqualTo(Date value) {
            addCriterion("plan_begin_date >=", value, "planBeginDate");
            return (Criteria) this;
        }

        public Criteria andPlanBeginDateLessThan(Date value) {
            addCriterion("plan_begin_date <", value, "planBeginDate");
            return (Criteria) this;
        }

        public Criteria andPlanBeginDateLessThanOrEqualTo(Date value) {
            addCriterion("plan_begin_date <=", value, "planBeginDate");
            return (Criteria) this;
        }

        public Criteria andPlanBeginDateIn(List<Date> values) {
            addCriterion("plan_begin_date in", values, "planBeginDate");
            return (Criteria) this;
        }

        public Criteria andPlanBeginDateNotIn(List<Date> values) {
            addCriterion("plan_begin_date not in", values, "planBeginDate");
            return (Criteria) this;
        }

        public Criteria andPlanBeginDateBetween(Date value1, Date value2) {
            addCriterion("plan_begin_date between", value1, value2, "planBeginDate");
            return (Criteria) this;
        }

        public Criteria andPlanBeginDateNotBetween(Date value1, Date value2) {
            addCriterion("plan_begin_date not between", value1, value2, "planBeginDate");
            return (Criteria) this;
        }

        public Criteria andPlanEndDateIsNull() {
            addCriterion("plan_end_date is null");
            return (Criteria) this;
        }

        public Criteria andPlanEndDateIsNotNull() {
            addCriterion("plan_end_date is not null");
            return (Criteria) this;
        }

        public Criteria andPlanEndDateEqualTo(Date value) {
            addCriterion("plan_end_date =", value, "planEndDate");
            return (Criteria) this;
        }

        public Criteria andPlanEndDateNotEqualTo(Date value) {
            addCriterion("plan_end_date <>", value, "planEndDate");
            return (Criteria) this;
        }

        public Criteria andPlanEndDateGreaterThan(Date value) {
            addCriterion("plan_end_date >", value, "planEndDate");
            return (Criteria) this;
        }

        public Criteria andPlanEndDateGreaterThanOrEqualTo(Date value) {
            addCriterion("plan_end_date >=", value, "planEndDate");
            return (Criteria) this;
        }

        public Criteria andPlanEndDateLessThan(Date value) {
            addCriterion("plan_end_date <", value, "planEndDate");
            return (Criteria) this;
        }

        public Criteria andPlanEndDateLessThanOrEqualTo(Date value) {
            addCriterion("plan_end_date <=", value, "planEndDate");
            return (Criteria) this;
        }

        public Criteria andPlanEndDateIn(List<Date> values) {
            addCriterion("plan_end_date in", values, "planEndDate");
            return (Criteria) this;
        }

        public Criteria andPlanEndDateNotIn(List<Date> values) {
            addCriterion("plan_end_date not in", values, "planEndDate");
            return (Criteria) this;
        }

        public Criteria andPlanEndDateBetween(Date value1, Date value2) {
            addCriterion("plan_end_date between", value1, value2, "planEndDate");
            return (Criteria) this;
        }

        public Criteria andPlanEndDateNotBetween(Date value1, Date value2) {
            addCriterion("plan_end_date not between", value1, value2, "planEndDate");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNull() {
            addCriterion("task_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("task_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(Integer value) {
            addCriterion("task_id =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(Integer value) {
            addCriterion("task_id <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(Integer value) {
            addCriterion("task_id >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_id >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(Integer value) {
            addCriterion("task_id <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(Integer value) {
            addCriterion("task_id <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(List<Integer> values) {
            addCriterion("task_id in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(List<Integer> values) {
            addCriterion("task_id not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(Integer value1, Integer value2) {
            addCriterion("task_id between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(Integer value1, Integer value2) {
            addCriterion("task_id not between", value1, value2, "taskId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}