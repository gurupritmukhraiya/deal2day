/**
 * 
 */
package com.d2d.hasoffers.api;

import java.io.Serializable;

/**
 * @author guruprit_mukhraiya
 *
 */
public class ClientURLHelper implements Serializable{

	private static final long serialVersionUID = 4292406311432692469L;
	
	private String networkId;
	private String apiKey;
	private String hasOfferURL;
	private String findAllOfferURL;
	private String findOfferByIdURL;
	private String findOfferImgByIdURL;
	private String id;
	
	public String getNetworkId() {
		return networkId;
	}
	public void setNetworkId(String networkId) {
		this.networkId = networkId;
	}
	
	public String getApiKey() {
		return apiKey;
	}
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	
	public String getHasOfferURL() {
		return "https://api.hasoffers.com/Apiv3/json?NetworkId=" + networkId + "&api_key=" + apiKey;
	}
	
	public String getFindAllOfferURL() {
		return getHasOfferURL() + "&Target=Affiliate_OfferUrl&Method=findAll&filters%5Bstatus%5D=active&fields%5B%5D=id&fields%5B%5D=name&fields%5B%5D=offer_id&fields%5B%5D=preview_url&fields%5B%5D=offer_url&fields%5B%5D=status";
	}
	
	public String getFindOfferByIdURL() {
		return getHasOfferURL() + "&Target=Affiliate_Offer&Method=findById&fields%5B%5D=description&fields%5B%5D=expiration_date&fields%5B%5D=name&fields%5B%5D=status&fields%5B%5D=id&fields%5B%5D=featured&fields%5B%5D=preview_url&fields%5B%5D=terms_and_conditions&id=" + id;
	}
	
	public String getFindOfferImgByIdURL() {
		return getHasOfferURL() + "&Target=Affiliate_Offer&Method=getThumbnail&ids%5B%5D=" + id;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
