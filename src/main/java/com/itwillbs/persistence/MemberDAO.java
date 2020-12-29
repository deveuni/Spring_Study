package com.itwillbs.persistence;

import java.util.List;

import com.itwillbs.domain.MemberVO;

public interface MemberDAO {

	// 해당 도메인에 관련된 기능 선언(추상메서드) -> 구현
	
	// DB서버의 시간정보를 가져오기 
	public String getTime();
	
	// 회원가입(C create)
	public void insertMember(MemberVO vo);
	
	// 회원 정보 조회-사용자 ID해당하는 정보 (R read)
	public MemberVO readMember(String userid) throws Exception;
	
	// 회원 정보 조회 - ID,PW정보에 해당하는 사용자 정보 
	public MemberVO readMemberWithIDPW(String userid,String userpw) throws Exception;
	
	// 회원 정보 수정 - (U update)
	public void updateMember(MemberVO vo) throws Exception;
	
	// 회원 정보 삭제 - (D delete)
	public void deleteMember(MemberVO vo) throws Exception;
	
	// 회원정보 + List
	public List<MemberVO> listMember(); 
	
	
}
