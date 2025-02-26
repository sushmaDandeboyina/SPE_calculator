package com.sushma.calculator;

import java.util.Scanner;

public class Calculator {
    public static double squareRoot(double x) {
        if (x < 0) {
            System.out.println("\n Square root cannot be computed for negative numbers");
            return -1;
        }
        return Math.sqrt(x);
    }

    public static long factorial(int x) {
        if (x < 0) {
            System.out.println("\n Factorial is not defined for negative numbers");
            return -1;
        }
        long result = 1;
        for (int i = 2; i <= x; i++) {
            result *= i;
        }
        return result;
    }

    public static double logarithm(double x, double base) {
        if (x <= 0 || base <= 0 || base == 1) {
            System.out.println("\n Logarithm is undefined for given values");
            return -1;
        }
        return Math.log(x) / Math.log(base);
    }

    public static double powerFunction(double x, double b) {
        return Math.pow(x, b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n==============================");
        System.out.println("      SCIENTIFIC CALCULATOR");
        System.out.println("==============================\n");

        while (true) {
            System.out.println("\n Select an operation:");
            System.out.println("----------------------------");
            System.out.println(" 1)  Square Root");
            System.out.println(" 2)  Factorial");
            System.out.println(" 3)  Logarithm");
            System.out.println(" 4)  Power Function");
            System.out.println(" 5)  Exit");
            System.out.println("----------------------------");
            System.out.print(" Enter your choice: ");

            int choice = scanner.nextInt();

            if (choice == 5) {
                System.out.println("\n Exiting... \n");
                break;
            }

            switch (choice) {
                case 1:
                    System.out.print("\n Enter a number: ");
                    double num1 = scanner.nextDouble();
                    System.out.println("Result: " + squareRoot(num1));
                    break;
                case 2:
                    System.out.print("\n Enter an integer: ");
                    double num2 = scanner.nextDouble();
                    if (num2 != (int) num2) {
                        System.out.println("\n Factorial is only defined for integers!");
                    } else {
                        System.out.println("Result: " + factorial((int) num2));
                    }
                    break;
                case 3:
                    System.out.print("\nEnter the number: ");
                    double num3 = scanner.nextDouble();
                    System.out.print("Enter the base: ");
                    double base = scanner.nextDouble();
                    System.out.println("Result: " + logarithm(num3, base));
                    break;
                case 4:
                    System.out.print("\nEnter the base number: ");
                    double baseNum = scanner.nextDouble();
                    System.out.print("Enter the exponent: ");
                    double exponent = scanner.nextDouble();
                    System.out.println("Result: " + powerFunction(baseNum, exponent));
                    break;
                default:
                    System.out.println("\nInvalid choice! Please select a valid option.");
            }
        }
        scanner.close();
    }
}
