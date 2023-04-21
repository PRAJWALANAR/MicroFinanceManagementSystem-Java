<div id="container">
    <link href="css.css" rel="stylesheet" type="text/css"/>
    <jsp:include page="admin-header.jsp"></jsp:include>
    
    <script type="text/javascript">
        
        function check()
        {
       
           if(document.f1.amount.value=="")
        {
            alert("plz enter amount!");
            return false;
        }
       
        if(document.f1.user.value=="")
        {
            alert("plz enter username!");
            return false;
        }
           
        if(document.f1.user.value!=document.f1.reuser.value)
        {
            alert("username does not match!");
            return false;
        }
    
    
         }
    </script>
    
    <div id="content-container">
    <div id="content">
        <center>
     
    
    
    <br><br><h2>Deposit</h2><br/><br/>
    
    <div id="messageBox">
                        ${message}
    </div>                                               
    
    <form action="deposit" name="f1" onsubmit="return check();" method="post">
    <b>Amount:</b> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <input type="text" name="amount"/><br/><br/>
    <b>Destination Username:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b> <input type="text" name="username"/><br/><br/>
    <b>Retype Username:&nbsp;</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" name="reuser"/><br/><br/> 
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <br>&nbsp; 
    <input type="submit" value="deposit"/>
    &nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="Clear"/>
    </form><br/>
    </center>
    
    </div>
    
    <div id="aside">
    
    </div>
    </div>
     
    </div>
    