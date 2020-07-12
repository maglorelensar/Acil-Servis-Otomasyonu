
package adapter;


public class Sagliksiz_SaglikliAdapter implements interfaceSagliksizİnsan {
    Saglikli_İnsan insan;

    public Sagliksiz_SaglikliAdapter(Saglikli_İnsan insan) {

        this.insan = insan;
    }

    public String atesVAR() {
       return insan.atesYOK();
    }

    public String oksurukVAR() {
        return insan.oksurukYOK();
    }

    public String halsizlikVAR() {
        return insan.halsizlikYOK();
    }

    public String nefesDarligiVAR() {
        return insan.nefesDarligiYOK();
    }

}
