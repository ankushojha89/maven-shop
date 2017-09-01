<%@ include file="includes/header.jsp"%>
<div class="content-wrapper py-3">
	<div id="catDemo" class="container-fluid">
		<dir class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading clearfix">
						<h1>Edit Post</h1>
					</div>
					<hr>
					<div class="panel-body">
						<form:form modelAttribute="post" method="POST" action="${post.post_id }">
							<div class="row">
								<div class="col-lg-8">
									<div class="form-group">
										<label for="post_title">Title : </label>
										<form:errors path="post_title" cssClass="small text-danger"/>
										<form:input path="post_title" cssClass="form-control" />
									</div>
									<div class="form-group">
										<label for="post_desc">Short Description : </label>
										<form:errors path="post_desc" cssClass="small text-danger"/>
										<form:textarea path="post_desc" cssClass="form-control" />
									</div>
									<div class="form-group">
										<label for="post_content">Content : </label>
										<form:errors path="post_content" cssClass="small text-danger"/>
										<form:textarea path="post_content" cssClass="form-control" />
									</div>
								</div>
								<div class="col-lg-4">
									<div class="form-group">
										<label for="post_status">Status</label>
										<form:errors path="post_status" cssClass="small text-danger"/>
										 <form:select path="post_status" cssClass="form-control" >
												<form:option value="0" label="Draft" />
												<form:option value="1" label="Published" />
										</form:select>
									</div>
									<div class="form-group">
										<label for="post_cat_id">Category</label>
										<form:errors path="post_cat_id" cssClass="small text-danger"/>
										<form:select path="post_cat_id" cssClass="form-control">
											<option disabled selected>Select Category</option>
											<c:forEach items="${catList}" var="catTemp">
												<form:option value="${catTemp.cat_id }"
													label="${catTemp.cat_name }"></form:option>
											</c:forEach>
										</form:select>
									</div>
									<button type="submit" name="editSubmit" class="btn btn-primary btn-block btn-lg">Update</button>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</dir>
	</div>
</div>
<script
	src="${pageContext.request.contextPath}/files/admin/vendor/tinymce/tinymce.min.js"></script>
<script>
tinymce.init({
selector : 'textarea#post_content',
height : 200,
menubar : false
});
</script>
<%@ include file="includes/footer.jsp"%>
