$( document ).ready(function() {
	$('#send-coupon-model').on('show.bs.modal', function (e) {
		//e.preventDefault();
		$("#res-sc").html('');
		$('#u_target').val('');
		$("#c-code").html('');
		var button = $(e.relatedTarget);
		var modal = $(this);
		var oid = button.data('oid');
		var pid = button.data('pid');
		var code = button.data('code');
		$("#o_source").val(oid);
		$("#p_source").val(pid);
		$("#c-code").html(code);
	});
});

$(function () {
  $('[data-toggle="tooltip"]').tooltip()
})

function sendCoupon(context){
	$("#sobtn").html('Sending...')
    
	var u_target = $('#u_target').val();
	var o_source = $("#o_source").val();
	var p_source =  $("#p_source").val();
	
	
	var doSMS = isMobileNumber(u_target);
	
	if(doSMS || isEmailId(u_target)){
		var u_target_by = doSMS ? "SMS" : "Mail";
		$.getJSON( context + "/coupon/sendDeal.htm?o_source=" + o_source + "&u_target=" + u_target + "&u_target_by=" + u_target_by + "&p_source=" + p_source , function(res) {
			if(res.status == "success"){
				$("#res-sc").html('<p class="alert alert-success">Offer sent through ' + u_target_by + ' on <strong>' + u_target + '</strong></p>');		
			}else{
				$("#res-sc").html('<p class="alert alert-danger">Somethiing went wrong, Please try after sometime.</p>');		
			}	
			$("#sobtn").html('Send Coupon')
			setTimeout(function(){
				$("#res-sc").html('');
				$('#send-coupon-model').modal('toggle');
	        }, 2000);
		});
	}else{
		$("#sobtn").html('Send Coupon')
		$("#res-sc").html('<p class="alert alert-danger">Invalid mobile number or mail id.</p>');		
	}
}

function isMobileNumber(number){
	var mob = /[0-9 -()+]+$/;
    if (!mob.test(number) || number.length != 10 ) {
        return false;
    }
    return true;
}

function isEmailId(email){
	var atpos = email.indexOf("@");
    var dotpos = email.lastIndexOf(".");
    if (atpos< 1 || dotpos<atpos+2 || dotpos+2>=email.length) {
        return false;
    }
    return true;
}

function subcribeWithUs(context){
	var contact = $('#subs-contact').val();
	if(isMobileNumber(contact) || isEmailId(contact)){
		$.getJSON(context + "/coupon/subscribe.htm?contact=" + contact, function( data ) {
			$("#subs-contact").val('');
			$("#subs-result").html('<p class="alert alert-success" role="alert">Thanks for subscribe with us!!!</p> ');
			setTimeout(function(){
				$("#subs-result").html('');
	        }, 3000);
		});
		return;
	}
	$("#subs-result").html('<p class="alert alert-danger" role="alert">Enter a valid email id or mobile number...</p>');
	setTimeout(function(){
		$("#subs-result").html('');
    }, 3000);
}