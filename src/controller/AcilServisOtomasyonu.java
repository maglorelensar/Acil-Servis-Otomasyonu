/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author LENOVO
 */
public class AcilServisOtomasyonu extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("AdminGiris.fxml"));

        Scene scene = new Scene(root);
        //scene.setFill(Color.TRANSPARENT);
         //stage.initStyle(StageStyle.TRANSPARENT);
        double width = 320;
        double height = 480;

        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((screenBounds.getWidth() - width) / 2);
        stage.setY((screenBounds.getHeight() - height) / 2);
        //stage.centerOnScreen();
        //stage.setY(stage.getY() * 3f / 2f);
        stage.setScene(scene);
        stage.setTitle("ADMİN GİRİŞ");
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
