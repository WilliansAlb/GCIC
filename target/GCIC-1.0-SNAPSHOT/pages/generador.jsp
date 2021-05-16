<%-- 
    Document   : generador
    Created on : 25/04/2021, 12:34:15
    Author     : willi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GCIC</title>
        <link rel="shortcut icon" type="image/ico" href="../img/088-cube.ico"/>
        <link rel="stylesheet" href="../css/estilos.css">
        <link rel="stylesheet" href="../css/multiboton.css">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,500&display=swap" rel="stylesheet">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
        <script src="../scripts/entrada.js" type="text/javascript"></script>
    </head>
    <body>
        <%@include file='header.html' %>
        <div class="main">
            <div class="multi-button">
                <button class="learn-more" onclick="nuevo()">NUEVO</button>
                <button class="learn-more" onclick="clickOculto()">ABRIR ARCHIVO</button>
                <button class="learn-more">GUARDAR COMO</button>
                <button class="learn-more"><svg class="material-icons" xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"><g class="search-path" fill="none" stroke="#000000"><path stroke-linecap="square" d="M18.5 18.3l-5.4-5.4"/><circle cx="8" cy="8" r="7"/></g></svg>
                    ANALIZAR</button>
            </div>
            <h3 hidden id="oculto"></h3>
            <div class="textarea-wrapper" >
                <textarea rows="25" cols="40" id="contenido-archivo" onkeypress="escribiendo()"></textarea>
            </div>
        </div>
        <input type="file" id="archivo" accept=".gcic" hidden="true" onchange="aceptarArchivo()">

        <svg id="clouds" xmlns="http://www.w3.org/2000/svg" width="2611.084" height="485.677" viewBox="0 0 2611.084 485.677">
        <title>Gray Clouds Background</title>
        <path id="Path_39" data-name="Path 39"
              d="M2379.709,863.793c10-93-77-171-168-149-52-114-225-105-264,15-75,3-140,59-152,133-30,2.83-66.725,9.829-93.5,26.25-26.771-16.421-63.5-23.42-93.5-26.25-12-74-77-130-152-133-39-120-212-129-264-15-54.084-13.075-106.753,9.173-138.488,48.9-31.734-39.726-84.4-61.974-138.487-48.9-52-114-225-105-264,15a162.027,162.027,0,0,0-103.147,43.044c-30.633-45.365-87.1-72.091-145.206-58.044-52-114-225-105-264,15-75,3-140,59-152,133-53,5-127,23-130,83-2,42,35,72,70,86,49,20,106,18,157,5a165.625,165.625,0,0,0,120,0c47,94,178,113,251,33,61.112,8.015,113.854-5.72,150.492-29.764a165.62,165.62,0,0,0,110.861-3.236c47,94,178,113,251,33,31.385,4.116,60.563,2.495,86.487-3.311,25.924,5.806,55.1,7.427,86.488,3.311,73,80,204,61,251-33a165.625,165.625,0,0,0,120,0c51,13,108,15,157-5a147.188,147.188,0,0,0,33.5-18.694,147.217,147.217,0,0,0,33.5,18.694c49,20,106,18,157,5a165.625,165.625,0,0,0,120,0c47,94,178,113,251,33C2446.709,1093.793,2554.709,922.793,2379.709,863.793Z"
              transform="translate(142.69 -634.312)" fill="#eee" />
        </svg>

        <script>
            window.onload = function () {
                $("#titulo").text("generador de captchas");
            }
        </script>
    </body>
</html>
