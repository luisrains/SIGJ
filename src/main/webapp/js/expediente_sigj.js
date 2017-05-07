
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
			
			//despachos
			$('.selectDespacho').select2('destroy');
			$('.selectDespacho').html('');
			$('.selectDespacho').select2();
			$.each(rdinfo.materia.listaDespacho, function( index, value ) {
				var o = new Option(value.descripcion, value.id);
				$('.selectDespacho').append(o);
			});
			var o = new Option("-Elija una opción", 0);
			o.selected=true;
			$('.selectDespacho').append(o);
			$('#selectDespacho').removeClass('hidden');
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



function openWorkflow(){
	mostrarModalStep();
}

function mostrarModalStep(){
	$('#modalStep').modal("show");
	  var navListItems = $('div.setup-panel div a'),
	          allWells = $('.setup-content'),
	          allNextBtn = $('.nextBtn'),
	  		  allPrevBtn = $('.prevBtn');

	  allWells.hide();

	  navListItems.click(function (e) {
	      e.preventDefault();
	      var $target = $($(this).attr('href')),
	              $item = $(this);

	      if (!$item.hasClass('disabled')) {
	          navListItems.removeClass('btn-primary').addClass('btn-default');
	          $item.addClass('btn-primary');
	          allWells.hide();
	          $target.show();
	          $target.find('input:eq(0)').focus();
	      }
	  });
	  
	  allPrevBtn.click(function(){
	      var curStep = $(this).closest(".setup-content"),
	          curStepBtn = curStep.attr("id"),
	          prevStepWizard = $('div.setup-panel div a[href="#' + curStepBtn + '"]').parent().prev().children("a");

	          prevStepWizard.removeAttr('disabled').trigger('click');
	  });

	  allNextBtn.click(function(){
	      var curStep = $(this).closest(".setup-content"),
	          curStepBtn = curStep.attr("id"),
	          nextStepWizard = $('div.setup-panel div a[href="#' + curStepBtn + '"]').parent().next().children("a"),
	          curInputs = curStep.find("input[type='text'],input[type='url']"),
	          isValid = true;

	      $(".form-group").removeClass("has-error");
	      for(var i=0; i<curInputs.length; i++){
	          if (!curInputs[i].validity.valid){
	              isValid = false;
	              $(curInputs[i]).closest(".form-group").addClass("has-error");
	          }
	      }

	      if (isValid)
	          nextStepWizard.removeAttr('disabled').trigger('click');
	  });

	  $('div.setup-panel div a.btn-primary').trigger('click');

	
}

function agregar_demandado(){
	var seleccion = $('input[name=tipo_cliente]:checked').val();
	var seleccionDT = $("#clienteDT tbody tr.selected td");
	if(seleccionDT != null && seleccionDT != undefined && seleccionDT != ''){
		if(seleccion == 'D'){
			var demandante = new Object();
			demandante.cedula_ruc = $("#clienteDT tbody tr.selected td").eq(1).text();
			demandante.nombre_razon_social = $("#clienteDT tbody tr.selected td").eq(2).text();
			demandante.apellido = $("#clienteDT tbody tr.selected td").eq(3).text();
			demandante.tipo = seleccion;
			$(".demandante").removeClass("hidden");
			$("#o-cedula_demandante").text(demandante.cedula_ruc);
			$("#o-nombre_demandante").text(demandante.nombre_razon_social);
			$("#o-apellido_demandante").text(demandante.apellido);
			$("#o-demandante").text("Demandante");
		}else if(seleccion == 'C'){
			var demandado = new Object();
			demandado.cedula_ruc = $("#clienteDT tbody tr.selected td").eq(1).text();
			demandado.nombre_razon_social = $("#clienteDT tbody tr.selected td").eq(2).text();
			demandado.apellido = $("#clienteDT tbody tr.selected td").eq(3).text();
			demandado.tipo = seleccion;
			
			$(".demandado").removeClass("hidden");
			$("#o-cedula_demandado").text(demandado.cedula_ruc);
			$("#o-nombre_demandado").text(demandado.nombre_razon_social);
			$("#o-apellido_demandado").text(demandado.apellido);
			$("#o-demandado").text("Demandado");
		}else{
			alert("Error no eligio nada");
		}
	}else{
		alert("Error Debe seleccionar un cliente de la tabla");
	}
	
}
function agregar_abogado(){
	var seleccion = $('input[name=tipo_abogado]:checked').val();
	var seleccionDT = $("#abogadoDT tbody tr.selected td");
	if(seleccionDT != null && seleccionDT != undefined && seleccionDT != ''){
		if(seleccion == 'AP'){
			var apoderado = new Object();
			apoderado.cedula_ruc = $("#abogadoDT tbody tr.selected td").eq(1).text();
			apoderado.nombre_razon_social = $("#abogadoDT tbody tr.selected td").eq(2).text();
			apoderado.apellido = $("#abogadoDT tbody tr.selected td").eq(3).text();
			apoderado.tipo = seleccion;
			$(".apoderado").removeClass("hidden");
			$("#o-cedula_apoderado").text(apoderado.cedula_ruc);
			$("#o-nombre_apoderado").text(apoderado.nombre_razon_social);
			$("#o-apellido_apoderado").text(apoderado.apellido);
			$("#o-apoderado").text("Apoderado");
		}else if(seleccion == 'CO'){
			var contraparte = new Object();
			contraparte.cedula_ruc = $("#abogadoDT tbody tr.selected td").eq(1).text();
			contraparte.nombre_razon_social = $("#abogadoDT tbody tr.selected td").eq(2).text();
			contraparte.apellido = $("#abogadoDT tbody tr.selected td").eq(3).text();
			contraparte.tipo = seleccion;
			
			$(".contraparte").removeClass("hidden");
			$("#o-cedula_contraparte").text(contraparte.cedula_ruc);
			$("#o-nombre_contraparte").text(contraparte.nombre_razon_social);
			$("#o-apellido_contraparte").text(contraparte.apellido);
			$("#o-contraparte").text("Contraparte");
		}else{
			alert("Error no eligio nada");
		}
	}else{
		alert("Error Debe seleccionar un cliente de la tabla");
	}
}

function datos_caratula(){
	
	
	
	var expediente = $("#o-nombre_demandante").text() +" "+$("#o-apellido_demandante").text()+" C/ "+ $("#o-nombre_demandado").text() +" "+$("#o-apellido_demandado").text()+" S/ "+ $("select[name=tipoDemanda]").find(":selected").text();
	var juzgado = $("select[name=despacho]").find(":selected").text();
	$("#anho_caract").text($("#anho").val());
	$("#nro_caract").text($("#nroExpediente").val());
	$("#folio_caract").text($("#folio").val());
	$("#expediente_caract").text(expediente);
	$("#juzgado_caract").text(juzgado);
}