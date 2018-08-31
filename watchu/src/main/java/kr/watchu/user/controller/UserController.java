package kr.watchu.user.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.watchu.user.domain.ContactCommand;
import kr.watchu.user.domain.UserCommand;
import kr.watchu.user.service.ContactService;
import kr.watchu.user.service.UserService;
import kr.watchu.util.CipherTemplate;
import kr.watchu.util.PagingUtil;
import kr.watchu.util.StringUtil;

@Controller
public class UserController {
	
	private Logger log = Logger.getLogger(this.getClass());
	private int rowCount = 10;
	private int pageCount = 10;
	
	@Resource
	private UserService userService;
	
	@Resource
	private ContactService contactService;
	
	@Resource
	private CipherTemplate cipherAES;
	
	/*@Resource
	private SplitUtil split;*/
	//자바빈 초기화
	@ModelAttribute("command")
	public UserCommand initCommand() {
		return new UserCommand();
	}
	@ModelAttribute("contactCommand")
	public ContactCommand initContactCommand() {
		return new ContactCommand();
	}
	//==========================================회원가입========================================
	//회원가입 폼 호출
	@RequestMapping(value="/user/write.do",method=RequestMethod.GET)
	public String insertForm() {
		return "userWrite";
	}
	//회원가입 데이터 전송
	@RequestMapping(value="/user/write.do",method=RequestMethod.POST)
	public String insertSubmit(@ModelAttribute("command") @Valid UserCommand userCommand, BindingResult result, HttpSession session) {
		
		if(log.isDebugEnabled()) {
			log.debug("<<userCommand>> : "+userCommand);
		}
		
		if(result.hasErrors()) {
			return insertForm();
		}
		//암호화 처리
		userCommand.setPasswd(cipherAES.encrypt(userCommand.getPasswd()));
		
		userService.insertUser(userCommand);
		
	    //===회원가입 성공시 바로 로그인 처리===///
		session.setAttribute("user_id", userCommand.getId());
		//회원가입시 초기 auth 값 1을 등록해준다
		session.setAttribute("user_auth", 1);
		
		return "redirect:/main/main.do";
	}
	//==========================================회원수정========================================
	//회원수정 폼 호출
	@RequestMapping(value="/user/updateUser.do",method=RequestMethod.GET)
	public String modifyForm(HttpSession session,Model model) {
		
		String id = (String)session.getAttribute("user_id");
		
		UserCommand user = userService.selectUser(id);
		model.addAttribute("command",user);
		
		return "userModify";
	}
	//회원수정 데이터 전송
	@RequestMapping(value="/user/updateUser.do",method=RequestMethod.POST)
	public String updateSubmit(@ModelAttribute("command") @Valid UserCommand userCommand, BindingResult result) {
		
		if(log.isDebugEnabled()) {
			log.debug("<<memberCommand>> :" + userCommand);
		}
		if(result.hasErrors()) {
			return "userModify";
		}
		
		//암호화 처리
		userCommand.setPasswd(cipherAES.encrypt(userCommand.getPasswd()));
		
		//회원정보수정
		userService.updateUser(userCommand);
		
		return "redirect:/user/userMypage.do";
		
	}
	
	//==========================================회원삭제========================================
	//회원삭제 폼 호출
	@RequestMapping(value="/user/deleteUser.do",method=RequestMethod.GET)
	public String deleteForm(HttpSession session,Model model) {
		
		String id = (String)session.getAttribute("user_id");
		
		UserCommand user = new UserCommand();
		user.setId(id);
		
		model.addAttribute("command",user);
		
		return "userDelete";
	}
	//회원데이터 삭제
	@RequestMapping(value="/user/deleteUser.do",method=RequestMethod.POST)
	public String deleteSubmit(@ModelAttribute("command") @Valid UserCommand userCommand,BindingResult result,HttpSession session) {
		
		if(log.isDebugEnabled()) {
			log.debug("<<userCommand>>:"+ userCommand);
		}
		
		/*userService.deleteUser(userCommand.getId());
		//로그아웃
		session.invalidate();
		return "redirect:/main/main.do";*/
		//passwd 필드의 에러만 체크
		if(result.hasFieldErrors("passwd")) {
			return "userDelete";
		}
		
		//비밀번호 일치 여부 체크
				try {
					UserCommand user = userService.selectUser(userCommand.getId());
					boolean check = false;
					
					if(user!=null) {
						//비밀번호 일치 여부 체크
						check = user.isCheckedPasswd(cipherAES.encrypt(userCommand.getPasswd()));
					}
					if(check) {
						//인증성공, 회원정보 삭제
						userService.deleteUser(userCommand.getId());
						//로그아웃
						session.invalidate();
						return "redirect:/main/main.do";
					}else {
						//인증실패
						throw new Exception();
					}
				
				}catch(Exception e) {
					result.rejectValue("passwd", "invalidPassword");
					return "userDelete";
				}
	}
	
	//==========================================추천친구목록(회원전체 목록)========================================
	@RequestMapping("/user/follow.do")
	public ModelAndView follow(HttpSession session) {		
		
		String id = (String)session.getAttribute("user_id");
		UserCommand user = userService.selectUser(id);
		
		List<UserCommand> list = null;
		
		list = userService.selectfollowList();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("userfollow");
		mav.addObject("list",list);
		mav.addObject("user",user);
		
		return mav;
	}
	
	//==========================================팔로우버튼 처리(미완료)========================================
	@RequestMapping("/user/following.do")
	@ResponseBody
	public Map<String,String> follwing(@RequestParam(value="follow_id") String follow_id,@RequestParam(value="user_id") String user_id){

		if(log.isDebugEnabled()) {
			log.debug("<<follow_id~~~>>:" + follow_id);
		}
		if(log.isDebugEnabled()) {
			log.debug("<<user_id~~~>>:" + user_id);
		}

		
		UserCommand user = userService.selectUser(user_id);
		
		
		String origin_follow = user.getFollow();
		String new_follow = origin_follow+","+follow_id;
		
		if(log.isDebugEnabled()) {
			log.debug("<<new_follow~~~>>:" + new_follow);
		}
		
		userService.insertFollow(new_follow, user_id);//파라미터 안받아영...
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("result", "success");

		return map;
	}
		
	
	// ========================================타임라인================================================
	@RequestMapping("/user/userTimeline.do")
	public String timeline() {
		
		return "userTimeline";
	}
	
	// ========================================고객센터================================================
	//등록 폼
	@RequestMapping(value="/user/userSupportWrite.do",method=RequestMethod.GET)
	public String form(HttpSession session, Model model) {
		String id = (String)session.getAttribute("user_id");
		
		ContactCommand command = new ContactCommand();
		command.setId(id);
		
		model.addAttribute("command",command);
		
		return "userSupportWrite";
	}
	//전송된 데이터 처리
	@RequestMapping(value="/user/userSupportWrite.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("contactCommand") @Valid ContactCommand contactCommand,BindingResult result) {
		if(log.isDebugEnabled()) {
			log.debug("<<contactCommand>> : " + contactCommand);
		}
		if(result.hasErrors()) {
			return "userSupportWrite";
		}
		
		contactService.insertContact(contactCommand);
		
		return "redirect:/user/userSupportList.do";
	}
	
	//글 목록
	@RequestMapping("/user/userSupportList.do")
	public ModelAndView process(
			@RequestParam(value="pageNum",defaultValue="1") int currentPage,
			@RequestParam(value="keyfield",defaultValue="") String keyfield,
			@RequestParam(value="keyword",defaultValue="") String keyword
			) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("keyfield", keyfield);
		map.put("keyword", keyword);
		
		//총 글의 갯수 또는 검색된 글의 갯수
		int count = contactService.selectContactCnt(map);
		
		if(log.isDebugEnabled()) {
			log.debug("<<count>> : " + count);
		}
		PagingUtil page = new PagingUtil(keyfield,keyword,currentPage,count,rowCount,pageCount,"userSupportList.do");

		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		
		List<ContactCommand> list = null;
		if(count > 0) {
			list = contactService.selectContactList(map);
			
			if(log.isDebugEnabled()) {
				log.debug("<<list>> : " + list);
			}
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("userSupportList");
		mav.addObject("count", count);
		mav.addObject("list", list);
		mav.addObject("pagingHtml",page.getPagingHtml());
		
		return mav;
	}
	//게시판 글 상세
	@RequestMapping("/user/userSupport.do")
	public ModelAndView process(@RequestParam("contact_num") int contact_num) {
		if(log.isDebugEnabled()) {
			log.debug("<<contact_num>> : " + contact_num);
		}
		
		ContactCommand contact = contactService.selectContact(contact_num);
		//줄바꿈 처리
		contact.setContent(StringUtil.useBrNoHtml(contact.getContent()));
		
		return new ModelAndView("userSupportView","contact",contact);
	}
	
	//파일 다운로드
	
	//이미지 출력
	
	//게시판 글 수정
	//수정 폼
	//수정 폼에서 전송된 데이터 처리
	
	//게시판 글 삭제
	
}	
	
	
	
	