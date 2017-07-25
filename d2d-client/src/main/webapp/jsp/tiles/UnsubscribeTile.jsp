<div class="container">
	<div class="main">
		<div class="contact">				
			<div class="contact_info">										
				<div class="contact-form" style="float: left; width: 49%;">
					<h2>UnSubscribe Newsletter!</h2>						
					<%if(request.getAttribute("success") != null){ %>
						<div class = "alert alert-success"><%=request.getAttribute("success") %></div>
					<% }%>					
					<form action="../d2d/unSubscribe.htm" method="post" id="my-deal-form">			
						<div>
							<span><label>Email id Or Mobile Number</label></span>
							<span><input type="text" id="contact" name="contact"/></span>
						</div>				
						<div>
							<input type="submit" id="register-submit" value="Click">
						</div>							    	   		
					</form>
				</div>	
				<div style="float: right; width: 49%;">					
					<h2>What Is Unsubscribe Newsletter!!</h2>															
					<!-- <p>Suppose you want to throw a birthday bash for your friends and You are 15 odd people. You walk into a restaurant you treat your Friends but you don't get a discount. But you think you deserve a Discount? We agree! Simple theory- When you buy a product in Bulk you get a discount. But here is the problem, restaurants do Not have customised deals for situations like these. That's where We come in. Only deal2day.in offers you best customised deals!							</p>	<br/>
					<h2>Here's how it works</h2>
					
					
						<ul>
	<li>Post in your requirements for example a birthday treat and fill in</li>
	<li>The details like number of people and the budget etc.</li>
	<li>Our clients- Restaurants, bars, fast-food joints etc.</li>
	<li>Check out your requirements and offer you the discount they are willing to offer.</li>
	<li>You select the best deal and reap the benefits</li>
                                                 </ul> -->
					
				</div>
				<div class="clearfix"></div>	
			</div>
		</div>
		<div class="clearfix"></div>		
	</div>
</div>