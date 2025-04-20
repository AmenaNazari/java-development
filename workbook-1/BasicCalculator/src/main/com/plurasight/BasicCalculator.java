package com.plurasight;
import java.util.*;


public class BasicCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("enter the first number");
        double num1 = input.nextDouble();

        System.out.print("enter the second number");
        double num2 = input.nextDouble();

        System.out.println("Possible calculations:");
        System.out.print("(A)dd");
        System.out.print("(S)ubtract");
        System.out.print("(M)ultiply");
        System.out.print("(D)ivide");

        System.out.print("Please select an option");
        char operation = Character.toUpperCase(input.next().charAt(0));

        if (operation == 'A') {
            double result = num1 + num2;
            System.out.println("the result of num1+num2 = " + result);

        } else if (operation == 'S') {
        double result = num1 - num2;
        System.out.println("the result of num1-num2 = " + result);
    }
        else if (operation == 'M') {
            double result = num1 * num2;
            System.out.println("the result of numb1*num2 = " + result);
        }

        else if (operation =='D') {
            double result = num1 / num2;
            System.out.println(" the result of the num1%num2 = " + result);

            }else
                System.out.println("Invalid operation.");
        }


        }








