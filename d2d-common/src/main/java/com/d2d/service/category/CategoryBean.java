package com.d2d.service.category;

import java.io.Serializable;
import java.util.List;

public class CategoryBean
implements Serializable {
    private static final long serialVersionUID = 9139418379121258345L;
    private String id;
    private String name;
    private CategoryBean parent;
    private List<CategoryBean> children;

    public CategoryBean() {
    }

    public CategoryBean(String id, String name, CategoryBean parent, List<CategoryBean> children) {
        this.id = id;
        this.name = name;
        this.parent = parent;
        this.children = children;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryBean getParent() {
        return this.parent;
    }

    public void setParent(CategoryBean parent) {
        this.parent = parent;
    }

    public List<CategoryBean> getChildren() {
        return this.children;
    }

    public void setChildren(List<CategoryBean> children) {
        this.children = children;
    }

    public boolean equals(Object obj) {
        if (obj != null && obj instanceof CategoryBean) {
            CategoryBean categoryBean = (CategoryBean)obj;
            return this.id.equals(categoryBean.id);
        }
        return false;
    }
}

