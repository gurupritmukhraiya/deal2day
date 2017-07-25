package com.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.d2d.client.command.OfferCommand;
import com.d2d.client.helper.ControllerUtil;
import com.d2d.client.helper.ImageUploadHelper;
import com.d2d.client.helper.OfferClientHelper;
import com.d2d.constants.ImageConstant;
import com.d2d.service.common.beans.Location;
import com.d2d.service.common.beans.Merchant;
import com.d2d.service.common.beans.Offer;
import com.d2d.service.intf.LocationServiceIntf;
import com.d2d.service.intf.MerchantServiceIntf;
import com.d2d.service.intf.OfferServiceIntf;
import com.d2d.service.locator.ServiceLocator;
import com.d2d.service.util.Response;

@Controller
@RequestMapping("/mer")
public class MerchantController {
	
	private static final Logger logger = Logger.getLogger(MerchantController.class);

	private OfferServiceIntf offerService = ServiceLocator.getServiceLocator().getOfferService();
	private MerchantServiceIntf merchantService = ServiceLocator.getServiceLocator().getMerchantService();
	private LocationServiceIntf locationService = ServiceLocator.getServiceLocator().getLocationService();
	private static ImageUploadHelper imageUploadHelper = new ImageUploadHelper();
	
	// merchant operations -------------------------------------------------------------
	
	@RequestMapping(value = "/registerMerchant.htm", method = RequestMethod.POST)
	public ModelAndView registerMerchant(HttpServletRequest request, HttpServletResponse responce, Merchant merchant){
		merchant.setCreatedBy("BY_USER");
		Response result = merchantService.registerMerchant(merchant);
		if(result.getStatus().equals(Response.SUCCESS))
			return new ModelAndView("redirect:/jsp/merchant-login.jsp", "result", result);
		return new ModelAndView("redirect:/jsp/ProviderRegistration.jsp", "result", result);
	}
	
	@RequestMapping(value = "/verifyMerchant.htm", method = RequestMethod.POST)
	public ModelAndView verifyMerchant(HttpServletRequest request, HttpServletResponse response){
		String mailId = request.getParameter("mailId");
		String verificationCode = request.getParameter("code");		
		Response result = merchantService.verifyMerchant(mailId, verificationCode);
		return new ModelAndView("redirect:/jsp/merchant-login.jsp", "result", result);
	}
	
	@RequestMapping(value = "/login.htm")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response){
		logger.info("inside /login.htm");
		logger.debug("mayank jain");
		logger.error("error message mayank");
		HttpSession session = request.getSession();
		String merLoginId = request.getUserPrincipal().getName();
		
		session.setAttribute("mer-login-id", merLoginId);
		
		return new ModelAndView("redirect:/mer/console.htm");
	}
	
	@RequestMapping(value = "/console.htm")
	public ModelAndView console(HttpServletRequest request, HttpServletResponse response){
		logger.info("inside /login.htm");
		logger.debug("mayank jain");
		logger.error("error message mayank");
		HttpSession session = request.getSession();
		String merLoginId = session.getAttribute("mer-login-id").toString();
		
		Merchant merchant = merchantService.getMerchantWithAddressAndOffer(merLoginId);
		session.setAttribute("mer-idx", merchant.getIdx());
		session.setAttribute("mer-name", merchant.getMerchantName());
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("profile", merchant);
		model.put("locations", merchant.getLocations());
		model.put("offers", merchant.getOffers());
		return new ModelAndView("/jsp/merchant-console.jsp", "model", model);
	}
	
	@RequestMapping(value = "/update-profile.htm", method = RequestMethod.POST)
	public @ResponseBody ModelAndView updateMerchant(MultipartHttpServletRequest request, HttpServletResponse response) { 
		Merchant merchant = new Merchant();
		long merchantId = Long.parseLong(request.getSession().getAttribute("mer-idx").toString());
		merchant.setIdx(merchantId);
		//merchant.setEmailId(request.getSession().getAttribute("loginId").toString());
		merchant.setEmailId(request.getSession().getAttribute("mer-login-id").toString());
		merchant.setContactNo(request.getParameter("contactNo"));
		merchant.setURL(request.getParameter("URL"));
		
		MultipartFile mpf = request.getFile("imagePath");
		try {
			InputStream inputStream = mpf.getInputStream();
			InputStream tinputStream = mpf.getInputStream();
			if(mpf != null && mpf.getSize() != 0){
				String path = ImageConstant.MERCHANT_OFFER_IMG_PATH + merchantId;
				imageUploadHelper.createImage(inputStream, path, ImageConstant.MERCHANT_IMG_FILE_NAME);
				imageUploadHelper.createThumbImage(tinputStream, path, ImageConstant.MERCHANT_THUMB_IMG_FILE_NAME);
				merchant.setImagePath(ImageConstant.MERCHANT_OFFER_IMG_URL+merchantId+ImageConstant.MERCHANT_IMG_FILE_NAME );
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		merchantService.updateMerchant(merchant);
		
		return new ModelAndView("redirect:/mer/console.htm");
	}
	
	@RequestMapping(value = "/changeCred.htm", method = RequestMethod.POST)
	public ModelAndView changeCred(HttpServletRequest request, HttpServletResponse response, Merchant merchant){
		/*merchant.setIdx(Long.parseLong(request.getSession().getAttribute("idx").toString()));
		merchant.setEmailId(request.getSession().getAttribute("loginId").toString());*/
		merchant.setIdx(Long.parseLong(request.getSession().getAttribute("mer-idx").toString()));
		merchant.setEmailId(request.getSession().getAttribute("mer-login-id").toString());
		merchantService.updateMerchant(merchant);
		return new ModelAndView("redirect:/mer/console.htm");
	}
	
	// Location operation operations -----------------------------------------------------------------------------------
	
	@RequestMapping(value = "/add-location.htm", method = RequestMethod.POST)
	public ModelAndView addLocation(HttpServletRequest request, HttpServletResponse response, Location location) throws Exception{
		location.setMerchantId(Long.parseLong(request.getSession().getAttribute("mer-idx").toString()));
		locationService.createLocation(location);
		return new ModelAndView("redirect:/mer/console.htm");
	}
	
	@RequestMapping(value = "/delete-location.htm", method = RequestMethod.POST)
	public ModelAndView deleteLocation(HttpServletRequest request, HttpServletResponse response, Location location) throws Exception{
		
		long idx = Long.parseLong(request.getParameter("idx"));
		locationService.deleteLocation(idx);
		return new ModelAndView("redirect:/mer/console.htm");
	}
	
	// Offer operation operations -----------------------------------------------------------------------------------
	
	@RequestMapping(value = "/add-offer.htm", method = RequestMethod.POST)
	public @ResponseBody ModelAndView addOffer(MultipartHttpServletRequest request, HttpServletResponse response) { 
		OfferCommand command = OfferClientHelper.getInstance().getOfferCommandFromRequest(request, false);
		
		Merchant merchant = new Merchant();
		long merchantId = Long.parseLong(request.getSession().getAttribute("mer-idx").toString());
		merchant.setIdx(merchantId);
		merchant.setEmailId(request.getSession().getAttribute("mer-login-id").toString());
		
		command.setMerchantId(merchantId + "");
		command.setMerchantName(request.getSession().getAttribute("mer-name").toString());
		
		Offer offerFromUI = OfferClientHelper.getInstance().getOfferByOfferCommand(command, false);
		
		MultipartFile fileUpload = request.getFile("coverImage");
		if(fileUpload != null && fileUpload.getSize() != 0){
			offerFromUI.setImageURL("true");
		}else{
			offerFromUI.setImageURL("false");
		}
		if(offerFromUI != null){
			long offerId = offerService.createOffer(offerFromUI);
			offerFromUI.setIdx(offerId);
			if(offerId != 0){
				try {
					InputStream inputStream = fileUpload.getInputStream();
					InputStream tinputStream = fileUpload.getInputStream();
					
					if(fileUpload != null && fileUpload.getSize() != 0){
						String path = ImageConstant.MERCHANT_OFFER_IMG_PATH + merchantId + "/" + offerId;;
						imageUploadHelper.createImage(inputStream, path, ImageConstant.OFFER_IMG_FILE_NAME);
						imageUploadHelper.createThumbImage(tinputStream, path, ImageConstant.OFFER_THUMB_IMG_FILE_NAME);
						/*merchant.setImagePath(ImageConstant.MERCHANT_OFFER_IMG_URL+merchantId+ImageConstant.MERCHANT_IMG_FILE_NAME );*/
					}
				} catch (IOException e) {
					e.printStackTrace();
				}	
			}
		}
		return new ModelAndView("redirect:/mer/console.htm");
	}
	
	@RequestMapping(value = "/view-offer.htm")
	public void viewOffer(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ControllerUtil controllerUtil = new ControllerUtil();
		long offerIdx = Long.parseLong(request.getParameter("idx"));
		long merchatnIdx = Long.parseLong(request.getSession().getAttribute("mer-idx").toString());
		Offer offer = offerService.getOffer(merchatnIdx, offerIdx);
		try {
			controllerUtil.addAttribute("offer", offer);
			response.getWriter().write(controllerUtil.getJSON());
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	@RequestMapping(value = "/update-offer.htm", method = RequestMethod.POST)
	public @ResponseBody ModelAndView updateOffer(MultipartHttpServletRequest request, HttpServletResponse response){ 
		OfferCommand command = OfferClientHelper.getInstance().getOfferCommandFromRequest(request, true);
		
		Merchant merchant = new Merchant();
		long merchantId = Long.parseLong(request.getSession().getAttribute("mer-idx").toString());
		merchant.setIdx(merchantId);
		merchant.setEmailId(request.getSession().getAttribute("mer-login-id").toString());
		
		command.setMerchantId(merchantId + "");
		command.setMerchantName(request.getSession().getAttribute("mer-name").toString());
		
		Offer offerFromUI = OfferClientHelper.getInstance().getOfferByOfferCommand(command, true);
		
		MultipartFile fileUpload = request.getFile("coverImage");
		if(fileUpload != null && fileUpload.getSize() != 0){
			offerFromUI.setImageURL("true");
		}else{
			offerFromUI.setImageURL("false");
		}
		if(offerFromUI != null){
			offerService.updateOffer(offerFromUI);		
			try {
				InputStream inputStream = fileUpload.getInputStream();
				InputStream tinputStream = fileUpload.getInputStream();
				
				if(fileUpload != null && fileUpload.getSize() != 0){
					String path = ImageConstant.MERCHANT_OFFER_IMG_PATH + merchantId + "/" + offerFromUI.getIdx();;
					imageUploadHelper.createImage(inputStream, path, ImageConstant.OFFER_IMG_FILE_NAME);
					imageUploadHelper.createThumbImage(tinputStream, path, ImageConstant.OFFER_THUMB_IMG_FILE_NAME);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return new ModelAndView("redirect:/mer/console.htm");
	}
	
	@RequestMapping(value = "/delete-offer.htm", method = RequestMethod.POST)
	public ModelAndView deleteOffer(HttpServletRequest request, HttpServletResponse response) throws Exception{
		long offerIdx = Long.parseLong(request.getParameter("idx"));
		long merchatnIdx = Long.parseLong(request.getSession().getAttribute("mer-idx").toString());
		offerService.deleteOffer(merchatnIdx, offerIdx);
		return new ModelAndView("redirect:/mer/console.htm");	
	}
}
