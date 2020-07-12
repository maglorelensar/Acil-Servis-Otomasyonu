
package Strategy;


public class durumuSari implements hastaMuayene{
        @Override
    public String hastaDurum() {
        
        return "Hastanın Durumu Şüpheli";
    }
    
    @Override
    public String hastaAlan() {
       return " Sarı Alana Yerleştirilior .. ";
    }
    
}



