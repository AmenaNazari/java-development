package com.pluralsight;

public class MathApp {
    public static void main(String[] args) {

        double bobSalary = 45000.50;
        double garySalary = 47000.75;
        double highestSalary = Math.max(bobSalary, garySalary);
        System.out.println(" The  highest salary is "+ highestSalary);


double carPrice =12000;
double truckPrice= 45000;
double minPrice = Math.min(carPrice,truckPrice);
System.out.print("the smallest price is " +minPrice);
System.out.println();


double radius = 7.25;
double area = Math.PI* radius * radius;
System.out.print("The area of circle is "+ area);
System.out.println();

double number = 5.0;
double squireRoot =Math.sqrt(number);
System.out.print("the squire  root is " + squireRoot);
System .out.println();

int x1=5,y1=10,x2=85, y2=50;
double distance = Math.sqrt(Math.pow(x2-x1,2))+(Math.pow(y2-y1,2));
System.out.println("the distance between to line is " + distance);
System.out.println();

double NegativeValue= -3.8;
        double positiveValue = Math.abs(NegativeValue);
        System.out.println("the positive value of -3.8 is " +positiveValue);
        System.out.println();

        double randomValue = Math.random();

        System.out.println("Question 7: Random Number");
        System.out.println("The random number is: " + randomValue);

















    }
}
