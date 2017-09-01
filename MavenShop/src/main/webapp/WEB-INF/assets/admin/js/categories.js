$(function() {

	getCategoriesList();
	
	 $(".mySort").on("click", function(){
		 
		 $( ".mySort i" ).removeClass("down");	
		 $( ".mySort i" ).removeClass("arrow");	
		 $( ".mySort i" ).removeClass("up");	
		 console.log("adasdasdasdasdasdasd");
		 
	     var order =$(this).attr("data-myOrder"); 
	     var columnNo=$(this).attr("data-columnNo");
	     
	     if(order=='ASC'){
	    	 $(this).attr("data-myOrder",'DESC')
	    	 $(this).find('i').addClass( "arrow down" );
	     }    	 
	    	 else{
	    		 $(this).attr("data-myOrder",'ASC')	; 
	    		 $(this).find('i').addClass( "arrow up" );
	    	 }
	    		 
	     getCategoriesList(columnNo,order);
	    
	 });
});





function getParameterByName(name) {
	 return decodeURIComponent((new RegExp('[?|&]' + name + '=' + '([^&;]+?)(&|#|;|$)').exec(location.search)||[,""])[1].replace(/\+/g, '%20'))||null;
	}


function mySearchFunction(){
	var sKey = document.getElementById("searchInput").value;

	getCategoriesList(0,'ASC',sKey);
	console.log(sKey);
}


function getCategoriesList(oId,oBy,sKey) {
	
	
	
	if (typeof sKey === "undefined") {
		sKey=getParameterByName('sKey');
		sKey=null||sKey;
	}
	if(sKey === null){
		sKey='';
	}
	if (typeof oId === "undefined") { 
		oId=getParameterByName('oId'); 
	  }
	if(oId === null){
		oId =0;
	}
	
	if (typeof oBy === "undefined") { 
		oBy=getParameterByName('oBy');  		
	  }
	if( oBy === null){
		 oBy ='ASC';
	}

	
	$('#categoryTable tbody').empty();
	$('#my-pagination ul.pagination').empty();
		
    var getPage=getParameterByName('page');
    if(getPage==null)
    	getPage=1;
    
	$.getJSON(
					'getCategoriesList?page='+getPage+'&oId='+oId+'&oBy='+oBy+'&sKey='+sKey,
					function(data) {
						
						$('#categoryTable tbody').empty();
						$('#my-pagination ul.pagination').empty();
						$
								.each(
										data.catList,
										function(i, f) {
											var statusValue = "Not Avaliable";
											if (f.cat_status == 1) {
												statusValue = "Avaliable";
											}

											var tblRow = "<tr>" + "<td>"
													+ f.cat_id
													+ "</td><td>"
													+ f.cat_name
													+ "</td><td>"
													+ f.cat_desc
													+ "</td><td>"
													+ "<span class='small label label-success'>"
													+ statusValue
													+ "</span></td><td>"													
													+"<button type='button' class='btn btn-success btn-lg' onclick='getCategoryData("+f.cat_id+")' data-toggle='modal' data-target='#editCategoryModal'><i class='fa fa-edit'></i></button>&emsp;"
													+"<button type='button' class='btn btn-danger btn-lg' onclick='setCategoryId("+f.cat_id+")' data-toggle='modal' data-target='#deleteCategoryModal'><i class='fa fa-trash'></i></button>"
													
													
													+ "</td>"
													+ "</tr>"
											$(tblRow).appendTo(
													"#categoryTable tbody");
										});

						var maxPage = data.maxPages;
						var currentPage = data.currentPage;
						var oBy = data.oBy;
						var oId = data.oId;
					 var sKey=data.sKey;
						if (currentPage > 1) {

							var paginationRow = "<li><a href='/MavenShop/admin/categories?page="
									+  (currentPage-1)+"&oId="+oId+"&oBy="+oBy+'&sKey='+sKey
									+ "' class='pn prev'>&laquo;	Prev</a></li>";
							$(paginationRow).appendTo(
									"#my-pagination ul.pagination");
						}
					
						for (var i = 1; i <= maxPage; i++) {

							var paginationRow;

							if (currentPage == i) {
								paginationRow = " <li ><a class='active' href='javascript:void(0)'>"
										+i + "</a></li>";
							} else {
								paginationRow = " <li><a href='/MavenShop/admin/categories?page="
										+ i +"&oId="+oId+"&oBy="+oBy+'&sKey='+sKey+ "'>" + i + "</a></li>";

							}

							$(paginationRow).appendTo(
									"#my-pagination ul.pagination");
						}

						if (currentPage <maxPage) {

							var paginationRow = "<li><a href='/MavenShop/admin/categories?page="
									+ (currentPage+1)+"&oId="+oId+"&oBy="+oBy+'&sKey='+sKey
									+ "' class='pn prev'>Next &raquo;</a></li>";
							$(paginationRow).appendTo(
									"#my-pagination ul.pagination");
						}
					});
}

function addCategory() {

	var cat_name = $('#cat_name').val();
	var cat_status = $('#cat_status').val();
	var cat_desc = $('#cat_desc').val();

	$('#messages').empty();

	
	$
			.ajax({
				type : "POST",
				url : "./addcategory",
				data : $("#category").serialize(),
				success : function(data) {

					if (data.status == 1) {
						$('#messages')
								.append(
										"<div id='myMsg' class='alert alert-dismissible alert-success'>"
												+ "<button type='button' class='close' data-dismiss='alert'>&times;</button>"
												+ data.message + "</div>");

					} else {
						$('#messages')
								.append(
										"<div id='myMsg'  class='alert alert-dismissible alert-danger'>"
												+ "<button type='button' class='close' data-dismiss='alert'>&times;</button>"
												+ data.message + "</div>");

					}
					getCategoriesList();
					setTimeout(function() {
						$('#myMsg').fadeOut('slow');
					}, 10000); // <-- time in milliseconds

					$('#addCategoryModal').modal('toggle');

				

				}
			});

	return false;
}

$('#addCategoryModal').on('hidden.bs.modal', function() {
	$(this).find('form').trigger('reset');
})


function editCategory() {
	
	$
	.ajax({
		type : "POST",
		url : "./editcategory",
		data : $("#editCategory").serialize(),
		success : function(data) {

			$('#messages').empty();
			if (data.status == 1) {
				$('#messages')
						.append(
								"<div id='myMsg' class='alert alert-dismissible alert-success'>"
										+ "<button type='button' class='close' data-dismiss='alert'>&times;</button>"
										+ data.message + "</div>");

			} else {
				$('#messages')
						.append(
								"<div id='myMsg'  class='alert alert-dismissible alert-danger'>"
										+ "<button type='button' class='close' data-dismiss='alert'>&times;</button>"
										+ data.message + "</div>");

			}
			getCategoriesList();
			setTimeout(function() {
				$('#myMsg').fadeOut('slow');
			}, 10000); // <-- time in milliseconds

			$('#editCategoryModal').modal('toggle');

			

		}
	});

	
	
	return false;
}



function deleteCategory() {

	$
	.ajax({
		type : "POST",
		url : "./deletecategory",
		data : $("#deleteCategory").serialize(),
		success : function(data) {

			$('#messages').empty();
			if (data.status == 1) {
				$('#messages')
						.append(
								"<div id='myMsg' class='alert alert-dismissible alert-success'>"
										+ "<button type='button' class='close' data-dismiss='alert'>&times;</button>"
										+ data.message + "</div>");

			} else {
				$('#messages')
						.append(
								"<div id='myMsg'  class='alert alert-dismissible alert-danger'>"
										+ "<button type='button' class='close' data-dismiss='alert'>&times;</button>"
										+ data.message + "</div>");

			}
			getCategoriesList();
			setTimeout(function() {
				$('#myMsg').fadeOut('slow');
			}, 10000); // <-- time in milliseconds

			$('#deleteCategoryModal').modal('toggle');

	

		}
	});

	
	
	return false;
}



function addCategoryValidate() {
	

	var nameReg = /^[A-Za-z\s]+$/;
	var numberReg = /^[0-1]+$/;
	var bool = 1;

	var cat_name = $('#cat_name').val();
	var cat_status = $('#cat_status').val();
	var cat_desc = $('#cat_desc').val();

	$('.error').hide();

	if (cat_name == "") {
		bool = 0;
		$('#cat_name')
				.after(
						'<span class="error text-danger small"> Please enter category name</span>');
	} else if (!nameReg.test(cat_name)) {
		bool = 0;
		$('#cat_name').after(
				'<span class="error text-danger small"> Letters only</span>');
	}

	if (cat_status == "") {
		bool = 0;
		$('#cat_status')
				.after(
						'<span class="error text-danger small"> Please enter status</span>');
	} else if (!numberReg.test(cat_status)) {
		bool = 0;
		$('#cat_status').after(
				'<span class="error text-danger small"> Select only</span>');
	}

	if (cat_desc == "") {
		bool = 0;
		$('#cat_desc')
				.after(
						'<span class="error text-danger small"> Please enter description</span>');
	}

	return Boolean(bool);

}

function editCategoryValidate() {
	

	var nameReg = /^[A-Za-z\s]+$/;
	var numberReg = /^[0-1]+$/;
	var bool = 1;

	var cat_name = $('#edit_cat_name').val();
	var cat_status = $('#edit_cat_status').val();
	var cat_desc = $('#edit_cat_desc').val();

	$('.error').hide();

	if (cat_name == "") {
		bool = 0;
		$('#edit_cat_name')
				.after(
						'<span class="error text-danger small"> Please enter category name</span>');
	} else if (!nameReg.test(cat_name)) {
		bool = 0;
		$('#edit_cat_name').after(
				'<span class="error text-danger small"> Letters only</span>');
	}

	if (cat_status == "") {
		bool = 0;
		$('#edit_cat_status')
				.after(
						'<span class="error text-danger small"> Please enter status</span>');
	} else if (!numberReg.test(cat_status)) {
		bool = 0;
		$('#edit_cat_status').after(
				'<span class="error text-danger small"> Select only</span>');
	}

	if (cat_desc == "") {
		bool = 0;
		$('#edit_cat_desc')
				.after(
						'<span class="error text-danger small"> Please enter description</span>');
	}

	return Boolean(bool);

}
function setCategoryId(id){
	$('#delete_cat_id').val(id);
}
function getCategoryData(id){
	
	var dataString = 'catId=' + id;
	
	$
	.ajax({
		type : "GET",
		url : "./getCategoryDataById",
		data : dataString,
		success : function(data) {
			
			console.log(data.cat_name);
			$('#edit_cat_name').val(data.cat_name);
			$('#edit_cat_status').val(data.cat_status);
			$('#edit_cat_desc').val(data.cat_desc);
			$('#edit_cat_id').val(data.cat_id);
		}
		});
	
	
}





