<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<script>
	$( document ).ready(function() {
		$('.carousel').carousel({
	  		interval: 3000
		});
	});
</script>
<div class="container">
	<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
    	<ol class="carousel-indicators">
             <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
             <li data-target="#carousel-example-generic" data-slide-to="1"></li>
             <li data-target="#carousel-example-generic" data-slide-to="2"></li>
        </ol>
         <div class="carousel-inner" role="listbox">
              <div class="item active">
                  <img width="100%" src="${context }/d2d/img/Banner1.jpg" alt="Deal2Day offers you the widest range of discounts and offers from around the web and more">
                  <div class="carousel-caption">
                      <h1>Enjoy the night life</h1>
                      <h2>Great discounts on chilling destinations</h2>
                  </div>
              </div>
              <div class="item">
                <img width="100%" src="${context }/d2d/img/Banner2.jpg" alt="Deal2Day provides you with the best deals on Restaurant and Hotels around you" >
                <div class="carousel-caption">
                      <h1>Relax your mind with SPA</h1>
                      <h2>Deal2day brings you the best deals and offers on Spa, Salon & Fitness at your nearest location</h2>
                </div>
              </div>
              <div class="item">
                  <img width="100%" src="${context }/d2d/img/Banner3.jpg" alt="Deal2Day offers you a choice of Online as well as Walk-In deals to choose from">
                  <div class="carousel-caption">
                      <h1>Dine with your love</h1>
                      <h2>Best deals on Restaurant and Cafe around you.</h2>
                  </div>
              </div>
          	</div>
          	<a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
            	<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
             	<span class="sr-only">Previous</span>
          	</a>
			<a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
            	<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
              	<span class="sr-only">Next</span>
        	</a>
    	  </div>        
	</div>
	<div class="container">	
		<div class="jumbotron " style="background:#ee6c39 ;color:#fff;">
			<h1>Unlimited Offers and deals!</h1>
			<p>Enjoy unlimited local deals, online offers and promo code.</p>
			<p><a class="btn btn-primary btn-lg" href="#offline" role="button">Start Saving</a></p>				
		</div>
	</div>