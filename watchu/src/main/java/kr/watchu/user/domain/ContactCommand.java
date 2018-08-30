package kr.watchu.user.domain;

import java.io.IOException;
import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class ContactCommand {
	private Integer contact_num;
	private String id;
	private String content;
	private MultipartFile upload;
	private String filename;
	private byte[] upload_file;
	private Date reg_date;
	private int recotentable;
	
	public Integer getContact_num() {
		return contact_num;
	}
	public void setContact_num(Integer contact_num) {
		this.contact_num = contact_num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public MultipartFile getUpload() {
		return upload;
	}
	public void setUpload(MultipartFile upload) throws IOException {
		this.upload = upload;
		setFilename(upload.getOriginalFilename());
		setUpload_file(upload.getBytes());
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public byte[] getUpload_file() {
		return upload_file;
	}
	public void setUpload_file(byte[] upload_file) {
		this.upload_file = upload_file;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public int getRecotentable() {
		return recotentable;
	}
	public void setRecotentable(int recotentable) {
		this.recotentable = recotentable;
	}
	@Override
	public String toString() {
		return "ContactCommand [contact_num=" + contact_num + ", id=" + id + ", content=" + content + ", reg_date="
				+ reg_date + ", recotentable=" + recotentable + "]";
	}
	
}
