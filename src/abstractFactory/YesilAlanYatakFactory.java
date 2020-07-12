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
public class YesilAlanYatakFactory implements hastaFactory{
 
       @Override
       public hastaDurum createNewYatak() {
           return new yatakYesilAlan();
       }
}

