<%@ include file="includes/header.jsp"%>


<div class="content-wrapper py-3">

	<div id="catDemo" class="container-fluid">
		<!-- Icon Cards -->




		<dir class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading clearfix">

						<h1>World Map</h1>

      <c:if test="${!empty message}">
    
    <p class="lead"><c:out value="${message}"></c:out></p>
</c:if>

					</div>

					<hr>


					<!-- /.panel-heading -->
					<div class="panel-body">

						<form:form modelAttribute="world" method="POST" action = "/MavenShop/admin/world">

							
							
							<div class="form-group">
    <label for="country">Country : </label>
    <form:errors path="country" />
    

  <form:select path="country" cssClass="form-control"  onclick="setStates(this.value)">
    
<option disabled selected value="">--- Select ---</option>
								<form:options items="${countryList}" />
							</form:select>         

			
  </div>
  
  			
							<div class="form-group">
    <label for="state">State : </label>
    <form:errors path="state" />
    <form:select path="state" cssClass="form-control"  multiple="false">
							
								<option disabled selected>--- Select Country First---</option>
							
         
         <c:if test="${!empty stateList}">
    <form:options items="${stateList}" />
</c:if>
    
							
							</form:select>
  </div>
  
  <div class="form-group">
    <label for="state">PinCode : </label>
     <form:errors path="pinCode" />
    <form:input path="pinCode" cssClass="form-control" onchange="checkNumber(this.value)"/>
  </div>
  
   	<button type="submit" class="btn btn-primary" >Submit</button>
			
  


						</form:form>

					</div>
					<!-- /.panel-body -->
				</div>
			</div>
		</dir>



	</div>
	<!-- /.container-fluid -->

</div>
<!-- /.content-wrapper -->



<script
	src="${pageContext.request.contextPath}/files/admin/js/world.js"></script>
<%@ include file="includes/footer.jsp"%>
