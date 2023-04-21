
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
			<td>FROM</td>
			<td>TO</td>
			<td>TIMESTAMP</td>
			<td>AMOUNT</td>
		</tr>
<c:forEach items="${transaction}" var="transaction">
	<tr>
		<td>${transaction.from}</td>
		<td>${transaction.to}</td>
	    <td>${transaction.timestamp}</td>
	    <td>${transaction.amount}</td>
     </tr>
</c:forEach>
</table>

</div>


</div>
</div>
