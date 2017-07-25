/**
 * 
 */
package com.d2d.service;

import java.util.List;

import com.d2d.cache.CategoryCache;
import com.d2d.service.common.beans.Category;


/**
 * @author guruprit_mukhraiya
 *
 */
public class CategoryService {

	private CategoryCache categoryCache = CategoryCache.getInstanse();
	
    private static CategoryService categoryService;
    
    private CategoryService() {
    }

	public static CategoryService getInstanse() {
        if (categoryService == null) {
        	categoryService = new CategoryService();
        }
        return categoryService;
    }
	
	public Category getCategoryById(Integer categoryId) {
        return categoryCache.getCategoryById(categoryId);
    }

    public void addCategory(Category category) {
    	categoryCache.addCategory(category);
    }
    
    public List<Category> getAllCategory() {
    	return categoryCache.getAllCategory();
    }	
    
    public String getParentName(Integer categoryId) {
        Category category = categoryCache.getCategoryById(categoryId);
        Integer parentId = category.getParent();
        Category parentCategory = categoryCache.getCategoryById(parentId);
        if(parentCategory != null){
        	return parentCategory.getName();
        }
        return "D2D";
        
    }
}
