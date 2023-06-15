package com.java.servlet.service;

import com.google.gson.JsonObject;

public interface MemberApiService {
	JsonObject getMemberDual();
	
	JsonObject getMember();
}
