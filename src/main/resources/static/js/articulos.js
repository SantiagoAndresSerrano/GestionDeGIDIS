async function listarArticulos(){
    const request = await fetch('api/v1/usuario/articulo', {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    }).then(res => res.json())
        .then(data => {
            if(data == null){
                document.getElementById("tbody").innerHTML = "<td>No hay artículos disponibles</td>"
            }
            else{
                document.getElementById("tbody").innerHTML = ""
                for (let i = 0; i < data.length; i++){
                    let titulo = data[i].titulo
                    let ciudad = data[i].ciudad
                    let coautores = data[i].coautores
                    let digitalObjectIdentifierDOI = data[i].digitalObjectIdentifierDOI

                    document.getElementById("tbody").innerHTML +=
                        ` <tr>
        <td>${titulo}</td>
        <td>${ciudad}</td>
        <td>${coautores}</td>
        <td>${digitalObjectIdentifierDOI}</td>
      </tr>
        `
                }

            }

        });
}

listarArticulos()


async function registroArticulo() {
    let data = {};

    data.titulo = document.getElementById('titulo').value;
    data.coautores = document.getElementById('coautores').value;
    data.nombreRevista = document.getElementById('nombreRevista').value;
    data.fasciculoRevista = document.getElementById('fasciculoRevista').value;
    data.ciudad = document.getElementById('ciudad').value;
    data.serieRevista = document.getElementById('serieRevista').value;
    data.digitalObjectIdentifierDOI = document.getElementById('digitalObjectIdentifierDOI').value;
    data.medioDivulgacion = document.getElementById('medioDivulgacion').value;
    data.idioma = document.getElementById('idioma').value;
    data.volumen = document.getElementById('volumen').value;
    data.tipoArticulo = document.getElementById('tipoArticulo').value;
    data.paginaInicial = document.getElementById('paginaInicial').value;
    data.paginaFinal = document.getElementById('paginaFinal').value;


    const request = await fetch('/api/v1/articulo/guardar', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    }).then(res => res.json())
        .then(data => {
            if (data.guardo) {
                alert("Artículo Registrado");
                window.location.href = '../viewArticulos.html';
            }
            else
                alert("No se registró");
        }).catch( err => {
            alert("Error de registro.");
        });


}