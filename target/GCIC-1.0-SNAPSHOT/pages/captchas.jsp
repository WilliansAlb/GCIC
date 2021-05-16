<%-- 
    Document   : captchas
    Created on : 16/05/2021, 03:52:21
    Author     : willi
--%>

<%@page import="POJOS.Captcha"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Controladores.Captchas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Captchas</title>
        <link rel="shortcut icon" type="image/ico" href="../img/088-cube.ico"/>
        <link rel="stylesheet" href="../css/estilos.css">
        <link rel="stylesheet" href="../css/multiboton.css">
        <link rel="stylesheet" href="../css/tarjetas.css" />
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,500&display=swap" rel="stylesheet">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
    </head>
    <body>
        <%@include file='header.html' %>
        <%
            Captchas control = new Captchas();
            ArrayList<Captcha> forms = control.obtener_listado();
            if (forms.size() > 0) {

        %>
        <div class="paraFlex">
            <div class="contenedor">
                <%                    for (int i = 0; i < forms.size(); i++) {
                        Captcha fm = forms.get(i);
                %>
                <div class="flip-card-container" style="--hue: 220">
                    <div class="flip-card">
                        <div class="card-front DARK">
                            <figure>
                                <div class="img-bg"></div>
                                <img
                                    src="https://cdn.rsjoomla.com/images/products/header-image-joomla-extension-rsform.png">
                                <figcaption><%out.print(fm.getId());%></figcaption>
                            </figure>
                            <div class="datos">
                                <p><span class="nombre_param">NOMBRE:</span><span class="param"><%out.print(fm.getNombre());%></span></p>
                                <p><span class="nombre_param">VECES:</span><span class="param"><%out.print(fm.getVeces());%></span></p>
                                <p><span class="nombre_param">ACIERTOS:</span><span class="param"><%out.print(fm.getAciertos());%></span></p>
                                <p><span class="nombre_param">FALLOS:</span><span class="param"><%out.print(fm.getFallos());%></span></p>
                                <p><span class="nombre_param">FECHA UTILIZACION:</span><span class="param"><%out.print(fm.getFecha());%></span></p>
                            </div>
                        </div>
                        <div class="card-back DARK ">
                            <figure>
                                <div class="img-bg"></div>
                                <img
                                    src="https://cdn.rsjoomla.com/images/products/header-image-joomla-extension-rsform.png">
                            </figure>
                            <div style="display:grid;grid-template-columns:auto;">
                                <button style="color:yellow;background-color:#414242a6;" onclick="window.location = '../Mostrar?id=<%out.print(fm.getId());%>';">Ver</button>
                            </div>
                            <div class="design-container">
                                <span class="design design--1"></span>
                                <span class="design design--2"></span>
                                <span class="design design--3"></span>
                                <span class="design design--4"></span>
                                <span class="design design--5"></span>
                                <span class="design design--6"></span>
                                <span class="design design--7"></span>
                                <span class="design design--8"></span>
                            </div>
                        </div>
                    </div>
                </div>
                <%}
                } else {%>
                <div class="paraFlex">
                    <img src="../img/svg/025-inbox-1.svg" width="30%" title="Generador" alt="Generador">
                    <h1 style="position: absolute;backdrop-filter: blur(20px);z-index: 20;color:rgb(207, 243, 141);">Aún no has creado ningún formulario</h1>
                </div>
                <%}%>
                <svg id="clouds" xmlns="http://www.w3.org/2000/svg" width="2611.084" height="485.677" viewBox="0 0 2611.084 485.677">
                <title>Gray Clouds Background</title>
                <path id="Path_39" data-name="Path 39"
                      d="M2379.709,863.793c10-93-77-171-168-149-52-114-225-105-264,15-75,3-140,59-152,133-30,2.83-66.725,9.829-93.5,26.25-26.771-16.421-63.5-23.42-93.5-26.25-12-74-77-130-152-133-39-120-212-129-264-15-54.084-13.075-106.753,9.173-138.488,48.9-31.734-39.726-84.4-61.974-138.487-48.9-52-114-225-105-264,15a162.027,162.027,0,0,0-103.147,43.044c-30.633-45.365-87.1-72.091-145.206-58.044-52-114-225-105-264,15-75,3-140,59-152,133-53,5-127,23-130,83-2,42,35,72,70,86,49,20,106,18,157,5a165.625,165.625,0,0,0,120,0c47,94,178,113,251,33,61.112,8.015,113.854-5.72,150.492-29.764a165.62,165.62,0,0,0,110.861-3.236c47,94,178,113,251,33,31.385,4.116,60.563,2.495,86.487-3.311,25.924,5.806,55.1,7.427,86.488,3.311,73,80,204,61,251-33a165.625,165.625,0,0,0,120,0c51,13,108,15,157-5a147.188,147.188,0,0,0,33.5-18.694,147.217,147.217,0,0,0,33.5,18.694c49,20,106,18,157,5a165.625,165.625,0,0,0,120,0c47,94,178,113,251,33C2446.709,1093.793,2554.709,922.793,2379.709,863.793Z"
                      transform="translate(142.69 -634.312)" fill="#eee" />
                </svg>
            </div>
            <script>
                window.onload = function () {
                    $("#titulo").text("listado de captchas");
                }
            </script>
        </div>
    </body>
</html>
