package com.java.servlet.service;

import com.java.servlet.vo.MemberVO;

public interface LoginService {
	
	int getCountMember(MemberVO vo);

	void getMemberByIdAndPwd(MemberVO vo);
	
}
