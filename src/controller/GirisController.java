
package controller;

import dao.HastaDao;
import entity.Sekreter;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class GirisController implements Initializable {

    @FXML
    private TextField txtTc;

 public   String x;
 private HastaDao hdao;

    public HastaDao getHdao() {
        if(this.hdao==null)
            this.hdao=new HastaDao();
        return hdao;
    }

 
 
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public String z=null;
    @FXML
    private void btnGiris(ActionEvent e) throws IOException {
       
        
        
        Parent root = FXMLLoader.load(getClass().getResource("AraGecit.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        
        double width = 538;
        double height = 300;

        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((screenBounds.getWidth() - width) / 2);
        stage.setY((screenBounds.getHeight() - height) / 2);

        stage.setScene(scene);
        stage.setTitle("");
        stage.show();
        
         z=txtTc.getText();
        getHdao().hastaAra(txtTc.getText());
             
       
        x=getHdao().ad;
        System.out.println(x);

//        Sekreter s = new Sekreter();
//        s.girisAl(txtTc.getText().toString(), txtAd.getText().toString(), txtYas.getText().toString(), txtCinsiyet.getText().toString());
    }

    @FXML
    private void btnGeri(ActionEvent e) throws IOException {
        Parent x = FXMLLoader.load(getClass().getResource("Köprü.fxml"));
        Scene z = new Scene(x);

        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        double width = 400;
        double height = 300;

        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        window.setX((screenBounds.getWidth() - width) / 2);
        window.setY((screenBounds.getHeight() - height) / 2);

        window.setScene(z);
        window.setTitle("");
        window.show();
    }

}
