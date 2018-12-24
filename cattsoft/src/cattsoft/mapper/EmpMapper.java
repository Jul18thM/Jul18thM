package cattsoft.mapper;

import cattsoft.pojo.Emp;
import cattsoft.pojo.EmpExample;

import java.sql.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmpMapper {
    long countByExample(EmpExample example);

    int deleteByExample(EmpExample example);
    //删除用户
    int deleteByUsername(String username);

    int addUser(String username, String name, String password, String sex, Date birthday, Date hiredate,
            String position, String qualification, String professional, String flag, String experience);

    int insertSelective(Emp record);

    List<Emp> selectByExampleWithBLOBs(EmpExample example);

    List<Emp> selectByExample(EmpExample example);

    Emp selectByPrimaryKey(String username);

    int updateByExampleSelective(@Param("record") Emp record, @Param("example") EmpExample example);

    int updateByExampleWithBLOBs(@Param("record") Emp record, @Param("example") EmpExample example);

    int updateByExample(@Param("record") Emp record, @Param("example") EmpExample example);

    int updateByPrimaryKeySelective(Emp record);

    int updateByPrimaryKeyWithBLOBs(Emp record);

    int updateByPrimaryKey(Emp record);

    Emp login(String username);

    List<Emp> userList(int start, int count);

    int count();

    Emp userDetail(String username);

    Emp checkUsername(String username);
    
    List<Emp> empList(int start, int count);
    
    int empCount();
    
    Emp empDetail(String username);
    
    List<Emp> mgrList(String super_id,int start, int count);
    
    int mgrCount(String super_id);
    
    String getName(String username);
    
    List<Emp> getStaff(String super_id);
    
    
}