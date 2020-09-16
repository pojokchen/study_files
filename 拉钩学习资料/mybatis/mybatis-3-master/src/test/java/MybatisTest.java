import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {

  /**
   * 传统方式
   * @throws IOException
   */
  public void test1() throws IOException {
    // 1. 读取配置文件，读成字节输入流，注意：现在还没解析
    InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

    // 2. 解析配置文件，封装Configuration对象   创建DefaultSqlSessionFactory对象
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

    // 3. 生产了DefaultSqlsession实例对象   设置了事务不自动提交  完成了executor对象的创建
    SqlSession sqlSession = sqlSessionFactory.openSession();

    // 4.(1)根据statementid来从Configuration中map集合中获取到了指定的MappedStatement对象
       //(2)将查询任务委派了executor执行器
    List<Object> objects = sqlSession.selectList("namespace.id");

    // 5.释放资源
    sqlSession.close();

  }

  /**
   * mapper代理方式
   */
  public void test2() throws IOException {

    InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
    SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
    SqlSession sqlSession = factory.openSession();

    // 使用JDK动态代理对mapper接口产生代理对象
    IUserMapper mapper = sqlSession.getMapper(IUserMapper.class);

    //代理对象调用接口中的任意方法，执行的都是动态代理中的invoke方法
    List<Object> allUser = mapper.findAllUser();

  }



}







