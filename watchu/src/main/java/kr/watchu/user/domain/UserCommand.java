package kr.watchu.user.domain;

import java.io.IOException;
import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class UserCommand {
	
	private String id;
	private int auth;
	private String passwd;
	private String name;
	private String phone;
	private String email;
	private MultipartFile upload;
	private byte[] profile_img;
	private Date reg_date;
	private String follow;
	private String follower;
	private String block;
	
	//비밀번호 체크
	public boolean isCheckedPasswd(String userPasswd) {
		if(auth > 0 && passwd.equals(userPasswd)) {
			return true;
		}
		return false;
	}
	
	public void setUpload(MultipartFile upload) throws IOException{
		this.upload = upload;
		setProfile_img(upload.getBytes()); 
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public int getAuth() {
		return auth;
	}

	public void setAuth(int auth) {
		this.auth = auth;
	}

	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public MultipartFile getUpload() {
		return upload;
	}
	
	public byte[] getProfile_img() {
		return profile_img;
	}
	public void setProfile_img(byte[] profile_img) {
		this.profile_img = profile_img;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public String getFollow() {
		return follow;
	}
	public void setFollow(String follow) {
		this.follow = follow;
	}
	public String getFollower() {
		return follower;
	}
	public void setFollower(String follower) {
		this.follower = follower;
	}
	public String getBlock() {
		return block;
	}
	public void setBlock(String block) {
		this.block = block;
	}
}
