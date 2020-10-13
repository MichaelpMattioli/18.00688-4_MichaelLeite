package estruturas_controle

fun main(){
    val numero = 15
    if(numero % 2 == 0)
        println("Par")
    else
        println("Impar")

    //Simular um ternario
    val numero2 = 40
    val resultado = if (numero2 % 2 == 0) "Par" else "Impar"
    println("$resultado")

    println("Resultado: ${if (numero2 % 2 == 0) "Par" else "Impar"}")

    //Elvis operator
    //Deixa explicito que a variável pode receber um valor nulo
    var nome : String? // Null-safe, só aceita nulo se eu colocar o ? na variavel, se eu não colocar ele nao aceita
    nome = "Miguel"
    println(nome)
//    nome = null
    println("${nome ?: "Ryu"}")
}