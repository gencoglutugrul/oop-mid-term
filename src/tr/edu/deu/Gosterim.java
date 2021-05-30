package tr.edu.deu;

import java.util.ArrayList;

public class Gosterim {
    private ArrayList<Koltuk> koltuklar;
    private String filmAdi;
    private String seans;
    private String tarih;
    private int salonNo;

    public Gosterim(String filmAdi, String seans, String tarih, int salonNo, ArrayList<Koltuk> koltuklar){
        this.filmAdi = filmAdi;
        this.seans = seans;
        this.tarih = tarih;
        this.salonNo = salonNo;
        this.koltuklar = koltuklar;
    }


    public ArrayList<Koltuk> getKoltuklar() {
        return koltuklar;
    }

    public void setKoltuklar(ArrayList<Koltuk> koltuklar) {
        this.koltuklar = koltuklar;
    }

    public String getFilmAdi() {
        return filmAdi;
    }

    public void setFilmAdi(String filmAdi) {
        this.filmAdi = filmAdi;
    }

    public String getSeans() {
        return seans;
    }

    public void setSeans(String seans) {
        this.seans = seans;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public int getSalonNo() {
        return salonNo;
    }

    public void setSalonNo(int salonNo) {
        this.salonNo = salonNo;
    }
}
