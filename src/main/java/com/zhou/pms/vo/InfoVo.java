package com.zhou.pms.vo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
/**
 * 信息对象
 * @author Administrator
 */
public class InfoVo implements Serializable{
	//状态码
	private Integer status;
	//提示信息
	private String msgcontent;
	//集合提示信息
	private Map<String,Object> msgmap=new HashMap<String,Object>();
	
	public InfoVo() {
	}
	
	public InfoVo(Integer status, String msgcontent) {
		super();
		this.status = status;
		this.msgcontent = msgcontent;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMsgcontent() {
		return msgcontent;
	}
	public void setMsgcontent(String msgcontent) {
		this.msgcontent = msgcontent;
	}
	public Map<String, Object> getMsgmap() {
		return msgmap;
	}
	public void setMsgmap(Map<String, Object> msgmap) {
		this.msgmap = msgmap;
	}
	
	
	
		
}
