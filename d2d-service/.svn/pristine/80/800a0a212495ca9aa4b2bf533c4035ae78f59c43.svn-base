/**
 * 
 */
package com.d2d.hasoffers.api;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author guruprit_mukhraiya
 *
 */
public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("AffilateClient.xml");
		AbstractOnlineOfferClient client = (AbstractOnlineOfferClient) context.getBean("client");
		client.execute();
		
		ClientURLHelper helper = (ClientURLHelper)context.getBean("vcommisionHelper");
		client.setHelper(helper);
		//client.run();
	}
}
