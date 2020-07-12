/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import abstractFactory.AbstractFactory;
import abstractFactory.AbstracttFactory;
import abstractFactory.hastaFactory;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Callback;
import util.DBConnection;


public class YatakTahsisController implements Initializable {

   
    @FXML
    private TableView<?> tblview;

    private DBConnection db;
    @FXML
    private Label lblYatakGöster;
    public DBConnection getDb() {
        if(this.db==null)
            this.db=new DBConnection();
        return db;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
      private ObservableList<ObservableList> aa;

    private void dataTransfer(TableView t) {
        t.getColumns().clear();
        Connection c;
        aa = FXCollections.observableArrayList();
        try {
            c = getDb().getConnection();
            //sql string ifademiz. 
            String SQL = "SELECT * from  yataktahsis";//tablomuzun adı bilgi. id ve adi alanları var. 
            //ResultSet
            ResultSet rs = c.createStatement().executeQuery(SQL);

            // TABLO SÜTUNLARINI DİNAMİK OLARAK EKLEYECEĞİMİZ YAPI 
            for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });

                t.getColumns().addAll(col);
                System.out.println("Column [" + i + "] ");

            }

            //ObservableList e verileri ekleyen döngü
            while (rs.next()) {
                //Satırları yinele
                ObservableList<String> row = FXCollections.observableArrayList();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    //sütunları yinele
                    row.add(rs.getString(i));
                }
                System.out.println("Satır eklendi " + row);
                aa.add(row);
            }

            //Sonucu tabloya ekleme
            t.setItems(aa);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Hata oluştu");
        }
    }

    @FXML
    private void btnYatakÜret(ActionEvent event) {
         AbstracttFactory abs=new AbstracttFactory();
        TablePosition pos = (TablePosition) tblview.getSelectionModel().getSelectedCells().get(0);
        int row = pos.getRow();
        TableColumn col = pos.getTableColumn();
        String veri = (String) col.getCellObservableValue(row).getValue();
       
        abs.factoryS(veri);
        lblYatakGöster.setText(abs.factoryS(veri));
    }

    @FXML
    private void btnGeri(ActionEvent e) throws IOException {
         Parent x = FXMLLoader.load(getClass().getResource("MuayeneOl.fxml"));

            Scene z = new Scene(x);

            Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();

            // window.initStyle(StageStyle.TRANSPARENT);
            //window.centerOnScreen();
            double width = 496;
            double height = 325;

            Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
            window.setX((screenBounds.getWidth() - width) / 2);
            window.setY((screenBounds.getHeight() - height) / 2);
       
            window.setScene(z);
            window.setTitle("");
            window.show();
    }

    @FXML
    private void btnGörüntüle(ActionEvent event) {
        dataTransfer(tblview);
    }

    @FXML
    private void btnKapat(ActionEvent event) {
         tblview.getItems().removeAll(aa);
    }

}
