<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />



<div id="main-content">


<h2 class="centered"> Solar System Geek Forum </h2>


<form action="<c:url value="/submitforumpage" /> " > 

<input type="submit"  value="Submit Your Post Here"/> 

</form>

<c:forEach items="${posts}" var="post" >    
 <div id="forumpost" > 
<fmt:parseDate value="${post.datePosted}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />

	
	<h4>${post.subject}</h4> 
	<p>  by ${post.username}   on  <fmt:formatDate pattern="MM/dd/yyyy  "  value="${ parsedDateTime }" />  at  <fmt:formatDate pattern="HH:mm:ss"  value="${ parsedDateTime }" />  </p>
	<p>${post.message} </p>
	

</div>
</c:forEach>



</div>



<c:import url="/WEB-INF/jsp/common/footer.jsp" />