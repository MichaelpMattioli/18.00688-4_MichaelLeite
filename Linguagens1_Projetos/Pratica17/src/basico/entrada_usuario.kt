package basico

fun main(){
    print("Informe um nome: ")
    var nome = readLine()
    println("Ola $nome")
    println("Informe dois números: ")
    var numero1 = readLine()!!.toDouble()
    var numero2 = readLine()!!.toDouble()
    println("Resultado da soma de $numero1 com $numero2 é igual a ${numero1 + numero2}")
}