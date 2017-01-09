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
						
								if(val==true){val = "Si";}else if(val == false){val="No";}
								columnsArray.push( {"data" : val} );
					});
					console.log(colsStr, "->", columnsArray);
					return columnsArray;
			}
		
		function crearDataTable(dataTableId, ajaxSource, columnas, editUrl){
			console.log("creando DT:", dataTableId, ajaxSource, columnas, editUrl)
			 var config={};
			 config['processing'] = true;
			 config['sAjaxSource'] = ajaxSource;
			 config['serverSide'] = true;
			 config['columns']= getColumnasArray(columnas);
			
			 var dataTable = $('#'+ dataTableId).dataTable(config);
			 //Ocultamos la primera columna (id)
			 dataTable.fnSetColumnVis(0, false);
			 
				 $('#'+ dataTableId + ' tbody').on('click', 'tr', function() {
					 //Obtenemos el valor de la columna id
					 var id = dataTable.fnGetData(this, 0);
					 //Si id no es número, no hacemos nada
					 if (isNaN(id)) {
					 return;
					 }
					
					 window.location.href = editUrl + id; //"/estudio/cliente/edit/" + id;
				 });
			
		}
		
		
		/**
		 * 
		 * @param magicSuggestId
		 * @param urlData
		 * @param pValueField
		 * @param pNameDisplay
		 * @returns un listado de clientes, tipo cliente entre otros.
		 */
		function crearMagicSuggest(magicSuggestId, urlData, pValueField, pNameDisplay) {
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
	    }