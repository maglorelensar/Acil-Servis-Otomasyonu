/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractFactory;

/**
 *
 * @author LENOVO
 */
public class AbstracttFactory {
    public String factoryS(String hasta_durum){
    switch (hasta_durum){
    case "Kırmızı":
            return "Kırmızı Alan Yatağı Üretilior ..";
    case "Sarı":
           return "Sarı Alan Yatağı Üretilior ..";
    case "Yeşil":
           return "Yeşil Alan Yatağı Üretilior ..";
    default:
           System.out.println("Hastanın Durumu Belirlenemedi");
}
         return null;

}
}
