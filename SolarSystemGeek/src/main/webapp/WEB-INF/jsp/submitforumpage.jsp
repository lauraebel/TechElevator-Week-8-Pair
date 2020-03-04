<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<c:import url="/WEB-INF/jsp/common/header.jsp" />


<div id="main-content">

<h2 class="centered"> New Geek Post </h2>

<form action="<c:url value="/submitforumpost" /> " method="POST" >  

<div>
<label for="Username">Username</label>

<input type="text" name="Username">
</div>

<div>
<label for="Subject"> Subject </label>
<input type="text" name="Subject">
</div>

<div>
<label for="Message"> Message </label>
<textarea name="Message" rows="2" cols="10"></textarea>
</div>
<input type="submit"  value="Submit"/> 
</form>


</div>




<c:import url="/WEB-INF/jsp/common/footer.jsp" />