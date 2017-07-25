/**
 * 
 */
package com.d2d.hasoffers.api;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.codehaus.jackson.JsonNode;

/**
 * @author guruprit_mukhraiya
 *
 */
public class AbstractOnlineOfferClient {

	private HasOfferConnectionUtil connectionUtil = HasOfferConnectionUtil.getInstance();
	private HasOfferJSONUtil jsonUtil = HasOfferJSONUtil.getInstance();
	private ClientURLHelper helper;
	
	public void setHelper(ClientURLHelper helper) {
		this.helper = helper;
	}

	public void execute(){
		System.out.println(helper.getFindAllOfferURL());
		JsonNode dataNode = getResponseData(helper.getFindAllOfferURL());
		Set<String> offerIdsCovered = new HashSet<String>();
		if(dataNode != null){
			Iterator<JsonNode> iterate = dataNode.iterator();
			while(iterate.hasNext()){
				JsonNode offerURL = iterate.next();
				String id = offerURL.get("OfferUrl").findValue("id").getTextValue();
				String offerId = offerURL.get("OfferUrl").findValue("offer_id").getTextValue();
				//String name = offerURL.get("OfferUrl").findValue("name").getTextValue();
				String previewURL = offerURL.get("OfferUrl").findValue("preview_url").getTextValue();
				//String status = offerURL.get("OfferUrl").findValue("status").getTextValue();
				if(offerIdsCovered.add(offerId)){
					helper.setId(offerId);
					JsonNode offerDataNode = getResponseData(helper.getFindOfferByIdURL());
					if(offerDataNode != null){
						String merchantName = offerDataNode.get("Offer").findValue("name").getTextValue();
						String description = offerDataNode.get("Offer").findValue("name").getTextValue();
						String terms_and_conditions = offerDataNode.get("Offer").findValue("name").getTextValue();
						String merchantURL = offerDataNode.get("Offer").findValue("name").getTextValue();
						String status = offerDataNode.get("Offer").findValue("status").getTextValue();
						String endDate = offerDataNode.get("Offer").findValue("expiration_date").getTextValue();
						//String featured = offerDataNode.get("Offer").findValue("featured").getTextValue();
						/*JsonNode offerImgDataNode = getResponseData(helper.getFindOfferImgByIdURL());
						if(offerImgDataNode != null){
							JsonNode thumbnailNode = offerImgDataNode.findValue("Thumbnail");
							Iterator<JsonNode> thumbNailIterator = thumbnailNode.iterator();
							while(thumbNailIterator.hasNext()){
								JsonNode thumbnailNext = thumbNailIterator.next();
								String filename = thumbnailNext.findValue("filename").getTextValue();
								String size = thumbnailNext.findValue("size").getTextValue();
								String type = thumbnailNext.findValue("type").getTextValue();
								String width = thumbnailNext.findValue("width").getTextValue();
								String height = thumbnailNext.findValue("height").getTextValue();
								String imgURL = thumbnailNext.findValue("url").getTextValue();
								String thumbnailURL = thumbnailNext.findValue("thumbnail").getTextValue();
								System.out.println(imgURL);
							}
						}		*/				
						System.out.println(merchantName);
					}	
				}
			}
		}
	}
	
	private JsonNode getResponseData(String URL){
		String responseStr = connectionUtil.openConnectionGetResponse(URL);
		if(responseStr != null){
			JsonNode responseJSON = jsonUtil.parseResponseAndGetJSONResponse(responseStr);
			JsonNode dataNode = responseJSON.get("data");
			return dataNode;
		}else{
			return null;
		}
		
	}
}

