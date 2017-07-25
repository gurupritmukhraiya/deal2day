package com.d2d.cache;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.d2d.db.mediator.impl.OfferDBMediatorImpl;
import com.d2d.db.mediator.intf.OfferDBMediatorIntf;
import com.d2d.service.common.beans.Category;

public class CategoryCache {
	
	private OfferDBMediatorIntf offerDBService = new OfferDBMediatorImpl();
    
    private static Map<Integer, Category> categoryMap;
    private static Map<String, Category> categoryNameMap;
    private static CategoryCache cache;
    
    public static void reloadCache(){
    	categoryMap = null;
    	categoryNameMap = null;
    	cache = null;
    	getInstanse();
    }
    
    private CategoryCache() {
    	List<Category> categoriesFromDB = offerDBService.getCategories();
    	for (Category categoryFromDB : categoriesFromDB) {
    		addCategory(categoryFromDB);
		}
    	for (Integer categoryId : categoryMap.keySet()) {
    		Category category = categoryMap.get(categoryId);
    		Category parentCategory = categoryMap.get(category.getParent());
    		if(parentCategory != null){
    			List<Integer> childOfParent = parentCategory.getChildren();
    			if(childOfParent == null){
        			childOfParent = new ArrayList<Integer>();
        		}
        		
        		childOfParent.add(category.getIdx());
        		parentCategory.setChildren(childOfParent);
    		}
    	}    		
    }
    
    public static void reloadCategoryCache(){
    	categoryMap = null;
    	categoryNameMap = null;
		cache = null;
    }

	public static CategoryCache getInstanse() {
		if (categoryMap == null) {
        	/*categoryMap = new ConcurrentHashMap<Integer, Category>();*/
			categoryMap = new TreeMap<Integer, Category>();
        }
		if(categoryNameMap == null){
			categoryNameMap = new TreeMap<String, Category>();
		}
        if (cache == null) {
        	cache = new CategoryCache();
        }        
        return cache;
    }
	
	public Category getCategoryById(Integer categoryId) {
        return categoryMap.get(categoryId);
    }
	
	public Category getCategoryByName(String categoryName) {
        return categoryNameMap.get(categoryName);
    }
	
	public List<Category> getCategoryByType(String type) {
		Collection<Category> categoriesFromMap = categoryMap.values();
    	List<Category> categories = new ArrayList<Category>();
    	for (Category category : categoriesFromMap) {
    		if(category.getType().equalsIgnoreCase(type)){
    			categories.add(category);
    		}
		}
    	return categories;
    }

    public void addCategory(Category category) {
    	categoryMap.put(category.getIdx(), category);
    	categoryNameMap.put(category.getName(), category);
    }
    
    public List<Category> getAllCategory() {
    	Collection<Category> categoriesFromMap = categoryMap.values();
    	List<Category> categories = new ArrayList<Category>();
    	for (Category category : categoriesFromMap) {
    		categories.add(category);
		}
    	return categories;
    }
    
    public static void main(String[] args) {
		List<Category> categories = CategoryCache.getInstanse().getAllCategory();
		for (Category category : categories) {
			System.out.println(category.getName());
		}
	}
}

