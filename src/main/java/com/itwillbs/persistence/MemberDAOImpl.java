package com.itwillbs.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.MemberVO;

// @Repository : DAO객체를 스프링에서 인식하도록 처리
//               DAO객체를 구현한 객체로 사용하도록 지정
// MemberDAOImpl 객체를 만들었다.
@Repository
public class MemberDAOImpl implements MemberDAO {
	// DAO 동작
	
	// DB 연결 (의존 주입)
	// 주입받은 SqlSession때문에 작성한 쿼리에 접근 가능
	// SqlSession은 root-context.xml에서 mapper로 접근이 가능하므로
	@Inject
	private SqlSession sqlSession;
	// -> Mapper가 있는 위치까지 접근
	
	
	// Mapper를 구분하는 값 -> Mapper가 여러개 있으므로 
	private static final String namespace
	  = "com.itwillbs.mapper.MemberMapper";
	
	@Override
	public String getTime() {
		System.out.println("DAO : DB접근 sqlSession객체를 주입!!!!!!");
		System.out.println("DAO : TEST에서 해당메서드 호출!!!!!");
		System.out.println("DAO : memberMapper.xml 이동");
		System.out.println("DAO : Select 구문을 실행하는 메서드를 실행해서 SQL구문 실행");
		// 데이터 하나를 리턴받는다.
		//"com.itwillbs.mapper.MemberMapper.getTime(id)";
		String result = sqlSession.selectOne(namespace+".getTime");
		System.out.println("DAO : SQL 구문 실행 완료! 값 리턴 테스트로 이동");
		
		return result;
	}
	
	
	@Override
	public void insertMember(MemberVO vo) {
		
		// 인자가 vo를 받아와서 sqlSession의 vo를 보내줌. 
		// 이 vo는 mapper 쿼리구문 vlaues값(#~)으로 들어감 
		// 이때 중요한 것은 컬럼명이랑 변수값이 같아야한다.
		sqlSession.insert(namespace+".insertMember", vo);
		
	}
	
	@Override
	public MemberVO readMember(String userid) throws Exception {

		System.out.println("DAO : readMember(userid) 호출");
		// 테스트(컨트롤러) 호출 -> 정보를 저장해서 -> DB
		
		// DB에 접근 가능하도록 생성한 객체
		// root에서 받아온 리턴타입으로 받음(다운캐스팅 필요없음. 스프링이 알아서 해줌)
		MemberVO vo = sqlSession.selectOne(namespace+".readMember",userid);
		
		
		
		return vo;
	}

	// 인터페이스 선언 -> 서브클래스 구현
	@Override
	public MemberVO readMemberWithIDPW(String userid, String userpw) throws Exception {
		
		Map<String, Object> paramMap 
		 = new HashMap<String,Object>();
		
		// 여기에서 key값은 mapper에서 바로 읽을 수 있는 값.
		paramMap.put("userid", userid);
		paramMap.put("userpw",userpw);
		
		
		// DB로 정보를 전달하기 위해서는 sqlSession 객체 활용
		// * 1개 이상의 정보를 전달할 때는 객체 단위로 전달 
		// * 객체(VO) 안에 저장이 안되는 정보의 경우 MAP을 사용
		// => key-value : 이때 key값은 sql구문의 #{ㅇㅇㅇ} 이름과 같아야함
		
		
		MemberVO vo = 
		sqlSession.selectOne(namespace+".readWithIDPW",paramMap);
		
		return vo;
		//return sqlSession.selectOne(namespace+".readWithIDPW",userid,userpw);
	}
	
	
	@Override
	public void updateMember(MemberVO vo) throws Exception {
		System.out.println("DAO : updateMember(vo) 호출");
		System.out.println("DAO : 정보 가지고 mapper 이동");
		
		sqlSession.update(namespace+".updateMember",vo);
		
	}
	
	@Override
	public void deleteMember(MemberVO vo) throws Exception {
		
		System.out.println("DAO : deleteMember(vo) 호출 ");
		System.out.println("DAO : mapper 사용 sql 호출");
		
		int check = sqlSession.delete(namespace+".deleteMember",vo);
		
		System.out.println("DAO : check -> "+check);
		System.out.println("DAO : SQL 실행완료, 서비스로 이동");
	}
	
	@Override
	public List<MemberVO> listMember(){
		System.out.println("DAO : listMember(vo) 호출");
		System.out.println("DAO : mapper 사용 해당 동작 호출 ");
		
		List<MemberVO> memberList =
		sqlSession.selectList(namespace+".listMember");
		
		System.out.println("DAO : SQL 실행완료");
		System.out.println("DAO :" +memberList);
		
		return memberList;
	}
	
	
	
}
