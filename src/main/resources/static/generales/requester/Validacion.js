var onEmpty;
jQuery.getScript("./generales/requester/OperationsValidation.js", function(){
	
	class Validacion{
		
		constructor( objConfig, isElement ) {
			this.isElement 		= isElement;
			this.lstelements 	= objConfig.lstE;
			this.arraylst		= objConfig.lstS	;
			this.stylenormal	= objConfig.stlN;
			this.type			= objConfig.show;
			this.styleerror		= objConfig.stlE;
			this.mailmesage		= objConfig.other;
		}
		
		getType(){
			
			var i = 0;
			var operations = new OperationsValidation( this.type, this.styleerror, this.mailmesage );
			var values = new Array();
			
			if (this.isElement) {
				jQuery.each(this.lstelements, function(key, value) {
					var atributoId = jQuery(value).attr("id");
					
					switch ( jQuery(value).get(0).nodeName ) {
						case "INPUT": {
							switch (jQuery(value).attr("type")) {
								case "email": {
									values[i] = operations.getEmail( value, true );
								}break;
								case "text": {
									values[i] = operations.getValueText(value, true);
								}break;
								case "tel": {
									values[i] = operations.getValueText(value, true);
								}break;
								case "password": {
									values[i] = operations.getValueText(value, true);
								}break;
								case "checkbox": {
									values[i] = jQuery(value).is(":checked") ? true: false;
								}break;
								case "radio": {
									values[i] = jQuery(value).is(":checked") ? true: false;
								}break;
								case "date": {
									values[i] = operations.getExpresion( jQuery(value).val(), "f");
								}break;
							}
						}break;
						case "TEXTAREA": {
							values[i] = operations.getValueText(value,atributoId);
						}break;
						case "SELECT": {
							values[i] = operations.getValueSelect(value, atributoId);
						}break;
						default:break;
					}
					i++;
				});
			}
			
			for (var _i = i, arraylst_1 = this.arraylst; _i < arraylst_1.length; _i++) {
				var datoItem = arraylst_1[_i];
				switch (jQuery("#" + datoItem).get(0).nodeName) {
					case "INPUT": {
						switch (jQuery("#" + datoItem).attr("type")) {
							case "email": {
								values[_i] = operations.getIEmail(datoItem, false);
							}break;
							case "text": {
								values[_i] = operations.getValueText(datoItem, false);
							}break;
							case "tel": {
								values[_i] = operations.getValueText(datoItem, false);
							}break;
							case "password": {
								values[_i] = operations.getValueText(datoItem, false);
							}break;
							case "checkbox": {
								values[_i] = jQuery("#" + datoItem).is(":checked") ? true: false;
							}break;
							case "radio": {
								values[_i] = jQuery("#" + datoItem).is(":checked") ? true: false;
							}break;
							case "date": {
								values[_i] = operations.getExpresion(jQuery("#" + datoItem).val(), "f");
							}break;
						}
					}break;
					case "TEXTAREA": {
						values[_i] = operations.getValueText(datoItem, false);
					}break;
					case "SELECT": {
						values[_i] = operations.getValueSelect(datoItem, false);
					}break;
					default:break;
				}
			}
			var desition = values.filter(function(item) {
				return item == false;
			});
			return desition.length > 0 ? false : true;
		}		
	}
	
	onEmpty = function( objectConfg ) {
		if (objectConfg != undefined) {
			
			var arraylst = objectConfg.lstString != undefined ? objectConfg.lstString : [];
			var stylenormal = objectConfg.normalStyle != undefined ? objectConfg.normalStyle: { "border" : "1px solid #eee" };
			var type = objectConfg.showErrors !== undefined ? objectConfg.showErrors : false;
			var styleerror = objectConfg.errorStyle != undefined ? objectConfg.errorStyle: {"border" : "1px solid red"};
			var mailmesage = objectConfg.otherConf != undefined ? objectConfg.otherConf: {"confemail" : false,"elements" : false};
			var lstelements = objectConfg.lstElements != undefined ? objectConfg.lstElements: undefined;
			
			var elementsfist;
			
			var config = { 
					"lstS":arraylst,
					"stlN":stylenormal,
					"show":type,
					"stlE":styleerror,
					"other":mailmesage,
					"lstE":lstelements
			};
			
			if ( lstelements != undefined ) {
				jQuery.each( lstelements, function( key, value ) {
					jQuery( value ).css( stylenormal );
					if ( type ) {
						jQuery("#err" + jQuery( value ).attr("id") ).hide("slow");
					}
					if (mailmesage.confemail) {
						jQuery("#err-email-" + jQuery(value).attr("id")).hide("slow");
					}
				});
				var validationes = new Validacion( config, true);				
				return validationes.getType();
			}
			
			for (var _i = 0, arraylst_2 = arraylst; _i < arraylst_2.length; _i++) {
				var valoritem = arraylst_2[_i];
				jQuery("#" + valoritem).css( stylenormal );
				if (type) {
					jQuery("#err" + valoritem ).hide("slow");
				}
				if (mailmesage.confemail) {
					jQuery("#err-email-" + valoritem).hide("slow");
				}
			}
			var validationes = new Validacion(config, false);
			return validationes.getType();
		}
		return false;
	};


});

var clearList;
var clearElements;
var convertToClass;
var convertToObject;
jQuery.getScript("./generales/requester/OperationsElements.js", function(){
	
	clearList = function( lstString ){
		var execution = new OperationsElements(lstString);
		execution.clearList();
	}
	
	clearElements = function(lstElements) {
		var execution = new OperationsElements(lstElements);
		execution.clearElements();
	}
	
	convertToClass = function(classtoConvert, objeto) {
		jQuery.each(objeto, function(key, value) {
			classtoConvert[key] = value;
		});
		return classtoConvert;
	}
	
	convertToObject = function( arraylst, remain ) {
		var execution = new OperationsElements( arraylst );
		return execution.convertToObject( remain );
	}
	
	jQuery(".data-numeric").keypress(function() {
		var operations = new OperationsValidation();
		if (operations.getExpresion(jQuery(this).val(), "n")) {
			jQuery(this).val("");
		}
	});

	jQuery(".data-decimal").keypress(function() {
		var operations = new OperationsValidation();
		if (operations.getExpresion(jQuery(this).val(), "n")) {
			jQuery(this).val("");
		}
	});
	
});
