<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<div id="send-coupon-model" class="modal">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-body text-center">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close" style="z-index:999;font-size:2em;margin:-20px;">
						<span aria-hidden="true">&times;</span>
				</button>
				<h2 class="text-left"><small>Get this offer on mobile or email.</small></h2>
	  			<div class="row">
			         <div class="col-md-8">
			         	<div class="alert alert-info text-uppercase" role="alert" id="c-code"><b>HFsdsdFL</b></div>
			          	<input type="hidden" id="o_source" value="" />
			          	<input type="hidden" id="p_source" value="" /> 
			          	<div class="form-group">
			                <div class="input-group form-group-lg">
			                	<div class="input-group-addon"><i class="fa fa-tag"></i></div>
			                	<input class="form-control" id="u_target" placeholder="enter email id or mobile number...">
			                </div>
		              	</div>
		              	<button onclick="sendCoupon('${context }')" class="btn btn-primary btn-lg btn-block" id="sobtn">Send Offer</button>			      
		              	<div id="res-sc"></div>      	
			          	<h5 class="text-left"><small>Your information would not be shared.</small></h5>
			         </div>
		          <div class="col-md-4">
		          		<img width= "100%" src="${context }/d2d/img/Tag.png" class="img-circle img-responsive">
		          </div>
	        	</div>
			</div>
		</div>
	</div>
</div>
