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
public class KöprüController implements Initializable {
public void center(){
    
}
    @FXML
    private void btnKayit(ActionEvent e) throws IOException {
        Parent x = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene z = new Scene(x);

        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        double width = 773;
        double height = 450;

        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        window.setX((screenBounds.getWidth() - width) / 2);
        window.setY((screenBounds.getHeight() - height) / 2);
        //window.centerOnScreen();
        window.setScene(z);
        window.setTitle("");
        window.show();
    }

    @FXML
    private void btnGiris(ActionEvent e) throws IOException {
        Parent x = FXMLLoader.load(getClass().getResource("AraGecit.fxml"));
        Scene z = new Scene(x);

        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        double width = 496;
        double height = 300;

        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        window.setX((screenBounds.getWidth() - width) / 2);
        window.setY((screenBounds.getHeight() - height) / 2);
        //window.centerOnScreen();
        window.setScene(z);
        window.setTitle("HASTA ARA");
        window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
