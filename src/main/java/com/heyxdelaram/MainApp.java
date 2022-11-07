package com.heyxdelaram;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class MainApp {
    static Scanner scanner = new Scanner(System.in);
    //initializing variables and arrays
    static int maxNum = 56;
    static int carNum = 0;
    static int exited = 0;
    static double total = 0;
    //car info
    static String[] driverName = new String[maxNum];
    static String[] phoneNum = new String[maxNum];
    static String[] plateNum = new String[maxNum];
    static Boolean[] isOut = new Boolean[maxNum];
    //car info after repairment
    static String[][] serviceTypes = new String[maxNum][];
    static Double[][] prices = new Double[maxNum][];

    public static void main(String[] args) {

        //print welcome + date and time
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("Happy " + dateTime.getDayOfWeek());

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));

        //checks whether currently in working hours or not
        // && dateTime.getHour()< 17
        if (dateTime.getHour() > 8 && dateTime.getHour() < 17) {

            while (true) {
                if (carNum < maxNum) {

                    switch (menu()) {
                        case 1:
                            registerCar();
                            break;
                        case 2:
                            orderStatus();
                            break;
                        case 3:
                            System.out.println("Enter your car number:");
                            int cNum = scanner.nextInt();
                            carStatus(cNum);
                            break;
                        case 4:
                            System.out.println("Enter your car number:");
                            int cNumber = scanner.nextInt();
                            exitCar(cNumber);
                            break;
                        case 0:
                            System.out.println("Goodbye!");
                            return;
                        default:
                            System.out.println("Unavailable request.");
                            break;
                    }

                } else {
                    System.out.println("Capacity is full for today, come back tomorrow.");
                    return;
                }
            }

        } else {
            System.out.println("The program is only available during working hours (8am - 5pm)\nCome back later...");
        }

    }

    public static int menu() {

        System.out.println("\nEnter a number based on your request: ");
        System.out.println("1 - Register a new car");
        System.out.println("2 - Order Status");
        System.out.println("3 - Show car information");
        System.out.println("4 - Exit car");
        System.out.println("0 - Exit from the program");

        return scanner.nextInt();
    }

    public static void registerCar() {

        System.out.println("Driver's Name: ");
        driverName[carNum] = scanner.next();

        System.out.println("Phone Number: ");
        phoneNum[carNum] = scanner.next();

        System.out.println("Plate Number: ");
        plateNum[carNum] = scanner.next();
        //since in this method the car is being registered, it's not leaving yet
        isOut[carNum] = false;

        System.out.println("Your register number is " + carNum);

        carNum++;

    }

    public static void orderStatus() {
        int remain = maxNum - carNum;
        System.out.println("In Service: " + (carNum - exited));
        System.out.println("Serviced : "+ exited);
        System.out.println("Remained : "+ remain);
    }

    public static void carStatus(int carNum) {
        System.out.println("Driver's Name: " + driverName[carNum]);
        System.out.println("Phone Number: " + phoneNum[carNum]);
        System.out.println("Plate Number: " + plateNum[carNum]);
        System.out.println(isOut[carNum] ? "Serviced" : "In Service");
    }

    public static void exitCar(int carNumber) {
        System.out.println("Number of services: ");
        int numOfServices = scanner.nextInt();

        serviceTypes[carNumber] = new String[numOfServices];
        prices[carNumber] = new Double[numOfServices];

        for (int i = 0; i < numOfServices; i++) {
            System.out.println("Service Type: ");
            serviceTypes[carNumber][i] = scanner.next();

            System.out.println("Service Price: ");
            prices[carNumber][i] = scanner.nextDouble();

            total += prices[carNumber][i];
        }

        System.out.println("Services done for your car: ");
        for (int i = 0; i < numOfServices; i++) {
            System.out.println(serviceTypes[carNumber][i] + ": " + prices[carNumber][i]);
        }
        System.out.println("Total amount: " + total);
        isOut[carNumber] = true;
        exited++;
    }

}
