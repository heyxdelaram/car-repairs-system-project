package com.heyxdelaram;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int carCount = 0;
        Scanner scanner = new Scanner(System.in);

        //welcome + date message
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("\nWelcome!");
        System.out.println("Today is " + dateTime.getDayOfWeek());
        while (true) {


            //exit option
            System.out.println("To continue - 1 \nTo exit - 0");
            int exit = scanner.nextInt();
            if (exit == 1) {

                // && dateTime.getHour() < 17
                if (dateTime.getHour() > 8) {

                    if (carCount < 56) {

                        //car entering phase
                        System.out.println("Driver's Name: ");
                        String driverName = scanner.next();

                        System.out.println("Phone Number: ");
                        String phoneNum = scanner.next();

                        System.out.println("Plate Number: ");
                        String plateNum = scanner.next();

                        carCount++;

                        //car exiting phase
                        System.out.println("Number of services: ");
                        int numOfServices = scanner.nextInt();

                        String[] service = new String[numOfServices];
                        double[] price = new double[numOfServices];
                        double total = 0;

                        for (int i = 0; i < numOfServices; i++) {
                            System.out.println("Service Type: ");
                            service[i] = scanner.next();

                            System.out.println("Service Price: ");
                            price[i] = scanner.nextDouble();

                            total += price[i];
                        }

                        System.out.println("Services done for your car: ");
                        for (int i = 0; i < service.length; i++) {
                            System.out.println(service[i] + ": " + price[i]);
                        }
                        System.out.println("Total amount: " + total);

                        //to empty the arrays for the next order
                        Arrays.fill(service, null);
                        Arrays.fill(price, 0);
                        System.out.println("Thank you. Would you like to know the order statuses?");
                        String statAns = scanner.next();

                        if (statAns.equals("yes")){
                            getOrderStatus(carCount);
                        }

                    } else {
                        System.out.println("Capacity full for today, come back tomorrow.");
                        return;
                    }

                } else {
                    System.out.println("The system will only be available in working hours.");
                    return;
                }

            }else{
                System.out.println("Have a nice day!");
                return;
            }
        }
    }

    public static void getOrderStatus(int carCount){
        System.out.println("Orders till now: " + carCount);
        System.out.println("Remaining capacity: " + (56 - carCount));
    }
}