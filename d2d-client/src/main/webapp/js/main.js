$(document).ready(function(){        
	$("#overlay").click(function () {
		$('#overlay').removeClass("show-overlay");
	});
    
	$(".slide")
	.mouseenter(function () {
		$(this).find(".bx-caption").show();
	})
	.mouseleave(function () {
		$(this).find(".bx-caption").hide();
	});
	
	//Post My Deal
	$("#my-deal-form").validate({
		rules: {
			fullName: {required: true, minlength: 3, maxlength:24},
			emailId: {required: true, email: true},
			contactNo: {required: true, minlength: 10, maxlength:10, number: true},
			description: {required: true, rangelength: [20, 250]}
		},
		messages: {
			fullName: "Please enter your name of 3 to 24 characters",
			emailId: "Please enter a valid email id",
			contactNo: "Please provide a valid 10 digit mobile no",
			description: "Please provide your description within 20 to 250 words"
		}
	});
	
	//Validator for comma separated email ids
	jQuery.validator.addMethod("commaSeparatedEmailIds", function(value, element) {
		return this.optional(element) || commaSeparatedEmailIds(value);
	}, "Please provide comma separated & valid Email Ids");
	
	//Invite Friend
	$("#invite-friend-form").validate({
		rules: {
			from: {required: true, email: true},
			fullName: {required: true, minlength: 3, maxlength:24},
			emaiIds: {required: true, commaSeparatedEmailIds: true}
		},
		messages: {
			from: "Please enter a valid email id",
			fullName: "Please enter your name of 3 to 24 characters",
			emaiIds: "Please provide comma separated & valid Email Ids"
		}
	});
	
	//Contact Us
	$("#contact-us").validate({
		rules: {
			personType: {required: true},
			fullName: {required: true, minlength: 3, maxlength:24},
			emailId: {required: true, email: true},
			contactNo: {required: true, minlength: 10, maxlength:10, number: true},
			comment: {required: true, rangelength: [20, 250]}
		},
		messages: {
			personType: "Please select person type to understand your need",
			fullName: "Please enter your name of 3 to 24 characters",
			emailId: "Please enter a valid email id",
			contactNo: "Please provide a valid 10 digit mobile no",
			comment: "Please provide your comments within 20 to 250 words"
		}
	});
	
	//Advertise with Us
	$("#advertise-with-us-form").validate({
		rules: {
			companyName: {required: true},
			businessTypes: {required: true},
			contactPerson: {required: true},
			emailId: {required: true, email: true},
			contactNo: {required: true, minlength: 10, maxlength:10, number: true},
			comment: {required: true, rangelength: [20, 250]}
		},
		messages: {
			companyName: "Please provide company name",
			businessTypes: "Please select at least one business type to understand your need",
			contactPerson: "Please provide contact person name",
			emailId: "Please enter a valid email id",
			contactNo: "Please provide a valid 10 digit mobile no",
			comment: "Please provide your comments within 20 to 250 words"
		}
	});
	
	$( ".abcde" )
	.mouseover(function() {
		$(this).find('.thumb-p-n').hide();
		$(this).find('.price').hide();
		$(this).find('.quick-offer-summary').show();
	})
	.mouseout(function() {
		$(this).find('.quick-offer-summary').hide();
		$(this).find('.thumb-p-n').show();
		$(this).find('.price').show();
	});
});

function sendCoupon(parameter, offerId){
	var mobNo = $("#mob-no-" + offerId).val();
	if(mobNo == "" || isNaN(mobNo) || mobNo.length != 10){
        $('#mob-no-' + id).css({"color": "red"});
        alert("Enter valid 10 digit mobile no - 9890xxxxxx");
    }else{
       $('#sent-coupon').html('<b style="color:#00405D;">Thanks You! your coupon has been sent.<b>');
       //$.getJSON( "../coupon/sendCoupon.htm?mobileNo=" + mobNo + "&" + parameter, function( data ) {			
	
       //});
    }
}

function commaSeparatedEmailIds(){
    var x = document.forms["inviteFriendForm"]["emaiIds"].value;
    if (x != null || x != "") {
	    var res = x.split(",");
	    var i = 0;
	    for(i = 0; i < res.length; i++)
	        if(!validateEmail(res[i])){
	        	$("#error").css( "display", "block");
	        	$("#error").html("Invalid email ids!!!");
	        	return false;
	        }
	    return true;
    }
    $("#error").css( "display", "block");
	$("#error").html("Email ids required!!!");
    return false;  
}

function validateEmail(email){
	var atpos = email.indexOf("@");
    var dotpos = email.lastIndexOf(".");
    if (atpos< 1 || dotpos<atpos+2 || dotpos+2>=email.length) {
        return false;
    }
    return true;
}

function subscribe(contextPath){
	var contact = $('#subContact').val();
	$.getJSON( contextPath + "/coupon/subscribe.htm?contact=" + contact, function( data ) {			
		alert("Thank You for your time and subscribe with us!!!");
	});
}