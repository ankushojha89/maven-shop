<%@ include file="includes/header.jsp" %>
    <!-- Page Content -->
    <div class="container">

      <div class="row">

        <!-- Blog Entries Column -->
        <div class="col-md-8">

      <h1 class="my-4 card-title">${post.post_title }
                     
          </h1>
          <p class="text-muted small">
            
                  Posted on <c:out value="${post.created_data_time }" />  in    
                  
                  <a href="${pageContext.request.contextPath}?cat_id=${post.post_cat_id }" class="link"><c:out value="${post.cat_name }" /></a>       
            </p>
         <!-- Blog Post -->
          <div class="card mb-4">
            <img class="card-img-top" src="http://placehold.it/750x300" alt="Card image cap">
            <div class="card-body">
              
              
              <div class="card-text">
              <c:out value="${post.post_content }" escapeXml="false"/>
              </div>
             </div>
            
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
