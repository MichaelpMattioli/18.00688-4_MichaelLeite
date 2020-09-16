package br.maua.projeto.parsers;

import br.maua.projeto.model.ListaDeJogos;
import org.json.JSONArray;
import org.json.JSONObject;


public class ListaDeJogosParser {
    public static JSONArray toJson(ListaDeJogos lista){
        JSONArray json = new JSONArray();
        lista.getJogos().forEach( jogo -> {
            json.put(jogo);
        });
        return json;
    }

    public static ListaDeJogos fromJson(JSONArray json){
        ListaDeJogos lista = new ListaDeJogos();
        json.forEach( item ->{
            lista.addJogo(JogoParser.fromJson((JSONObject) item));
        });
        return lista;
    }
}
