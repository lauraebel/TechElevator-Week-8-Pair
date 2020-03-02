<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<c:import url="/WEB-INF/jsp/common/header.jsp" />


<div id="main-content">

<h2 class="centered"> Alien Age Calculator </h2>


<img src="<c:url value="/img/${param.planet.toLowerCase() }.jpg" />"/>;



<h3>If you are ${param.age} years old on planet Earth, then you are <fmt:formatNumber value="${planetAge}" type="number" maxFractionDigits="2" /> ${param.planet} years old.  </h3>

</div>





<c:import url="/WEB-INF/jsp/common/footer.jsp" />