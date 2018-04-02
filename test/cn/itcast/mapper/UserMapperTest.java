package cn.itcast.mapper;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.po.User;

public class UserMapperTest {

	private SqlSessionFactory sqlSessionFactory;
	@Before
	public void setUp() throws Exception {
		// mybatis配置文件
		String resource = "SqlMapConfig.xml";

		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂，传入mybatis的配置信息

		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

	}

	@Test
	public void testFindUserById() throws IOException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建UserMapper对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.findUserById(1);
		System.out.println(user);
	}
	
	@Test
	public void testFindUserByIdResultMap() throws IOException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建UserMapper对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.findUserByIdResultMap(1);
		System.out.println(user);
	}

}
