<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../layout/taglib.jsp"%>
<jsp:include page="../layout/classic.jsp" flush="true" />

<html>

<body>
	<div class="container">

		<form:form commandName="user"
			csssClass="form-horizontal registrationForm">

			<c:if test="${param.success eq true}">
				<div class="alert alert-success">Register successfully</div>
			</c:if>

			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">Name</label>
				<div class="col-sm-10">
					<form:input path="name" cssClass="form-control" />
					<form:errors path="name" />
				</div>
			</div>
			<br><br><br>
			<div class="form-group">
				<label for="email" class="col-sm-2 control-label">Email</label>
				<div class="col-sm-10">
					<form:input path="email" cssClass="form-control" />
					<form:errors path="email" />
				</div>
				<br><br>
			</div>
			<div class="form-group">
				<label for="password" class="col-sm-2 control-label">Password</label>
				<div class="col-sm-10">
					<form:password path="password" cssClass="form-control" />
					<form:errors path="password" />
				</div>
			</div>
			<br><br><br>
			
			<div class="form-group">
				<label for="password" class="col-sm-2 control-label">Confirm Password</label>
				<div class="col-sm-10">
					<input type="password" name="confirm_password" id="confirm_password" class="form-control">
				</div>
			</div>
			<br><br>
			
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="submit" value="Save" class="btn btn-default" />
				</div>
			</div>
		</form:form>
		
	<script type="text/javascript" >
	
	$(document).ready(function(){
		$(".registrationForm").validate({
			
			rules:{
				name:{
					required: true,
					minlength: 3
				},
				email:{
					required: true,
					email: true
				},
				password:{
					required: true,
					minlength: 5
				},
				confirm_password:{
					required: true,
					minlength: 5,
					equalTo: "#password"
				},
				highlight: function(element){
					$(element).closest('.form-group').removeClass('has-sucess').addClass('has-error');
				},
				highlight: function(element){
					$(element).closest('.form-group').removeClass('has-error').addClass('has-success');
				}
			}
		});	
	});
	
	</script>

	</div>

    
       <%@ include file="../layout/footer.jsp" %>
       </body>
       </html>