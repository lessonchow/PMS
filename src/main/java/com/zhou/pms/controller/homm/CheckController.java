package com.zhou.pms.controller.homm;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhou.pms.po.hopm.Construction;
import com.zhou.pms.service.homm.IOwnerInfoService;

@Controller
@RequestMapping("/homm/check")
public class CheckController {
	
	@Resource
	private IOwnerInfoService oiService;
	
	@RequestMapping(value="/getcons",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Object getCons() throws Exception {
		List<Construction> consList = oiService.getAllConstruction();
		return consList;
	}
}
