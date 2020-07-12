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
public class Hemşire extends Hastane{
    private String hem_vardiya;

    public Hemşire(String tc, String ad, String soyad, String tel, String eposta, String cinsiyet) {
        super(tc, ad, soyad, tel, eposta, cinsiyet);
    }

    public String getHem_vardiya() {
        return hem_vardiya;
        
    }

    public void setHem_vardiya(String hem_vardiya) {
        this.hem_vardiya = hem_vardiya;
    }
    
    
    public void talimatUygula(){
        
    }
    
}
