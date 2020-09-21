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
        previewPhoto();
   }

    @FXML
    public void exibirDadosDaCartaDoFoto(){

    int indexDaCartaAtual = listaCartasPokemon.getPokemonAtual();

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
    public void proximaCarta(){
        listaCartasPokemon.switchToNextCard();
        cartasPokemons = cartasPokemonDAO.getAll();
        exibirCartas();
    }

    @FXML
    public void cartaAnterior(){
        listaCartasPokemon.switchToPreviousCard();
        cartasPokemons = cartasPokemonDAO.getAll();
        exibirCartas();
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
        cartasPokemons = cartasPokemonDAO.getAll();
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
        cartasPokemons = cartasPokemonDAO.getAll();
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
        cartasPokemons = cartasPokemonDAO.getAll();
       exibirCartas();
       txtIdAtt.clear();
       txtNomeAtt.clear();
       txtRaridadeAtt.clear();
       txtSerieAtt.clear();
       txtColecaoAtt.clear();
       txtURLAtt.clear();
    }

    @FXML
    public void previewPhoto(){
        String url = cartasPokemons.get(listaCartasPokemon.getPokemonAtual()).getURL();
        Image image = new Image(url);
        imgFoto.setImage(image);
        exibirDadosDaCartaDoFoto();
    }

}
