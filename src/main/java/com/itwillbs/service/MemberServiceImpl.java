package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;

// @Service : 해당 클래스를 서비스 객체로 처리하겠다.(스프링에서 인식)
// 호출은 인터페이스 서비스를 부르지만 실제로 실행은 구현한 서비스를 한다.
// 컨트롤러에서 DAO로 직접 접근하지 못하게 제어 동작을 함.(종속되지 않도록)

@Service
public class MemberServiceImpl implements MemberService {
	
	// DB처리를 하기 위한 객체 주입
	@Inject
	private MemberDAO mdao;
	
	@Override
	public void insertMember(MemberVO vo) {
		// 컨트롤러 -> 서비스 호출 -> DAO -> Mapper -> DB
		System.out.println("Service : 회원가입 동작");
		if(vo == null) {
			//처리
			return;
		}
		mdao.insertMember(vo);
	}

	
	@Override
	public MemberVO loginMember(MemberVO vo) {
		System.out.println("S : 컨트롤러에서 호출");
		System.out.println("S : 필요한 정보를 받아서 DAO 전달");
		MemberVO returnVO = null;
		try {
			// DAO 객체 생성 (DI)
			returnVO = mdao.readMemberWithIDPW(vo.getUserid(), vo.getUserpw());
			// vo로 받아도 되는데 쿼리작성할 때 id, pw로 받았기 때문에 vo 객체에서 꺼내온 방식
		} catch (Exception e) {
			e.printStackTrace();
			returnVO = null; // 예외처리 실행하다가 문제가 생겼을 때에는 데이터를 null로 넘기면서 앞의 문제가 있다는 것을 알리기 위해 
		}
		
		return returnVO;
	}
	
	
	@Override
	public MemberVO readMember(String id) {
		System.out.println("S : readMember(id) 호출");
		System.out.println("S : DAO 객체 생성(DI) - 메서드 호출");
		
		MemberVO vo = null;
		 try {
			vo = mdao.readMember(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return vo;
	}
	
	
	@Override
	public void updateMember(MemberVO vo) {
		System.out.println("S : updateMember(vo) 호출");
		System.out.println("S : DAO 객체 생성(DI) - 메서드 호출");
		
		try {
			mdao.updateMember(vo);
			
			System.out.println("S : 회원정보 수정완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void deleteMember(MemberVO vo) {
		System.out.println("S : deleteMember(vo) 호출");
		System.out.println("S : DAO 객체 생성(DI) - 메서드 호출");
		
		try {
			mdao.deleteMember(vo);
			
			System.out.println("S : 회원정보 삭제 완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public List<MemberVO> getMemberList() {
		
		System.out.println("S : listMember() 호출 ");
		System.out.println("S : DAO - 회원정보 리스트가져오기 동작 호출");
		
		// DAO객체(DI) - 해당 동작 메서드 호출
		List<MemberVO> memberList 
		   = mdao.listMember();
		
		System.out.println("S : DAO 처리 완료");
		System.out.println("S : "+memberList);
		
		return memberList;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
