/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        $("#formulario").submit();
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