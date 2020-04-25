package Dao;
import mybatisCS.beansTest;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
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

    //查询多行返回一个对象的集合
    public List<beansTest>  selectList();

    //查询一条数据，结果分装为map
    public Map<String,Object>  getEmployeeByIdReturnMap(Integer id);

    //查询多条数据返回map
    @MapKey("id")  //指定使用对象的那个属性作为map的key
    public Map<Integer,beansTest> getEmployeemoreReturnMap();


}
