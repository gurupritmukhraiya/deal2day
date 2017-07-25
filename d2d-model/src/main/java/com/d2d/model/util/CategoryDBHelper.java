/**
 * 
 */
package com.d2d.model.util;

import com.d2d.model.beans.CategoryModel;
import com.d2d.service.common.beans.Category;

/**
 * @author guruprit_mukhraiya
 *
 */
public class CategoryDBHelper {


	private static CategoryDBHelper categoryDBHelper;

    private CategoryDBHelper() {
    }

    public static CategoryDBHelper getInstance() {
        if (categoryDBHelper == null) {
        	categoryDBHelper = new CategoryDBHelper();
        }
        return categoryDBHelper;
    }
    
    public Category getCategoryByCategoryModel(CategoryModel categoryModel) {
        Category category = null;
        if (categoryModel != null) {
        	category = new Category();
        	category.setName(categoryModel.getName());
        	category.setIdx(categoryModel.getIdx());
        	category.setParent(categoryModel.getParent());
        	category.setType(categoryModel.getType());
        }
        return category;
    }
    
    public CategoryModel getCategoryModelByCategory(Category category) {
        CategoryModel categoryModel = null;
        if (category != null) {
        	categoryModel = new CategoryModel();
        	categoryModel.setName(category.getName());
        	categoryModel.setParent(category.getParent());
        	categoryModel.setType(category.getType());
        	if(category.getIdx() < 0)
        		categoryModel.setIdx(category.getIdx());
        }
        return categoryModel;
    }
}
