package mybatisCS;

import Dao.EmployeeMapperResultMap;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

public class TestMybatisResuleMap {

    public SqlSessionFactory getFactory() throws  Exception{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }

    @Test
    public void testResultMap() throws  Exception{
        SqlSessionFactory sf = getFactory();
        SqlSession session = sf.openSession();
        try {
            EmployeeMapperResultMap beans = session.getMapper(EmployeeMapperResultMap.class);
            beansTest bean = beans.getEmployeeById(123);
            System.out.println(bean);

        }finally {
            session.close();
        }
    }
}
