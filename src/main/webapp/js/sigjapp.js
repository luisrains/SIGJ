/**
				EJ: recibe "id;codigo;razonSocial;tipoCliente.nombre"
				y retorna [{'data' : 'id'}, {'data':'codigo'}, {'data':'razonSocial'}, {'data':'tipoCliente.nombre'}]
			*/
		var iva_5 = 0;
		var iva_10 = 0;
		var monto_total = 0;
		function confirmarFila(){
			var trs = $("#f_detalle tbody tr").length -1;
			if($(".fila_"+(trs-1)).find("#ingreso").val() != ""){
				iva_5 += parseInt($(".fila_"+(trs-1)).find("#ingreso").val());
				iva_5 = Math.round(iva_5 / 21);
			}
			else if($(".fila_"+(trs-1)).find("#egreso").val() != ""){
				iva_10 += parseInt($(".fila_"+(trs-1)).find("#egreso").val());
				iva_10 =  Math.round(iva_10 / 11);
			}
			if($(".fila_"+(trs-1)).find("#monto").val() != ""){
				monto_total += parseInt($(".fila_"+(trs-1)).find("#monto").val());
			}
			
			
			
			$("#iva_5").text(iva_5); 
			$("#iva_10").text(iva_10); 
			$("#monto_total").text(monto_total); 
		}
		function agregarFila(){
			console.log("entra en el evento");
			var aux = $("#f_detalle tbody tr:last").clone()
			var trs = $("#f_detalle tbody tr").length -1;
			
			$("#f_detalle tbody tr:last").remove()
			$("#f_detalle tbody tr td:first").text(trs);
			$("#f_detalle tbody tr:first").clone().removeClass('clonar').appendTo("#f_detalle tbody");
			$("#f_detalle tbody tr:last").addClass("fila_"+trs);
			aux.appendTo("#f_detalle tbody");
			/*if($(".fila_"+(trs-1)).find("#ingreso").val() != ""){
				iva_5 += parseInt($(".fila_"+(trs-1)).find("#ingreso").val());
				iva_5 = Math.round(iva_5 / 21);
			}
			else if($(".fila_"+(trs-1)).find("#egreso").val() != ""){
				iva_10 += parseInt($(".fila_"+(trs-1)).find("#egreso").val());
				iva_10 =  Math.round(iva_10 / 11);
			}
			if($(".fila_"+(trs-1)).find("#monto").val() != ""){
				monto_total += parseInt($(".fila_"+(trs-1)).find("#monto").val());
			}
			
			
			
			$("#iva_5").text(iva_5); 
			$("#iva_10").text(iva_10); 
			$("#monto_total").text(monto_total); */
			
			
		}
		
		function eliminarFila(){
			$(document).on("click","button#eliminar_fila",function(){
			console.log("entra en el evento");
			var parent = $(this).parents('tr');
			if(parent.find("#ingreso").val() != ""){
				iva_5 -= Math.round(parseInt(parent.find("#ingreso").val())/21); 
			}else if(parent.find("#egreso").val() != ""){
				iva_10 -= Math.round(parseInt(parent.find("#egreso").val())/11);
			}
			monto_total -= parseInt(parent.find("#monto").val());
			$(parent).remove();
			$("#iva_5").text(iva_5); 
			$("#iva_10").text(iva_10); 
			$("#monto_total").text(monto_total);
			
			var trs = $("#f_detalle tbody tr").length-1;
			var i=1;
			for(i=1;i<trs;i++){
				var x = $("#f_detalle tbody tr:eq("+i+")"+" td:first");
				x.text(i.toString());
			}
			});	
			
		}
		
		
		function getColumnasArray(colsStr){
				/*
				1. declarar un array para retornar
				2. separar colsStr teniendo en cuenta ';''
				3. iterar para crear el array
				*/
				    //1
					var columnsArray = [];
					//2
					var arrayCol = colsStr.split(";");
					//3 , se puede crear una funcion aparte en vez de hacer function
					jQuery.each(arrayCol, function(i, val){
						
								 if(val==true){
									val = "Si";
								}else if(val == false){
									val="No";
									
								}else{
									columnsArray.push( {"data" : val} );
								}
								
								
					});
					columnsArray.push(
			                {'defaultContent': "<button type='button' class='editar btn btn-primary btn-xs'><i class='fa fa-edit'></i></button>"+
						                    "<button type='button' class='eliminar btn btn-danger btn-xs' data-toggle='modal'><i class='fa fa-trash-o' aria-hidden='true'></i></button>"+
						                    "<button type='button' class='ver btn btn-primary btn-xs' ><i class='fa fa-search'></i></button>"}
			                );
					
					return columnsArray;
			}
		
		function getColumnasArrayEsp(colsStr){
			/*
			1. declarar un array para retornar
			2. separar colsStr teniendo en cuenta ';''
			3. iterar para crear el array
			*/
			    //1
				var columnsArray = [];
				//2
				var arrayCol = colsStr.split(";");
				//3 , se puede crear una funcion aparte en vez de hacer function
				columnsArray.push({'defaultContent':"<input type='radio' name='radio-dt' class='radio-dt'>"});
				jQuery.each(arrayCol, function(i, val){
					
							if(val==true){val = "Si";}else if(val == false){val="No";}
							
							columnsArray.push( {"data" : val} );
				});
				
				/*columnsArray.push( {
		            orderable: false,
		            className: 'select-checkbox',
		            targets:   0
		        } );*/
				
				console.log(colsStr, "->", columnsArray);
				return columnsArray;
		}
		function crearDataTable(dataTableId, ajaxSource, columnas, editUrl){
			console.log("creando DT:", dataTableId, ajaxSource, columnas, editUrl)
			
			
			 //var dataTable = $('#'+ dataTableId).dataTable(config);
			 var dataTable = $('#'+ dataTableId).DataTable({
                'processing' : true,
//                'responsive': true,
                'sAjaxSource' : ajaxSource,
                'serverSide' : true,
                'columns' : getColumnasArray(columnas),
                
                'language' : {
                    "sProcessing": "Procesando...",
                    "sLengthMenu": "Mostrar _MENU_ registros",
                    "sZeroRecords": "No se encontraron resultados",
                    "sEmptyTable": "No hay datos disponibles en esta tabla",
                    "sInfo": "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
                    "sInfoEmpty": "Mostrando _MAX_ registros",
                    "sInfoFiltered": " ",
                    "sInfoPostFix": "",
                    "sSearch": "Buscar:",
                    "sUrl": "",
                    "sInfoThousands": ",",
                    "sLoadingRecords": "Cargando...",
                    "oPaginate": {
                        "sFirst": "Primero",
                        "sLast": "Último",
                        "sNext": "Siguiente",
                        "sPrevious": "Anterior"
                    },
                    "oAria": {
                        "sSortAscending": ": Activar para ordenar la columna de manera ascendente",
                        "sSortDescending": ": Activar para ordenar la columna de manera descendente"
                    }
                }
			 });

			 //Ocultamos la primera columna (id)
			 //dataTable.fnSetColumnVis(0, false);
			dataTable.column(0).visible(false);		
			
				$('#'+ dataTableId + ' tbody').on('click','button.editar', function(){
					/*Con esto tenemos un objeto de tipo {id: 1, codigo: "ejc", descripcion: "Ejecutivo", materia: Object}
					 teniendo en cuenta que ejecutamos http://localhost:8090/sigj/proceso/ 
					 entonces para obtener el id de este objeto accedemos por su llave "id"*/
//					console.log($('#'+dataTableId+ ' tbody tr'));
					var ob = dataTable.row( $(this).parents('tr') ).data();
					console.log(ob);
					console.log( ob["id"] );
					agregar(ob, 'e');

					}); 
				
				$('#'+ dataTableId + ' tbody').on('click','button.eliminar', function(){
					/*Con esto tenemos un objeto de tipo {id: 1, codigo: "ejc", descripcion: "Ejecutivo", materia: Object}
					 teniendo en cuenta que ejecutamos http://localhost:8090/sigj/proceso/ 
					 entonces para obtener el id de este objeto accedemos por su llave "id"*/
//					console.log($('#'+dataTableId+ ' tbody tr'));
					var ob = dataTable.row( $(this).parents('tr') ).data();
					console.log(ob);
					console.log( ob["id"] );
					agregar(ob, 'd');

					}); 
			
				 $('#'+ dataTableId + ' tbody').on('click','button.ver', function(){
					var ob = dataTable.row( $(this).parents('tr') ).data();
					agregar(ob, 'v');
					});
				 
		}
		
		
		function crearDataTableEsp(dataTableId, ajaxSource, columnas, tipoObjeto){
			
			 var dataTable = $('#'+ dataTableId).DataTable({
                'processing' : true,
//                'responsive': true,
                'sAjaxSource' : ajaxSource,
                'serverSide' : true,
                'columns' : getColumnasArrayEsp(columnas),
                'columnDefs': [
                    {
                        "targets": [ 0 ],
                        "visible": true,
                        "searchable": false
                    },
//                    {
//                        "targets": [ 1 ],
//                        "visible": false,
//                        "searchable": false
//                    }
                ],
                'language' : {
                    "sProcessing": "Procesando...",
                    "sLengthMenu": "Mostrar _MENU_ registros",
                    "sZeroRecords": "No se encontraron resultados",
                    "sEmptyTable": "No hay datos disponibles en esta tabla",
//                    "sInfo": "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
//                    "sInfoEmpty": "Mostrando registros del 0 al 0 de un total de 0 registros",
                    "sInfoFiltered": "\n(filtrado de un total de _MAX_ registros)",
                    "sInfoPostFix": "",
                    "sSearch": "Buscar:",
                    "sUrl": "",
                    "sInfoThousands": ",",
                    "sLoadingRecords": "Cargando...",
                    "oPaginate": {
                        "sFirst": "Primero",
                        "sLast": "Último",
                        "sNext": "Siguiente",
                        "sPrevious": "Anterior"
                    },
                    "oAria": {
                        "sSortAscending": ": Activar para ordenar la columna de manera ascendente",
                        "sSortDescending": ": Activar para ordenar la columna de manera descendente"
                    }
                }
             });
			 //Ocultamos la primera columna (id)
			 //dataTable.fnSetColumnVis(0, false);
             //dataTable.column( 0 ).visible( false );
             console.log("creando data:", dataTable)
             //codigo que selecciona la fila
             $('#'+ dataTableId + ' tbody').on( 'change', 'tr', function () {
         		if ( $(this).hasClass('checked') ) {
         			$(this).removeClass('checked');
         			$(".object_id").val("");
         		}
         		else {
         			dataTable.$('tr.checked').removeClass('checked');
         			$(this).addClass('checked');
         			var data = dataTable.row( this ).data();
         			$(".object_id").val(data["id"]);
         			console.log($(".object_id").val());
         		}
         	} );
             
           }
		/**
		 * 
		 * @param magicSuggestId
		 * @param urlData
		 * @param pValueField
		 * @param pNameDisplay
		 * @returns un listado de clientes, tipo cliente entre otros.
		 */
		/*function crearMagicSuggest(magicSuggestId, urlData, pValueField, pNameDisplay) {
			var suggest = $('#'+ magicSuggestId).magicSuggest({
				data : urlData,
				useZebraStyle: true,
				sortDir: 'asc',
				valueFiel : pValueField,
				sortOrder : pNameDisplay,
				method : 'get',
				displayField : pNameDisplay,
				queryParam : 'q',
				selectFirst : true,
				requerid : true,
				maxSelection : 1,
				resultAsString: true,
				placeholder : 'Ingrese texto para buscar'
			});

			$(suggest).on('selectionchange', function(a,b,c){
				  console.log("cambió el valor del maicsuggest: " + this.getValue());
				  
				});
	    }*/
		
		function iniciarSpinner(spinnerID){
			var opts = {
					className: 'spinner',
					color: ' #005EB8',
					length: 7,
					lines: 12,
					radius: 9,
					width: 3,
					scale: 2.5,
			};
			var m_spinner = new Spinner(opts);
			if(m_spinner.el==undefined){
		    	m_spinner.spin();
		        $("#"+spinnerID).append(m_spinner.el);
			}
			
			return m_spinner;
		}
		
		function pararSpinner(m_spinner){
			if(m_spinner.el!=undefined){
				m_spinner.stop();
			}
		}
		
$.fn.enterKey = function (fnc) {
		    return this.each(function () {
		        $(this).keypress(function (ev) {
		            var keycode = (ev.keyCode ? ev.keyCode : ev.which);
		            if (keycode == '13') {
		                fnc.call(this, ev);
		            }
		        })
		    })
		}
