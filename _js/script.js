function validarInputEmpty(id) {
    let valor = document.getElementById(id).value;
    let c = document.getElementById(id).className;
    let result = "invalid";
    if (id == "name") {
        if (!(isNaN(valor)) || valor == "") {
            document.getElementById(id).className = c + " " + 'is-invalid';
            return result;
        }
    } else if(valor == "" || valor <= 0) {
        document.getElementById(id).className = c + " " + 'is-invalid';
        return result;
    } else {
        result = "ok";
        return result;
    }
}

function validarInput(id) {
    // variável 'classe' recebe os atributos da classe  
    let classe = document.getElementById(id).className;

    // match ver se a string "is-invalid" está contida na variável 'ver'
    // caso positivo, 'ver' vai receber o valor "is-invalid" 
    let ver = classe.match("is-invalid");
    if (ver == "is-invalid") {
        // split vai dividir uma cadeia de caracteres em uma matriz de substrings. 
        // neste caso o parametro para divisao é  " ".
        let array = classe.split(" ");
        let result = '';
        for (let i = 0; i < array.length - 1; i++) {
            result += array[i] + " ";
        }
        document.getElementById(id).className = result;
    }
}
