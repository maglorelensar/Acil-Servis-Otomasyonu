
package abstractFactory;


public class AbstractFactory {

public hastaFactory factoryS(String hasta_durum){
    switch (hasta_durum){
    case "Kırmızı":
            return (hastaFactory) new KirmiziAlanYatakFactory().createNewYatak();
    case "Sarı":
           return (hastaFactory) new SariAlanYatakFactory().createNewYatak();
    case "Yeşil":
           return (hastaFactory) new YesilAlanYatakFactory().createNewYatak();
    default:
           System.out.println("Hastanın Durumu Belirlenemedi");
}
         return null;

}
}

