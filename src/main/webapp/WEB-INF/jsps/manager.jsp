<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping</title>

	<spring:url value="/resources/css/style.css" var="stylecss"/>  
	<link href="${stylecss}" rel="stylesheet"/>  

</head>
<body>

 <jsp:include page="_header.jsp" />
 
<h1> Welcome!</h1>
<br>
<div style="overflow-x:auto;">
 <table class="table table-striped">
        
        <thead>
            <tr>
                <th>Item Name</th>
                <th>Description</th>
                <th>Price</th>
               
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${items}" var="item">
                <tr>
                    <td>${item.name}</td>
                     <td>${item.description}</td>
                   
                    <td class="price">${item.price}</td>
                    
                </tr>
            </c:forEach>
        </tbody>
    </table>
  </div>
<hr>

<form method="POST" action="${contextPath}/list" class="form-signin">
        <h2 class="form-heading">Add Product</h2>

        <div class="form-group ${error != null ? 'has-error' : ''}">
            <input name="name" type="text" class="form-control" placeholder="Item name"
                   autofocus="true"/>
            </br>
            <input name="description" type="text" class="form-control" placeholder="Description"
              />
            
            </br>
            <input type="number" name="price"  placeholder="Price">
               <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
          
            <br>
            <button class="btn btn-lg btn-primary" type="submit">Add</button>
           
        </div>

    </form>
    
 <jsp:include page="_footer.jsp" />
</body>
</html>
