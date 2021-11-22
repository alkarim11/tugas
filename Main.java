package com.company;

import java.util.Scanner;

public class Main {
    public static void main (String[] args) {

        Scanner in = new Scanner(System.in);

        while(true) {
            System.out.println("Masuk ke Sistem Parkir? y/n");
            String masuk = in.nextLine();

            if (masuk.equals("y")) {
                new Program1();
            }
            if (masuk.equals("n")) {
                break;
            }
        }
    }
}