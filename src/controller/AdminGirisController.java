/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class AdminGirisController implements Initializable {

    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Button btnGiris;
    @FXML
    private Label lblMessage;

    @FXML
    private void btnGiris(ActionEvent e) throws IOException {
        if (txtUsername.getText().equals("barkin") && txtPassword.getText().equals("123")||txtUsername.getText().equals("cansel") && txtPassword.getText().equals("456")) {
            Parent x = FXMLLoader.load(getClass().getResource("Köprü.fxml"));

            Scene z = new Scene(x);

            Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();

            // window.initStyle(StageStyle.TRANSPARENT);
            //window.centerOnScreen();
            double width = 400;
            double height = 300;

            Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
            window.setX((screenBounds.getWidth() - width) / 2);
            window.setY((screenBounds.getHeight() - height) / 2);
       
            window.setScene(z);
            window.setTitle("");
            window.show();
        } else {
//            String x="Kullanıcı veya Parola Hatalı !!";
//             lblMessage.setText(x);
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("");
            alert.setHeaderText("                                     UYARI");
            alert.setContentText("                         Kullanıcı  veya  Parola Hatalı  !!");

            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
