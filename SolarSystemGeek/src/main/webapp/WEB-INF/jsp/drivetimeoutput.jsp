<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />


<div id="main-content">

<h2 class="centered"> Alien Travel Calculator </h2>


<img src="<c:url value="/img/${param.planet.toLowerCase() }.jpg" />"/>;



<h3> Traveling by ${param.method} you will reach ${param.planet} in <fmt:formatNumber value="${travelTime}" type="number" maxFractionDigits="2" /> years. You will be <fmt:formatNumber value="${travelAge}" type="number" maxFractionDigits="2" /> years old. </h3>

</div>





<c:import url="/WEB-INF/jsp/common/footer.jsp" />