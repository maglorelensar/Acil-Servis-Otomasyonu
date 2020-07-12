package dao;

import controller.GirisController;
import controller.MuayeneOlController;
import entity.Hasta;
import entity.hastaBilgileri;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import util.DBConnection;


public class HastaDao {

    private Connection c;

    public Connection getC() {
        this.c = new DBConnection().getConnection();
        return c;
    }
/*Statement tablomuza giriş yapmamızı sağlar.Statement ile giriş yapmanun ardından Resulset 
    ile de tablomuzun içersinde satır ve sütunlarda gezinmemizi sağlayan nesnedir*/
    public List<Hasta> getList() {
        List<Hasta> hlist = new ArrayList<>();
        try {
            Statement st = this.getC().createStatement();
            ResultSet rs = st.executeQuery("select * from hastagiris");

            //isteğe bağlı for ile optimize edilebilir !
            while (rs.next()) {
          hlist.add(new Hasta(rs.getString("Tc"), rs.getString("Ad"),
          rs.getString("Soyad"), rs.getString("Tel"), rs.getString("Eposta"), rs.getString("Cinsiyet")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return hlist;
    }

    public void addToList(Hasta h) {
         List<Hasta> hlist = new ArrayList<>();
         
        try {
            Statement st = this.getC().createStatement();
            st.executeUpdate("insert into hastagiris values('" + h.getTc()+ "'," + "'" + h.getAd() + "','" + h.getSoyad()+ "','" + h.getTel()+ "'"
                            + ",'" + h.getEposta()+ "','" + h.getCinsiyet()+ "',default);");
        } catch (Exception e) {
            System.out.println(e.getMessage());
             Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("");
            alert.setHeaderText("                                   UYARI");
            alert.setContentText("                          Bu kayıt zaten mevcut !!");

            alert.showAndWait();
            
        }
        hlist.add(h);
    }

    public void delete(Hasta h) {

        try {
            Statement st = this.getC().createStatement();
            st.executeUpdate("delete from hastagiris where Tc=" +"'"+h.getTc()+"'");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void update(Hasta h) {
        try {
            Statement st = this.getC().createStatement();

            st.executeUpdate("Update hastagiris set Ad='" + h.getAd() + "',Soyad='" + 
                   h.getSoyad() + "',Tel='" + 
                   h.getTel()+"',Eposta='" + 
                   h.getEposta()+"',Cinsiyet='" + 
                   h.getCinsiyet()+"' where Tc='" + h.getTc() + "'");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
       public void yatanHastaUpdate(String ad,String hst_durum) {
        try {
            Statement st = this.getC().createStatement();

            st.executeUpdate("Update yatanhasta set hasta_durum='" + hst_durum +
                    "'where hasta_adi='"+ad +"'"); 
                

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
       public String ad = "";
                public void yatakTahsisUpdate(String hasta_adi,String hasta_durum) {
        try {
            Statement st = this.getC().createStatement();

            st.executeUpdate("Update yataktahsis set hasta_durum='" + hasta_durum +
                    "'where hasta_adi='"+hasta_adi +"'"); 
                

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
     
         public List<String> hastaAra(String tc) {
       List<String> aramalistesi=new ArrayList<>();
      
        try {
             PreparedStatement pst = this.getC().prepareStatement("select * from hastagiris where Tc='"+tc+"'",Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = pst.executeQuery();
            
//            PreparedStatement pst = getC().prepareStatement("select * from ilackayit where ilac_no='"+i.getIlac_no()+"'");
//            ResultSet rs=pst.executeQuery();
            
            while(rs.next()){
            System.out.println(rs.getString("Ad"));
            this.ad=rs.getString("Ad");
            }
            
             System.out.println("Arama Başarılı");
            return aramalistesi;
           
            } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Arama Başarısız");
             
        } 
        return aramalistesi;
    }

    public void hastaRaporKaydet(hastaBilgileri hb) {
         List<hastaBilgileri> hlist = new ArrayList<>();
         
        try {
            Statement st = this.getC().createStatement();
            st.executeUpdate("insert into hastagiris values('" + hb.getSikayet()+ "'," + "'" 
                    + hb.getHstTeshis() +"','" + hb.getTedavi()+ "'");
            System.out.println("Kayıt İşlemi Başarılı ");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Kayır İşlemi Başarısız");
            
        }
        hlist.add(hb);
    }
    

    public void yatanHastaDelete(String yatak_no) {
          try {
            Statement st = this.getC().createStatement();
            st.executeUpdate("delete from yatanhasta where yatak_no=" +"'"+yatak_no+"'");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
