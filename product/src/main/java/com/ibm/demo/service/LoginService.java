package com.ibm.demo.service;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/*
 * 
 * kg972t
 * 
 */

import org.springframework.stereotype.Service;

import com.ibm.demo.processor.ProductProcessor;
import com.ibm.demo.utils.Funclib;

@Service
public class LoginService {
	public static final Logger logger = LoggerFactory.getLogger(LoginService.class);

	@Autowired
	ProductProcessor productProcessor;

	@Value("${user}")
	private String uN;

	@Value("${password}")
	private String pwd;

	@Value("${uName}")
	private String uName;

	@Value("${pwd}")
	private String pwd12;

	public String validateUser(HttpServletRequest request) {
		String who = null;
		String userName = request.getParameter("userNmae");
		String pass = request.getParameter("password");
		
		
		if (Funclib.isAllTrue(userName.equalsIgnoreCase(uN), pass.equalsIgnoreCase(pwd))) {
			who = uN;
		} else if (Funclib.isAllTrue(uName.equalsIgnoreCase(userName), pwd12.equalsIgnoreCase(pass)))
			who = uName;

		return who;
	}

	
}
