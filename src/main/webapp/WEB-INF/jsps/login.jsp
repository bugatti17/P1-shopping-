
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   
    <title>Log in with your account</title>
    
	<spring:url value="/resources/css/style.css" var="stylecss"/>  
	<link href="${stylecss}" rel="stylesheet"/>  
<spring:url value="/resources/css/bootstrap.min.css" var="style2css"/>  
	<link href="${style2css}" rel="stylesheet"/>  

</head>

<body>

 <jsp:include page="_header.jsp" />

<div class="container">

    <form method="POST" action="${contextPath}/login" class="form-signin">
        <h2 class="form-heading">Log in</h2>

        <div class="form-group ${error != null ? 'has-error' : ''}">
            <input name="username" type="text" class="form-control" placeholder="Username"
                   autofocus="true"/> <br>
            <input name="password" type="password" class="form-control" placeholder="Password"/>
              <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
           
            <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
            <br>
           
           	<span>${error}</span>
            <span>${message}</span>
           
            <h4 class="text-center"><a href="${contextPath}/registration">Create an account</a></h4>
        </div>

    </form>

</div>

 <jsp:include page="_footer.jsp" />
</body>
</html>
