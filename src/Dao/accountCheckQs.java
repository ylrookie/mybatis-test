package Dao;

import mybatisCS.AccountCheck;
import mybatisCS.beansTest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface accountCheckQs {
    public void insertSQL(@Param("emps") List<AccountCheck> account);
}
