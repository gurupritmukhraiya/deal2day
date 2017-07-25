/**
 * 
 */
package com.d2d.model.beans;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author guruprit_mukhraiya
 *
 */
@Entity
@Table(name="_category", uniqueConstraints={@UniqueConstraint(columnNames={"_NAME"})})
public class CategoryModel implements Serializable{

	private static final long serialVersionUID = -7284690835554791082L;

	private Integer idx;
	private String name;
	private Integer parent;
	private String type;
	private Set<OfferModel> offers;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="_IDX", unique=true, nullable=false)
	public Integer getIdx() {
		return idx;
	}
	public void setIdx(Integer idx) {
		this.idx = idx;
	}
	
	@Column(name="_NAME", nullable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="_PARENT")
	public Integer getParent() {
		return parent;
	}
	public void setParent(Integer parent) {
		this.parent = parent;
	}
	
	@Column(name="_TYPE", nullable=false)
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "category")
	public Set<OfferModel> getOffers() {
		return offers;
	}
	public void setOffers(Set<OfferModel> offers) {
		this.offers = offers;
	}
}
