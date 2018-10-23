/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


(function(){
    function ComparaA(idneg){
        $.ajax({
            type: "post" ,
            url: "cnClientesConfiguracion?enter=comparaa&idnegocio="+idneg,
            cache:false,
            success: function(dato){
                if(dato!==""){
                    alert('Subscripción terminada'); 
                    location.href='cnzzterminada?code='+dato;
                }
            },
            error: function(XMLHttpRequest,textStatus,errorthrows){
                alert("Ocurrió un error: "+ errorthrows);
            }
        });
    }

    function ComparaD(idneg){
        $.ajax({
            type: "post" ,
            url: "cnClientesConfiguracion?enter=comparad&idnegocio="+idneg,
            cache:false,
            success: function(dato){
                if(dato!==""){
                    alert('Subscripción terminada'); 
                    location.href='cnzzterminada?code='+dato;
                }
            },
            error: function(XMLHttpRequest,textStatus,errorthrows){
                alert("Ocurrió un error: "+ errorthrows);
            }
        });
    }

    function getDias(idneg){
        var dias = 0;
        $.ajax({
            type: "post" ,
            url: "cnClientesConfiguracion?enter=getdias&idnegocio="+idneg,
            cache:false,
            success: function(dato){
                dias = dato;
            },
            error: function(XMLHttpRequest,textStatus,errorthrows){
                alert("Ocurrió un error: "+ errorthrows);
            }
        });
        return dias;
    }
})();