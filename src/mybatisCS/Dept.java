package mybatisCS;

import java.util.List;

public class Dept {
    private int deptId;

    private String deptName;

    private List<beansTest> emps;

    public List<beansTest> getEmps() {
        return emps;
    }

    public void setEmps(List<beansTest> emps) {
        this.emps = emps;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                '}';
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
