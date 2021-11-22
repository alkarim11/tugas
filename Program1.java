package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.time.*;

public class Program1 {

    File newFile;
    FileWriter tulis;

    Scanner in = new Scanner(System.in);

    Random random = new Random();

    ArrayList<String> jenisKendaraan;
    ArrayList<Integer> listKode;
    ArrayList<LocalTime> dataTanggal;
    ArrayList<Duration> lamaParkir;

    public Program1() {

        this.newFile = new File("Karcis.txt");

        LocalTime sekarang = LocalTime.now();
        LocalTime nanti = sekarang.plusHours(2);
        Duration durasi = Duration.between(sekarang, nanti);

        this.dataTanggal = new ArrayList<>();
        this.dataTanggal.add(0, sekarang);
        this.dataTanggal.add(1, nanti);

        this.lamaParkir = new ArrayList<>();
        this.lamaParkir.add(0, durasi);

        this.jenisKendaraan = new ArrayList<>();
        System.out.print("Jenis Kendaraan : ");
        this.jenisKendaraan.add(0, in.nextLine());

        this.listKode = new ArrayList<>();
        this.listKode.add(0, random.nextInt(99999));

        inputDataJenisKendaraan();
    }

    public String inputDataJenisKendaraan() {
        System.out.println("Jenis Kendaraan : " + this.jenisKendaraan.get(0));
        if (this.jenisKendaraan.get(0).isEmpty()) {
            System.out.println("Harap Isi Jenis Kendaraan dengan Ketentuan Jenis Kendaraan diBawah ini");
            System.out.println("1. Sepeda Motor");
            System.out.println("2. Mobil");
            System.out.println("3. Buss");
            System.out.println("Perhatikan Pemakaian Huruf Kapital");
            System.out.println("\n");
            return (this.jenisKendaraan.get(0));
        }
        inputDataTanggal();
        return null;
    }

    public void inputDataTanggal() {
        System.out.println("Waktu Parkir    : " + this.dataTanggal.get(0));

        inputDataKodeParkir();
    }

    public void inputDataKodeParkir() {
        System.out.println("Kode Parkir     : " + this.listKode.get(0));

        program2();
    }

    public Integer program2() {
        System.out.print("Masukkan Kode   : ");
        int kode = in.nextInt();
        if (kode != this.listKode.get(0)) {
            System.out.println("Error : Tidak Menemukan Kode!!");
            System.out.println("\n");
            return kode;
        }
        System.out.println("Waktu Keluar    : " + this.dataTanggal.get(1));

        lamaParkir();

        return null;
    }

    public void lamaParkir() {
        System.out.println("Lama Parkir     : " + this.lamaParkir.get(0) + " jam");

        cetakTotalBayar();
    }

    public void cetakTotalBayar() {
        if (this.jenisKendaraan.get(0).equals("Sepeda Motor")) {
            int totalBayar = (int) this.lamaParkir.get(0).toHours() * 2000;
            System.out.println("Pembayaran Untuk Sepeda Motor : " + totalBayar);
        }
        if (this.jenisKendaraan.get(0).equals(("Mobil"))) {
            int totalBayar = (int) this.lamaParkir.get(0).toHours() * 3000;
            System.out.println("Pembayaran Untuk Mobil        : " + totalBayar);
        }
        if (this.jenisKendaraan.get(0).equals(("Buss"))) {
            int totalBayar = (int) this.lamaParkir.get(0).toHours() * 6000;
            System.out.println("Pembayaran Untuk Buss         : " + totalBayar);
        }
        System.out.println("Terima Kasih");
        System.out.println("\n");

        cetakKarcis();
    }

    public void cetakKarcis() {
        this.newFile = new File("Cetak Karcis.txt");
        try {
            boolean create = newFile.createNewFile();
        } catch (IOException ignore) {
        }

        try {
            this.tulis = new FileWriter(newFile, true);
            tulis.write("Kode Parkir         : " + this.listKode.get(0) + "\n");
            tulis.write("Jenis Kendaraan     : " + this.jenisKendaraan.get(0) + "\n");
            tulis.write("Waktu Masuk Parkir  : " + this.dataTanggal.get(0) + "\n");
            tulis.write("Waktu Keluar Parkir : " + this.dataTanggal.get(1) + "\n");
            tulis.write("Lama Parkir         : " + this.lamaParkir.get(0) + "\n");

            if (this.jenisKendaraan.get(0).equals("Sepeda Motor") || this.jenisKendaraan.get(0).equals("Motor")) {
                int totalBayar = (int) this.lamaParkir.get(0).toHours() * 2000;
                tulis.write("Total Pembayaran    : " + totalBayar + "\n");
            }
            if (this.jenisKendaraan.get(0).equals(("Mobil"))) {
                int totalBayar = (int) this.lamaParkir.get(0).toHours() * 3000;
                tulis.write("Total Pembayaran    : " + totalBayar + "\n");
            }
            if (this.jenisKendaraan.get(0).equals(("Buss"))) {
                int totalBayar = (int) this.lamaParkir.get(0).toHours() * 6000;
                tulis.write("Total Pembayaran    : " + totalBayar + "\n");
            }

            tulis.write("Terima Kasih\n");
            tulis.write("\n");
            tulis.close();
        } catch (IOException ignore) {
        }

        tampilkanIsiKarcis();
    }

    void tampilkanIsiKarcis() {
        try {
            Scanner scan = new Scanner(newFile);
            while(scan.hasNextLine()) {
                System.out.println(scan.nextLine());
            }
            scan.close();
        } catch (FileNotFoundException exception) {}
    }
}