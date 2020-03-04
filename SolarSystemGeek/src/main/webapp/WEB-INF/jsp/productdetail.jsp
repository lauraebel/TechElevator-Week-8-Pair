<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div id="main-content">

<h2 class="centered"> Solar System Geek Gift Shop </h2>

<img src ="<c:url value="/img/${product.imageName}" />" />

<h1>${product.name}</h1>

<p>${product.price}</p>

<p>${product.description}</p>

</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />