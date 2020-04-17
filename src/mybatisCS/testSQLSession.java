package mybatisCS;

import Dao.EmployeeDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

public class testSQLSession {
    public static void main(String[] args) throws Exception{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //System.out.println("sqlSessionFactory = " + sqlSessionFactory);

        SqlSession session = sqlSessionFactory.openSession();
        try {
            beansTest beans = session.selectOne("org.mybatis.example.EmployeeMapper.selectEmployee", 1);

            System.out.println("beans = " + beans);
            String lastName = beans.getLastName();
            String email = beans.getEmail();
        } finally {
            session.close();
        }
    }
    @Test
    public void testHelloWorldMapper() throws  Exception{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sess = sqlSessionFactory.openSession();

        try{
            EmployeeDao dao = sess.getMapper(EmployeeDao.class);
            beansTest bt = dao.getEmployeeById(2);
            System.out.println(bt);
        }finally {
            sess.close();
        }
    }
}
