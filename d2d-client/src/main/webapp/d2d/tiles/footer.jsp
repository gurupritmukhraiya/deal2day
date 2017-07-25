<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
		<!-- <div class="row home-intro text-center">
			<div class="col-lg-12">
				<h2 class="tagline">TOP MERCHANTS</h2>
				<hr class="small">
				<div class="row">
					<div class="col-md-2 col-sm-4 col-xs-6"><a href="http://www.amazon.in" target="_blank"><img src="http://img.deal2day.in/merchant/amazon.jpg" alt="amazon unlimited offers, deals, promocodes and coupons"  class="img-responsive"></a></div>
					<div class="col-md-2 col-sm-4 col-xs-6"><a href="http://www.flipkart.com" target="_blank"><img src="http://img.deal2day.in/merchant/flipkart.jpg" alt="flipkart unlimited offers, deals, promocodes and coupons"  class="img-responsive"></a></div>
					<div class="col-md-2 col-sm-4 col-xs-6"><a href="http://www.ebay.com" target="_blank"><img src="http://img.deal2day.in/merchant/ebay.jpg" alt="ebay unlimited offers, deals, promocodes and coupons" class="img-responsive"></a></div>
					<div class="col-md-2 col-sm-4 col-xs-6"><a href="http://www.paytm.com" target="_blank"><img src="http://img.deal2day.in/merchant/paytm.jpg" alt="paytm unlimited offers, deals, promocodes and coupons" class="img-responsive"></a></div>
					<div class="col-md-2 col-sm-4 col-xs-6"><a href="http://www.dominos.com" target="_blank"><img src="http://img.deal2day.in/merchant/dominos.jpg" class="img-responsive" alt="dominos unlimited offers, deals, promocodes and coupons" ></a></div>
					<div class="col-md-2 col-sm-4 col-xs-6"><a href="http://www.foodpanda.com" target="_blank"><img src="http://img.deal2day.in/merchant/foodpanda.jpg" class="img-responsive" alt="foodpanda unlimited offers, deals, promocodes and coupons" ></a></div>
					<div class="col-md-2 col-sm-4 col-xs-6"><a href="http://www.firstcry.com"  target="_blank"><img src="http://img.deal2day.in/merchant/firstcry.jpg" class="img-responsive" alt="firstcry unlimited offers, deals, promocodes and coupons" ></a></div>
					<div class="col-md-2 col-sm-4 col-xs-6"><a href="http://www.makemytrip.com" target="_blank"><img src="http://img.deal2day.in/merchant/makemytrip.jpg" class="img-responsive" alt="makemytrip unlimited offers, deals, promocodes and coupons" ></a></div>
					<div class="col-md-2 col-sm-4 col-xs-6"><a href="http://www.pepperfry.com" target="_blank"><img src="http://img.deal2day.in/merchant/pepperfry.jpg" class="img-responsive" alt="pepperfry unlimited offers, deals, promocodes and coupons" ></a></div>
					<div class="col-md-2 col-sm-4 col-xs-6"><a href="http://shopping.rediff.com/shopping/index.html" target="_blank"><img src="http://img.deal2day.in/merchant/rediff.jpg" class="img-responsive" alt="rediff shopping unlimited offers, deals, promocodes and coupons" ></a></div>
					<div class="col-md-2 col-sm-4 col-xs-6"><a href="http://www.snapdeal.com" target="_blank"><img src="http://img.deal2day.in/merchant/snapdeal.jpg" class="img-responsive" alt="snapdeal unlimited offers, deals, promocodes and coupons" ></a></div>
					<div class="col-md-2 col-sm-4 col-xs-6"><a href="http://www.shopclues.com" target="_blank"><img src="http://img.deal2day.in/merchant/shopclues.jpg" class="img-responsive" alt="shopclues unlimited offers, deals, promocodes and coupons" ></a></div>
				</div>						
			</div>
		</div>
		 -->
		<hr class="small">
		<div class="jumbotron" style="margin-bottom:0;background: #d9534f ;color: #fff;">
			<div class="row">
	  			<div class="col-md-4">
	          		<img width="200" class="img-circle img-responsive" src="${context }/d2d/img/Mail3.png">
	          	</div>
	          	<div class="col-md-8">
	          		<h2 class="text-left text-info" style="mergin-top:0px;color: #fff;">Subscribe to our news letter.</h2>
	       			<h4 class="text-left text-info" style="color: #fff;">Do not ever miss a deal, Subscribe to get the latest nearby offer delivered directly to your inbox.</h4>
	  		  	  	<div class="form-group">
	                	<div class="input-group form-group-lg">
	                  		<div class="input-group-addon">@</div>
	                		<input placeholder="Email Address" id="subs-contact" class="form-control">
	                		<div class="input-group-btn">
								<button class="btn btn-lg btn-primary" onClick="subcribeWithUs('${context }')">Subscribe</button>
							</div>
	                	</div>
	              	</div>
	              	<div id="subs-result"></div>      	
	              	<h5 class="text-left"><small style="color: #fff;">You can unsubscribe at any time</small></h5>
	         	</div>
	        </div>
		</div>		
		<div class="well" style="background: #563d7c; color:#fff">
			<div class="container text-center">		
				<div class="row">
				  <div class="col-md-2 col-md-offset-1"><i class="fa fa-users fa-5x"></i><p> 2000+ Users </p></div>
				  <div class="col-md-2"><i class="fa fa-ticket fa-5x"></i><p>5000+ OFFERS</p></div>
				  <div class="col-md-2"><i class="fa fa-medium fa-5x"></i><p>500+ Merchants</p></div>
				  <div class="col-md-2"><i class="fa fa-inr fa-5x"></i><p>FREE COUPONS</p></div>
				  <div class="col-md-2"><i class="fa fa-shopping-cart fa-5x"></i><p>All Top Online Store</p></div>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<ul class="list-inline text-center">
						<li><a href="http://story.deal2day.in" class="text-muted" target="_blank">Home</a></li>
						<li><a href="http://story.deal2day.in#about" class="text-muted" target="_blank">About Us</a></li>
						<li><a href="http://story.deal2day.in#services" class="text-muted" target="_blank">Services</a></li>
						<li><a href="http://story.deal2day.in#portfolio" class="text-muted" target="_blank">Portfolio</a></li>
						<li><a href="http://story.deal2day.in/#contact" class="text-muted" target="_blank">Contact Us</a></li>
						<li><a href="http://story.deal2day.in/Disclaimer.html#dis" class="text-muted" target="_blank">Disclaimer</a></li>
						<li><a href="http://story.deal2day.in/Disclaimer.html#policy" class="text-muted" target="_blank">Privacy Policy</a></li>
						<li><a href="http://story.deal2day.in/Disclaimer.html#term" class="text-muted" target="_blank">Terms & Condition</a></li>
					</ul>	
				</div>				
			</div>			
			<hr class="small">
			<div class="row">
				<div class="pull-right text-center col-md-6">
					<a href="https://www.facebook.com/deal2day" style="color:#3b5998;" target="_blank"><i class="fa fa-facebook-square fa-2x"></i></a>
					<a href="https://plus.google.com/113781312400206743282" target="_blank" style="color:#dd4b39;"><i class="fa fa-google-plus-square fa-2x"></i></a>
					<a href="https://twitter.com/Deal2Day_in" target="_blank" style="color:#00aced;"><i class="fa fa-twitter-square fa-2x"></i></a>
					<a href="https://in.linkedin.com/in/deal2day" style="color:#007bb6;" target="_blank"><i class="fa fa-linkedin-square fa-2x"></i></a>
					<a href="https://www.pinterest.com/deal2day0139/" target="_blank" style="color:#cb2027;"><i class="fa fa-pinterest-square fa-2x"></i></a>
					<a href="mailto:contactus@deal2day.in" target="_top" target="_blank"><i class="fa fa-envelope-square fa-2x" title="Sent Mail"></i></a>	
				</div>
				<div class="text-center col-md-6" style="margin-top:5px;">					
					<p>&copy; All rights reserved |&nbsp; <a href="http://story.deal2day.in/" target="_blank"> DEAL2DAY.IN</a></p>				
				</div>
			</div>			
		</div>
</div>