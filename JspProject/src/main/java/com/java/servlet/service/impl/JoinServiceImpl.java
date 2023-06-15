package com.java.servlet.service.impl;

import com.java.servlet.dao.JoinDAO;
import com.java.servlet.dao.impl.JoinDAOImpl;
import com.java.servlet.service.JoinService;
import com.java.servlet.vo.MemberVO;

public class JoinServiceImpl implements JoinService {
	
	private final JoinDAO dao = JoinDAOImpl.getInstance();
	
	private static final JoinService instance = new JoinServiceImpl();  
	
	private JoinServiceImpl() {
	}
	
	public static JoinService getInstance() {
		return instance;
	}
	
	@Override
	public int registerMember(MemberVO member) {
		return dao.insertMember(member);
	}

}
