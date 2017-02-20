/**
				EJ: recibe "id;codigo;razonSocial;tipoCliente.nombre"
				y retorna [{'data' : 'id'}, {'data':'codigo'}, {'data':'razonSocial'}, {'data':'tipoCliente.nombre'}]
			*/
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
								console.log(val);
								
					});
					columnsArray.push(
			                {'defaultContent': "<button type='button' class='editar btn btn-primary btn-xs'><i class='fa fa-edit'></i></button>"+
						                    "<button type='button' class='eliminar btn btn-danger btn-xs' data-toggle='modal'><i class='fa fa-trash-o' aria-hidden='true'></i></button>"+
						                    "<button type='button' class='ver btn btn-primary btn-xs' ><i class='fa fa-search'></i></button>"}
			                );
					
					console.log(colsStr, "->", columnsArray);
					
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
                'responsive': true,
                'sAjaxSource' : ajaxSource,
                'serverSide' : true,
                'columns' : getColumnasArray(columnas),

                'language' : {
                    "sProcessing": "Procesando...",
                    "sLengthMenu": "Mostrar _MENU_ registros",
                    "sZeroRecords": "No se encontraron resultados",
                    "sEmptyTable": "Ningun dato disponible en esta tabla",
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
					console.log($('#'+dataTableId+ ' tbody tr'));
					var ob = dataTable.row( $(this).parents('tr') ).data()[0];
					console.log(ob);
					console.log( ob["id"] );
					// var dat = dataTable.api().row( $(this).parents('tr') ).data();
					
					//window.location.href = "/polapp/reserva/edit/" + id;
					}); 
				
				$('#reservaDT tbody').on('click','button.eliminar', function(){
					var id = dataTable.fnGetData($(this).parents('tr'), 0);
					var alumno = dataTable.fnGetData($(this).parents('tr'),2);
					// var dat = dataTable.api().row( $(this).parents('tr') ).data();
					alert('Se eliminará la reserva de alumno '+ alumno)
					//falta modificar aca la url
					window.location.href = "/polapp/reserva/delete_r/" + id;
					});
			
				/* $('#'+ dataTableId + ' tbody').on('click', 'tr', function() {
					 //Obtenemos el valor de la columna id
					 //var id = dataTable.fnGetData(this, 0);
					 var data = dataTable.row( this ).data();
					 var id = data["id"];

					 //Si id no es número, no hacemos nada
					 if (isNaN(id)) {
					 return;
					 }
					
					 window.location.href = editUrl + id; //"/estudio/cliente/edit/" + id;
					//codigo que selecciona la fila
		            
				 });*/
				 
		}
		
		
		function crearDataTableEsp(dataTableId, ajaxSource, columnas, tipoObjeto){
			
			 /*var config={};
			 config['processing'] = true;
			 config['sAjaxSource'] = ajaxSource;
			 config['serverSide'] = true;
			 config['columns']= getColumnasArray(columnas);*/
             var LENGUAJE = {
                    "sProcessing": "Procesando...",
                    "sLengthMenu": "Mostrar _MENU_ registros",
                    "sZeroRecords": "No se encontraron resultados",
                    "sEmptyTable": "Ningún dato disponible en esta tabla",
                    "sInfo": "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
                    "sInfoEmpty": "Mostrando registros del 0 al 0 de un total de 0 registros",
                    "sInfoFiltered": "(filtrado de un total de _MAX_ registros)",
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
			
			 //var dataTable = $('#'+ dataTableId).dataTable(config);
			 var dataTable = $('#'+ dataTableId).DataTable({
                'processing' : true,
                'responsive': true,
                'sAjaxSource' : ajaxSource,
                'serverSide' : true,
                'columns' : getColumnasArrayEsp(columnas),
                'language' : {
                    "sProcessing": "Procesando...",
                    "sLengthMenu": "Mostrar _MENU_ registros",
                    "sZeroRecords": "No se encontraron resultados",
                    "sEmptyTable": "Ningún dato disponible en esta tabla",
                    "sInfo": "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
                    "sInfoEmpty": "Mostrando registros del 0 al 0 de un total de 0 registros",
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
             dataTable.column( 0 ).visible( false );
             console.log("creando data:", dataTable)
             //codigo que selecciona la fila
             $('#'+ dataTableId + ' tbody').on( 'click', 'tr', function () {
         		if ( $(this).hasClass('selected') ) {
         			$(this).removeClass('selected');
         			$("form input:last").val("");
         		}
         		else {
         			dataTable.$('tr.selected').removeClass('selected');
         			$(this).addClass('selected');
         			var data = dataTable.row( this ).data();
         			$("form input:last").val(data["id"]);
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
		
		
