package mybatisCS;

import Dao.EmployeeMapperDynamicSQL;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class TestMybatisDynamicSQL {
    public SqlSessionFactory getFactory() throws  Exception{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }

    @Test
    public void testTf() throws Exception{
        SqlSessionFactory sqlSessionFactory = getFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapperDynamicSQL emd = sqlSession.getMapper(EmployeeMapperDynamicSQL.class);
            beansTest condition = new beansTest();
            //condition.setId(126);
            condition.setLastName("看");
            condition.setEmail("1234");
            condition.setGender(1);

            beansTest condition1 = new beansTest();
            condition1.setId(123);
            condition1.setLastName("孙");
            condition1.setEmail("1234");
            condition1.setGender(1);
            List<beansTest> list = emd.getEmployeeConditionIfWhere(condition1);
            System.out.println(list);
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void testTrim() throws Exception{
        SqlSessionFactory sqlSessionFactory = getFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapperDynamicSQL emd = sqlSession.getMapper(EmployeeMapperDynamicSQL.class);

            beansTest condition1 = new beansTest();
            condition1.setId(123);
            condition1.setLastName("孙");
            condition1.setEmail("1234");
            condition1.setGender(1);
            List<beansTest> list = emd.getEmployeeConditionTrim(condition1);
            System.out.println(list);
        }finally {
            sqlSession.close();
        }
    }
    @Test
    public void test() throws Exception{
        SqlSessionFactory sqlSessionFactory = getFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapperDynamicSQL emd = sqlSession.getMapper(EmployeeMapperDynamicSQL.class);
            List<beansTest> list = emd.getEmployeeConditionByName();
            System.out.println(list);
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void testForeach() throws Exception{
        SqlSessionFactory sqlSessionFactory = getFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapperDynamicSQL emd = sqlSession.getMapper(EmployeeMapperDynamicSQL.class);
            List<Integer> li = new ArrayList<Integer>();
            li.add(123);
            li.add(124);
            li.add(125);
            li.add(126);
            List<beansTest> list = emd.getEmployeeConditionByid(li);
            System.out.println(list);
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void testInsertForeach() throws Exception{
        SqlSessionFactory sqlSessionFactory = getFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapperDynamicSQL emd = sqlSession.getMapper(EmployeeMapperDynamicSQL.class);
            List<beansTest> beans = new ArrayList<>();
            beans.add(new beansTest(null,"JJ","11t",1));
            beans.add(new beansTest(null,"TT","22t",1));
            emd.insertEmployee(beans);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void testUpdateForeach() throws Exception{
        SqlSessionFactory sqlSessionFactory = getFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapperDynamicSQL emd = sqlSession.getMapper(EmployeeMapperDynamicSQL.class);
            List<beansTest> beans = new ArrayList<>();
            beans.add(new beansTest(131,"J11","00",2));
            beans.add(new beansTest(132,"T22","00",2));
            emd.updateEmployee(beans);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSet() throws Exception{
        SqlSessionFactory sqlSessionFactory = getFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapperDynamicSQL emd = sqlSession.getMapper(EmployeeMapperDynamicSQL.class);

            beansTest condition1 = new beansTest();
            condition1.setId(123);
            condition1.setLastName("SS");
            condition1.setEmail("333");
            condition1.setGender(0);
            emd.UpdateEmployeeCondition(condition1);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void testChoose() throws Exception{
        SqlSessionFactory sqlSessionFactory = getFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapperDynamicSQL emd = sqlSession.getMapper(EmployeeMapperDynamicSQL.class);

            beansTest condition1 = new beansTest();
            //condition1.setId(123);
            condition1.setLastName("SS");
            condition1.setEmail("333");
            condition1.setGender(0);
            List<beansTest> beans = emd.getEmpsByConditionChoose(condition1);
            System.out.println(beans);
        }finally {
            sqlSession.close();
        }
    }

}
