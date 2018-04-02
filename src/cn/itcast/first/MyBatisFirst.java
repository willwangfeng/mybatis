package cn.itcast.first;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.itcast.po.User;

/**
 * 
 * @author wangfeng
 *
 */
public class MyBatisFirst {

	// 根据id查询用户信息，得到一条记录结果
	@Test
	public void findUserById() throws IOException {

		// mybatis配置文件
		String resource = "SqlMapConfig.xml";

		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂，传入mybatis的配置信息

		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 通过工厂得到sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 通过sqlSession操作数据库
		// 参数一：映射文件中statement的id,等于命名空间+statement的id
		// 参数二：指定和映射文件中所匹配的parameterType类型的参数
		// selectOne的结果 是与映射文件中所匹配的resultType类型的对象
		User user = sqlSession.selectOne("test.findUserById", 1);

		System.out.println(user);

		// 释放资源
		sqlSession.close();
	}

	// 根据用户名称模糊查询用户信息
	@Test
	public void findUserByNameTest() throws IOException {

		// mybatis配置文件
		String resource = "SqlMapConfig.xml";

		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂，传入mybatis的配置信息

		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 通过工厂得到sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		List<User> list = sqlSession.selectList("test.findUserByName", "小明");

		System.out.println(list);
		// 释放资源
		sqlSession.close();
	}

	// 添加用户
	@Test
	public void insertUserTest() throws IOException {
		// mybatis配置文件
		String resource = "SqlMapConfig.xml";
		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂，传入mybatis的配置信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 通过工厂得到sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = new User();
		user.setUsername("王小军");
		user.setBirthday(new Date());
		user.setSex("1");
		user.setAddress("河南郑州");
		sqlSession.insert("test.insertUser", user);
		// 提交事务
		sqlSession.commit();

		System.out.println(user.getId());
		// 释放资源
		sqlSession.close();
	}
	
	@Test
	public void deleteUserTest() throws IOException {
		// mybatis配置文件
		String resource = "SqlMapConfig.xml";
		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂，传入mybatis的配置信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 通过工厂得到sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		sqlSession.delete("test.deleteUser", 10);
		
		sqlSession.commit();
		// 释放资源
		sqlSession.close();
	}
	
	@Test
	public void updateUserTest() throws IOException {
		// mybatis配置文件
		String resource = "SqlMapConfig.xml";
		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂，传入mybatis的配置信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 通过工厂得到sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		User user = new User();
		user.setId(33);
		user.setUsername("王大军");
		user.setBirthday(new Date());
		user.setSex("1");
		user.setAddress("河南郑州");
		sqlSession.update("test.updateUser", user);
		
		sqlSession.commit();
		// 释放资源
		sqlSession.close();
	}
}
