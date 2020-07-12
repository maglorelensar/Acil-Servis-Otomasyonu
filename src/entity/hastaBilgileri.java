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
public class hastaBilgileri {
    private String hstTeshis;
    private String tedavi;
    private String sikayet;

    
    public hastaBilgileri(String hstTeshis, String tedavi, String sikayet) {
        this.hstTeshis = hstTeshis;
        this.tedavi = tedavi;
        this.sikayet = sikayet;
    }
    

    public String getSikayet() {
        return sikayet;
    }

    public void setSikayet(String sikayet) {
        this.sikayet = sikayet;
    }
    

    public String getHstTeshis() {
        System.out.println(hstTeshis);
        return hstTeshis;
        
    }

    public void setHstTeshis(String hstTeshis) {
        this.hstTeshis = hstTeshis;
    }

    public String getTedavi() {
        return tedavi;
    }

    public void setTedavi(String tedavi) {
        this.tedavi = tedavi;
    }
    
}
