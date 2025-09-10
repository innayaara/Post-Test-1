/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.myc.main;

/**
 *
 * @author Asus TUF
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ArrayList untuk menyimpan data koleksi
        ArrayList<String> namaAlat = new ArrayList<>();
        ArrayList<String> jenisAlat = new ArrayList<>();
        ArrayList<String> merkAlat = new ArrayList<>();
        ArrayList<Integer> jumlahAlat = new ArrayList<>();

        int pilihan;

        do {
            System.out.println("\n=== Menu Koleksi Alat Makeup ===");
            System.out.println("1. Tambah Koleksi");
            System.out.println("2. Lihat Koleksi");
            System.out.println("3. Ubah Koleksi");
            System.out.println("4. Hapus Koleksi");
            System.out.println("5. Keluar");
            System.out.println("===============================");
            System.out.print("Pilih menu: ");
            pilihan = Integer.parseInt(sc.nextLine()); // input menu

            switch (pilihan) {
                case 1:
                    // Tambah data
                    String nama, jenis, merk;
                    int jumlah;

                    // Validasi nama
                    do {
                        System.out.print("Masukkan Nama Alat Makeup: ");
                        nama = sc.nextLine().trim();
                        if (nama.isEmpty()) {
                            System.out.println("Nama tidak boleh kosong!");
                        }
                    } while (nama.isEmpty());

                    // Validasi jenis
                    do {
                        System.out.print("Masukkan Jenis Alat Makeup: ");
                        jenis = sc.nextLine().trim();
                        if (jenis.isEmpty()) {
                            System.out.println("Jenis tidak boleh kosong!");
                        }
                    } while (jenis.isEmpty());

                    // Validasi merk
                    do {
                        System.out.print("Masukkan Merk: ");
                        merk = sc.nextLine().trim();
                        if (merk.isEmpty()) {
                            System.out.println("Merk tidak boleh kosong!");
                        }
                    } while (merk.isEmpty());

                    // Validasi jumlah
                    do {
                        System.out.print("Masukkan Jumlah Alat Makeup: ");
                        String inputJumlah = sc.nextLine();
                        if (inputJumlah.matches("\\d+")) { // operator logika + regex
                            jumlah = Integer.parseInt(inputJumlah);
                        } else {
                            jumlah = -1;
                            System.out.println("Jumlah harus angka positif!");
                        }
                    } while (jumlah <= 0);

                    // Simpan ke ArrayList
                    namaAlat.add(nama);
                    jenisAlat.add(jenis);
                    merkAlat.add(merk);
                    jumlahAlat.add(jumlah);

                    System.out.println("Koleksi berhasil ditambahkan!");
                    break;

                case 2:
                    // Lihat data
                    if (namaAlat.isEmpty()) {
                        System.out.println("Koleksi masih kosong!");
                    } else {
                        System.out.println("\n=== Daftar Koleksi Alat Makeup ===");
                        int total = 0;
                        for (int i = 0; i < namaAlat.size(); i++) {
                            System.out.println((i+1) + ". " +
                                "Nama: " + namaAlat.get(i) +
                                " | Jenis: " + jenisAlat.get(i) +
                                " | Merk: " + merkAlat.get(i) +
                                " | Jumlah: " + jumlahAlat.get(i));
                            total += jumlahAlat.get(i); // operator aritmatika
                        }
                        System.out.println("Total semua alat: " + total);
                    }
                    break;

                case 3:
                    // Ubah data
                    System.out.print("Masukkan nomor koleksi yang mau diubah: ");
                    int ubah = Integer.parseInt(sc.nextLine());
                    if (ubah > 0 && ubah <= namaAlat.size()) {
                        System.out.print("Nama baru: ");
                        namaAlat.set(ubah-1, sc.nextLine());
                        System.out.print("Jenis baru: ");
                        jenisAlat.set(ubah-1, sc.nextLine());
                        System.out.print("Merk baru: ");
                        merkAlat.set(ubah-1, sc.nextLine());
                        System.out.print("Jumlah baru: ");
                        jumlahAlat.set(ubah-1, Integer.parseInt(sc.nextLine()));
                        System.out.println("Koleksi berhasil diubah!");
                    } else {
                        System.out.println("Nomor tidak valid!");
                    }
                    break;

                case 4:
                    // Hapus data
                    System.out.print("Masukkan nomor koleksi yang mau dihapus: ");
                    int hapus = Integer.parseInt(sc.nextLine());
                    if (hapus > 0 && hapus <= namaAlat.size()) {
                        namaAlat.remove(hapus-1);
                        jenisAlat.remove(hapus-1);
                        merkAlat.remove(hapus-1);
                        jumlahAlat.remove(hapus-1);
                        System.out.println("Koleksi berhasil dihapus!");
                    } else {
                        System.out.println("Nomor tidak valid!");
                    }
                    break;

                case 5:
                    System.out.println("Terima kasih, program selesai!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }

        } while (pilihan != 5);

        sc.close();
    }
}


