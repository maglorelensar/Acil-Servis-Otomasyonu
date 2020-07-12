
package adapter;


public class Saglikli_İnsan implements interfaceSaglikliİnsan{
      @Override
    public String atesYOK() {
        return "Ateşi yok !";
    }

    @Override
    public String oksurukYOK() {
        return "Öksürüğü normal";
    }

    @Override
    public String halsizlikYOK() {
        return "Dinç !";
    }

    @Override
    public String nefesDarligiYOK() {
        return "Nefes alış verişi normal ";
    }

}
