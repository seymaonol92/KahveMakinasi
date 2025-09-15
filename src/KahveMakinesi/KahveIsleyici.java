package KahveMakinesi;

import java.util.Scanner;

public class KahveIsleyici implements ISeker, ISut {

    private final Scanner scanner;  //constructor'da set edildikten sonra değişmemesini sağlıyor. tek elden scanner bu

    private boolean sutVar;   // bu ekip de sipariş özeti gibi, ihtyiaç halinde çağrılacak buradan
    private boolean sekerVar;
    private int sekerAdedi;

    public KahveIsleyici(Scanner scanner){    // bu scanner'ı main'den alacak. hata almıştım, scanner null kalmaz hatasını bunu yaparak çözdüm
        this.scanner = scanner;
    }

    @Override
    public void sutEkle() {
        sutOlsunMu();
    }


    @Override
    public boolean sutOlsunMu() {
        while (true) {
            System.out.print("Süt eklemek ister misiniz? evet/hayır: ");
            String cevap = scanner.nextLine().trim().toLowerCase();
            switch (cevap) {
                case "evet" -> {
                    sutVar = true;
                    System.out.println("Süt ekleniyor...");
                    return true;
                }
                case "hayır"-> {
                    sutVar = false;
                    System.out.println("Kahveniz sütsüz hazırlanıyor...");
                    return false;
                }
                default -> System.out.println("Geçersiz seçim. Lütfen evet/hayır girin!");
            }
        }
    }

    public int kacSeker() {
        int adet;
        while (true) {
            System.out.print("Kaç şeker istersiniz? (0-5): ");
            if (scanner.hasNextInt()) {  // gerçekten sayı olup olmadığını kontrol etmesi için
                adet = scanner.nextInt();
                scanner.nextLine(); // bu buffer
                if (adet >= 0 && adet <= 5) {
                    return adet;
                } else {
                    System.out.println("0 ile 5 arasında sayı girmelisiniz.");
                }
            } else {
                System.out.println("Lütfen sadece sayı girin!");
                scanner.nextLine();
            }
        }
    }

    @Override
    public boolean sekerOlsunMu() {
        while (true) {
            System.out.print("Şeker ister misiniz? evet/hayır: ");
            String cevap = scanner.nextLine().trim().toLowerCase();
            switch (cevap) {
                case "evet" -> {
                    sekerVar = true;
                    sekerAdedi = kacSeker();
                    System.out.println(sekerAdedi + " küp şeker eklenecek.");
                    return true;
                }
                case "hayır" -> {
                    sekerVar = false;
                    sekerAdedi = 0;
                    System.out.println("Kahveniz şekersiz hazırlanıyor...");
                    return false;
                }
                default -> System.out.println("Geçersiz seçim. Lütfen evet/hayır girin!");
            }
        }
    }
 //bunlar getter'lar
    public boolean isSutVar() { return sutVar; }
    public boolean isSekerVar() { return sekerVar; }
    public int getSekerAdedi() { return sekerAdedi; }
    }




