/*
 * Archivo para el manejo de todos los datos relacionados al expediente
 */
 function createFileInput(idFile){
	 $('#'+idFile).fileinput({
 
		        language: 'es',
		        uploadUrl: '#',
		        allowedFileExtensions: ['jpg', 'png', 'gif','jpeg'],
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

$("#btn-informe").on('click',function(e){
	   var fecha_rec = $('input[name=fecha]').val();
	   var url = '/sigj/planilla_salario/reporte_planilla_salario?fecha='+fecha_rec;
	   $('#btn-planillaPdf').prop("href", url);
	   $('#btn-planillaPdf')[0].click();
	   //location.href =  url;
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
	      		$(this).prop('disabled','disabled')
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
var idPartes = [];
var banDem=0;
var banDe=0;
var banApo=0;
var banCon=0;

function agregar_cliente(id, nombre, ci){
	var seleccion = $('input[name=tipo_cliente]:checked').val();
	if(notInTable(id,"C")){//si no esta en la tabla de partes
		if(seleccion == undefined || seleccion=="" || seleccion==null){
			//$("#div-result_cliente").empty();
			$(".error-cliente").html('');
			$("#error-cliente").removeClass("hidden");
			var msg= "Debe seleccionar el tipo de Cliente."
				$(".error-cliente").html(msg);
		}else{
		//	$("#error-cliente").empty();
			$("#error-cliente").addClass("hidden");
			if(seleccion == 'D'){
				clientes.push({"id_cliente":id, "tipo_cliente": seleccion });
				 $('#tbody_partes').append("<tr>"+
						"<td style='width: 12px;'><button type='button' class='eliminar btn btn-danger btn-xs' id='boton_"+id+"' onclick='eliminar_parte("+id+",\"C\""+")'><i class='fa fa-trash-o' ></i></button>"+
						"</td> <td>"+id+"</td><td>DEMANDANTE</td><td>"+nombre+"</td><td>"+ci+"</td></tr>");
				 idPartes.push({"id":id,"tipo":"C"});
				 if(banDem == 0){
					 $('#o-demandante').val(nombre);
					 banDem++;
				 }
				 $("#div-result_cliente").addClass("hidden");
			}else{
				clientes.push({"id_cliente":id, "tipo_cliente": seleccion });
				$('#tbody_partes').append("<tr>"+
						"<td style='width: 12px;'><button type='button' class='eliminar btn btn-danger btn-xs' id='boton_"+id+"' onclick='eliminar_parte("+id+",\"C\""+")'><i class='fa fa-trash-o'></i></button>"+
						"</td> <td>"+id+"</td><td>DEMANDADO</td><td>"+nombre+"</td><td>"+ci+"</td></tr>");
				idPartes.push({"id":id,"tipo":"C"});
				if(banDe == 0){
					$('#o-demandado').val(nombre);
					banDe++;
				}
				$("#div-result_cliente").addClass("hidden");
			}
		}
	
	}else{
		$("#div-result_cliente").html('');
		$(".error-cliente").html('');
		$("#error-cliente").removeClass("hidden");
		var msg= "Este cliente ya fue agregado al listado de Partes."
		$(".error-cliente").html(msg);
	}
	$("#tipo_cliente_demandante").prop('checked', false);
	$("#tipo_cliente_demandado").prop('checked', false);
	$("#buscar_parte_cliente").val("");
	
}
function agregar_abogado(id, nombre, ci){
	var seleccion = $('input[name=tipo_abogado]:checked').val();
	if(notInTable(id,"A")){//si no esta en la tabla de partes
		if(seleccion == undefined || seleccion=="" || seleccion==null){
			//$("#div-result_abogado").empty();
			$(".error-abogado").html('');
			$("#error-abogado").removeClass("hidden");
			var msg= "Debe seleccionar el tipo de Abogado."
				$(".error-abogado").html(msg);
		}else{
			//$("#error-abogado").html('');
			$("#error-abogado").addClass("hidden");
			if(seleccion == 'AP'){
				abogado.push({"id_abogado":id, "tipo_abogado": seleccion });
				 $('#tbody_partes').append("<tr>"+
						"<td style='width: 12px;'><button type='button' class='eliminar btn btn-danger btn-xs' id='boton_"+id+"' onclick='eliminar_parte("+id+",\"A\""+")'><i class='fa fa-trash-o'></i></button>"+
						"</td> <td>"+id+"</td><td>APODERADO</td><td>"+nombre+"</td><td>"+ci+"</td></tr>");
				 idPartes.push({"id":id,"tipo":"A"});
				 if(banApo == 0){
					 $('#o-apoderado').val(nombre);
					 banApo++;
				 }
				 $("#div-result_abogado").addClass("hidden");
			}else{
				abogado.push({"id_abogado":id, "tipo_abogado": seleccion });
				$('#tbody_partes').append("<tr>"+
						"<td style='width: 12px;'><button type='button' class='eliminar btn btn-danger btn-xs' id='boton_"+id+"' onclick='eliminar_parte("+id+",\"A\""+")'><i class='fa fa-trash-o'></i></button>"+
						"</td><td>"+id+"</td><td>CONTRAPARTE</td><td>"+nombre+"</td><td>"+ci+"</td></tr>");
				idPartes.push({"id":id,"tipo":"A"});
				if(banCon == 0){
					$('#o-contraparte').val(nombre);
					banCon++;
				}
				$("#div-result_abogado").addClass("hidden");
			}
		}
	}else{
		$("#div-result_abogado").html('');
		$(".error-abogado").html('');
		$("#error-abogado").removeClass("hidden");
		var msg= "El/la abogado/a ya fue agregado/a al listado de Partes."
		$(".error-abogado").html(msg);
	}
	$("#tipo_abogado_apoderado").prop('checked', false);
	$("#tipo_abogado_contraparte").prop('checked', false);
	$("#buscar_parte_abogado").val("");
	
}

function eliminar_parte(id,tipo){
	$.each(idPartes, function( index, value ) {
		if(value["id"] == id && tipo == value["tipo"] ){
			idPartes.splice(index,1);
			return false;
		}
	});
	
	var boton = $('#boton_'+id).closest('tr').remove();
}

function datos_caratula(){
	
	var rInfo= {};
	rInfo.mapa= {};
	rInfo.mapa.abogados=abogado;
	rInfo.mapa.clientes=clientes;
	var demandante = $("#o-demandante").val();
	var demandando = $("#o-demandado").val();
	var tipoDemnda = $("select[name=tipoDemanda]").find(":selected").text();
	var juzgado = $("select[name=despacho]").find(":selected").text();
	var tamanho = juzgado.length;
	var secretaria = juzgado.substring(tamanho-2,tamanho);
	if(demandante != null && demandante != undefined && demandando != null 
			&& demandando != undefined && tipoDemnda != null && tipoDemnda != undefined){
		var expediente = demandante +" C/ "+ demandando+" S/ "+ tipoDemnda;
		$.each(listDespachos, function( index, value ) {
			if( $("#despacho").find(":selected").val() == value.id){
				$("#juez_caract").text(value.juez);
			}
		});
		$("#anho_caract").text($("#anho").val());
		$("#nro_caract").text($("#nroExpediente").val());
		$("#folio_caract").text($("#folio").val());
		$("#expediente_caract").text(expediente);
		$("#juzgado_caract").text(juzgado);
		$("#secretaria_caract").text(secretaria);
		return true;
	}else{
		$("#div-error-general").html('');
		$(".error-general").html('');
		$("#error-general").removeClass("hidden");
		var msg= "Debe agregar todas las partes."
			$(".error-general").html(msg);
		return false;
		
	}
	
	
}

function registrar_expediente(){
	if(datos_caratula() == true){
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
		expediente.juez = $("#juez_caract").text();
		expediente.secretaria = $("#secretaria_caract").text();
		expediente.cargo = $("#cargo_caract").val();
		expediente.caratula = $("#expediente_caract").text();
		expediente.moneda = $("#moneda").val();
		expediente.monto = $("#monto").val();
		expediente.nroExpediente = $("#nro_caract").text();
		expediente.fecha = $('input[name=fecha]').val();
		expediente.estadoExterno = $('#estadoExterno').val();
		expediente.estadoInterno = $('#estadoInterno').val();
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
			$(".btn-atras").removeClass("hidden");
		});
	}
}
function atras_expediente(){
	$("#section_1").removeClass("hidden");
	$("#expediente_section_2").addClass("hidden");
	$(".btn-atras").addClass("hidden");
}


function agregar_actuacion(id_expediente){
	if(id_expediente == null || id_expediente == undefined || id_expediente == ""){ // solo para probar si llega al controlador
		id_expediente = 0;
	}
	//cambiar
	
	var url = '/sigj/expediente/ver-documento?expediente='+id_expediente;
	location.href = url;
}

function modal_pag1(){
	  var tipo = $("#tipoDemanda").val();
	var descripcion = $("select[name=tipoDemanda]").find(":selected").text();
	descripcion = descripcion.toLowerCase();
	if (tipo != 0 && tipo != '0') {
		if (descripcion != 'acción ejecutiva' && descripcion != 'acción preparatoria de juicio ejecutivo') {
			$("#moneda").addClass("hidden");
			$('.control-moneda').css('display','none');
			$("#moneda").val(0);
			$("#monto").addClass("hidden");
			$('.control-monto').css('display','none');
			$("#monto").val(1);
		} else {
			$("#moneda").removeClass("hidden");
			$('.control-moneda').css('display','block');
			$('.control-monto').css('display','block');
			$("#monto").removeClass("hidden");
		}
	}
}

function modal_pag2(){
	  var monto = $("#monto").val();
	  monto = monto.replace(/\./g, "");
	  
		var descripcion = $("select[name=tipoDemanda]").find(":selected").text();
		descripcion = descripcion.toLowerCase();
	if (monto != 0 && monto > 7555800) {
		if (descripcion == 'acción ejecutiva' || descripcion == 'acción preparatoria de juicio ejecutivo') {
			$(".nroLiquidacion-control").css("display","block");
			$('#nroLiquidacion').val('');
			
		} else {
			$(".nroLiquidacion-control").css("display",'none');
			$('#nroLiquidacion').val(1);
		}
	}else{
		$(".nroLiquidacion-control").css("display",'none');
		$('#nroLiquidacion').val(1);
		
	}
}


function buscar_parte(tipo_parte){
	var sSearch = null;
	var div_error;
	var div_tipo;
	if(tipo_parte == 'C'){
		sSearch = $('#buscar_parte_cliente').val();
		div_error="error-cliente";
		div_tipo="div-result_cliente";
	}else{
		sSearch = $('#buscar_parte_abogado').val();
		div_error="error-abogado";
		div_tipo="div-result_abogado";
	}
	
	if(sSearch != null && sSearch != "" && sSearch != undefined){
		var modalSpinner = iniciarSpinner("modal_spinner");
		$("#error-abogado").addClass("hidden");
		$("#error-cliente").addClass("hidden");
		$.ajax({
	           type: "GET",
	           url: "/sigj/expediente/buscar-parte",
	           data: { 
	               search : sSearch,
	               tipo_parte: tipo_parte
	           }
	       }).done(function(data){
	           
	           if(data == "" && tipo_parte=="C"){
	        	   $("#div-result_cliente").addClass("hidden");
	           }else if(data=="" && tipo_parte =="A"){
	        	   $("#div-result_abogado").addClass("hidden");
	           }else if(tipo_parte =="C"){
	        	   $("#div-result_abogado").addClass("hidden");
	        	   $("#div-result_abogado").html('');
	        	   
	        	   $("#div-result_cliente").removeClass("hidden");
	        	   $("#div-result_cliente").html('');
		           $("#div-result_cliente").html(data); 
		   		   $("#error-cliente").addClass("hidden");
	           }else if(tipo_parte == "A"){
	        	   $("#div-result_cliente").addClass("hidden");
	        	   $("#div-result_cliente").html('');
	        	   
	        	   $("#div-result_abogado").removeClass("hidden");
	        	   
		           $("#div-result_abogado").html(data);
		   		   $("#error-abogado").addClass("hidden");
	           }
	           pararSpinner(modalSpinner);
	       });
	}else{
		$("#"+div_tipo).html("");
		$("#"+div_error).removeClass("hidden");
		var msg= "Debe introducir un dato a buscar."
			$("."+div_error).html(msg);
	}
	
}

function notInTable(id,tipo){
	var ban = true;
	$.each(idPartes,function(index, value){
		if(value["id"] == id && value["tipo"] == tipo){
			ban = false;
			return;
		}
	});
	if(ban){
		return ban;
	}else{
		return ban;
	}
	
}

function calcularFecha(){
	$('#fecha-presentacion').datepicker({ 
        autoclose : true, 
        format: 'dd/mm/yyyy',
        daysOfWeekDisabled: [0,6],
        language : 'es', 
             
     }).on("changeDate", function (e) {
    	 $("#error-actuacion").addClass("hidden");
    	 $(".type-error").html('');
    	 if($("#tipo-actuacion").val() == 0){
    	 	$(this).datepicker('update', '');
    	 	$(".type-error").html('');
			$("#error-actuacion").removeClass("hidden");
			var msg= "Debe seleccionar una actuación."
			$(".type-error").html(msg);
    		 return false;							            			
    	  }else{
    		  var seleccion = $("#fecha-presentacion").val(); 
    	  	  var actuacion = $("#tipo-actuacion").val();
    	  	  if(seleccion != null && seleccion != undefined && seleccion != ""){
    	  		  var url = '/sigj/expediente/fecha-vencimiento?fecha='+seleccion+'&actuacion='+actuacion;
    	  		$.ajax({
    	  	        type: "GET",
    	  	        url: url,
    	  	    }).done(function(data){
    	  	    	if(data != null && data.trim() !=""){
    	  	    		$('#fecha-vencimiento').val('');
    	  	    		$('#fecha-vencimiento').val(data.substring(data.indexOf('/')-2,data.indexOf('>')-1));
    	  	    		$('#fecha-vencimiento').prop("disabled", "disabled");
    	  	    	}
    				 return true;
    	  	    }).fail(function(jqXHR, textStatus){
    	  			console.log(textStatus)
    	  		});
     		  }
//    	  	  var seleccion = $("#fecha-presentacion").val(); 
//    	  	  var actuacion = $("#tipo-actuacion").val();
//    	  	  if(seleccion != null && seleccion != undefined && seleccion != ""){
//    	  		  var url = '/sigj/expediente/fecha-vencimiento?fecha='+seleccion+'&actuacion='+actuacion;
//    	  	  	  $("#contenedor-ven").load(url, function(response, status, xhr) {
//	  				 if(status == "success"){
//	  					 var aux = $("input.fecha-venc2").val();
//	  					 if($("input.fecha-venc2").val() != undefined){
//    	  					if($("#fecha-vencimiento").val() != undefined && $("#fecha-vencimiento").val() != ""){
//    	  						$("#fecha-vencimiento").val("");
//    	  						$("#fecha-vencimiento").val(aux);
//    	  	  					$("#fecha-vencimiento").prop("disabled","disabled");
//    	  					}else{
//    	  						$("#fecha-vencimiento").attr('value',aux);
//    	  	  					$("#fecha-vencimiento").prop("disabled","disabled");
//    	  					}
//	  						
//	  					 }
//	  				return true;
//	  				 }			
//	  			  });  
//	  		  }
    	   }	   
	 });
	
}
function TipoActuacionChange(){
$('#tipo-actuacion').on('change', function(e){
	$("#error-actuacion").addClass("hidden");
	 $(".type-error").html('');
	 if($("#tipo-actuacion").val() == 0){
	 	$(".type-error").html('');
		$("#error-actuacion").removeClass("hidden");
		var msg= "Debe seleccionar una actuación."
		$(".type-error").html(msg);
		 return false;							            			
	  }else{
	  	  var seleccion = $("#fecha-presentacion").val(); 
	  	  var actuacion = $("#tipo-actuacion").val();
	  	  if(seleccion != null && seleccion != undefined && seleccion != ""){
	  		  var url = '/sigj/expediente/fecha-vencimiento?fecha='+seleccion+'&actuacion='+actuacion;
	  		$.ajax({
	  	        type: "GET",
	  	        url: url,
	  	    }).done(function(data){
	  	    	if(data != null && data.trim() !=""){
	  	    		$('#fecha-vencimiento').val('');
	  	    		$('#fecha-vencimiento').val(data.substring(data.indexOf('/')-2,data.indexOf('>')-1));
	  	    	}
				 return true;
	  	    }).fail(function(jqXHR, textStatus){
	  			console.log(textStatus)
	  		});
 		  }
	   }

});
}

function actuacion_agregar(){ //verificar si llega bien
	
	if(($('#hora-presentacion').val() !=null && $('#hora-presentacion').val()!="" && $('#hora-presentacion').val()!= undefined) &&
			($('#fecha-presentacion').val() !=null && $('#fecha-presentacion').val()!="" && $('#fecha-presentacion').val()!= undefined)&&
			($('#fecha-vencimiento').val() !=null && $('#fecha-vencimiento').val()!="" && $('#fecha-vencimiento').val()!= undefined) &&
			($('#movimiento-observacion').val() !=null && $('#movimiento-observacion').val()!="" && $('#movimiento-observacion').val()!= undefined)){
		var f = new FormData();
		f.append("documento",$("#file-es")[0].files[0]);
		f.append("fecha_presentacion",$("#fecha-presentacion").val());
		f.append("fecha_vencimiento", $("#fecha-vencimiento").val());
		f.append("tipo_actuacion",$("#tipo-actuacion").val());
		f.append("expediente",$("#expediente_id").val());
		f.append("movimiento_observacion",$("#movimiento-observacion").val());
		f.append("hora_presentacion",$("#hora-presentacion").val());
		var csrf =$('form#' + 'form-movimiento' + ' input[name=_csrf]').val();
		f.append("_csrf",csrf);
		var modalSpinner = iniciarSpinner("modal_spinner"); 
		$.ajax({
	        type: "POST",
	        url: "/sigj/expediente/actuacion-agregar",
	        data: f,
	        cache:false,
	        processData: false,
	        contentType: false,
	    }).done(function(data){
	        pararSpinner(modalSpinner);	
	        window.scrollTo(0, 0);
	        $('#mensaje').html('');
	        $('#mensaje').html("Actuación agregada con éxito");
	        $("#alerta2").fadeIn(2000);
			$("#alerta2").fadeOut(1000);
			$('#movimiento-observacion').val('');
			$('#fecha-vencimiento').val('');
			$('#fecha-presentacion').val('');
			$('#hora-presentacion').val('');
			$('#file-es').fileinput('refresh');
			$('#seccion3_dataTable').html('');
			$('#seccion3_dataTable').html(data);
			$(".type-error").html('');
			$("#error-actuacion").addClass("hidden");
	    }).fail(function(jqXHR, textStatus){
			pararSpinner(modalSpinner);	
			window.scrollTo(0, 0);
			$("#mensaje").html("Error al cargar la actuación");
			$("#alerta2").removeClass("alert-success");
			$("#alerta2").addClass("alert-danger");
			$("#alerta2").fadeIn(5000);
			$("#alerta2").fadeOut(1000);
			$(".errorEach").fadeIn(5000);
			$(".errorEach").fadeOut(1000);
			
		});
	}else{
		$(".type-error").html('');
		$("#error-actuacion").removeClass("hidden");
		var msg= "La fecha de presentación, hora y observación no pueden estar vacios."
		$(".type-error").html(msg);
		 return false;
		
	}
}


function createDataTableActuacion(){
	$('#movimientoActuacionDT').dataTable(
			{
				"bScrollCollapse" : true,
				"responsive" : true,
				'language' : {
					"sProcessing" : "Procesando...",
					"sLengthMenu" : "Mostrar _MENU_ registros",
					"sZeroRecords" : "No se encontraron resultados",
					"sEmptyTable" : "No posee Actuaciones",
					"sInfo" : "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
					"sInfoEmpty" : "Mostrando _MAX_ registros",
					"sInfoFiltered" : " ",
					"sInfoPostFix" : "",
					"sSearch" : "Buscar:",
					"sUrl" : "",
					"sInfoThousands" : ",",
					"sLoadingRecords" : "Cargando...",
					"oPaginate" : {
						"sFirst" : "Primero",
						"sLast" : "Último",
						"sNext" : "Siguiente",
						"sPrevious" : "Anterior"
					},
					"oAria" : {
						"sSortAscending" : ": Activar para ordenar la columna de manera ascendente",
						"sSortDescending" : ": Activar para ordenar la columna de manera descendente"
					}
				}
			});
	
	
}
