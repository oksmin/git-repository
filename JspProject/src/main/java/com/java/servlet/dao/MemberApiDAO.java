package com.java.servlet.dao;

import com.google.gson.JsonObject;

public interface MemberApiDAO {
	
	JsonObject getMemberDual();
	
	JsonObject getMember();
}
