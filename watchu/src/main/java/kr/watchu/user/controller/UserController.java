package kr.watchu.user.controller;


import java.util.ArrayList;
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
import kr.watchu.util.SplitUtil;
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
	
	//==========================================��õģ�����========================================
	@RequestMapping("/user/follow.do")
	public ModelAndView follow(@RequestParam(value="id") String id,
							   @RequestParam(value="pageNum",defaultValue="1") int currentPage,
							   @RequestParam(value="keyfield",defaultValue="") String keyfield,
			                   @RequestParam(value="keyword",defaultValue="") String keyword) {		
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("keyfield", keyfield);
		map.put("keyword", keyword);
		
		//�ѱ��� ���� �Ǵ� �˻��� ���� ����
		int count = userService.selectUserCnt(map);
		if(log.isDebugEnabled()) {
			log.debug("<<count>>:" + count);
		}
		
		PagingUtil page = new PagingUtil(keyfield,keyword,currentPage,count,rowCount,pageCount,"follow.do");
		
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		
		//--------------------------------------------
		
		UserCommand user = userService.selectUser(id);
		ModelAndView mav = new ModelAndView();
		
		//����
		List<String> follow_id3 = new ArrayList<String>();
		
		if(user.getFollow() != null) {
			String follow_id = user.getFollow();
			String[] follow_id2 = SplitUtil.splitByComma(follow_id);//��ǥ����
		
			//for�� ������ String�迭��� Array����Ʈ�� �ֱ�
			for(int i=0;i<follow_id2.length; i++) {
				follow_id3.add(follow_id2[i]);
			}
			
		}else {
			follow_id3.clear();
		}
		//�α�Ȯ��
		if(log.isDebugEnabled()) {
			log.debug("<<�١�follow_id3~~~>>:" + follow_id3);
		}
		mav.addObject("follow",follow_id3);
		
		//��
		
		//��õģ�� ����or�˻���ģ�� ����Ʈ���
		List<UserCommand> list = null;
		list = userService.selectUserList(map);
		//----------------------------------------------
	
		
		mav.setViewName("userfollow");
		mav.addObject("list",list);
		mav.addObject("count",count);
		mav.addObject("pagingHtml",page.getPagingHtml());
		mav.addObject("user",user);
		
		
		return mav;
	}
	
	//�ȷο��ư ó��
	@RequestMapping("/user/following.do")
	@ResponseBody
	public Map<String,String> follwing(@RequestParam(value="follow_id") String follow_id,@RequestParam(value="user_id") String user_id){

		UserCommand user = userService.selectUser(user_id);//�� Ŀ�ǵ�
		UserCommand follow_user = userService.selectUser(follow_id);//���� �ȷο��ѻ���� Ŀ�ǵ�
		
		//------------------�� Ŀ�ǵ� follow�� �߰�
		if(user.getFollow() == null) {//���� �ȷο��ѻ�� ������ �׳� �߰�
			user.setFollow(follow_id);
		}else{//������ ��ǥ��� ���� �ȷο��� ��� �߰�
			String origin_follow = user.getFollow();
			String new_follow = origin_follow+","+follow_id;
			user.setFollow(new_follow);
		}
		//�� follow update
		userService.insertFollow(user);
		
		//-----------------���� �ȷο��� ����� Ŀ�ǵ� follower�� ���� �߰�
		if(follow_user.getFollower() == null) {//�ȷο� ��������� �׳� �߰�
			follow_user.setFollower(user_id);
		}else {//������ ��ǥ��� �߰�
			String origin_follower = follow_user.getFollower();
			String new_follow = origin_follower+","+user_id;
			follow_user.setFollower(new_follow);
		}
		//���� follower update
		userService.insertFollower(follow_user);
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("result", "success");

		return map;
	}
	
	//���ȷο��ư ó��
	@RequestMapping("/user/unfollow.do")
	@ResponseBody
	public Map<String,String> unfollow(@RequestParam(value="unfollow_id") String unfollow_id,@RequestParam(value="user_id") String user_id){
		
		ModelAndView mav = new ModelAndView();
		UserCommand user = userService.selectUser(user_id);//�� Ŀ�ǵ�
		UserCommand unfollow_user = userService.selectUser(unfollow_id);//���� �����ѻ���� Ŀ�ǵ�
		
		//------------------------------------------------
		//�� follow�� �ִ� ģ���� ��ǥ�����ؼ� arrayList�� ����� ����
		List<String> user_follow3 = new ArrayList<String>();

		if(user.getFollow() != null) {
			String user_follow = user.getFollow();
			String[] user_follow2 = SplitUtil.splitByComma(user_follow);//��ǥ����

			//for�� ������ String�迭��� Array����Ʈ�� �ֱ�
			for(int i=0;i<user_follow2.length; i++) {
				user_follow3.add(user_follow2[i]);
			}

		}else {
			user_follow3.clear();
		}
		
		mav.addObject("follow",user_follow3);
		//�� follow�� �ִ� ģ���� ��ǥ�����ؼ� arrayList�� ����� ��
		
		//�� follow���� ������ ģ�� �����
		if(user_follow3.contains(unfollow_id)==true) {//���ȴ����� ���̵� �� ģ����Ͽ� ������
			user_follow3.remove(unfollow_id);
		}

		//���������� follow_id3��ҵ��� �ٽ� ��ǥ�ٿ��� String���ڿ��� �����
		String followback = "";
		if(user_follow3.isEmpty()) {//��� �����ؼ� follow ���������
			followback = "";
		}else {//follow�� �Ѹ��̻� �������

			for(int i=0; i<user_follow3.size(); i++) {
				followback += user_follow3.get(i) + "," ;
			}
			//������ ��ǥ�� �����ؾߴ�
			followback = followback.substring(0,followback.length()-1);//�ε���0~������������ ���ڸ� ������
		}
		
		user.setFollow(followback);

		//�� follow update
		userService.insertFollow(user);
		//-------------------------------------------------
		
		//���� �����ѻ���� follwer�� ��ǥ�����ؼ� arrayList�� ����� ����
		List<String> unfollow_follower3 = new ArrayList<String>();
		if(unfollow_user.getFollower() != null) {
			String unfollow_follower = unfollow_user.getFollower();
			String[] unfollow_follower2 = SplitUtil.splitByComma(unfollow_follower);//��ǥ����
			
			//for�� ������ String�迭��� Array����Ʈ�� �ֱ�
			for(int i=0;i<unfollow_follower2.length; i++) {
				unfollow_follower3.add(unfollow_follower2[i]);
			}
		}else {
			unfollow_follower3.clear();
		}
		//���� �����ѻ���� follwer�� ��ǥ�����ؼ� arrayList�� ����� ��
		
		//���� follower���� �� �����
		if(unfollow_follower3.contains(user_id)==true) {
			unfollow_follower3.remove(user_id);
		}
		//unfollow_follower3��ҵ��� �ٽ� ��ǥ�ٿ��� String���ڿ��� �����
		String followerback ="";
		if(unfollow_follower3.isEmpty()) {
			followerback="";
		}else {
			for(int i =0;i<unfollow_follower3.size();i++) {
				followerback += unfollow_follower3.get(i) + ",";
			}
			//������ ��ǥ�� ����
			followerback= followerback.substring(0,followerback.length()-1);//�ε���0~������������ ���ڸ� ������
		}
		
		unfollow_user.setFollower(followerback);
		
		//���� follower update
		userService.insertFollower(unfollow_user);
		//----------------------------------------------------
		
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
		
		ContactCommand contactCommand = new ContactCommand();
		contactCommand.setId(id);
		
		model.addAttribute("command",contactCommand);
		
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
	@RequestMapping("/user/userSupportView.do")
	public ModelAndView process(@RequestParam(value="contact_num",required=true) int contact_num) {
		if(log.isDebugEnabled()) {
			log.debug("<<contact_num>> : " + contact_num);
		}
		
		ContactCommand contact = contactService.selectContact(contact_num);
		//�ٹٲ� ó�� 
		contact.setContent(StringUtil.useBrNoHtml(contact.getContent()));
		
		return new ModelAndView("userSupportView","contact",contact);
	}
	
	//���� �ٿ�ε�
	@RequestMapping("/user/file.do")
	public ModelAndView download(@RequestParam("contact_num")int contact_num) {
		ContactCommand contact = contactService.selectContact(contact_num);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("downloadView");
		mav.addObject("downloadFile",contact.getUpload_file());
		mav.addObject("filename",contact.getFilename());
		
		return mav;
	}
	
	//�̹��� ���
	@RequestMapping("/user/imageView.do")
	public ModelAndView viewImage(@RequestParam("contact_num") int contact_num) {
		ContactCommand contact = contactService.selectContact(contact_num);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("imageView");
		mav.addObject("imageFile",contact.getUpload_file());
		mav.addObject("filename",contact.getFilename());
		
		return mav; 
	}
	
	//�Խ��� �� ����
	//���� ��
	@RequestMapping(value="/user/userSupportUpdate.do",method=RequestMethod.GET)
	public String form(@RequestParam("contact_num") int contact_num, Model model) {
		ContactCommand contactCommand = contactService.selectContact(contact_num);
		model.addAttribute("contactCommand", contactCommand);
		
		return "userSupportModify";
	}
	//���� ������ ���۵� ������ ó��
	@RequestMapping(value="/user/userSupportUpdate.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("contactCommand") 
						 ContactCommand contactCommand, 
						 BindingResult result,
						 HttpSession session, 
						 HttpServletRequest request) {
		if(log.isDebugEnabled()) {
			log.debug("<<contactCommand>> : " + contactCommand);
		}
		
		ContactCommand contact = contactService.selectContact(contactCommand.getContact_num());
		
		if(result.hasErrors()) {
			contactCommand.setFilename(contact.getFilename());
			return "userSupportModify";
		}
		
		if(contactCommand.getUpload().isEmpty()) {
			contactCommand.setUpload_file(contact.getUpload_file());
			contactCommand.setFilename(contact.getFilename());
		}
		
		contactService.updateContact(contactCommand);

		return "redirect:/user/userSupportList.do"; 
	}
	
	//�Խ��� �� ����
	@RequestMapping("/user/userSupportDelete.do")
	public String submit(@RequestParam("contact_num")int contact_num) {
		if(log.isDebugEnabled()) {
			log.debug("<<contact_num>> : " + contact_num);
		}
		contactService.deleteContact(contact_num);
		
		return "redirect:/user/userSupportList.do";
	}
	
	
	
	//===============================================�ٸ����� ������===============================================
	@RequestMapping("/user/userPage.do")
	public ModelAndView anotherUserpage(HttpSession session,@RequestParam("id") String id) {
		
		ModelAndView mav = new ModelAndView();
		
		String my_id = (String)session.getAttribute("user_id");
		UserCommand anotheruser = userService.selectUser(id);//�ٸ����� Ŀ�ǵ�
		UserCommand user = userService.selectUser(my_id);//�� Ŀ�ǵ�
		
		//�ٸ����� �ȷ��� ���� ǥ���ϱ����� ģ�� arraylist����
		List<String> follow3 = new ArrayList<String>();

		if(anotheruser.getFollow() != null) {
			String follow = anotheruser.getFollow();
			String[] follow2 = SplitUtil.splitByComma(follow);//��ǥ����

			//for�� ������ String�迭��� Array����Ʈ�� �ֱ�
			for(int i=0;i<follow2.length; i++) {
				follow3.add(follow2[i]);
			}

		}else {
			follow3.clear();//null���� ���ֹ���
		}

		//�ȷο� ����
		List<String> follower3 = new ArrayList<String>();
		if(anotheruser.getFollower() != null) {
			String follower = anotheruser.getFollower();
			String[] follower2 = SplitUtil.splitByComma(follower);//��ǥ����

			//for�� ������ String�迭��� Array����Ʈ�� �ֱ�
			for(int i=0;i<follower2.length; i++) {
				follower3.add(follower2[i]);
			}
		}else {
			follower3.clear();
		}
		
		//�� ģ����� ���ϱ� 
		//�� follow�� �ִ� ģ���� ��ǥ�����ؼ� arrayList�� ����� ����
		List<String> user_follow3 = new ArrayList<String>();

		if(user.getFollow() != null) {
			String user_follow = user.getFollow();
			String[] user_follow2 = SplitUtil.splitByComma(user_follow);//��ǥ����

			//for�� ������ String�迭��� Array����Ʈ�� �ֱ�
			for(int i=0;i<user_follow2.length; i++) {
				user_follow3.add(user_follow2[i]);
			}

		}else {
			user_follow3.clear();
		}
		//�� follow�� �ִ� ģ���� ��ǥ�����ؼ� arrayList�� ����� ��
		
		//�� Ŀ�ǵ忡 ��� ��ǥ���� arrayList�� �����
		List<String> blockList = new ArrayList<String>();
		if(user.getBlock() != null) {
			String block = user.getBlock();
			String[] block2 = SplitUtil.splitByComma(block);//��ǥ����

			//for�� ������ String�迭��� Array����Ʈ�� �ֱ�
			for(int i=0;i<block2.length; i++) {
				blockList.add(block2[i]);
			}
		}else {
			blockList.clear();
		}
		
		
		mav.setViewName("userPage");
		mav.addObject("anotheruser",anotheruser);
		mav.addObject("user",user);
		mav.addObject("list",follow3);
		mav.addObject("list2",follower3);
		mav.addObject("mylist",user_follow3);
		mav.addObject("blockList",blockList);
		
		return mav;
	}
	
	
	//blockó��
	@RequestMapping("/user/block.do")
	@ResponseBody
	public Map<String,String> block(HttpSession session,@RequestParam("block_id") String block_id) {
		
		ModelAndView mav = new ModelAndView();
		
		String my_id = (String)session.getAttribute("user_id");
		UserCommand user = userService.selectUser(my_id);//�� Ŀ�ǵ�
		
		//�� Ŀ�ǵ忡 ��� �߰�
		if(user.getBlock() ==null) {
			user.setBlock(block_id);
		}else {
			String origin_block = user.getBlock();
			String new_block = origin_block +","+ block_id;
			user.setBlock(new_block);
		}
		//DB�� ��� �߰�
		userService.insertBlock(user);
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("result", "success");
		
		return map;
		
	}
	
	//unblockó��
	@RequestMapping("/user/unblock.do")
	@ResponseBody
	public Map<String,String> unblock(HttpSession session,@RequestParam("unblock_id") String unblock_id) {

		ModelAndView mav = new ModelAndView();

		String my_id = (String)session.getAttribute("user_id");
		UserCommand user = userService.selectUser(my_id);//�� Ŀ�ǵ�
		
		//�� Ŀ�ǵ忡 ��� ��ǥ���� arrayList�� �����
		List<String> blockList = new ArrayList<String>();
		if(user.getBlock() != null) {
			String block = user.getBlock();
			String[] block2 = SplitUtil.splitByComma(block);//��ǥ����
			
			//for�� ������ String�迭��� Array����Ʈ�� �ֱ�
			for(int i=0;i<block2.length; i++) {
				blockList.add(block2[i]);
			}
		}else {
			blockList.clear();
		}
		mav.addObject("blockList",blockList);
		//�� block���� ��������� ģ�� �����
		if(blockList.contains(unblock_id)==true) {
			blockList.remove(unblock_id);
		}
		//���������ģ�� ���� arraylist�� �ٽ� String���ڿ��� ����
		String blockList2 = "";
		if(blockList.isEmpty()) {
			blockList2 = "";
		}else {
			for(int i=0; i<blockList.size(); i++) {
				blockList2 += blockList.get(i) + "," ;
			}
			//������ ��ǥ�� �����ؾߴ�
			blockList2 = blockList2.substring(0,blockList2.length()-1);//�ε���0~������������ ���ڸ� ������
		}
		
		user.setBlock(blockList2);
		//�� block update
		userService.insertBlock(user);
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("result", "success");

		return map;

	}
	
	
}	
	



	
	
	