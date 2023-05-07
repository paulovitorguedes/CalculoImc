# CalculoImc
Calculadora de IMC (o peso ideal)

[Acesse aqui CalculoImc](https://paulovitorguedes-calculadora-imc.netlify.app/)
#### Projeto em *HTML*, *CSS*, *BOOTSTRAP* e *JAVASCRIPT*

![Interface-projeto-calculadora-IMC](_interface/principal.png)

A classificação do índice de massa corporal (IMC) pode ajudar a identificar problemas de obesidade ou desnutrição, em crianças, adolescentes, adultos e idosos.

Além de calcular o valor de IMC, esta calculadora também indica qual o intervalo de peso ideal que deve ter para garantir uma melhor qualidade de vida.

Ter um peso dentro do intervalo de peso ideal ajuda ainda a evitar o aparecimento de várias doenças crônicas, como diabetes e hipertensão.


___

### Como calcular o IMC
imc = peso / quadrado da altura 
```
peso = parseFloat(document.getElementById(peso).value);
altura = parseFloat(document.getElementById(altura).value / 100);
let imc = peso / (Math.pow(altura, 2));
```
