function getCodeStatus(jqXHR, textStatus) {
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
	let e = new Modal('div',{class:'modal-window-content'},[  
		new Elements('h1',{class:'modal-window-title'},[ "¡UPS!" ]),
		new Elements('p',{class:'modal-window-text'},[error]) ]);
	document.body.appendChild(e);
}

function getSuccessfulMessage(){
	let e = new Modal('div',{class:'modal-window-content'},[
		new Elements('div',{class:'modal-window-image'},["<svg viewBox=\"0 0 32 32\" style=\"fill:#48DB71\"><path d=\"M1 14 L5 10 L13 18 L27 4 L31 8 L13 26 z\"></path></svg>"]),
		new Elements('h1',{class:'modal-window-title'},[ "¡LISTO!" ]),
		new Elements('p',{class:'modal-window-text'},['La operación se hizo correctamente']) ]);
	document.body.appendChild(e);
}

var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
        return extendStatics(d, b);
    }
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();

var Elements = /** @class */ (function(){
	function Elements( type, attributes, children ){
		return this.createCustomElement( type, attributes, children );
	}
		
	Elements.prototype.createCustomElement = function( type, attributes, children ){
		var element = document.createElement( type );
		if(children !== undefined) this.addChildren( element, children );
		this.addAttributes(element, attributes);
		return element;
	};
		
	Elements.prototype.addAttributes = function(element, attrObj){
		for(let attr in attrObj){
			if(attrObj.hasOwnProperty( attr )) element.setAttribute( attr, attrObj[attr] );
		}
	};
		
	Elements.prototype.addChildren = function(element, children){
		for(var i = 0; i < children.length; i++){
			if(children[i].nodeType== 1 || children[i].nodetype==11) element.appendChild(children[i]);
			else element.innerHTML += children[i]
		}
	};
	return Elements;
}());
	
var Modal = /** @class */ (function (_super) {
    __extends(Modal, _super);
    function Modal(type, attributes, children) {
        var _this = _super.call(this, 'div', { class: 'modal-window' }, []) || this;
        Elements.prototype.addChildren(_this, [Elements.prototype.createCustomElement(type, attributes, children)]);
        _this.addEventListener('click', function (e) {
            if (e.target === this)
                Modal.prototype.closeModal.call(this);
        });
        return _this;
    }
    Modal.prototype.closeModal = function () {
        document.body.removeChild(this);
    };
    return Modal;
}(Elements));