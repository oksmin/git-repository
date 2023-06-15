package com.java.servlet.dao;

import java.util.List;
import com.java.servlet.vo.MemberVO;

public interface MemberDAO {
	
	List<MemberVO> selectMemberList();
	
}
