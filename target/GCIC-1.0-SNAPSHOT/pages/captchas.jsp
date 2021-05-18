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
        <link rel="stylesheet" href="../css/tabla.css" />
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,500&display=swap" rel="stylesheet">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
        <script src="https://cdn.jsdelivr.net/npm/chart.js@latest/dist/Chart.min.js"></script>
    </head>
    <body>
        <%@include file='header.html' %>
        <%
            Captchas control = new Captchas();
            ArrayList<Captcha> forms = control.obtener_listado();
        %>
        <div class="main">
            <%
                if (forms.size() > 0) {
            %>
            <div class="linea" style="margin: auto;">
                <button id="reporte" class="learn-more" style="width: fit-content; margin: auto; margin-bottom: 20px;" onclick="mostrar()"><img src="../img/svg/059-file.svg" width="25px" title="Generador" alt="Generador"><span id="rep">VER REPORTE</span></button>
                <div id="tabla" hidden>
                    <h3 style="text-align:center;color:rgb(215,255,144);"><img src="../img/svg/081-chart.svg" width="25px" title="Generador" alt="Generador" style="display:inline-block;vertical-align: middle;">Estadisticas</h3>
                    <div style="width: 100%; margin:auto">
                        <canvas id="grafica" style="background-color:white;border-radius: 10px;"></canvas>
                    </div>
                    <hr>
                    <h3 style="text-align:center;color:rgb(215,255,144);"><img src="../img/svg/027-clipboard-1.svg" width="25px" title="Generador" alt="Generador" style="display:inline-block;vertical-align: middle;">Tabla de datos</h3>
                    <div class="table-wrapper">
                        <table class="fl-table">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>NOMBRE</th>
                                    <th>UTILIZACION</th>
                                    <th>ACIERTOS</th>
                                    <th>FALLOS</th>
                                    <th>FECHA</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%for (int i = 0; i < forms.size(); i++) {
                                        Captcha fm = forms.get(i);
                                %>
                                <tr>
                                    <td><%out.print(fm.getId());%></td>
                                    <td><%out.print(fm.getNombre());%></td>
                                    <td><%out.print(fm.getVeces());%></td>
                                    <td><%out.print(fm.getAciertos());%></td>
                                    <td><%out.print(fm.getFallos());%></td>
                                    <td><%out.print(fm.getFecha());%></td>
                                </tr>
                                <%}%>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <h2 style="text-align: center;color: rgb(215,255,144);">LISTADO DE CAPTCHAS GENERADOS</h2>
            <div class="paraFlex">
                <div class="contenedor">
                    <%                    for (int i = 0; i < forms.size(); i++) {
                            Captcha fm = forms.get(i);
                    %>
                    <div id="<%out.print(fm.getId());%>" class="flip-card-container" style="--hue: 220">
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
                                    <p><span class="nombre_param">LINK:</span><span class="param">http://localhost:8080/GCIC/Mostrar?id=<%out.print(fm.getId());%></span></p>
                                </div>
                            </div>
                            <div class="card-back DARK ">
                                <figure>
                                    <div class="img-bg"></div>
                                    <img
                                        src="https://cdn.rsjoomla.com/images/products/header-image-joomla-extension-rsform.png">
                                </figure>
                                <div style="display:grid;grid-template-columns:auto;">
                                    <button class="atras" style="color:yellow;background-color:#414242a6;" onclick="window.location = '../Mostrar?id=<%out.print(fm.getId());%>';">http://localhost:8080/GCIC/Mostrar?id=<%out.print(fm.getId());%></button>
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
                    <%}%>
                    <%
                    } else {%>
                    <div class="paraFlex" style="margin-top:11%;">
                        <img src="../img/svg/025-inbox-1.svg" width="30%" title="Generador" alt="Generador">
                        <h1 style="position: absolute;backdrop-filter: blur(20px);z-index: 20;color:rgb(207, 243, 141);">Aún no has creado ningún formulario</h1>                        
                    </div>
                    <button id="agenerar" class="learn-more" style="width: fit-content; margin: auto; margin-top: 20px;" onclick="window.location = 'generador.jsp';"><img src="../img/svg/059-file.svg" width="25px" title="Generador" alt="Generador"><span id="rep">IR A GENERAR CAPTCHA</span></button>
                    <%}%>

                </div>
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
                function mostrar() {
                    var tabla = document.getElementById('tabla');
                    if (tabla.hidden === true) {
                        tabla.hidden = false;
                        $("#rep").text("OCULTAR REPORTE");
                    } else {
                        tabla.hidden = true;
                        $("#rep").text("VER REPORTE");
                    }
                }
                <%
                    if (forms.size() > 0) {
                %>
                const $grafica = document.querySelector("#grafica");
// Las etiquetas son las que van en el eje X. 
                const etiquetas = [<%for (int i = 0; i < forms.size(); i++) {
                    if (i == forms.size() - 1) {
                        out.print("\"" + forms.get(i).getNombre() + "\"");
                    } else {
                        out.print("\"" + forms.get(i).getNombre() + "\",");
                    }
                }
                %>];
                new Chart($grafica, {
                    type: 'bar', // Tipo de gráfica
                    data: {
                        labels: etiquetas,
                        datasets: [{
                                label: "Utilizacion",
                                data: [<%for (int i = 0; i < forms.size(); i++) {
                                    if (i == forms.size() - 1) {
                                        out.print(forms.get(i).getVeces());
                                    } else {
                                        out.print(forms.get(i).getVeces() + ",");
                                    }
                                }
                %>], // La data es un arreglo que debe tener la misma cantidad de valores que la cantidad de etiquetas
                                backgroundColor: 'rgba(215,255,144,0.5)', // Color de fondo
                                borderColor: 'rgba(54, 162, 235, 1)', // Color del borde
                                borderWidth: 1, // Ancho del borde
                            },
                            {
                                label: "Aciertos",
                                data: [<%for (int i = 0; i < forms.size(); i++) {
                                    if (i == forms.size() - 1) {
                                        out.print(forms.get(i).getAciertos());
                                    } else {
                                        out.print(forms.get(i).getAciertos() + ",");
                                    }
                                }
                %>], // La data es un arreglo que debe tener la misma cantidad de valores que la cantidad de etiquetas
                                backgroundColor: 'rgba(255,0,0,0.5)', // Color de fondo
                                borderColor: 'rgba(54, 162, 235, 1)', // Color del borde
                                borderWidth: 1, // Ancho del borde
                            },
                            {
                                label: "Fallos",
                                data: [<%for (int i = 0; i < forms.size(); i++) {
                                    if (i == forms.size() - 1) {
                                        out.print(forms.get(i).getFallos());
                                    } else {
                                        out.print(forms.get(i).getFallos() + ",");
                                    }
                                }
                %>], // La data es un arreglo que debe tener la misma cantidad de valores que la cantidad de etiquetas
                                backgroundColor: 'rgba(0,0,0,0.5)', // Color de fondo
                                borderColor: 'rgba(54, 162, 235, 1)', // Color del borde
                                borderWidth: 1, // Ancho del borde
                            }
                        ]
                    },
                    options: {
                        scales: {
                            yAxes: [{
                                    ticks: {
                                        beginAtZero: true
                                    }
                                }],
                        },
                    }
                });
                <%}%>
            </script>
        </div>
    </body>
</html>
