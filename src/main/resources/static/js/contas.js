function cadastrarContas(){
    window.location.href = "/redirectCadastrarConta";
}
function consultarContas(){
    window.location.href = "/redirectConsultarConta";
}
function submitContas(){
    window.location.href = "/redirectMenuConta";
}
 function getParameter(theParameter) {
            var params = window.location.search.substr(1).split('&');

            for (var i = 0; i < params.length; i++) {
                var p = params[i].split('=');
                if (p[0] == theParameter) {
                    valorId = decodeURIComponent(p[1]);
                    document.getElementById("idUser").value = valorId;

                }
            }
            return false;
            }


            window.onload = function () {
                getParameter('id');
             }