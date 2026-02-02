package com.example.config;

import java.io.IOException;

import org.springframework.stereotype.Component;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthFilter {
	public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain)throws IOException,ServletException {
		System.out.println("***************API Gateway Called**************"+request.getRemoteAddr());
		
		HttpServletRequest httpReq=(HttpServletRequest)request;
		HttpServletResponse httpRes=(HttpServletResponse)response;
		
		String authHeader = httpReq.getHeader("Authorization");
		String AUTH_TOKEN="my-secret-token";
		
		if(authHeader==null|| !authHeader.equals(AUTH_TOKEN)) {
			httpRes.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			httpRes.getWriter().write("Unauthorized");
			return;
		}
		//Continue with next filter/controller
		chain.doFilter(request, response);		;
	}

}
