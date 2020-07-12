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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXMLHastaAraController implements Initializable {

    @FXML
    private TableView<?> tblw;
    @FXML
    private TextField txtAra;

    @FXML
    private void btnHAnaSayfa(ActionEvent e) throws IOException {
        Parent tableWiewParent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene tableWiewScene = new Scene(tableWiewParent);

        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setScene(tableWiewScene);
        window.setTitle("ÜRÜNLER");
        window.show();
    }

    @FXML
    private void btnAra(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
