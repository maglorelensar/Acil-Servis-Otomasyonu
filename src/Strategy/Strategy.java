
package Strategy;


public class Strategy {
       private hastaMuayene hst_durum;

   
   public Strategy(hastaMuayene hst_durum){
      this.hst_durum = hst_durum;
   }
   
   //Hasta durumuna göre hangi alana(Kırmız,Sarı,Yeşil) yerleştirilecek ?
     public String stratejiyiUygula(){
         
    return hst_durum.hastaDurum();
     
     }
     public String strtj_hangiAlanaYerleştrilmeli(){
         
         return hst_durum.hastaAlan();
     }

}
