package Dao;
import mybatisCS.beansTest;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface EmployeeDao {

    //根据id查询employee
    public beansTest getEmployeeById(Integer id);

    //添加一个新的employee
    public void insertEmployee(beansTest  beanstest);

    //修改一个员工的信息
    public void updateEmployee(beansTest  beanstest);

    //删除一个员工信息
    public void deleteEmployee(Integer id);

    //多个参数
    public beansTest getEmployeeByIdandLastName(@Param("id") Integer id, @Param("lastName") String lastName);

    //封装为map
    public beansTest getEmployeeByMap(Map<String,Object> map);
}
