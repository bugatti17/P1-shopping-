<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   
    <title>Edit Page-Admin</title>
    
	<spring:url value="/resources/css/style.css" var="stylecss"/>  
	<link href="${stylecss}" rel="stylesheet"/>  
<spring:url value="/resources/css/bootstrap.min.css" var="style2css"/>  
	<link href="${style2css}" rel="stylesheet"/>  

</head>

<body>
<jsp:include page="_header.jsp" />

<form method="POST" action="${contextPath}/editProduct" class="form-signin">
        <h2 class="form-heading">Add Product</h2>

        <div class="form-group ${error != null ? 'has-error' : ''}">
            <input name="name" type="text" value=${item.name } class="form-control" placeholder="Item name"
                   autofocus="true"/>
            </br>
            <input name="description" type="text" value="${item.description}" class="form-control" placeholder="Description"
              />
            
            </br>
            <input type="number" name="price" value=${item.price } placeholder="Price">
              <input type="hidden" name="id" value="${item.id}"/>
           
               <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
          
            <br>
            <button class="btn btn-lg btn-primary" type="submit">Save</button>
           
        </div>

    </form>


<jsp:include page="_footer.jsp" />
</body>
</html>