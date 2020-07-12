
package Strategy;


public class durumuYesil implements hastaMuayene{
    @Override
    public String hastaDurum() {
        
        return "Hastanın Durumu Kritik veya Şüheli Değil";
    }
    
    @Override
    public String hastaAlan() {
       return " Yeşil Alana Yerleştirilior .. ";
    }

}
