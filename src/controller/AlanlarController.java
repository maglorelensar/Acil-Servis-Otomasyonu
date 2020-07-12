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
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class AlanlarController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btnYesilAlan(ActionEvent e) throws IOException {
        Parent x = FXMLLoader.load(getClass().getResource("YesilAlan.fxml"));
        Scene z = new Scene(x);

        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        double width = 1200;
        double height = 860;

        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        window.setX((screenBounds.getWidth() - width) / 2);
        window.setY((screenBounds.getHeight() - height) / 2);
        window.setScene(z);
        window.setTitle("Kırmızı Alan");
        window.show();
    }

    @FXML
    private void btnSariAlan(ActionEvent e) throws IOException {
        Parent x = FXMLLoader.load(getClass().getResource("SariAlan.fxml"));
        Scene z = new Scene(x);

        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        double width = 1200;
        double height = 860;

        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        window.setX((screenBounds.getWidth() - width) / 2);
        window.setY((screenBounds.getHeight() - height) / 2);
        window.setScene(z);
        window.setTitle("Kırmızı Alan");
        window.show();
    }

    @FXML
    private void btnKirmiziAlan(ActionEvent e) throws IOException {
        Parent x = FXMLLoader.load(getClass().getResource("KirmiziAlan.fxml"));
        Scene z = new Scene(x);

        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        double width = 1200;
        double height = 860;

        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        window.setX((screenBounds.getWidth() - width) / 2);
        window.setY((screenBounds.getHeight() - height) / 2);
        window.setScene(z);
        window.setTitle("Kırmızı Alan");
        window.show();
    }

}
