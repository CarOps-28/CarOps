package com;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.carops.*;
import com.catalogs.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CarOps extends Application {

    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Υλοποίηση των ζητουμένων του παραδοτέου.");

        // Create Secretary
        Secretary tampouris = new Secretary("Ευθύμιος", "Ταμπούρης");
        System.out.println("New Secretary Ταμπούρης has been created");
        System.out.println();

        Secretary foulidis = new Secretary("Δημήτρης", "Φουλίδης");
        System.out.println("New Secretary Φουλίδης has been created");
        System.out.println();

        // Create Customers
        tampouris.createCustomer("Τάσος", "Λειβαδίτης", "1234567890", "tasos@gmail.com", "t12345");
        System.out.println("New Customer Λειβαδίτης has been created");
        System.out.println();

        tampouris.createCustomer("Μαρία", "Κάλλας", "6996986610", "kallas@gmail.com", "t12346");
        System.out.println("New Customer Κάλλας has been created");
        System.out.println();

        tampouris.createCustomer("Γιάννης", "Πάριος", "1234567893", "parios@gmail.com", "t12347");
        System.out.println("New Customer Πάριος has been created");
        System.out.println();

        tampouris.createCustomer("Μέρη", "Παρμεζάνα", "1234567894", "parmezana@gmail.com", "t12348");
        System.out.println("New Customer Παρμεζάνα has been created");
        System.out.println();

        tampouris.createCustomer("Τάκης", "Τσουκαλάς", "1234567895", "tsoukalas@gmail.com", "t12349");
        System.out.println("New Customer Τσουκαλάς has been created");
        System.out.println();

        // Create Vehicles by Tampouris
        tampouris.createVehicle("KTR4456", "TOYOTA", "90Turbo", 1989, "Truck", 500);
        System.out.println("New Vehicle KTR4456 has been created");
        System.out.println();

        // Create Reception Engineer
        ReceptionEngineer vergidis = new ReceptionEngineer("Κωνσταντίνος", "Βεργίδης", "reception");
        System.out.println("New ReceptionEngineer Βεργίδης has been created");
        System.out.println();

        // Crete Vehicles by Βεργίδης
        vergidis.createVehicle("NIK3745", "Land", "LandRover Range Rover HSE", 2014, "Vehicle", 0);
        System.out.println("New Vehicle NIK3745 has been created");
        System.out.println();

        // ---------------------------------------- 3 job objects
        // ----------------------------------------
        Job job1 = new Job("Oil change", 20, "");
        System.out.println("New Job 'Oil change' has been created");
        System.out.println();

        Job job2 = new Job("Cabin filter change", 5, "");
        System.out.println("New Job 'Cabin filter change' has been created");
        System.out.println();

        Job job3 = new Job("Brake maintenance", 30, "");
        System.out.println("New Job 'Brake maintenance' has been created");
        System.out.println();

        // ---------------------------------------- 6 spareParts Objects
        // ----------------------------------------
        SparePart sparePart1 = new SparePart("Oil package 4lt", 34, 30);
        System.out.println("New SparePart 'Oil package 4lt' has been created");
        System.out.println();

        SparePart sparePart2 = new SparePart("Oil filter", 55, 20);
        System.out.println("New SparePart 'Oil filter' has been created");
        System.out.println();

        SparePart sparePart3 = new SparePart("Cabin filter", 90, 30);
        System.out.println("New SparePart 'Cabin filter' has been created");
        System.out.println();

        SparePart sparePart4 = new SparePart("Front wheel brake pad", 44, 5);
        System.out.println("New SparePart 'Front wheel brake pad' has been created");
        System.out.println();

        SparePart sparePart5 = new SparePart("Back wheel brake pad", 22, 5);
        System.out.println("New SparePart 'Back wheel brake pad' has been created");
        System.out.println();

        SparePart sparePart6 = new SparePart("Break oil", 37, 10);
        System.out.println("New SparePart 'Break oil' has been created");
        System.out.println();

        // Create appointment

        // Blank appointment for testing
        tampouris.createAppointment("","", new DateTime("13/13/1222 - 12:20"));

        // Appointment 1
        Customer customer1 = tampouris.searchCustomer("6996986610");
        Vehicle vehicle3 = tampouris.searchVehicle("KTR4456");

        tampouris.createAppointment(customer1.getId(), vehicle3.getPlateNumber(), new DateTime("16/7/2024 - 15:00"));
        System.out.println("New Appointment with customer: " + customer1.getId() + " has been created");
        System.out.println();

        // Appointment 2
        Customer customer2 = tampouris.searchCustomer("1234567893");
        Vehicle vehicle4 = tampouris.searchVehicle("NIK3745");
        tampouris.createAppointment(customer2.getId(), vehicle4.getPlateNumber(), new DateTime("16/7/2024 - 16:00"));
        System.out.println("New Appointment with customer: " + customer2.getId() + " has been created");
        System.out.println();

        // 2 Repairfile Objects
        Vehicle vehicle1 = vergidis.searchVehicle("KTR4456");

        ArrayList<Job> estJobs1 = new ArrayList<>();
        estJobs1.add(job1);
        estJobs1.add(job2);
        vergidis.createRepairFile(vehicle1, estJobs1, 8);
        System.out.println("New Repairfile with vehicle: " + vehicle1.getPlateNumber() + " has been created");
        System.out.println();

        Vehicle vehicle2 = vergidis.searchVehicle("NIK3745");

        ArrayList<Job> estJobs2 = new ArrayList<>();
        estJobs2.add(job3);
        vergidis.createRepairFile(vehicle2, estJobs2, 16);
        System.out.println("New Repairfile with vehicle " + vehicle1.getPlateNumber() + " has been created");
        System.out.println();

        // Create Supervisor engineer
        SupervisorEngineer supervisorEngineer = new SupervisorEngineer("Δήμητρα", "Τζήκα", "supervisor");
        System.out.println("New supervisorEngineer Τζήκα has been created");
        System.out.println();

        // Create Engineers
        Engineer engineer1 = new Engineer("Βασίλης", "Τσολακίδης", "engineer");
        System.out.println("New Engineer Τσολακίδης has been created");
        System.out.println();

        Engineer engineer2 = new Engineer("Εριόλα", "Χαϊντάρι", "engineer");
        System.out.println("New Engineer Χαϊντάρη has been created");
        System.out.println();

        Engineer engineer3 = new Engineer("Βασίλης", "Χαμαλίδης", "engineer");
        System.out.println("New Engineer Χαμαλίδης has been created");
        System.out.println();

        // ------------------ Add assignments ------------------
        // ------------------ supervisor set assignments ------------------
        Vehicle vehicle5 = supervisorEngineer.searchVehicle("KTR4456");

        supervisorEngineer.createAssignment(engineer1, job1,
                RepairfileCatalog.fetchRepairfilebyVehicle(vehicle5.getPlateNumber()));
        System.out.println("New Assignment in engineer: " + engineer1.getName() + " has been created");
        System.out.println();

        //remove assignment from estimated job list. this happens automatically in program.
        RepairfileCatalog.fetchRepairfilebyVehicle(vehicle5.getPlateNumber()).getJobs().remove(job1);

        supervisorEngineer.createAssignment(engineer2, job2,
                RepairfileCatalog.fetchRepairfilebyVehicle(vehicle5.getPlateNumber()));
        System.out.println("New Assignment in engineer: " + engineer2.getName() + " has been created");
        System.out.println();

        //remove assignment from estimated job list. this happens automatically in program.
        RepairfileCatalog.fetchRepairfilebyVehicle(vehicle5.getPlateNumber()).getJobs().remove(job2);

        Vehicle vehicle6 = supervisorEngineer.searchVehicle("NIK3745");
        supervisorEngineer.createAssignment(engineer1, job3,
                RepairfileCatalog.fetchRepairfilebyVehicle(vehicle6.getPlateNumber()));
        System.out.println("New Assignment in engineer: " + engineer1.getName() + " has been created");
        System.out.println();

        //remove assignment from estimated job list. this happens automatically in program.
        RepairfileCatalog.fetchRepairfilebyVehicle(vehicle6.getPlateNumber()).getJobs().remove(job3);

        // ------------------ Engineers set spareParts ------------------

        // ------------------ engineer1 add sparepart to assignment2 - Repairfile 1
        Assignment assignment1 = engineer1.getAssignments().get(0);

        HashMap<SparePart, Integer> spareParts1 = new HashMap<>();

        spareParts1.put(sparePart1, 1);
        spareParts1.put(sparePart2, 1);
        assignment1.setSpareParts(spareParts1);

        assignment1.setWorktime(4);

        // ------------------ engineer2 add sparepart to assignment2 - Repairfile 1
        Assignment assignment2 = engineer2.getAssignments().get(0);

        HashMap<SparePart, Integer> spareParts2 = new HashMap<>();
        spareParts2.put(sparePart3, 1);
        assignment2.setSpareParts(spareParts2);

        assignment2.setWorktime(4);


        // ------------------ engineer1 add sparepart to assignment2 - Repairfile 2
        Assignment assignment3 = engineer1.getAssignments().get(1);

        HashMap<SparePart, Integer> spareParts3 = new HashMap<>();

        spareParts3.put(sparePart4, 4);
        spareParts3.put(sparePart5, 4);
        spareParts3.put(sparePart6, 1);
        assignment3.setSpareParts(spareParts3);

        assignment3.setWorktime(16);

        //this happens automatically when registering spareparts and worktime in the program.
        assignment1.setStatus(true);
        assignment2.setStatus(true);
        assignment3.setStatus(true);

        // Supervisor
        supervisorEngineer
                .callRecordTotalSparePartsFromRepairfile(RepairfileCatalog.fetchRepairfilebyVehicle("KTR4456"));

        supervisorEngineer
                .callRecordTotalSparePartsFromRepairfile(RepairfileCatalog.fetchRepairfilebyVehicle("NIK3745"));

        //this happens automatically when registering spareparts and worktime in the program.
        supervisorEngineer.searchRepairfile("KTR4456").setStatus("Completed");
        supervisorEngineer.searchRepairfile("NIK3745").setStatus("Completed");

        // ------------------ PRINT STATISTICS ------------------
        System.out.println("Total Catalog contents:");
        JobCatalog.printData();
        SparePartsCatalog.printData();
        RepairfileCatalog.printData();
        AppointmentCatalog.printData();
        CustomerCatalog.printData();
        VehicleCatalog.printData();
        EngineerCatalog.printData();

        // ------------------ TEXT MENU ------------------
        Owner owner = new Owner("owner", "owner");


        int testerChoice = Processes.options(0);
        while(testerChoice != 0){
            System.out.println();
            System.out.println("TEXT MENU");
            System.out.println();

            switch (testerChoice) {
                case 1 -> {
                    System.out.println("---------- Owner ----------");
                    System.out.println();
                    ownerMenu(owner);
                }
                case 2 -> {
                    System.out.println("---------- Secretary ----------");
                    System.out.println();
                    secretaryMenu();
                }
                case 3 -> {
                    System.out.println("---------- Reception Engineer ----------");
                    System.out.println();
                    receptionEngineerMenu();
                }
                case 4 -> {
                    System.out.println("---------- Supervisor Engineer ----------");
                    System.out.println();
                    supervisorEngineerMenu();
                }
                case 5 -> {
                    System.out.println("---------- Engineer ----------");
                    System.out.println();
                    EngineerMenu();
                }
            }

            System.out.println("\nTotal Catalog contents:");
            JobCatalog.printData();
            SparePartsCatalog.printData();
            RepairfileCatalog.printData();
            AppointmentCatalog.printData();
            CustomerCatalog.printData();
            VehicleCatalog.printData();
            EngineerCatalog.printData();

            testerChoice = Processes.options(0);
        }

        launch(args);

        System.exit(0);
    }

    private static void secretaryMenu() {

        Secretary secretaryObject = (Secretary) Processes.logInFunctionality(1);

        int secretaryChoice;
        int userInputCode;

        userInputCode = Processes.options(1);
        while (userInputCode != 0) {

            Vehicle vehicle = null;
            Customer customer = null;
            Repairfile repairfile ;
            String plateNumber ;

            switch (userInputCode) {
                case 1 -> {
                    System.out.println("-> Add vehicle in appointment");
                    System.out.println("Search Vehicle - 1");
                    System.out.println("Make Vehicle - 2");
                    System.out.println("Appointment without Vehicle - 3");
                    System.out.println("Exit - 0");
                    secretaryChoice = Processes.checkInputData(0, 3);
                    if (secretaryChoice == 0) {
                        break;
                    }
                    if (secretaryChoice == 1) {
                        do {
                            System.out.print("Enter vehicle plateNumber: ");
                            plateNumber = in.nextLine();

                            assert secretaryObject != null; // Empty object warning
                            vehicle = secretaryObject.searchVehicle(plateNumber);

                            if (vehicle == null)
                                System.out.println("Vehicle not found.");
                        } while (vehicle == null);
                        System.out.println("\nVehicle found. Vehicle plate successfully added to appointment.");

                    } else if (secretaryChoice == 2) {
                        vehicle = Processes.vehicleCreationProcess(1, secretaryObject);
                        System.out.println();
                    }
                    System.out.println();
                    System.out.println();
                    System.out.println("-> Add customer in appointment");
                    System.out.println("Search Customer - 1");
                    System.out.println("Make Customer - 2");
                    System.out.println("Appointment without Customer - 3");
                    System.out.println("Exit - 0");
                    secretaryChoice = Processes.checkInputData(0, 3);

                    if (secretaryChoice == 0) {
                        break;
                    }
                    if (secretaryChoice == 1) {
                        do {
                            System.out.print("Enter Customer phone: ");
                            String phoneNumber = in.nextLine();

                            assert secretaryObject != null; // Empty object warning
                            customer = secretaryObject.searchCustomer(phoneNumber);

                            if (customer == null)
                                System.out.println("Customer not found.");
                        } while (customer == null);
                        System.out.println("Customer found. Customer's ID successfully added to appointment.");

                    } else if (secretaryChoice == 2) {
                        customer = Processes.customerCreationProcess(secretaryObject);
                        System.out.println();
                    }
                    System.out.print("Give DateTime (XX/XX/XXXX - XX:XX): ");
                    String inputDatetime = in.nextLine();
                    DateTime dateTime = new DateTime(inputDatetime);

                    assert secretaryObject != null; // Empty object warning
                    if (vehicle == null && customer == null) {
                        secretaryObject.createAppointment("", "", dateTime);
                    } else if (vehicle == null) {
                        secretaryObject.createAppointment(customer.getId(), "", dateTime);
                    } else if (customer == null) {
                        secretaryObject.createAppointment("", vehicle.getPlateNumber(), dateTime);
                    } else {
                        secretaryObject.createAppointment(customer.getId(), vehicle.getPlateNumber(),
                                dateTime);
                    }
                    System.out.println("New Appointment has been created.");
                }
                case 2 -> {
                    System.out.println();
                    Processes.vehicleCreationProcess(1, secretaryObject);
                    System.out.println();
                }
                case 3 -> {
                    System.out.println();
                    Processes.customerCreationProcess(secretaryObject);
                    System.out.println();
                }
                case 4 -> {
                    // εμφάνιση όλων των φακέλων επισκευής και αναζήτηση με βάση τον αριθμό πινακίδας για
                    // να δεί η γραμματεία εάν ο φάκελος του οχήματος είναι Pending, δηλαδή περιμένει
                    // απάντηση του πελάτη για συνέχεια η τέλος της διαδικασίας επισκευής.
                    System.out.println();
                    System.out.print("Change RepairFile Status:");
                    RepairfileCatalog.printData();
                    System.out.println("\nSearch repair files that await customer's answer with vehicle plate number");
                    boolean proceed = true;
                    do {
                        System.out.print("Enter Vehicle plate number or enter Exit to abandon search: ");
                        plateNumber = in.nextLine();

                        assert secretaryObject != null; // Empty object warning
                        repairfile = secretaryObject.searchRepairfile(plateNumber);

                        if (plateNumber.equalsIgnoreCase("exit")) {
                            proceed = true;
                        }else {
                            if (repairfile == null) {
                                System.out.println("\nNo repair file found with such vehicle plate number.");
                                proceed = false;
                            } else if (!repairfile.getStatus().equals("Awaiting")) {
                                System.out.println("\nRepair file found but its status is not Awaiting.");
                                proceed = false;
                            }else if (!repairfile.getStatus().equals("Awaiting")) {
                                System.out.println("");
                                proceed = true;
                            }
                        }
                    } while (!proceed);

                    if (!plateNumber.equalsIgnoreCase("exit")) {
                        System.out.println("Repairfile found. Awaiting customer's answer.");

                        System.out.println("\nChange repairfile status to Accepted (1)/Declined (0)");
                        int choice = Processes.checkInputData(0, 1);
                        if (choice == 1)
                            repairfile.setStatus("Accepted");
                        else
                            repairfile.setStatus("Declined");

                        System.out.println("\nRepairfile status has been changed.\n");
                    }
                }
                case 5 -> {
                    System.out.println("\nPrint repair file by entering the vehicle's plate number.");
                    System.out.print("Enter Vehicle plate number: ");
                    plateNumber = in.nextLine();

                    assert secretaryObject != null; // Empty object warning
                    repairfile = secretaryObject.searchRepairfile(plateNumber);
                    if (repairfile == null) {
                        System.out.println("Repairfile not found.");
                    } else {
                        System.out.printf("\n> Repair File:\n %-26s %-10s  %-13s  %-10s  %-8s  %-14s  %-4s\n",
                                "Repair duration in days", "Status",
                                "Plate number", "Type", "Est Jobs", "Assignments", "Total Cost");
                        repairfile.printData();
                    }
                }
                case 6 -> {
                    AppointmentCatalog.printData();
                    System.out.println();
                }
                case 7 -> {
                    System.out.println();
                    System.out.printf("""
                                    Select Appointment to update:
                                    n %-25s  %-15s  %-14s  %-20s  %-20s  %-20s  %-20s
                                    """,
                            "Date", "Name", "Surname", "Phone number", "Vehicle Plate", "Brand", "Type");

                    ArrayList<Appointment> unfinishedAppointments = new ArrayList<Appointment>();

                    int i = 1;
                    for (Appointment appointment : AppointmentCatalog.fetchAppointments()) {
                        if (appointment.getCustomerId().equals("") || appointment.getVehiclePlateNumber().equals("")) {
                            unfinishedAppointments.add(appointment);
                            System.out.printf("%d", i);
                            appointment.printData();
                            i++;
                        }
                    }
                    System.out.print("\nChoose appointment number or choose 0 to Exit\n");

                    int appointmentChoice = Processes.checkInputData(0, i);

                    if (appointmentChoice == 0) {
                        break;
                    }

                    Appointment chosenAppointment = unfinishedAppointments.get(--appointmentChoice);
                    System.out.printf("n %-25s  %-15s  %-14s  %-20s  %-20s  %-20s  %-20s\n",
                            "Date", "Name", "Surname", "Phone number", "Vehicle Plate", "Brand", "Type");

                    ++appointmentChoice;

                    System.out.printf("%d", appointmentChoice);
                    chosenAppointment.printData();
                    System.out.print("\n");

                    do  {
                        //both customer and vehicle are missing
                        if (chosenAppointment.getCustomerId().equals("") && chosenAppointment.getVehiclePlateNumber().equals("")) {
                            System.out.println("Add Customer - 1");
                            System.out.println("Add Vehicle - 2");
                            System.out.println("Exit - 0");

                            secretaryChoice = Processes.checkInputData(0, 2);

                            switch (secretaryChoice) {
                                case 0:
                                    break;

                                case 1:
                                    System.out.print("\nGive customer phone number: ");
                                    String phoneNumber = in.nextLine();
                                    customer = CustomerCatalog.fetchCustomerByPhoneNumber(phoneNumber);
                                    if (customer == null) {
                                        System.out.print("\nCustomer not found in catalogs. Provide customer details to create a new customer.\n");
                                        customer = Processes.customerCreationProcess(secretaryObject);
                                    }
                                    chosenAppointment.setCustomerId(customer.getId());

                                    System.out.println();
                                    System.out.printf("""
                                                    Appointment updated:
                                                    n %-25s  %-15s  %-14s  %-20s  %-20s  %-20s  %-20s
                                                    """,
                                            "Date", "Name", "Surname", "Phone number", "Vehicle Plate", "Brand", "Type");
                                    System.out.printf("%d", appointmentChoice);
                                    chosenAppointment.printData();
                                    break;

                                case 2:
                                    System.out.print("\nGive vehicle plate number: ");
                                    String platenumber = in.nextLine();

                                    vehicle = VehicleCatalog.fetchVehicleByPlateNumber(platenumber);
                                    if (vehicle == null) {
                                        System.out.print("\nVehicle not found in catalogs. Provide vehicle details to create a new customer.\n");
                                        vehicle = Processes.vehicleCreationProcess(1, secretaryObject);
                                    }

                                    chosenAppointment.setVehiclePlateNumber(vehicle.getPlateNumber());

                                    System.out.println();
                                    System.out.printf("""
                                                    Appointment updated:
                                                    n %-25s  %-15s  %-14s  %-20s  %-20s  %-20s  %-20s
                                                    """,
                                            "Date", "Name", "Surname", "Phone number", "Vehicle Plate", "Brand", "Type");
                                    System.out.printf("%d", appointmentChoice);
                                    chosenAppointment.printData();
                                    break;

                            }
                        } else if (chosenAppointment.getCustomerId().equals("") && !chosenAppointment.getVehiclePlateNumber().equals("")) {
                            //only customer is missing
                            System.out.println("Add Customer - 1");
                            System.out.println("Exit - 0");

                            secretaryChoice = Processes.checkInputData(0, 1);

                            switch ((secretaryChoice)) {
                                case 0:
                                    break;

                                case 1:
                                    System.out.print("\nGive customer phone number: ");
                                    String phoneNumber = in.nextLine();
                                    customer = CustomerCatalog.fetchCustomerByPhoneNumber(phoneNumber);
                                    if (customer == null) {
                                        customer = Processes.customerCreationProcess(secretaryObject);
                                    }

                                    chosenAppointment.setCustomerId(customer.getId());

                                    System.out.println();
                                    System.out.printf("""
                                                    Appointment updated:
                                                    n %-25s  %-15s  %-14s  %-20s  %-20s  %-20s  %-20s
                                                    """,
                                            "Date", "Name", "Surname", "Phone number", "Vehicle Plate", "Brand", "Type");
                                    System.out.printf("%d", appointmentChoice);
                                    chosenAppointment.printData();
                                    break;
                            }
                        } else if (!chosenAppointment.getCustomerId().equals("") && chosenAppointment.getVehiclePlateNumber().equals("")) {
                            //only vehicle is missing
                            System.out.println("Add Vehicle - 1");
                            System.out.println("Exit - 0");

                            secretaryChoice = Processes.checkInputData(0, 1);

                            switch (secretaryChoice) {
                                case 0:
                                    break;

                                case 1:
                                    System.out.print("\nGive vehicle plate number: ");
                                    String platenumber = in.nextLine();

                                    vehicle = VehicleCatalog.fetchVehicleByPlateNumber(platenumber);
                                    if (vehicle == null) {
                                        System.out.print("\nVehicle not found in catalogs. Provide vehicle details to create a new customer.\n");
                                        vehicle = Processes.vehicleCreationProcess(1, secretaryObject);
                                    }

                                    chosenAppointment.setVehiclePlateNumber(vehicle.getPlateNumber());

                                    System.out.println();
                                    System.out.printf("""
                                                    Appointment updated:
                                                    n %-25s  %-15s  %-14s  %-20s  %-20s  %-20s  %-20s
                                                    """,
                                            "Date", "Name", "Surname", "Phone number", "Vehicle Plate", "Brand", "Type");
                                    System.out.printf("%d", appointmentChoice);
                                    chosenAppointment.printData();
                                    break;
                            }
                        } else {
                            System.out.println();
                            System.out.println("Exit - 0");
                            secretaryChoice = Processes.checkInputData(0, 1);
                        }
                    }while (secretaryChoice != 0);
                }
            }
            userInputCode = Processes.options(1);
        }
    }

    private static void receptionEngineerMenu() {

        ReceptionEngineer receptionEngineerObject = (ReceptionEngineer) Processes.logInFunctionality(2);

        int userInputCode;
        int engineerChoice;

        userInputCode = Processes.options(2);
        while (userInputCode != 0) {
            Vehicle vehicle = null;
            String plateNumber = "";
            int estDays = 0;

            if (userInputCode == 1) {

                System.out.println();
                System.out.println("Search vehicle - 1");
                System.out.println("Exit - 0");

                engineerChoice = Processes.checkInputData(0, 1);

                switch(engineerChoice){
                    case 0:
                        break;

                    case 1:
                        while (engineerChoice == 1){
                            System.out.println();
                            System.out.print("Enter vehicle plateNumber: ");
                            plateNumber = in.nextLine();

                            assert receptionEngineerObject != null; // Empty object warning
                            vehicle = receptionEngineerObject.searchVehicle(plateNumber);

                            if(vehicle == null) {
                                System.out.println();
                                System.out.println("Vehicle not found.\n");
                                System.out.println("Search vehicle - 1");
                                System.out.println("Create vehicle - 2");
                                System.out.println("Exit - 0");

                                engineerChoice = Processes.checkInputData(0, 2);

                                if(engineerChoice == 0)
                                    break;

                                else if (engineerChoice == 2){
                                    System.out.println();
                                    vehicle = Processes.vehicleCreationProcess(2, receptionEngineerObject);
                                }
                            }
                            else{
                                boolean proceed = true;

                                System.out.println("\nVehicle found.");

                                //check if vehicle is already in the system. Repair file creation
                                //will only happen if the vehicle has never been repaired in the shop before
                                // or if latest repair file is either Completed or Declined.
                                Repairfile repairfile = RepairfileCatalog.fetchRepairfilebyVehicle(plateNumber);
                                if (repairfile != null) { //repairfile with this vehicle already in system
                                    if (repairfile.getStatus().equals("Accepted")) {
                                        System.out.println("Vehicle currently getting repaired. Search another vehicle.");
                                        proceed = false;
                                    }
                                    else if(repairfile.getStatus().equals("Awaiting")){
                                        System.out.println("Already diagnosed this Vehicle. Customer answer pending to continue repairs.");
                                        proceed = false;
                                    }
                                }

                                //vehicle waiting for diagnostic check
                                if (proceed) {
                                    int job = 0;
                                    ArrayList<Job> jobs = new ArrayList<Job>();

                                    do {
                                        System.out.println("\nChoose a Job (1,2,ect...): ");

                                        int counter = 1;
                                        for (Job jb : JobCatalog.fetchJobs()) {
                                            if (!jobs.contains(jb)) {
                                                System.out.println(counter + ") " + jb.getName());
                                            }
                                            counter++;
                                        }

                                        System.out.println("stop adding jobs - 0");

                                        System.out.print("your choice: ");
                                        job = in.nextInt();

                                        for (int i = 0; i < JobCatalog.fetchJobs().size(); i++) {
                                            if (job == (i + 1)) {
                                                jobs.add(JobCatalog.fetchJobs().get(i));
                                            }
                                        }

                                    } while (job != 0);

                                    System.out.print("\nAdd estimated hours: ");
                                    estDays = in.nextInt();
                                    in.nextLine(); //to enter character
                                    System.out.print("\nRepair file created.\n");
                                    assert vehicle != null;
                                    receptionEngineerObject.createRepairFile(vehicle, jobs, estDays);

                                    break;

                                }
                            }
                        }

                        break;
                }
            }

            userInputCode = Processes.options(2);
        }
    }

    private static void supervisorEngineerMenu() {

        SupervisorEngineer supervisorEngineerObject = (SupervisorEngineer) Processes.logInFunctionality(3);

        int userInputCode;
        int engineerChoice;

        userInputCode = -1;
        while (userInputCode != 0) {
            userInputCode = Processes.options(3);
            int repairfileChoice;
            String plateNumber = "";
            Repairfile repairfile = null;
            int jobNumber, engineerNumber;

            switch (userInputCode) {
                case 0:
                    break;

                case 1:
                    System.out.println();
                    System.out.println("Search vehicle by plateNumber - 1");
                    System.out.println("Exit - 0");

                    engineerChoice = Processes.checkInputData(0, 1);

                    switch (engineerChoice) {
                        case 0:
                            break;

                        case 1:
                            do {
                                repairfile = null;
                                System.out.print("\nEnter Vehicle plate number or <<Exit>> to abandon search: ");
                                plateNumber = in.nextLine();

                                assert supervisorEngineerObject != null; // Empty object warning
                                repairfile = supervisorEngineerObject.searchRepairfile(plateNumber);

                                if(!plateNumber.equalsIgnoreCase("Exit")){
                                    if(repairfile==null)
                                        System.out.println("No repair file found.");
                                    else if (!repairfile.getStatus().equals("Accepted")) {
                                        System.out.println("Cannot create assignments for this vehicle.");
                                        repairfile = null; //to search again
                                    }
                                }
                            } while (repairfile == null && !plateNumber.equalsIgnoreCase("Exit"));

                            if(!plateNumber.equalsIgnoreCase("Exit")){
                                System.out.println("Repair file found.");
                                ArrayList<Engineer> engineers = EngineerCatalog.fetchEngineers();
                                ArrayList<Job> jobs = repairfile.getJobs();

                                System.out.println("\nUnassigned Estimated Jobs from Reception:");
                                int counter = 1;
                                for (Job job : jobs) {
                                    System.out.println(counter + ") " + job.getName());
                                    counter++;
                                }

                                boolean done = false;
                                repairfileChoice = -1;

                                while ( !done && repairfileChoice!=0 ) {
                                    System.out.println();
                                    System.out.println("Set job to engineer - 1");
                                    System.out.println("Add new job - 2");
                                    System.out.println("Exit - 0");

                                    repairfileChoice = Processes.checkInputData(0, 2);

                                    switch (repairfileChoice) {
                                        case 0:
                                            break;

                                        case 1:
                                            System.out.println("\n------------ Set job to engineer ------------");
                                            System.out.println("Available engineers:");
                                            counter = 1;
                                            for (Engineer engineer : EngineerCatalog.fetchEngineers()) {
                                                System.out.println(counter + ") " + engineer.getName() + " " + engineer.getSurname());
                                                counter++;
                                            }
                                            System.out.println();

                                            if (!jobs.isEmpty()) {
                                                System.out.println("Unassigned Estimated Jobs from Reception:");
                                                counter = 1;
                                                for (Job job : jobs) {
                                                    System.out.println(counter + ") " + job.getName());
                                                    counter++;
                                                }

                                                System.out.println();
                                                System.out.print("Choose Job (1,...): ");
                                                jobNumber = in.nextInt();

                                                System.out.print("Choose engineer (1,...): ");
                                                engineerNumber = in.nextInt();
                                                in.nextLine(); //to discard enter from in.nextInt();

                                                System.out.println("\nJob " + jobs.get(jobNumber - 1).getName() + " assigned to engineer " + engineers.get(engineerNumber - 1).getSurname());

                                                Assignment assignment = new Assignment(engineers.get(engineerNumber - 1), jobs.get(jobNumber - 1), repairfile);

                                                repairfile.addAssignment(assignment); //add assignment to repairfile
                                                engineers.get(engineerNumber).addAssignment(assignment); //add assignment to engineer
                                                jobs.remove(jobs.get(jobNumber - 1)); //remove job from estimated list after assigning it to engineer.

                                            } else {
                                                System.out.println("No more jobs left to assign. Add new ones or continue.\n");
                                                done = true;
                                            }

                                            break;

                                        case 2:
                                            counter = 1;
                                            for (Job job : JobCatalog.fetchJobs()) {
                                                if (!jobs.contains(job)) { // if job isn't already in estimated jobs list
                                                    System.out.println(counter + ") " + job.getName());
                                                }
                                                counter++;
                                            }
                                            System.out.println();

                                            System.out.print("Add a job: ");
                                            jobNumber = in.nextInt();

                                            jobs.add(JobCatalog.fetchJobs().get(jobNumber - 1));

                                            break;
                                    }
                                }

                                break;
                            }

                    }

                    break;

                case 2:
                    System.out.println("\nEnter Vehicle plate number - 1");
                    System.out.println("Exit - 0");
                    engineerChoice = Processes.checkInputData(0, 1);
                    switch (engineerChoice){
                        case 0:
                            break;

                        case 1:
                            do{
                                System.out.print("\nEnter Vehicle plate number or <<Exit>> to abandon search: ");
                                plateNumber = in.nextLine();

                                repairfile = null;
                                if(!plateNumber.equalsIgnoreCase("Exit")){
                                    assert supervisorEngineerObject != null; // Empty object warning
                                    repairfile = supervisorEngineerObject.searchRepairfile(plateNumber);

                                    if(repairfile == null)
                                        System.out.println("\n No such vehicle found");
                                    else if (repairfile.getStatus().equals("Completed")){
                                        System.out.println("Repair status is already <<Completed>>.");
                                        repairfile = null; //to search again
                                    }
                                    else if (!repairfile.getStatus().equals("Accepted")){
                                        System.out.println("Cannot set repair status for this vehicle.");
                                        repairfile = null; //to search again
                                    }
                                    else if(!repairfile.getJobs().isEmpty()){
                                        System.out.println("There are still unassigned jobs for this vehicle. Complete assignments to start repairs.");
                                        repairfile = null; //to search again
                                    }
                                }
                            }while(repairfile == null && !plateNumber.equalsIgnoreCase("Exit"));

                            if(!plateNumber.equalsIgnoreCase("Exit")){
                                boolean repairCompleted = true;

                                for (Assignment assignment : repairfile.getAssignments()) {
                                    if (!assignment.getStatus()) {
                                        repairCompleted = false;
                                        break;
                                    }
                                }

                                if(!repairCompleted) {
                                    System.out.println("\nRepair is not yet done for this vehicle.\n");
                                }
                                else{
                                    System.out.println("Repairs completed. Change repair status to <<Completed>> ? (1 - Yes, 0 - No)");
                                    int answer = Processes.checkInputData(0, 1);
                                    if(answer == 1) {
                                        repairfile.setStatus("Completed");
                                        System.out.println("Repairfile status has been changed.");
                                    }
                                }
                            }
                            break;
                    }
                }
        }
            System.out.println();

    }

    public static void EngineerMenu() {


        Engineer EngineerObject = (Engineer) Processes.logInFunctionality(4);

        int userInputCode;
        int engineerChoice;
        int counter;

        userInputCode = Processes.options(4);

        while (userInputCode != 0) {
            switch (userInputCode) {
                case 1 -> {

                    if (EngineerObject.getAssignments().isEmpty()) {
                        System.out.println("\nNo Jobs assigned at the moment.");
                    }else{
                        System.out.printf("|%-20s|%-20s |%-10s |%-15s\n", "Plate Number", "Job name", "Work Time", "Status");
                        for (Assignment assignment : EngineerObject.getAssignments()) {
                            System.out.printf("|%-20s|%-20s |%-10s |%-15s\n", assignment.getRepairfile().getVehicle().getPlateNumber(), assignment.getJob().getName(), assignment.getWorktime(), assignment.getStatus());
                        }
                    }

                }
                case 2 -> {
                    assert EngineerObject != null;
                    if (EngineerObject.getAssignments().isEmpty()) {
                        System.out.println("\nNo Jobs assigned at the moment.");
                        break;
                    }else{

                        System.out.println("\nChoose assignment");
                        counter = 1;

                        for (Assignment assignment : EngineerObject.getAssignments()) {
                            String plateNumber = assignment.getRepairfile().getVehicle().getPlateNumber();
                            System.out.println(counter + ") Vehicle: " + plateNumber + " with assignment: "
                                    + assignment.getJob().getName());
                            counter++;
                        }

                        System.out.println("\nExit - 0");
                        engineerChoice = Processes.checkInputData(0, counter);

                        if (engineerChoice == 0) {
                            break;
                        }

                        int engineerSparePartChoice, numberOfSparePart, assignmentWorktime;
                        HashMap<SparePart, Integer> spareParts = new HashMap<SparePart, Integer>();

                        Assignment currentAssignment = EngineerObject.getAssignments().get(engineerChoice - 1);

                        do {
                            System.out.println("\nChoose sparePart");
                            System.out.printf("\n> Spare Parts:\nn %-25s  |%-4s %10s\n", "Name", "A-Q", "Price per unit");
                            counter = 1;
                            for (SparePart sparePart : SparePartsCatalog.fetchSpareParts()) {
                                if (!spareParts.containsKey(sparePart)) {
                                    System.out.printf("%d", counter);
                                    sparePart.printData();
                                }
                                counter++;
                            }

                            System.out.println("\nExit - 0");

                            engineerSparePartChoice = Processes.checkInputData(0, counter);

                            if (engineerSparePartChoice == 0){
                                break;
                            }

                            SparePart sparePart = SparePartsCatalog.fetchSpareParts().get(engineerSparePartChoice - 1);

                            System.out.println("Number of sparePart used");

                            numberOfSparePart = Processes.checkInputData(1, sparePart.getAvailableQuantity());

                            sparePart.setAvailableQuantity(sparePart.getAvailableQuantity() - numberOfSparePart);

                            spareParts.put(sparePart, numberOfSparePart);
                            System.out.println("Do you want to add more spareParts ?");
                            System.out.println("1 : Yes / 2 : No");

                            engineerChoice = Processes.checkInputData(1, 2);

                        } while (engineerChoice == 1);


                        currentAssignment.setSpareParts(spareParts);
                        System.out.println("Set Work Time");
                        System.out.print("your choice: ");
                        assignmentWorktime = in.nextInt();

                        currentAssignment.setWorktime(assignmentWorktime); // add workTime
                        currentAssignment.setStatus(true); // change status
                        EngineerObject.getAssignments().remove(currentAssignment); // remove the completed assignment
                    }

                }
            }

            userInputCode = Processes.options(4);
        }
    }
    public static void ownerMenu(Owner owner){

        Scanner in = new Scanner(System.in);
        int ownerChoice;

        ownerChoice = Processes.options(5);
        switch (ownerChoice){
            case 0:
                break;
            case 1:
                Engineer engineer = null;
                System.out.println("Choose engineer: ");

                EngineerCatalog.printData();

                System.out.println();
                int engineerChoice = Processes.checkInputData(0,EngineerCatalog.fetchEngineers().size());

                if (engineerChoice != 0) {
                    engineer = EngineerCatalog.fetchEngineers().get(engineerChoice - 1);

                    System.out.println("Set new role: ");
                    System.out.println("Reception - 1 / Supervisor - 2 / Engineer - 3");
                    System.out.print("you choice: ");

                    int role = in.nextInt();
                    switch (role) {
                        case 1 -> owner.changeRole(engineer, "reception");
                        case 2 -> owner.changeRole(engineer, "supervisor");
                        case 3 -> owner.changeRole(engineer, "engineer");
                    }
                }
                break;
        }
    }
    // GUI
    @Override
    public void start(Stage stage) {

        Parent root;

        try {
            root = FXMLLoader.load(getClass().getResource("StartScreenController-view.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Scene scene = new Scene(root);
        stage.setTitle("CarOps Information System");
        stage.setHeight(700);
        stage.setWidth(900);

        stage.setScene(scene);
        stage.show();
    }
}