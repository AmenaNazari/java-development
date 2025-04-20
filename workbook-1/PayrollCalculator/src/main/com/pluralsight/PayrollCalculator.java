package com.pluralsight;
import java.util.Scanner;
public class PayrollCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter you name");
        String Name = scanner.nextLine();

        System.out.print("Enter your working hours");
        double WorkingHours = scanner.nextDouble();

        System.out.print("Enter pay rate");
        double PayRate = scanner.nextDouble();

        double GrossPay = WorkingHours * PayRate;

        System.out.println("\nPayroll Summary");
        System.out. print ("\n Name " + Name);

        System.out .print ("\n Gross pay is "+ GrossPay);

        System.out.print("\n The gross pay of "  +Name+" is " +GrossPay);


    }
}
