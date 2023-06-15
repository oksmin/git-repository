package com.java.servlet.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHAEncodeUtil {
	public static String encodeSha(String planeText) {
		String encodingText = "";
		try {
			// SHA-512, SHA-256, SHA1 등 다양한 방식으로 활용
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			md.update(planeText.getBytes());
			encodingText = String.format("%0128x", new BigInteger(1, md.digest()));

		} catch (NoSuchAlgorithmException e) {
			// throws가 싫어서 RuntimeException을 사용
			throw new RuntimeException(e);
		}
		return encodingText;
	}
	
	public static void main(String[] args) {
		System.out.println(encodeSha("jem04"));
	}
	
}
