package kr.watchu.main.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.watchu.user.domain.UserCommand;
import kr.watchu.user.service.UserService;
import kr.watchu.util.CipherTemplate;

@Controller
public class MainController {
	
	private Logger log = Logger.getLogger(this.getClass());

	@Resource
	private UserService userService;

	@Resource
	private CipherTemplate cipherAES;
	
	//�ڹٺ� �ʱ�ȭ
	@ModelAttribute("command")
	public UserCommand initCommand() {
		return new UserCommand();
	}
	
	@RequestMapping("/main/main.do")
	public String process() {

		return "main";
	}

	//�α��� �� ȣ��
	@RequestMapping(value="/user/login.do",method=RequestMethod.GET)
	public String loginForm() {
		return "userLogin";
	}
	//�α���
	@RequestMapping(value="/user/login.do",method=RequestMethod.POST)
	public String submitLogin(@ModelAttribute("command") 
							  @Valid UserCommand userCommand, 
							  BindingResult result, HttpSession session) {
	    
		if(log.isDebugEnabled()) {
			log.debug("<<userCommand>> : " + userCommand);
		}
		
		if(result.hasFieldErrors("id") || result.hasFieldErrors("passwd")) {
			return loginForm();
		}
		
		try {
			UserCommand user = userService.selectUser(userCommand.getId());
			
			boolean check = false;
			if(user!=null) {
				//��й�ȣ ��ġ ���� üũ
				check = user.isCheckedPasswd(cipherAES.encrypt(userCommand.getPasswd()));
				if(log.isDebugEnabled()) {
					log.debug("<<��ġ����>> : " + check);
				}
			}
				
			if(check) {
				//���� ���� �α���
				session.setAttribute("user_id", user.getId());
				session.setAttribute("user_auth", user.getAuth());
				if(user.getProfile_img() == null) {
					session.setAttribute("profile", null);
				}else if(user.getProfile_img() != null) {
					session.setAttribute("profile", "found");
				}
				if(log.isDebugEnabled()) {
					log.debug("<<���� ����>>");
					log.debug("<<user_id>> : " + user.getId());
					log.debug("<<user_auth>> : " + user.getAuth());
				}
				
				return "redirect:/main/main.do";
			}else {
				//�������� 
				throw new Exception();
			}
		}catch(Exception e){
			//���� ����
			result.reject("invalidIdOrPasswd");
			
			if(log.isDebugEnabled()) {
				log.debug("<<���� ����>>");
			}
			
			return loginForm();
		}
	}
	//�α׾ƿ�
	@RequestMapping("/user/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/main/main.do";
	}

	//=========�̹��� ��========//
	@RequestMapping("/main/imageView.do")
	public ModelAndView viewImage(@RequestParam("id") String id) {
		
		UserCommand user = userService.selectUser(id);
		if(log.isDebugEnabled()) {
			log.debug("<<profile_img>> : " + user.getProfile_img());
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("imageView");
		mav.addObject("filename","profile.jpg");
		mav.addObject("imageFile", user.getProfile_img());
		return mav; 
	}
	
/*	@RequestMapping("/main/imageView.do")
	public ModelAndView viewImage(@RequestParam("movie_num") Integer movie_num) {
		
		if(log.isDebugEnabled()) {
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("imageView");
		mav.addObject("filename","profile.jpg");
		mav.addObject("imageFile");
		return mav; 
	}*/
}
