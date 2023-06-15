package com.java.servlet.service.impl;

import com.google.gson.JsonObject;
import com.java.servlet.dao.MemberApiDAO;
import com.java.servlet.dao.impl.MemberApiDAOImpl;
import com.java.servlet.service.MemberApiService;

public class MemberApiServiceImpl implements MemberApiService{
	
	private static final MemberApiService instance = new MemberApiServiceImpl();
	
	private final MemberApiDAO dao = MemberApiDAOImpl.getInstance();
	
	private MemberApiServiceImpl() {
	}
	
	public static MemberApiService getInstance() {
		return instance;
	}
	
	@Override
	public JsonObject getMemberDual() {
		return dao.getMemberDual();
	}

	@Override
	public JsonObject getMember() {
		return dao.getMember();
	}

	

}
