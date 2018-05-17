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
 
<br>
<div style="overflow-x:auto;">
 <table class="table table-striped">
        
        <thead>
            <tr>
                <th>Item Name</th>
                <th>Quantity</th>
                <th>Price</th>
               <th>Total Price</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${items}" var="item">
                <tr>
                    <td>${item.name}</td>
                     <td>${item.quantity}</td>
                   
                    <td class="price">${item.price}</td>
                  	 <td class="price">${item.subtotal}</td>
                  	 <td> <a type="button" class="btn btn-warning"  href="/delete?id=${item.id }">Delete</a>
					</td>
				
               </tr>
            </c:forEach>
        </tbody>
    </table>
  </div>

    
 <jsp:include page="_footer.jsp" />
</body>
</html>
