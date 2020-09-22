package br.maua;

import br.maua.dao.CartasPokemonDAO;
import br.maua.model.CartasPokemon;
import br.maua.model.ListaCartasPokemon;
import javafx.fxml.FXML;

import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
/**
 * * Classe responsavel pelo controle da Interface ViewInterface, criação de codigos on Action para botões e associação dos textfields e labels ficam aqui.
 * @author José Guilherme Martins dos Santos - josegms2000@gmail.com    Michael Pedroza Mattioli Leite - michael.pmattioli@gmail.com
 * @since 19/09/2020
 * @version 1.0
 * */
public class ControleInterface {

    private CartasPokemonDAO cartasPokemonDAO = new CartasPokemonDAO();
    private List<CartasPokemon> cartasPokemons = cartasPokemonDAO.getAll();
    ListaCartasPokemon listaCartasPokemon = new ListaCartasPokemon(cartasPokemons);
    @FXML
    private ListView<CartasPokemon> lvCartasPokemon;
    @FXML
    private Label lblIdDoCanvas, lblNomeDoCanvas, lblRaridadeDoCanvas, lblSerieDoCanvas, lblColecaoDoCanvas, lblURLDoCanvas;
    @FXML
    private TextField txtId, txtNome, txtRaridade, txtSerie, txtColecao, txtURL, txtIdDeletar,
            txtIdAtt, txtNomeAtt, txtRaridadeAtt, txtSerieAtt, txtColecaoAtt, txtURLAtt;
    @FXML
    private ImageView imgFoto;

    /**
     * Método que atualiza as modificações feitas na data base, atualizando a lista de cartasPokemon
     */

    @FXML
    private void atualizaModificacoes(){
        cartasPokemons = cartasPokemonDAO.getAll();
        listaCartasPokemon = new ListaCartasPokemon(cartasPokemons);
    }

    /**
     * Exibe os dados e imagem da carta atual, alem de atualizar os dados de toda a lista no listView
     */

    @FXML
    public void exibirCartas(){
        lvCartasPokemon.getItems().clear();
        for (CartasPokemon cartasPokemon : cartasPokemonDAO.getAll()) {
            lvCartasPokemon.getItems().add(cartasPokemon);
        }
        previewPhoto();
   }

    /**
     * Método que atualiza os labels do campo de dados da carta atual.
     */

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

    /**
     * Método que atualiza para a proxima carta que está na lista de cartasPokemon
     */

    @FXML
    public void proximaCarta(){
        listaCartasPokemon.switchToNextCard();
        exibirCartas();
    }

    /**
     * Método que atualiza para a carta anterior que está na lista de cartasPokemon
     */

    @FXML
    public void cartaAnterior(){
        listaCartasPokemon.switchToPreviousCard();
        exibirCartas();
    }

    /**
     * Método que cadastrar uma carta na lista, atualiza a lista e a exibe.
     */

    @FXML
    public void cadastrarCarta(){
        try{
            Image image = new Image(txtURL.getText());

            cartasPokemonDAO.create(new CartasPokemon(
                    txtId.getText()+"",
                    txtNome.getText()+"",
                    txtRaridade.getText()+"",
                    txtSerie.getText()+"",
                    txtColecao.getText()+"",
                    txtURL.getText()+""

            ));
            atualizaModificacoes();
            exibirCartas();
            txtId.clear();
            txtNome.clear();
            txtRaridade.clear();
            txtSerie.clear();
            txtColecao.clear();
            txtURL.clear();
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro!");
            alert.setHeaderText("Nao foi possivel cadastrar");

            alert.showAndWait();
        }
    }

    /**
     * Método que deleta determinada carta da lista.
     */
    @FXML
    public void deletarCarta(){
        CartasPokemon cartasPokemon = new CartasPokemon(txtIdDeletar.getText()+"");
        cartasPokemonDAO.delete(cartasPokemon);
        listaCartasPokemon.setPokemonAtual(0);
        atualizaModificacoes();
        exibirCartas();
        txtIdDeletar.clear();
    }

    /**
     * Método que atualiza determinada carta da lista.
     */
    @FXML
    public void atualizarCarta(){
        try{
            cartasPokemonDAO.update(new CartasPokemon(
                    txtIdAtt.getText()+"",
                    txtNomeAtt.getText()+"",
                    txtRaridadeAtt.getText()+"",
                    txtSerieAtt.getText()+"",
                    txtColecaoAtt.getText()+"",
                    txtURLAtt.getText()+""
            ));
            atualizaModificacoes();
            exibirCartas();
            txtIdAtt.clear();
            txtNomeAtt.clear();
            txtRaridadeAtt.clear();
            txtSerieAtt.clear();
            txtColecaoAtt.clear();
            txtURLAtt.clear();
        }catch(Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro!");
            alert.setHeaderText("Nao foi possivel atualizar");

            alert.showAndWait();
        }

    }

    /**
     *  Método que exibe a imagem presente na URL de uma determinada carta.
     */
    @FXML
    public void previewPhoto(){
        String url = cartasPokemons.get(listaCartasPokemon.getPokemonAtual()).getURL();
        Image image = new Image(url);
        imgFoto.setImage(image);
        exibirDadosDaCartaDoFoto();
    }
}
