// Michael Pedroza Mattioli leite RA: 18.00688-4
// José Guilherme Martins dos Santos RA: 18.00135-0

package br.maua;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * * Classe responsavel por incializar o programa.
 * @author José Guilherme Martins dos Santos - josegms2000@gmail.com    Michael Pedroza Mattioli Leite - michael.pmattioli@gmail.com
 * @since 19/09/2020
 * @version 1.0
 * */
public class Main extends Application {

    public static void main(String[] args) {
        launch();
    }

    /**
     * Função que inicializa a aplicação
     * @param primaryStage Parametro para criação da cena
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("ViewInterface.fxml"));
        primaryStage.setTitle("Pokedex");
        primaryStage.setScene(new Scene(root, 950.0,832.0));
        primaryStage.show();
    }
}
