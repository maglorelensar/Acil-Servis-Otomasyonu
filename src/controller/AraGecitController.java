
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


public class AraGecitController implements Initializable {

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void btnDisaridanGelenHasta(ActionEvent e) throws IOException {
         Parent x = FXMLLoader.load(getClass().getResource("MuayeneOl.fxml"));

            Scene z = new Scene(x);

            Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();

            // window.initStyle(StageStyle.TRANSPARENT);
            //window.centerOnScreen();
            double width = 600;
            double height = 450;

            Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
            window.setX((screenBounds.getWidth() - width) / 2);
            window.setY((screenBounds.getHeight() - height) / 2);
       
            window.setScene(z);
            window.setTitle("");
            window.show();
    }

    @FXML
    private void btnYatanHasta(ActionEvent e) throws IOException {
        Parent x = FXMLLoader.load(getClass().getResource("YatanHasta.fxml"));

            Scene z = new Scene(x);

            Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();

            // window.initStyle(StageStyle.TRANSPARENT);
            //window.centerOnScreen();
            double width = 606;
            double height = 550;

            Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
            window.setX((screenBounds.getWidth() - width) / 2);
            window.setY((screenBounds.getHeight() - height) / 2);
       
            window.setScene(z);
            window.setTitle("");
            window.show();
    }
    
}
