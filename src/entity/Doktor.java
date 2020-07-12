/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import dao.HastaDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 *
 * @author LENOVO
 */
public class Doktor extends Hastane {

    private String dok_vardiya;
    private String ünvan;

    public Doktor() {
        super(null, null, null, null, null, null);
    }
    

    public Doktor(String tc, String ad, String soyad, String tel, String eposta, String cinsiyet) {
        super(tc, ad, soyad, tel, eposta, cinsiyet);
    }

    public void muayeneEt(String yatakno[],String hstsikayet) {

    }

    

//      @FXML
//    private void btnHastaRaporGir(ActionEvent event) {
//             doktorMuayeneTest(txtSikayet.getText(),txtTeshis.getText(),txtTedavi.getText());
//    }
//
//    public void hastaRaporuGir(String sikayet,String teshis,String tedavi) {
//          HastaDao hd=new HastaDao();
//        hastaBilgileri hb=new hastaBilgileri(sikayet,teshis,tedavi);
////        hs.setSikayet(Sikayet);
////        hs.setHstTeshis(Teshis);
////        hs.setTedavi(txtTedavi);
//      hd.hastaRaporKaydet(hb);
//       
//        System.out.println("-------  .. TEST EDİLİYOR ..  -------  ");
//        System.out.println("Şikayet : "+hb.getSikayet()+
//                "Teşhis : "+hb.getHstTeshis()+
//                "Tedavi : "+hb.getTedavi());
//        
//        
//    }
//public void doktorMuayeneTest(String sikayet,String teshis,String tedavi ){
//    String x=sikayet;
//    String y=teshis;
//    String z=tedavi;
//    hastaRaporuGir(x,y,z);
//}
    
    public String getDok_vardiya() {
        return dok_vardiya;
    }

    public void setDok_vardiya(String dok_vardiya) {
        this.dok_vardiya = dok_vardiya;
    }

    public String getÜnvan() {
        return ünvan;
    }

    public void setÜnvan(String ünvan) {
        this.ünvan = ünvan;
    }

    private void hastaRaporuGir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
