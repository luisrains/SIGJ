function modal_pag1(){
	var tipo = $("#tipoDemanda").val();
	var descripcion = $("#tipoDemanda").text();
	if (tipo != 0 && tipo != '0') {
		if (tipo != '1' || tipo != 1) {
			$("#moneda").prop("disabled","disabled");
			$("#monto").prop("disabled","disabled");

		} else {
			$("#moneda").prop("disabled",false);
			$("#monto").prop("disabled",false);
		}
	}
}
/*
 * Archivo para el manejo de todos los datos relacionados al expediente
 */
 function createFileInput(){
	 $('#file-es').fileinput({
 
		        language: 'es',
		        uploadUrl: '#',
		        allowedFileExtensions: ['jpg', 'png', 'gif'],
		        showUpload : false,
				maxFileCount : 1,
				mainClass : "input-group-lg",
				layoutTemplates: { 
					footer: '<div class="file-thumbnail-footer">\n' +
			            '    <div class="file-footer-caption" style="width:{width}">{caption}<br> {size}</div>\n' +
			            '    {actions}\n' +
			            '</div>',
		        	actions: '<div class="file-actions">\n' +
			            '    <div class="file-footer-buttons">\n' +
			            '      {delete} {zoom} {other}' +
			            '    </div>\n' +
			            '    <div class="clearfix"></div>\n' +
			            '</div>',
				}
		    });		 
 }
 
 
var listDespachos=''; // variable global para guardar el listado de despachos
$("select[name=materia]").on("change", function(e){
	console.log($('select[name=materia]').val());
	var codigo_materia = $('select[name=materia]').val();
	var web_url = '/sigj/materia/obtener_materia';
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
			listDespachos = rdinfo.materia.listaDespacho;
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
	  		  allSuccBtn = $('.succesBtn');

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
	          curInputs = curStep.find("input[type='text'], select:visible"),
	          isValid = true;

	      $(".form-group").removeClass("has-error");
	      for(var i=0; i<curInputs.length; i++){
	          if (!curInputs[i].validity.valid){
	              isValid = false;
	              $(curInputs[i]).closest(".form-group").addClass("has-error");
	          }
	          
	          if (curInputs[i].value == 0){
	              isValid = false;
	              var a = $(curInputs[i]).closest(".form-group").addClass("has-error");
	              $(curInputs[i]).closest(".form-group").addClass("has-error");
	          }
	      }

	      if (isValid){
	          nextStepWizard.removeAttr('disabled').trigger('click');
	      	if(curStepBtn== 'step-3'){
	      		$('#modalStep').modal('toggle');
	      	}
	      }
	  });

	  $('div.setup-panel div a.btn-primary').trigger('click');

	
}
//var rInfo = { "mapa": {"abogados" : [],"clientes": [] } }
var abogado = [];
var clientes = [];
//rInfo.mapa.abogados.push({"id_abogado":$("#id_abogadoHtml").val(), "tipo_abogado" : $("#tipo_abogadoHtml").val()})
var demandante = "";
var demandado = "";
var apoderado = "";
var contraparte = "";
function agregar_demandado(){
	var seleccion = $('input[name=tipos_personas]:checked').val();
	var seleccionDT = $("#clienteDT tbody tr").find(":checked");
	if(seleccionDT != null && seleccionDT != "" && seleccionDT != undefined && $('input:radio[name=radio-dt]').is(":checked") === true ){
		if(seleccion == 'D'){
			if(demandante == ""){
				demandante = "["+ $("#clienteDT tbody tr.checked td").eq(3).text() + " " + $("#clienteDT tbody tr.checked td").eq(2).text() + "]";
				var id = $("#clienteDT tbody tr.checked td").eq(1).text();
				var tipo =  seleccion;
				clientes.push({"id_cliente":id, "tipo_cliente": tipo });
				$("#o-nombre_demandante").text($("#clienteDT tbody tr.checked td").eq(3).text());
				$("#o-apellido_demandante").text($("#clienteDT tbody tr.checked td").eq(4).text());
			}
			else{
				demandante = demandante.substr(0,demandante.length-1);
				demandante = demandante + ", "+$("#clienteDT tbody tr.checked td").eq(3).text() + " " + $("#clienteDT tbody tr.checked td").eq(2).text() + "]";
				var id = $("#clienteDT tbody tr.checked td").eq(1).text();
				var tipo =  seleccion;
				clientes.push({"id_cliente":id, "tipo_cliente": tipo });
			}
//			demandante.id = $("#clienteDT tbody tr.selected td").eq(0).text();
//			demandante.cedula_ruc = $("#clienteDT tbody tr.selected td").eq(1).text();
//			demandante.nombre_razon_social = $("#clienteDT tbody tr.selected td").eq(2).text();
//			demandante.apellido = $("#clienteDT tbody tr.selected td").eq(3).text();
//			demandante.tipo = seleccion;
			$(".demandante").removeClass("hidden");
			$("#o-id_demandante").text(demandante);
//			$("#o-cedula_demandante").text(demandante.cedula_ruc);
//			$("#o-nombre_demandante").text(demandante.nombre_razon_social);
//			$("#o-apellido_demandante").text(demandante.apellido);
			$("#o-demandante").text("Demandante");
		}else if(seleccion == 'C'){
			if(demandado == ""){
				demandado = "["+ $("#clienteDT tbody tr.checked td").eq(3).text() + " " + $("#clienteDT tbody tr.checked td").eq(2).text() + "]";
			
				var id = $("#clienteDT tbody tr.checked td").eq(1).text();
				var tipo =  seleccion;
				clientes.push({"id_cliente":id, "tipo_cliente": tipo });
				$("#o-nombre_demandado").text($("#clienteDT tbody tr.checked td").eq(3).text());
				$("#o-apellido_demandado").text($("#clienteDT tbody tr.checked td").eq(4).text());
			}
			else{
				demandado = demandado.substr(0,demandado.length-1);
				demandado = demandado + ", "+$("#clienteDT tbody tr.checked td").eq(3).text() + " " + $("#clienteDT tbody tr.checked td").eq(2).text() + "]";
				var id = $("#clienteDT tbody tr.checked td").eq(1).text();
				var tipo =  seleccion;
				clientes.push({"id_cliente":id, "tipo_cliente": tipo });
			}
			
//			var demandado = new Object();
//			demandado.cedula_ruc = $("#clienteDT tbody tr.selected td").eq(1).text();
//			demandado.nombre_razon_social = $("#clienteDT tbody tr.selected td").eq(2).text();
//			demandado.apellido = $("#clienteDT tbody tr.selected td").eq(3).text();
//			demandado.tipo = seleccion;
			
			$(".demandado").removeClass("hidden");
			$("#o-id_demandado").text(demandado);
//			$("#o-cedula_demandado").text(demandado.cedula_ruc);
//			$("#o-nombre_demandado").text(demandado.nombre_razon_social);
//			$("#o-apellido_demandado").text(demandado.apellido);
			$("#o-demandado").text("Demandado");
			$("#error-cliente").addClass("hidden");
		}else {
			$("#error-cliente").removeClass("hidden");
			return;
			
		}
		$("#error-cliente").addClass("hidden");
	}else{
		$("#error-cliente").removeClass("hidden");
		
	}
	
}
function agregar_abogado(){
	var seleccion = $('input[name=tipos_personas]:checked').val();
	var seleccionDT = $("#abogadoDT tbody tr").find(":checked");
	if(seleccionDT != null && seleccionDT != "" && seleccionDT != undefined && $('input:radio[name=radio-dt]').is(":checked") === true){
		if(seleccion == 'AP'){
			if(apoderado == ""){
				apoderado = "["+ $("#abogadoDT tbody tr.checked td").eq(3).text() + " " + $("#abogadoDT tbody tr.checked td").eq(2).text() + "]";
				
				var id = $("#abogadoDT tbody tr.checked td").eq(1).text();
				var tipo =  seleccion;
				abogado.push({"id_abogado":id, "tipo_abogado": tipo });
			}else{
				apoderado = apoderado.substr(0,apoderado.length-1);
				apoderado = apoderado + ", "+$("#abogadoDT tbody tr.checked td").eq(3).text() + " " + $("#abogadoDT tbody tr.checked td").eq(2).text() + "]";
				var id = $("#abogadoDT tbody tr.checked td").eq(1).text();
				var tipo =  seleccion;
				abogado.push({"id_abogado":id, "tipo_abogado": tipo });
			
			}
//			var apoderado = new Object();
//			apoderado.cedula_ruc = $("#abogadoDT tbody tr.selected td").eq(1).text();
//			apoderado.nombre_razon_social = $("#abogadoDT tbody tr.selected td").eq(2).text();
//			apoderado.apellido = $("#abogadoDT tbody tr.selected td").eq(3).text();
//			apoderado.tipo = seleccion;
			$(".apoderado").removeClass("hidden");
			$("#o-id_apoderado").text(apoderado);
//			$("#o-nombre_apoderado").text(apoderado.nombre_razon_social);
//			$("#o-apellido_apoderado").text(apoderado.apellido);
			$("#o-apoderado").text("Apoderado");
		}else if(seleccion == 'CO'){
			if(contraparte == ""){
				contraparte = "["+ $("#abogadoDT tbody tr.checked td").eq(3).text() + " " + $("#abogadoDT tbody tr.checked td").eq(2).text() + "]";
				
				var id = $("#abogadoDT tbody tr.checked td").eq(1).text();
				var tipo = seleccion;
				abogado.push({"id_abogado":id, "tipo_abogado": tipo });
			}else{
				contraparte = contraparte.substr(0,contraparte.length-1);
				contraparte = contraparte + ", "+$("#abogadoDT tbody tr.checked td").eq(3).text() + " " + $("#abogadoDT tbody tr.checked td").eq(2).text() + "]";
				var id = $("#abogadoDT tbody tr.checked td").eq(1).text();
				var tipo = seleccion;
				abogado.push({"id_abogado":id, "tipo_abogado": tipo });
			
			}
			
//			var contraparte = new Object();
//			contraparte.cedula_ruc = $("#abogadoDT tbody tr.selected td").eq(1).text();
//			contraparte.nombre_razon_social = $("#abogadoDT tbody tr.selected td").eq(2).text();
//			contraparte.apellido = $("#abogadoDT tbody tr.selected td").eq(3).text();
//			contraparte.tipo = seleccion;
			
			$(".contraparte").removeClass("hidden");
			$("#o-id_contraparte").text(contraparte);
//			$("#o-nombre_contraparte").text(contraparte.nombre_razon_social);
//			$("#o-apellido_contraparte").text(contraparte.apellido);
			$("#o-contraparte").text("Contraparte");
			$("#error-abogado").addClass("hidden");
		}else{
			$("#error-abogado").removeClass("hidden");
			return;
		}
		$("#error-abogado").addClass("hidden");
	}else{
		$("#error-abogado").removeClass("hidden");
	}
}

function datos_caratula(){
	
	var rInfo= {};
	rInfo.mapa= {};
	rInfo.mapa.abogados=abogado;
	rInfo.mapa.clientes=clientes;
	
	
	var expediente = $("#o-nombre_demandante").text() +" "+$("#o-apellido_demandante").text()+" C/ "+ $("#o-nombre_demandado").text() +" "+$("#o-apellido_demandado").text()+" S/ "+ $("select[name=tipoDemanda]").find(":selected").text();
	var juzgado = $("select[name=despacho]").find(":selected").text();
	$.each(listDespachos, function( index, value ) {
		if( $("#despacho").find(":selected").val() == value.id){
			$("#juez_caract").val(value.juez);
		}
	});
	$("#anho_caract").text($("#anho").val());
	$("#nro_caract").text($("#nroExpediente").val());
	$("#folio_caract").text($("#folio").val());
	$("#expediente_caract").text(expediente);
	$("#juzgado_caract").text(juzgado);
}

function registrar_expediente(){
	var rInfo = {};
	rInfo.mapa = {};
	rInfo.mapa.abogados = abogado;
	rInfo.mapa.clientes = clientes;
	var expediente = {};
	//expediente.anho = $("#anho_caract").text();
	expediente.anho = $("#anho").val();
	expediente.juzgado= "2017";
	expediente.caratula = "2017";
	expediente.folio = 	$("#folio_caract").text();
	expediente.juzgado = $("#juzgado_caract").text();
	expediente.juez = $("#juez_caract").val();
	expediente.secretaria = $("#secretaria_caract").val();
	expediente.cargo = $("#cargo_caract").val();
	expediente.caratula = $("#expediente_caract").text();
	expediente.moneda = $("#moneda").val();
	expediente.monto = $("#monto").val();
	expediente.nroExpediente = $("#nro_caract").text();
	expediente.fecha = $('input[name=fecha]').val();
	expediente.estado = $('#estadoExterno').val();
	expediente.nroLiquidacion = $("#nroLiquidacion").val();
	expediente.despacho = $("#despacho").val();
	rInfo.mapa.expediente =  expediente;
	console.log(rInfo);
	var mapaStr = JSON.stringify(rInfo);
	$.ajax({
		type:"GET",
		url: "/sigj/expediente/save_listado2",
		data: {
			rd_expediente : mapaStr
		}
	}).done(function(json_data){
		$("#expediente_section_2").html(json_data);
		$("#section_1").addClass("hidden");
		$("#expediente_section_2").removeClass("hidden");
	});
}
function agregar_actuacion(){
	var id_expediente = $("#id-expediente").val();
	if(id_expediente == null || id_expediente == undefined || id_expediente == ""){ // solo para probar si llega al controlador
		id_expediente = 0;
	}
	//cambiar
	
	var url = '/sigj/expediente/ver-documento?expediente='+id_expediente;
	location.href = url;
}
