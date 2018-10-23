/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function controlresopi(accion, idDOM, id){
    var url = "accion=" + accion+ "&idcrud_com=" + id;
    getAjaxCom(url,idDOM,accion);
}

function getAjaxCom(url,idDOM,accion){
    $.ajax({
        type: "POST",
        url:"cnClientesComentarios?" + url,
        cache:false,
        success: function(dato){
            if($.trim(accion) === "aprobarR"){
                if($.trim(dato) === "1"){
                    $("#"+idDOM).hide("slow");
                    alertify.alert("Guissa","Respuesta aprobada");
                }else{
                    alertify.alert("Guissa","Error al aprobar");
                }
            }else if($.trim(accion) === "eliminarR"){
                if($.trim(dato) === "1"){
                    $("#"+idDOM).hide("slow");
                    alertify.alert("Guissa","Respuesta eliminada");
                }else{
                    alertify.alert("Guissa","Error al eliminar");
                }
            }else if($.trim(accion) === "aprobarO"){
                if($.trim(dato) === "1"){
                    $("#"+idDOM).hide("slow");
                    alertify.alert("Guissa","Pregunta aprobada");
                }else{
                    alertify.alert("Guissa","Error al aprobar");
                }
            }else if($.trim(accion) === "eliminarO"){
                if($.trim(dato) === "1"){
                    $("#"+idDOM).hide("slow");
                    alertify.alert("Guissa","Pregunta eliminada");
                }else{
                    alertify.alert("Guissa","Error al eliminar");
                }
            }
        },
        error: function(XMLHttpRequest,textStatus,errorthrows){
            alert("Ocurrió un error: "+ errorthrows);
        }
    });
}

function controladorUserC(accion, idDOM, id){
    var url = "enter=cl" + accion+ "&idcrud_com=" + id;
    getAjaxClientes(url,idDOM,accion);
}

function getAjaxClientes(url,idDOM,accion){
    $.ajax({
        type: "POST",
        url:"cnClientesClientes?" + url,
        cache:false,
        success: function(dato){
            if($.trim(accion) === "eliminar"){
                if($.trim(dato) === "1"){
                    $("#"+idDOM).hide("slow");
                    alertify.alert("Guissa","Eliminación completa");
                }else{
                    alertify.alert("Guissa","Error al eliminar");
                }
            }else if($.trim(accion) === "editar"){
                if($.trim(dato) === "1"){
                    $("#"+idDOM).hide("slow");
                    alertify.alert("Guissa","Editado con éxito");
                }else{
                    alertify.alert("Guissa","Error al editar");
                }
            }
        },
        error: function(XMLHttpRequest,textStatus,errorthrows){
            alert("Ocurrió un error: "+ errorthrows);
        }
    });
}

function controladorRese(accion, idDOM, id){
    var url = "accion=res" + accion+ "&idcrud_com=" + id;
    getAjaxReservaciones(url,idDOM,accion);
}

function getAjaxReservaciones(url,idDOM,accion){
    $.ajax({
        type: "POST",
        url:"cnClientesReservaciones?" + url,
        cache:false,
        success: function(dato){
            if($.trim(accion) === "eliminar"){
                if($.trim(dato) === "1"){
                    $("#"+idDOM).hide("slow");
                    alertify.alert("Guissa","Eliminación completa");
                }else{
                    alertify.alert("Guissa","Error al eliminar");
                }
            }else if($.trim(accion) === "liberar"){
                if($.trim(dato) === "1"){
                    $("#"+idDOM).hide("slow");
                    alertify.alert("Guissa","Liberación con éxito");
                }else{
                    alertify.alert("Guissa","Error al liberar");
                }
            }
        },
        error: function(XMLHttpRequest,textStatus,errorthrows){
            alert("Ocurrió un error: "+ errorthrows);
        }
    });
}

function kultreserva(idreserva){
    $.ajax({
        type: "post" ,
        url: "cnClientesReservaciones?accion=getReservatxt&idreserva="+idreserva,
        cache:false,
        beforeSend:function(){
            $("#pedidorancicrm").html("<div style='height: 70%;width: 70%;text-align: center;margin-right: auto;justify-content: center;display: inline-block;   vertical-align: middle;'><img src='/guissa/cliente/img/loading.gif'></div>");
        },
        success: function(dato){
            $("#pedidorancicrm").fadeOut("fast",function(){
                $(this).html(dato).slideDown(10);
            });
        },
        error: function(XMLHttpRequest,textStatus,errorthrows){
            alertify.alert("Guissa","Ocurrió un error: "+ errorthrows);
        }
    });
}

function cambiaventanaacciones(tipo,accion,vista,servlet,id,idcrud){
    var tipomenu = servlet+"?accion="+accion+"&catalogaccion="+tipo+"&idaccion="+id+"&idcrud="+idcrud;
    $.ajax({
        type: "post" ,
        url: tipomenu,
        cache:false,
        success: function(dato){                
            $("#"+vista).fadeOut("fast",function(){
                $(this).html(dato).slideDown(10);
            });
        },
        error: function(XMLHttpRequest,textStatus,errorthrows){
            alert("Ocurrió un error: "+ errorthrows);
        }
    });
}

/*function setAjaxPost(url, data, accion){
    $.post(url,{data},function(dato){if($.trim(dato)==="1"){$("#exi"+accion).show("slow");}else{$("#err"+accion).show("slow");}});
}*/

function controladorMenu(accion, idDOM, id){
    var url = "accion=" + accion+ "&id=" + id;
    getAjaxMenus(url,idDOM,accion);
}

function getAjaxMenus(url,idDOM,accion){
    $.ajax({
        type: "POST",
        url:"cnClientesMenus?" + url,
        cache:false,
        success: function(dato){
            if($.trim(accion) === "eliminar"){
                if($.trim(dato) === "1"){
                    $("#"+idDOM).hide("slow");
                    alertify.alert("Guissa","Eliminación completa");
                }else{
                    alertify.alert("Guissa","Error al eliminar");
                }
            }else if($.trim(accion) === "liberar"){
                if($.trim(dato) === "1"){
                    $("#"+idDOM).hide("slow");
                    alertify.alert("Guissa","Liberación con éxito");
                }else{
                    alertify.alert("Guissa","Error al liberar");
                }
            }
        },
        error: function(XMLHttpRequest,textStatus,errorthrows){
            alert("Ocurrió un error: "+ errorthrows);
        }
    });
}


function controladorPDF(accion, idDOM, id){
    var url = "accion=" + accion+ "&id=" + id;
    getAjaxPDF(url,idDOM,accion);
}

function getAjaxPDF(url,idDOM,accion){
    $.ajax({
        type: "POST",
        url:"cnClientesRegistros?" + url,
        cache:false,
        success: function(dato){
            if($.trim(accion) === "eliminar"){
                if($.trim(dato) === "1"){
                    $("#"+idDOM).hide("slow");
                    alertify.alert("Guissa","Eliminación completa");
                }else{
                    alertify.alert("Guissa","Error al eliminar");
                }
            }else if($.trim(accion) === "download"){
                document.write(dato);
                //location.href = dato;
            }
        },
        error: function(XMLHttpRequest,textStatus,errorthrows){
            alert("Ocurrió un error: "+ errorthrows);
        }
    });
}