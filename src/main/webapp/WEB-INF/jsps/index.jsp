
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
 
<h1> Welcome</h1>
<br>
<form:form method="GET" modelAttribute="name"
           action="${pageContext.request.contextPath}/list">
     
            <button class="btn btn-lg btn-primary btn-block" type="submit">Go to Products</button>
  </form:form>


 <jsp:include page="_footer.jsp" />
</body>
</html>
