package br.maua;

public class TeshHash {
    public static void main(String[] args) {

        Integer[] tabChaves = new Integer[] {23, 45, 77, 11, 33, 49, 10, 4, 89, 14};
        Integer[] tabHash = new Integer[10] ;

        int i;
        for ( i = 0; i < tabHash.length; i++){
            if( tabHash[hash(tabChaves[i])] == null){
                tabHash[hash(tabChaves[i])] = tabChaves[i];
            }else {
                Integer indiceHashLivre = rehashing(tabHash, i);
                if( indiceHashLivre != null){
                    tabHash[indiceHashLivre] = tabChaves[i];
                }else{
                    System.out.println("Código do Empregado" + tabChaves[i] + "não armazenado!\n");
                }
            }
        }

        System.out.print("Lista da tabela Hash implementando o rehashing: [");

        for ( i = 0; i < tabHash.length; i++){
            if(i != tabHash.length-1){
                System.out.print(tabHash[i]+ ", ");
            }else{
                System.out.print(tabHash[i] + "]\n");
            }
        }
    }

    public static Integer rehashing(Integer[] tabhash, Integer indice) {
        for (Integer i = indice + 1 ; i < tabhash.length ; i ++) {
            if (tabhash[i] == null )
                return i;
        }
        for (Integer i = 0 ; i < indice ; i++ ) {
            if (tabhash[i] == null )
                return i;
        }
        return null;
    }

    public static Integer hash(Integer key){
        return (key % 10);
    }
}
