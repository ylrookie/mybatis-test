package Dao;

import com.sun.tracing.dtrace.ProviderAttributes;
import mybatisCS.beansTest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapperDynamicSQL {
    //将查询条件封装为一个对象传入
    public List<beansTest> getEmployeeConditionIfWhere(beansTest condition);

    public List<beansTest> getEmployeeConditionTrim(beansTest condition);

    public List<beansTest> getEmployeeConditionByName();

    public List<beansTest> getEmployeeConditionByid(@Param("ids") List<Integer> ids);

    //批量插入
    public void insertEmployee(@Param("emps") List<beansTest> beans);

    //批量修改
    public void updateEmployee(@Param("upemps") List<beansTest> beans);

    public void UpdateEmployeeCondition(beansTest condition);
    //choose
    public List<beansTest>  getEmpsByConditionChoose(beansTest Condition);


}
