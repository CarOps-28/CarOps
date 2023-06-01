package com.carops;

import java.util.Scanner;

public class Processes {

    public static Vehicle vehicleCreationProcess(int code, Object object) {
        // GUI Input fields
        Scanner in = new Scanner(System.in);

        System.out.println("Vehicle plateNumber: ");
        String vehiclePlateNumber = in.nextLine();

        System.out.println("Vehicle brand: ");
        String vehicleBrand = in.nextLine();

        System.out.println("Vehicle model: ");
        String vehicleModel = in.nextLine();

        System.out.println("Vehicle Prod Year: ");
        int vehicleProdYear = in.nextInt();

        System.out.println("Vehicle vehicleType (Vehicle - Truck - Motorcycle)");
        String vehicleType = in.nextLine();

        float typeValue = -1;
        if (vehicleType.equalsIgnoreCase("Truck")) {
            typeValue = in.nextFloat();
        } else if (vehicleType.equalsIgnoreCase("Motorcycle")) {
            typeValue = in.nextFloat();
        }

        // Secretary
        if (code == 1) {
            Secretary secretary = (Secretary) object;
            return secretary.createVehicle(vehiclePlateNumber, vehicleBrand, vehicleModel, vehicleProdYear, vehicleType,
                    typeValue);
        }

        ReceptionEngineer receptionEngineer = (ReceptionEngineer) object;
        return receptionEngineer.createVehicle(vehiclePlateNumber, vehicleBrand, vehicleModel, vehicleProdYear,
                vehicleType, typeValue);
    }

    public static Customer customerCreationProcess(Object object) {
        // GUI Input fields
        Scanner in = new Scanner(System.in);

        System.out.println("Customer name: ");
        String customerName = in.nextLine();

        System.out.println("Customer surname: ");
        String customerSurname = in.nextLine();

        System.out.println("Customer phone number: ");
        String customerPhoneNumber = in.nextLine();

        System.out.println("Customer email: ");
        String customerEmail = in.nextLine();

        System.out.println("Customer address: ");
        String customerAddress = in.nextLine();

        // Secretary
        Secretary secretary = (Secretary) object;
        return secretary.createCustomer(customerName, customerSurname, customerPhoneNumber, customerEmail,
                customerAddress);

    }

    public static int options(int code) {
        // secretary print code 1
        Scanner inputCode = new Scanner(System.in);
        if (code == 1) {
            System.out.println("Create appointment - 1");
            System.out.println("Create vehicle - 2");
            System.out.println("Create customer - 3");
            System.out.println("Change repairfile status - 4");
            System.out.println("Print repairfile  - 5");
            System.out.println("Exit - 0");
            System.out.println("your choice: ");
            return inputCode.nextInt();
        } else if (code == 2) { // Reception
            System.out.println("Create Repairfile - 1");
            System.out.println("Exit - 0");
            System.out.println("your choice: ");
            return inputCode.nextInt();
        }else if (code == 3){ // Supervisor
            System.out.println("create Assignments - 1");
            System.out.println("Exit - 0");
            System.out.println("your choice: ");
            return inputCode.nextInt();
        }
        return 0;
    }

}
