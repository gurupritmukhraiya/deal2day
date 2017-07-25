package com.d2d.service.common.beans;

import java.io.Serializable;
import java.util.List;

public class Category implements Serializable {
	
    private static final long serialVersionUID = 9139418379121258345L;
    
    private int idx;
    private String name;
    private String type;
    private Integer parent;    
    private List<Integer> children;

    public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Integer getParent() {
        return this.parent;
    }
    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public List<Integer> getChildren() {
        return this.children;
    }
    public void setChildren(List<Integer> children) {
        this.children = children;
    }
	
    public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}    
}

