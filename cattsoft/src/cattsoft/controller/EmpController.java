package cattsoft.controller;

import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cattsoft.pojo.Emp;
import cattsoft.service.EmpService;

@Controller
public class EmpController {
    @Autowired
    EmpService empService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam("username") String username, @RequestParam("password") String password,
            HttpSession session) {
        ModelAndView mav = new ModelAndView();
        Emp emp = empService.login(username);
        if (emp == null) {
            mav.addObject("msg", "用户名不存在");
            mav.setViewName("login");
        } else {
            if (!password.equals(emp.getPassword())) {
                mav.addObject("msg", "密码错误");
                mav.setViewName("login");
            } else {
                if (username.equals(emp.getUsername()) && password.equals(emp.getPassword())) {
                   
                        String super_id = emp.getUsername();
                        List<Emp> sn = empService.getStaff(super_id);
                        session.setAttribute("sn", sn);
                
                    mav.setViewName("main");
                    session.setAttribute("emp", emp);
                }
            }
        }
        return mav;
    }

    @RequestMapping(value = "/logout")
    public ModelAndView logout(HttpSession session) {
        ModelAndView mav = new ModelAndView();
        session.removeAttribute("emp");
        mav.setViewName("login");
        mav.addObject("msg", "您已安全退出");
        return mav;
    }

    @RequestMapping(value = "/empList")
    public ModelAndView userList(@RequestParam("page") Integer page) {
        ModelAndView mav = new ModelAndView();
        int pageSize = 3;
        int totalPages;
        int start = (page - 1) * pageSize;
        int count = pageSize;
        int sum = empService.count();
        if (sum % pageSize == 0) {
            totalPages = sum / pageSize;
        } else {
            totalPages = sum / pageSize + 1;
        }
        List<Emp> userList = empService.userList(start, count);
        mav.addObject("userList", userList);
        mav.addObject("totalPages", totalPages);
        mav.addObject("sum", sum);
        mav.addObject("page", page);
        mav.setViewName("user-list");
        return mav;
    }

    @RequestMapping(value = "/userDetail")
    public ModelAndView userDetail(@RequestParam("username") String username) {
        ModelAndView mav = new ModelAndView();
        Emp eD = empService.userDetail(username);
        mav.addObject("ed", eD);
        mav.setViewName("user-details");
        return mav;
    }

    @RequestMapping(value = "/addUser")
    public ModelAndView addUser(@RequestParam("username") String username, @RequestParam("name") String name,
            @RequestParam("password") String password, @RequestParam("sex") String sex,
            @RequestParam("birthday") Date birthday, @RequestParam("hiredate") Date hiredate,
            @RequestParam("position") String position, @RequestParam("qualification") String qualification,
            @RequestParam("professional") String professional, @RequestParam("flag") String flag,
            @RequestParam("experience") String experience) {
        ModelAndView mav = new ModelAndView();
        Emp e = empService.checkUsername(username);
        if(e == null) {
            int i = empService.addUser(username, name, password, sex, birthday, hiredate, position, qualification,
                    professional, flag, experience);
            if (i == 1) {
                mav.addObject("msg", "success");
                mav.setViewName("user-add");
            } else {
                mav.addObject("msg", "新增用户失败，请重试");
                Emp u = new Emp();
                u.setName(name);
                u.setBirthday(birthday);
                u.setExperience(experience);
                u.setFlag(flag);
                u.setHiredate(hiredate);
                u.setPassword(password);
                u.setPosition(position);
                u.setProfessional(professional);
                u.setQualification(qualification);
                u.setSex(sex);
                u.setUsername(username);
                mav.addObject("u", u);
                mav.setViewName("user-add");
            }
        } 
        return mav;
    }

    @RequestMapping(value = "/checkUsername")
    public Object checkUsername(@RequestParam("username") String username,HttpServletResponse response) throws Exception {
        Emp e = empService.checkUsername(username);
        response.setCharacterEncoding("Utf-8");
        PrintWriter writer= response.getWriter();
        if (e != null) {
           writer.println("用户名已被占用");
        } else {
            writer.println("用户名可以使用");
        }
        return null;
    }

    @RequestMapping(value = "/userList")
    public ModelAndView empList(@RequestParam("page") int page) {
        ModelAndView mav = new ModelAndView();
        int pageSize = 3;
        int totalPages;
        int start = (page - 1) * pageSize;
        int count = pageSize;
        int ep = empService.empCount();
        if (ep % pageSize == 0) {
            totalPages = ep / pageSize;
        } else {
            totalPages = ep / pageSize + 1;
        }
        List<Emp> empList = empService.empList(start, count);
        mav.addObject("empList", empList);
        mav.addObject("totalPages", totalPages);
        mav.addObject("ep", ep);
        mav.addObject("page", page);
        mav.setViewName("emp-list");
        return mav;
    }

    @RequestMapping(value = "/empDetail")
    public ModelAndView empDetail(@RequestParam("username") String username) {
        ModelAndView mav = new ModelAndView();
        Emp eD = empService.empDetail(username);
        mav.addObject("uds", eD);
        mav.setViewName("emp-details");
        return mav;
    }

    @RequestMapping(value = "/mgrList")
    public ModelAndView mgrList(@RequestParam("super_id") String super_id, @RequestParam("page") int page) {
        ModelAndView mav = new ModelAndView();
        int pageSize = 3;
        int totalPages;
        int start = (page - 1) * pageSize;
        int count = pageSize;
        int ep = empService.mgrCount(super_id);
        if (ep % pageSize == 0) {
            totalPages = ep / pageSize;
        } else {
            totalPages = ep / pageSize + 1;
        }
        List<Emp> empList = empService.mgrList(super_id, start, count);
        mav.addObject("empList", empList);
        mav.addObject("totalPages", totalPages);
        mav.addObject("ep", ep);
        mav.addObject("page", page);
        mav.setViewName("emp-list1");
        return mav;
    }

    @RequestMapping(value = "/deleteUser")
    public ModelAndView deleteUser(@RequestParam("username") String str) {
        ModelAndView mav = new ModelAndView();
        String a[] = str.split(",");
        for(int i=0;i<a.length;i++) {
            String username = a[i];
            empService.deleteByUsername(username);
        }
        mav.setViewName("userList?page=1");
        return mav;
    }
}
