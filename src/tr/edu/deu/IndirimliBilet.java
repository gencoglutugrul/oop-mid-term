package tr.edu.deu;

import java.util.ArrayList;

public class IndirimliBilet extends Bilet{
    private String indirimKodu;
    private float indirimMiktari;

    public IndirimliBilet(String indirimKodu, float indirimMiktari, float fiyat, Gosterim gosterim, ArrayList<Koltuk> koltuklar, String isim, String soyisim, String tcNo) {
        super(fiyat - indirimMiktari, gosterim, koltuklar, isim, soyisim, tcNo);
        this.indirimMiktari = indirimMiktari;
        this.indirimKodu = indirimKodu;
    }

    public String getIndirimKodu() {
        return indirimKodu;
    }

    public void setIndirimKodu(String indirimKodu) {
        this.indirimKodu = indirimKodu;
    }

    public float getIndirimMiktari() {
        return indirimMiktari;
    }

    public void setIndirimMiktari(float indirimMiktari) {
        this.indirimMiktari = indirimMiktari;
    }

    @Override
    public void bilgiYazdir() {
        super.bilgiYazdir();
        super.bilgiBasligi("INDIRIM BILGILERI");
        System.out.println("#    Normal Tutar: " + this.indirimMiktari + this.getFiyat());
        System.out.println("#    Indirim Kodu: " + this.indirimKodu);
        System.out.println("# Indirim Miktari: " + this.indirimMiktari);
        System.out.println("#       Son Tutar: " + this.getFiyat());
        System.out.println("##############################\n");
    }
}
