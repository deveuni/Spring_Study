package com.itwillbs.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.service.MemberService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class MemberServiceTest {

	// 서비스의 동작을 테스트하는 파일
	
	// 서비스 객체 생성(x) -> 의존 주입
	@Inject
	private MemberService service;
	
	@Test
	public void insertServiceTest() throws Exception {
		MemberVO vo = new MemberVO("test2", "1234", "test2", "test2@itwillbs.co.kr", null, null);
		service.insertMember(vo);
	}
	
	
}
