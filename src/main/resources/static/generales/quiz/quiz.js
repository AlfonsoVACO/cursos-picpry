var objQuiz = new Quiz(listQuestions);
var lista = objResource.getNewArray(10, objQuiz.getObject() );	
var lstresp = []; 
var id = 1;
var itempos = 0;

$.each(lista,function( k , v ){
	var btn = new Element('button',{type:'button',class:'btn btn-info', 'data-in':k },[ (k+1) ] );
	btn.addEventListener("click", function(){ // click en item de
		setReactInSelected( k );
		getQuestion(v.options, v.type, v.q, k);
	});
	$("#itemslist").append(btn);
	lstresp.push( new Answer(v.idquestion, []) );
	
	if( k == 0 ){
		getQuestion(v.options, v.type, v.q, k);
		$("#nextfinished").append( new Element('input',{type:'button',class:'btn btn-info', id:'btnnextFin', 'data-on': ( k + 1 ), value:'Siguiente' },[ ] ) );
	}
	
});

function radio( element ){
	var list = $("#itemquest").find("input[type='radio']").filter(function(item){ return $(this).attr("id") == $(element).attr("id") ? false: true; });
	$.each(list,function(i, elem){ $(elem).prop("checked", false); });
}

function getQuestion( options, type, q, k ){
	$(".contextual").remove();
	let respuestas =  new Element('div',{ class:'options' },[ ]);
		
	$.each(options, function(key, valu){
		var ishere = false;
		if( lstresp[k].answers.length > 0  ){
			$.each(lstresp[k].answers, function(keyl, valuel){
				if( valuel == key ) ishere = true;
			});
		}
		var valuesCheck;
		if( ishere )
			valuesCheck = new Element('input',{ type:type, onclick:'radio(this)', id:'ans' + key, checked: ishere },[]);
		else
			valuesCheck = new Element('input',{ type:type, onclick:'radio(this)', id:'ans' + key },[]);
		
		respuestas.append( new Element('div',{ class:'form-row' },[
			new Element('div',{ class:'col-auto', style:'padding:5px;' },[ valuesCheck ]),
			new Element('div',{ class:'col-auto', style:'padding:5px;' },[
				new Element('p',{ },[ valu ])
			])
		]));
	});
	
	$("#itemquest").append(new Element('div',{ class:'contextual', id:'idques'+k },[ 
		new Element('div',{ class:'question' },[ q,
			new Element('div',{ class:'options' },[ respuestas ] )
		] )
	]));
	
	if( k > 0){
		if($("#btnbefore").val() == undefined)
			$("#before").append( new Element('input',{type:'button', class:'btn btn-info', id:'btnbefore',onclick:'getAction(this);', 'data-on': ( k - 1 ), value:'Anterior' },[ ] ) );
		else
			$("#btnbefore").attr('data-on', (k-1) );
	}else
		$("#btnbefore").remove();

	if( (lista.length -1) == k )
		$("#btnnextFin").val("Terminar");
	else{
		$("#btnnextFin").val("Siguiente");
		$("#btnnextFin").attr("data-on", (k + 1) );
	}
	activeOption(k);
}

function activeOption(position){
	$.each( $("#itemslist").find("button"),function (k, val){ $(val).removeClass("active"); });
	$("button[data-in='"+position+"']").addClass("active");
}

$("#btnnextFin").click(function(){
	var position = parseInt($(this).attr("data-on"));
	if( $(this).val() == "Siguiente" ){
		setReact( position );
		getQuestion( lista[position].options, lista[position].type, lista[position].q, position );
	}else{
		setReact( position +1 );
		var resp = confirm("¿Está seguro de querer terminar el Quiz?");
		if(resp == true){
			sendParse();
			clearInterval(countTimer);
		}
	}
});

function getAction(elment){
	var position = parseInt($(elment).attr("data-on"));
	setReactBef( position );
	getQuestion( lista[position].options, lista[position].type, lista[position].q, position );
};

function setReactInSelected( position ){
	if( $(".contextual").find("input[id*=ans]").filter(function(index,item){ console.log($(item)); return $(item).is(":checked") ? true: false; }).length > 0  ){
		$.each(lstresp[position ].answers,function(key,value){ lstresp[position ].answers.pop(); });
		var listaDivs = $(".contextual").find("input[id*=ans]");
		$.each(listaDivs,function(key,value){
			if( $(value).is(":checked") ) lstresp[position ].answers.push(key);
		});
		console.log("Había seleccionadas");
	}else{
		//if( position == 0) position++;
		console.log("No había seleccionadas");
		$.each(lstresp[position].answers,function(key,value){ lstresp[position].answers.pop(); });
	}
	//getQuestion( lista[position].options, lista[position].type, lista[position].q, position );
}

function setReactBef( position ){
	if( $(".contextual").find("input[id*=ans]").filter(function(item){ return $(this).is(":checked") ? true: false; }).length > 0  ){
		$.each(lstresp[position +1 ].answers,function(key,value){ lstresp[position +1 ].answers.pop(); });
		var listaDivs = $(".contextual").find("input[id*=ans]");
		$.each(listaDivs,function(key,value){
			if( $(value).is(":checked") ) lstresp[position + 1].answers.push(key);
		});
	}else{
		//if( position == 0) position++;
		$.each(lstresp[position +1].answers,function(key,value){ lstresp[position +1].answers.pop(); });
	}
}

function setReact( position ){
	if( $(".contextual").find("input[id*=ans]").filter(function(item){ return $(this).is(":checked") ? true: false; }).length > 0  ){
		$.each(lstresp[position -1 ].answers,function(key,value){ lstresp[position -1 ].answers.pop(); });
		var listaDivs = $(".contextual").find("input[id*=ans]");
		$.each(listaDivs,function(key,value){
			if( $(value).is(":checked") ) lstresp[position - 1].answers.push(key);
		});
	}else{
		if( position == 0) position++;
		$.each(lstresp[position -1].answers,function(key,value){ lstresp[position -1].answers.pop(); });
	}
}

var segundos=200;
/*function countDown(){
	var minutes = Math.round( (segundos-30) /60);
	var remain = segundos % 60;
	if(remain<1) remain = "0";
	
	document.getElementById("timer").innerHTML = minutes + ":" + remain;
	if(segundos==0){
		clearInterval(countTimer);
		sendParse();
	}else segundos--;
}
var countTimer = setInterval(countDown,1000);*/

function sendParse(){
	var cadena = "";
	$.each(lstresp, function(k,v){
		cadena += v.idquestion + ",";
		$.each(v.answers, function(key,val){
			if(v.answers.length == key) cadena += val; else cadena += val +"-";
		});
		cadena = cadena.substring(0, cadena.length - 1);
		if(lstresp.length != k) cadena += ":";
	});
	cadena = cadena.substring(0, cadena.length - 1);
	console.log(lstresp);
	setDataEnd(new Registroquiz(lista.length,0,(lista.length / 100),cadena, document.getElementById("timer").innerHTML, lstresp));
}

function setDataEnd(senddata){
	$.ajax({
		url:"/quizquest/edit/"+id,
		data:senddata,
		type:"put",
		success:function(response){
			console.log(response.idregistro);
			
		},
		error : function ( XMLHttpRequest, textStatus, errorthrows ){
			getErrorMessage( getCodeStatus( XMLHttpRequest, textStatus ) );
		}
	});
}