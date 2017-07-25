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
			
			</div>	
				</div>
			</div>
		</div>
	  </div>
	</div>
	