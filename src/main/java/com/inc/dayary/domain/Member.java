package com.inc.dayary.domain;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class Member {
	
	@Pattern(regexp="[a-zA-Z0-9]{4,10}",message="알파벳 또는 숫자 4~10글자")
	private String id;
	
	@Pattern(regexp="[a-zA-Z0-9]{4,10}",message="알파벳 또는 숫자 4~10글자")
	private String password;	
	private String passwordConfirm;
	
	@Pattern(regexp="[가-힣]{2,10}",message="이름은 한글 2~10글자이내")
	private String name;
	
	@Pattern(regexp="[A-Za-z0-9]+@[A-Za-z0-9]+.[A-Za-z]{2,10}",message="예)email0000@email.com형식으로 입력해주세요. 30글자 이내")
	private String email;
	private String emailCode;
	@NotEmpty(message="성별을 선택해주세요.")
	@Pattern(regexp="[fm]",message="잘못된 선택")	
	private String gender;
	//.[A-Za-z]{2,10}	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	public boolean isPasswordValid() {		
		return this.password.equals(this.passwordConfirm);
	}
	public String getEmailCode() {
		return emailCode;
	}
	public void setEmailCode(String emailCode) {
		this.emailCode = emailCode;
	}	
}
