<%@ include file="includes/header.jsp"%>


<div class="content-wrapper py-3">

	<div id="catDemo" class="container-fluid">
		<!-- Icon Cards -->
	
		
		

		<dir class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading clearfix">

						<h1>Categories</h1>

						<!-- Button trigger modal -->


						<button type="button" class="btn btn-info btn-lg pull-right"
							data-toggle="modal" data-target="#addCategoryModal">
							<i class="fa fa-plus"></i> Add Category
						</button>


					</div>
<div style="padding:15px 0; ">
		<input class="form-control" type="text" id="searchInput" onkeyup="mySearchFunction()" placeholder="Search for Categories..">
</div>

					<hr>
					
					
				<div id="messages" style="padding:15px 0; ">
				</div>	
		


					<!-- /.panel-heading -->
					<div class="panel-body">
					
			
						<div class="table-responsive">
							<table id="categoryTable" class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th class="mySort"  data-columnNo = "0" data-myOrder = "DESC">#  <i class="arrow down"></i></th>
										<th  class="mySort"  data-columnNo = "1" data-myOrder = "ASC">Name <i></i></th>
										<th  class="mySort"  data-columnNo = "2" data-myOrder = "ASC">Description <i></i></th>
										<th  class="mySort"  data-columnNo = "3" data-myOrder = "ASC">Status <i></i></th>
										<th>Actions</th>
									</tr>
								</thead>
								
								<tbody>
							
								</tbody>
								
							</table>
						</div>
						<!-- /.table-responsive -->
						
						<jsp:include page="./includes/pagination.jsp"></jsp:include>		
					</div>
					<!-- /.panel-body -->
				</div>
			</div>
		</dir>



	</div>
	<!-- /.container-fluid -->

</div>
<!-- /.content-wrapper -->


<!--Add Category Modal -->
<div class="modal fade" id="addCategoryModal" tabindex="-1"
	role="dialog" aria-labelledby="addCategoryModal">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" id="myModalLabel">
					<i class="fa fa-fw fa-plus"></i> Add New Category
				</h4>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>

			</div>
			

				<form:form modelAttribute="category" onsubmit="return addCategory()">
					<div class="modal-body">
					<div class="form-group">
						<label for="cat_name">Name</label>

						<form:input path="cat_name" cssClass="form-control"
							placeholder="Enter Category Name" />
					</div>

					<div class="form-group">
						<label for="cat_status">Status</label>

						<form:select path="cat_status" cssClass="form-control">
							<option disabled selected>Select an option</option>
							<option value="1">Avaliable</option>
							<option value="0">Not Avaliable</option>
						</form:select>

					</div>

					<div class="form-group">
						<label for="cat_desc">Description</label>

						<form:textarea path="cat_desc" cssClass="form-control"
							placeholder="Enter Category Description" />

					</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="submit" class="btn btn-primary" onclick="return addCategoryValidate()">Confirm</button>
			</div>
			</form:form>
		</div>
	</div>
</div>

<!--Edit Modal -->
<div id="editCategoryModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
				<h4 class="modal-title" id="myModalLabel">
					<i class="fa fa-fw fa-edit"></i> Edit Category
				</h4>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>

			</div>
      <form:form modelAttribute="editCategory" onsubmit="return editCategory()">
					<div class="modal-body">
					<div class="form-group">
						<label for="edit_cat_name">Name</label>
 <input name="cat_name" type="text" class="form-control" id="edit_cat_name" placeholder="Enter Category Name">
 <input name="cat_id" type="hidden" id="edit_cat_id">
						
					</div>

					<div class="form-group">
						<label for="edit_cat_status">Status</label>

						
						<select name="cat_status" class="form-control" id="edit_cat_status">
   <option disabled selected>Select an option</option>
							<option value="1">Avaliable</option>
							<option value="0">Not Avaliable</option>
  </select>

					</div>

					<div class="form-group">
						<label for="cat_desc">Description</label>

				
							
				<textarea class="form-control" placeholder="Enter Category Description" name="cat_desc" id="edit_cat_desc"></textarea>			

					</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="submit" class="btn btn-primary" onclick="return editCategoryValidate()">Update</button>
			</div>
			</form:form>
    </div>

  </div>
</div>

<!--Delete Modal -->
<div id="deleteCategoryModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
				<h4 class="modal-title" id="deleteCategoryModal">
					<i class="fa fa-fw fa-trash"></i> Delete Category
				</h4>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>

			</div>
      <form:form modelAttribute="deleteCategory" onsubmit="return deleteCategory()">
					<div class="modal-body">
 					<input name="cat_id" type="hidden" id="delete_cat_id">
						
				<p class="lead">Are you sure you want to delete this category ?</p>

				
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="submit" class="btn btn-primary">Confirm</button>
			</div>
			</form:form>
    </div>

  </div>
</div>
<script
	src="${pageContext.request.contextPath}/files/admin/js/categories.js"></script>
<%@ include file="includes/footer.jsp"%>
