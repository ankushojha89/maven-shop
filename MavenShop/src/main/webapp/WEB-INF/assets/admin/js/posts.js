function getParameterByName(name) {
	 return decodeURIComponent((new RegExp('[?|&]' + name + '=' + '([^&;]+?)(&|#|;|$)').exec(location.search)||[,""])[1].replace(/\+/g, '%20'))||null;
	}

function setPostId(id){
	$('#post_id').val(id);
}
$(function() {
	
	
	var oId=getParameterByName('oId');
	var oBy=getParameterByName('oBy');
	$( ".mySort i" ).removeClass("down");	
	 $( ".mySort i" ).removeClass("arrow");	
	 $( ".mySort i" ).removeClass("up");
	if(oId!=null&&oBy!=null){	
		 $( ".mySort i:eq("+oId+" )" ).addClass( "arrow");
		 
		 if(oBy=='ASC'){
			
			 $( ".mySort i:eq("+oId+" )" ).addClass( "down");
			 $( ".mySort i:eq("+oId+" )" ).attr("data-myOrder",'DESC')
		 }else{
			
			 $( ".mySort i:eq("+oId+" )" ).addClass( "up");
			 $( ".mySort i:eq("+oId+" )" ).attr("data-myOrder",'ASC')	; 
		 }
		 
		
	}else{
		
		 $( ".mySort i:eq(0 )" ).addClass( "arrow down");
		 
		 
	}
	

	
	
	 $(".mySort").on("click", function(){
		 
	     var order =$(this).find("i").attr("data-myOrder"); 
	     var columnNo=$(this).find("i").attr("data-columnNo");	 
	     
	     var page=getParameterByName('page');
	     
	     if(page==null)
	    	 page=0;
	 
	     var url = "http://localhost:9080/MavenShop/admin/posts?page="+page+"&oId="+columnNo+"&oBy="+order;
	     
	     $(location).attr('href',url);
	 
	     
	 });
});