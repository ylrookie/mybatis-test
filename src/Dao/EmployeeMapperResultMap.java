package Dao;

import mybatisCS.beansTest;

public interface EmployeeMapperResultMap {

    public beansTest getEmployeeById(Integer id);

    public beansTest getEmployeeAndDept(Integer id);

    public beansTest getEmployeeDeptStep(Integer id);

}
