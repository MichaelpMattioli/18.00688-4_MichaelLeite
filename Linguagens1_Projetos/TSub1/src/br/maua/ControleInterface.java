package br.maua;

import br.maua.dao.CartasPokemonDAO;
import br.maua.model.CartasPokemon;
import br.maua.model.ListaCartasPokemon;
import br.maua.teste.AplicacaoDAO;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

public class ControleInterface {

    private CartasPokemonDAO cartasPokemonDAO = new CartasPokemonDAO();
    private List<CartasPokemon> cartasPokemons = cartasPokemonDAO.getAll();
    ListaCartasPokemon listaCartasPokemon = new ListaCartasPokemon(cartasPokemons);

    @FXML
    private ListView<CartasPokemon> lvCartasPokemon;

    @FXML
    private Label lblIdDoCanvas, lblNomeDoCanvas, lblRaridadeDoCanvas, lblSerieDoCanvas, lblColecaoDoCanvas, lblURLDoCanvas;
    @FXML
    private Button btnProximaCarta, btnAnteriorCarta;
    @FXML
    private TextField txtId, txtNome, txtRaridade, txtSerie, txtColecao, txtURL, txtIdDeletar,
            txtIdAtt, txtNomeAtt, txtRaridadeAtt, txtSerieAtt, txtColecaoAtt, txtURLAtt;
    @FXML
    private ImageView imgFoto;

    @FXML
    public void exibirCartas(){
        lvCartasPokemon.getItems().clear();
        for (CartasPokemon cartasPokemon : cartasPokemonDAO.getAll()) {
            lvCartasPokemon.getItems().add(cartasPokemon);
        }

        cartasPokemons = cartasPokemonDAO.getAll();

        String url = cartasPokemons.get(listaCartasPokemon.getPokemonAtual()).getURL();
        Image image = new Image("https://cdn.bulbagarden.net/upload/thumb/0/0d/025Pikachu.png/1200px-025Pikachu.png");
        imgFoto.setImage(image);
        exibirDadosDaCartaDoFoto(listaCartasPokemon.getPokemonAtual());
   }

   @FXML
   public void exibirDadosDaCartaDoFoto(int indexDaCartaAtual){

        String idCarta = cartasPokemons.get(indexDaCartaAtual).getId();
        String nomeCarta = cartasPokemons.get(indexDaCartaAtual).getNome();
        String raridadeCarta = cartasPokemons.get(indexDaCartaAtual).getRaridade();
        String serieCarta = cartasPokemons.get(indexDaCartaAtual).getSerie();
        String colecaoCarta = cartasPokemons.get(indexDaCartaAtual).getColecao();

        lblIdDoCanvas.setText(idCarta);
        lblNomeDoCanvas.setText(nomeCarta);
        lblRaridadeDoCanvas.setText(raridadeCarta);
        lblSerieDoCanvas.setText(serieCarta);
        lblColecaoDoCanvas.setText(colecaoCarta);

   }

   @FXML
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
       txtId.clear();
       txtNome.clear();
       txtRaridade.clear();
       txtSerie.clear();
       txtColecao.clear();
       txtURL.clear();
   }
   @FXML
   public void deletarCarta(){
       CartasPokemon cartasPokemon = new CartasPokemon(txtIdDeletar.getText()+"");
       cartasPokemonDAO.delete(cartasPokemon);
       exibirCartas();
       txtIdDeletar.clear();
   }
   @FXML
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
       txtIdAtt.clear();
       txtNomeAtt.clear();
       txtRaridadeAtt.clear();
       txtSerieAtt.clear();
       txtColecaoAtt.clear();
       txtURLAtt.clear();
   }


}
