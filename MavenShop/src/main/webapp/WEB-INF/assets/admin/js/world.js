
//jQuery(window).on("load", function(){
//
//  console.log($( "#country" ).val());
//  
//  setStates($( "#country" ).val());
//  
//});




function checkNumber(value){
	 $( "#myMsg" ).remove();
	if(!value.match(/^\d+$/)||value==""||value==null) {
		console.log(value);
		$("#pinCode").removeClass('success');
		 $("#pinCode").addClass('error');
		 
		 $("#pinCode").before(
					"<span id='myMsg' class='text-danger small'> Only Number Allowed</span>");
		 
	}else{
		 $("#pinCode").removeClass('error');
		 $("#pinCode").addClass('success');	
		 
		
	}
}


function setStates(n){
	$.ajax({url: "getStateList?ct="+n, success: function(result){	
		$('#state').empty();
		$.each(result, function(key, value) {   
			  $('#state').append($("<option></option>")
		                    .attr("value",key)
		                    .text(value)); 
		});
    }});
}




