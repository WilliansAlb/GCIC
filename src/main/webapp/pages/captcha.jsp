<%-- 
    Document   : captcha
    Created on : 17/05/2021, 03:12:54
    Author     : willi
--%>

<%@page import="Controladores.Captchas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Captchas c = new Captchas();
    HttpSession h = request.getSession();
    if (h.getAttribute("link") != null) {
        String captcha = h.getAttribute("id").toString();
        String titulo = h.getAttribute("titulo").toString();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%out.print(titulo);%></title>
        <link rel="shortcut icon" type="image/ico" href="../img/088-cube.ico"/>
        <link rel="stylesheet" href="../css/estilos.css">
        <link rel="stylesheet" href="../css/multiboton.css">
        <link rel="stylesheet" href="../css/tarjetas.css" />
        <link rel="stylesheet" href="../css/tabla.css" />
        <link rel="stylesheet" href="../css/captcha.css" />
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,500&display=swap" rel="stylesheet">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
        <script src="https://cdn.jsdelivr.net/npm/chart.js@latest/dist/Chart.min.js"></script>
    </head>
    <button class="learn-more" onclick="window.location = 'http://localhost:8080/GCIC/'" style="width:fit-content;margin:auto;"><img src="../img/svg/088-cube.svg" width="50px" title="Regresar a GCIC" alt="Regresar a GCIC"></button>
        <%if (h.getAttribute("temp") != null) {%>
        <%
            out.print(h.getAttribute("temp").toString());
            h.setAttribute("temp", null);
        %>
        <%} else {%>
        <jsp:include page="${link}"></jsp:include>
        <%}%>
</html>
<%} else {
        response.sendRedirect("http://localhost:8080/GCIC/");
    }%>
