<%@ include file="includes/header.jsp" %>
    <!-- Page Content -->
    <div class="container">

      <div class="row">

        <!-- Blog Entries Column -->
        <div class="col-md-8">

          <c:choose>
         
         
         <c:when test = "${!empty sKey }">
           <h1 class="my-4">Search results for :
            <small><c:out value="${sKey }" /></small>
          </h1>
         </c:when>
         
         <c:when test = "${!empty catDetails }">
           <h1 class="my-4">Category :  <small><c:out value="${catDetails.cat_name }" />  </small>          
          </h1>
          <p class="lead"><c:out value="${catDetails.cat_desc }" /></p>
         </c:when>
         
         
         <c:otherwise>
            <h1 class="my-4">Welcome to Maven Shop
            <small>Spring... Practical Interesting</small>
          </h1>
         </c:otherwise>
      </c:choose>
    <c:if test="${empty postsList }">
<div class="card-body">
              <h2 class="card-title">Sorry No Records Found...</h2>
              
              <a href="${pageContext.request.contextPath}" class="btn btn-primary">Go to Home &rarr;</a>
            </div>
          </c:if>
					      

       <c:forEach items="${postsList }" var="post">
         <!-- Blog Post -->
          <div class="card mb-4">
            <img class="card-img-top" src="http://placehold.it/750x300" alt="Card image cap">
            <div class="card-body">
              <h2 class="card-title"><c:out value="${post.post_title }" /></h2>
              <p class="card-text">
              <c:out value="${post.post_desc }" />
              </p>
              <a href="${pageContext.request.contextPath}?post_id=${post.post_id }" class="btn btn-primary">Read More &rarr;</a>
            </div>
            <div class="card-footer text-muted">
            
                  Posted on <c:out value="${post.created_data_time }" /> 
         <c:if test = "${empty catDetails }">
in    
                  
                  <a href="${pageContext.request.contextPath}?cat_id=${post.post_cat_id }" class="link"><c:out value="${post.cat_name }" /></a>       
           
          </c:if>	         
                  
                    </div>
          </div>
       
       </c:forEach>
       
          <!-- Pagination -->
    	<div class="my-pagination">
						<ul class="pagination justify-content-center mb-4">
								
							
								<c:url value="/" var="next">
									<c:param name="page" value="${page + 1}" />	
									
									
								<c:if test = "${!empty catDetails }">
          
       <c:param name="cat_id" value="${catDetails.cat_id}" />	
          </c:if>	
									
									<c:if test="${!empty sKey }">
          
       <c:param name="sKey" value="${sKey}" />	
          </c:if>
									
																	
								</c:url>
								<c:if test="${page + 1 <= maxPages}">
												
								<li class="page-item">
              <a class="page-link" href='<c:out value="${next}" />'>&larr; Older</a>
            </li>			
								</c:if>
								
								<c:url value="/" var="prev">
									<c:param name="page" value="${page-1}" />
									<c:if test="${!empty sKey }">
          
       <c:param name="sKey" value="${sKey}" />	
          </c:if>
						<c:if test = "${!empty catDetails }">
          
       <c:param name="cat_id" value="${catDetails.cat_id}" />	
          </c:if>										
								</c:url>
								<c:if test="${page > 1}">
									
						
             <li class="page-item">
              <a class="page-link" href='<c:out value="${prev}" />'>Newer &rarr;</a>
            </li>					
											
											
								</c:if>


							</ul>



						</div>	
    
    
    
       
    
      
      

        </div>

        <!-- Sidebar Widgets Column -->
        <div class="col-md-4">
       

<%@ include file="includes/sidebar.jsp" %>

        </div>

      </div>
      <!-- /.row -->

    </div>
    <!-- /.container -->

 <%@ include file="includes/footer.jsp" %>
