package entity;


abstract public class Hastane {
    private String tc,ad,soyad;
    private String tel;
    private String eposta,cinsiyet;

    public Hastane(String tc, String ad, String soyad, String tel, String eposta, String cinsiyet) {
        this.tc = tc;
        this.ad = ad;
        this.soyad = soyad;
        this.tel = tel;
        this.eposta = eposta;
        this.cinsiyet = cinsiyet;
    }


    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    

    public String getEposta() {
        return eposta;
    }

    public void setEposta(String eposta) {
        this.eposta = eposta;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }
    
    
    
    public void girisCikis(){
        
    }
}
