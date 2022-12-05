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
        if (valor == "" || valor <= 0) {
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
        if (!validarInputEmpty(indice[i])) {
            cont++;
        }
    }
    if (cont > 0) {
        document.getElementById("fail").innerHTML = "<div class='alert alert-danger alert-dismissible mt-2'><button class='close' type='button' data-dismiss='alert'> &times; </button>Por favor revise os dados digitados!</div>";
    } else {
        peso = parseFloat(document.getElementById(peso).value);
        altura = parseFloat(document.getElementById(altura).value / 100);
        let imc = peso / (Math.pow(altura, 2));

        let sex = new Array();
        sex = document.getElementsByName("sex");
        let cont = 0;
        let vsex = '';
        while (cont < sex.length) {
            if (sex[cont].checked) {
                vsex = sex[cont].value;
            }
            cont++;
        }


        if(vsex == "m") {
            document.getElementById("renome").innerHTML = "Olá " + document.getElementById(nome).value;
            document.getElementById("recalculo").innerHTML = "Seu cálculo IMC é de: <strong>" + imc + "</strong> (Masculino)";

            if(imc < 20.7) {
                document.getElementById("reimc").innerHTML = "Você encontra-se na categoria: <strong> Abaixo do peso </strong>"
            } else {
                if(imc >= 20.7 && imc <= 26.4) {
                    document.getElementById("reimc").innerHTML = "Você encontra-se na categoria: <strong> Peso ideal </strong>"
                } else {
                    if(imc > 26.4 && imc <= 27.8) {
                        document.getElementById("reimc").innerHTML = "Você encontra-se na categoria: <strong> Pouco acima do peso </strong>"
                    } else {
                        if(imc > 27.8 && imc <= 31.1) {
                            document.getElementById("reimc").innerHTML = "Você encontra-se na categoria: <strong> Acima do peso </strong>"
                        } else {
                            document.getElementById("reimc").innerHTML = "Você encontra-se na categoria: <strong> Obesidade </strong>"
                        }
                    }
                }
            }
        }


        if(vsex == "f") {
            document.getElementById("renome").innerHTML = "Olá " + document.getElementById(nome).value;
            document.getElementById("recalculo").innerHTML = "Seu cálculo IMC é de: <strong>" + imc + "</strong> (Feminino)";

            if(imc < 19.1) {
                document.getElementById("reimc").innerHTML = "Você encontra-se na categoria: <strong> Abaixo do peso </strong>"
            } else {
                if(imc >= 19.1 && imc <= 25.8) {
                    document.getElementById("reimc").innerHTML = "Você encontra-se na categoria: <strong> Peso ideal </strong>"
                } else {
                    if(imc > 25.8 && imc <= 27.3) {
                        document.getElementById("reimc").innerHTML = "Você encontra-se na categoria: <strong> Pouco acima do peso </strong>"
                    } else {
                        if(imc > 27.3 && imc <= 32.3) {
                            document.getElementById("reimc").innerHTML = "Você encontra-se na categoria: <strong> Acima do peso </strong>"
                        } else {
                            document.getElementById("reimc").innerHTML = "Você encontra-se na categoria: <strong> Obesidade </strong>"
                        }
                    }
                }
            }
        }
    }
}