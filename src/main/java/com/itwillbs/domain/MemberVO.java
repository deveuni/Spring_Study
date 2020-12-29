package com.itwillbs.domain;

import java.sql.Timestamp;

/*                  
 *   도메인(domain) : 개발(프로젝트)에서 가장 중요한 용어(단어) '명사'
 *   -> 회원, 상품, 글, 주문, 배송,... (1차 도메인) 
 *   -> 회원 - 가입, 탈퇴, 수정,... (2차 도메인)
 *   => '물리적인 환경으로 분리가 가능한 단위'
 *    -> DB 테이블을 구분할 수 있다.
 */
public class MemberVO {
	// tbl_member 테이블정보 처리 객체 
	private String userid;
	private String userpw;
	private String username;
	private String useremail;
	private Timestamp regdate;
	private Timestamp updatedate;
	
	// alt shift s o
	public MemberVO() {}
	public MemberVO(String userid, String userpw, String username, String useremail, Timestamp regdate,
			Timestamp updatedate) {
		super();
		this.userid = userid;
		this.userpw = userpw;
		this.username = username;
		this.useremail = useremail;
		this.regdate = regdate;
		this.updatedate = updatedate;
	}
	
	// alt shift s r
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	public Timestamp getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Timestamp updatedate) {
		this.updatedate = updatedate;
	}
	
	
	// alt shift s s
	@Override
	public String toString() {
		return "MemberVO [userid=" + userid + ", userpw=" + userpw + ", username=" + username + ", useremail="
				+ useremail + ", regdate=" + regdate + ", updatedate=" + updatedate + "]";
	}
	
	
	
	

	
	
	
	
	
	
}
