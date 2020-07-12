/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategy;

/**
 *
 * @author LENOVO
 */
public class durumuKirmizi implements hastaMuayene {
      @Override
    public String hastaDurum() {
        
        return "Hastanın Durumu Ağır";
    }

    @Override
    public String hastaAlan() {
       return " Kırmızı Alana Yerleştirilior .. ";
    }
    
}



