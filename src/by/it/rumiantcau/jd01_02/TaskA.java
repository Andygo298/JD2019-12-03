package by.it.rumiantcau.jd01_02;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int[] mas=new int[10];
        for (int i = 0; i < mas.length; i++) {
            mas[i]=scanner.nextInt();
        }
        step1(mas);
        step2(mas);
        step3(mas);
    }
        private static void step1(int[ ] mas){
        int min=mas[0];
        int max=mas[0];
            for (int i = 0; i < mas.length; i++) {
                if (min>mas[i])
                {min = mas[i];}
                if (max<mas[i])
                {max = mas[i];}
                
            }
            System.out.print(min+" "+max);
            System.out.println();

        }
        private static void step2(int[ ] mas){
        double middleSum = 0;
            for (int i = 0; i < mas.length; i++) middleSum = middleSum + mas[i];
            middleSum = middleSum/(mas.length+1);

            for (int i = 0; i < mas.length; i++) {
                if (mas[i]<middleSum) {
                    System.out.print(mas[i]+" ");

                }
            }
            System.out.println();
        }
        private static void step3(int[ ] mas){
        int min=mas[0];
        int max=mas[0];
            for (int element: mas) {
                if(min>element) min = element;
                 }
//
//            for (int i = 0; i < mas.length; i++) {
//                if (min>mas[i]) min=mas[i];
//            }

            for (int i = mas.length-1; i >= 0; i--) {
                if (mas[i]==min) {
                    System.out.print(i+" ");
                }
            }
            System.out.println();
        }

}
