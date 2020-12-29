package com.itwillbs.test;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"} // 경로에 해당하는 파일을 불러옴 
		)
public class MyBatisTest {
	
	// SqlSessionFactory 객체 생성 -> DI(의존주입)
	@Inject
	private SqlSessionFactory sqlFactory;
	// xml 코드 - SqlSessionFactoryBean 객체 생성
	// => 주입하면서 SqlSessionFactory 형변환(업캐스팅)
	
	// 객체 주입 후 확인동작 - 메서드
	@Test
	public void testFactory() throws Exception{
		System.out.println("@@@@@@ 생성된 객체 정보 : "+sqlFactory);
	}
	
	// 주입받은 slqFactory 객체 사용 -> openSesson() 호출해서 
	// 리턴되는 정보 확인하기!
	@Test
	public void testSession() throws Exception{
		
		SqlSession session = sqlFactory.openSession();
		System.out.println("@@@@@@ 생성된 session 객체 : " + session);
		/*
		 * session.delete(statement); session.insert(statement);
		 * session.update(statement); session.select(statement, handler);
		 */
	}
	
	
	
	
}
