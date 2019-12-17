package by.it.ban.jd01_02;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] mas=new int [10];
        for (int i = 0; i < 10; i++) {
            mas[i] = sc.nextInt();
        }
        step1(mas);
        step2(mas);
        step3(mas);

    }

    static void step1(int[] mas) {
        int min = mas[0];
        int max = mas[0];
        for (int i = 1; i < mas.length; i++) {
            if (mas[i] < min) {
                min = mas[i];
            }
            if (mas[i] > max) {
                max = mas[i];
            }

        }
        System.out.println(min + " " + max);

    }

    ;

    private static void step2(int[] mas) {
        int sum = 0;
        for (int i = 0; i < mas.length; i++) {
            sum += mas[i];
        }
        double sar = sum / 10;
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] < sar) {
                System.out.print(mas[i] + " ");
            }
        }
        System.out.println();
    }

    ;

    private static void step3(int[] mas) {
        int min = mas[0];
        for (int i = 1; i < mas.length; i++) {
            if (mas[i] < min) min = mas[i];
        }
        for (int i = mas.length - 1; i >= 0; i--) {
            if (mas[i] == min) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    ;
}
