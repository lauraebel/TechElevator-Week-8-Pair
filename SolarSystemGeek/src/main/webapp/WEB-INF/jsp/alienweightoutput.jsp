<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<c:import url="/WEB-INF/jsp/common/header.jsp" />


<div id="main-content">

<h2 class="centered"> Alien Weight Calculator </h2>

<section class="calculatorOutput">

<img src="<c:url value="/img/${param.planet.toLowerCase() }.jpg" />"/>



<h3>If you are ${param.weight} pounds on planet Earth, then you  would weigh <fmt:formatNumber value="${planetWeight}" type="number" maxFractionDigits="2" /> pounds on ${param.planet}.  </h3>

</section>

</div>





<c:import url="/WEB-INF/jsp/common/footer.jsp" />
