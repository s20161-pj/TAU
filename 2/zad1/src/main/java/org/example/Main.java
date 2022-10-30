package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Triangle myTriangle = new Triangle();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj a:");
        myTriangle.a = scanner.nextDouble();

        System.out.println("Podaj b:");
        myTriangle.b = scanner.nextDouble();

        System.out.println("Podaj c:");
        myTriangle.c = scanner.nextDouble();


        System.out.println("Pole to: ");
        System.out.print(myTriangle.area());
    }
}
