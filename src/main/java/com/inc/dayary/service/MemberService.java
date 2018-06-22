package com.inc.dayary.service;

import javax.validation.Valid;

import com.inc.dayary.domain.Member;

public interface MemberService {

	Member findOne(String id);

	boolean emailDupCheck(String email);

	String sendCertifyEmail(String email);

	void signUp(Member member);
	
}
