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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class SariAlanController implements Initializable {

    @FXML
    private Label lblTc1;
    @FXML
    private Label lblAd1;
    @FXML
    private Label lblYas1;
    @FXML
    private Label lblCinsiyet1;
    @FXML
    private Label lblTc2;
    @FXML
    private Label lblAd2;
    @FXML
    private Label lblYas2;
    @FXML
    private Label lblCinsiyet2;
    @FXML
    private Label lblTc4;
    @FXML
    private Label lblAd4;
    @FXML
    private Label lblYas4;
    @FXML
    private Label lblCinsiyet4;
    @FXML
    private Label lblTc5;
    @FXML
    private Label lblAd5;
    @FXML
    private Label lblYas5;
    @FXML
    private Label lblCinsiyet5;
    @FXML
    private Label lblTc3;
    @FXML
    private Label lblAd3;
    @FXML
    private Label lblYas3;
    @FXML
    private Label lblCinsiyet3;
    @FXML
    private Label lblTc6;
    @FXML
    private Label lblAd6;
    @FXML
    private Label lblYas6;
    @FXML
    private Label lblCinsiyet6;
    @FXML
    private TextField txtDoktor;
    @FXML
    private TextField txtHemsire;
    @FXML
    private TextField txtGüvenlik;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnYGeri(ActionEvent e) throws IOException {
        Parent x = FXMLLoader.load(getClass().getResource("MuayeneOl.fxml"));
        Scene z = new Scene(x);

        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
       double width = 600;
        double height = 490;

        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        window.setX((screenBounds.getWidth() - width) / 2);
        window.setY((screenBounds.getHeight() - height) / 2);

        window.setScene(z);
        window.setTitle("");
        window.show();
    }

    @FXML
    private void btnCikis1(ActionEvent event) {
    }

    @FXML
    private void btnSec1(ActionEvent event) {
    }

    @FXML
    private void btnCikis2(ActionEvent event) {
    }

    @FXML
    private void btnSec2(ActionEvent event) {
    }

    @FXML
    private void btnCikis4(ActionEvent event) {
    }

    @FXML
    private void btnSec4(ActionEvent event) {
    }

    @FXML
    private void btnCikis5(ActionEvent event) {
    }

    @FXML
    private void btnSec5(ActionEvent event) {
    }

    @FXML
    private void btnCikis3(ActionEvent event) {
    }

    @FXML
    private void btnSec3(ActionEvent event) {
    }

    @FXML
    private void btnSec6(ActionEvent event) {
    }

    @FXML
    private void btnMuayeneEt(ActionEvent event) {
    }

    @FXML
    private void btnTalimatYerineGetir(ActionEvent event) {
    }

    @FXML
    private void btnGöreviYerineGetir(ActionEvent event) {
    }
    
}
