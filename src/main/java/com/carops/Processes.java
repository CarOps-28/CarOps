package com.carops;

import java.util.Scanner;

public class Processes {

    public static Vehicle vehicleCreationProcess(int code, Object object) {
        // GUI Input fields
        Scanner in = new Scanner(System.in);

        String vehiclePlateNumber;

        boolean found = false;
        do{
            found = false;
            System.out.print("Vehicle plateNumber: ");
            vehiclePlateNumber = in.nextLine();
            if(VehicleCatalog.fetchVehicleByPlateNumber(vehiclePlateNumber)!=null){
                System.out.println("Vehicle already exists.");
                found = true;
            }
        }while (found==true);



        System.out.println("\nVehicle has not been registered yet. Provide details:");
        System.out.print("Vehicle brand: ");
        String vehicleBrand = in.nextLine();

        System.out.print("Vehicle model: ");
        String vehicleModel = in.nextLine();

        System.out.print("Vehicle Prod Year: ");
        int vehicleProdYear = in.nextInt();
        in.nextLine();

        System.out.print("VehicleType (Car - Truck - Motorcycle): ");
        String vehicleType = in.nextLine();

        float typeValue = -1;
        if (vehicleType.equalsIgnoreCase("Truck")) {
            System.out.print("Give capacity: ");
            typeValue = in.nextFloat();
        } else if (vehicleType.equalsIgnoreCase("Motorcycle")) {
            System.out.print("Give quantum: ");
            typeValue = in.nextFloat();
        }

        System.out.print("\nVehicle created successfully.");

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

        String customerPhoneNumber;

        boolean found = false;
        do{
            found = false;
            System.out.print("Customer phone number: ");
            customerPhoneNumber = in.nextLine();
            if(CustomerCatalog.fetchCustomerByPhoneNumber(customerPhoneNumber) != null){
                System.out.println("Customer already exists.");
                found = true;
            }
        }while (found == true);

        System.out.println("\nCustomer has not been registered yet. Provide details:");
        System.out.print("Customer name: ");
        String customerName = in.nextLine();

        System.out.print("Customer surname: ");
        String customerSurname = in.nextLine();

        System.out.print("Customer email: ");
        String customerEmail = in.nextLine();

        System.out.print("Customer address: ");
        String customerAddress = in.nextLine();

        System.out.print("\nCustomer created successfully.");

        // Secretary
        Secretary secretary = (Secretary) object;
        return secretary.createCustomer(customerName, customerSurname, customerPhoneNumber, customerEmail,
                customerAddress);

    }

    public static int options(int code) {
        System.out.println();
        if(code == 0) {
            System.out.println("Choose User");
            System.out.println("Owner - 1");
            System.out.println("Secretary - 2");
            System.out.println("Reception Engineer - 3");
            System.out.println("Supervisor Engineer - 4");
            System.out.println("Engineer - 5");
            System.out.println("Exit - 0");
            return  checkInputData(0 ,5);
        }
        else if (code == 1) {
            System.out.println("Create appointment - 1");
            System.out.println("Create vehicle - 2");
            System.out.println("Create customer - 3");
            System.out.println("Change repairfile status based on customer decision - 4");
            System.out.println("Print repairfile  - 5");
            System.out.println("Show Appointments - 6");
            System.out.println("Update Appointment - 7");
            System.out.println("Exit - 0");
            return checkInputData(0 ,7);
        } else if (code == 2) { // Reception
            System.out.println("Create Repairfile - 1");
            System.out.println("Exit - 0");
            return checkInputData(0 ,1);
        }else if (code == 3){ // Supervisor
            System.out.println("Create Assignments - 1");
            System.out.println("Set Repairfile status - 2");
            System.out.println("Exit - 0");
            return checkInputData(0 ,2);
        }else if (code == 4){ // Engineer
            System.out.println("Show assignments - 1");
            System.out.println("Add spareParts and work time on completed assignment - 2");
            System.out.println("Exit - 0");
            return checkInputData(0 ,2);
        }else if (code == 5) {
            System.out.println("Change Engineer Role - 1");
            System.out.println("Exit - 0");
            return checkInputData(0 ,1);
        }
        return 0;
    }

    public static int checkInputData(int startInt, int endInt){
        int number;
        Scanner inputCode = new Scanner(System.in);
        do{
            System.out.print("your choice: ");
            number = inputCode.nextInt();
        }while(number < startInt || number > endInt);
        return number;
    }

}
