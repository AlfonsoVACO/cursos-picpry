/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function limpiarcampos(arreglo){
            for(var i = 0; i < arreglo.length; i++){$("#"+arreglo[i]).val("");}    
}
function errores(arreglo, borde, type){
    var values = true;
    for(var i = 0; i < arreglo.length; i++){
        document.getElementById(arreglo[i]).style.border = "1px solid " + borde;
        if(type){
            $("#err"+arreglo[i]).hide("slow");
        }
    }    
    for(var i = 0; i < arreglo.length; i++){
        if(document.getElementById(arreglo[i]).value === ""){
            document.getElementById(arreglo[i]).style.border = "1px solid red";
            if(type){
                $("#err"+arreglo[i]).show("slow");
            }
            values = false;
        }
    }    
    return values;
}

function impementacionajaxsc(url, type ,data, load, rutaimg, dimimg, accion, cache){
    var send = function(){
        if(load !== null)
            $("#" + load).html("<center><img style='height: "+dimimg+"%;width: "+dimimg+"%;' src='"+rutaimg+"'></center>");
    };
    $.ajax({
        type: type,
        url: url,
        data: data,
        cache: cache,
        beforeSend: send,
        success: function(dato){
            if($.trim(dato) === "1"){
                $("#exi"+accion).show("slow");
            }else{
                $("#err"+accion).show("slow");
            }
        },
        error: function(XMLHttpRequest,textStatus,errorthrows){
            alertify.alert("Guissa","Ocurrió un error: "+ errorthrows);
        }
    });
}
