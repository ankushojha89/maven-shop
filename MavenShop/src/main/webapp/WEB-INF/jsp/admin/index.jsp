<%@ include file="includes/header.jsp"%>


	<div class="content-wrapper py-3">

		<div class="container-fluid">

			<!-- Icon Cards -->
			<div class="row">
				<div class="col-xl-3 col-sm-6 mb-3">
					<div class="card text-white bg-success o-hidden h-100">
						<div class="card-body">
							<div class="card-body-icon">
								<i class="fa fa-fw fa-comments"></i>
							</div>
							<div class="mr-5"><c:out value="${postCount }" /> New Post!</div>
						</div>
						<a href="${pageContext.request.contextPath}/admin/posts" class="card-footer text-white clearfix small z-1">
							<span class="float-left">View Details</span> <span
							class="float-right"> <i class="fa fa-angle-right"></i>
						</span>
						</a>
					</div>
				</div>
				<div class="col-xl-3 col-sm-6 mb-3">
					<div class="card text-white bg-info o-hidden h-100">
						<div class="card-body">
							<div class="card-body-icon">
								<i class="fa fa-fw fa-folder-open"></i>
							</div>
							<div class="mr-5"><c:out value="${catCount }" /> Categories</div>
						</div>
						<a href="${pageContext.request.contextPath}/admin/categories" class="card-footer text-white clearfix small z-1">
							<span class="float-left">View Details</span> <span
							class="float-right"> <i class="fa fa-angle-right"></i>
						</span>
						</a>
					</div>
				</div>
	
			
			</div>



		</div>
		<!-- /.container-fluid -->

	</div>
	<!-- /.content-wrapper -->

<%@ include file="includes/footer.jsp"%>
