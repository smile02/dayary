package com.inc.dayary.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.inc.dayary.domain.Member;
import com.inc.dayary.repository.MemberDao;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDao memberDao;

	@Autowired
	private JavaMailSender javamailSender;
	
	@Override
	public Member findOne(String id) {
		return memberDao.findOne(id);
	}

	@Override
	public boolean emailDupCheck(String email) {
		Member member = memberDao.getFindOneByEmail(email);
		return member != null; //true
	}

	@Override
	public String sendCertifyEmail(String email) {
		String from = "gosu12002@gmail.com";
		String subject = "Dayary 이메일 인증";
		String emailCode = makeRandomCode(); //랜덤숫자 4개 생성 (0~9)
		
		String content = "인증코드 : "+emailCode;
		
		try {
			MimeMessage msg = javamailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(msg, true, "UTF-8");
			
			helper.setFrom(from);
			helper.setTo(email);
			helper.setSubject(subject);
			helper.setText(content);
			
			javamailSender.send(msg);
		} catch (MessagingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		return emailCode;
	}
	
	public String makeRandomCode() {
		
		StringBuffer sb = new StringBuffer();
		
		for(int i=0; i<4; i++) {					
			sb.append((int)(Math.random() * 10));			
		}
		
		return sb.toString();
	}

	@Override
	public void signUp(Member member) {
		memberDao.signUp(member);		
	}
}
