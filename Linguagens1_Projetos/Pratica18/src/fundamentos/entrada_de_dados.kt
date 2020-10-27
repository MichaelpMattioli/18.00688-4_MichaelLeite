package fundamentos

fun main(){
    print("Informe seu nome: ")
    var nome = readLine()
    println("Nome informada: $nome")
    println("Tamanho: ${nome!!.length}")
}