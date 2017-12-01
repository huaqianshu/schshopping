package com.schoolshoping.letsgoshoping.base;

import org.bson.Document;

public class Result {
	private static final long serialVersionUID = 3833240412015045888L;
	private int code=0;
	private String info="success";
	private Document data=new Document();
	
	public Result() {
		super();
	}
	public Result(int code, String info,Document extra) {
		super();
		this.code = code;
		this.info = info;
		this.data = extra;
	}

	
	public Result(int code, String info) {
		super();
		this.code = code;
		this.info = info;
	}

	public int getCode() {
		return code;
	}
	public Document getData() {
		return data;
	}
	public void setData(Document data) {
		this.data = data;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	public void set(String key,Object value) {
		this.data.append(key, value);
	}

	public void remove(String key) {
		if(this.data.containsKey(key))
			this.data.remove(key);
	}

	
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
