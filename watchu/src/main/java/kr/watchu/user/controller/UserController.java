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
	//�ڹٺ� �ʱ�ȭ
	@ModelAttribute("command")
	public UserCommand initCommand() {
		return new UserCommand();
	}
	@ModelAttribute("contactCommand")
	public ContactCommand initContactCommand() {
		return new ContactCommand();
	}
	//==========================================ȸ������========================================
	//ȸ������ �� ȣ��
	@RequestMapping(value="/user/write.do",method=RequestMethod.GET)
	public String insertForm() {
		return "userWrite";
	}
	//ȸ������ ������ ����
	@RequestMapping(value="/user/write.do",method=RequestMethod.POST)
	public String insertSubmit(@ModelAttribute("command") @Valid UserCommand userCommand, BindingResult result, HttpSession session) {
		
		if(log.isDebugEnabled()) {
			log.debug("<<userCommand>> : "+userCommand);
		}
		
		if(result.hasErrors()) {
			return insertForm();
		}
		//��ȣȭ ó��
		userCommand.setPasswd(cipherAES.encrypt(userCommand.getPasswd()));
		
		userService.insertUser(userCommand);
		
	    //===ȸ������ ������ �ٷ� �α��� ó��===///
		session.setAttribute("user_id", userCommand.getId());
		//ȸ�����Խ� �ʱ� auth �� 1�� ������ش�
		session.setAttribute("user_auth", 1);
		
		return "redirect:/main/main.do";
	}
	//==========================================ȸ������========================================
	//ȸ������ �� ȣ��
	@RequestMapping(value="/user/updateUser.do",method=RequestMethod.GET)
	public String modifyForm(HttpSession session,Model model) {
		
		String id = (String)session.getAttribute("user_id");
		
		UserCommand user = userService.selectUser(id);
		model.addAttribute("command",user);
		
		return "userModify";
	}
	//ȸ������ ������ ����
	@RequestMapping(value="/user/updateUser.do",method=RequestMethod.POST)
	public String updateSubmit(@ModelAttribute("command") @Valid UserCommand userCommand, BindingResult result) {
		
		if(log.isDebugEnabled()) {
			log.debug("<<memberCommand>> :" + userCommand);
		}
		if(result.hasErrors()) {
			return "userModify";
		}
		
		//��ȣȭ ó��
		userCommand.setPasswd(cipherAES.encrypt(userCommand.getPasswd()));
		
		//ȸ����������
		userService.updateUser(userCommand);
		
		return "redirect:/user/userMypage.do";
		
	}
	
	//==========================================ȸ������========================================
	//ȸ������ �� ȣ��
	@RequestMapping(value="/user/deleteUser.do",method=RequestMethod.GET)
	public String deleteForm(HttpSession session,Model model) {
		
		String id = (String)session.getAttribute("user_id");
		
		UserCommand user = new UserCommand();
		user.setId(id);
		
		model.addAttribute("command",user);
		
		return "userDelete";
	}
	//ȸ�������� ����
	@RequestMapping(value="/user/deleteUser.do",method=RequestMethod.POST)
	public String deleteSubmit(@ModelAttribute("command") @Valid UserCommand userCommand,BindingResult result,HttpSession session) {
		
		if(log.isDebugEnabled()) {
			log.debug("<<userCommand>>:"+ userCommand);
		}
		
		/*userService.deleteUser(userCommand.getId());
		//�α׾ƿ�
		session.invalidate();
		return "redirect:/main/main.do";*/
		//passwd �ʵ��� ������ üũ
		if(result.hasFieldErrors("passwd")) {
			return "userDelete";
		}
		
		//��й�ȣ ��ġ ���� üũ
				try {
					UserCommand user = userService.selectUser(userCommand.getId());
					boolean check = false;
					
					if(user!=null) {
						//��й�ȣ ��ġ ���� üũ
						check = user.isCheckedPasswd(cipherAES.encrypt(userCommand.getPasswd()));
					}
					if(check) {
						//��������, ȸ������ ����
						userService.deleteUser(userCommand.getId());
						//�α׾ƿ�
						session.invalidate();
						return "redirect:/main/main.do";
					}else {
						//��������
						throw new Exception();
					}
				
				}catch(Exception e) {
					result.rejectValue("passwd", "invalidPassword");
					return "userDelete";
				}
	}
	
	//==========================================��õģ�����(ȸ����ü ���)========================================
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
	
	//==========================================�ȷο��ư ó��(�̿Ϸ�)========================================
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
		
		userService.insertFollow(new_follow, user_id);//�Ķ���� �ȹ޾ƿ�...
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("result", "success");

		return map;
	}
		
	
	// ========================================Ÿ�Ӷ���================================================
	@RequestMapping("/user/userTimeline.do")
	public String timeline() {
		
		return "userTimeline";
	}
	
	// ========================================������================================================
	//��� ��
	@RequestMapping(value="/user/userSupportWrite.do",method=RequestMethod.GET)
	public String form(HttpSession session, Model model) {
		String id = (String)session.getAttribute("user_id");
		
		ContactCommand command = new ContactCommand();
		command.setId(id);
		
		model.addAttribute("command",command);
		
		return "userSupportWrite";
	}
	//���۵� ������ ó��
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
	
	//�� ���
	@RequestMapping("/user/userSupportList.do")
	public ModelAndView process(
			@RequestParam(value="pageNum",defaultValue="1") int currentPage,
			@RequestParam(value="keyfield",defaultValue="") String keyfield,
			@RequestParam(value="keyword",defaultValue="") String keyword
			) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("keyfield", keyfield);
		map.put("keyword", keyword);
		
		//�� ���� ���� �Ǵ� �˻��� ���� ����
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
	//�Խ��� �� ��
	@RequestMapping("/user/userSupport.do")
	public ModelAndView process(@RequestParam("contact_num") int contact_num) {
		if(log.isDebugEnabled()) {
			log.debug("<<contact_num>> : " + contact_num);
		}
		
		ContactCommand contact = contactService.selectContact(contact_num);
		//�ٹٲ� ó��
		contact.setContent(StringUtil.useBrNoHtml(contact.getContent()));
		
		return new ModelAndView("userSupportView","contact",contact);
	}
	
	//���� �ٿ�ε�
	
	//�̹��� ���
	
	//�Խ��� �� ����
	//���� ��
	//���� ������ ���۵� ������ ó��
	
	//�Խ��� �� ����
	
}	
	
	
	
	