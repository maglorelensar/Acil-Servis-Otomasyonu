/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author LENOVO
 */
public class geciciHastaBilgileri {
    private String tc;
    private String ad;
    private String yas;
    private String Cinsiyet;

    public geciciHastaBilgileri() {
    }
    
    public geciciHastaBilgileri(String tc, String ad, String yas, String Cinsiyet) {
        this.tc = tc;
        this.ad = ad;
        this.yas = yas;
        this.Cinsiyet = Cinsiyet;
    }

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getYas() {
        return yas;
    }

    public void setYas(String yas) {
        this.yas = yas;
    }

    public String getCinsiyet() {
        return Cinsiyet;
    }

    public void setCinsiyet(String Cinsiyet) {
        this.Cinsiyet = Cinsiyet;
    }
    
    
}
