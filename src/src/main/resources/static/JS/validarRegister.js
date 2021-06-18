window.onload = iniciar;

function iniciar() {
    document.getElementById("send").addEventListener("click", validar, false);
}

//VALIDACION DEL FIRSTNAME
function validarfirstName(){

    let firstName = document.getElementById("name");

    if(firstName.value === ""){
        alert("El FirstName no puede estar vacio");
        return false;
    }
    return true;
}

//VALIDACION DEL LASTNAME
function validarlastName(){

    let lastName = document.getElementById("lastName");

    if(lastName.value === ""){
        alert("El LastName no puede estar vacio");           
        return false;
    }
    return true;
}

//VALIDACION DEL USERNAME
function validaruserName(){

    let username = document.getElementById("username");

    if(username.value === ""){
        alert("El Username no puede estar vacio");         
        return false;
    }
    return true;
}

//VALIDACION DE LA EDAD
function validarAge(){

    let age = document.getElementById("age");

    if(age.value === ""){
        alert("El Age no puede estar vacio");         
        return false;
    }
    return true;
}

//VALIDACION DEL PASSWORD
function validarPassword(){

  let regexPassword = /^(?=\w*\d)(?=\w*[A-Z])(?=\w*[a-z])\S{8,16}$/g;
  let password = document.getElementById("password");

  if(regexPassword.test(password.value)){
      return true;
  }else{
      alert("La contraseña no cumple las condiciones");
      return false;
  }
}

function validar(e) {
    if (validarfirstName()  && validarlastName() && validaruserName() && 
		validarAge() && validarPassword() && confirm("Desea enviar estos datos")) {
      return true;
    } else {
      e.preventDefault();
      return false;
    }
}