
          <!-- Search Widget -->
          <div class="card my-4">
            <h5 class="card-header">Search</h5>
            <div class="card-body">
            
              
              
 <form:form  method="get">
              <div class="input-group">
                <input type="text" name="sKey" class="form-control" placeholder="Search for...">
                <span class="input-group-btn">
                  <button class="btn btn-secondary" type="submit">Go!</button>
                </span>
              </div>
            </form:form>             
              
              
            </div>
          </div>

          <!-- Categories Widget -->
          <div class="card my-4">
            <h5 class="card-header">Categories</h5>
            <div class="card-body">
              <div class="row">
                <div class="col-lg-12">
                  <ul class="list-unstyled mb-0">
                  
            <c:forEach items="${catLists}" var="current">        
                         
         <li > <a href="${pageContext.request.contextPath}?cat_id=${current.cat_id }"><c:out value = "${current.cat_name}"/></a> </li>
      </c:forEach>
                  
                  </ul>
                </div>                
              </div>
            </div>
          </div>

          <!-- Side Widget -->
          <div class="card my-4">
            <h5 class="card-header">Side Widget</h5>
            <div class="card-body">
              You can put anything you want inside of these side widgets. They are easy to use, and feature the new Bootstrap 4 card containers!
            </div>
          </div>