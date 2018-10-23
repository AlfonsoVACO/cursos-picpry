//jQuery.getScript("./generales/requester/Validacion.js", function(){
	
	var objectSend = {
		type : "null",
		url : "null",
		data: {},
		cache : false,
		success : function( response ) {
			console.log( response );
			getSuccessfulMessage();
		},
		error : function ( XMLHttpRequest, textStatus, errorthrows ){
			getErrorMessage( getCodeStatus( XMLHttpRequest, textStatus ) );
		}
	};
	
	function sendData( idElement ) {
		var lstElements = $(".valid-errors").find("input");
		var lstStringscmd = $(idElement).attr("data-list-str");
		var arraryString = lstStringscmd.split(",");
		var reduce = $(idElement).attr("data-remain") == '' ? 0: $(idElement).attr("data-remain");
		if( validate( idElement, lstElements, arraryString )  ){
			var objetoAdmin = convertToObject(
					lstElements.filter(function( item ){
						return listSend( idElement ).includes( $(this).attr("id") ) ? false : true;
					}), 
					reduce
			);
			var ulrString = "";
			for(var i = 0; i < arraryString.length; i++){
				var cadena = arraryString[i].substring(reduce, arraryString[i].length);
				ulrString += cadena + "="+ $("#"+arraryString[i]).val() + "?";
			}
			
			if(getPasswordinArray()){
				setActionMethod( idElement, objetoAdmin, ulrString.substring( 0, (ulrString.length -1) ) );
				
				if( $(idElement).attr("data-onclear") == "true"){
					clearFElements( idElement );
					clearList(arraryString);
					console.log( objectSend.url );
				}
			}else{
				getErrorMessage("Los campos contraseñas deben coincidir");
			}
		}
	
	}
	
	function getPasswordinArray(){
		var listpass = $("form").find("input").filter(function( item ){
			return "password" == $(this).attr("type") ? true : false;
		});
		
		if(listpass.length == 2){
			var cadenassh = "";
			var item = 0;
			var valid = 0;
			$.each(listpass,function(key, value){
				if( item != 0 ){
					if(cadenassh == $(value).val()){
						return true;
					}
				}else{
					cadenassh = $(value).val();
					item++;
				}
			});
			return  false;
		}
		
		return true;
		
	}
	
	function clearFElements( idElement ){
		clearElements($(".valid-errors").find("input").filter(function( item ){
			return listValid( idElement).includes( $(this).attr("id") ) ? false : true;
		}));
	}
	
	function setActionMethod( idElement, objeto, stringCadeurl ){
		var value = $(idElement).attr("data-href-method");
		var url = $(idElement).attr("data-href-url");
		objectSend.data = objeto;
		switch( value ){
			case "post":
				objectSend.type="post";
				objectSend.url = url +"/add?"+ stringCadeurl;
				break;
			case "put": 
				objectSend.type="put";
				objectSend.url = url +"/edit";
				break;
			case "delete": 
				objectSend.type="delete";
				objectSend.url = url +"/delete";
				break;
			default: return; break;
		}
		
		$.ajax( objectSend );
	}
	
	function getCodeStatus( jqXHR, textStatus ){
		if (jqXHR.status === 0)
		    return 'Error de conexióm.';
		else if (jqXHR.status == 404)
			return 'Página no encontrada.';
		else if (jqXHR.status == 500)
			return 'Error interno en servidor.';
		else if (textStatus === 'parsererror')
			return 'El análisis JSON solicitado fracasó.';
		else if (textStatus === 'timeout')
			return 'Tiempo de espera terminado.';
		else if (textStatus === 'abort')
			return 'Solicitud ajax cancelada.';
		else
			return 'Error desconocido: ' + jqXHR.responseText;
	}
	
	function getErrorMessage( error ){
		let title = new Element('h1',{class:'modal-window-title'},[ "¡UPS!" ]);
		let text = new Element('p',{class:'modal-window-text'},[error]);
		let e = new Modal('div',{class:'modal-window-content'},[ title, text]);
		document.body.appendChild(e);
	}
	
	function getSuccessfulMessage(){
		let image = new Element('div',{class:'modal-window-image'},["<svg viewBox=\"0 0 32 32\" style=\"fill:#48DB71\"><path d=\"M1 14 L5 10 L13 18 L27 4 L31 8 L13 26 z\"></path></svg>"]);
		let title = new Element('h1',{class:'modal-window-title'},[ "¡LISTO!" ]);
		let text = new Element('p',{class:'modal-window-text'},['La operación se hizo correctamente']);
		let e = new Modal('div',{class:'modal-window-content'},[ image, title, text]);
		document.body.appendChild(e);
	}
	
	function getSize( input ){
		var tamanio = $(input).attr("data-image-size").trim().split(",");
	    var fReader = new FileReader();
	    fReader.onload = function( event ){
	    	var img = new Image();
	    	img.src = event.target.result;
	    	img.onload = function() {
	    		$(input).attr( "data-loaded", "false" );
	    		if ( this.height > tamanio[1] && this.width > tamanio[0] ){
	    			$(input).attr( "data-loaded", "true" );
	    		}
	    	}
	    }
	    fReader.readAsDataURL( input[0].files[0] );
	}
	
	function setArchive( fileElement ){
		var progress = $(fileElement).attr("data-progress");
	    if( progress != undefined)
	    	$( "#" + progress ).show("slow");
	    
	    if( $(fileElement).attr("data-image-size") != undefined ){
	    	getSize( $(fileElement) );
		}
	
	    var filePath = $(fileElement).val();
	    var lstExtensions = $(fileElement).attr("accept").trim().split(",").filter(function(item){
	    	return item == (filePath.substring(filePath.lastIndexOf("."))).toLowerCase();
	    });
	
	    if(lstExtensions.length == 0){
	        $(fileElement).val("");
	        return false;
	    }else{
	    	if( progress != undefined)
	            getProgress( progress );
	    	setTimeLeftImg( $(fileElement), progress );
	    }
	};
	
	function getProgress( progress ){
		var width = 1;
	    var id = setInterval(function () {
	        if (width >= 100) {
	            clearInterval(id);
	        } else {
	            width++;
	            $("#" + progress).val(width);
	        }
	    }, 30);
	}
	
	function setTimeLeftImg( reference, idprogress ){
		setTimeout( function(){
			if( reference.attr("data-loaded") == "true" ){
				if (reference[0].files && reference[0].files[0] && reference.attr("data-preview") != undefined) {
					var reader = new FileReader();
					reader.onload = function(e) {
						$("#" + reference.attr("data-preview") ).fadeIn("slow", function() {
							var dato = '<img class="rounded-circle mx-auto d-block" src="'+e.target.result+'">';
							$(this).html(dato).slideDown("slow");
						});
					};
					reader.readAsDataURL(reference[0].files[0]);
				}
				if( idprogress != undefined)
		              $("#" + idprogress).hide("slow");
			}else{
				reference.val("");
				$("#" + reference.attr("data-preview")).fadeOut("slow", function() {
					$(this).html("").slideUp("slow");
				});
				if( idprogress != undefined)
		              $("#" + idprogress).hide("slow");
				return false;
			}
		}, 3000, reference);
	}
	
	$(".sendDataMeta").on("submit", function(e){
	    e.preventDefault();
	    var f = $(this);
	    var formData = new FormData(document.getElementsByClassName("sendDataMeta"));
	    var lstElements = $(".valid-errors").find("input");
	    var idElement = $(".sendmeta");
	    if( validate( idElement, lstElements, [] ) ){
	    	$.ajax({
	            url: $(idElement).attr("data-href-post"),
	            type: "post",
	            dataType: "html",
	            data: formData,
	            cache: false,
	            contentType: false,
	            processData: false
	        }).done(function(res){
	            
	        });
	    	if( $(idElement).attr("data-onclear") == "true"){
				clearElements($(".valid-errors").find("input").filter(function( item ){
					return listValid( idElement).includes( $(this).attr("id") ) ? false : true;
				}));
			}
	    }
	    
	});
	
	function listSend( idElement ){
		return $(idElement).attr("data-onsend") != "[]" ? JSON.parse( $(idElement).attr("data-onsend") ) : [];
	}
	
	function listValid( idElement ){
		return $(idElement).attr("data-onvalid") != "[]" ? JSON.parse( $(idElement).attr("data-onvalid") ) : [];
	}
	
	function validate( idElement, lstElements, lstStrings ){
		var result = onEmpty({
			lstString: lstStrings,
			normalStyle : { "border" : "solid 1px #eee" },
			showErrors : true,
			errorStyle : { "border" : "solid 1px red" },
			otherConf : { "confemail" : false, "elements":true },
			lstElements: lstElements.filter(function( item ){
				return listValid( idElement ).includes( $(this).attr("id") ) ? false : true;
				})
		});
		return result;
	}

	
	function isValidType( idElement ){
		$(idElement).attr("pattern");
	}
	
	function getItem(id) {
		var hrefs = $(id).attr("data-href-to-view");
		if ($(id).attr("data-href-to-menu") != undefined) {
			var contenido = $(id).attr("data-href-to-menu");
			$(".change-menu").find(".active").removeClass("active");
			$(".change-menu li span[data-href*='" + contenido + "']").parent("li").addClass("active");
			document.title = contenido;
		}
	
		var idelement = {
			id : 0
		};
		if ($(id).attr("data-href-to-view-data") != undefined) {
			idelement.id = $(id).attr("data-href-to-view-data");
			$.ajax({
				type : "get",
				url : hrefs + "/" + idelement.id,
				cache : false,
				success : function(dato) {
					$(".main-content").fadeOut("slow", function() {
						$(this).html(dato).slideDown("slow");
					});
				},
				error : function(XMLHttpRequest, textStatus, errorthrows) {
					alert('Error: ' + errorthrows);
				}
			});
		}else{
			$.ajax({
				type : "get",
				url : hrefs,
				cache : false,
				success : function(dato) {
					$(".main-content").fadeOut("slow", function() {
						$(this).html(dato).slideDown("slow");
					});
				},
				error : function(XMLHttpRequest, textStatus, errorthrows) {
					alert('Error: ' + errorthrows);
				}
			});
		}
		
	}
	
	function getItemOnLoad(){
		$.ajax({
			type : "get",
			url : "/admin/index",
			cache : false,
			success : function(dato) {
				$(".main-content").fadeOut("slow", function() {
					$(this).html(dato).slideDown("slow");
				});
			},
			error : function(XMLHttpRequest, textStatus, errorthrows) {
				alert('Error: ' + errorthrows);
			}
		});
	}
	
	class Element{
		constructor(type,attributes,children){
			return this.createCustomElement(type,attributes,children);
		}
		
		createCustomElement(type,attributes,children){
			let element=document.createElement(type);
			if(children !== undefined) this.addChildren(element,children);
			this.addAttributes(element,attributes);
			return element;
		}
		
		addAttributes(element,attrObj){
			for(let attr in attrObj){
				if(attrObj.hasOwnProperty(attr)) element.setAttribute(attr,attrObj[attr]);
			}
		}
		
		addChildren(element,children){
			children.forEach(el =>{
				if(el.nodeType== 1 || el.nodetype==11) element.appendChild(el);
				else element.innerHTML+=el
			});
		}
		
	}
	
	class Modal extends Element{
		constructor(type,attributes,children){
			super('div',{class:'modal-window'},[]);
			Element.prototype.addChildren(this,[Element.prototype.createCustomElement(type,attributes,children)]);
			console.log(this)
			this.addEventListener('click',function(e){
				if(e.target === this) Modal.prototype.closeModal.call(this);
			});
		}
		
		closeModal(){
			document.body.removeChild(this);
		}
	}
	
	//function send

//});
