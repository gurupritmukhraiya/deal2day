package com.d2d.model.test;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.d2d.db.mediator.impl.OfferDBMediatorImpl;
import com.d2d.model.beans.OfferModel;
import com.d2d.service.common.beans.Category;
import com.d2d.service.common.beans.Filter;
import com.d2d.service.common.beans.Offer;

public class OfferTest {
    private OfferDBMediatorImpl offerDBMediatorImpl = new OfferDBMediatorImpl();

    public static void main(String[] args) {
    	
    	new OfferTest().getOffersByFilter();
    	
    }
    
    public void getOffersByFilter(){
    	Filter filter = new Filter();
    	//f1.setDescription("mayank 56th offer");
    	//f1.setStatus("A");
    	//f1.setCouponCode("GGFJ");
    	/*String area[] = {"sb road"};
    	f1.setArea(area);*/
    	//f1.setCity("nagpur");
    	//Integer i[] = {5};
    	//f1.setMerchantIds(i);*/
    	//f1.setCategory(i);
    	//filter.setStartDate(new Date());
    			//filter.setEndDate(new Date());
    			//filter.setStatus("A");
    			//filter.setCategoryName("group");
    			//filter.setArea(new String[]{"group"});
    			//filter.setSummary("group");
    			filter.setMerchantName("group");
    			filter.setCategoryName("minky");
    			filter.setSummary("test");
    			//filter.setCity("pune");
    	Set<Offer> o1 = this.offerDBMediatorImpl.getOffersByFilter(filter, true);
    	for(Offer o2: o1){
    		System.out.println("value: "+o2.getIdx()+"id"+o2.getMerchantId());
    	}
    	   
    	
    	
    }
    
    
    public void delete(){
    	offerDBMediatorImpl.deleteCategory(6);
    }
    
    public void addSub(){
    	Category cat = new Category();
    	cat.setName("Deal Sub");
    	cat.setType("Cat");
    	cat.setIdx(3);
    	
    	offerDBMediatorImpl.addCategory(cat);
    }
    
    public void getCat(){
    	/*boolean  cat = offerDBMediatorImpl.isCategoryExist("Heath and care", 0);
    	System.out.println(cat);*/
    	
    	offerDBMediatorImpl.getCategoryIdsFromOC(6);
    }
  
    
	private void deleteOffer() {
		offerDBMediatorImpl.deleteOffer(1);
		
	}

	public void updateOffer() {
        Offer offer = new Offer();
        offer.setCouponPrice(10);
        offer.setDiscount(50);
        offer.setMinBillAmt(100);
        offer.setCreatedDate(new Date());
        offer.setEndDate(new Date());
        offer.setStartDate(new Date());
        offer.setStatus("A");
        offer.setRating(5);
        offer.setMerchantId(1);
        
        List<Long> locations = new LinkedList<Long>();
        locations.add(1L);
        offer.setLocations(locations);
       
        List<Integer> categories = new LinkedList<Integer>();
        categories.add(1);
		offer.setCategories(categories);
		offer.setIdx(3);
        this.offerDBMediatorImpl.updateOffer(offer);
    }


	public void createOffer() {
        Offer offer = new Offer();
        offer.setCouponPrice(10);
        offer.setDiscount(50);
        offer.setMinBillAmt(100);
        offer.setCreatedDate(new Date());
        offer.setEndDate(new Date());
        offer.setStartDate(new Date());
        offer.setStatus("A");
        offer.setRating(5);
        offer.setMerchantId(1);
        
        List<Long> locations = new LinkedList<Long>();
        locations.add(1L);
        offer.setLocations(locations);
       
        List<Integer> categories = new LinkedList<Integer>();
        categories.add(1);
		offer.setCategories(categories);
        this.offerDBMediatorImpl.createOffer(offer);
    }

    public static OfferModel getOffer() {
        OfferModel offerModel = new OfferModel();
        offerModel.setStatus("A");
        Set<Integer> categories = new HashSet<Integer>();
		categories.add(1001);
		//offerModel.setCategoryIds(categories);
        offerModel.setCreatedDate(new Date(System.currentTimeMillis()));
        offerModel.setEndDate(new Date(System.currentTimeMillis()));
        offerModel.setStartDate(new Date(System.currentTimeMillis()));
        
        return offerModel;
    }
    
    public void addCategory() {
    	Category category = new Category();
    	
    	category.setParent(0);
    	category.setType("D2D");
    	category.setName("OfflineOffer");
    	offerDBMediatorImpl.addCategory(category);
    	
    	category.setParent(1);
    	category.setType("Cat");
    	
    	category.setName("Restaurant");
    	offerDBMediatorImpl.addCategory(category);
    	
    	category.setName("Health And Beauty");    	
    	offerDBMediatorImpl.addCategory(category);
    	
    	category.setName("Travel");
    	offerDBMediatorImpl.addCategory(category);
    	
    	category.setName("Activities");
    	offerDBMediatorImpl.addCategory(category);
    	
    	category.setName("Products");
    	offerDBMediatorImpl.addCategory(category);
    	
    	category.setName("Services");
    	offerDBMediatorImpl.addCategory(category);
    	
    	category.setName("Entertainment");
    	offerDBMediatorImpl.addCategory(category);
    	
    	category.setType("Subcat");
    	category.setParent(2);
    	
    	category.setName("Fine Dining");
    	offerDBMediatorImpl.addCategory(category);

    	category.setName("Cafe");
    	offerDBMediatorImpl.addCategory(category);
    	
    	category.setName("Fast Food");
    	offerDBMediatorImpl.addCategory(category);
    	
    	category.setName("Lounge And Pubs");
    	offerDBMediatorImpl.addCategory(category);
    	
    	category.setName("Fine Dining");
    	offerDBMediatorImpl.addCategory(category);
    	
    	category.setParent(3);
    	
    	category.setName("Spa And Salon");
    	offerDBMediatorImpl.addCategory(category);
    	
    	category.setName("Gym And Yoga");
    	offerDBMediatorImpl.addCategory(category);
    	
    	category.setName("Health And Fitness");
    	offerDBMediatorImpl.addCategory(category);
    	
    	category.setParent(4);
    	
    	category.setName("Hotels");
    	offerDBMediatorImpl.addCategory(category);
    	
    	category.setName("Holidays");
    	offerDBMediatorImpl.addCategory(category);
    	
    	category.setName("Cat And Cab Services");
    	offerDBMediatorImpl.addCategory(category);
    	
    	category.setParent(5);
    	
    	category.setName("Dance And Music Classes");
    	offerDBMediatorImpl.addCategory(category);
    	
    	category.setName("Sports");
    	offerDBMediatorImpl.addCategory(category);
    	
    	category.setName("Others");
    	offerDBMediatorImpl.addCategory(category);
    	
    	category.setParent(6);
    	
    	category.setName("Electronics, mobile And Laptops");
    	offerDBMediatorImpl.addCategory(category);
    	
    	category.setName("Furniture And Home Decor");
    	offerDBMediatorImpl.addCategory(category);
    	
    	category.setName("Kitchen Appliances");
    	offerDBMediatorImpl.addCategory(category);
    	
    	category.setName("Apparels");
    	offerDBMediatorImpl.addCategory(category);
    	
    	category.setName("Accessories");
    	offerDBMediatorImpl.addCategory(category);
    	
    	category.setName("Personal Care");
    	offerDBMediatorImpl.addCategory(category);
    	
    	category.setName("Groceries");
    	offerDBMediatorImpl.addCategory(category);
    	
    	category.setName("Gifts And Flowers");
    	offerDBMediatorImpl.addCategory(category);
    	
    	category.setParent(7);
    	
    	category.setName("Pest Control");
    	offerDBMediatorImpl.addCategory(category);
    	
    	category.setName("Interior Designer");
    	offerDBMediatorImpl.addCategory(category);
    	
    	category.setName("Education");
    	offerDBMediatorImpl.addCategory(category);
    	
    	category.setName("Financial Real Estate");
    	offerDBMediatorImpl.addCategory(category);
    	
    	category.setParent(8);
    	
    	category.setName("Electronics, mobile & Laptops");
    	offerDBMediatorImpl.addCategory(category);
    	
    	category.setName("Apparels");
    	offerDBMediatorImpl.addCategory(category);
    	
    	category.setName("Accessories");
    	offerDBMediatorImpl.addCategory(category);
    	
    	category.setName("Personal care");
    	offerDBMediatorImpl.addCategory(category);
    	
    	category.setName("Gifts & Flowers");
    	offerDBMediatorImpl.addCategory(category);
    	
    	category.setName("Furniture & Home decor");
    	offerDBMediatorImpl.addCategory(category);
    	
    	category.setName("Kitchen Appliances");
    	offerDBMediatorImpl.addCategory(category);
    	
    	category.setName("Groceries");
    	offerDBMediatorImpl.addCategory(category);
	}
    
    public void addCat(){
    	Category cModel = new Category();
    	cModel.setName("Mobile");
    	cModel.setType("Cat");
    	cModel.setParent(0);
    	
    	offerDBMediatorImpl.addCategory(cModel);
    }
    
    public void getCategories() {
		List<Category> categories = offerDBMediatorImpl.getCategories();
		for (Category category : categories) {
			System.out.println(category.getIdx());
		}
	}
}

