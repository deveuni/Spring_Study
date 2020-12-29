package com.itwillbs.domain;

// 도메인 : 프로젝트에서 중요한 의미를 가지는 명사
// ex) 회원, 글, 상품, 주문,...

// DTO == VO : 동일한 역할을 수행 (정보들을 한번에 저장해서 전달)

public class ProductVO {
	
	private String name;
	private double price;
	
	// alt + shift + s + o  생성자 만들기
	public ProductVO() {}
	public ProductVO(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}



	//alt + shift + s + s
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
	
	
	

}
