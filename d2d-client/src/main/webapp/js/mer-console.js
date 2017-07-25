$(document).ready(function() {
	//Merchant Update
	$("#mer-update-f").validate({
		rules: {
			contactNo: {required: true,minlength: 10,maxlength:20,number: true}
		},
		messages: {
			contactNo: "enter 10 to 20 digit contact number i.e. 9890XXXX12",
		}	
	});
	
	$('#updateMerchantImageInput').change(function () {
		$('#result-update').html('');
		$("#result-update").removeAttr('class');
		$("#result-update").addClass('bg-danger');
		$('#uploadImageBUpdate').attr('disabled','disabled');
		
		var file = this.files[0];
		var reader = new FileReader();
	    var image  = new Image();		    
	    reader.readAsDataURL(file);  
	    reader.onload = function(_file) {
	        image.src    = _file.target.result; 
	        image.onload = function() {
	            var w = this.width,
	                h = this.height,
	                t = file.type,              
	                n = file.name,
	                s = ~~(file.size/1024);			            
	            var ext = n.split('.').pop().toLowerCase();
	            if($.inArray(ext, ['png','jpg','jpeg']) != -1) {
	            	if(((w == 540) && (h == 270)) && s < 2048){
	            		$("#result-update").removeAttr('class');
	        			$("#result-update").addClass('bg-info');
	        			
						$('#uploadImageBUpdate').removeAttr('disabled');
						$('#result-update').append('Width: ' + w + ', height: ' + h + ', size: ' + s + 'KB, type: ' + t + ', name: ' + n);
					}else{
						$('#result-update').html("please check width & height should be [540 * 270], size should not more than 2 MB");
					}    
	            }else{
	            	$('#result-update').html("not valid extention, only jpg, jpeg, and png allowed");
	            }			            
	        };
	        image.onerror= function() {	        
				$('#result-update').html("invalid file type");
	        };      
	    };
	});
	
	$("#mer-change-pass-f").validate({
		rules: {
			oldPassword: {required: true},
			password: {required: true,minlength: 5},
			cpassword: {required: true,minlength: 5,equalTo: "#password"}
		},
		messages: {
			oldPassword: "Please enter old password",	
			password: "Please provide password at least 5 character long",
			cpassword: "Confirm password must match password"
		}	
	});
	
	//Add Location
	$.validator.addMethod("valueNotEquals", function (value, element, arg) {
	    return arg != value;
	}, "Message to User");
	
	$("#loc-add-f").validate({
		rules: {
			city: {required:true, valueNotEquals: "-1" },
			area: {required: true},
			landmark: {required: true},
			pincode: {required: true, number:true, maxlength:7, minlength:4},
			contactNo: {required: true,minlength: 10,maxlength:20,number: true}
		},
		messages: {
			city: "please select city",
			area: "pleaase enter area",
			landmark: "please enter a landmark/address",
			pincode: "please enter a valid pincode",
			contactNo: "please enter a valid contact no 10 to 20 digit"
		}
	});
	
	//Add Offer
	$("#offer-add-f").validate({
		rules: {
			offerSummary: {required: true},
			categories: {required: true},
			endDate: {required: true},
			URL:{url:true},
			minBillAmt:{number: true, maxlength:5,minlength:1},
			discount:{number: true, maxlength:2, minlength:1},
			couponPrice:{number: true, maxlength:3, minlength:1},
			promoCode:{required: true}
		},
		messages: {
			offerSummary: "enter offer summary",
			categories: "select category",
			endDate: "select end date",
			URL: "enter correct URL",
			minBillAmt : "enter number only/upto 6 digit.",
		 	discount : "enter number only/upto 3 digit.",
	    	couponPrice : "enter number only/upto 3 digit.",
	    	promoCode : "enter code like D2DINXXXX"	 	 
		}
	});
	
	//Update Offer
	$("#offer-update-f").validate({
		rules: {
			offerSummary: {required: true},
			categories: {required: true},
			endDate: {required: true},
			URL:{url:true},
			minBillAmt:{number: true, maxlength:5, minlength:1},
			discount:{number: true, maxlength:2, minlength:1},
			couponPrice:{number: true, maxlength:3, minlength:1}
			
		},
		messages: {
			offerSummary: "enter offer summary",
			categories: "select category",
			endDate: "select end date",
			URL: "enter correct URL",
			minBillAmt : "enter number only/upto 6 digit.",
		 	discount : "enter number only/upto 3 digit.",
	    	couponPrice : "enter number only/upto 3 digit."
		}
	});
	
	$('#addOfferImageInput').change(function () {
		$('#result').html('');
		$("#result").removeAttr('class');
		$("#result").addClass('bg-danger');
		$('#uploadImageB').attr('disabled','disabled');
		
		var file = this.files[0];
		var reader = new FileReader();
	    var image  = new Image();		    
	    reader.readAsDataURL(file);  
	    reader.onload = function(_file) {
	        image.src    = _file.target.result; 
	        image.onload = function() {
	            var w = this.width,
	                h = this.height,
	                t = file.type,              
	                n = file.name,
	                s = ~~(file.size/1024);			            
	            var ext = n.split('.').pop().toLowerCase();
	            if($.inArray(ext, ['png','jpg','jpeg']) != -1) {
	            	if(((w == 540) && (h == 270)) && s < 2048){
	            		$("#result").removeAttr('class');
	        			$("#result").addClass('bg-info');
	        			
						$('#uploadImageB').removeAttr('disabled');
						$('#result').append('Width: ' + w + ', height: ' + h + ', size: ' + s + 'KB, type: ' + t + ', name: ' + n);
					}else{
						$('#result').html("please check width & height should be [540 * 270], size should not more than 2 MB");
					}    
	            }else{
	            	$('#result').html("not valid extention, only jpg, jpeg, and png allowed");
	            }			            
	        };
	        image.onerror= function() {	        
				$('#result').html("invalid file type");
	        };      
	    };
	});
	
	$( "#departure" ).datepicker();
	$( "#departure2" ).datepicker();
	$( "#updateOfferStartDate" ).datepicker();
	$( "#updateOfferEndDate" ).datepicker();
});

function letMerUpdate(){
	$('#mer-update-d').show();
	$('#mer-profile-d').hide();
	$('#mer-change-pass-d').hide();
}

function letChangePassword(){
	$('#mer-update-d').hide();
	$('#mer-profile-d').hide();
	$('#mer-change-pass-d').show();
}

function canChangePass(){
	$('#mer-update-d').hide();
	$('#mer-profile-d').show();
	$('#mer-change-pass-d').hide();
}

function canMerUpdate(){
	$('#mer-update-d').hide();
	$('#mer-profile-d').show();
	$('#mer-change-pass-d').hide();
}

function letAddLoc(){
	$('#loc-add-d').show();
	$('#loc-list-d').hide();
}

function canAddLoc(){
	$('#loc-list-d').show();
	$('#loc-add-d').hide();
}

function letAddOffer(){
	$('#offer-add-d').show();
	$('#offer-list-d').hide();
	$('#offer-update-d').hide();
}

function canAddOffer(){
	$('#offer-list-d').show();
	$('#offer-add-d').hide();
	$('#offer-update-d').hide();
	
}

function showNotification(status, msg){
    var $notification = $("#show-notification");
    if(status == "success"){
    	$notification.css("background-color", "green");
    }
    if(status == "error"){
    	$notification.css("background-color", "red");
    }
    if(status == "warning"){
    	$notification.css("background-color", "grey");
    }
    
    $notification.html(msg);
    $notification.show();
    setTimeout(function() {
    	$notification.hide();
    }, 3000);
}

function viewOffer(id){
	$('#offer-list-d').hide();
	$('#offer-add-d').hide();
	$('#offer-update-d').show();
	document.getElementById("offer-update-f").reset();
	$('#overlay').addClass("show-overlay");
	$.getJSON( "../mer/view-offer.htm?idx=" + id, function( data ) {
		$.each(data.offer, function(key, value){  
			var flag = true;
			var $ctrl = $('[name='+key+']', "#offer-update-f");  
			if(key == "coverImage"){
				$("#offer-img-u").attr("src", value);
				flag = false;
			}
			if(key == "startDate"){
				value = new Date(value);
			    value = (value.getMonth() + 1) + "/" + value.getDate() + "/" + value.getFullYear();
			}
			if(key == "endDate"){
				value = new Date(value);
			    value = (value.getMonth() + 1) + "/" + value.getDate() + "/" + value.getFullYear();
			}
			if(key == "description"){
				value="";
    			$.each(data.offer.description, function(keyN, valueN){
    				value = value + valueN + ".";	        				
    			});
    		}
			if(key == "termsAndConditions"){
				value="";
    			$.each(data.offer.termsAndConditions, function(keyN, valueN){
    				value = value + valueN + ".";	        				
    			});
    		}
			if(flag){
				switch($ctrl.attr("type")){  
		        	case "text" :   
		        	case "hidden":  
		        		$ctrl.val(value);   
		        		break;   
		        	case "radio" : case "checkbox":   
		        		$ctrl.each(function(){
		        			if($(this).attr('value') == value) {  $(this).attr("checked",true); } });   
		        		break;  
		        	default:
		        		$ctrl.val(value);	
				}  	
    		}
	    });  
		$('#overlay').removeClass("show-overlay");
	});	
}

function submitUpdateOfferForm(){
	$('#offer-update-f').submit();	
}