package com.carops;

import com.catalogs.CustomerCatalog;
import com.catalogs.EngineerCatalog;
import com.catalogs.VehicleCatalog;

import java.text.Normalizer;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Processes {
    private static Scanner in = new Scanner(System.in);

    public static Vehicle vehicleCreationProcess(int code, Object object) {
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
        }while (found);

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
            System.out.println("Exit / Run GUI - 0");
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

    public static Object logInFunctionality(int code){
        Boolean found = false;
        String userSurname;

        if (code == 1){ // Log in as Secretary

            System.out.print("Secretary surname: ");
            userSurname = in.nextLine();


            while (!found){
                for (Secretary sec : Secretary.secretaryList) {
                    if (removeTones(userSurname).equalsIgnoreCase(removeTones(sec.getSurname()))) {
                        System.out.println("Login as " + userSurname + " successful.");
                        return sec;
                    }
                }

                System.out.print("\nSecretary surname not found :(\n");
                System.out.print("Secretary surname: ");
                userSurname = in.nextLine();

            }

        }else if (code == 2){ // Log in as Reception

            System.out.print("Reception surname: ");
            userSurname = in.nextLine();

            while (!found){
                for (Engineer engineer : EngineerCatalog.fetchEngineers()) {
                    if (removeTones(userSurname).equalsIgnoreCase(removeTones(engineer.getSurname()))  && engineer.getRole().equalsIgnoreCase("reception")) {
                        System.out.println("Login as " + userSurname + " successful.");
                        return engineer;
                    }
                }

                System.out.print("\nReception surname not found :(\n");
                System.out.print("Reception surname: ");
                userSurname = in.nextLine();

            }
        }else if (code == 3){ // Log in as Supervisor

            System.out.print("Supervisor surname: ");
            userSurname = in.nextLine();

            while (!found){
                for (Engineer engineer : EngineerCatalog.fetchEngineers()) {
                    if (removeTones(userSurname).equalsIgnoreCase(removeTones(engineer.getSurname())) && engineer.getRole().equalsIgnoreCase("supervisor")) {
                        System.out.println("Login as " + userSurname + " successful.");
                        return engineer;
                    }
                }

                System.out.print("\nSupervisor surname not found :(\n");
                System.out.print("Supervisor surname: ");
                userSurname = in.nextLine();

            }
        }else if (code == 4) { // Log in as Engineer

                System.out.print("Engineer surname: ");
                userSurname = in.nextLine();

                while (!found) {
                    for (Engineer engineer : EngineerCatalog.fetchEngineers()) {
                        if (removeTones(userSurname).equalsIgnoreCase(removeTones(engineer.getSurname()))) {
                            System.out.println("Login as " + userSurname + " successful.");
                            return engineer;
                        }
                    }

                    System.out.print("\nEngineer surname not found :(\n");
                    System.out.print("Engineer surname: ");
                    userSurname = in.nextLine();

                }
            }

        return null;
    }

    public static String removeTones(String string){
        // Normalize the string
        String normalizedString = Normalizer.normalize(string, Normalizer.Form.NFD);

        // Remove diacritical marks
        String removedTonesString = Pattern.compile("\\p{InCombiningDiacriticalMarks}+").matcher(normalizedString)
                .replaceAll("");

        return removedTonesString;

    }
}
