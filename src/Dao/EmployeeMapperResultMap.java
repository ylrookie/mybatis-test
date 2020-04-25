package Dao;

import mybatisCS.beansTest;

import java.util.List;

public interface EmployeeMapperResultMap {

    public beansTest getEmployeeById(Integer id);

    public beansTest getEmployeeAndDept(Integer id);

    public beansTest getEmployeeDeptStep(Integer id);

    public List<beansTest> getEmpsByDeptId(Integer Id);

}
