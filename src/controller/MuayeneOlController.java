/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Strategy.Strategy;
import Strategy.durumuKirmizi;
import Strategy.durumuSari;
import Strategy.durumuYesil;
import dao.HastaDao;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class MuayeneOlController implements Initializable {

    @FXML
    private ToggleGroup tglGroup;
    @FXML
    private RadioButton rdbYesil;
    @FXML
    private RadioButton rdbSari;
    @FXML
    private RadioButton rdbKirmizi;
    @FXML
    private Label lblMuayeneSonuc;
    @FXML
    private TextField txtTc;
    
 private HastaDao hdao;
    @FXML
    private Label lblMuayeneTamamla;
 

    public HastaDao getHdao() {
        if(this.hdao==null)
            this.hdao=new HastaDao();
        return hdao;
    }
 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
   
    @FXML
    private void btnMuayeneTamamla(ActionEvent event) {
        Strategy srk=new Strategy(new durumuKirmizi()); 
        Strategy srs=new Strategy(new durumuSari()); 
        Strategy sry=new Strategy(new durumuYesil()); 
        if(rdbYesil.isSelected()){
        lblMuayeneTamamla.setText(getHdao().ad+sry.strtj_hangiAlanaYerleştrilmeli());
        getHdao().yatakTahsisUpdate(getHdao().ad, "Yeşil");
        }
        if(rdbSari.isSelected()){
           lblMuayeneTamamla.setText(getHdao().ad+srs.strtj_hangiAlanaYerleştrilmeli());
         getHdao().yatakTahsisUpdate(getHdao().ad, "Sarı");
        }
        if(rdbKirmizi.isSelected()){
            lblMuayeneTamamla.setText(getHdao().ad +srk.strtj_hangiAlanaYerleştrilmeli());
         getHdao().yatakTahsisUpdate(getHdao().ad, "Kırmızı");
        }
        lblMuayeneSonuc.setText("");
    }

    @FXML
    private void btnMuayene(ActionEvent event) {
       lblMuayeneSonuc.setText(getHdao().ad+"  Muayene ediliyor ..");
        
    }

    @FXML
    private void btnGiris(ActionEvent event) {
        getHdao().hastaAra(txtTc.getText());
       
        txtTc.setText("");
        
    }

    @FXML
    private void btnGeri(ActionEvent e) throws IOException {
         Parent x = FXMLLoader.load(getClass().getResource("AraGecit.fxml"));

            Scene z = new Scene(x);

            Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();

            // window.initStyle(StageStyle.TRANSPARENT);
            //window.centerOnScreen();
            double width = 496;
            double height = 250;

            Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
            window.setX((screenBounds.getWidth() - width) / 2);
            window.setY((screenBounds.getHeight() - height) / 2);
       
            window.setScene(z);
            window.setTitle("");
            window.show();
    }

    @FXML
    private void btnYatakTahsisEt(ActionEvent e) throws IOException {
        Parent x = FXMLLoader.load(getClass().getResource("yatakTahsis.fxml"));

            Scene z = new Scene(x);

            Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();

            // window.initStyle(StageStyle.TRANSPARENT);
            //window.centerOnScreen();
            double width = 496;
            double height = 250;

            Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
            window.setX((screenBounds.getWidth() - width) / 2);
            window.setY((screenBounds.getHeight() - height) / 2);
       
            window.setScene(z);
            window.setTitle("");
            window.show();
    }

    @FXML
    private void btnAlanlar(ActionEvent e) throws IOException {
        Parent x = FXMLLoader.load(getClass().getResource("Alanlar.fxml"));

            Scene z = new Scene(x);

            Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();

            // window.initStyle(StageStyle.TRANSPARENT);
            //window.centerOnScreen();
            double width = 550;
            double height = 300;

            Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
            window.setX((screenBounds.getWidth() - width) / 2);
            window.setY((screenBounds.getHeight() - height) / 2);
       
            window.setScene(z);
            window.setTitle("");
            window.show();
    }
    
}
