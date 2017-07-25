<div class="row container-fluid">
	<div id="map" class="col-md-8"></div>	
	
	<div id="offer-ls" class="col-md-4 pull-right">
		<div class="list-group">
			<div class="row list-group-item active">
				<div class="col-md-4">
					<div><img class="img-responsive" alt="10% off on Rs. 1000 &amp; Above" src="http://img.deal2day.in/mer_offer/25/61/cover.jpg"></div>
				</div>
				<div class="col-md-8">
					<h4 class="list-group-item-heading">7 seas</h4>
					<p class="list-group-item-text">10% off on Rs. 1000 & Above.</p>
					<p>
						<a class="btn btn-danger" href="/offer/viewOfferPage.htm?o_d=61&amp;p_d=25">Show It!</a>
						<button data-target="#send-coupon-model" onclick="sendCoupon()" data-id="61" data-toggle="modal" class="btn btn-warning" type="button">Grap It!</button>						
					</p>
				</div>
			</div>			
			<div class="row list-group-item">
				<div class="col-md-4">
					<div><img class="img-responsive" alt="10% off on Rs. 1000 &amp; Above" src="http://img.deal2day.in/mer_offer/25/61/cover.jpg"></div>
				</div>
				<div class="col-md-8">
					<h4 class="list-group-item-heading">7 seas</h4>
					<p class="list-group-item-text">10% off on Rs. 1000 & Above.</p>
					<p>
						<a class="btn btn-danger" href="/offer/viewOfferPage.htm?o_d=61&amp;p_d=25">Show It!</a>
						<button data-target="#send-coupon-model" onclick="sendCoupon()" data-id="61" data-toggle="modal" class="btn btn-warning" type="button">Grap It!</button>								
					</p>
				</div>
			</div>	
		</div>	
	</div>
</div>
	<div class="modal" id="send-coupon-model">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">Get Coupon</h4>
				</div>
				<div class="modal-body text-center">
						<i class="icon-hand-down"></i>
					<h2>
						<small>Send coupon on mobile or email.</small>
					</h2>
					<div class="input-group">
						<span id="basic-addon1" class="input-group-addon"><i class="fa fa-ticket"></i></span> 
						<input type="hidden" id="o_source" value="" /> 
						<input type="text" aria-describedby="basic-addon1" placeholder="enter name" id="u_target" class="form-control">
						<span id="basic-addon1" class="input-group-addon"><i class="fa fa-ticket"></i></span>
						<input type="text" aria-describedby="basic-addon1" placeholder="enter email id or mobile number..." id="u_target" class="form-control">
						<div class="input-group-btn">
							<button onclick="sendCoupon()" class="btn btn-primary">Get Offer</button>
						</div>
					</div>
					<div id="res-sc"></div>
				</div>
			</div>
		</div>
	</div> 		

<script>
	
	function initMap() {		
		var bounds = new google.maps.LatLngBounds();
		var locations = ["Shivaji Nagar, Pune", "MG Road, Pune", "Baner, Pune"];

		var map = new google.maps.Map(document.getElementById('map'), {
			zoom: 12,
			center: pune,
			mapTypeControl: false,
			streetViewControl: false,
			rotateControl: false,
			disableDefaultUI: true
		});
		var geocoder = new google.maps.Geocoder();
		var punewindow = new google.maps.InfoWindow({
				content: "Pune"
		});
		var pune = geocodeAddress(geocoder, map, "Pune", punewindow, bounds); 
		$.each(locations, function( index, value ) {
			var infowindow = new google.maps.InfoWindow({
				content: value
			});
			geocodeAddress(geocoder, map, value, infowindow, bounds); 
		});  	  
	}

	function geocodeAddress(geocoder, resultsMap, address, infowindow, bounds) {
		geocoder.geocode({'address': address}, function(results, status) {
		if (status === google.maps.GeocoderStatus.OK) {
			resultsMap.setCenter(results[0].geometry.location);
			var marker = new google.maps.Marker({
				map: resultsMap,
				position: results[0].geometry.location,
				title: 'Twitter'
			});
			marker.addListener('mouseover', function() {
				infowindow.open(resultsMap, marker);
			});
			marker.addListener('mouseout', function() {
				infowindow.close();
			});
			bounds.extend(marker.getPosition());
			resultsMap.fitBounds(bounds);
		} else {
			alert('Geocode was not successful for the following reason: ' + status);
		}
	  });
	}
</script>
<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBl2S6GxtDlYHCNJalZ255v3orh8xdgQZc&signed_in=false&callback=initMap&sensor=true&v=3"></script>
  </body>
</html>

