/**
 * 
 */
package com.d2d.hasoffers.api;

import java.io.IOException;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * @author guruprit_mukhraiya
 *
 */
public class HasOfferJSONUtil {
	
	private static HasOfferJSONUtil hasOfferJSONUtil;
	
	private HasOfferJSONUtil() {
	}
	
	public static HasOfferJSONUtil getInstance(){
		if(hasOfferJSONUtil == null){
			hasOfferJSONUtil = new HasOfferJSONUtil();
		}
		return hasOfferJSONUtil;
	}

	public JsonNode parseResponseAndGetJSONResponse(String response){
		ObjectMapper mapper = new ObjectMapper();
		JsonNode offersJSONObject;
		try {
			offersJSONObject = mapper.readTree(response);
			JsonNode responseJSON = offersJSONObject.get("response");
			return responseJSON;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
