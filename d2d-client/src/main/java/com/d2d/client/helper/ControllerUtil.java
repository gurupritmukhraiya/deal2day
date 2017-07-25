package com.d2d.client.helper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;

public class ControllerUtil {
	
	private ObjectMapper mapper;
	private Map<String, Object> JSONMap;
	private String JSONString = null;

	public ControllerUtil() {
		mapper = new ObjectMapper();
		JSONMap = new HashMap<String, Object>();
	}
	
	public void addAttribute(String attribute, String value){
		JSONMap.put(attribute, value);
	}
	
	public void addAttribute(String attribute, long value){
		JSONMap.put(attribute, value);
	}
	
	public void addAttribute(String attribute, int value){
		JSONMap.put(attribute, value);
	}
	
	public void addAttribute(String attribute, Object value){
		JSONMap.put(attribute, value);
	}
	
	public String getJSON(){
		try {
			JSONString = mapper.writeValueAsString(JSONMap);
		} catch (IOException e) {
			e.printStackTrace();
		}	
		return JSONString;
	}
}
