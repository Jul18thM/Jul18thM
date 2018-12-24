package cattsoft.service;

import java.sql.Date;
import java.util.List;

import cattsoft.pojo.Emp;

public interface EmpService {
    Emp login(String username);

    List<Emp> userList(int start, int count);

    int count();

    Emp userDetail(String username);

    int addUser(String username, String name, String password, String sex, Date birthday, Date hiredate,
            String position, String qualification, String professional, String flag, String experience);

    Emp checkUsername(String username);
    
    List<Emp> empList(int start,int count);
    
    int empCount();
    
    Emp empDetail(String username);
    
    List<Emp> mgrList(String super_id,int start, int count);
    
    int mgrCount(String super_id);
    
    String getName(String username);
    
    List<Emp> getStaff(String super_id);
    
    int deleteByUsername(String username);
}
