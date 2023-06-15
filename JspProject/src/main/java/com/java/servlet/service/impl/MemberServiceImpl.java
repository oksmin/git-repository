package com.java.servlet.service.impl;

import java.util.List;

import com.java.servlet.dao.MemberDAO;
import com.java.servlet.dao.impl.MemberDAOImpl;
import com.java.servlet.service.MemberService;
import com.java.servlet.vo.MemberVO;

public class MemberServiceImpl implements MemberService{
	
	private MemberDAO dao = new MemberDAOImpl();
	
	@Override
	public List<MemberVO> getMemberList() {
		return dao.selectMemberList();
	}

}
