package com.zhou.pms.controller.homm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhou.pms.po.homm.OwnerInfo;

@Controller
@RequestMapping("/homm/goto")
public class GoToController {

	@RequestMapping(value="/ownerinfo")
	public String GoToOwnerInfo() {
		return "jsp/homm/ownerinfo";
	}
	
	@RequestMapping(value="/testfresh1")
	public String GoToTestFresh1() {
		return "jsp/homm/testfresh1";
	}
	
	@RequestMapping(value="/testfresh2")
	public String GoToTestFresh2() {
		return "jsp/homm/testfresh2";
	}
	
	@RequestMapping(value="/check")
	public String GoToCheck() {
		return "jsp/homm/check";
	}
	
}
