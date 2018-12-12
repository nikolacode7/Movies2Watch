<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/common.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

<style>           
.blue-button{
 background: #25A6E1;
 filter: progid: DXImageTransform.Microsoft.gradient( startColorstr='#25A6E1',endColorstr='#188BC0',GradientType=0);
 padding:3px 5px;
 color:#fff;
 font-family:'Helvetica Neue',sans-serif;
 font-size:12px;
 border-radius:2px;
 -moz-border-radius:2px;
 -webkit-border-radius:4px;
 border:1px solid #1A87B9
}     
table {
  font-family: "Helvetica Neue", Helvetica, sans-serif;
   width: 50%;
}
th {
  background: SteelBlue;
  color: white;
}
 td,th{
                border: 1px solid gray;
                width: 25%;
                text-align: left;
                padding: 5px 10px;
            }
</style>
<script type="text/javascript">
    var clicks = 0;
    function onClick() {
        clicks += 1;
        document.getElementById("clicks").innerHTML = clicks;
    };
    </script>

</head>
<body>
<div class="container">
<form id="logoutForm" method="POST" action="${pageContext.request.contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        <h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h2>
 </div>       

<div class="container">
<form:form method="post" modelAttribute="movie" action="${pageContext.request.contextPath}/addMovie">

<table>
  <tr>
   <th colspan="2">Add Movie</th>
  </tr>
  <tr>
  <form:hidden path="id" />
          <td><form:label path="movieName">Movie Name:</form:label></td>
          <td><form:input path="movieName" size="30" maxlength="30"></form:input></td>
        </tr>
  <tr>
       <td><form:label path="movieGenre">Movie Genre:</form:label></td>
          <td><form:input path="movieGenre" size="30" maxlength="30"></form:input></td>
  </tr>
  <tr>
   <td colspan="2"><input type="submit"
    class="blue-button" /></td>
  </tr>
 </table> 
 </form:form>
<h3>Movie List</h3>
<c:if test="${!empty listOfMovies}">
 <table class="tg">
 <tr>
  <th width="80">Id</th>
  <th width="120">Movie</th>
  <th width="120">Movie Genre</th>
  <th width="120">Number of likes</th>
  <th width="60">Like</th>
  <th width="60">Edit</th>
  <th width="60">Delete</th>
  
 </tr>
 <c:forEach items="${listOfMovies}" var="movie">
  <tr>
   <td>${movie.id}</td>
   <td>${movie.movieName}</td>
   <td>${movie.movieGenre}</td>
   <td>${movie.likes}</td>
   <td><a href="<c:url value='/updateLikes/${movie.id}' />" >Like</a></td>
   <td><a href="<c:url value='/updateMovie/${movie.id}' />" >Edit</a></td>
   <td><a href="<c:url value='/deleteMovie/${movie.id}' />" >Delete</a></td>
   
   
  </tr>
 </c:forEach>
 </table>
</c:if>
</div>  

    
    

</body>
</html>
