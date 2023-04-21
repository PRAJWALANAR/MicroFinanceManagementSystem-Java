    <script type="text/javascript">
    
    function check()
    {
    if(document.f1.username.value=="")
    {
        alert("plz enter username!");
        return false;
    }

    if(document.f1.password.value=="")
    {
        alert("please enter password!");
        return false;
    }

    if(document.f1.password.value!=document.f1.repassword.value)
    {
        alert("password does not match!");
        return false;
    }

    if(document.f1.amount.value=="")
    {
        alert("please enter amount!");
        return false;
    }

    if(document.f1.address.value=="")
    {
        alert("please enter address!");
        return false;
    }

    if(document.f1.phone.value=="")
    {
        alert("please enter phone no.!");
        return false;
    }
    }
</script>
<div id="container">
<link href="css.css" rel="stylesheet" type="text/css">
<jsp:include page="admin-header.jsp"></jsp:include>

<div id="content-container">
<div id="content"><center>
<marquee><h2 style="color: red;"><i>--- Welcome ${username} ---</i></h2></marquee><br/><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

</div>
<center>
<br/><h2>Open Account :-</h2><br/><br/>
    <form name="f1" action="addcust" onsubmit="return check();" method="post">
		<b>		 
		Name: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="name"/><br/><br/>		 
		Username: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="username"/><br/><br/>
		Address: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="address"/><br/><br/>
		Phone No: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="mobno"/><br/><br/>
		Email: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="email"/><br/><br/>
		Aadhar no: &nbsp;<input type="text" name="aadhar"/><br/><br/></b>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" value="Submit"/>
    	&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="Clear"/>
</form></center>
</div>

</div>
 
</div>
