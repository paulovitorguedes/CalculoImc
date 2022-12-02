function validarInputEmpty(id){
    var valor = document.getElementById(id).value;
    var c = document.getElementById(id).className;

    if (!isNaN(valor)) {
        document.getElementById(id).className = c + ' is-invalid';
    } else {
        c.replace("is-invalid","");
    }
    console.log(c);
    
}