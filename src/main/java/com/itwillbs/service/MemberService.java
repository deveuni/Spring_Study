package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.MemberVO;

public interface MemberService {
	// 서비스 계층
	
	// 회원 가입 (일반 회원가입/ SNS 계정-간단회원가입)
	// 요청을 일반회원가입, sns 회원가입 둘다 받아서 서비스계층에서 하나로 합쳐 dao로 간다.
	// MemberDAO 의 메소드와 일치해서 만듬.
	public void insertMember(MemberVO vo);
	
	// 회원 로그인 체크 
	// MemberDAO와 이름이 굳이 같지 않아도 되긴함. 같으면 좋음.
	public MemberVO loginMember(MemberVO vo);
	
	// ID를 사용해서 회원정보 가져오는 동작 
	public MemberVO readMember(String id);
	
	// 회원정보 수정
	public void updateMember(MemberVO vo);
	
	// 회원정보 삭제 
	public void deleteMember(MemberVO vo);
	
	// 회원 정보 
	public List<MemberVO> getMemberList();
	
	
	
	
	
}
