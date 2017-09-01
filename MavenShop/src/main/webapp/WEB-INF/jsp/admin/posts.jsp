<%@ include file="includes/header.jsp"%>


<div class="content-wrapper py-3">

	<div id="catDemo" class="container-fluid">
		<!-- Icon Cards -->
			
		<dir class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading clearfix">

						<h1>Posts</h1>

						<!-- Button trigger modal -->
						
			<a	href="${pageContext.request.contextPath}/admin/addpost"
												type="button" class="btn btn-primary btn-lg pull-right"><i class="fa fa-plus"></i> Add Post
								</a>			
						


					</div>



					<hr>
					

<form:form  cssClass="form-horizontal" method="get">
              <div class="input-group" >
                <input type="text" name="sKey" class="form-control" placeholder="Search for...">
                <span class="input-group-btn">
                  <button class="btn btn-primary" type="submit">
                    <i class="fa fa-search"></i>
                  </button>
                </span>
              </div>
            </form:form>
		<hr>
					<!-- /.panel-heading -->
					<div class="panel-body">

						<div class="table-responsive">
							<table id="categoryTable" class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th class="mySort" ># <i data-columnNo = "0" data-myOrder = "DESC" ></i></th>
										<th class="mySort">Title <i   data-columnNo = "1" data-myOrder = "ASC"></i></th>
										
										<th class="mySort">Category <i   data-columnNo = "2" data-myOrder = "ASC"></i></th>
										
										<th class="mySort" >Created On <i  data-columnNo = "3" data-myOrder = "ASC"></i></th>
										<th class="mySort"  >Short Description <i data-columnNo = "4" data-myOrder = "ASC"></i></th>
										<th class="mySort" >Status <i  data-columnNo = "5" data-myOrder = "ASC"></i></th>
										<th>Actions</th>
									</tr>
								</thead>
								
								<tbody>
							<c:forEach items="${postsList }" var="temp">
												
							<tr>
								<td><c:out value="${temp.post_id }"></c:out></td>
								<td><c:out value="${temp.post_title }"></c:out></td>
								
								<td>
								<c:if test="${empty temp.cat_name }">
								<span class="text-danger small">Please define category</span>
								</c:if>
								<c:if test="${!empty temp.cat_name }">
								<c:out value="${temp.cat_name }"></c:out>
								</c:if>
								</td>
								
								<td><c:out value="${temp.created_data_time }"></c:out></td>
								<td><c:out value="${temp.post_desc }"></c:out></td>
								<td>
								<c:if test="${temp.post_status ==0}">
								<span class='small label label-success'>Drafted</span>
								</c:if>
								<c:if test="${temp.post_status ==1}">
								<span class='small label label-success'>Published</span>
								</c:if>
								</td>
								
								<td><a href="${pageContext.request.contextPath}/admin/editpost/${temp.post_id}"
												type="button" class="btn btn-success"><i class="fa fa-edit"></i>
								</a>
								<button type="button" class="btn btn-danger" onclick="setPostId(${temp.post_id})" data-toggle="modal" data-target="#deletePostModal"><i
													class="fa fa-trash"></i></button>
													
													</td>
								
								
							</tr>					
													
					
							</c:forEach>
							
								</tbody>
								
							</table>
						</div>
						<!-- /.table-responsive -->
						
						
						<div class="my-pagination">
							<ul class="pagination">
								<c:url value="/admin/posts" var="prev">
									<c:param name="page" value="${page-1}" />
									<c:param name="oId" value="${oId}" />
									<c:param name="oBy" value="${oBy}" />
								</c:url>
								<c:if test="${page > 1}">
									<li><a href="<c:out value="${prev}" />" class="pn prev">&laquo;
											Prev</a></li>
								</c:if>
								<c:forEach begin="1" end="${maxPages}" step="1" varStatus="i">
									<c:choose>
										<c:when test="${page == i.index}">
											<li><a class="active" href="javascript:void(0)">${i.index}</a></li>
										</c:when>
										<c:otherwise>
											<c:url value="/admin/posts" var="url">
												<c:param name="page" value="${i.index}" />
												<c:param name="oId" value="${oId}" />
									<c:param name="oBy" value="${oBy}" />
											</c:url>
											<li><a href='<c:out value="${url}" />'>${i.index}</a></li>


										</c:otherwise>
									</c:choose>
								</c:forEach>

								<c:url value="/admin/posts" var="next">
									<c:param name="page" value="${page + 1}" />
									<c:param name="oId" value="${oId}" />
									<c:param name="oBy" value="${oBy}" />
								</c:url>
								<c:if test="${page + 1 <= maxPages}">
									<li><a href='<c:out value="${next}" />' class="pn next">Next
											&raquo;</a></li>
								</c:if>


							</ul>



						</div>	
					</div>
					<!-- /.panel-body -->
				</div>
			</div>
		</dir>



	</div>
	<!-- /.container-fluid -->

</div>
<!-- /.content-wrapper -->


<!--Delete Modal -->
<div id="deletePostModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
				<h4 class="modal-title" id="deleteCategoryModal">
					<i class="fa fa-fw fa-trash"></i> Delete Post
				</h4>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>

			</div>
      <form:form modelAttribute="deletePost" action="deletepost">
					<div class="modal-body">
 					<input name="post_id" type="hidden" id="post_id">
						
				<p class="lead">Are you sure you want to delete this Post ?</p>

				
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="submit" class="btn btn-danger">Confirm</button>
			</div>
			</form:form>
    </div>

  </div>
</div>
<script
	src="${pageContext.request.contextPath}/files/admin/js/posts.js"></script>

<%@ include file="includes/footer.jsp"%>
