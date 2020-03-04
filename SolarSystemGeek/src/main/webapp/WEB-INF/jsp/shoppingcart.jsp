<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div id="main-content">

<h2 class="centered"> Solar System Geek Gift Shop </h2>

<div id="productlabels">
<h3>Name</h3>
<h3>Price</h3>
<h3>Quantity</h3>
<h3>Total</h3>
</div>

<c:forEach items="${products}" var="product">

<div id="product" >
<img src ="<c:url value="/img/${product.imageName}" />" />
<p>${product.name}</p>
<p>${product.description}</p>
<p>${product.price}</p>

</div>

</c:forEach>

</div>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />