<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<c:import url="/WEB-INF/jsp/common/header.jsp" />


<div id="main-content">

<h2 class="centered"> Alien Weight Calculator </h2>

<form action="<c:url value="/alienweightsubmission"/>" method="GET"> 
	<label for="planet"> Choose A Planet </label>
	
	<select id="planets" name="planet"> 
		<option value="">Choose One </option>
		<option value="Mercury">Mercury </option> 
		<option value="Venus">Venus </option>
		<option value="Mars"> Mars </option>
		<option value="Jupiter"> Jupiter </option>
		<option value="Saturn"> Saturn </option>
		<option value="Uranus"> Uranus </option>
		<option value="Neptune"> Neptune </option>
	 </select> 
	
	</br>
	</br>
	<label for="weight"> Enter Your Earth Weight</label>
	<input type="text" name="weight" />
	
	<input type="submit" value="Calculate Weight" /> 
	

</form>




</div>





<c:import url="/WEB-INF/jsp/common/footer.jsp" />