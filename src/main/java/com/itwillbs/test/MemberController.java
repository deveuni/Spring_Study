package com.itwillbs.test;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.service.MemberService;

@Controller
@RequestMapping(value = "/member/*")
public class MemberController {
	
	// 서비스 처리 객체를 주입(DI)
	@Inject
	private MemberService service;

	private static final Logger logger =
			LoggerFactory.getLogger(MemberController.class);
	
	
	// 회원 가입 처리 동작
	//http://localhost:8088/test/insert(X)
	//http://localhost:8088/test/member/insert(X)
	// 서버더블클릭 - 모듈즈 - 수정하기 - /만 남기기
	// http://localhost:8088/member/insert
	@RequestMapping(value = "/insert", method = RequestMethod.GET )
	public String insertGET() throws Exception {
		
		logger.info("C : 회원가입 페이지(정보입력)");
		logger.info("C : /member/insert -> /member/insertMember.jsp 페이지 이동");
		// views, controller - member맞춰야함.
		
		return "/member/insertMember";
	}
	
	@RequestMapping(value = "/insert", method =RequestMethod.POST )
	public String insertPOST(MemberVO vo) throws Exception{
		
		logger.info("C : 회원 가입 처리 페이지(정보처리)");
		logger.info("C : /member/insertMember.jsp -> 처리");
		
		// 0. 한글처리 - 서버정지한뒤
		// 1. 전달되는 정보 저장하기(파라미터값)
		//logger.info("C : " + request);
		logger.info("C : " + vo);
		// vo - 뷰페이지에서 입력한 파라미터 값들을 가지고옴(프레임워크에서 자체적으로 해줌-객체에 대한 셋/겟 메서드를 찾아와서 가져와줌_
		// 뷰페이지에서 name에 vo객체의 이름을 같기 했기 때문에 가능해짐.
		// 2. 서비스 객체 생성(의존주입)
		// 3. 서비스 회원가입 동작 호출
		service.insertMember(vo);
		logger.info("C : 회원가입 완료!");
		// 4. 로그인 페이지로 이동(GET)
		// [ /member/login ]
		
		return "redirect:/member/login";
	}
	
	
	// 로그인 처리
	// http://localhost:8088/member/login
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginGET() throws Exception {
		
		logger.info("C : 로그인 처리 페이지");
		logger.info("C : /member/login -> /member/loginForm.jsp  이동");
		
		return "/member/loginForm";
	}

	
	// http://localhost:8088/member/login (POST)
	// 로그인 처리(POST)
	// 로그인 하고 메인 페이지로 가기 때문에 특정 주소로 가야함 -> 리턴타입 받기
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPOST(MemberVO vo, HttpSession session, RedirectAttributes rttr/* , @ModelAttribute("userid") String id */) throws Exception{
		
		logger.info("C: loginPOST 동작");
		logger.info("C : loginForm.jsp -> /login(POST)");
		
		// 1. 전달정보를 저장(파라미터값: ID, PW)
		logger.info("C : " + vo); // 포함되면 vo 객체 단위로 들고 다니는 게 좋다. // get->post로 올때 받아온 값(로그인 입력창에서 받아옴)
		/* logger.info("C : id = " + id); */ // => @ModelAttribute("userid") String id : 이것때문에 주소에 아이디 파라미터가 넘어가게 됨. 
		// 2. 서비스 객체 생성 => 주입완료 
		// 3. 서비스 로그인 체크 동작 
		MemberVO returnVO = service.loginMember(vo); // DB에서 받아온 returnVO 안에 정보 다들어잇음!!
		logger.info("C : 결과 " + returnVO);
		// 4. 해당 결과에 따라 페이지 이동 제어 (이동에 대한 제어는 서비스에서 말고 컨트롤러에서 해도 된다.)
		//    - 해당 정보가 있을 경우 : -> main페이지
		//      -> 5. 세션값 생성
		//    - 해당 정보가 없을 경우 : -> login페이지
		if(returnVO == null) {
			// login(POST) -> login(GET)으로 이동
			return "redirect:/member/login";
		}

		
		// 정보를 전달하기 위해 session객체가 필요한데 여기 자바에서는 request, session객체가 없기 때문에 
		// 전달인자로 HttpSession 객체로 받아옴.
		// jsp 페이지 안에는 내장객체 session이 존재하므로 받아올 수 있음.
		// jsp페이지에서 post호출할 때 받아와진다.(vo 받아왔던것 처럼 session 정보도 받아 오겠다.)
		
		// 5. 세션값 생성
		session.setAttribute("id", returnVO.getUserid());
		
		// 세션 정보는 그 사이트에서 계속 가지고 다녀야함.
		// 이름이랑 이메일은 필요할 때만 찾아 쓰면 되므로 굳이 세션에 담아야 할까? - 서버에 부담이 많아지므로 별로다.
		// 이름, 이메일 returnVO로 받아왔으므로 여기서 꺼내면됨 !! Model객체를 사용해서 !!!!!!! 
		// Model은 정보 저장해서 넘기는 역할을 한다!! (컨트롤러 -> 뷰)
		// 하지만 model객체는 컨트롤러에 해당하는 뷰로 정보를 전달할 때 사용
		// 이 상황에서는 redirect로 받아와야함!(페이지 이동을 redirect로 할 때에는!!)
		/*
		 * session.setAttribute("name", returnVO.getUsername());
		 * session.setAttribute("email", returnVO.getUseremail());
		 */
		
		// 6. 정보 저장해서 view 페이지로 전달
		//model.addAttribute("mvo", returnVO);
		// * 페이지 redirect 이동시 RedirectAttributes객체를 사용한다.
		rttr.addFlashAttribute("mvo", returnVO);
		//rttr.addAttribute("mvo", returnVO);  (X)
		//rttr.addFlashAttribute("mvo", "Hello1234");
		return "redirect:/member/main";
	}
	
	// http://localhost:8088/member/main
	// main 페이지 
	@RequestMapping(value = "/main",method = RequestMethod.GET)
	public void mainGET(Model model) throws Exception {
		
		logger.info("C: main 페이지");
		logger.info("C : /main -> /member/main.jsp");
		
		logger.info("C : 전달된 사용자 정보 -> " + model);
		
	}
	
	//http://localhost:8088/member/logout
	// 로그아웃
	@RequestMapping(value = "/logout",method =RequestMethod.GET )
	public String logoutGET(HttpSession session) throws Exception{
		// logout 주소로 바꾸는 거니까 겟방식!!
		
		logger.info("C : 로그아웃 처리");
		// 세션 초기화 -> 로그아웃
		session.invalidate();
		
		return "redirect:/member/main";
	}
	
	
	
	// 회원 정보 확인(info) - 조회 
	// 정보를 뷰에 나타나는 것은 디비에 대한 접근이 아니므로 ?
	@RequestMapping(value = "/info",method = RequestMethod.GET)
	public void infoGET(HttpSession session, Model model) throws Exception{
		
		logger.info("C : infoGET() 호출");
		logger.info("C : /info -> /member/info.jsp(get)");
		
		
		// 필요한 정보를 가지고 뷰 페이지로 이동한다.
		// 세션 객체 안에 있는 ID 정보 저장 (로그인할 때 세션값 저장했당.)
		String id = (String)session.getAttribute("id");
		logger.info("C : ID 저장 완료"+id);
		
		// 서비스 - 회원 정보 가져오는 동작
		logger.info("C : 서비스 - readMember() 호출");
		MemberVO vo = service.readMember(id);
		
		logger.info("C : 서비스 처리 완료");
		logger.info("C : 결과 -> " + vo);
		
		
		// 정보 저장후 페이지 이동
		model.addAttribute("memVO", vo);
		logger.info("C : 모델 객체에 전달할 정보 저장완료");
		logger.info("C : 페이지 이동!!");
		
	}
	
	
	// 회원정보 수정(update)
	@RequestMapping(value = "/update",method = RequestMethod.GET)
	public String updateGET(HttpSession session, Model model) throws Exception{
		
		logger.info("C : updateGET() 호출");
		logger.info("C : /update -> (GET) ");
		
		// 해당 회원정보 가져오기 (id)
		//String id = (String)session.getAttribute("id");
		
		//MemberVO vo = service.readMember((String)session.getAttribute("id"));
		
		// 뷰 페이지로 전달
		model.addAttribute("memVO", service.readMember((String)session.getAttribute("id")));
		
		
		return "/member/updateForm";
	}
	
	// 회원정보 수정 처리(update)
	// http://localhost:8088/member/update
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public String updatePOST(MemberVO vo) throws Exception{
		
		logger.info("C: updatePOST 동작");
		logger.info("C : /updateForm.jsp -> /main");
		
		// 1. updateForm페이지에서 입력받은 정보를 전달 받기(전달된 파라미터 저장)
		logger.info("C : 수정할 정보 -> " + vo);
		// 2. 정보를 가지고 수정하기 위해 이동(서비스객체)
		service.updateMember(vo);
		logger.info("C : 정보 수정완료!");
		// 3. 서비스 -> DAO 호출 -> Mapper 호출
		// 4. 정보수정 완료 후 메인페이지 이동
		
		return "redirect:/member/main";
	}
	
	
	// 회원정보 삭제
	// http://localhost:8088/member/delete
	@RequestMapping(value = "/delete",method = RequestMethod.GET)
	public String deleteGET(HttpSession session, Model model) throws Exception{
		
		logger.info("C : /member/delete -> /member/deleteForm.jsp");
		
		// 세션제어 
		String id = (String) session.getAttribute("id");
		if(id == null) {
			return "redirect:/member/main";
		}
		model.addAttribute("memVO", id);
		
		return "member/deleteForm";
		
	}
	
	
	@RequestMapping(value = "/delete",method = RequestMethod.POST)
	public String deletePOST(MemberVO vo, HttpSession session) throws Exception{
		
		logger.info("C : /member/delete(post) -> /member/main");
		
		// 1. 파라미터 저장
		logger.info("C 삭제할 정보 ->"+vo);
		
		// 2. 전달받은 정보를 가지고 삭제 동작 처리
		// 3. service 객체 - 동작
		service.deleteMember(vo);
		
		// 4. 세션 초기화
		session.invalidate();

		logger.info("C : 회원정보 삭제!");
		
		// 5. 페이지 이동
		return "redirect:/member/login";
	}
	
	// 회원 정보 리스트(GET)
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public String listGET(HttpSession session,MemberVO vo,Model model) throws Exception{
		// 관리자만 사용하는 기능 
		logger.info("C /member/list -> /member/memberlist.jsp");
		// 1. 관리자 세션 제어
		String id = (String)session.getAttribute("id");
		if(id == null || !(id.equals("admin"))) {
			logger.info("C : 관리자 아닌 접근 ID" + id);
			
			return "redirect:/member/main";
		}
		
		logger.info("C : 회원정보" + vo);
		
		// 2. 서비스 - 회원 목록 가져오는 동작
		
		List<MemberVO> memberList =
		service.getMemberList();
		
		
		// 3. 정보 저장 -> 뷰(/member/memberlist.jsp)
		//    (Model 객체)
		model.addAttribute("memberList", memberList);
		
		
		
		return "/member/memberlist";
	}
	
	
	
	
	
	
	
	
	
	
}
