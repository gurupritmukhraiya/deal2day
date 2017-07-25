package com.d2d.constants;

import com.d2d.service.util.ConstantProperties;

public class DatafileConstant {

	public static final String DATAHOME = ConstantProperties.getInstance().getValue("DATAHOME") + "/D2D_DATAHOME/";
	
	public static final String LOCATION_PATH = DATAHOME + "/LOCATION/";
	public static final String OFFER_PATH = DATAHOME + "/OFFERS/";
	public static final String COUPON_CSV_LOCATION = DATAHOME + "/COUPON_CSV/";

	public static final String LOCATION_XML = "/location.xml";

	public static final String DETAIL_XML_FILE_NAME = "/detail.xml";
	public static final String SUMMARY_XML_FILE_NAME = "/summary.xml";

	public static final String COUPON_CSV_FILE_NAME = "/COUPON.csv";
}
