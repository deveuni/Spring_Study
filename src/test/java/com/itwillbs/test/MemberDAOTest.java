package com.itwillbs.test;

import javax.inject.Inject;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)

public class MemberDAOTest {
	// 스프링을 사용해서 DAO 테스트 (컨트롤러, 뷰) 
	
	// DB처리 객체 생성 MemberDAO
	// 의존 주입: root-context.xml -> persistence패키지 연결 
	// -> @Repository (해당 객체를 DAO객체로 지정) (업캐스팅)
	@Inject
	private MemberDAO mdao;
	
	// 주입 오류 원인 root.context.xml 파일에서 MemberDAO객체가 없기 때문에 
	// -> 추가해도 안됨 -> 디비 패키지안에 객체가 없기 때문에 -> MemberDAOImpl에 @Repository 추가 -> 가능해짐
	
	@Test
	public void testDAO() throws Exception{
		// DAO 생성 테스트
		System.out.println("TEST : DAO객체 생성@@@@ " + mdao);
	}
	
	@Test
	public void testGetTime() throws Exception{
		System.out.println("TEST : DAO 객체 주입 완료@@@");
		System.out.println("TEST : DAO_getTime() 메서드 호출");
		System.out.println("--------------------------------------");
		
		// DB의 시간정보를 확인 
		System.out.println(mdao.getTime());
		
		System.out.println("--------------------------------------");
	}
	
	// 회원가입 동작 실행 
	//@Test //-> 다음 실행할 때 똑같은 게 안나기 위해서
	public void testMemberInsert() throws Exception{
		
		MemberVO vo = new MemberVO("itwill", "1234", "itwill", "itwill@itwillbs.co.kr", null, null);
		
		mdao.insertMember(vo);
		
		// 한번더 실행하면 admin(pk) 중복뜨므로 에러난다.
		
	}
	
	// Read - 회원정보에 해당하는 값 가져오기
	// 리포지터리로 인해서 dao구현한 클래스 리턴함. 
	@Test
	public void readMember() {
		//read동작 처리
				try {
					System.out.println("@@@@@@@@@@@@@@@@@@@@@@");
					System.out.println(mdao.readMember("admin"));
					System.out.println("@@@@@@@@@@@@@@@@@@@@@@");
				} catch (Exception e) {
					e.printStackTrace();
				}
	}


	@Test
	public void readMemberIDPW() {
		try {
			System.out.println(mdao.readMemberWithIDPW("admin","1234"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testMemberUpdate() throws Exception {
		MemberVO vo = new MemberVO("itwill", "1234", "itwill555", "itwill555@naver.com", null, null);
		mdao.updateMember(vo);
	}
	
	@Test
	public void testMemberDelete() throws Exception{
		MemberVO vo = new MemberVO("itwill", "1234", "itwill555", "itwill555@naver.com", null, null);
		mdao.deleteMember(vo);
	}
	
	@Test
	public void testMemberList() throws Exception{
		System.out.println(mdao.listMember());
	}
	
	
	
	
}
