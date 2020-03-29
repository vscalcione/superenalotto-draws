<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Generazione Sestina</title>
</head>
<body>
<center><h1>Test funzionamento num: 11 </h1></center>



 <center> <h2>Sestina: <%String sest= (String) request.getAttribute("estrazionejsp");out.print(sest);  %> </h2> </center>   


  <form method= "POST" action="CreateRandom">
Is present on DataBase:  <input type="submit" value="Compare On DB"/>
</form>

      	  <center><a href="http://localhost:8080/WebSuperEnalotto">Indietro</a></center> 



</body>
</html>