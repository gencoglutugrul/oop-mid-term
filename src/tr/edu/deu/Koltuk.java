package tr.edu.deu;

public class Koltuk {

    private int siraNo;
    private int salonNo;
    private int koltukNo;
    private boolean bosMu;

    public Koltuk(int siraNo, int salonNo, int koltukNo, boolean bosMu){
        this.siraNo = siraNo;
        this.salonNo = salonNo;
        this.koltukNo = koltukNo;
        this.bosMu = bosMu;
    }

    public void yerAyir(){
        this.bosMu = false;
    }

    public int getSiraNo() {
        return siraNo;
    }

    public int getSalonNo() {
        return salonNo;
    }

    public int getKoltukNo() {
        return koltukNo;
    }

    public boolean bosMu() {
        return bosMu;
    }

}
