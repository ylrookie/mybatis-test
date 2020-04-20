package Dao;
import mybatisCS.beansTest;

public interface EmployeeDao {

    //根据id查询employee
    public beansTest getEmployeeById(Integer id);

    //添加一个新的employee
    public void insertEmployee(beansTest  beanstest);

    //修改一个员工的信息
    public void updateEmployee(beansTest  beanstest);

    //删除一个员工信息
    public void deleteEmployee(Integer id);

    public beansTest getEmployeeByIdandLastName(Integer id,String lastName);
}
