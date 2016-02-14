<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ include file="../layout/taglib.jsp" %>

    
    
    <form:form commandName="user" cssClass="form-horizontal">
    	
    	<c:if test= "${param.success eq true }"/>
    	
    	 <div class="form-group">
    		<label for="name" class="col-sm-2 control-label">Name:</label>
    	</div>
    	<div class="col-sm-10">
    		<form:input path="name" cssClass="form-control"/>
    	</div>
    	<div class="form-group">
    		<label for="email" class="col-sm-2 control-label">Email:</label>
    	</div>
    	<div class="col-sm-10">
    		<form:input path="email" cssClass="form-control"/>
    	</div>
    	<div class="form-group">
    		<label for="password" class="col-sm-2 control-label">Password:</label>
    	</div>
    	<div class="col-sm-10">
    		<form:password path="password" cssClass="form-control"/>
    	</div>
    	<div class="form-group">
    		<label for="name" class="col-sm-2 control-label">Name:</label>
    	</div>
    	<div class="col-sm-2">
    		<input type="submit" value="Save" class="btn btn-l btn-primary" />
    	</div>
    </form:form>