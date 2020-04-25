package Dao;

import mybatisCS.Dept;

public interface DeptResultMap {
    public Dept getDeptById(Integer dept_id);
    public Dept getDeptAndEmps(Integer id);

    public Dept getDeptAndEmpsStep(Integer id);
}
