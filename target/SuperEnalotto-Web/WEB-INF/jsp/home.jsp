<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
  <head>
      <meta charset="ISO-8859-1">
      <title>SuperEnalotto</title>
      <script src="http://code.jquery.com/jquery-latest.js"></script>
      <script type="text/javascript" src="https://platform.linkedin.com/badges/js/profile.js" async defer></script>
      <script type="text/javascript" src="../js/main.js"></script>
      <link type="text/css" rel="stylesheet" href="../css/style.css">
  </head>
  <body>
    <div class="centered">
        <h1>SuperEnalotto</h1>
    </div>
    Sestina :

    <input type="text" placeholder=${casuali1 } maxlength="2" class="classe" size=2 id="num1" name="num1" value="<%=request.getAttribute("num1") %>"/>
    <input type="text" placeholder=${casuali2 } maxlength="2" class="classe" size=2 id="num2" name="num2" value="<%=request.getAttribute("num2")%>"/>
    <input type="text" placeholder=${casuali3 } maxlength="2" class="classe" size=2 id="num3" name="num3" value="<%=request.getAttribute("num3")%>"/>
    <input type="text" placeholder=${casuali4 }  maxlength="2" class="classe" size=2 id="num4" name="num4" value="<%=request.getAttribute("num4")%>"/>
    <input type="text" placeholder=${casuali5 } maxlength="2" class="classe" size=2 id="num5" name="num5" value="<%=request.getAttribute("num5")%>"/>
    <input type="text" placeholder=${casuali6 } maxlength="2" class="classe" size=2 id="num6" name="num6" value="<%=request.getAttribute("num6")%>"/>
    <br><br>
    <button type="button" id="valida" name="NomUguali" value="validazione"> Validazione:</button>
    <br><br>
    <input type="button" id="rnd" name="NomUguali" value="Random"> <br><br>
    <div id="risultato"></div>
    <%
        String numeriSbagliati = (String) request.getAttribute("erroreMess");
        if ((numeriSbagliati) == null)
        else
            out.print(numeriSbagliati);
    %>
    <br>
    <%
        String sest = (String) request.getAttribute("validazione");
        if ((sest) == null)
            out.print("");
        else
            out.print(sest);
    %>
    <br>
    <%
        String exception = (String) request.getAttribute("errore");
        if ((exception) == null)
            out.print("");
        else
              out.print(exception);
        %>
    <br>
    <div class="centered">
        <a href="http://localhost:8080/WebSuperEnalotto">Torna alla Home</a></>
    </div>
  </body>
</html>
