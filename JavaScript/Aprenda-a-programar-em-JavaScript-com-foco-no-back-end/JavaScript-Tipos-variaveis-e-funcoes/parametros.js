function soma(num1, num2)
{
    return num1 + num2
}

//console.log(soma(2, 2))

// parametros x argumentos

//ordem dos parametros

function nomeIdade(nome, idade)
{
    return `meu nome ${nome} e minha idade é ${idade}`
}

//console.log(moneIdade(40, Julia))

function mutiplica(num1 = 1, num2 = 1)
{
    return num1 * num2
}


//console.log(mutiplica(soma(4, 5), soma(3, 3)))
//console.log(mutiplica(soma(4, 5)))

function apresentar()
{
    return "ola"
}


console.log(soma(1, 1))
const soma = function(num1, num2)
             {
                return num1 + num2
             }