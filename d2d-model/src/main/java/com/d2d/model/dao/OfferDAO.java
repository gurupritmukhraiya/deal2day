package com.d2d.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

import com.d2d.db.exception.DBServiceException;
import com.d2d.db.exception.DBServiceIssueHandler;
import com.d2d.db.exception.HibernateInteralExceptionSupDBService;
import com.d2d.db.exception.IssueHandlerIntf;
import com.d2d.db.exception.UnknownExceptionSupDBService;
import com.d2d.model.beans.CategoryModel;
import com.d2d.model.beans.OfferModel;
import com.d2d.model.dao.intf.OfferDAOIntf;
import com.d2d.service.common.beans.Filter;

public class OfferDAO extends GenricDAOAbs implements OfferDAOIntf {
   
	private static final Log log = LogFactory.getLog(OfferDAO.class);
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public org.hibernate.Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public void create(OfferModel offerModel) throws DBServiceException {
        super.create(offerModel, getCurrentSession());
    }
    

    @Override
    public OfferModel getOfferById(long idx, boolean includeMerchant, boolean includeLocations) throws DBServiceException {
        log.debug((Object)("finding instance with id: " + idx));
        try {
            String queryStr = "from OfferModel offerModel where offerModel.idx = '" + idx + "'";
            Query query = this.getCurrentSession().createQuery(queryStr);
            OfferModel offerModel = (OfferModel)query.uniqueResult();
            if (includeMerchant) {
                Hibernate.initialize((Object)offerModel.getMerchant());
            }
            if (includeLocations) {
                Hibernate.initialize(offerModel.getLocations());
            }
            return offerModel;
        }
        catch (HibernateException he) {
            log.debug((Object)"Find by offer id failed");
            HibernateInteralExceptionSupDBService hibernateInteralExceptionSupDBService = new HibernateInteralExceptionSupDBService((Exception)he, (IssueHandlerIntf)new DBServiceIssueHandler());
            hibernateInteralExceptionSupDBService.handle();
            hibernateInteralExceptionSupDBService.printStackTrace();
            throw hibernateInteralExceptionSupDBService;
        }
        catch (Exception ex) {
            UnknownExceptionSupDBService unknownIssue = new UnknownExceptionSupDBService(ex, (IssueHandlerIntf)new DBServiceIssueHandler());
            unknownIssue.handle();
            unknownIssue.printStackTrace();
            throw unknownIssue;
        }
    }

    @Override
    public void update(OfferModel offerModel) throws DBServiceException {
    	super.update(offerModel, this.getCurrentSession());
    }

    @Override
    public void delete(long idx) throws DBServiceException {
    	OfferModel model = getOfferById(idx, false, false);
        super.delete(model, getCurrentSession());
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<OfferModel> getOffersByFilter(Filter filter, boolean includeMerchant, boolean includeLocations) throws DBServiceException {
        log.debug("finding OfferModel instance with filter");
        List<OfferModel> offers = new ArrayList<OfferModel>();
        try {
            Criteria criteria = this.getCurrentSession().createCriteria(OfferModel.class);
            		 criteria.createAlias("merchant", "mer");
            if(filter.getCity() != null){
            	criteria.createAlias("locations", "location").add(Restrictions.like("location.city", filter.getCity()));
            }
            if (filter.getMaxPrice() > 0 || filter.getMinPrice() > 0) {
                criteria.add(Restrictions.between("price", filter.getMinPrice(), filter.getMaxPrice()));
            }
            if (filter.getMinDiscount() > 0 || filter.getMaxDiscount() > 0) {
                criteria.add(Restrictions.between("discount", filter.getMinDiscount(), filter.getMaxDiscount()));
            }
            if (filter.getMinCouponPrice() > 0 || filter.getMaxCouponPrice() > 0) {
                criteria.add(Restrictions.between("couponPrice", filter.getMinCouponPrice(), filter.getMaxCouponPrice()));
            }
            if (filter.getStartDate() != null || filter.getEndDate() != null) {
                SimpleExpression startDate = Restrictions.le("startDate", filter.getStartDate());
                SimpleExpression endDate = Restrictions.ge("endDate", filter.getEndDate());
                LogicalExpression andExp = Restrictions.and(startDate, endDate);
                criteria.add(andExp);
            }
            if (filter.getArea() != null) {
            	
            	Criterion area = Restrictions.in("location.area", filter.getArea());
            	Criterion city = Restrictions.like("location.city", filter.getCity());
            	LogicalExpression andExp = Restrictions.and(city, area);
            	criteria.add( andExp );
            }
            if (filter.getStatus() != null) {
                criteria.add(Restrictions.eq("status", filter.getStatus()));
            }
            if (filter.getPromoCode() != null) {
                criteria.add(Restrictions.eq("promoCode", filter.getPromoCode()));
            }
            if (filter.getMerchantIds() != null && filter.getMerchantIds().length >0) {
                criteria.add(Restrictions.in("mer.idx",filter.getMerchantIds()));
            }
            if (filter.getCategory() != null && filter.getCategory().length > 0) {
                criteria.createAlias("category", "category").add(Restrictions.in("category.idx", filter.getCategory()));
            }
            if (filter.getSummary() != null) {
                criteria.add((Criterion)Restrictions.like((String)"title", (Object)filter.getSummary()));
            }
            if(filter.getCategoryName() != null){
            	criteria.createAlias("category", "category").add(Restrictions.like("category.name", filter.getCategoryName(),MatchMode.ANYWHERE));
            }
            if(filter.getMerchantName() != null){
            	criteria.createAlias("mer.merchantProfile", "me").add(Restrictions.like("me.merchantName", filter.getMerchantName()));
            }
            if (filter.getLimit() != 0) {
                criteria.setMaxResults(filter.getLimit());
            }
            if(filter.isDistintMerchant()){
            	criteria.createAlias("merchant", "mer").setProjection(Projections.distinct(Projections.property("mer.idx")));
            }
            criteria.addOrder(Order.desc("startDate"));
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            offers = (ArrayList<OfferModel>)criteria.list();
            for (OfferModel offerModel : offers) {
            	if (includeMerchant) {
                    Hibernate.initialize(offerModel.getMerchant());
                }
                if (includeLocations) {
                    Hibernate.initialize(offerModel.getLocations());
                }
			}
            return offers;
        }
        catch (HibernateException he) {
            log.debug((Object)"Find by User id failed");
            HibernateInteralExceptionSupDBService hibernateInteralExceptionSupDBService = new HibernateInteralExceptionSupDBService((Exception)he, (IssueHandlerIntf)new DBServiceIssueHandler());
            hibernateInteralExceptionSupDBService.handle();
            hibernateInteralExceptionSupDBService.printStackTrace();
            throw hibernateInteralExceptionSupDBService;
        }
        catch (Exception ex) {
            UnknownExceptionSupDBService unknownIssue = new UnknownExceptionSupDBService(ex, (IssueHandlerIntf)new DBServiceIssueHandler());
            unknownIssue.handle();
            unknownIssue.printStackTrace();
            throw unknownIssue;
        }
    }

    @Override
    public List<OfferModel> getOffersByOR(Filter filter, boolean includeMerchant, boolean includeLocations)
    		throws DBServiceException {
        log.debug("finding OfferModel instance with filter for OR condition");
        List<OfferModel> offers = new ArrayList<OfferModel>();
        try {
       
        	String status = filter.getStatus();
        	String catName = filter.getCategoryName();
        	String city = filter.getCity();
        	String summary = filter.getSummary();
        	String merName = filter.getMerchantName();
        	
        	String queryStr = "select offerModel from OfferModel offerModel"
        			+ " join offerModel.locations as location "
        			+ " join offerModel.category as cat "
        			+ " join offerModel.merchant as merch "
        			+ " join merch.merchantProfile as mer "
        			+ " where location.city like '%" +city+ "%' OR mer.merchantName like '%"+merName+"%' OR cat.name like '%"+catName+"%' OR  offerModel.title like '%"+summary+"%'";
            
        	Query query = this.getCurrentSession().createQuery(queryStr);
            
            offers = (ArrayList<OfferModel>)query.list();
            for (OfferModel offerModel : offers) {
            	if (includeMerchant) {
                    Hibernate.initialize(offerModel.getMerchant());
                }
                if (includeLocations) {
                    Hibernate.initialize(offerModel.getLocations());
                }
			}
            
        	return offers;
        }
        catch (HibernateException he) {
            log.debug((Object)"Find by User id failed");
            HibernateInteralExceptionSupDBService hibernateInteralExceptionSupDBService = new HibernateInteralExceptionSupDBService((Exception)he, (IssueHandlerIntf)new DBServiceIssueHandler());
            hibernateInteralExceptionSupDBService.handle();
            hibernateInteralExceptionSupDBService.printStackTrace();
            throw hibernateInteralExceptionSupDBService;
        }
        catch (Exception ex) {
            UnknownExceptionSupDBService unknownIssue = new UnknownExceptionSupDBService(ex, (IssueHandlerIntf)new DBServiceIssueHandler());
            unknownIssue.handle();
            unknownIssue.printStackTrace();
            throw unknownIssue;
        }
    }
    
	@Override
	public void addCategory(CategoryModel categoryModel) throws DBServiceException {
		 super.create(categoryModel, this.getCurrentSession());		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CategoryModel> getCategories() throws DBServiceException {

        log.debug((Object)"finding OfferModel instance with filter");
        List<CategoryModel> categoryModels = new ArrayList<CategoryModel>();
        try {
            Criteria criteria = this.getCurrentSession().createCriteria(CategoryModel.class);
            categoryModels = (ArrayList<CategoryModel>)criteria.list();
            return categoryModels;
        }
        catch (HibernateException he) {
            log.debug((Object)"Find by User id failed");
            HibernateInteralExceptionSupDBService hibernateInteralExceptionSupDBService = new HibernateInteralExceptionSupDBService((Exception)he, (IssueHandlerIntf)new DBServiceIssueHandler());
            hibernateInteralExceptionSupDBService.handle();
            hibernateInteralExceptionSupDBService.printStackTrace();
            throw hibernateInteralExceptionSupDBService;
        }
        catch (Exception ex) {
            UnknownExceptionSupDBService unknownIssue = new UnknownExceptionSupDBService(ex, (IssueHandlerIntf)new DBServiceIssueHandler());
            unknownIssue.handle();
            unknownIssue.printStackTrace();
            throw unknownIssue;
        }
    
	}
	
	@Override
	public CategoryModel getCategoryByName(String var1, int var2)
			throws DBServiceException {
		 log.debug((Object)("finding instance with name: " + var1));
	        try {
	        	String queryStr = "from CategoryModel categoryModel where categoryModel.name = '%" + var1 + "' AND categoryModel.parent = '"+ var2 +"'";
	            Query query = this.getCurrentSession().createQuery(queryStr);
	            CategoryModel categoryModel = (CategoryModel)query.uniqueResult();
	           return categoryModel;
	        }
	        catch (HibernateException he) {
	            log.debug((Object)"Find by Category id failed");
	            HibernateInteralExceptionSupDBService hibernateInteralExceptionSupDBService = new HibernateInteralExceptionSupDBService((Exception)he, (IssueHandlerIntf)new DBServiceIssueHandler());
	            hibernateInteralExceptionSupDBService.handle();
	            hibernateInteralExceptionSupDBService.printStackTrace();
	            throw hibernateInteralExceptionSupDBService;
	        }
	        catch (Exception ex) {
	            UnknownExceptionSupDBService unknownIssue = new UnknownExceptionSupDBService(ex, (IssueHandlerIntf)new DBServiceIssueHandler());
	            unknownIssue.handle();
	            unknownIssue.printStackTrace();
	            throw unknownIssue;
	        }
	}
	
	@Override
	public void updateCategory(CategoryModel var1) throws DBServiceException {
		super.update(var1, this.getCurrentSession());
	}
	
	@Override
	public List<CategoryModel> getCategoryParentIds(Integer var1)
			throws DBServiceException {
		 log.debug((Object)("finding instance with name: " + var1));
	        try {
	        	String queryStr = "from CategoryModel categoryModel where categoryModel.parent = '"+ var1 +"'";
	            Query query = this.getCurrentSession().createQuery(queryStr);
	            List<CategoryModel> categoryModel = query.list();
	            return categoryModel;
	        }
	        catch (HibernateException he) {
	            log.debug((Object)"Find by category parent id failed");
	            HibernateInteralExceptionSupDBService hibernateInteralExceptionSupDBService = new HibernateInteralExceptionSupDBService((Exception)he, (IssueHandlerIntf)new DBServiceIssueHandler());
	            hibernateInteralExceptionSupDBService.handle();
	            hibernateInteralExceptionSupDBService.printStackTrace();
	            throw hibernateInteralExceptionSupDBService;
	        }
	        catch (Exception ex) {
	            UnknownExceptionSupDBService unknownIssue = new UnknownExceptionSupDBService(ex, (IssueHandlerIntf)new DBServiceIssueHandler());
	            unknownIssue.handle();
	            unknownIssue.printStackTrace();
	            throw unknownIssue;
	        }
	}
	
	@Override
	public void deleteCategory(Integer var1) throws DBServiceException {
		 log.debug((Object)("finding instance with name: " + var1));
	        try {
	        	String queryStr = "DELETE from CategoryModel categoryModel where categoryModel.idx = '"+ var1 +"'";
	            Query query = this.getCurrentSession().createQuery(queryStr);
	            query.executeUpdate();
	        }
	        catch (HibernateException he) {
	            log.debug((Object)"Find by category parent id failed");
	            HibernateInteralExceptionSupDBService hibernateInteralExceptionSupDBService = new HibernateInteralExceptionSupDBService((Exception)he, (IssueHandlerIntf)new DBServiceIssueHandler());
	            hibernateInteralExceptionSupDBService.handle();
	            hibernateInteralExceptionSupDBService.printStackTrace();
	            throw hibernateInteralExceptionSupDBService;
	        }
	        catch (Exception ex) {
	            UnknownExceptionSupDBService unknownIssue = new UnknownExceptionSupDBService(ex, (IssueHandlerIntf)new DBServiceIssueHandler());
	            unknownIssue.handle();
	            unknownIssue.printStackTrace();
	            throw unknownIssue;
	        }
	}
	
	@Override
	public List<Integer> getCatIdsFromOfferCategoryTable(Integer var1)
			throws DBServiceException {
		try {
		
        	String queryStr = "select offerModel.idx from OfferModel offerModel inner join offerModel.category cat with cat.idx='"+ var1 +"'";
            Query query = this.getCurrentSession().createQuery(queryStr);
            List<Integer> idxList = query.list();
            return idxList;
        }
        catch (HibernateException he) {
            log.debug((Object)"Find by category parent id failed");
            HibernateInteralExceptionSupDBService hibernateInteralExceptionSupDBService = new HibernateInteralExceptionSupDBService((Exception)he, (IssueHandlerIntf)new DBServiceIssueHandler());
            hibernateInteralExceptionSupDBService.handle();
            hibernateInteralExceptionSupDBService.printStackTrace();
            throw hibernateInteralExceptionSupDBService;
        }
        catch (Exception ex) {
            UnknownExceptionSupDBService unknownIssue = new UnknownExceptionSupDBService(ex, (IssueHandlerIntf)new DBServiceIssueHandler());
            unknownIssue.handle();
            unknownIssue.printStackTrace();
            throw unknownIssue;
        }
	}
	
	@Override
	public void updateOfferCatNotExist(String var1, Integer var2)
			throws DBServiceException {
	try{
		
		String queryStr = "update OfferModel offerModel set offerModel.status='"+var1+"' inner join offerModel.category cat with cat.idx='"+ var1 +"'";
        Query query = this.getCurrentSession().createQuery(queryStr);
        int i = query.executeUpdate();
        System.out.println("IIIII:"+i);
		
	} catch (HibernateException he) {
        log.debug((Object)"Find by category parent id failed");
        HibernateInteralExceptionSupDBService hibernateInteralExceptionSupDBService = new HibernateInteralExceptionSupDBService((Exception)he, (IssueHandlerIntf)new DBServiceIssueHandler());
        hibernateInteralExceptionSupDBService.handle();
        hibernateInteralExceptionSupDBService.printStackTrace();
        throw hibernateInteralExceptionSupDBService;
    }
    catch (Exception ex) {
        UnknownExceptionSupDBService unknownIssue = new UnknownExceptionSupDBService(ex, (IssueHandlerIntf)new DBServiceIssueHandler());
        unknownIssue.handle();
        unknownIssue.printStackTrace();
        throw unknownIssue;
    }
 }
	
	@Override
	public CategoryModel getCategoryById(Integer idx)
			throws DBServiceException {
		 log.debug((Object)("finding instance with id: " + idx));
	        try {
	            String queryStr = "from CategoryModel catModel where catModel.idx = '" + idx + "'";
	            Query query = this.getCurrentSession().createQuery(queryStr);
	            CategoryModel catModel = (CategoryModel)query.uniqueResult();
	            return catModel;
	        }
	        catch (HibernateException he) {
	            log.debug((Object)"Find by offer id failed");
	            HibernateInteralExceptionSupDBService hibernateInteralExceptionSupDBService = new HibernateInteralExceptionSupDBService((Exception)he, (IssueHandlerIntf)new DBServiceIssueHandler());
	            hibernateInteralExceptionSupDBService.handle();
	            hibernateInteralExceptionSupDBService.printStackTrace();
	            throw hibernateInteralExceptionSupDBService;
	        }
	        catch (Exception ex) {
	            UnknownExceptionSupDBService unknownIssue = new UnknownExceptionSupDBService(ex, (IssueHandlerIntf)new DBServiceIssueHandler());
	            unknownIssue.handle();
	            unknownIssue.printStackTrace();
	            throw unknownIssue;
	        }
	}
	
	@Override
	public void updateImage(long offerId, String imagePath) throws DBServiceException {
		Map<String, String> path = new HashMap<String, String>();
		path.put("imageURL", imagePath);
		super.update(OfferModel.class, path, "_IDX", offerId, getCurrentSession());
		
	}
}

