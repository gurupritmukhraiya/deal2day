$(document).ready(function() {
	$( "#typeSelect" ).change(function() {
		  if($( "#typeSelect" ).val() == "other"){
			  $( "#newTypeInput" ).show();
		  }else{
			  $( "#newTypeInput" ).hide();
		  }
	});
	
	$("#mer-register-f").validate({
		rules: {
			merchantName: {required: true,minlength: 2,	maxlength:30},
			contactNo: {required: true,minlength: 10,maxlength:20,number: true},
			emailId: {required: true,email: true}
		},
		messages: {
			merchantName: "Please enter Provider Name between 2 to 30 characters",
			contactNo: "Please provide the valid contact number 10 to 20 digits",
			emailId: "Please enter a valid email address"
		}	
	});

	
	$("#uploadCSVForm").validate({
		rules: {
			affilateName: {required: true},
			file: {required: true}
		},
		messages: {
			affilateName: "enter offer summary",
			file: "enter offer summary"
		}
	});
	
	$( "#departure" ).datepicker();
	$( "#departure2" ).datepicker();
	$( "#updateOfferStartDate" ).datepicker();
	$( "#updateOfferEndDate" ).datepicker();
});

function letAddMerchant(){
	$('#mer-list-d').hide();
	$('#mer-add-d').show();
	$('#assign-mer-d').hide();
}

function canCatAdd(){
	$('#cat-list-d').show();
	$('#cat-add-d').hide();
	$('#cat-update-d').hide();
}

function letAddCat(){
	$('#cat-list-d').hide();
	$('#cat-add-d').show();
	$('#cat-update-d').hide();
}

function canMerAdd(){
	$('#assign-mer-d').show();
	$('#mer-list-d').show();
	$('#mer-add-d').hide();
	$('#mer-update-d').hide();	
}

function viewCat(id){
	$('#cat-list-d').hide();
	$('#cat-add-d').hide();
	$('#cat-update-d').show();
	
	$('#overlay').addClass("show-overlay");
	$.getJSON( "../admin/viewCategory.htm?idx=" + id, function( data ) {
		$.each(data.category, function(key, value){  
			var $ctrl = $('[name='+key+']', "#cat-update-f"); 			
			switch($ctrl.attr("type")){  
	        	case "text" :   
	        	case "hidden":  
	        		$ctrl.val(value);   
	        		break;   
	        	case "radio" : case "checkbox":   
	        		$ctrl.each(function(){
	        			if($(this).attr('value') == value) {  $(this).attr("checked",value); } });   
	        		break;  
	        	default:
	        		$ctrl.val(value);	
			}  	
	    });  
		$('#overlay').removeClass("show-overlay");
	});	
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

function updateMerchantStatus(id, status){
	$('#overlay').addClass("show-overlay");
	$.getJSON( "../admin/updateMerchantStatus.htm?idx=" + id + "&status=" + status, function( data ) {
		if(status == "A"){
			$('#merchant-status-'+id).html('<input style="font-size:10px;" type="button" class="btn btn-primary" onclick="updateMerchantStatus(' + id + ','+" 'INACTIVE'"+')" value="Inactive Merchant"/>');
		}else{
			$('#merchant-status-'+id).html('<input style="font-size:10px;" type="button" class="btn" onclick="updateMerchantStatus(' + id + ',' + " 'A'" + ')" value="Active Merchant"/>');
		}
		$('#overlay').removeClass("show-overlay");
	});	
}

function uploadImage(){
	$('#result').html('');
	$("#image-upload-form").ajaxForm({
		success:function(data) {
			$('#addImageField').val(data);
			
			$("#result").removeAttr('class');
			$("#result").addClass('bg-success');
			$('#result').html("Image uploaded successfully!!!");
			$('#uploadImageB').attr('disabled','disabled');
			$('#addOfferImageInput').val('');
		},
		dataType:"text"
	}).submit();	
}

function uploadUpdateImage(){
	$('#result-update').html('');
	$("#image-upload-form-update").ajaxForm({
		success:function(data) {
			$('#updateImageField').val(data);
			
			$("#result-update").removeAttr('class');
			$("#result-update").addClass('bg-success');
			$('#result-update').html("Image uploaded successfully!!!");
			$('#uploadImageBUpdate').attr('disabled','disabled');
			$('#updateOfferImageInput').val('');
		},
		dataType:"text"
	}).submit();	
}

$('#catImageInput').change(function () {
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
            	if(((w == 300) && (h == 220)) && s < 2048){
            		$("#result-update").removeAttr('class');
        			$("#result-update").addClass('bg-info');
        			
					$('#uploadImageBUpdate').removeAttr('disabled');
					$('#result-update').append('Width: ' + w + ', height: ' + h + ', size: ' + s + 'KB, type: ' + t + ', name: ' + n);
				}else{
					$('#result-update').html("please check width & height should be [300 * 220], size should not more than 2 MB");
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

$('#catUpdateImageInput').change(function () {
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
            	if(((w == 300) && (h == 220)) && s < 2048){
            		$("#result-update").removeAttr('class');
        			$("#result-update").addClass('bg-info');
        			
					$('#uploadImageBUpdate').removeAttr('disabled');
					$('#result-update').append('Width: ' + w + ', height: ' + h + ', size: ' + s + 'KB, type: ' + t + ', name: ' + n);
				}else{
					$('#result-update').html("please check width & height should be [300 * 220], size should not more than 2 MB");
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


function submitAddOfferForm(){
	$('#offer-add-f').submit();	
}

function submitUpdateOfferForm(){
	$('#offer-update-f').submit();	
}

function submitUpdateCategoryForm(){
	$('#cat-update-d').submit();	
}