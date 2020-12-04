package br.maua.enums;

/**
 * * Classe responsável por enumerar todos os tipos de profissões existentes.
 * @author José Guilherme Martins dos Santos - josegms2000@gmail.com  Michael Pedroza Mattioli Leite - michael.pmattioli@gmail.com
 * @since 02/11/2020
 * @version 1.0
 * */

public enum Profissao {
    ARQUEIRA("Arqueira"),  CACADOR("Caçador"), CACADOR_DE_RECOMPENSAS("Caçador de Recompensas"),
    MAGO("Mago"), ALQUIMISTA("Alquimista"), FEITICEIRO("Feiticeiro"), ARQUIMAGO("Arquimago"), SACERDOTE("Sacerdote"),
    NINJA("Ninja"), MERCENARIO("Mercenario"),
    GUERREIRO("Guerreiro"), ESPADACHIM("Espadachim"), GLADIADOR("Gladiador"),
    DEFENSOR("Defensor"), GUARDIAO("Guardiao"), PALADINO("Paladino"), TEMPLARIO("Templario"),
    TECNOMAGO("Tecnomago");

    private String valor;

    /**
     Construtor da classe Profissao, responsável por construir a variavel que esse enum apresenta, que nesse caso é para deixar
     o enum com uma string padrão ao nome representado do enum.
     * @param valor String que representa o nome do enum.
     */

    Profissao(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    /**
     * Método responsável por retornar o tipo de enum relacionado a String que foi inserida em seu parâmetro, foi essencial para a implementação e construção do DAO.
     * @param profissao String que irá ser comparada aos itens contidos na classe equipamento.
     * @return retorna uma Profissao que tenha o nome igual a string que foi colocada no parâmetro.
     */

    public static Profissao getProfissao(String profissao){
        for(Profissao prof:Profissao.values()){
            if(prof.toString().equals(profissao.toUpperCase())){
                return prof;
            }
        }
        return null;
    }

}
