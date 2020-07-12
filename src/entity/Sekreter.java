/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import controller.YesilAlanController;
import dao.HastaDao;

/**
 *
 * @author LENOVO
 */
public class Sekreter extends Hastane{

    private String s_vardiya;
    private geciciHastaBilgileri gh;
    YesilAlanController yc=new YesilAlanController();
  
    public Sekreter() {
        super(null, null, null, null, null, null);
       // this.gh=new geciciHastaBilgileri();
        
    }
  
    public geciciHastaBilgileri getGh() {
        return gh;
    }

    public void setGh(geciciHastaBilgileri gh) {
        this.gh = gh;
    }
 
    public Sekreter(String tc, String ad, String soyad, String tel, String eposta, String cinsiyet) {
        super(tc, ad, soyad, tel, eposta, cinsiyet);
    }

    public void girisAl(String tc,String ad,String yas,String Cinsiyet){
         geciciHastaBilgileri gb=new geciciHastaBilgileri(tc, ad, yas, Cinsiyet);
         yc.nesneKap(gb);
         
    }
    private HastaDao hd;

    public HastaDao getHd() {
        hd=new HastaDao();
        return hd;
    }

//    @FXML
//    private void btnKaydet(ActionEvent event) {
//             bntKaydetTest(txtTc.getText(), txtAd.getText(), txtSoyad.getText(),txtTel.getText(), txtEposta.getText(), this.x);
//    }
//
//    public void hastaBilgileriniKaydet(String tc, String ad, String soyad, String tel, String eposta, String cinsiyet){
//        Hasta h = new Hasta(tc,ad,soyad,tel,eposta,cinsiyet);
//        //HastaDao hd=new HastaDao();
//            System.out.println("Tc : "+h.getTc()+"Ad : "+h.getAd()+"Soyad : "+
//                    h.getSoyad()+"Tel : "+h.getTel()+"Eposta "+h.getEposta()+"Cinsiyet "+h.getCinsiyet());
//            
//           getHd().hastaKaydet(h);
//    }
//    
//      public void hastaKaydet(Hasta h) {
//         List<Hasta> hlist = new ArrayList<>();
//         
//        try {
//            Statement st = this.getC().createStatement();
//            st.executeUpdate("insert into hastagiris values('" + h.getTc()+ "'," + "'" + h.getAd() + "','" + h.getSoyad()+ "','" + h.getTel()+ "'"
//                            + ",'" + h.getEposta()+ "','" + h.getCinsiyet()+ "',default);");
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//             Alert alert = new Alert(Alert.AlertType.WARNING);
//            alert.setTitle("");
//            alert.setHeaderText("                                   UYARI");
//            alert.setContentText("                          Bu kayıt zaten mevcut !!");
//
//            alert.showAndWait();
//            
//        }
//        hlist.add(h);
//    }
//    
//    public void bntKaydetTest(){
//       this.hastaBilgileriniKaydet();
//    }


    public String getS_vardiya() {
        return s_vardiya;
    }

    public void setS_vardiya(String s_vardiya) {
        this.s_vardiya = s_vardiya;
    }
}
