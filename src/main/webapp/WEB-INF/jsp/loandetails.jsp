
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="container">
<link href="css.css" rel="stylesheet" type="text/css">
<jsp:include page="admin-header.jsp"></jsp:include>

<div id="content-container">
<div id="content"><center>
<marquee><h2 style="color: red;"><i>--- Welcome ${username} ---</i></h2></marquee><br/><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<table cellpadding="10" border="1">
		<tr>
			<td>Name</td>
			<td>Username</td>
            <td>Account No.</td>
			<td>Address</td>
			<td>IFSC</td>
			<td>Principal</td>
			<td>Term</td>
		    <td>EMI</td>
		    <td>Balance</td>
		    
		    
		</tr>
<c:forEach items="${allcust}" var="allcust">
	<tr>
		<td>${allcust.name}</td>
		<td>${allcust.username}</td>
		<td>${allcust.accno}</td>
		<td>${allcust.address}</td>
		<td>${allcust.ifsc}</td>
		<td>${allcust.principal}</td>
	    <td>${allcust.term}</td>
        <td>${allcust.emi}</td>
	    <td>${allcust.balance}</td>
	    
     </tr>
</c:forEach>
</table>

</div>

</div>
</div>
