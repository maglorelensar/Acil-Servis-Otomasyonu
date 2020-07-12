/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adapter;

/**
 *
 * @author LENOVO
 */
public class Sagliksiz_İnsan implements interfaceSagliksizİnsan{
        @Override
    public String atesVAR() {
        return "Ateşi var ";
    }

    @Override
    public String oksurukVAR() {
        return "Öksürüğü Şiddetli";
    }

    @Override
    public String halsizlikVAR() {
        return "Hali yok , bitkin ";
    }

    @Override
    public String nefesDarligiVAR() {
        return "Nefes darlığı mevcut";
    }

}
