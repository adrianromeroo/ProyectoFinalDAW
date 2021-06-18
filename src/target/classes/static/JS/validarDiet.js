window.onload = iniciar;

function iniciar() {
    document.getElementById("send-diet").addEventListener("click", validar, false);
}

//VALIDACION DEL NAME
function validarName(){

    let name = document.getElementById("name");

    if(name.value === ""){
        alert("El Name no puede estar vacio");
        return false;
    }
    return true;
}

//VALIDACION DE LAS PROTEINAS
function validarProteins(){

    let proteins = document.getElementById("proteins");
    let regexPCF = /^[1-9]{3}$/;

    if(regexPCF.test(proteins.value)){
    	return true;
  	}else{
		alert("El campo proteina no cumple con el pattern: 3 Dígitos del 1-9");
		return false;
  	}
}

//VALIDACION DE LAS PROTEINAS
function validarCarbohydrates(){

    let carbohydrates = document.getElementById("carbohydrates");
    let regexPCF = /^[0-9]{3}$/;

    if(regexPCF.test(carbohydrates.value)){
    	return true;
  	}else{
		alert("El campo carbohydrates no cumple con el pattern: 3 Dígitos del 1-9");
		return false;
  	}
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

  let regexPassword = /^(?=\w*\d)(?=\w*[A-Z])(?=\w*[a-z])\S{8,16}$/g 
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