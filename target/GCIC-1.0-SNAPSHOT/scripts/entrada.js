/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var ids = [];

function clickOculto() {
    $("#archivo").click();
}

function descargar() {
    var contenido = document.getElementById("contenido-archivo").value;
    if (contenido === '') {
        alert("escribe mas de algo para que pueda ser guardado");
    } else {
        var blob = new Blob([contenido], {type: "text/gcic;charset=utf-8"});
        saveAs(blob, "captcha.gcic");
    }
}

function analizar() {
    var contenido = document.getElementById("contenido-archivo").value;
    if (contenido === '') {
        alert("No puedes mandar a analizar una cadena vacia");
    } else {
        $.ajax({
            type: "POST",
            url: "../Analizar",
            data: {contenido: contenido},
            beforeSend: function () {
            },
            complete: function (data) {
            },
            success: function (data) {
                if (data.includes("ERROR"))
                {
                    window.location = "errores.jsp";
                } else if (data === "CORRECTO") {
                    window.location = "captchas.jsp";
                } else if (data === "REDIRIGIR") {
                    window.location = "captcha.jsp";
                } else if (data === "NO CREADO") {
                    $("#mensaje").html("<h1>El captcha que mandaste ya existe, cambia el id</h1><input type='text'><button class='learn-more'>ENVIAR DE NUEVO</button>");
                    $("#oculto2").show();
                } else if (data.includes("EXISTE")) {
                    console.log(data);
                    var partido = data.split("-");
                    ids = partido[1].split("%");
                    var datalists = document.createElement("datalist");
                    datalists.id ="ids";
                    for (var i = 0; i < ids.length; i++) {
                        var option = document.createElement("option");
                        option.value = ids[i];
                        datalists.appendChild(option);
                    }
                    $("#mensaje").html("<img src=\"../img/svg/120-info.svg\" width=\"80em\" style=\"margin:auto;\" title=\"Informacion\" alt=\"Informacion\">\n\<h1>El captcha que mandaste ya existe, cambia el id</h1><input type='text' id='nuevoinput' list='ids'><button class='learn-more' onclick='analizar_nuevo()'>ENVIAR DE NUEVO</button>");
                    document.getElementById("mensaje").appendChild(datalists);
                    $("#close").html("<img src=\"../img/svg/082-cross-1.svg\" width=\"25px\" title=\"Cerrar\" alt=\"Cerrar\">CERRAR");
                    $("#oculto2").show();
                }
            },
            error: function (data) {
                $("#mensaje").html("<img src=\"../img/svg/120-info.svg\" width=\"25px\" title=\"Informacion\" alt=\"Informacion\"><h1>Ocurrió un error al momento de analizar el archivo</h1><p>Revisa el recorrido del error</p>");
                $("#close").html("<img src=\"../img/svg/082-cross-1.svg\" width=\"25px\" title=\"Cerrar\" alt=\"Cerrar\">CERRAR");
                $("#oculto2").show();
            }
        });
    }
}

function analizar_nuevo() {
    var contenido = document.getElementById("contenido-archivo").value;
    var id = document.getElementById("nuevoinput").value;

    if (id !== '') {
        var boo = false;
        for (var i = 0; i < ids.length; i++) {
            if (ids[i] == id) {
                boo = true;
                break;
            }
        }
        if (boo) {
            alert("Ese id también ya existe");
        } else {
            $("#oculto").hide();
            $.ajax({
                type: "POST",
                url: "../Analizar",
                data: {contenido: contenido, id: id},
                beforeSend: function () {
                },
                complete: function (data) {
                },
                success: function (data) {
                    if (data === "CORRECTO") {
                        window.location = "captchas.jsp";
                    } else if (data === "REDIRIGIR") {
                        window.location = "captcha.jsp";
                    } else if (data === "NO CREADO") {
                        $("#mensaje").html("<h1>El captcha que mandaste ya existe, cambia el id</h1><input type='text'><button class='learn-more'>ENVIAR DE NUEVO</button>");
                        $("#oculto2").show();
                    }
                },
                error: function (data) {
                    $("#mensaje").html("<img src=\"../img/svg/120-info.svg\" width=\"25px\" title=\"Informacion\" alt=\"Informacion\"><h1>Ocurrió un error al momento de analizar el archivo</h1><p>Revisa el recorrido del error</p>");
                    $("#close").html("<img src=\"../img/svg/082-cross-1.svg\" width=\"25px\" title=\"Cerrar\" alt=\"Cerrar\">CERRAR");
                    $("#oculto2").show();
                }
            });
        }
    } else {
        alert("El id tiene que ser un caracter valido, no puede ser un espacio en blanco");
    }
}

function aceptarArchivo() {
    var archivos = document.getElementById("archivo").files;
    if (archivos) {
        if (archivos[0].name.includes("gcic")) {
            let nombre = archivos[0].name;
            let reader = new FileReader();
            reader.onloadend = () => escribir(reader.result, nombre);
            reader.readAsText(archivos[0]);
        } else {
            alert('¡He dicho archivo de texto!');
        }
    } else {
        alert("No se ha ingresado nada");
    }
}

function escribir(contents, nombre) {
    $("#modo").text("ARCHIVO SELECCIONADO: ");
    $("#nombre").text(nombre);
    $("#oculto").fadeIn(1000);
    contenido = contents;
    $("#contenido-archivo").val(contents);
}

function escribiendo(textarea) {
    var textLines = textarea.value.substr(0, textarea.selectionStart).split("\n");
    var currentLineNumber = textLines.length;
    var currentColumnIndex = textLines[textLines.length - 1].length;
    $("#modo").text("ARCHIVO MODIFICADO: ");
    $("#colandline").text("Linea: " + currentLineNumber + ", Columna: " + currentColumnIndex);
}

function nuevo() {
    $("#oculto").fadeOut(1000);
    $("#contenido-archivo").val("");
    var archivos = document.getElementById("archivo");
    archivos.files = null;
    archivos.value = "";
}