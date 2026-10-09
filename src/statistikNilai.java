
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

public class statistikNilai {

    static final int SELESAI = -1;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> daftar = new ArrayList<>();

        System.out.println("===== STATISTIK NILAI KELAS =====");
        System.out.println("Ketik -1 kalau sudah selesai.");

        int nilai;

        do {
            System.out.print("Nilai ke-" + (daftar.size() + 1) + " : ");
            nilai = input.nextInt();

            daftar.add(nilai);

        } while (nilai != SELESAI);


        do {
            System.out.print("Nilai ke-" + (daftar.size() + 1) + " : ");
            nilai = input.nextInt();

            if (nilai == SELESAI) {
                continue;
            }

            if (nilai < 0 || nilai > 100) {
                System.out.println("  Ditolak, harus 0-100");
                continue;
            }

            daftar.add(nilai);

        } while (nilai != SELESAI);


        if (daftar.size() == 0) {
            System.out.println();
            System.out.println("Tidak ada nilai yang dimasukkan.");
            input.close();
            return;
        }

        int total = 0;
        int tertinggi = daftar.get(0);
        int terendah = daftar.get(0);

        int[] jumlahGrade = new int[5];

        for (int x : daftar) {
            total += x;

            if (x > tertinggi) {
                tertinggi = x;
            }

            if (x < terendah) {
                terendah = x;
            }

            if (x >= 90) {
                jumlahGrade[0]++;
            } else if (x >= 80) {
                jumlahGrade[1]++;
            } else if (x >= 70) {
                jumlahGrade[2]++;
            } else if (x >= 60) {
                jumlahGrade[3]++;
            } else {
                jumlahGrade[4]++;
            }
        }

        double rataRata = (double) total / daftar.size();

        int diAtasRataRata = 0;

        for (int x : daftar) {
            if (x > rataRata) {
                diAtasRataRata++;
            }
        }

        input.close();
    }
}