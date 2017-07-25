package com.d2d.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.d2d.affilate.datafile.AffilateCSVUtil;
import com.d2d.hasoffers.api.AbstractOnlineOfferClient;
import com.d2d.hasoffers.api.ClientURLHelper;

public class AffilateService {

	private static AffilateService affilateService;
	private static ApplicationContext context;
	
	static{
		context = new ClassPathXmlApplicationContext("AffilateClient.xml");
	}
	
	
	private AffilateService() {
	}
	
	public static AffilateService getInstance() {
		if(affilateService == null){
			affilateService = new AffilateService();
		}
		return affilateService;
	}
	
	public void executeAffilateAPI(String affilateName) {
		AbstractOnlineOfferClient affilateAPI = (AbstractOnlineOfferClient) context.getBean("affilateAPI");
		if(affilateName.equals("PAYOOM")){
			ClientURLHelper helper = (ClientURLHelper)context.getBean("payoom");
			affilateAPI.setHelper(helper);
		}else if(affilateName.equals("VCOMMISION")){
			ClientURLHelper helper = (ClientURLHelper)context.getBean("vcommision");
			affilateAPI.setHelper(helper);
		}
		affilateAPI.execute();
	}

	public void readAffilateCSV(String affilateName, String[] categories) {
		if(affilateName.equals("PAYOOM")){
			AffilateCSVUtil.getInstance().readPayoom(categories);
		}else if(affilateName.equals("VCOMMISION")){
			AffilateCSVUtil.getInstance().readVComission(categories);
		}
	}
}
