package com.d2d.config;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class SecurityConfig extends MultiActionController{
	
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response){
		Set<String> roles = AuthorityUtils.authorityListToSet(
				 SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        if (roles.contains("ADMIN_ROLE")) {
            return new ModelAndView("/admin/login.htm");
        }else if(roles.contains("MERCHANT_ROLE")){
        	return new ModelAndView("/mer/login.htm");
        }
        return new ModelAndView("/jsp/403.htm");
	}
}
