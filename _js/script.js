function validarInputEmpty(id) {
    let valor = document.getElementById(id);
    let result = true;
    if (id == "name") {
        if (!(isNaN(valor.value)) || valor.value == "") {
            document.getElementById(id).className = valor.className + " " + 'is-invalid';
            result = false;
        }
    } else {
        if (valor.value == "" || valor.value <= 0) {
            document.getElementById(id).className = valor.className + " " + 'is-invalid';
            result = false;
        }
    }
    return result;
}



//A função remove a class is-invalid dos imput text caso exista ao atribuir o foco ( click )
function validarInput(id) {

    let classe = document.getElementById(id);

    if (classe.className.indexOf('is-invalid') >= 0) {
        document.getElementById(id).className = classe.className.replace('is-invalid', "").trim();
    }

    document.getElementById("fail").innerHTML = "";
}




function calcularImc(...param) {//nome, idade, altura, peso

    param.forEach(validarInput);

    let valid = true;
    for (const i in param) {
        if (!validarInputEmpty(param[i])) {
            valid = false;
        }
    }

    let [nome, , altura, peso] = param;

    if (!valid) {
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


        if (vsex == "m") {
            document.getElementById("renome").innerHTML = "Olá " + document.getElementById(nome).value;
            document.getElementById("recalculo").innerHTML = "Seu cálculo IMC é de: <strong>" + imc.toFixed(2) + "</strong> (Masculino)";

            if (imc < 16) {
                document.getElementById("reimc").innerHTML = "Seu IMC é menor que 16, encontra-se na categoria: <strong> Magreza Grave </strong>";

            } else if (imc >= 16 && imc < 17) {
                document.getElementById("reimc").innerHTML = "Seu IMC está entre 16 e 17, encontra-se na categoria: <strong> Magreza Moderada </strong>";

            } else if (imc >= 17 && imc < 18.5) {
                document.getElementById("reimc").innerHTML = "Seu IMC está entre 17 e 18.5, encontra-se na categoria: <strong> Magreza Leve </strong>";

            } else if (imc >= 18,5 && imc < 25) {
                document.getElementById("reimc").innerHTML = "Seu IMC está entre 18.5 e 25, encontra-se na categoria: <strong> Saudável </strong>";

            } else if (imc >= 25 && imc < 30) {
                document.getElementById("reimc").innerHTML = "Seu IMC está entre 25 e 30, encontra-se na categoria: <strong> Sobrepeso </strong>";

            } else if (imc >= 30 && imc < 35) {
                document.getElementById("reimc").innerHTML = "Seu IMC está entre 30 e 35, encontra-se na categoria: <strong> Obesidade Grau I </strong>";
            
            } else if (imc >= 35 && imc < 40) {
                document.getElementById("reimc").innerHTML = "Seu IMC está entre 30 e 35, encontra-se na categoria: <strong> Obesidade Grau II (considerada severa) </strong>";
            
            } else if (imc >= 40 ) {
                document.getElementById("reimc").innerHTML = "Seu IMC é 40 ou Superior, encontra-se na categoria: <strong> Obesidade Grau III (considerada mórbida) </strong>";
            
            }
        }


        if (vsex == "f") {
            document.getElementById("renome").innerHTML = "Olá " + document.getElementById(nome).value;
            document.getElementById("recalculo").innerHTML = "Seu cálculo IMC é de: <strong>" + imc.toFixed(2) + "</strong> (Feminino)";

            document.getElementById("reimc").innerHTML = "<strong>Seu IMC está ótimo e você está PERFEITA, Parabéns!!!!!!</strong>";
            
        }
    }
}