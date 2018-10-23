/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function getItem(item){
    var tipomenu = "/guissa/cliente/vista/"+item+".jsp";
    $.ajax({
        type: "post" ,
        url: tipomenu,
        cache:false,
        beforeSend:function(){
            $("#menuResult").html("<div style='height: 70%;width: 70%;text-align: center;margin-right: auto;justify-content: center;display: inline-block;   vertical-align: middle;'><img src='/guissa/cliente/img/loading.gif'></div>");
        },
        success: function(dato){
            $("#menuResult").fadeOut("fast",function(){
                $(this).html(dato).slideDown(10);
            });
        },
        error: function(XMLHttpRequest,textStatus,errorthrows){
            alert("Ocurrió un error: "+ errorthrows);
        }
    });
} 

function getItemNormal(item){
    var tipomenu = "/guissa/cliente/vista-erno/"+item+".jsp";
    $.ajax({
        type: "post" ,
        url: tipomenu,
        cache:false,
        beforeSend:function(){
            $("#menuResult").html("<div style='height: 70%;width: 70%;text-align: center;margin-right: auto;justify-content: center;display: inline-block;   vertical-align: middle;'><img src='/guissa/cliente/img/loading.gif'></div>");
        },
        success: function(dato){
            $("#menuResult").fadeOut("fast",function(){
                $(this).html(dato).slideDown(10);
            });
        },
        error: function(XMLHttpRequest,textStatus,errorthrows){
            alert("Ocurrió un error: "+ errorthrows);
        }
    });
} 

