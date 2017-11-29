package com.schoolshoping.letsgoshoping.base;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;
import org.json.JSONException;
import org.json.JSONObject;

public class Result {
	public int code; // 出错代码
	public String info; // 消息
	public HashMap<String, Object> data; // 消息实体

	public int getCode() {
		return code;
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

	public HashMap<String, Object> getData() {
		return data;
	}

	public void setData(HashMap<String, Object> data) {
		this.data = data;
	}

	public Result(int code, String info, HashMap<String, Object> data) {
		super();
		this.code = code;
		this.info = info;
		this.data = (null == data) ? new HashMap<String, Object>() : data;
	}

	public Result(int code, String info) {
		super();
		this.code = code;
		this.info = info;
		this.data = new HashMap<String, Object>();
	}

	public void set(String key, Object value) {
		if (null == this.data)
			this.data = new HashMap<String, Object>();
		this.data.put(key, value);
	}

	public void remove(String key) {
		if (null == this.data)
			return;
		if (this.data.containsKey(key))
			this.data.remove(key);
	}

	@Override
	public String toString() {
		Iterator<String> iterator = this.data.keySet().iterator();
		Document entity = new Document();
		while(iterator.hasNext()){
			String key = iterator.next();
			entity.put(key,data.get(key));
		}
		Document response = new Document();
		response.put("code",code);
		response.put("info",code);
		response.put("data",entity);
		return response.toJson();
	}

}
