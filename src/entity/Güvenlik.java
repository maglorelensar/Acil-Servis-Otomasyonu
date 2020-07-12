package entity;

public class Güvenlik extends Hastane{

    private String güc;
    private String g_vardiya;

    public Güvenlik(String tc, String ad, String soyad, String tel, String eposta, String cinsiyet) {
        super(tc, ad, soyad, tel, eposta, cinsiyet);
    }
   
    public void hastaneyiTara() {
            
    }

    public void koru() {

    }

    public void destekİste() {

    }

    public String getGüc() {
        return güc;
    }

    public void setGüc(String güc) {
        this.güc = güc;
    }

    public String getG_vardiya() {
        return g_vardiya;
    }

    public void setG_vardiya(String g_vardiya) {
        this.g_vardiya = g_vardiya;
    }

  


}
