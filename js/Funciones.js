function traerInformacionclientes() {
  $.ajax({
    type: "GET",
    dataType: "JSON",
    url: "https://g49c788dd9bbbcb-ks5gdymlqj9nwru5.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/client/client",
    success: function (datos) {
      console.log(datos);
      pintarTablaclientes(datos.items);
    },
    error: function (xhr, status) {
      console.log("ha sucedido un problema111");
    },
    complete: function (xhr, status) {
      console.log("peticion realizada");
    },
  });
}

function pintarTablaclientes(items) {
  let misDatos =
    "<table border=1 align='center'><thead><tr><th>ID</th><th>Nombre</th><th>Correo</th><th>Edad</th><th>Eliminar</th></tr></thead>";
  for (i = 0; i < items.length; i++) {
    misDatos += "<tr>";
    misDatos += "<td>" + items[i].id + "</td>";
    misDatos += "<td>" + items[i].name + "</td>";
    misDatos += "<td>" + items[i].email + "</td>";
    misDatos += "<td>" + items[i].age + "</td>";
    misDatos += "<td><button onclick='borrarElementoclientes(" +items[i].id +")' id='borrar'>Eliminar</button></td>";
    misDatos += "</tr>";
  }
  misDatos += "</table>";
  $("#datosclientes").append(misDatos);
}

function guardarinformacionclientes() {
  let myData = {
    id:$("#idcliente").val(),
    name:$("#namecliente").val(),
    email:$("#email").val(),
    age:$("#age").val(),
  };
  console.log(myData);
  $.ajax({
    url: "https://g49c788dd9bbbcb-ks5gdymlqj9nwru5.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/client/client",
    type: "POST",
    data: myData,
    success: function (dat) {
      $("#datosclientes").empty();
      $("#idcliente").val("");
      $("#namecliente").val("");
      $("#email").val("");
      $("#age").val("");
      traerInformacionclientes();
      alert("Dato guardado");
    },
    error: function (xhr, status) {
      console.log("error al guardar");
    },
    complete: function (xhr, status) {
      console.log("peticion realizada guardar");
    }
  });
}

function editarinformacionclientes() {
  let myData = {
    id: $("#idcliente").val(),
    name: $("#namecliente").val(),
    email: $("#email").val(),
    age: $("#age").val(),
  };
  let dataToSend = JSON.stringify(myData);
  $.ajax({
    type: "PUT",
    url: "https://g49c788dd9bbbcb-ks5gdymlqj9nwru5.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/client/client",
    data: dataToSend,
    contentType: "application/JSON",
    success: function (dat) {
      $("#datosclientes").empty();
      $("#idcliente").val("");
      $("#namecliente").val("");
      $("#email").val("");
      $("#age").val("");
      traerInformacionclientes();
      alert("se ha Actualizado");
    },
  });
}

function borrarElementoclientes(idElemento) {
  let myData = {
    id: idElemento,
  };
  let dataToSend = JSON.stringify(myData);
  $.ajax({
    type: "DELETE",
    dataType: "JSON",
    url: "https://g49c788dd9bbbcb-ks5gdymlqj9nwru5.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/client/client",
    data: dataToSend,
    contentType: "application/JSON",
    success: function (datos) {
      $("#datosclientes").empty();
      traerInformacionclientes();
      alert("se ha Eliminado");
    },
  });
}

function traerInformacionmensajes() {
  $.ajax({
    type: "GET",
    dataType: "JSON",
    url: "https://g49c788dd9bbbcb-ks5gdymlqj9nwru5.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/message/message",
    success: function (datos) {
      console.log(datos);
      pintarTablamensajes(datos.items);
    },
    error: function (xhr, status) {
      console.log("ha sucedido un problema111");
    },
    complete: function (xhr, status) {
      console.log("peticion realizada");
    },
  });
}

function pintarTablamensajes(items) {
  let misDatos =
    "<table border=1 align='center'><thead><tr><th>ID</th><th>Mensaje</th><th>Eliminar</th></tr></thead>";
  for (i = 0; i < items.length; i++) {
    misDatos += "<tr>";
    misDatos += "<td>" + items[i].id + "</td>";
    misDatos += "<td>" + items[i].messagetext + "</td>";
    misDatos += "<td><button onclick='borrarElementomensajes(" +items[i].id +")' id='borrar'>Eliminar</button></td>";
    misDatos += "</tr>";
  }
  misDatos += "</table>";
  $("#datosmensajes").append(misDatos);
}

function guardarinformacionmensajes() {
  let myData = {
    id: $("#idmensajes").val(),
    messagetext:$("#messagetext").val(),
  };
  console.log(myData);
  $.ajax({
    url: "https://g49c788dd9bbbcb-ks5gdymlqj9nwru5.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/message/message",
    type: "POST",
    data: myData,
    success: function (dat) {
      $("#datosmensajes").empty();
      $("#idmensajes").val("");
      $("#messagetext").val("");
      traerInformacionmensajes();
      alert("Dato guardado");
    },
    error: function (xhr, status) {
      console.log("error al guardar");
    },
    complete: function (xhr, status) {
      console.log("peticion realizada guardar");
    }
  });
}

function editarinformacionmensajes() {
  let myData = {
    id: $("#idmensajes").val(),
    messagetext: $("#messagetext").val(),  
  };
  let dataToSend = JSON.stringify(myData);
  $.ajax({
    type: "PUT",
    url: "https://g49c788dd9bbbcb-ks5gdymlqj9nwru5.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/message/message",
    data: dataToSend,
    contentType: "application/JSON",
    success: function (dat) {
      $("#datosmensajes").empty();
      $("#idmensajes").val("");
      $("#messagetext").val("");
      traerInformacionmensajes();
      alert("se ha Actualizado");
    },
  });
}

function borrarElementomensajes(idElemento) {
  let myData = {
    id: idElemento,
  };
  let dataToSend = JSON.stringify(myData);
  $.ajax({
    type: "DELETE",
    dataType: "JSON",
    url: "https://g49c788dd9bbbcb-ks5gdymlqj9nwru5.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/message/message",
    data: dataToSend,
    contentType: "application/JSON",
    success: function (datos) {
      $("#datosmensajes").empty();
      traerInformacionmensajes();
      alert("se ha Eliminado");
    },
  });
}

function traerInformacionherramienta() {
  $.ajax({
    type: "GET",
    dataType: "JSON",
    url: "http://localhost:8080/api/Tool/all",
    success: function (datos) {
      console.log(datos);
      pintarTablaherramienta(datos);
    },
    error: function (xhr, status) {
      console.log("ha sucedido un problema111");
    },
    complete: function (xhr, status) {
      console.log("peticion realizada");
    },
  });
}

function pintarTablaherramienta(items) {
  let misDatos =
    "<table class='table mt-5' border=1 align='center'><thead><tr><th>ID</th><th>Marca</th><th>Modelo</th><th>Categoria</th><th>Nombre</th><th colipan='2'>Acciones</th></tr></thead>";
  for (i = 0; i < items.length; i++) {
    misDatos += "<tr>";
    misDatos += "<td>" + items[i].id + "</td>";
    misDatos += "<td>" + items[i].brand + "</td>";
    misDatos += "<td>" + items[i].model + "</td>";
    misDatos += "<td>" + items[i].category.name + "</td>";
    misDatos += "<td>" + items[i].name + "</td>";
    misDatos +="<td><a href = '#' class = 'btn btn-success' data-bs-toggle='modal' data-bs-target='#modalEditar' onclick='editar("+items[i].id+");'>Editar</a></td>";
    misDatos +="<td><a href = '#' class = 'btn btn-danger' onclick='eliminar("+items[i].id+");'>Eliminar</a></td>";
    misDatos += "</tr>";
  }
  misDatos += "</table>";
  $("#datosherramienta").append(misDatos);
}

function guardarinformacionherramienta() {
  let myData = {
    brand: $("#marca").val(),
    model: $("#modelo").val(),
    category_id: $("#categoria").val(),
    name:$("#nameherramienta").val(),
  };
  console.log(myData);
  $.ajax({
    url: "http://localhost:8080/api/Tool/save",
    type: "POST",
    data: myData,
    success: function (dat) {
   
      traerInformacionherramienta();

      alert("Dato guardado");
    },
    error: function (xhr, status) {
      console.log("error al guardar");
    },
    complete: function (xhr, status) {
      console.log("peticion realizada guardar");
    }
  });
}

function editarinformacionherramienta() {
  let myData = {
    id: $("#idherramienta").val(),
    brand: $("#marca").val(),
    model: $("#modelo").val(),
    category_id: $("#categoria").val(),
    name:$("#nameherramienta").val(),
  };
  let dataToSend = JSON.stringify(myData);
  $.ajax({
    type: "PUT",
    url: "https://g49c788dd9bbbcb-ks5gdymlqj9nwru5.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/tool/tool",
    data: dataToSend,
    contentType: "application/JSON",
    success: function (dat) {
      $("#datosherramienta").empty();
      $("#idherramienta").val("");
      $("#marca").val("");
      $("#modelo").val("");
      $("#categoria").val("");
      $("#nameherramienta").val("");  
      traerInformacionherramienta();
      alert("se ha Actualizado");
    },
  });
}

function borrarElementoherramienta(idElemento) {
  let myData = {
    id: idElemento,
  };
  let dataToSend = JSON.stringify(myData);
  $.ajax({
    type: "DELETE",
    dataType: "JSON",
    url: "https://g49c788dd9bbbcb-ks5gdymlqj9nwru5.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/tool/tool",
    data: dataToSend,
    contentType: "application/JSON",
    success: function (datos) {
      $("#datosherramienta").empty();
      traerInformacionherramienta();
      alert("se ha Eliminado");
    },
  });
}