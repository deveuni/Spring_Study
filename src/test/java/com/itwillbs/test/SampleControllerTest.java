package com.itwillbs.test;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

// @RunWith
// @ContextConfiguration
// -> 스프링으로 테스트 하겠다.
// @WebAppConfiguration
// => 스프링 MVC로 테스트 하겠다.

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"} // /spring/**/ -> 스프링 폴더안에 있는 모든 폴더/파일
		)
public class SampleControllerTest {
	
	// 로그정보 처리 객체 
	private static final Logger logger
		= LoggerFactory.getLogger(SampleControllerTest.class);
	
	
	// 객체 의존 주입
	@Inject
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	// -> 브라우저에서 페이지 요청, 응답을 처리하는 객체 
	// => 가상의 요청, 응답을 처리 
	
	@Before
	public void setup() {
		// Test 실행 전 준비 사항
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		
		logger.info("mockMvc 객체 생성완료 (준비 완료)");
		
	}
	
	@Test
	public void testDoA() throws Exception {
		logger.info(" Junit을 사용해서 컨트롤러 동작 실행 ");
		
		mockMvc.perform(MockMvcRequestBuilders.get("/doA"));
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
