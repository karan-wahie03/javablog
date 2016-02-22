<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="../layout/taglib.jsp"%>
<jsp:include page="../layout/classic.jsp" flush="true" />

<title>Insert title here</title>
</head>
<body> 
 <h1>Latest news for java</h1>


 <table class="table table-bordered table-hover table-striped">
						<thead>
							<tr>
								<th>Date</th>
								<th>Item</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${items}" var="item">
								<tr>
									<td>${item.publishedDate}
									<br />
									<c:out value="${item.blog.name }"></c:out>
									
									</td>
									<td>
									   <strong>
								          <a href="<c:out value="${item.link}" />" target="_blank">
								         <c:out value="${item.title}" /> 
									   </a>
									   </strong>
									   <br />
									   ${item.description}
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>					
			
			

<%@ include file="../layout/footer.jsp" %>
</body>
</html>