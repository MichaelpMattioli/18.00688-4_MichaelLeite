package colecoes

import kotlin.math.min

fun main(){
    val meuVetor = arrayOf(1,2,3)
    var item : Int
    for (item in meuVetor){
        println(item)
    }

    println("Tamanho do array: ${meuVetor.size}")
    println("Primeiro elemento: ${meuVetor[0]}")
    println("Maior valor: ${meuVetor.max()}")

    //Lista
    //Objeto lista não mutavel (nao varia, nao modificada)
    var minhaLista = listOf("Oi", "ola", "denovo")
    println(minhaLista)

    val minhaListaQueMuda = mutableListOf("Oi", "ola", "denovo")
    println(minhaListaQueMuda)
    minhaListaQueMuda.add("Goku")
    println(minhaListaQueMuda)
    //Não pode ser executado pois a variável foi criada com val
    // minhaListaQueMuda = mutableListOf("Oi", "ola", "denovo")

}