
<!DOCTYPE html>
<jsp:include page="header.jsp"></jsp:include>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Form</title>
</head>
<body>
	<%@page
		import="com.ibm.demo.processor.ProductProcessor,com.ibm.demo.beans.Products"%>



	<h1>Edit Form</h1>
	<form action="/login/updateProduct" method="post">
		<%-- <input type="hidden" name="pId" value="${p.getProductId()} "/> --%>
		<table>
			<tr>
				<td>ProductId:</td>
				<td><input type="text" name="pId" value="${p.getProductId()}" /></td>
			</tr>
			<tr>
				<td>ProductName:</td>
				<td><input type="text" name="pName"
					value=" ${p.getProductName()}" /></td>
			</tr>
			<tr>
				<td>ProductDescription:</td>
				<td><input type="text" name="pDescr"
					value="${p.getProductDescription()}" /></td>
			</tr>
			<tr>
				<td>RelatedProducts:</td>
				<td><input type="text" name="pRelated"
					value="${p.getRelatedProducts()}" /></td>
			</tr>
			<%-- <tr>
				<td>productURL:</td>
				<td><input type="text" name="pURL"
					value="${ p.getProductImage()}" /></td>
			</tr> --%>
			<tr>
				<td colspan="2"><input type="submit" value="Update Product" /></td>
			</tr>
		</table>
	</form>

</body>
</html>
