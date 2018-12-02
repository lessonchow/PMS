package com.zhou.pms.po.homm;

public class User {

	private Integer userId;
	private String userCode; //用户登录码，唯一键
	private String userName; //用户名（如“物业系统管理员”，“赵云”）
	private String userPassword; //用户登录密码
	private Role role; //角色表
}
