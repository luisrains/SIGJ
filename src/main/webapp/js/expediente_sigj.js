
/*
    Archivo para el manejo de todos los datos relacionados al expediente
*/
$("select[name=materia]").on("change", function(e){
	console.log($('select[name=materia]').val());
	var codigo_materia = $('select[name=materia]').val();
	var web_url = 'materia/obtener_materia';
	var modalSpinner = iniciarSpinner("modal_spinner");
		$.ajax({
			type:"GET",
			url: web_url,
			data: {
				cod_materia : codigo_materia
			}
		}).done(function(json_data){
			var rdinfo = json_data.mapa;
			var selec = $('.selectTipoProceso');
			$('.selectTipoProceso').select2('destroy');
			$('.selectTipoProceso').html('');
			$('.selectTipoProceso').select2();
			$.each(rdinfo.materia.listaProceso, function( index, value ) {
				var o = new Option(value.descripcion, value.id);
				$('.selectTipoProceso').append(o);
			});
			var o = new Option("-Elija una opción", 0);
			o.selected=true;
			$('.selectTipoProceso').append(o);
			$('#selectTipoProceso').removeClass('hidden');
			pararSpinner(modalSpinner);	
		}).fail(function(jqXHR, textStatus){
			console.log("error", textStatus);
			pararSpinner(modalSpinner);	
		});
});

$("select[name=tipoProceso]").on("change", function(e){
	console.log($('select[name=tipoProceso]').val());
	var codigo_proceso = $('select[name=tipoProceso]').val();
	var web_url = 'proceso/obtener_proceso';
	var modalSpinner = iniciarSpinner("modal_spinner");
		$.ajax({
			type:"GET",
			url: web_url,
			data: {
				cod_proceso : codigo_proceso
			}
		}).done(function(json_data){
			var rdinfo = json_data.mapa;
			var selec = $('.selectTipoDemanda');
			$('.selectTipoDemanda').select2('destroy');
			$('.selectTipoDemanda').html('');
			$('.selectTipoDemanda').select2();
			$.each(rdinfo.proceso.listTipoDemanda, function( index, value ) {
				var o = new Option(value.descripcion, value.id);
				$('.selectTipoDemanda').append(o);
			});
			var o = new Option("-Elija una opción", 0);
			o.selected=true;
			$('.selectTipoDemanda').append(o);
			$('#selectTipoDemanda').removeClass('hidden');
			pararSpinner(modalSpinner);	
		}).fail(function(jqXHR, textStatus){
			console.log("error", textStatus);
			pararSpinner(modalSpinner);	
		});
});