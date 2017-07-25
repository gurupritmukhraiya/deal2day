<%@page import="com.d2d.constants.SEOConstant" %>
<%@page import="com.d2d.service.seo.impl.SEOObject"%>
         
     <%!String title ="";
        String keywordData = "";
        String description = "";
        String pageName ="";%>
	  <%
	  	pageName = request.getRequestURI(); 
	  	      StringBuffer sbtemp = new StringBuffer(pageName).delete(0, 5);
	  	      pageName = new String(sbtemp);
	  	      title = SEOObject.getInstance().getProperty(pageName + SEOConstant.PAGE_TITLE);
	  		  keywordData = SEOObject.getInstance().getProperty(pageName + SEOConstant.META_KEYWORD);
	  		  description = SEOObject.getInstance().getProperty(pageName + SEOConstant.META_DESC);
	  %>
	  <%
	  if(title == null || keywordData == null ||description == null){
		  title ="Deal2day My City, My Offer";
		  keywordData = "Deal2day My City, My Offer";
		  description = "Deal2day My City, My Offer";
	  }
	  %>
	 <title><%=title%></title>
	 <meta content="<%=keywordData%>" name="keywords" >
	 <meta   content="<%=description%>"  name="description">
	 
	