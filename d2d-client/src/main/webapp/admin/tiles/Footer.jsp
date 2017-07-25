<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<div class="row" style="background:rgba(0,0,0,.6);margin:3% 0 0 0;padding:3%">
  <div class="row">
    <div class="col-md-2"></div>
  	<div class="col-md-8"><h2 style="color:#fff" class="text-center">DO NOT EVER MISS A DEAL</h2></div>
    <div class="col-md-2"></div>		
</div>
<div class="row">
    <div class="col-md-3"></div>
    <div class="col-md-6">
	      <div class="input-group">
  	      <input type="text" class="form-control" placeholder="Email Id/MobileNo" id="subContact">
          <span class="input-group-btn">
              <button class="btn btn-primary" type="button" onclick="subscribe('${context}')">Subscribe</button>
          </span>
    	  </div>
		</div>
		<div class="col-md-3"></div>
</div></div>
<div class="footer_top">
 <div class="container">
	<div class="span_of_4">
		<div class="span1_of_4">
			<h4>Company</h4>
			<ul class="f_nav">
				<li><a href="${context}/jsp/AboutUs.jsp">About Us</a></li>
				<li><a href="${context}/jsp/Career.jsp" >Career</a></li>	
				<li><a href="${context}/jsp/Disclaimer.jsp" >Disclaimer</a></li>
				<li><a href="${context}/jsp/PrivacyPolicy.jsp">Privacy Policy</a></li>
				<li><a href="${context}/jsp/TermsAndCondition.jsp">Terms & Condition</a></li>		
			</ul>	
		</div>
		<div class="span1_of_4">
			<h4>Learn More</h4>
			<ul class="f_nav">
				<li><a href="${context}/jsp/InviteFriend.jsp" >Invite Friend</a></li>
				<li><a href="${context}/jsp/MyDeals.jsp" >My Deals</a></li>
				<li><a href="${context}/jsp/HowItWorks.jsp" >How It Works</a></li>
				<li><a href="${context}/jsp/FAQ.jsp">FAQ</a></li>
				<li><a href="${context}/jsp/Testimonial.jsp">Testimonial</a></li>
			</ul>				
		</div>
		<div class="span1_of_4">
			<c:if test="${pageContext.request.userPrincipal.name == null}">
				<h4>Merchant</h4>
				<ul class="f_nav">
					<%--<li><a href="${context}/jsp/MerchantList.jsp" >Merchant Listing</a></li>--%>
					<li><a href="${context}/jsp/ProviderRegistration.jsp" >Merchant Sign Up</a></li>
					<li><a href="${context}/jsp/merchant-login.jsp" >Merchant Sign In</a></li>
				</ul>
			</c:if>	
			<h4>Advertise with us</h4>
			<ul class="f_nav">
				<li><a href="${context}/jsp/AdvertiseWithUsWhy.jsp" >Why Advertise With Us?</a></li>
				<li><a href="${context}/jsp/AdvertiseWithUsForm.jsp" >Advertise Yourself</a></li>
				<li><a href="${context}/jsp/AdvertiseWithUsPPT.jsp" >Quick Presentation</a></li>
			</ul>
		</div>
		<div class="span1_of_4">
			<h4>Social</h4>
            <iframe frameborder="0" src="//www.facebook.com/plugins/likebox.php?href=https%3A%2F%2Fwww.facebook.com%2Fdeal2day&amp;width=270&amp;height=150&amp;colorscheme=light&amp;show_faces=true&amp;header=true&amp;stream=false&amp;show_border=true" scrolling="no" style="overflow:hidden; width:100%; height:50%;" allowtransparency="true"></iframe>
		</div>		
		<div class="clearfix"></div>
		</div>
		<!-- start span_of_2 -->
		<div class="span_of_2" style="margin:0">
			<div class="span1_of_2">
				<h5>need help? <a href="${context}/jsp/ContactUs.jsp">contact us</a> </h5>
				<p>(or) Call us: +91-7890521430 </p>
			</div>
			<div class="clearfix"></div>
		</div>
  </div>
</div>
<!-- footer -->
<div class="footer">
 	<div class="container">
		<div class="copy">
			<p class="link">&copy; All rights reserved |&nbsp; <a href="http://deal2day.in/"> DEAL2DAY.IN</a></p>
		</div>
 	</div>
</div>