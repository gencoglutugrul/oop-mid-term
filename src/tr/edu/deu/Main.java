package tr.edu.deu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

/**
 * Tuğrul Gençoğlu
 * 2019280030
 *
 * openjdk version "1.8.0_292" kullanılarak derlenmiştir.
 */
public class Main {
    private static final String FileName = "sinema.txt";

    public static void main(String[] args) {
        ArrayList<Gosterim> gosterimler = new ArrayList<Gosterim>();
        ArrayList<Koltuk> koltuklar = new ArrayList<Koltuk>();

        try{
            Scanner fileScanner = new Scanner(new File(FileName));

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] values = line.split(",");

                if(values.length != 4)
                    continue;

                int salonNo = parseInt(values[0]);
                int siraNo = parseInt(values[1]);
                int koltukNo = parseInt(values[2]);
                boolean bosMu = values[3].equals("boş");

                koltuklar.add(new Koltuk(siraNo, salonNo,koltukNo, bosMu));
            }
        }catch (FileNotFoundException exception){
            try {
                File myObj = new File(FileName);
                myObj.createNewFile();
            } catch (IOException e) {
                System.out.println("Dosya oluşturmak için gerekli izinler yok!");
                System.out.println("Programdan çıkılıyor...");
                System.exit(-1);
            }

            System.out.println("sinema.txt dosyası bulunamadığı için otomatik olarak oluşturuldu.");
        }


        /**
         * Örnek olarak bir kaç gösterimi elle ekledim
         * Dosyada 3 nolu salona ait koltuk olursa onlar da otomatik olarak
         * burada filitrelenip ilgili gösterime eklenecek.
         * Olmaması ihtimaline karşı ben elle koltuk da ekledim.
         */
        ArrayList<Koltuk> salon3Koltuklari = new ArrayList<Koltuk>();
        for (int i = 0; i < 5; i++) {
            Koltuk koltuk = new Koltuk(i/2,3, i,true);
            koltuklar.add(koltuk);
        }

        for (int i = 0; i <koltuklar.size() ; i++) {
            if(koltuklar.get(i).getSalonNo() == 3){
                salon3Koltuklari.add(koltuklar.get(i));
            }   
        }
        gosterimler.add(new Gosterim("Stalker - Andrei Tarkovsky", "5. Seans", "20.11.2022", 3,
                salon3Koltuklari));

        Scanner scanner = new Scanner(System.in);

        String islemler = "0 - Bilet Al\n" +
                "1 - Gösterim Ekle\n" +
                "2 - Koltuk Ekle\n"
                +"q - Cikis\n";

        while(true){
            System.out.println(islemler);

            System.out.print("Lutfen yapmak istediginiz islemi secin : ");

            String islem = scanner.nextLine();

            if(islem.equals("0")){
                for (int i = 0; i < gosterimler.size(); i++) {
                    System.out.println(i + " - " + gosterimler.get(i).getFilmAdi());
                }

                System.out.println("Lutfen bilet almak istediginiz gosterimi seciniz:");
                int gosterimSecim = parseInt(scanner.nextLine());
                if (gosterimSecim >= gosterimler.size() || gosterimSecim < 0) {
                    System.out.println("Gecerli bir gosterim secmediniz!");
                    continue;
                }
                Gosterim secilenGosterim = gosterimler.get(gosterimSecim);
                ArrayList<Koltuk> secilenKoltuklar = new ArrayList<Koltuk>();
                while(true) {
                    int bosKoltuk = 0;
                    for (int i = 0; i < secilenGosterim.getKoltuklar().size(); i++) {
                        if (!secilenGosterim.getKoltuklar().get(i).bosMu())
                            continue;
                        bosKoltuk++;
                        System.out.println(i + " - Koltuk No: " + secilenGosterim.getKoltuklar().get(i).getKoltukNo() + " Salon No: "
                                + secilenGosterim.getKoltuklar().get(i).getSalonNo());
                    }

                    if (bosKoltuk == 0) {
                        System.out.println("Maalesef hic bos koltuk kalmadi!");
                        continue;
                    }

                    System.out.println("Lutfen koltuk seciniz: ");
                    int koltukSecim = parseInt(scanner.nextLine());

                    if (koltukSecim >= secilenGosterim.getKoltuklar().size() || koltukSecim < 0) {
                        System.out.println("Gecerli bir koltuk secmediniz!");
                        continue;
                    }
                    koltuklar.get(koltukSecim).yerAyir();
                    secilenKoltuklar.add(koltuklar.get(koltukSecim));
                    System.out.println("Baska bir koltuk almak ister misiniz? y/n :");
                    String cevap = scanner.nextLine();
                    if(cevap.trim().equals("n"))
                        break;
                }
                System.out.println("Lutfen fiyat giriniz: ");
                float fiyat = parseFloat(scanner.nextLine());

                System.out.println("Lutfen isim giriniz: ");
                String isim = scanner.nextLine();

                System.out.println("Lutfen soyisim giriniz: ");
                String soyisim = scanner.nextLine();

                System.out.println("Lutfen TC No giriniz: ");
                String tcNo = scanner.nextLine();

                System.out.println("1 - Normal Bilet");
                System.out.println("2 - İndirimli Bilet");
                System.out.println("Lutfen bilet türünü giriniz: ");
                int biletTuru = parseInt(scanner.nextLine());
                Bilet bilet;
                if (biletTuru == 1) {
                    bilet = new Bilet(fiyat, secilenGosterim, secilenKoltuklar, isim, soyisim, tcNo);
                } else {
                    System.out.println("Lutfen indirim kodunuzu giriniz: ");
                    String indirimKodu = scanner.nextLine();

                    System.out.println("Lutfen indirim miktarini giriniz: ");
                    float indirimMiktari = parseFloat(scanner.nextLine());

                    bilet = new IndirimliBilet(indirimKodu, indirimMiktari, fiyat, secilenGosterim, secilenKoltuklar, isim, soyisim, tcNo);
                }

                System.out.println("Lutfen bekleyin biletiniz yazdiriliyor...\n\n");

                bilet.bilgiYazdir();
                System.out.println("\n");

            }else if(islem.equals("1")){
                System.out.print("Lütfen gösterim adını giriniz: ");
                String isim = scanner.nextLine();

                System.out.print("Lütfen seansı giriniz: ");
                String seans = scanner.nextLine();

                System.out.print("Lütfen tarihi giriniz: ");
                String tarih = scanner.nextLine();

                System.out.print("Lütfen salon no giriniz: ");
                int salonNo =  parseInt(scanner.nextLine());
                gosterimler.add(new Gosterim(isim, seans, tarih, salonNo, koltuklar));
            }else if(islem.equals("2")){
                System.out.print("Lütfen sıra no giriniz: ");
                int siraNo = parseInt(scanner.nextLine());

                System.out.print("Lütfen salon no giriniz: ");
                int salonNo = parseInt(scanner.nextLine());

                System.out.print("Lütfen koltuk no giriniz: ");
                int koltukNo = parseInt(scanner.nextLine());

                koltuklar.add(new Koltuk(siraNo, siraNo, koltukNo, true));
            }else if(islem.equals("q")){
                System.out.println("Basariyla cikis yaptiniz!");
                break;
            }else{
                System.out.println("Yanlis bir secim yaptiniz lutfen yalnizca menude gosterilen seceneklerden birini giriniz!");
            }
        }
    }
}
