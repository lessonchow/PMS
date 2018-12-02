package com.zhou.pms.controller.homm;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/")
	public String doLogin(HttpServletRequest req) {
//		System.out.println(req.getRequestURI() + "******************************************");
//		System.out.println(req.getSession().getServletContext().getRealPath("url") + "***************************************");
		return "jsp/home";
	}
}
