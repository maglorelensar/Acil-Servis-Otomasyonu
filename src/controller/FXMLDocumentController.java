/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.HastaDao;
import entity.Hasta;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Callback;
import util.DBConnection;


public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField txtAd;
    @FXML
    private TextField txtSoyad;
    @FXML
    private TextField txtTc;
    @FXML
    private TextField txtTel;
    @FXML
    private TextField txtEposta;
    @FXML
    private RadioButton rdbKiz;
    @FXML
    private RadioButton rdbErkek;
    @FXML
    private TableView tableeview;
    @FXML
    private Label lbluyari;
    @FXML
    private ToggleGroup tglGroup;

    private HastaDao hd;
    private Hasta h;
    private DBConnection db;

    public DBConnection getDb() {
        if (this.db == null) {
            this.db = new DBConnection();
        }
        return db;
    }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public HastaDao getHd() {
        if (this.hd == null) {
            this.hd = new HastaDao();
        }
        return hd;
    }

    public Hasta getH() {
        if (this.h == null) {
            this.h = new Hasta();
        }
        return h;
        
    }

    public String x = " ";

    @FXML
    private void btnKaydet(ActionEvent event) {
        if (rdbErkek.isSelected()) {
            this.x = "Erkek";
        }
        if (rdbKiz.isSelected()) {
            this.x = "Kız";
        }
        if (txtTc.getText().isEmpty() || txtAd.getText().isEmpty() || txtSoyad.getText().isEmpty()) {
            //lbluyari.setText("Zorunlu Alanlar Boş Bırakılamaz !!");
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("");
            alert.setHeaderText("                                   UYARI");
            alert.setContentText("                      Zorunlu Alanlar Boş Bırakılamaz !!");

            alert.showAndWait();
        } else {
              
            Hasta h = new Hasta(txtTc.getText(), txtAd.getText(), txtSoyad.getText(),
                    txtTel.getText(), txtEposta.getText(), this.x);
            getHd().addToList(h);
            dataTransfer(tableeview);
            
            txtTc.setText("");
            txtAd.setText("");
            txtSoyad.setText("");
            txtTel.setText("");
            txtEposta.setText("");
            rdbErkek.setSelected(false);
            rdbKiz.setSelected(false);
        }
        //lbluyari.setText(null);

    }
    private ObservableList<ObservableList> aa;

    private void dataTransfer(TableView t) {
        t.getColumns().clear();
        Connection c;
        aa = FXCollections.observableArrayList();
        try {
            c = getDb().getConnection();
            //sql string ifademiz. 
            String SQL = "SELECT * from  hastagiris";//tablomuzun adı bilgi. id ve adi alanları var. 
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
    private void btnSil(ActionEvent e) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("                                          ONAYLA");
        alert.setHeaderText(tableeview.getSelectionModel().getSelectedItems().get(0).toString());
        alert.setContentText("Bu kaydı silmek istediğinize emin misiniz?");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK) {
            // ... user chose OK
            TablePosition pos = (TablePosition) tableeview.getSelectionModel().getSelectedCells().get(0);
            int row = pos.getRow();
            TableColumn col = pos.getTableColumn();
            String data = (String) col.getCellObservableValue(row).getValue();
            System.out.println(data);
            getH().setTc(data);
            getHd().delete(getH());
            dataTransfer(tableeview);
        } else {
            // ... user chose CANCEL or closed the dialog
        }

// Item here is the table view type:
        //  TableView item = (TableView) tableeview.getItems().get(row);
// this gives the value in the selected cell:
//        System.out.println(tableeview.getSelectionModel().getSelectedItems());
//        System.out.println(tableeview.getItems().removeAll(tableeview.getSelectionModel().getSelectedItem())); 
    }
    ObservableList<String> hlist;

    @FXML
    private void btnDüzenle(ActionEvent event) {
        rdbErkek.setSelected(false);
        rdbKiz.setSelected(false);

        //hlist=FXCollections.observableArrayList();
        hlist = (ObservableList<String>) tableeview.getSelectionModel().getSelectedItems().get(0);
        System.out.println(hlist.get(0));
        // String a=hlist.get(0);
        txtTc.setText(hlist.get(0));
        txtAd.setText(hlist.get(1));
        txtSoyad.setText(hlist.get(2));
        txtTel.setText(hlist.get(3));
        txtEposta.setText(hlist.get(4));
        if (hlist.get(5).equals("Erkek")) {
            rdbErkek.setSelected(true);
        }
        if (hlist.get(5).equals("Kız")) {
            rdbKiz.setSelected(true);
        }
        // txtTc.setText(hlist.get(0).toString());
        System.out.println(hlist);
    }

    @FXML
    private void btnGüncelle(ActionEvent e) {
        if (rdbErkek.isSelected()) {
            this.x = "Erkek";
        }
        if (rdbKiz.isSelected()) {
            this.x = "Kız";
        }
        Hasta hst = new Hasta(hlist.get(0), txtAd.getText(),
                txtSoyad.getText(), txtTel.getText(), txtEposta.getText(), this.x);
        getHd().update(hst);
        dataTransfer(tableeview);

        txtTc.setText("");
        txtAd.setText("");
        txtSoyad.setText("");
        txtTel.setText("");
        txtEposta.setText("");
        rdbErkek.setSelected(false);
        rdbKiz.setSelected(false);
        this.x = "";
    }

    @FXML
    private void btnGörüntüle(ActionEvent event) {
        dataTransfer(tableeview);
    }

    @FXML
    private void btnGörüntüKapat(ActionEvent event) {
        tableeview.getItems().removeAll(aa);
    }

    @FXML
    private void btnFormTemizle(ActionEvent event) {
        txtTc.setText("");
        txtAd.setText("");
        txtSoyad.setText("");
        txtTel.setText("");
        txtEposta.setText("");
        rdbErkek.setSelected(false);
        rdbKiz.setSelected(false);
    }

    private void btnAra(ActionEvent e) throws IOException {
        Parent x = FXMLLoader.load(getClass().getResource("FXMLHastaAra.fxml"));
        Scene z = new Scene(x);

        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setScene(z);
        window.setTitle("HASTA ARA");
        window.show();
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

    private void btnKirmizi(ActionEvent e) throws IOException {
        Parent x = FXMLLoader.load(getClass().getResource("KirmiziAlan.fxml"));
        Scene z = new Scene(x);

        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setScene(z);
        window.setTitle("Kırmızı Alan");
        window.show();
    }

    private void btnYesil(ActionEvent e) throws IOException {
        Parent x = FXMLLoader.load(getClass().getResource("YesilAlan.fxml"));
        Scene y = new Scene(x);

        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setScene(y);
        window.setTitle("YEŞİL ALAN");
        window.show();
    }

}
