import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Inisialisasi 8 Menu (4 Makanan, 4 Minuman)
        Menu[] daftarMenu = new Menu[8];
        daftarMenu[0] = new Menu("Nasi Goreng", 25000, "Makanan");
        daftarMenu[1] = new Menu("Mie Goreng", 22000, "Makanan");
        daftarMenu[2] = new Menu("Sate Ayam", 30000, "Makanan");
        daftarMenu[3] = new Menu("Soto Ayam", 20000, "Makanan");
        daftarMenu[4] = new Menu("Es Teh", 8000, "Minuman");
        daftarMenu[5] = new Menu("Es Jeruk", 10000, "Minuman");
        daftarMenu[6] = new Menu("Kopi Hitam", 12000, "Minuman");
        daftarMenu[7] = new Menu("Teh Tarik", 15000, "Minuman");

        Scanner scanner = new Scanner(System.in);

        // Menampilkan Menu secara manual (Tanpa Perulangan/Loop)[cite: 1]
        System.out.println("=== DAFTAR MENU RESTORAN ===");
        System.out.println("MAKANAN:");
        System.out.println("0. " + daftarMenu[0].nama + " - Rp" + daftarMenu[0].harga);
        System.out.println("1. " + daftarMenu[1].nama + " - Rp" + daftarMenu[1].harga);
        System.out.println("2. " + daftarMenu[2].nama + " - Rp" + daftarMenu[2].harga);
        System.out.println("3. " + daftarMenu[3].nama + " - Rp" + daftarMenu[3].harga);
        System.out.println("MINUMAN:");
        System.out.println("4. " + daftarMenu[4].nama + " - Rp" + daftarMenu[4].harga);
        System.out.println("5. " + daftarMenu[5].nama + " - Rp" + daftarMenu[5].harga);
        System.out.println("6. " + daftarMenu[6].nama + " - Rp" + daftarMenu[6].harga);
        System.out.println("7. " + daftarMenu[7].nama + " - Rp" + daftarMenu[7].harga);

        // Input Pesanan (Maksimal 4 menu)[cite: 1]
        System.out.println("\n--- Masukkan Nomor Menu Pesanan ---");
        System.out.print("Pesanan 1: "); int p1 = scanner.nextInt();
        System.out.print("Pesanan 2: "); int p2 = scanner.nextInt();
        System.out.print("Pesanan 3: "); int p3 = scanner.nextInt();
        System.out.print("Pesanan 4: "); int p4 = scanner.nextInt();

        // Perhitungan Total Awal[cite: 1]
        double totalAwal = daftarMenu[p1].harga + daftarMenu[p2].harga + daftarMenu[p3].harga + daftarMenu[p4].harga;
        
        // Pajak 10% dan Biaya Pelayanan Rp 20.000[cite: 1]
        double pajak = totalAwal * 0.10;
        double biayaPelayanan = 20000;
        double totalKeseluruhan = totalAwal + pajak + biayaPelayanan;

        // Logika Diskon 10% jika Total > Rp 100.000[cite: 1]
        double diskon = 0;
        if (totalKeseluruhan > 100000) {
            diskon = totalKeseluruhan * 0.10;
        }

        // Logika Promo Beli 1 Gratis 1 Minuman jika Total > Rp 50.000[cite: 1]
        String infoPromo = "Tidak Ada";
        if (totalAwal > 50000) {
            if (p1 >= 4 || p2 >= 4 || p3 >= 4 || p4 >= 4) {
                infoPromo = "Mendapat Gratis 1 Minuman";
            }
        }

        // Mencetak Struk Pesanan[cite: 1]
        System.out.println("\n========== STRUK PEMBAYARAN ==========");
        System.out.println("1. " + daftarMenu[p1].nama + " \t: Rp" + daftarMenu[p1].harga);
        System.out.println("2. " + daftarMenu[p2].nama + " \t: Rp" + daftarMenu[p2].harga);
        System.out.println("3. " + daftarMenu[p3].nama + " \t: Rp" + daftarMenu[p3].harga);
        System.out.println("4. " + daftarMenu[p4].nama + " \t: Rp" + daftarMenu[p4].harga);
        System.out.println("--------------------------------------");
        System.out.println("Total Harga Menu : Rp" + totalAwal);
        System.out.println("Pajak (10%)      : Rp" + pajak);
        System.out.println("Biaya Pelayanan  : Rp" + biayaPelayanan);
        if (diskon > 0) {
            System.out.println("Diskon (10%)     : -Rp" + diskon);
        }
        System.out.println("Promo            : " + infoPromo);
        System.out.println("--------------------------------------");
        System.out.println("TOTAL AKHIR      : Rp" + (totalKeseluruhan - diskon));
        System.out.println("======================================");
        
        scanner.close();
    }
}