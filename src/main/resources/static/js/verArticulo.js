async function verArticulo(){
    const datosURL = window.location.search;
    const urlParams = new URLSearchParams(datosURL);
    let id = urlParams.get('id');
    const request = await fetch(`/api/v1/articulo/${id}`, {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
    })
    const res = await request.json();
    if(!res){
        document.getElementById("tbody").innerHTML = "<td>No hay artículos disponibles</td>"
    }
    else{
        console.log(res)
        document.getElementById("tbody").innerHTML = ""
        for (let i = 0; i < res.length; i++){
            let titulo = res[i].titulo
            let ciudad = res[i].ciudad
            let coautores = res[i].coautores
            let digitalObjectIdentifierDOI = res[i].digitalObjectIdentifierDOI
            let id = res[i].id

            document.getElementById("tbody").innerHTML +=
                ` <tr>
        <td>${titulo}</td>
        <td>${ciudad}</td>
        <td>${coautores}</td>
        <td>${digitalObjectIdentifierDOI}</td>
        <td>
          <div class="dropdown show">
            <a class="btn dropdown-toggle" src="img/puntos.png" href="#" role="button" id="desplegable"
              data-toggle="dropdown" aria-haspopup="true">
              <img src="../img/puntos.png" class="align-right" height="30px" width="30px">
            </a>



            <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                <a class="dropdown-item" data-toggle="modal" style="background-color:#FFFFFF" id="btn-abrir-popup3"
                href="verArticulo.html">Ver</a>
              <a class="dropdown-item" onclick="eliminarArticulo('${id}')" data-toggle="modal" style="background-color:#FFFFFF"
                >Eliminar</a>
              <a class="dropdown-item" onclick="editarArticulo('${id}')" data-toggle="modal" style="background-color:#FFFFFF" id="btn-abrir-popup2"
                href="editarArticulo.html">Editar</a>
              
            </div>
          </div>
        </td>

      </tr>
        `
        }

    }

}
verArticulo()