class OperationsElements {
	
	constructor( arraylst ) {
		this.arraylst = arraylst;
	}
	
	clearList() {
		for (var _i = 0, arraylst_3 = this.arraylst; _i < arraylst_3.length; _i++) {
			var itemClear = arraylst_3[_i];
			switch (jQuery("#" + itemClear).get(0).nodeName) {
			case "INPUT":
				switch (jQuery("#" + itemClear).attr("type")) {
				case "checkbox": {
					jQuery("#" + itemClear).prop('checked', false);
				}
					break;
				case "radio": {
					jQuery("#" + itemClear).prop('checked', false);
				}
					break;
				default:
					jQuery("#" + itemClear).val("");
					break;
				}
				break;
			case "SELECT":
				jQuery("#" + itemClear)[0].selectedIndex = 0;
				break;
			case "TEXTAREA":
				jQuery("#" + itemClear).val("");
				break;
			}
		}
	}

	clearElements() {
		jQuery.each(this.arraylst, function(key, value) {
			switch (jQuery(value).get(0).nodeName) {
				case "INPUT":
					switch (jQuery(value).attr("type")) {
						case "checkbox": {
							jQuery(value).prop('checked', false);
						}
							break;
						case "radio": {
							jQuery(value).prop('checked', false);
						}
							break;
						default:
							jQuery(value).val("");
							break;
					}
					break;
				case "SELECT":
					jQuery(value).selectedIndex = 0;
					break;
				case "TEXTAREA":
					jQuery(value).val("");
					break;
			}
		});
	}
	
	convertToObject( remain ) {
		var objetoCreado = {};
		jQuery.each(this.arraylst, function(key, value) {
			switch (jQuery(value).get(0).nodeName) {
				case "INPUT":
					switch (jQuery(value).attr("type")) {
						case "checkbox": {
							var stringValue = jQuery(value).attr("id");
							var cadena = stringValue.substring(remain, stringValue.length);
							objetoCreado[cadena] = jQuery(value).is(":checked") ? true : false;
						}break;
						case "radio": {
							var stringValue = jQuery(value).attr("id");
							var cadena = stringValue.substring(remain, stringValue.length);
							objetoCreado[cadena] = jQuery(value).is(":checked") ? true : false;
						}break;
						default:{
							var stringValue = jQuery(value).attr("id");
							var cadena = stringValue.substring(remain, stringValue.length);
							objetoCreado[cadena] = jQuery(value).val();
						}break;
					}break;
				case "SELECT":{
					var stringValue = jQuery(value).attr("id");
					var cadena = stringValue.substring(remain, stringValue.length);
					objetoCreado[cadena] = jQuery(value).selectedIndex;
				}break;
				case "TEXTAREA":{
					var stringValue = jQuery(value).attr("id");
					var cadena = stringValue.substring(remain, stringValue.length);
					objetoCreado[cadena] = jQuery(value).val();
				}break;
			}
		});
		return objetoCreado;
	}

}