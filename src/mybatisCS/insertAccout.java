package mybatisCS;

import Dao.EmployeeDao;
import Dao.accountCheckQs;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class insertAccout {

    public static SqlSessionFactory getSqlSessionFactory() throws Exception{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //System.out.println("sqlSessionFactory = " + sqlSessionFactory);
        return sqlSessionFactory;
    }

    public static void insertAccObject(List<AccountCheck> account) throws Exception{
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try{
            accountCheckQs qs = session.getMapper(accountCheckQs.class);
            qs.insertSQL(account);

            session.commit();
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();
        }finally {
            session.close();
        }
    }

    public static void main(String[] args){
        List<AccountCheck> list = new ArrayList<>();
        BufferedReader br = null;


        try{
            File file = new File("K:\\11.txt");
            br = new BufferedReader(new FileReader(file));
            int len;
            String str = null;
            while((str = br.readLine())!= null){
                String[] strArray = str.split(",");
                AccountCheck acc = new AccountCheck();
                acc.setBillDate(strArray[0]);
                acc.setBusiId(strArray[1]);
                acc.setOrderType(strArray[2]);
                list.add(acc);
            }
            insertAccObject(list);
            System.out.println("插入成功");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
