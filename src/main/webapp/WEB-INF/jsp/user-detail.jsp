<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<script
 src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
 
 <script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/jquery.validate.min.js"></script>


<%@ include file="../layout/taglib.jsp" %>
<jsp:include page="../layout/classic.jsp" flush="true"/>


<h1><c:out value="${user.name }"></c:out> 
</h1>



<!-- Button trigger modal -->
<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
  New Blog
</button>


<form:form commandName="blog" csssClass="form-horizontal registrationForm">
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">New Blog</h4>
      </div>
      <div class="modal-body">
      
      
       <div class="form-group">
				<label for="name" class="col-sm-2 control-label">Name:</label>
				<div class="col-sm-10">
					<form:input path="name" cssClass="form-control" />
					<form:errors path="name" />
				</div>
			</div>
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">URL:</label>
				<div class="col-sm-10">
					<form:input path="name" cssClass="form-control" />
					<form:errors path="url" />
				</div>
			</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <input type="submit" class="btn btn-primary" value="Save"/>
       
      </div>
    </div>
  </div>
</div>
</form:form>



<div>

  <script type="text/javascript">
		  $(document).ready(function(){
			  $('.nav-tabs a:first').tab('show'); 
			  $(".triggerRemove").click(function(e){
				  
				  e.preventDefault();
				  $("#modalRemove").modal('show');
				  $("#modalRemove .removeBtn").attr("href", $(this).attr("href"));
			  });
		  });
		</script>
  
  <!-- Nav tabs -->
  <ul class="nav nav-tabs" role="tablist">
    <c:forEach items="${user.blogs}" var= "blog">
    <li role="presentation"><a href="#blog_${blog.id}"  data-toggle="tab">${blog.name}</a></li>
    </c:forEach>
  </ul>

  <!-- Tab panes -->
  <div class="tab-content">
  <c:forEach items="${user.blogs}" var= "blog">
  
   <div  class="tab-pane " id="blog_${blog.id}">
  						
  						
  					<h1>${blog.name}</h1>
	<p> 
	<a href="<spring:url value="/blog/remove/${blog.id}.html"/>" class="btn btn-danger triggerRemove">Remove Blog</a>
	${blog.url}</p>

	<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
		<th>Title</th>
		<th>Link</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items= "${blog.items}" var="item">
	
	<tr>
		<td><c:out value="${item.title}"></c:out></td>
		<td><c:out value="${item.link}"></c:out></td>
		</tr>
	
	</c:forEach>
	</tbody>
	</table>
    
    </div>	
  		
  
 			 
  
  </c:forEach>
    		
 
</div>


 
	<!-- Modal -->
<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Remove Blog</h4>
      </div>
      <div class="modal-body">
      Really you wanna do that?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
        <a href="" class="btn btn-danger removeBtn">Remove</a>
      </div>
    </div>
  </div>
</div>
	
    
    
</div>    
    
    
    
    	
   

