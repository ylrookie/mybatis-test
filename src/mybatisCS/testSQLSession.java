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

    public SqlSessionFactory getFactory() throws  Exception{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }

    @Test
    public void testCRUD() throws Exception{
        //获取SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = getFactory();
        SqlSession session = sqlSessionFactory.openSession();

        try{
            EmployeeDao  dao = session.getMapper(EmployeeDao.class);
            //查询
//            beansTest beans = dao.getEmployeeById(2);
//            System.out.println(beans);
            //插入
            beansTest beans1 = new beansTest(null,"XX","xx.com",3);
            dao.insertEmployee(beans1);
            System.out.println(beans1.getId());
            beansTest beans = dao.getEmployeeById(beans1.getId());
            System.out.println(beans);

            //修改
           /* beansTest beans2 = new beansTest(1,"猪八戒","4321",1);
            dao.updateEmployee(beans2);*/

            //删除
//            dao.deleteEmployee(3);

            session.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    @Test
    public void testPatam() throws Exception{
        SqlSessionFactory sqlSessionFactory = getFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            EmployeeDao  dao1 = session.getMapper(EmployeeDao.class);
            //查询
            beansTest beans = dao1.getEmployeeByIdandLastName(129,"xx");
            System.out.println(beans);
        }finally {
            session.close();
        }

    }
}
