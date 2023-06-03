package com.carops;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

//    Create GUI
public class CarOps extends Application {
    // Create GUI
    @Override
    public void start(Stage stage) throws IOException {

        Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();

        FXMLLoader fxmlLoader = new FXMLLoader(CarOps.class.getResource("start-screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), visualBounds.getWidth() * 0.7, visualBounds.getHeight() * 0.7);

        stage.setTitle("CarOps Information System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        System.out.println("Ylopoiisi ton zitimaton toy paradotaioy");
        // Create Secretary
        Secretary tampouris = new Secretary("Efthimios", "Tampouris");
        System.out.println("New Secretary Tampouris has been created");
        System.out.println();

        Secretary mantas = new Secretary("Dimitris", "Foulidis");
        System.out.println("New Secretary Foulidis has been created");
        System.out.println();
        // ---------------------------------------- Create Customer
        // ----------------------------------------

        tampouris.createCustomer("Tasos", "Livaditis", "1234567890", "tzhka@gmail.com", "t12345");
        System.out.println("New Customer Livaditis has been created");
        System.out.println();

        tampouris.createCustomer("Maria", "Kallas", "6996986610", "bill@gmail.com", "t12346");
        System.out.println("New Customer Kallas has been created");
        System.out.println();

        tampouris.createCustomer("Giannis", "Parios", "1234567893", "jimmy@gmail.com", "t12347");
        System.out.println("New Customer Parios has been created");
        System.out.println();

        tampouris.createCustomer("Meri", "Parmezana", "1234567894", "eri@gmail.com", "t12348");
        System.out.println("New Customer Parmezana has been created");
        System.out.println();

        tampouris.createCustomer("Takis", "Petrov", "1234567895", "bill2@gmail.com", "t12349");
        System.out.println("New Customer Petrov has been created");
        System.out.println();

        // ---------------------------------------- Create Vehicles by Tampouris
        // ----------------------------------------
        tampouris.createVehicle("KTR4456", "TOYOTA", "90Turbo", 1989, "Truck", 500);
        System.out.println("New Vehicle KTR4456 has been created");
        System.out.println();

        // ---------------------------------------- Create Reception Engineer.
        // ----------------------------------------
        ReceptionEngineer vergidis = new ReceptionEngineer("Konstantinos", "Vergidis", "reception");
        System.out.println("New ReceptionEngineer Vergidis has been created");
        System.out.println();

        // ---------------------------------------- Crete Vehicles by Vergidis
        // ----------------------------------------
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

        // -------------- Create appointment ------------------

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

        // -------------- /Create appointment ------------------

        // ------------------ 2 Repairfile Objects ------------------

        Vehicle vehicle1 = vergidis.searchVehicle("KTR4456");

        ArrayList<Job> estJobs1 = new ArrayList<>();
        estJobs1.add(job1);
        estJobs1.add(job2);
        vergidis.createRepairFile(vehicle1, estJobs1, 8);
        System.out.println("New Repairfile with vehicle: " + vehicle1.getPlateNumber() + " has been created");
        System.out.println();

        Vehicle vehicle2 = vergidis.searchVehicle("NIK3745");

        ArrayList<Job> estJobs2 = new ArrayList<>();
        estJobs1.add(job3);
        vergidis.createRepairFile(vehicle2, estJobs1, 16);
        System.out.println("New Repairfile with vehicle " + vehicle1.getPlateNumber() + " has been created");
        System.out.println();


        // ------------------ Create Supervisor engineer ------------------
        SupervisorEngineer supervisorEngineer = new SupervisorEngineer("Dimitra", "Tzhka", "supervisor");
        System.out.println("New supervisorEngineer Tzhka has been created");
        System.out.println();

        // ------------------ Create Engineers ------------------
        Engineer engineer1 = new Engineer("Vasilis", "Tsolakidis", "engineer");
        System.out.println("New Engineer Tsolakidis has been created");
        System.out.println();

        Engineer engineer2 = new Engineer("Eriola", "Xaintari", "engineer");
        System.out.println("New Engineer Xaintari has been created");
        System.out.println();

        Engineer engineer3 = new Engineer("Vasilis", "Xamalidis", "engineer");
        System.out.println("New Engineer Xamalidis has been created");
        System.out.println();

        // ------------------ Add assignments ------------------
        // ------------------ supervisor set assignments ------------------
        Vehicle vehicle5 = supervisorEngineer.searchVehicle("KTR4456");

        supervisorEngineer.createAssignment(engineer1, job1,
                RepairfileCatalog.fetchRepairfilebyVehicle(vehicle5.getPlateNumber()));
        System.out.println("New Assignment in engineer: " + engineer1.getName() + " has been created");
        System.out.println();

        supervisorEngineer.createAssignment(engineer2, job2,
                RepairfileCatalog.fetchRepairfilebyVehicle(vehicle5.getPlateNumber()));
        System.out.println("New Assignment in engineer: " + engineer2.getName() + " has been created");
        System.out.println();

        Vehicle vehicle6 = supervisorEngineer.searchVehicle("NIK3745");
        supervisorEngineer.createAssignment(engineer1, job3,
                RepairfileCatalog.fetchRepairfilebyVehicle(vehicle6.getPlateNumber()));
        System.out.println("New Assignment in engineer: " + engineer1.getName() + " has been created");
        System.out.println();

        // ------------------ Engineers set spareParts ------------------

        // ------------------ engineer1 add sparepart to assignment2 - Repairfile 1
        // ------------------
        Assignment assignment1 = engineer1.getAssignments().get(0);

        HashMap<SparePart, Integer> spareParts1 = new HashMap<>();

        spareParts1.put(sparePart1, 1);
        spareParts1.put(sparePart2, 1);
        assignment1.setSpareParts(spareParts1);

        assignment1.setWorktime(4);

        // ------------------ engineer2 add sparepart to assignment2 - Repairfile 1
        // ------------------
        Assignment assignment2 = engineer2.getAssignments().get(0);

        HashMap<SparePart, Integer> spareParts2 = new HashMap<>();
        spareParts2.put(sparePart3, 1);
        assignment2.setSpareParts(spareParts2);

        assignment2.setWorktime(4);

        // ------------------ engineer1 add sparepart to assignment2 - Repairfile 2
        // ------------------
        Assignment assignment3 = engineer1.getAssignments().get(1);

        HashMap<SparePart, Integer> spareParts3 = new HashMap<>();

        spareParts3.put(sparePart4, 4);
        spareParts3.put(sparePart5, 4);
        spareParts3.put(sparePart6, 1);
        assignment3.setSpareParts(spareParts3);

        assignment3.setWorktime(16);

        // ------------------ supervisor ------------------
        supervisorEngineer
                .callRecordTotalSparePartsFromRepairfile(RepairfileCatalog.fetchRepairfilebyVehicle("KTR4456"));

        supervisorEngineer
                .callRecordTotalSparePartsFromRepairfile(RepairfileCatalog.fetchRepairfilebyVehicle("NIK3745"));

        // ------------------ PRINT STATISTICS ------------------
        System.out.println("Total Catalog contents:");
        JobCatalog.printData();
        SparePartsCatalog.printData();
        RepairfileCatalog.printData();
        AppointmentCatalog.printData();
        CustomerCatalog.printData();
        VehicleCatalog.printData();
        EngineerCatalog.printData();

        Owner owner = new Owner("owner", "owner");
//        TEXT MENU

        int testerChoice = Processes.options(0);
        while(testerChoice != 0){
            System.out.println();
            System.out.println("TEXT MENU");
            System.out.println();

            switch (testerChoice){
                case 1:
                    System.out.println("---------- Owner ----------");
                    System.out.println();

                    ownerMenu(owner);
                    break;
                case 2:
                    System.out.println("---------- Secretary ----------");
                    System.out.println();

                    secretaryMenu();
                    break;
                case 3:
                    System.out.println("---------- Reception Engineer ----------");
                    System.out.println();

                    receptionEngineerMenu();
                    break;
                case 4:
                    System.out.println("---------- Supervisor Engineer ----------");
                    System.out.println();

                    supervisorEngineerMenu();
                    break;
                case 5:
                    System.out.println("---------- Engineer ----------");
                    System.out.println();

                    EngineerMenu();
                    break;
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
        System.exit(0);
    }

    private static void secretaryMenu() {
        Secretary secretaryObject = null;
        int userInputCode; // secretary menu
        Scanner in = new Scanner(System.in);
        boolean notFound;
        int secretaryChoice;

        String secretaryUserName;
        // Secretary log in
        do {
            System.out.print("Secretary surname: ");
            secretaryUserName = in.nextLine();
            notFound = true;
            for (Secretary sec : Secretary.secretaryList) {
                if (secretaryUserName.equalsIgnoreCase(sec.getSurname())) {
                    secretaryObject = sec;
                    notFound = false;
                    break;
                }
            }

            if (notFound) {
                System.out.println("Secretary does not exist.");
            }
        } while (notFound);

        System.out.println("Login as " + secretaryObject.getSurname() + " successful.");


        userInputCode = Processes.options(1);
        while (userInputCode != 0) {
            Vehicle vehicle = null;
            Customer customer = null;
            Repairfile repairfile = null;
            String plateNumber = "";
            switch (userInputCode) {
                case 1:
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
                            vehicle = secretaryObject.searchVehicle(plateNumber);

                            if(vehicle==null)
                                System.out.println("Vehicle not found.");
                        } while (vehicle == null);
                        System.out.println("\nVehicle found. Vehicle plate successfully added to appointment.");

                    } else if (secretaryChoice == 2) {
                        vehicle = Processes.vehicleCreationProcess(1, secretaryObject);
                        System.out.println("");
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
                            customer = secretaryObject.searchCustomer(phoneNumber);

                            if(customer== null)
                                System.out.println("Customer not found.");
                        } while (customer == null);
                        System.out.println("Customer found. Customer's ID successfully added to appointment.");

                    } else if (secretaryChoice == 2) {
                        customer = Processes.customerCreationProcess(secretaryObject);
                        System.out.println("");
                    }

                    System.out.print("Give DateTime (XX/XX/XXXX - XX:XX): ");
                    String inputDatetime = in.nextLine();
                    DateTime dateTime = new DateTime(inputDatetime);

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

                    break;
                case 2:
                    System.out.println();
                    vehicle = Processes.vehicleCreationProcess(1, secretaryObject);
                    System.out.println();
                    break;
                case 3:
                    System.out.println();
                    customer = Processes.customerCreationProcess(secretaryObject);
                    System.out.println();
                    break;
                case 4:
                    // εμφάνιση όλων των φακέλων επισκευής και αναζήτηση με βάση τον αριθμό πινακίδας για
                    // να δεί η γραμματεί εάν ο φάκελος του οχήματος είναι Pending, δηλαδή περιμένει
                    // απάντηση του πελάτη για συνέχεια η τέλος της διαδικασίας επισκευής.
                    System.out.println();


                    System.out.print("Change RepairFile Status:");


                    RepairfileCatalog.printData();

                    System.out.println("\nSearch repair files that await customer's answer with vehicle plate number:");
                    boolean proceed = true;
                    do {
                        System.out.print("Enter Vehicle plate number or enter Exit to abandon search: ");
                        plateNumber = in.nextLine();
                        repairfile = secretaryObject.searchRepairfile(plateNumber);

                        if(plateNumber=="Exit"){
                            proceed = true;
                        }

                        if(!plateNumber.equals("Exit")){
                            if(repairfile==null){
                                System.out.println("\nNo repair file found with such vehicle plate number.");
                                proceed = false;
                            }
                            else if (repairfile.getStatus()!="Awaiting") {
                                System.out.println("\nRepair file found but its status is not Awaiting.");
                                proceed = false;
                            }
                        }
                    } while (proceed == false);

                    if(!plateNumber.equals("Exit")){
                        System.out.println("Repairfile found. Awaiting customer's answer.");

                        System.out.println("\nChange repairfile status to Accepted (1)/Declined (0)");
                        int choice = Processes.checkInputData(0, 1);
                        if(choice == 1)
                            repairfile.setStatus("Accepted");
                        else
                            repairfile.setStatus("Declined");

                        System.out.println("\nRepairfile status has been changed.\n");
                    }
                    break;

                case 5:
                    System.out.println("\nPrint repair file by entering the corresponding vehicle plate number");

                    System.out.print("Enter Vehicle plate number: ");
                    plateNumber = in.nextLine();

                    repairfile = secretaryObject.searchRepairfile(plateNumber);

                    if (repairfile == null) {
                        System.out.println("Reparifile not found.");
                    } else {
                        System.out.printf("\n> Repair File:\n%-25s %-10s  %-13s  %-10s  %-8s  %-14s  %-4s\n",
                                "Repair duration in days", "Status",
                                "Plate number", "Type", "Est Jobs", "Assignments", "Total Cost");
                        repairfile.printData();
                    }
                    break;

                case 6:
                    AppointmentCatalog.printData();
                    System.out.println();
                    break;

                case 7:
                    System.out.printf("\nSelect Appointment to update:\n" +
                                    "n %-25s  %-15s  %-14s  %-20s  %-20s  %-20s  %-20s\n",
                            "Date","Name", "Surname", "Phone number", "Vehicle Plate", "Brand", "Type");
                    ArrayList<Appointment> unfinishedAppointments = new ArrayList<Appointment>();
                    int i = 1;
                    for(Appointment appointment : AppointmentCatalog.fetchAppointments()) {
                        if (appointment.getCustomerId().equals("") || appointment.getVehiclePlateNumber().equals("")) {
                            unfinishedAppointments.add(appointment);
                            System.out.printf("%d", i);
                            appointment.printData();
                            i++;
                        }
                    }

                    System.out.printf("\nChoose appointment number or choose 0 to Exit\n");
                    int appointmentChoice = Processes.checkInputData(0,i);

                    if(appointmentChoice == 0){
                        break;
                    }

                    Appointment chosenAppointment = unfinishedAppointments.get(--appointmentChoice);
                    System.out.printf("n %-25s  %-15s  %-14s  %-20s  %-20s  %-20s  %-20s\n",
                            "Date","Name", "Surname", "Phone number", "Vehicle Plate", "Brand", "Type");
                    ++appointmentChoice;
                    System.out.printf("%d", appointmentChoice);
                    chosenAppointment.printData();
                    System.out.printf("\n");

                    secretaryChoice = -1;
                    while(secretaryChoice!=0) {
                        //both customer and vehicle are missing
                        if (chosenAppointment.getCustomerId().equals("") && chosenAppointment.getVehiclePlateNumber().equals("")) {
                            System.out.println("Add Customer - 1");
                            System.out.println("Add Vehicle - 2");
                            System.out.println("Exit - 0");

                            secretaryChoice = Processes.checkInputData(0, 2);

                            switch ((secretaryChoice)) {
                                case 0:
                                    break;

                                case 1:
                                    System.out.printf("\nGive customer phone number: ");
                                    String phoneNumber = in.nextLine();
                                    customer = CustomerCatalog.fetchCustomerByPhoneNumber(phoneNumber);
                                    if (customer == null){
                                        System.out.printf("\nCustomer not found in catalogs. Provide customer details to create a new customer.\n");
                                        customer = Processes.customerCreationProcess(secretaryObject);
                                    }
                                    chosenAppointment.setCustomerId(customer.getId());

                                    System.out.printf("\nAppointment updated:\n" +
                                                    "n %-25s  %-15s  %-14s  %-20s  %-20s  %-20s  %-20s\n",
                                            "Date","Name", "Surname", "Phone number", "Vehicle Plate", "Brand", "Type");
                                    System.out.printf("%d", appointmentChoice);
                                    chosenAppointment.printData();
                                    break;

                                case 2:
                                    System.out.printf("\nGive vehicle plate number: ");
                                    String platenumber = in.nextLine();

                                    vehicle = VehicleCatalog.fetchVehicleByPlateNumber(platenumber);
                                    if (vehicle == null) {
                                        System.out.printf("\nVehicle not found in catalogs. Provide vehicle details to create a new customer.\n");
                                        vehicle = Processes.vehicleCreationProcess(1, secretaryObject);
                                    }

                                    chosenAppointment.setVehiclePlateNumber(vehicle.getPlateNumber());

                                    System.out.printf("\nAppointment updated:\n" +
                                                    "n %-25s  %-15s  %-14s  %-20s  %-20s  %-20s  %-20s\n",
                                            "Date","Name", "Surname", "Phone number", "Vehicle Plate", "Brand", "Type");
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
                                    System.out.printf("\nGive customer phone number: ");
                                    String phoneNumber = in.nextLine();
                                    customer = CustomerCatalog.fetchCustomerByPhoneNumber(phoneNumber);
                                    if (customer == null){
                                        customer = Processes.customerCreationProcess(secretaryObject);
                                    }

                                    chosenAppointment.setCustomerId(customer.getId());

                                    System.out.printf("\nAppointment updated:\n" +
                                                    "n %-25s  %-15s  %-14s  %-20s  %-20s  %-20s  %-20s\n",
                                            "Date","Name", "Surname", "Phone number", "Vehicle Plate", "Brand", "Type");
                                    System.out.printf("%d", appointmentChoice);
                                    chosenAppointment.printData();
                                    break;
                            }
                        }
                        else if(!chosenAppointment.getCustomerId().equals("") && chosenAppointment.getVehiclePlateNumber().equals("")){
                            //only vehicle is missing
                            System.out.println("Add Vehicle - 1");
                            System.out.println("Exit - 0");

                            secretaryChoice = Processes.checkInputData(0, 1);

                            switch ((secretaryChoice)) {
                                case 0:
                                    break;

                                case 1:
                                    System.out.printf("\nGive vehicle plate number: ");
                                    String platenumber = in.nextLine();

                                    vehicle = VehicleCatalog.fetchVehicleByPlateNumber(platenumber);
                                    if (vehicle == null) {
                                        System.out.printf("\nVehicle not found in catalogs. Provide vehicle details to create a new customer.\n");
                                        vehicle = Processes.vehicleCreationProcess(1, secretaryObject);
                                    }

                                    chosenAppointment.setVehiclePlateNumber(vehicle.getPlateNumber());

                                    System.out.printf("\nAppointment updated:\n" +
                                                    "n %-25s  %-15s  %-14s  %-20s  %-20s  %-20s  %-20s\n",
                                            "Date","Name", "Surname", "Phone number", "Vehicle Plate", "Brand", "Type");
                                    System.out.printf("%d", appointmentChoice);
                                    chosenAppointment.printData();
                                    break;
                            }
                        }
                        else{
                            System.out.printf("\n");
                            System.out.println("Exit - 0");
                            secretaryChoice = Processes.checkInputData(0, 1);
                        }
                    }
            }
            userInputCode = Processes.options(1);
        }
    }

    private static void receptionEngineerMenu() {
        ReceptionEngineer receptionEngineerObject = null;

        int userInputCode; // engineer menu
        Scanner in = new Scanner(System.in);
        boolean notFound;
        int engineerChoice;

        String engineerUserSurmame;
        // Reception engineer log in
        do {
            System.out.print("Reception Engineer surname: ");
            engineerUserSurmame = in.nextLine();
            notFound = true;
            for (Engineer eng : EngineerCatalog.fetchEngineers()) {
                if (engineerUserSurmame.equalsIgnoreCase(eng.surname) && eng.getRole().equalsIgnoreCase("reception")) {
                    receptionEngineerObject = (ReceptionEngineer) eng;
                    notFound = false;
                    break;
                }
            }

            if (notFound) {
                System.out.println("No Reception Engineer with such surname exists.");
            }
        } while (notFound);

        System.out.println("Login as " + receptionEngineerObject.getSurname() + " successful.");

        System.out.println();

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


                            vehicle = receptionEngineerObject.searchVehicle(plateNumber);

                            if(vehicle == null) {
                                System.out.println();
                                System.out.println("Vehicle not found.");
                                System.out.println("Search vehicle - 1");
                                System.out.println("Create vehicle - 2");
                                System.out.println("Exit - 0");

                                engineerChoice = Processes.checkInputData(0, 2);
                            }else{
                                engineerChoice = -1;
                            }
                        }

                        if (engineerChoice == 2){
                            vehicle = Processes.vehicleCreationProcess(2, receptionEngineerObject);
                        }else if (engineerChoice == 1){
                            System.out.println("Vehicle found.");
                            System.out.println();

                            Repairfile repairfile = RepairfileCatalog.fetchRepairfilebyVehicle(plateNumber);
                            if (repairfile != null){
                                if (repairfile.getStatus().equals("Completed")){
                                    System.out.println("Repairfile already exist.");
                                }
                            }
                        }else if(engineerChoice == 0){
                            break;
                        }

                        int job = 0;
                        ArrayList<Job> jobs = new ArrayList<Job>();

                        do {
                            System.out.println("\nChoose a Job (1,2,ect...): ");
                            // Emfanisi ton doyleioyn

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
                        System.out.print("\n");
                        receptionEngineerObject.createRepairFile(vehicle, jobs, estDays);

                        in.nextLine(); //to consume plateNumber enter character after in.nextLine();
                }
            }

            userInputCode = Processes.options(2);
        }
    }

    private static void supervisorEngineerMenu() {
        SupervisorEngineer supervisorEngineerObject = null;

        int userInputCode; // engineer menu
        Scanner in = new Scanner(System.in);
        boolean notFound;
        int engineerChoice;

        String engineerUserName;
        // supervisor log in
        do {
            System.out.print("Supervisor Engineer surname: ");
            engineerUserName = in.nextLine();
            notFound = true;
            for (Engineer eng : EngineerCatalog.fetchEngineers()) {
                if (engineerUserName.equalsIgnoreCase(eng.getSurname())
                        && eng.getRole().equalsIgnoreCase("supervisor")) {
                    supervisorEngineerObject = (SupervisorEngineer) eng;
                    notFound = false;
                    break;
                }
            }

            if (notFound) {
                System.out.println("No Supervisor Engineer with such surname exists.");
            }
        } while (notFound);

        System.out.println("Login as " + supervisorEngineerObject.getSurname() + " successful.");


        Vehicle vehicle;

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
                                System.out.print("Enter Vehicle plate number: ");
                                plateNumber = in.nextLine();
                                repairfile = supervisorEngineerObject.searchRepairfile(plateNumber);
                            } while (repairfile == null);

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

                            while (done != true && repairfileChoice!=0) {
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
                            System.out.print("\nEnter Vehicle plate number: ");
                            do{
                                plateNumber = in.nextLine();
                                repairfile = supervisorEngineerObject.searchRepairfile(plateNumber);
                            }while(repairfile == null);

                            boolean repairCompleted = true;

                            for (Assignment assignment : repairfile.getAssignments()) {
                                if (!assignment.getStatus()) {
                                    repairCompleted = false;
                                    break;
                                }
                            }

                            if(repairCompleted == false) {
                                System.out.println("\nRepair is not yet done for this vehicle.\n");
                            }
                            else if (repairfile.getStatus().equals("Completed")){
                                System.out.println("Repairfile status is already <<Completed>>.");
                            }
                            else{
                                System.out.println("Repairs completed. Change repair status to <<Completed>> ? (1 - Yes, 0 - No)");
                                int answer = Processes.checkInputData(0, 1);
                                if(answer == 1) {
                                    repairfile.setStatus("Completed");
                                    System.out.println("Repairfile status has been changed.");
                                }
                            }

                            break;
                    }
                }
        }
            System.out.println("");

    }

    public static void EngineerMenu() {
        Engineer EngineerObject = null;

        int userInputCode; // engineer menu
        Scanner in = new Scanner(System.in);
        boolean notFound;
        int engineerChoice;
        int counter;

        String engineerUserName;
        // engineer log in
        do {
            System.out.print("Engineer surname: ");
            engineerUserName = in.nextLine();
            notFound = true;
            for (Engineer eng : EngineerCatalog.fetchEngineers()) {
                if (engineerUserName.equalsIgnoreCase(eng.getSurname()) && eng.getRole().equalsIgnoreCase("engineer")) {
                    EngineerObject = eng;
                    notFound = false;
                    break;
                }
            }

            if (notFound) {
                System.out.println("Engineer does not exist");
            }
        } while (notFound);

        System.out.println("Login as " + EngineerObject.getSurname() + " successful");


        userInputCode = Processes.options(4);

        while (userInputCode != 0) {
            switch (userInputCode) {
                case 1:

                    if(EngineerObject.getAssignments().isEmpty()){
                        System.out.println("\nNo Jobs assigned at the momment.");
                        break;
                    }

                    System.out.printf("|%-20s|%-20s |%-10s |%-15s\n", "Plate Number", "Job name", "Work Time", "Status");
                    for (Assignment assignment : EngineerObject.getAssignments()) {
                        System.out.printf("|%-20s|%-20s |%-10s |%-15s\n",assignment.getRepairfile().getVehicle().getPlateNumber(), assignment.getJob().getName(), assignment.getWorktime(),assignment.getStatus());
                    }
                    break;
                case 2:

                    if(EngineerObject.getAssignments().isEmpty()){
                        System.out.println("\nNo Jobs assigned at the momment.");
                        break;
                    }

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
                    Assignment currentAssignment = EngineerObject.getAssignments().get(engineerChoice - 1);
                    HashMap<SparePart, Integer> spareParts = new HashMap<SparePart, Integer>();

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

                        engineerSparePartChoice = Processes.checkInputData(0,counter);

                        if(engineerSparePartChoice==0)
                            break;

                        SparePart sparePart = SparePartsCatalog.fetchSpareParts().get(engineerSparePartChoice - 1);

                        System.out.println("Number of sparePart used");

                        numberOfSparePart = Processes.checkInputData(1, sparePart.getAvailableQuantity());

                        sparePart.setAvailableQuantity(sparePart.getAvailableQuantity() - numberOfSparePart);

                        spareParts.put(sparePart, numberOfSparePart);
                        System.out.println("Do you want to add more spareParts ?");
                        System.out.println("1 : Yes / 2 : No");

                        engineerChoice = Processes.checkInputData(1, 2);

                    } while (engineerChoice == 1);

                    if(engineerSparePartChoice==0)
                        break;

                    currentAssignment.setSpareParts(spareParts);

                    System.out.println("Set Work Time");
                    System.out.print("your choice: ");
                    assignmentWorktime = in.nextInt();

                    currentAssignment.setWorktime(assignmentWorktime);

                    currentAssignment.setStatus(true);
                    EngineerObject.getAssignments().remove(currentAssignment);

                    break;
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

                if (engineerChoice == 0){
                    break;
                }

                engineer = EngineerCatalog.fetchEngineers().get(engineerChoice - 1);

                System.out.println("Set new role: ");
                System.out.println("Reception - 1 / Supervisor - 2 / Engineer - 3");
                System.out.print("you choice: ");

                int role = in.nextInt();
                switch (role){
                    case 1:
                        owner.changeRole(engineer,"reception");
                        break;
                    case 2:
                        owner.changeRole(engineer,"supervisor");
                        break;
                    case 3:
                        owner.changeRole(engineer,"engineer");
                        break;
                }
                break;
        }
    }
}