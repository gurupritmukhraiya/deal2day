/**
 * 
 */
package com.d2d.hasoffers.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 * @author guruprit_mukhraiya
 *
 */
public class HasOfferConnectionUtil {
	
	private static HasOfferConnectionUtil hasOfferConnectionUtil;
	
	private HasOfferConnectionUtil() {
	}
	
	public static HasOfferConnectionUtil getInstance(){
		if(hasOfferConnectionUtil == null){
			hasOfferConnectionUtil = new HasOfferConnectionUtil();
		}
		return hasOfferConnectionUtil;
	}

	private static TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
		public java.security.cert.X509Certificate[] getAcceptedIssuers() {
			return null;
		}

		public void checkClientTrusted(
				java.security.cert.X509Certificate[] certs, String authType) {
		}

		public void checkServerTrusted(
				java.security.cert.X509Certificate[] certs, String authType) {
		}
	} };
	
	static{
		SSLContext sc;
		try {
			sc = SSLContext.getInstance("SSL");
			sc.init(null, trustAllCerts, new java.security.SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		}
	}
	
	public String openConnectionGetResponse(String url){
		URL obj;
		BufferedReader in = null;
		try {
			obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			int responseCode = con.getResponseCode();
			System.out.println("Response Code : " + responseCode);
			if(responseCode == 200){
				in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String line;
				StringBuffer response = new StringBuffer();
				while ((line = in.readLine()) != null) {
					response.append(line);
				}
				return response.toString();
			}else{
				System.out.println("Connection Failed error : " + responseCode);
				return null;
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
