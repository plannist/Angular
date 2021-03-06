package com.prac.angular;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class LogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler{
	
	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
								throws IOException, ServletException {
		log.debug("logoutSuccessHandler 인입@@@@@@@@@");
		List<Cookie>cookie = Arrays.asList(request.getCookies());
		cookie.forEach(obj -> {
			obj.setMaxAge(0);
			obj.setPath("/");
			response.addCookie(obj);
		});
		
		super.setDefaultTargetUrl("/");
		super.onLogoutSuccess(request, response, authentication);
	}
}
