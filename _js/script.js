function validarInputEmpty(id) {
    let valor = document.getElementById(id).value;
    let c = document.getElementById(id).className;
    let result = true;
    if (id == "name") {
        if (!(isNaN(valor)) || valor == "") {
            document.getElementById(id).className = c + " " + 'is-invalid';
            result = false;
        }
    } else { 
        if(valor == "" || valor <= 0) {
            document.getElementById(id).className = c + " " + 'is-invalid';
            result = false;
        }
    }
    return result;
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
    document.getElementById("fail").innerHTML = "";
}

function calcularImc(nome, idade, altura, peso) {
    validarInput(nome);
    validarInput(idade);
    validarInput(altura);
    validarInput(peso);

    var indice = new Array(nome, idade, altura, peso);
    var cont = 0;
    for (const i in indice) {
        if(!validarInputEmpty(indice[i])) {
            cont++;
        }
    }
    if(cont > 0) {
        document.getElementById("fail").innerHTML = "<div class='alert alert-danger alert-dismissible mt-3'><button class='close' type='button' data-dismiss='alert'> &times; </button>Por favor revise os dados digitados!</div>";

        // document.getElementById("fail").innerHTML = "teste";
    }
    console.log(cont);

}