package com.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.d2d.cache.MerchantNameCache;
import com.d2d.client.helper.ControllerUtil;
import com.d2d.client.helper.ImageUploadHelper;
import com.d2d.constants.DatafileConstant;
import com.d2d.constants.ImageConstant;
import com.d2d.service.common.beans.Category;
import com.d2d.service.common.beans.Merchant;
import com.d2d.service.common.beans.MerchantName;
import com.d2d.service.intf.MerchantServiceIntf;
import com.d2d.service.intf.OfferServiceIntf;
import com.d2d.service.locator.ServiceLocator;
import com.d2d.service.util.FolderUtil;
import com.d2d.service.util.Response;

@Controller
@RequestMapping("/admin")
public class AdminController extends MultiActionController{
	
	private MerchantServiceIntf merchantService = ServiceLocator.getServiceLocator().getMerchantService();
	private OfferServiceIntf offerService = ServiceLocator.getServiceLocator().getOfferService();
	private static ImageUploadHelper imageUploadHelper = new ImageUploadHelper();
	
	//Admin Operations ---------------------------------------------------------------------------------------------------
	
	@RequestMapping(value = "/login.htm")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response){
		List<Merchant> merchants = merchantService.getAllMerchants();
		List<Category> categories = offerService.getAllCategoriesFromCache();
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("merchants", merchants);
		model.put("categories", categories);
		model.put("merchantNamesWithoutId", MerchantNameCache.getInstanse().getMerchantNamesWithoutId());
		return new ModelAndView("/admin/admin-console.jsp", "model", model);
	}
	
	//Merchant Operations ---------------------------------------------------------------------------------------------------
	
	@RequestMapping(value = "/addMerchant.htm", method = RequestMethod.POST)
	public ModelAndView addMerchant(MultipartHttpServletRequest request, HttpServletResponse response) { 
		Merchant merchant = new Merchant();
		merchant.setMerchantName(request.getParameter("merchantName"));
		merchant.setContactNo(request.getParameter("contactNo"));
		merchant.setEmailId(request.getParameter("emailId"));
		merchant.setURL(request.getParameter("URL"));
		merchant.setStatus(request.getParameter("status"));
		merchant.setCreatedDate(new Date());
		merchant.setRole("MERCHANT_ROLE");
		merchant.setPassword("Cre@tive12345");
		merchant.setCreatedBy("ADMIN");
			
		MultipartFile mpf = request.getFile("imagePath");
		if(mpf != null && mpf.getSize() != 0){
			merchant.setImagePath("true");
		}else{
			merchant.setImagePath("false");
		}
		
		Response responseLocal = merchantService.addMerchant(merchant);
		String merchantId = responseLocal.getMassage();
			
		if(responseLocal.getStatus().equals("id")){
			if(mpf != null && mpf.getSize() != 0){
				InputStream inputStream, tinputStream;
				try {
					inputStream = mpf.getInputStream();
					tinputStream = mpf.getInputStream();
					String path = ImageConstant.MERCHANT_OFFER_IMG_PATH + merchantId;
					
					imageUploadHelper.createImage(inputStream, path, ImageConstant.MERCHANT_IMG_FILE_NAME);
					imageUploadHelper.createThumbImage(tinputStream, path, ImageConstant.MERCHANT_IMG_FILE_NAME);					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}			
		}
		return new ModelAndView("redirect:/admin/login.htm");
	}
	
	@RequestMapping(value = "/loginMerchant.htm", method = RequestMethod.POST)
	public ModelAndView loginMerchant(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		String merLoginId = request.getParameter("mer-login-id");
		
		session.setAttribute("mer-login-id", merLoginId);
		
		return new ModelAndView("redirect:/mer/console.htm");
	}
	
	@RequestMapping(value = "/updateMerchantStatus.htm")
	public void updateMerchantStatus(HttpServletRequest request, HttpServletResponse response){
		ControllerUtil controllerUtil = new ControllerUtil();
		long merchantId = Long.parseLong(request.getParameter("idx"));
		String status = request.getParameter("status");
		Response result = merchantService.updateMerchantStatus(merchantId, status);
		try {
			controllerUtil.addAttribute("result", result);
			response.getWriter().write(controllerUtil.getJSON());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/assignMerchant.htm", method = RequestMethod.POST)
	public ModelAndView assignMerchant(HttpServletRequest request, HttpServletResponse response){
		String newMerchantNameAndId = request.getParameter("newMerchant");
		String[] newMerchantNameIdArr = newMerchantNameAndId.split("<#>");
		
		String newMerchantId = newMerchantNameIdArr[0];
		String newMerchantName = newMerchantNameIdArr[1];		
		
		String oldMerchantId = request.getParameter("oldMerchant");
		
		MerchantName merchantName = new MerchantName();
		merchantName.setIdx(Long.parseLong(newMerchantId));
		merchantName.setMerchantId(Long.parseLong(oldMerchantId));
		merchantName.setMerchantName(newMerchantName);
		
		merchantService.updateMerchantName(merchantName);
		return new ModelAndView("redirect:/admin/login.htm");
	}
	
	
	//Category Operations ---------------------------------------------------------------------------------------------------
	
	@RequestMapping(value = "/deleteCategory.htm", method = RequestMethod.POST)
	public ModelAndView deleteCategory(HttpServletRequest request, HttpServletResponse response){
		int categoryId = Integer.parseInt(request.getParameter("id"));
		offerService.deleteCategory(categoryId);
		return new ModelAndView("redirect:/admin/login.htm");
	}	
	
	
	@RequestMapping(value = "/viewCategory.htm")	
	public void viewCategory(HttpServletRequest request, HttpServletResponse response) { 
			ControllerUtil controllerUtil = new ControllerUtil();
			Integer catIdx = Integer.parseInt(request.getParameter("idx"));
			Category category = offerService.getCategory(catIdx);
			try {
				controllerUtil.addAttribute("category", category);
				response.getWriter().write(controllerUtil.getJSON());
			} catch (IOException e) {
				e.printStackTrace();
		}	
	}
	
	@RequestMapping(value = "/updateCategory.htm", method = RequestMethod.POST)
	public ModelAndView updateCategory(MultipartHttpServletRequest request, HttpServletResponse response){
		Category category = new Category();
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		Integer parentId = Integer.parseInt(request.getParameter("parent"));
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		if(type.equalsIgnoreCase("other")){
			 type = request.getParameter("newType");
		}
		if(parentId == 0){
			name = "D2D";
	    	type = "D2D";
		}
		MultipartFile mpf = request.getFile("imagePath");
		try {
			InputStream inputStream = mpf.getInputStream();
			if(mpf != null && mpf.getSize() != 0){
				String path = ImageConstant.CATEGORY_IMG_PATH + idx;
				/*imageUploadHelper.createImage(inputStream, path, ImageConstant.CATEGORY_IMG_FILE_NAME);*/
				imageUploadHelper.createThumbImage(inputStream, path, ImageConstant.CATEGORY_IMG_FILE_NAME);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	
		category.setIdx(idx);
		category.setParent(parentId);
    	category.setType(type);
    	category.setName(name);
		Response reponseFromDB = offerService.updateCategory(category);
		
		return new ModelAndView("redirect:/admin/login.htm", "result", reponseFromDB);
	}
	
	@RequestMapping(value = "/addCategory.htm", method = RequestMethod.POST)
	public ModelAndView addCategory(MultipartHttpServletRequest request, HttpServletResponse response) { 
		Category category = new Category();
		Integer parentId = Integer.parseInt(request.getParameter("parent"));
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		if(type.equalsIgnoreCase("other")){
			 type = request.getParameter("newType");
		}
		if(parentId == 0){
			name = "D2D";
	    	type = "D2D";
		}
		category.setParent(parentId);
    	category.setType(type);
    	category.setName(name);
		Response reponseFromDB = offerService.createCategory(category);
		if(reponseFromDB.getStatus().equals("id")){
			MultipartFile mpf = request.getFile("imagePath");
			try {
				InputStream inputStream = mpf.getInputStream();
				if(mpf != null && mpf.getSize() != 0){
					String path = ImageConstant.CATEGORY_IMG_PATH + reponseFromDB.getMassage();
					/*imageUploadHelper.createImage(inputStream, path, ImageConstant.CATEGORY_IMG_FILE_NAME);*/
					imageUploadHelper.createThumbImage(inputStream, path, ImageConstant.CATEGORY_IMG_FILE_NAME);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
		return new ModelAndView("redirect:/admin/login.htm", "result", reponseFromDB);
	}
	
	//Promocode Operations ---------------------------------------------------------------------------------------------------
	
	@RequestMapping(value = "/uploadCSV.htm", method = RequestMethod.POST)
	public @ResponseBody ModelAndView uploadCSV(MultipartHttpServletRequest request, HttpServletResponse response) { 
		String affilateName = request.getParameter("affilateName");
		
		Iterator<String> itr =  request.getFileNames();
		while(itr.hasNext()){
			try {
				MultipartFile multipartFile = request.getFile(itr.next());
				InputStream input = multipartFile.getInputStream();
				
				String path = DatafileConstant.COUPON_CSV_LOCATION + affilateName;
				FolderUtil.createFolders(path);
				
				File couponFile = new File(path + "/" + DatafileConstant.COUPON_CSV_FILE_NAME);
			    FileUtils.copyInputStreamToFile(input, couponFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return new ModelAndView("redirect:/admin/login.htm");	
		}
		Response result = new Response("fail", "Offer creation fail!!!");
		return new ModelAndView("redirect:/admin/login.htm", "result", result);
	}
	
	@RequestMapping(value = "/executeAffilateAPI.htm", method = RequestMethod.POST)
	public ModelAndView executeAffilateAPI(HttpServletRequest request, HttpServletResponse response){
		String affilateName = request.getParameter("affilateName");
		offerService.executeAffilateAPI(affilateName);
		return new ModelAndView("redirect:/admin/login.htm");
	}
	
	@RequestMapping(value = "/readAffilateCSV.htm", method = RequestMethod.POST)
	public ModelAndView readAffilateCSV(HttpServletRequest request, HttpServletResponse response){
		String affilateName = request.getParameter("affilateName");
		String categories[] = request.getParameterValues("category");
		
		offerService.readAffilateCSV(affilateName, categories);
		return new ModelAndView("redirect:/admin/login.htm");
	}	
}
