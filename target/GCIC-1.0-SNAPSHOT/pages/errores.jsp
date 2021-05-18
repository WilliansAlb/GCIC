<%-- 
    Document   : errores
    Created on : 16/05/2021, 22:20:08
    Author     : willi
--%>

<%@page import="POJOS.Errores"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Errores</title>
        <link rel="shortcut icon" type="image/ico" href="../img/088-cube.ico"/>
        <link rel="stylesheet" href="../css/estilos.css">
        <link rel="stylesheet" href="../css/multiboton.css">
        <link rel="stylesheet" href="../css/tabla.css">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,500&display=swap" rel="stylesheet">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
        <script src="../scripts/entrada.js" type="text/javascript"></script>
        <script src="../scripts/FileSaver.js" type="text/javascript"></script>
        <style>
            .fl-table{
                white-space: pre-wrap;
                color: rgb(215,255,144);
            }
        </style>
    </head>
    <body>
        <%@include file='header.html' %>
        <%
            HttpSession s = request.getSession();
            ArrayList<Errores> listado = (ArrayList<Errores>) s.getAttribute("errores");
            if (!listado.isEmpty()) {
                String prueba = s.getAttribute("texto").toString();
        %>
        <div id="contenedor" class="main">
            <button id="agenerar" class="learn-more" style="width: fit-content; margin: auto; margin-bottom: 20px;" onclick="window.location = 'generador.jsp';"><img src="../img/svg/027-clipboard-1.svg" width="25px" title="Generador" alt="Generador"><span id="rep">REGRESAR A GENERADOR</span></button>
            <h1 id="descripcion">Datos error actual</h1>
            <div class="table-wrapper">
                <table class="fl-table" style="background-color: transparent;">
                    <thead>
                        <tr>
                            <th></th>
                            <th>ERROR</th>
                            <th>LEXEMA</th>
                            <th>TIPO</th>
                            <th>LINEA</th>
                            <th>COLUMNA</th>
                            <th>DESCRIPCION</th>
                            <th>SOLUCIÓN</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td style="width: fit-content;"><button class="learn-more" style="margin-bottom: 1em;" onclick="atras()">Anterior</button></td>
                            <td id="error_e">1 de <%out.print(listado.size());%></td>
                            <td id="lex_e"><%out.print(listado.get(0).getLexema());%></td>
                            <td id="tipo_e"><%out.print(listado.get(0).getTipo());%></td>
                            <td id="linea_e"><%out.print(listado.get(0).getLinea());%></td>
                            <td id="columna_e"><%out.print(listado.get(0).getColumna());%></td>
                            <td id="descripcion_e"><%out.print(listado.get(0).getDescripcion());%></td>
                            <td id="solucion_e"><%out.print(listado.get(0).getSolucion());%></td>
                            <td style="border-right: none; width: fit-content;"><button style="margin-bottom: 1em;" class="learn-more" onclick="siguiente()">Siguiente</button></td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div class="textarea-wrapper" >
                <textarea readonly rows="25" cols="40" id="contenido-archivo" onkeypress="escribiendo(this)" onclick="getLineNumberAndColumnIndex(this)"><%out.print(prueba);%></textarea>
            </div>
            <div id="abajo">
                <p hidden id="oculto"><span id="modo"></span><span id="nombre"></span></p>
                <p id="colandline">Linea: 0 - Columna: 0</p>
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
            var pos = 0;
            var lexemas = [
            <%for (int i = 0; i < listado.size(); i++) {
                    if (i == listado.size() - 1) {
                        out.print("\"" + listado.get(i).getLexema() + "\"");
                    } else {
                        out.print("\"" + listado.get(i).getLexema() + "\",");
                    }
                }
            %>];
            var tipos = [
            <%for (int i = 0; i < listado.size(); i++) {
                    if (i == listado.size() - 1) {
                        out.print("\"" + listado.get(i).getTipo() + "\"");
                    } else {
                        out.print("\"" + listado.get(i).getTipo() + "\",");
                    }
                }
            %>];
            var lineas = [
            <%for (int i = 0; i < listado.size(); i++) {
                    if (i == listado.size() - 1) {
                        out.print(listado.get(i).getLinea());
                    } else {
                        out.print(listado.get(i).getLinea() + ",");
                    }
                }
            %>];
            var columnas = [
            <%for (int i = 0; i < listado.size(); i++) {
                    if (i == listado.size() - 1) {
                        out.print(listado.get(i).getColumna());
                    } else {
                        out.print(listado.get(i).getColumna() + ",");
                    }
                }
            %>];
            var descripciones = [
            <%for (int i = 0; i < listado.size(); i++) {
                    if (i == listado.size() - 1) {
                        out.print("\"" + listado.get(i).getDescripcion() + "\"");
                    } else {
                        out.print("\"" + listado.get(i).getDescripcion() + "\",");
                    }
                }
            %>];
            var soluciones = [
            <%for (int i = 0; i < listado.size(); i++) {
                    if (i == listado.size() - 1) {
                        out.print("\"" + listado.get(i).getSolucion() + "\"");
                    } else {
                        out.print("\"" + listado.get(i).getSolucion() + "\",");
                    }
                }
            %>];

            window.onload = function () {
                $("#titulo").text("reporte de errores");
            };

            function atras() {
                pos--;
                if (pos < 0) {
                    pos = tipos.length - 1;
                }
                var res = (pos + 1) + " de " + tipos.length;
                $("#error_e").text(res);
                $("#lex_e").text(lexemas[pos]);
                $("#tipo_e").text(tipos[pos]);
                $("#linea_e").text(lineas[pos]);
                $("#columna_e").text(columnas[pos]);
                $("#descripcion_e").text(descripciones[pos]);
                $("#solucion_e").text(soluciones[pos]);
                resaltar(lineas[pos], columnas[pos], lexemas[pos], tipos[pos]);
            }

            function siguiente() {
                pos++;
                if (pos === tipos.length) {
                    pos = 0;
                }
                var res = (pos + 1) + " de " + tipos.length;
                $("#error_e").text(res);
                $("#lex_e").text(lexemas[pos]);
                $("#tipo_e").text(tipos[pos]);
                $("#linea_e").text(lineas[pos]);
                $("#columna_e").text(columnas[pos]);
                $("#descripcion_e").text(descripciones[pos]);
                $("#solucion_e").text(soluciones[pos]);
                resaltar(lineas[pos], columnas[pos], lexemas[pos], tipos[pos]);
            }

            function getLineNumberAndColumnIndex(textarea) {
                var textLines = textarea.value.substr(0, textarea.selectionStart).split("\n");
                var currentLineNumber = textLines.length;
                var currentColumnIndex = textLines[textLines.length - 1].length;
                $("#colandline").text("Linea: " + currentLineNumber + ", Columna: " + (currentColumnIndex + 1));
            }

            function resaltar(linea, columna, palabra, tipoe) {
                var textarea = document.getElementById("contenido-archivo").value;
                var textLines = textarea.split("\n");
                var i = 0;
                var total = 0;
                if (tipoe === 'Semantico') {
                    if (linea > 1) {
                        for (i = 0; i < linea-1; i++) {
                            total += textLines[i].length;
                        }
                        total+= i;
                        document.getElementById("contenido-archivo").focus();
                        document.getElementById("contenido-archivo").setSelectionRange(total, total + columna);
                        $("#colandline").text("Linea: " + linea + ", Columna: " + columna);
                    } else {
                        total = textLines[0].length;
                        document.getElementById("contenido-archivo").focus();
                        document.getElementById("contenido-archivo").setSelectionRange(0, total);
                        $("#colandline").text("Linea: " + linea + ", Columna: " + columna);
                    }
                } else {
                    if (linea !== 0) {
                        for (i = 0; i < linea - 1; i++) {
                            total += textLines[i].length;
                        }
                        total += i + (columna - 1);
                    } else {
                        total = columna - 1;
                    }
                    var suma = palabra.length;
                    document.getElementById("contenido-archivo").focus();
                    document.getElementById("contenido-archivo").setSelectionRange(total, total + suma);
                    $("#colandline").text("Linea: " + linea + ", Columna: " + columna);
                }
            }
        </script>
        <%} else {
                response.sendRedirect("http://localhost:8080/GCIC/pages/generador.jsp");
            }%>
    </body>
</html>
