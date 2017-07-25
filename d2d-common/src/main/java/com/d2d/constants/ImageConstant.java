package com.d2d.constants;

import com.d2d.service.util.ConstantProperties;

public class ImageConstant {

	public static final String IMAGE_PATH = ConstantProperties.getInstance().getValue("IMAGE_PATH");
	public static final String IMAGE_URL = ConstantProperties.getInstance().getValue("IMAGE_URL");
	public static final String MAIL_TEMPLATE_PATH = ConstantProperties.getInstance().getValue("MAIL_TEMPLATE_PATH");

	public static final String MERCHANT_OFFER_IMG_PATH = IMAGE_PATH + "mer_offer/";
	public static final String MERCHANT_OFFER_IMG_URL = IMAGE_URL + "mer_offer/";
	public static final String CATEGORY_IMG_PATH = IMAGE_PATH + "category/";
	 
	public static final String MERCHANT_IMG_FILE_NAME = "/logo.jpg";
	public static final String MERCHANT_THUMB_IMG_FILE_NAME = "/t_logo.jpg";

	public static final String OFFER_IMG_FILE_NAME = "/cover.jpg";
	public static final String OFFER_THUMB_IMG_FILE_NAME = "/t_cover.jpg";

	public static final String CATEGORY_IMG_FILE_NAME = "/cat.jpg";
	public static final String CATEGORY_THUMB_IMG_FILE_NAME = "/t_cat.jpg";
	
	public static final String DEFAULT_IMAGE = "../d2d/img/default.jpg";
}
