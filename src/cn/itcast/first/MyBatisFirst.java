package cn.itcast.first;

import java.io.IOException;
import java.io.InputStream;

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
	
	//根据id查询用户信息，得到一条记录结果
	@Test
	public void findUserById() throws IOException{
		
		//mybatis配置文件
		String resource = "SqlMapConfig.xml";
		
		//得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//创建会话工厂，传入mybatis的配置信息
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//通过工厂得到sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//通过sqlSession操作数据库
		//参数一：映射文件中statement的id,等于命名空间+statement的id
		//参数二：指定和映射文件中所匹配的parameterType类型的参数  
		//selectOne的结果 是与映射文件中所匹配的resultType类型的对象
		User user = sqlSession.selectOne("test.findUserById", 1);
		
		System.out.println(user);
		
		//释放资源
		sqlSession.close();
	}
}
