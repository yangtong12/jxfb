package com.nchu.library.entity;

import java.util.List;

public class Generic<T> {
	private Integer code;
	private T msg;
	private List<T> msgs;
	public List<T> getMsgs() {
		return msgs;
	}
	public void setMsgs(List<T> msgs) {
		this.msgs = msgs;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public T getMsg() {
		return msg;
	}
	public void setMsg(T msg) {
		this.msg = msg;
	}
	
	
	

}
