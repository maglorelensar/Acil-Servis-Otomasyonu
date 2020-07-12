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
public class Hasta extends Hastane {

    private String hasta_durum;
    private int müsade_no;

    public Hasta(String tc, String ad, String soyad, String tel, String eposta, String cinsiyet) {
        super(tc, ad, soyad, tel, eposta, cinsiyet);
    }

    public Hasta() {
        super(null, null, null, null, null, null);
    }


    public void girisYap() {
           
    }

    public String getHasta_durum() {
        return hasta_durum;
    }

    public void setHasta_durum(String hasta_durum) {
        this.hasta_durum = hasta_durum;
    }

    public int getMüsade_no() {
        return müsade_no;
    }

    public void setMüsade_no(int müsade_no) {
        this.müsade_no = müsade_no;
    }

}
