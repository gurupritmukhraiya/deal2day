<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="context" value="${pageContext.request.contextPath}" />

<script>
$( document ).ready(function() {
	$('#myModal').on('show.bs.modal', function (e) {
		//e.preventDefault();
		var button = $(e.relatedTarget); // Button that triggered the modal
		var modal = $(this);
		var ids = button.data('id');		
		
		$.getJSON( "${context}/offer/viewOffer.htm?" + ids, function(offer) {
			if(offer.status == "A"){
				$("#desc-id").html("");
				//modal.find('.modal-title').text(data.offer.merchantName);
				$("#myModalLabel").html(offer.merchantName);
				$("#summary").html(offer.offerSummary);
				$("#discount").html(offer.discount);
				$("#min-bill").html(offer.minBillAmt);
				
				$.each(offer.description, function( index, value ) {
					 $("#desc-id").append("<li>" + value + "</li>");
				});
				//$("#myModalLabel").html(offer.merchantName);
				/* modal.find('.modal-body input').val(recipient)
	        	$('#overlay').removeClass("show-overlay");
	        	$('#mer-contact-p').html(form.contactNo.value);
				showNotification(data.status, data.message);
				canMerUpdate(); */
				modal.show();
			}else{
				alret("Some thing went wrong!!!");
			}			
		});		
	});
	
	$('#myTabs a').click(function (e) {
	  e.preventDefault()
	  $(this).tab('show')
	});
});
</script>
	<div class="modal" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header" style="background:#428bca; color:#fff">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title text-uppercase" id="myModalLabel"></h4>
			</div>
			<div class="modal-body" id="fill-name">				
				<div class="row">
					<div class="col-md-6">
						<img src="http://image.deal2day.in/offOffer/5/12014.jpg" class="img-responsive" style="width:100%;height:200px;"/>
					</div>
					<div class="col-md-6">
						<h3><small id="summary"></small></h3>

						<div class="row text-center">
							<div class="col-md-4">
								<h4><small>ON MIN BILL</small></h4><p id="min-bill"></p>
							</div>
							<div class="col-md-4">
								<h4><small>YOU SAVE</small></h4><p id="discount">20 %</p>
							</div>
							<div class="col-md-4">
								<h4><small>COUPON PRICE</small></h4>FREE
							</div>
						</div>						
					</div>					
				</div>
<div class="row"></div>
				<div class="row">
					<div class="col-md-12">
						<ul role="tablist" class="nav nav-pills" id="myTabs">
					      	<li class="active" role="presentation"><a aria-expanded="true" aria-controls="home" data-toggle="tab" role="tab" id="desc-tab" href="#desc">Description</a></li>
					      	<li role="presentation"><a aria-controls="profile" data-toggle="tab" id="term-tab" role="tab" href="#term">T&C</a></li>
					      	<li role="presentation"><a aria-controls="profile" data-toggle="tab" id="loc-tab" role="tab" href="#loc">Location</a></li>
					      	<!-- <li class="dropdown" role="presentation">
					        	<a aria-controls="myTabDrop1-contents" data-toggle="dropdown" class="dropdown-toggle" id="myTabDrop1" href="#">Dropdown <span class="caret"></span></a>
					        	<ul id="myTabDrop1-contents" aria-labelledby="myTabDrop1" class="dropdown-menu">
					          		<li><a aria-controls="dropdown1" data-toggle="tab" id="dropdown1-tab" role="tab" href="#dropdown1">@fat</a></li>
					          		<li><a aria-controls="dropdown2" data-toggle="tab" id="dropdown2-tab" role="tab" href="#dropdown2">@mdo</a></li>
					        	</ul>
					      	</li> -->
					    </ul>
					    <div class="tab-content" id="myTabContent">
					      <div aria-labelledby="desc-tab" id="desc" class="tab-pane fade in active" role="tabpanel">
					        <ol id="desc-id">
					        	
					        </ol>
					      </div>
					      <div aria-labelledby="term-tab" id="term" class="tab-pane fade" role="tabpanel">
					        <p>Food truck fixie locavore, accusamus mcsweeney's marfa nulla single-origin coffee squid. Exercitation +1 labore velit, blog sartorial PBR leggings next level wes anderson artisan four loko farm-to-table craft beer twee. Qui photo booth letterpress, commodo enim craft beer mlkshk aliquip jean shorts ullamco ad vinyl cillum PBR. Homo nostrud organic, assumenda labore aesthetic magna delectus mollit. Keytar helvetica VHS salvia yr, vero magna velit sapiente labore stumptown. Vegan fanny pack odio cillum wes anderson 8-bit, sustainable jean shorts beard ut DIY ethical culpa terry richardson biodiesel. Art party scenester stumptown, tumblr butcher vero sint qui sapiente accusamus tattooed echo park.</p>
					      </div>
					      <div aria-labelledby="loc-tab" id="loc" class="tab-pane fade" role="tabpanel">
					        <p>Food truck fixie locavore, accusamus mcsweeney's marfa nulla single-origin coffee squid. Exercitation +1 labore velit, blog sartorial PBR leggings next level wes anderson artisan four loko farm-to-table craft beer twee. Qui photo booth letterpress, commodo enim craft beer mlkshk aliquip jean shorts ullamco ad vinyl cillum PBR. Homo nostrud organic, assumenda labore aesthetic magna delectus mollit. Keytar helvetica VHS salvia yr, vero magna velit sapiente labore stumptown. Vegan fanny pack odio cillum wes anderson 8-bit, sustainable jean shorts beard ut DIY ethical culpa terry richardson biodiesel. Art party scenester stumptown, tumblr butcher vero sint qui sapiente accusamus tattooed echo park.</p>
					      </div>
					      <!-- <div aria-labelledby="dropdown1-tab" id="dropdown1" class="tab-pane fade" role="tabpanel">
					        <p>Etsy mixtape wayfarers, ethical wes anderson tofu before they sold out mcsweeney's organic lomo retro fanny pack lo-fi farm-to-table readymade. Messenger bag gentrify pitchfork tattooed craft beer, iphone skateboard locavore carles etsy salvia banksy hoodie helvetica. DIY synth PBR banksy irony. Leggings gentrify squid 8-bit cred pitchfork. Williamsburg banh mi whatever gluten-free, carles pitchfork biodiesel fixie etsy retro mlkshk vice blog. Scenester cred you probably haven't heard of them, vinyl craft beer blog stumptown. Pitchfork sustainable tofu synth chambray yr.</p>
					      </div>
					      <div aria-labelledby="dropdown2-tab" id="dropdown2" class="tab-pane fade" role="tabpanel">
					        <p>Trust fund seitan letterpress, keytar raw denim keffiyeh etsy art party before they sold out master cleanse gluten-free squid scenester freegan cosby sweater. Fanny pack portland seitan DIY, art party locavore wolf cliche high life echo park Austin. Cred vinyl keffiyeh DIY salvia PBR, banh mi before they sold out farm-to-table VHS viral locavore cosby sweater. Lomo wolf viral, mustache readymade thundercats keffiyeh craft beer marfa ethical. Wolf salvia freegan, sartorial keffiyeh echo park vegan.</p>
					      </div> -->
					    </div>
					    <!-- 
						<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
						  <div class="panel panel-default">
							<div class="panel-heading" role="tab" id="headingOne">
							  <h4 class="panel-title">
								<a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
								  Locations
								</a>
							  </h4>
							</div>
							<div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
							  <div class="panel-body">
								<div class="row">
									<address class="col-md-4">
									  <strong>Twitter, Inc.</strong><br>
									  795 Folsom Ave, Suite 600<br>
									  San Francisco, CA 94107<br>
									  <abbr title="Phone">P:</abbr><p> (123) 456-7890</p>
									</address>
								</div>
							  </div>
							</div>
						  </div>
						  <div class="panel panel-default">
							<div class="panel-heading" role="tab" id="headingTwo">
							  <h4 class="panel-title">
								<a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
								  Deal Description
								</a>
							  </h4>
							</div>
							<div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
							  <div class="panel-body">
								<ol>
								  <li>Coupon has to be shown before bill Generation</li>
								  <li>Coupon has to be shown before bill Generation</li>
								  <li>Coupon has to be shown before bill Generation</li>
								  <li>Coupon has to be shown before bill Generation</li>
								  <li>Coupon has to be shown before bill Generation</li>
								</ol>
							  </div>
							</div>
						  </div>
						  <div class="panel panel-default">
							<div class="panel-heading" role="tab" id="headingThree">
							  <h4 class="panel-title">
								<a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
								  Terms
								</a>
							  </h4>
							</div>
							<div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
							  <div class="panel-body">
								<ol>
								  <li>Coupon has to be shown before bill Generation</li>
								  <li>Coupon has to be shown before bill Generation</li>
								  <li>Coupon has to be shown before bill Generation</li>
								  <li>Coupon has to be shown before bill Generation</li>
								  <li>Coupon has to be shown before bill Generation</li>
								</ol>		
							  </div>
							</div>
						  </div>
						</div> -->						          
					</div>	
				</div>
			</div>
		</div>
	  </div>
	</div>
	