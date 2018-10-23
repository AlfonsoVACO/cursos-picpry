class OperationsValidation {
	
	constructor(isVisible, styleerror, mailmesage) {
		this.styleerror = styleerror;
		this.isVisible	= isVisible;
		this.mailmesage	= mailmesage;
	}

	getEmail(item, typeDOM) {
		var valoritem = typeDOM == true ? jQuery( item ).val() : jQuery("#" + item).val();
		if (valoritem === "") {
			typeDOM == true ? jQuery(item).css(this.styleerror): jQuery("#" + item).css(this.styleerror);
			if (this.isVisible) {
				typeDOM == true ? jQuery("#err" + jQuery(item).attr("id") ).show("slow"): jQuery("#err" + item).show("slow");
			}
			return false;
		}
		if ( this.getExpresion(valoritem, "c") === false ) {
			typeDOM == true ? jQuery(item).css(this.styleerror): jQuery("#" + item).css(this.styleerror);
			if (this.mailmesage.confemail) {
				typeDOM == true ? jQuery("#err-email-" + jQuery(item).attr("id") ).show("slow"): jQuery("#err-email-" + item).show("slow");
			}
			if (this.isVisible) {
				typeDOM == true ? jQuery("#err" + jQuery(item).attr("id") ).show("slow"): jQuery("#err" + item).show("slow");
			}
			return false;
		}
		return true;
	}
	
	isPassword(obj) {
		if (/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*?&#/()=?¡¿+-.,;:{}|])(^[A-Za-z\d$@$!%*?&#/()=?¡¿+-.,;:{}|]+$)/
				.test(obj.value)
				&& obj.len >= 8) {
			$(obj.onTrue).show("fast");
			$(obj.onFalse).hide("fast");
		} else {
			$(obj.onTrue).hide("fast");
			$(obj.onFalse).show("fast");
		}
	}
	
	getValueText( item, typeDOM) {		
		var valoritem = typeDOM == true ? jQuery( item ).val() : jQuery("#" + item).val();
		
		if (valoritem === "") {
			typeDOM == true ? jQuery(item).css(this.styleerror): jQuery("#" + item).css(this.styleerror);
			if (this.isVisible) {
				typeDOM == true ? jQuery("#err" + jQuery(item).attr("id") ).show("slow"): jQuery("#" + item).show("slow");
			}
			return false;
		}
		return true;
	}
	
	getValueSelect(item, typeDOM) {
		var valoritem = typeDOM == true ? jQuery( item ).val() : jQuery("#" + item).val();
		if (valoritem === "" || valoritem === "0" || valoritem === undefined) {
			typeDOM == true ? jQuery(item).css(this.styleerror): jQuery("#" + item).css(this.styleerror);
			if (this.isVisible) {
				typeDOM == true ? jQuery("#err" + jQuery(item).attr("id") ).show("slow"): jQuery("#" + item).show("slow");
			}
			return false;
		}
		return true;
	}
	
	getExpresion(value, type){
		if (jQuery.trim(type) === "n") {
			if (!/^([1-9])*$/.exec(value)){
				return true;
			}			
			return false;
		} else if (jQuery.trim(type) === "d") {
			if (!/^[1-9]+([.])?([0-9]+)?$/.exec(value)) {
				return true;
			}
			return false;
		} else if (jQuery.trim(type) === "c") {
			if (!/^[_a-z0-9-]+(.[_a-z0-9-]+)*@[a-z0-9-]+(.[a-z0-9-]+)*(.[a-z]{2,3})$/
					.exec(value)) {
				return false;
			}
			return true;
		} else if (jQuery.trim(type) === "f") {
			if (!/^(19|20)[0-9]{2}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$/
					.exec(value)) {
				return false;
			}
			return true;
		}
	}

}