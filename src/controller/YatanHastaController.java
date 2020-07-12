/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import adapter.Saglikli_İnsan;
import adapter.Sagliksiz_SaglikliAdapter;
import adapter.Sagliksiz_İnsan;
import adapter.interfaceSagliksizİnsan;
import dao.HastaDao;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Callback;
import util.DBConnection;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class YatanHastaController implements Initializable {

    @FXML
    private TableView<?> tblview;
    @FXML
    private RadioButton rdbAtesYok;
    @FXML
    private ToggleGroup tgl1;
    @FXML
    private RadioButton rdbOksurukYok;
    @FXML
    private ToggleGroup tgl2;
    @FXML
    private RadioButton rdbOksurukVar;
    @FXML
    private RadioButton rdbAtesVar;
    @FXML
    private RadioButton rdbHalsizlikYok;
    @FXML
    private ToggleGroup tgl3;
    @FXML
    private RadioButton rdbHalsizlikVar;
    @FXML
    private RadioButton rdbNefesDarligiYok;
    @FXML
    private ToggleGroup tgl4;
    @FXML
    private RadioButton rdbNefesDarligiVar;
    @FXML
    private Label lblMuayeneEdilenKisi;
    @FXML
    private TextArea txtArea;

    private DBConnection db;
    private HastaDao hdao;
    @FXML
    private Label lblMuayeneTamamla;

    public HastaDao getHdao() {
        if (this.hdao == null) {
            this.hdao = new HastaDao();
        }
        return hdao;
    }

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

    @FXML
    private void btnMuayeneEt(ActionEvent event) {
        TablePosition pos = (TablePosition) tblview.getSelectionModel().getSelectedCells().get(0);
        int row = pos.getRow();
        TableColumn col = pos.getTableColumn();
        String data = (String) col.getCellObservableValue(row).getValue();

        System.out.println(data);
        lblMuayeneEdilenKisi.setText(data + " Muayene Ediliyor ..");

    }

    @FXML
    private void btnGoruntulle(ActionEvent event) {
        dataTransfer(tblview);
    }

    @FXML
    private void btnKapat(ActionEvent event) {
        tblview.getItems().removeAll(aa);
    }

   //Sağlıklı insan nesnesi oluşturuldu
    Saglikli_İnsan si = new Saglikli_İnsan();
    //Sağlıksız insan interfacesinden nesne oluşturuldu
    interfaceSagliksizİnsan szi = new Sagliksiz_İnsan();
    /*Sağlıksız insanın özelliklerini sağlıklı insanın özelliklerine 
    adapte edilebilmesi(çevrilmesi) için sağlıklı insanın si nesnesi 
    Sagliksiz_SaglikliAdapter sınıfımıza parametre olarak gönderildi.
   */
    interfaceSagliksizİnsan adptr = new Sagliksiz_SaglikliAdapter(si);
    @FXML
    private void btnHastaBilgisiGöster(ActionEvent event) {
        TablePosition pos = (TablePosition) tblview.getSelectionModel().getSelectedCells().get(0);
        int row = pos.getRow();
        TableColumn col = pos.getTableColumn();
        String data = (String) col.getCellObservableValue(row).getValue();

        if (data.equalsIgnoreCase("KORONA")) {
            txtArea.setText(szi.atesVAR() + "\n" + szi.oksurukVAR() + "\n" + szi.halsizlikVAR() + "\n" + szi.nefesDarligiVAR());
        } else if (data.equalsIgnoreCase("ŞÜPHELİ")) {
            txtArea.setText("HASTA ŞÜPHELİ !");
        } else {
            txtArea.setText(adptr.atesVAR() + "\n" + adptr.oksurukVAR() + "\n" + adptr.halsizlikVAR() + "\n" + adptr.nefesDarligiVAR());

        }
    }

    @FXML
    private void btnMuayeneTamamla(ActionEvent event) {
        TablePosition pos = (TablePosition) tblview.getSelectionModel().getSelectedCells().get(0);
        int row = pos.getRow();
        TableColumn col = pos.getTableColumn();
        String x = (String) col.getCellObservableValue(row).getValue();

        if (rdbAtesVar.isSelected() && rdbOksurukVar.isSelected() && rdbHalsizlikVar.isSelected() && rdbNefesDarligiVar.isSelected()) {
            lblMuayeneTamamla.setText(x + " Halen Korona ");
            getHdao().yatanHastaUpdate(x, "KORONA");
        } else if (rdbAtesYok.isSelected() && rdbOksurukYok.isSelected() && rdbHalsizlikYok.isSelected() && rdbNefesDarligiYok.isSelected()) {
            lblMuayeneTamamla.setText(x + " İyileşmiş !!");
            getHdao().yatanHastaUpdate(x, "İYİLEŞTİ");
        } else {
            lblMuayeneTamamla.setText(x + " Şüpheli");
            getHdao().yatanHastaUpdate(x, "ŞÜPHELİ");
        }
        dataTransfer(tblview);
        lblMuayeneEdilenKisi.setText("");
    }

    private ObservableList<ObservableList> aa;

    private void dataTransfer(TableView t) {
        t.getColumns().clear();
        Connection c;
        aa = FXCollections.observableArrayList();
        try {
            c = getDb().getConnection();
            //sql string ifademiz. 
            String SQL = "SELECT * from  yatanHasta";//tablomuzun adı bilgi. id ve adi alanları var. 
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
    private void btnTaburcuEt(ActionEvent event) {
        TablePosition pos = (TablePosition) tblview.getSelectionModel().getSelectedCells().get(0);
        int row = pos.getRow();
        TableColumn col = pos.getTableColumn();
        String data = (String) col.getCellObservableValue(row).getValue();
        if (data.equalsIgnoreCase("KORONA")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("");
            alert.setHeaderText("                                     UYARI");
            alert.setContentText("                         Bu Hasta Taburcu Edilemez  !!");

            alert.showAndWait();
        } else if (data.equalsIgnoreCase("İYİLEŞTİ")) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("                                          ONAYLA");
            alert.setHeaderText(tblview.getSelectionModel().getSelectedItems().get(0).toString());
            alert.setContentText("Bu hastayı taburcu etmek istediğinize emin misiniz?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                // ... user chose OK
   ObservableList<String> hlist;
   hlist=(ObservableList<String>) tblview.getSelectionModel().getSelectedItems().get(0);
                System.out.println(data);
                getHdao().yatanHastaDelete(hlist.get(0));
                System.out.println(data);

                dataTransfer(tblview);
            } else {
                // ... user chose CANCEL or closed the dialog
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("");
            alert.setHeaderText("                                     UYARI");
            alert.setContentText("                       Hasta tedavi görmeye devam etmeli  !!");

            alert.showAndWait();

        }

    }

    @FXML
    private void btnGeri(ActionEvent e) throws IOException {
        Parent x = FXMLLoader.load(getClass().getResource("AraGecit.fxml"));

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

}
