package tr.edu.deu;

import java.util.ArrayList;

public class Bilet {
    private ArrayList<Koltuk> koltuklar;
    private String isim;
    private String soyisim;
    private String tcNo;
    private Gosterim gosterim;
    private float fiyat;

    public Bilet(float fiyat, Gosterim gosterim, ArrayList<Koltuk> koltuklar, String isim, String soyisim, String tcNo) {
        this.gosterim = gosterim;
        this.isim = isim;
        this.soyisim = soyisim;
        this.koltuklar = koltuklar;
        this.tcNo = tcNo;
        this.fiyat = fiyat;
    }

    protected void bilgiBasligi(String baslik){
        System.out.println("##############################");
        System.out.println("# " + baslik);
        System.out.println("##############################");
    }

    public void bilgiYazdir(){
        this.bilgiBasligi("BILET BILGILERI");
        System.out.println("#    Isim: " + this.isim);
        System.out.println("# Soyisim: " + this.soyisim);
        System.out.println("#   TC No: " + this.tcNo);
        System.out.println("#   Tutar: " + this.fiyat);
        System.out.println("##############################\n");

        this.bilgiBasligi("GOSTERIM BILGILERI");
        System.out.println("# Film Adı: " + this.gosterim.getFilmAdi());
        System.out.println("# Salon No: " + this.gosterim.getSalonNo());
        System.out.println("#    Seans: " + this.gosterim.getSeans());
        System.out.println("#    Tarih: " + this.gosterim.getTarih());
        System.out.println("##############################\n");

        this.bilgiBasligi("KOLTUK BILGILERI");
        System.out.println("# Koltuk Sayisi: " + this.koltuklar.size());
        for (int i = 0; i < this.koltuklar.size(); i++) {
            System.out.println("# " + (i+1) + ". Koltuk Sıra No: " + this.koltuklar.get(i).getSiraNo());
            System.out.println("#      " + (i+1) + ". Koltuk No: " + this.koltuklar.get(i).getKoltukNo());
        }
        System.out.println("##############################\n");
    }
    
    public float getFiyat() {
        return fiyat;
    }

    public void setFiyat(float fiyat) {
        this.fiyat = fiyat;
    }

    public Gosterim getGosterim() {
        return gosterim;
    }

    public void setGosterim(Gosterim gosterim) {
        this.gosterim = gosterim;
    }

    public ArrayList<Koltuk> getKoltuklar() {
        return koltuklar;
    }

    public void setKoltuklar(ArrayList<Koltuk> koltuklar) {
        this.koltuklar = koltuklar;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    public String getTcNo() {
        return tcNo;
    }

    public void setTcNo(String tcNo) {
        this.tcNo = tcNo;
    }



}
