package br.maua.enums;

/**
 * * Classe responsável por enumerar todos os tipos de raças existentes.
 * @author José Guilherme Martins dos Santos - josegms2000@gmail.com  Michael Pedroza Mattioli Leite - michael.pmattioli@gmail.com
 * @since 02/11/2020
 * @version 1.0
 * */

public enum Raca {
    HUMANO("Humano"),
    ELFO("Elfo"),
    ASMODIANO("Asmodiano"),
    HAROS("Haros"),
    ANÃO("Anão");

    private String valor;

    /**
     Construtor da classe Raca, responsável por construir a variavel que esse enum apresenta, que nesse caso é para deixar
     o enum com uma string padrão ao nome representado do enum.
     * @param valor String que representa o nome do enum.
     */

    Raca(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    /**
     * Método responsável por retornar o tipo de enum relacionado a String que foi inserida em seu parâmetro, foi essencial para a implementação e construção do DAO.
     * @param raca String que irá ser comparada aos itens contidos na classe equipamento.
     * @return retorna uma Raca que tenha o nome igual a string que foi colocada no parâmetro.
     */

    public static Raca getRaca(String raca){
        for(Raca rac:Raca.values()){
            if(rac.toString().equals(raca.toUpperCase())){
                return rac;
            }
        }
        return null;
    }
}
