var objResource = new Resource();
var listQuestions = [];

/*listQuestions.push(new Question("Pregunta 1", ["Opción 1", "Opción 2"], [0], "Una description 1", 1, 1));
listQuestions.push(new Question("Pregunta 2", ["Opción 1", "Opción 2", "Opción 3"], [0, 1], "Una description 2", 2, 1));
listQuestions.push(new Question("Pregunta 3", ["Opción 1", "Opción 2", "Opción 3", "Opción 4"], [0, 2], "Una description 3", 3, 1));
listQuestions.push(new Question("Pregunta 4", ["Opción 1", "Opción 2", "Opción 3"], [1], "Una description 4", 4, 1));
listQuestions.push(new Question("Pregunta 5", ["Opción 1", "Opción 2", "Opción 3"], [2], "Una description 5", 5, 1));
listQuestions.push(new Question("Pregunta 6", ["Opción 1", "Opción 2", "Opción 3"], [0, 3], "Una description 6", 6, 1));*/


var objQuiz = new Quiz(listQuestions);
var lista = objQuiz.getObject();

var btn = document.getElementById("more");
var lista = document.getElementById("lst");
var clear = document.getElementById("clear");
var add = document.getElementById("add");
var listQuest = document.getElementById("listQuest");
var saveConfig = document.getElementById("saveConfig");
var sendAll = document.getElementById("sendAll");

var countList = 0;
var config = {
	aleatorio: false,
	timer: false,
	ontimer: "",
	maxquest:0,
	maxint:0,
	onmaxint:0,
	itsOk:false
};

btn.addEventListener("click",function(){
	$("#typeOption").prop("disabled",true);
	var typeValue = $("#typeOption").val();
	let divrow = new Element('div',{ class:'form-inline',id:'li' + countList, 'data-rem':'' },[
		new Element('div',{ class:'form-group', style:'padding:5px;' },[
			new Element('input',{type:typeValue, id:'corr' + countList, onclick:'radio(this)', value:'rad' + countList},[])
		]),
		new Element('div',{ class:'form-group', style:'padding:5px;' },[
			new Element('input',{ type:'text', id:'resp' + countList, class:'form-control' },[] )
		]),
		new Element('div',{ class:'form-group', style:'padding:5px;' },[
			new Element('input',{type:'button', id:'dell' + countList, value:'Delete', class:'btn btn-danger', onclick:'removeElemet("li'+countList+'")' },[])
		]),
		new Element('br',{ },[] )
	]);
	countList++;
	lista.appendChild(divrow);
});

clear.addEventListener("click",function(){
	clearAll();
});

add.addEventListener("click",function(){
	if( $("#question").val() == "" ){ alert("Agrega una pregunta"); return false; }
	
	var isEmptyElem = $("#lst").find("input[id*=corr]").filter(function(item){ return $(this).is(":checked") ? true: false; });
		
	if( isEmptyElem.length > 0 ) {
		var listaDivs = $("#lst").find("div[data-rem]");
		if( objResource.isEmptyList( listaDivs.find("input[type='text']") ) > 0 ){
			var opciones = objResource.getCampos( listaDivs );
			listQuestions.push( new Question($("#question").val(), opciones[0], opciones[1], $("#messages").val(), 0, 0, $("#typeOption").val() ) );
			$("#question").val("");
			setList();
			clearAll();
		}else
			alert("Hay respuestas sin rellenar");
		
	}else{
		alert("Tiene que haber una respuesta correcta");
	}
});

saveConfig.addEventListener("click",function(){
	if( $(".mainForce").find("input[id='sendAll']").length == 0 ){		
		var sendAll = new Element('input',{ type:'button',id:'sendAll',class:'btn btn-success',value:'Guardar' },[]);
		
		sendAll.addEventListener("click", function(){
			if( listQuestions.length <= 0 ){
				alert("No puedes guardar un cuestionario sin preguntas");
			}else{
				console.log({
					configuration: config,		
					lstQuest: listQuestions
				});
			}
		});
		
		$(".mainForce").append( sendAll );
	}
	
	config.aleatorio = $("#aleatorio").is(":checked");
	config.timer = $("#times").is(":checked");
	config.ontimer = $("#times").is(":checked") ? $("#time").val(): "";
	config.maxquest = $("#cantidadmuestra").val();
	config.maxint = $("#intento").is(":checked");
	config.onmaxint = $("#intento").is(":checked") == true ? $("#number").val(): 0;
	config.itsOk = true;
});

function removeElemet(id){
	$("#" + id).remove();
}

function radio( element ){
	var list = $("#lst").find("input[type='radio']").filter(function(item){ return $(this).attr("id") == $(element).attr("id") ? false: true; });
	$.each(list,function(i, elem){ $(elem).prop("checked", false); });
}

function clearAll(){
	$.each( $("#lst").find("div[data-rem]") ,function(i, elem){ $(elem).remove(); });
	$("#typeOption").prop("disabled",false);
	countList = 0;
}

function removeQuest( position ){
	listQuestions.splice(position, 1);
	setList();
}

setList();

function setList( ){
	var countListObj = 0;
	$.each( $("#listQuest").find("li[data-runge]"),function(k,v){ $(v).remove(); });
	$.each(listQuestions,function(k,v){
		var li = new Element('li',{ id:'quest'+countListObj, 'data-runge':'' },[
			new Element('div',{ class:'alert alert-info alert-dismissible', role:'alert' },[
				new Element('button',{ type:"button", class:'close', 'data-dismiss':'alert',onclick:'removeQuest(\''+countListObj+'\');', 'aria-label':'Close' },[
					new Element('span',{ 'aria-hidden':'true' },['&times;'] )
				]),
				v.question
			])
		]);
		countListObj++;
		listQuest.appendChild(li);
	});

}
$("#times").click(function(){
	if( $(this).is(":checked") )
		$(".times").append( new Element('input',{ type:'time',class:'form-control',id:'time',  pattern:'[0-9]{2}:[0-9]{2}:[0-9]{2}', step:'3', min:'00:01:00', max:'02:59:59' },[]) );
	else
		$("#time").remove();
});

$("#intento").click(function(){
	if( $(this).is(":checked") )
		$(".intento").append( new Element('input',{ type:'number', id:'number', min:'1', value:'1', class:'form-control' },[]) );
	else
		$("#number").remove();
});

// COOKIES
function getCookie(cname) {
	var name = cname + "=";
	var decodedCookie = decodeURIComponent(document.cookie);
	var ca = decodedCookie.split(';');
	for(var i = 0; i <ca.length; i++) {
		var c = ca[i];
		while (c.charAt(0) == ' ') {
			c = c.substring(1);
		}
		if (c.indexOf(name) == 0) {
			return c.substring(name.length, c.length);
		}
	}
	return "";
}

function getExpiresCookie(){
	var d = new Date();
	d.setTime(d.getTime() + (13 * 24 * 60 * 60 * 1000));
	return "expires=" + d.toUTCString();
}
//0445566553079 