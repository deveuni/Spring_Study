package com.itwillbs.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwillbs.domain.ProductVO;

@Controller
public class SampleController3 {
	
	// 로그정보 처리 객체 
	private static final Logger logger
	   = LoggerFactory.getLogger(SampleController3.class);
	
	// 페이지 이동시 객체 정보를 가지고 이동 
	// http://localhost:8088/test/doD
	@RequestMapping("doD")
	public String doD(Model model) {
		logger.info("doD() 호출");
		
		// 상품 객체 생성 
		ProductVO vo = new ProductVO("phone",100);
		
		// Model 객체 : 객체를 저장해서 뷰페이지로 전달(컨테이너)
		//model.addAttribute("vo", vo); // "키", object객체
		model.addAttribute(vo); //object 객체만
		// -> 객체 저장시 키값이 없을 경우,
		// -> 받아서 사용할 때 전달하는 클래스의 타입으로 호출
		// -> 클래스 타입의 첫글자를 소문자로 변경해서 호출
		// ProductVO -> productVO
		
		return "doDPage";
	}

}
