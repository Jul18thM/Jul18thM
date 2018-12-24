package cattsoft.service.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cattsoft.mapper.EmpMapper;
import cattsoft.pojo.Emp;
import cattsoft.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    EmpMapper empMapper;

    public Emp login(String username) {
        return empMapper.login(username);
    }

    public List<Emp> userList(int start, int count) {
        return empMapper.userList(start, count);
    }

    public int count() {
        return empMapper.count();
    }

    public Emp userDetail(String username) {
        return empMapper.userDetail(username);
    }

    public int addUser(String username, String name, String password, String sex, Date birthday, Date hiredate,
            String position, String qualification, String professional, String flag, String experience) {
        return empMapper.addUser(username, name, password, sex, birthday, hiredate, position, qualification,
                professional, flag, experience);
    }

    public Emp checkUsername(String username) {
        return empMapper.checkUsername(username);
    }
    
    public List<Emp> empList(int start, int count) {
        return empMapper.empList(start, count);
    }
    
    public int empCount() {
        return empMapper.empCount();
    }
    
    public Emp empDetail(String username) {
        return empMapper.empDetail(username);
    }
    
    public List<Emp> mgrList(String super_id,int start, int count){
        return empMapper.mgrList(super_id, start, count);
    }
    
    public int mgrCount(String super_id){
        return empMapper.mgrCount(super_id);
    }
    
    public String getName(String username) {
        return empMapper.getName(username);
    }
    
    public List<Emp> getStaff(String super_id){
        return empMapper.getStaff(super_id);
    }
    
    public  int deleteByUsername(String username) {
        return empMapper.deleteByUsername(username);
    }
}
