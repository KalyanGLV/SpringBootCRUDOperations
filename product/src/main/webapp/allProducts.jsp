
<!DOCTYPE html>
<jsp:include page="header.jsp"></jsp:include>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Users</title>
</head>
<body>


	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<h1>Products List</h1>



	<table border="1" width="90%">
		<tr>
			<th>ProductId</th>
			<th>ProductName</th>
			<th>ProductDescription</th>
			<th>RelatedProducts</th>
			<!-- <th>ProductURL</th> -->
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${p}" var="user">
			<tr>
				<td>${user.productId}</td>
				<td>${user.productName}</td>
				<%
					String imgName = "${user.productName}" + "immage";
				%>
				<td>${user.productDescription}</td>
				<td>${user.relatedProducts}</td>
				<%-- <td><a href="${user.productImage}">View Image</a></td> --%>
				<%-- <td><img SRC="${user.productImage}" width="50" height="50"></td>--%>
				<%-- <td><img src="${user.productImage}"/></td> --%>
				<td><a href="/login/${user.productId}/getProduct">Edit</a></td>
				<td><a href="/login/${user.productId}/deleteProduct">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="/login/deleteAllProducts">
		<button type="submit" class="btn btn-primary">Delete All
			Products</button>
	</a>
	<a href="/login/redirect">
		<button type="submit" class="btn btn-primary">Add Product</button>
	</a>
	<br>


</body>