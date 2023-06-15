package com.java.servlet.dao;

import com.java.servlet.vo.MemberVO;

public interface LoginDAO {
	
	int selectCountMember(MemberVO vo);
	void selectMemberByIdAndPwd(MemberVO vo);
}
