package controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerLogin {

    @FXML
    private Button buttonIngresar;

    @FXML
    private AnchorPane radioContrasenia;

    @FXML
    private PasswordField txtContrasenia;

    @FXML
    private TextField txtnombreUsuario;

    @FXML
    void IngresarSistema(ActionEvent event) throws IOException {
        // Agregar verificacion
        Stage sta = (Stage) this.buttonIngresar.getScene().getWindow();
        sta.close();

        // Abre nueva ventana
        Parent root = FXMLLoader.load(getClass().getResource("/view/homeInterface.fxml"));
        Scene scene = new Scene(root, 740, 530);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("");
        stage.setResizable(false);
        stage.show();

        /*
        * Utilizar Alert para confirmar la informacion ingresada con la base de datos
         */

    }

    @FXML
    void registrarUsuario(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/registerInterface.fxml"));
        Scene scene = new Scene(root, 250, 399);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Register");
        stage.setResizable(false);
        stage.showAndWait();
    }

}
