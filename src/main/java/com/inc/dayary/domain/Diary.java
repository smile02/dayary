package com.inc.dayary.domain;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Diary {
	private int id;
	private String u_id;
	@Size(min=0, max=15, message="15글자 이내로 작성해 주세요.")
	private String title;
	@NotEmpty(message="한글자 이상 입력해주세요.")
	@Size(min=1, max=500, message="500글자 이내로 작성해주세요.")
	private String content;
	private String regdate;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
}
