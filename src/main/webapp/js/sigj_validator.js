//Validamos los campos numericos y alphanumeric

var REGEX_NUMBERS_ONLY = "^[0-9\b]+$";
$('.importe').on("input", function (e) {
	var num = $(this).val();
	var moneda="";
	var moneda=getMonedaDetails(moneda);
	var inputPattern=moneda.inputPattern;
	var formatPattern=moneda.formatPattern;
	var numCleaned=num.replace(inputPattern,"");
	var nummero = formateoDeMontoEntero(numCleaned);
	var numFormated=formatMontoDecimal(nummero);
	$(this).val(numFormated);
});

function getMonedaDetails(codMoneda){
	var moneda= new Object();
	switch (codMoneda) {
	case 'GS':
		moneda.descripcion='Guaraníes';
		moneda.formato="0,0";
		moneda.formatPattern=/\D/g;
		moneda.inputPattern=/\D/g;
		break;
	case 'USD':
		moneda.descripcion='Dólares';
		moneda.formato="0,0.00";
		moneda.formatPattern=/^[0-9]+([,][0-9]+)?$/g;
		moneda.inputPattern=/[^0-9,]/g;
		break;
	case 'EUR':
		moneda.descripcion='Euros';
		moneda.formato="0,0.00";
		moneda.formatPattern=/^[0-9]+([,][0-9]+)?$/g;
		moneda.inputPattern=/[^0-9,]/g;
		break;
	case 'BRL':
		moneda.descripcion='REALES';
		moneda.formato="0,0.00";
		moneda.formatPattern=/^[0-9]+([,][0-9]+)?$/g;
		moneda.inputPattern=/[^0-9,]/g;
		break;
	case 'ARS':
		moneda.descripcion='PESO ARGENTINO';
		moneda.formato="0,0.00";
		moneda.formatPattern=/^[0-9]+([,][0-9]+)?$/g;
		moneda.inputPattern=/[^0-9,]/g;
		break;
	default:
		moneda.descripcion='Moneda no registrada';
		moneda.formato="0,0.00";
		moneda.formatPattern=/^[0-9]+([,][0-9]+)?$/g;
		moneda.inputPattern=/[^0-9,]/g;
		break;
	}
	
	return moneda;
}

function formateoDeMontoEntero(num)
{
	var separador=num.split(",");
	var decimal;
	var entero;
	if(separador.length>2){
		entero=separador[0];
		decimal=separador[1];
		entero=format(entero);
		num=entero+","+decimal;
	}else if(separador.length===2){
		entero=separador[0];
		decimal=separador[1];
		if(entero.length>0 && entero.length<=16){
			entero=format(entero);
			num=entero+","+decimal;
		}else if(entero.length>16){
			entero=entero.slice(0,-2);
			entero=format(entero);
			num=entero+","+decimal;
		}
	}else{
		entero = separador[0];
		if(entero.length>0 && entero.length<=16){
			num=format(num);
		}else if(entero.length>16){
			entero=entero.slice(0,-2);
			num=format(entero);
		}
	}
	return num;
}

function formatMontoDecimal(num){
	var separador=num.split(",");
	var decimal;
	var entero;
	if(separador.length>2){
		entero=separador[0];
		decimal=separador[1];
		entero=format(entero);
		num=entero+","+decimal;
	}else if(separador.length===2){
		entero=separador[0];
		decimal=separador[1];
		if(decimal.length>0 && decimal.length<=2){
			entero=format(entero);
			num=entero+","+decimal;
		}else if(decimal.length>2){
			decimal=decimal.slice(0,-1);
			entero=format(entero);
			num=entero+","+decimal;
		}if(decimal.length===0){
			num=format(entero);
			num=num+",";
		}	
	}else{
		num=format(num);
	}
	return num;
}

function format(input)
{
	var num = input.replace(/\./g,'');
	if(!isNaN(num)){
		num = num.toString().split('').reverse().join('').replace(/(?=\d*\.?)(\d{3})/g,'$1.');
		num = num.split('').reverse().join('').replace(/^[\.]/,'');
		input = num;
	}else{ 		
		input = "-1";
	}
	return input;
}
		
$('.numbers-only').bind('keypress', function (event) {
    var regex = new RegExp(REGEX_NUMBERS_ONLY);
    var key = String.fromCharCode(!event.charCode ? event.which : event.charCode);
    if (!regex.test(key)) {
       event.preventDefault();
       return false;
    }
});