	var successColor ={
		    "border-bottom": "solid 1px #ddd"
	};
	var errorColor ={
		    "border-bottom": "solid 1px red"
	}
	var objectSend = {
		type : "null",
		url : "null",
		data: {},
		cache : false,
		success : function( response ) {
			// console.log( response );
			getSuccessfulMessage();
		},
		error : function ( XMLHttpRequest, textStatus, errorthrows ){
			getErrorMessage( getCodeStatus( XMLHttpRequest, textStatus ) );
		}
	};
	
	function getListElements(){
		var lstInputs = $(".valid-errors").find("input");
		var lstSelects = $(".valid-errors").find("select");
		lstInputs.push(lstSelects);
		return lstInputs;
	}
	
	function sendData( idElement ) {
		var lstElements = getListElements();
		var lstStringscmd = $(idElement).attr("data-list-str") != undefined ? $(idElement).attr("data-list-str") : "";
		var arraryString = lstStringscmd =="" ? [] : lstStringscmd.split(",");
		var reduce = $(idElement).attr("data-remain") == '' ? 0: $(idElement).attr("data-remain");
		if( validate( idElement, lstElements, arraryString )  ){
			var objetoAdmin = convertToObject(
					lstElements.filter(function( item ){
						return $(this).attr("data-noset") != undefined ? false : true;
					}), 
					reduce
			);
			var ulrString = arraryString.length > 0 ? getNewsStrings(arraryString, reduce) : "";
			if(getPasswordinArray()){
				setActionMethod( idElement, objetoAdmin, ulrString.substring( 0, (ulrString.length -1) ) );
				if( $(idElement).attr("data-onclear") == "true"){
					clearFElements( idElement );
					clearList(arraryString);
				}
			}else{
				getErrorMessage("Los campos contraseñas deben coincidir");
			}
		}
	
	}
	
	function getNewsStrings(arraryString, reduce){
		var ulrString = "";
		for(var i = 0; i < arraryString.length; i++){
			var cadena = arraryString[i].substring(reduce, arraryString[i].length);
			ulrString += cadena + "="+ $("#"+arraryString[i]).val() + "?";
		}
		return ulrString;
	}
	
	function getPasswordinArray(){
		var listpass = $(".form").find("input[type='password']");
		if(listpass.length == 2){
			if($(listpass[0]).val() != $(listpass[1]).val() ) 
				return false
		}		
		return true;
		
	}
	
	function clearFElements( idElement ){
		clearElements($(".valid-errors").find("input").filter(function( item ){
			return $(this).attr("data-cleable") != undefined ? false : true;
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
					return $(this).attr("data-cleable") != undefined ? false : true;
				}));
			}
	    }
	    
	});
		
	function validate( idElement, lstElements, lstStrings ){
		var result = onEmpty({
			lstString: lstStrings != "" ? lstStrings : [],
			normalStyle : successColor,
			showErrors : true,
			errorStyle : errorColor,
			otherConf : { "confemail" : false, "elements":true },
			lstElements: lstElements.filter(function( item ){
				return $(this).attr("data-optional") != undefined ? false : true;
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
			this.addEventListener('click',function(e){
				if(e.target === this) Modal.prototype.closeModal.call(this);
			});
		}
		
		closeModal(){
			document.body.removeChild(this);
		}
	}
		
	function sendAjaxCodeZip( value ){
		$.ajax({
			type: "get",
			url: "https://api-codigos-postales.herokuapp.com/v2/buscar",
			data: { codigo_postal: value },
			success: function(response){
				$.get(
					"https://api-codigos-postales.herokuapp.com/v2/codigo_postal/" + response.codigos_postales[0],
					function( objeto ){
						sendDataCode( objeto );
					}
				);
			},
			error: function ( XMLHttpRequest, textStatus, errorthrows ){
				getErrorMessage( getCodeStatus( XMLHttpRequest, textStatus ) );
			}
		});
	}

	function sendDataCode( objeto ){
		$("#idmaauns").html("Estado: <span>"+objeto.estado+"</span><br>Municipio: <span>"+objeto.municipio+"</span>");
		$("#stridestado").val(objeto.estado);
		$("#stridmunicipio").val(objeto.municipio);
	}
	
	$(".zip").click(function(){
		if ( $("#strcp").val().length == 0 ) return;
		
		var btnZIP = $(this);
		var dondeBtnOk = $(this).attr("data-in");
		
		let mensaje = new Element('p',{class:'modal-window-text'},['¿Están correctos tus datos?']);		
		let estado = new Element('p',{id:'idmaauns'},[] );		
		let btnok = new Element('input',{ class: 'btn btn-default', type: 'button',style:'margin:4px', value:"Si" },[]);
		let btnnot = new Element('input',{ class: 'btn btn-default', type: 'button',style:'margin:4px', value:"No" },[]);
		
		btnok.addEventListener('click',function(e){
			$("#strcp").attr("disabled", true);
			$("#"+dondeBtnOk).append( getButtonMain() );
			$(".zip").remove();
			$(".modal-window").remove();
		});
		
		btnnot.addEventListener('click',function(e){
			$("#strcp").attr("disabled", false);
			$("#register-al").remove();
			$(".modal-window").remove();
		});
		
		let divbotones = new Element('div',{style:'display:block;float:center;position: relative;text-align: center;'},[btnok,btnnot ]);
		
		let e = new Modal('div',{class:'modal-window-content'},[ mensaje, estado, divbotones]);
		document.body.appendChild(e);
		sendAjaxCodeZip( $("#strcp").val() );
	});
	
	function getButtonMain(){
		return new Element('input',{ 
			'type': 'button', 'id': 'register-al',
			'onclick': 'sendData(this);',
			'data-onclear': 'true',
			'data-href-method': 'post',
			'data-remain': '3',
			'data-href-url': '/register', 'data-optional': '', 'data-noset': '',
			'data-cleable': '', class: 'btn btn-primary align-right', 
			'value': "Registrarse" },[]);
	}
