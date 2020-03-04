<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div id="main-content">

<h2 class="centered"> Solar System Geek Gift Shop </h2>

<c:forEach items="${products}" var="product">

<div id="product" >

<c:url value="/productdetail" var="productdetailurl" >
<c:param name="id" value="${product.id}" />
</c:url>

<a href="${productdetailurl}"><img src ="<c:url value="/img/${product.imageName}" />" /></a>

<h3>${product.name}</h3>

<p>${product.price}</p>

</div>

</c:forEach>

</div>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />