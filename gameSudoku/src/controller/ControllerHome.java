package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerHome {

    @FXML
    private Button buttonJugar;

    @FXML
    private Button buttonReglas;

    @FXML
    private Button buttonSalir;
    @FXML
    void jugar (ActionEvent event) throws IOException {
        // Agregar verificacion
        Stage sta = (Stage) this.buttonJugar.getScene().getWindow();
        sta.close();

        // Abre nueva ventana
        Parent root = FXMLLoader.load(getClass().getResource("/view/cuadriculaSudoku.fxml"));
        Scene scene = new Scene(root, 840, 630);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Juego Sudoku");
        stage.setResizable(false);
        stage.show();


        /*
         * Utilizar Alert para confirmar la informacion ingresada con la base de datos
         */
    }
}
