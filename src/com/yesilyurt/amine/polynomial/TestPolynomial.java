package com.yesilyurt.amine.polynomial;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * HW09_131044004 Definition: This class tests the Polynomial class
 *
 * @author Amine Yesilyurt
 */
public class TestPolynomial {

    /**
     * tests all methods of Polynomial class
     *
     * @param args there is no argument
     */
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int sizeOfArray;
        char again;
        do{
        
        //Getting sizeOfArray from user
        do {
            
            System.out.printf("Enter size of first array : ");
            while (!scan.hasNextInt()) {
                System.out.println("Invalid value!");
                scan.next();
            }
            sizeOfArray = scan.nextInt();
            
        } while (sizeOfArray <= 0);
        
        double[] arr1 = new double[sizeOfArray];
        System.out.println("Enter coefficients for first array : ");
        
        //Getting coefficients from user for arr1
        for (int i = 0; i < arr1.length; i++) {
            
            while (!scan.hasNextDouble()) {
                System.out.println("Invalid value!");
                scan.next();
            }
            arr1[i] = scan.nextDouble();
        }
        
        //Getting another array size from user 
        do {
            System.out.printf("Enter size of second array : ");
            while (!scan.hasNextInt()) {
                System.out.println("Invalid value!");
                scan.next(); // this is important!
            }
            sizeOfArray = scan.nextInt();
        } while (sizeOfArray <= 0);
         
        double[] arr2 = new double[sizeOfArray];
        System.out.println("Enter coefficients for second array : ");
        
        //Getting coefficients from user for arr2
        for (int i = 0; i < arr2.length; i++) {
            while (!scan.hasNextDouble()) {
                System.out.println("Invalid value!");
                scan.next(); 
            }
            arr2[i] = scan.nextDouble();
        }

        Polynomial p1 = new Polynomial(arr1);
        System.out.printf("p1 = %s\n", p1.toString());

        Polynomial p2 = new Polynomial(arr2);
        System.out.printf("p2 = %s\n", p2.toString());

        if (p1.equals(p2)) //testing if polynomials equal
        {
            System.out.printf("p1 = p2  They are equal\n");
        }

        //testing plus method
        System.out.printf("p1 + p2 = %s \n", p1.plus(p2).toString());

        //testing minus method
        System.out.printf("p1 - p2 = %s \n", p1.minus(p2).toString());

        //testing times method
        System.out.printf("p1 * p2 = %s \n", p1.times(p2).toString());
        
        //testing evaluate method
        System.out.printf("p1(2) = %.2f \n", p1.evaluate(2));
        System.out.printf("p2(2)= %.2f \n", p2.evaluate(2));
        
        System.out.printf("\nDo you want to test again(Y/N) ");
        again= scan.next().charAt(0);
        
        }while(again=='y' || again=='Y');
    }
        
}

