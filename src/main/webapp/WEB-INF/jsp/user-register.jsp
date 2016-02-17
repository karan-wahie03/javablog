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
			<div class="form-group">
				<label for="email" class="col-sm-2 control-label">Email</label>
				<div class="col-sm-10">
					<form:input path="email" cssClass="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-sm-2 control-label">Password</label>
				<div class="col-sm-10">
					<form:password path="password" cssClass="form-control" />
					<form:errors path="password" />
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-sm-2 control-label">Confirm Password</label>
				<div class="col-sm-10">
					<input type="password" name="pwd_again" id="pwd_again" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="submit" value="Save" class="btn btn-default" />
				</div>
			</div>
		</form:form>

	</div>

    
       <%@ include file="../layout/footer.jsp" %>