package br.maua;

import br.maua.model.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class ControleInterface {
    @FXML
    private Label lblSaida;
    @FXML
    private Button btnBotao1;
    @FXML
    private TextField txtEntrada;
    @FXML
    private TextField txtNumero1, txtNumero2;
    @FXML
    private TextField txtNome, txtSenha, txtUrl;
    @FXML
    private ImageView imgFoto;

    public void exibirNome(){
        String nome = txtEntrada.getText();
        lblSaida.setText(nome);
    }

    @FXML
    public void somar(){
        int numero1 = Integer.parseInt(txtNumero1.getText());
        int numero2 = Integer.parseInt(txtNumero1.getText());
        lblSaida.setText("Saida:" + (numero1 + numero2));
    }

    @FXML
    public void cadastrar(){
        Usuario usuario = new Usuario(
                txtNome.getText(), txtSenha.getText(), txtUrl.getText()
        );
        txtNome.clear();
        txtSenha.clear();
        txtUrl.clear();
        System.out.println("Usuario Cadastrado:" + usuario);
    }

    @FXML
    public void previewPhoto(){
        try {
            String url = txtUrl.getText();
            Image image = new Image(url);
            imgFoto.setImage(image);
        }
        catch (IllegalArgumentException exception){
            txtUrl.clear();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("URl Incorreta");
            alert.setHeaderText("Batata!");
            // Para a execução do restanet do código do método ate ele ser concluido ( Alerta )
            alert.showAndWait();
            // Deixa o restante do codigo ser executado
            // alert.show();
        }
    }
}
