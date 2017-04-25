
/*
    Archivo para el manejo de todos los datos relacionados al expediente
*/
$("select[name=materia]").on("change", function(e){
	console.log($('select[name=materia]').val());
	var codigo_materia = $('select[name=materia]').val();
	var web_url = 'materia/obtener_materia';
		$.ajax({
			type:"GET",
			url: web_url,
			data: {
				cod_materia : codigo_materia
			}
		}).done(function(json_data){
			var rdinfo = json_data.mapa;
			var selec = $('.selectTipoProceso');
			var codigos = [];
			
			console.log(rdinfo);
			console.log(rdinfo.materia);
			var dataArray = [];
			$('.selectTipoProceso').select2('destroy');
			$('.selectTipoProceso').html('');
			$('.selectTipoProceso').select2();
			$.each(rdinfo.materia.listaProceso, function( index, value ) {
				var o = new Option(value.descripcion, value.id);
				$('.selectTipoProceso').append(o);
			});
			var o = new Option("-Elija una opción", 0);
			$('.selectTipoProceso').append(o);
		}).fail(function(jqXHR, textStatus){
			console.log("error", textStatus);
		});
	
//	$('#materia').find('option:first').text("Seleccione un plazo de cuota");
//	$('#materia').trigger("change");
});