package com.d2d.service.category;

import com.d2d.service.category.CategoryBean;
import com.d2d.service.category.CategoryProperties;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CategoryPropertiesUtil {
    private static CategoryPropertiesUtil categoryPropertiesUtil = null;
    private List<CategoryBean> types = new LinkedList<CategoryBean>();

    private CategoryPropertiesUtil() {
        List<String> typeIds = CategoryPropertiesUtil.getMultiValues("d2d.types");
        for (String typeId : typeIds) {
            CategoryBean type = new CategoryBean(typeId, CategoryProperties.getInstance().getValue("d2d.type." + typeId), null, null);
            LinkedList<CategoryBean> categories = new LinkedList<CategoryBean>();
            List<String> categoryIds = CategoryPropertiesUtil.getMultiValues("d2d.categories." + typeId);
            for (String categoryId : categoryIds) {
                CategoryBean category = new CategoryBean(categoryId, CategoryProperties.getInstance().getValue("d2d.category." + categoryId), type, null);
                LinkedList<CategoryBean> subCategories = new LinkedList<CategoryBean>();
                List<String> subCategoryIds = CategoryPropertiesUtil.getMultiValues("d2d.subcategories." + categoryId);
                for (String subCategoryId : subCategoryIds) {
                    CategoryBean subCategory = new CategoryBean(subCategoryId, CategoryProperties.getInstance().getValue("d2d.subcategory." + subCategoryId), category, null);
                    subCategories.add(subCategory);
                    this.types.add(subCategory);
                }
                category.setChildren(subCategories);
                categories.add(category);
                this.types.add(category);
            }
            type.setChildren(categories);
            this.types.add(type);
        }
    }

    public static synchronized CategoryPropertiesUtil getInstance() {
        if (categoryPropertiesUtil == null) {
            categoryPropertiesUtil = new CategoryPropertiesUtil();
        }
        return categoryPropertiesUtil;
    }

    private static List<String> getMultiValues(String key) {
        String[] types = CategoryProperties.getInstance().getValue(key).split("#");
        return Arrays.asList(types);
    }

    public List<CategoryBean> getTypes() {
        return this.types;
    }

    public List<CategoryBean> getChildrenByeId(String id) {
        CategoryBean categoryBean = new CategoryBean();
        categoryBean.setId(id);
        return this.types.get(this.types.indexOf(categoryBean)).getChildren();
    }

    public CategoryBean getParentByeId(String id) {
        CategoryBean categoryBean = new CategoryBean();
        categoryBean.setId(id);
        return this.types.get(this.types.indexOf(categoryBean)).getParent();
    }

    public String getNameById(String id) {
        CategoryBean categoryBean = new CategoryBean();
        categoryBean.setId(id);
        return this.types.get(this.types.indexOf(categoryBean)).getName();
    }

    public static void main(String[] args) {
    }
}

