<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping</title>

	<spring:url value="/resources/css/style.css" var="stylecss"/>  
	<spring:url value="/resources/css/bootstrap.min.css" var="style2css"/>  
	
	<link href="${stylecss}" rel="stylesheet"/>  
	<link href="${style2css}" rel="stylesheet"/>  
	
</head>
<body>

 <jsp:include page="_header.jsp" />
 
<c:if test="${pageContext.request.userPrincipal.name != null}">
        
<form action="${pageContext.request.contextPath}/myCard"  method="GET">
	 	<button  class="btn btn-primary" type="submit">My Card</button>
 </form> 
 </c:if>
 <c:if test="${pageContext.request.userPrincipal.name == null}">
 <span> Please login to add items into your card </span>
 </c:if>
        
<br>
<div style="overflow-x:auto;">
 <table class="table table-striped">
        
        <thead>
            <tr>
                <th>Item Name</th>
                <th>Description</th>
                <th>Price</th>
               <th>Quantity</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${items}" var="item">
                <tr>
                    <td>${item.name}</td>
                     <td>${item.description}</td>
                   
                    <td class="price">${item.price}</td>
                    <c:if test="${pageContext.request.userPrincipal.name != null}">
        			<td> 
        			 
                    	<form action="${pageContext.request.contextPath}/add?id=${item.id}" class="add-form" method="POST">
	 						<input type="number" name="quantity" min="1"  value=1>
                    
	 						<button  class="btn btn-primary" type="submit">Add</button>
 							 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
           
 					</form> </td>
					</c:if>
					 <security:authorize  access="hasRole('ROLE_ADMIN')">
						 <td>
                		 <a type="button" class="btn btn-warning"
                   		  href="${pageContext.request.contextPath}/editProduct?id=${item.id}">
                  	     Edit Product</a>
                  		  </td>
           		    </security:authorize>
                </tr>
            </c:forEach>
        </tbody>
    </table>
  </div>

    
 <jsp:include page="_footer.jsp" />
</body>
</html>
