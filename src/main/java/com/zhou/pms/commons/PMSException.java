package com.zhou.pms.commons;
/**
 * �Զ����쳣
 *  * @author student
 *
 */

public class PMSException extends Exception {
	public PMSException(String msg){
		super(msg);
	}
	public PMSException(String msg,Throwable throwable){
		super(msg,throwable);
	}
	public PMSException(){
	}
	
}
