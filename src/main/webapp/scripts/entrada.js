/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function clickOculto() {
    $("#archivo").click();
}

function aceptarArchivo() {
    var archivos = document.getElementById("archivo").files;
    if (archivos) {
        if (archivos[0].name.includes("gcic")) {
            let nombre = archivos[0].name;
            let reader = new FileReader();
            reader.onloadend = () => escribir(reader.result,nombre);
            reader.readAsText(archivos[0]);
        } else {
            alert('¡He dicho archivo de texto!');
        }
    } else {
        alert("No se ha ingresado nada");
    }
}

function escribir(contents, nombre){
    $("#oculto").text("ARCHIVO SELECCIONADO: "+nombre);
    $("#oculto").fadeIn(1000);
    $("#contenido-archivo").val(contents);
}

function escribiendo(){
    $("#oculto").fadeOut(1000);
}

function nuevo(){
    $("#oculto").fadeOut(1000);
    $("#contenido-archivo").val("");
}