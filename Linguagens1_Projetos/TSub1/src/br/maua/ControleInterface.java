package br.maua;

import br.maua.dao.CartasPokemonDAO;
import br.maua.model.CartasPokemon;
import br.maua.teste.AplicacaoDAO;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class ControleInterface {
    private List<CartasPokemon> cartasPokemons;
    private CartasPokemonDAO cartasPokemonDAO = new CartasPokemonDAO();
    private int counter = 0;

    @FXML
    private ListView<CartasPokemon> lvCartasPokemon;

    @FXML
    private Label lblIdDoCanvas, lblNomeDoCanvas, lblRaridadeDoCanvas, lblSerieDoCanvas, lblColecaoDoCanvas, lblURLDoCanvas;
    @FXML
    private Button btnProximaURL;
    @FXML
    private TextField txtId, txtNome, txtRaridade, txtSerie, txtColecao, txtURL, txtIdDeletar,
            txtIdAtt, txtNomeAtt, txtRaridadeAtt, txtSerieAtt, txtColecaoAtt, txtURLAtt;

    @FXML
    public void exibirCartas(){
        lvCartasPokemon.getItems().clear();
        for (CartasPokemon cartasPokemon : cartasPokemonDAO.getAll()) {
            lvCartasPokemon.getItems().add(cartasPokemon);
        }
//        exibirDadosCartaDoCanvas();
   }

//   public void exibirDadosCartaDoCanvas(){
//        cartasPokemons = cartasPokemonDAO.getAll();
//        if(counter >= cartasPokemons.size()-1){
//            counter = cartasPokemons.size()-1;
//        }
//        String idCarta = cartasPokemons.get(counter).getId();
//        String nomeCarta = cartasPokemons.get(counter).getNome();
//        String raridadeCarta = cartasPokemons.get(counter).getRaridade();
//        String serieCarta = cartasPokemons.get(counter).getSerie();
//        String colecaoCarta = cartasPokemons.get(counter).getColecao();
//
//        lblIdDoCanvas.setText(idCarta);
//        lblNomeDoCanvas.setText(nomeCarta);
//        lblRaridadeDoCanvas.setText(raridadeCarta);
//        lblSerieDoCanvas.setText(serieCarta);
//        lblColecaoDoCanvas.setText(colecaoCarta);
//
//   }

   public void cadastrarCarta(){
    cartasPokemonDAO.create(new CartasPokemon(
            txtId.getText()+"",
            txtNome.getText()+"",
            txtRaridade.getText()+"",
            txtSerie.getText()+"",
            txtColecao.getText()+"",
            txtURL.getText()+""
    ));
       exibirCartas();
   }

   public void deletarCarta(){
       CartasPokemon cartasPokemon = new CartasPokemon(txtIdDeletar.getText()+"");
       cartasPokemonDAO.delete(cartasPokemon);
       exibirCartas();
   }

   public void atualizarCarta(){
       cartasPokemonDAO.update(new CartasPokemon(
               txtIdAtt.getText()+"",
               txtNomeAtt.getText()+"",
               txtRaridadeAtt.getText()+"",
               txtSerieAtt.getText()+"",
               txtColecaoAtt.getText()+"",
               txtURLAtt.getText()+""
       ));
       exibirCartas();
   }

}
