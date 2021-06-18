function eliminar(id) {
	swal({
		  title: "Estas seguro de Eliminar?",
		  text: "¡Si eliminas no podras revertir los cambios!",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((OK) => {
		  if (OK) {
				$.ajax({
					url:"/delete/"+id,
					success: function(res) {
						consolge.log(res);
				}
				});
		    swal("El usuario ha sido borrado exitosamente", {
		      icon: "success",
		    }).then((ok)=>{
				if(ok){
					location.href="/list";
				}
			});
		  } else {
		    swal("El usuario no ha sido eliminado");
		  }
		});
}


function eliminar_diet(id) {
	swal({
		  title: "Estas seguro de Eliminar?",
		  text: "¡Si eliminas no podras revertir los cambios!",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((OK) => {
		  if (OK) {
				$.ajax({
					url:"/delete-diet/"+id,
					success: function(res) {
						consolge.log(res);
				}
				});
		    swal("La dieta ha sido borrada exitosamente", {
		      icon: "success",
		    }).then((ok)=>{
				if(ok){
					location.href="/list-diets";
				}
			});
		  } else {
		    swal("La dieta no ha sido eliminada");
		  }
		});
}

function eliminar_routine(id) {
	swal({
		  title: "Estas seguro de Eliminar?",
		  text: "¡Si eliminas no podras revertir los cambios!",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((OK) => {
		  if (OK) {
				$.ajax({
					url:"/delete-routine/"+id,
					success: function(res) {
						consolge.log(res);
				}
				});
		    swal("La rutina ha sido borrada exitosamente", {
		      icon: "success",
		    }).then((ok)=>{
				if(ok){
					location.href="/list-routines";
				}
			});
		  } else {
		    swal("La rutina no ha sido eliminada");
		  }
		});
}


function eliminar_trainingplan(id) {
	swal({
		  title: "Estas seguro de Eliminar?",
		  text: "¡Si eliminas no podras revertir los cambios!",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((OK) => {
		  if (OK) {
				$.ajax({
					url:"/delete-trainingplan/"+id,
					success: function(res) {
						consolge.log(res);
				}
				});
		    swal("El plan de entrenamiento ha sido borrado exitosamente", {
		      icon: "success",
		    }).then((ok)=>{
				if(ok){
					location.href="/list-trainingplan";
				}
			});
		  } else {
		    swal("El plan de entrenamiento no ha sido eliminado");
		  }
		});
}