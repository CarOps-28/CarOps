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

        Secretary mantas = new Secretary("Mixail", "Mantas");
        System.out.println("New Secretary Mantas has been created");
        System.out.println();
        // ---------------------------------------- Create Customer
        // ----------------------------------------

        tampouris.createCustomer("Dimitra", "Tzhka", "1234567890", "tzhka@gmail.com", "t12345");
        System.out.println("New Customer Tzhka has been created");
        System.out.println();

        tampouris.createCustomer("Vasileios", "Tsolakidis", "6996986610", "bill@gmail.com", "t12346");
        System.out.println("New Customer Tsolakidis has been created");
        System.out.println();

        tampouris.createCustomer("Dimitris", "Foulidis", "1234567893", "jimmy@gmail.com", "t12347");
        System.out.println("New Customer Foulidis has been created");
        System.out.println();

        tampouris.createCustomer("Erjola", "Hajdari", "1234567894", "eri@gmail.com", "t12348");
        System.out.println("New Customer Hajdari has been created");
        System.out.println();

        tampouris.createCustomer("Vasileios", "Xamalidis", "1234567895", "bill2@gmail.com", "t12349");
        System.out.println("New Customer Xamalidis has been created");
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
        vergidis.createVehicle("NIK3745", "Land", "LandRover Range Rover HSE", 2014, "Car", 0);
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

        //blank appointment for testing
        tampouris.createAppointment("","", new DateTime("13/13/1222 - 12:20"));

        //appointment 1
        Customer customer1 = tampouris.searchCustomer("6996986610");
        Vehicle vehicle3 = tampouris.searchVehicle("KTR4456");

        tampouris.createAppointment(customer1.getId(), vehicle3.getPlateNumber(), new DateTime("16/7/2024 - 15:00"));
        System.out.println("New Appointment with customer: " + customer1.getId() + " has been created");
        System.out.println();

        //appointment 2
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
        SupervisorEngineer supervisorEngineer = new SupervisorEngineer("Bruce", "Lee", "supervisor");
        System.out.println("New supervisorEngineer Lee has been created");
        System.out.println();

        // ------------------ Create Engineers ------------------
        Engineer engineer1 = new Engineer("Martha", "Caephile", "engineer");
        System.out.println("New Engineer Caephile has been created");
        System.out.println();

        Engineer engineer2 = new Engineer("Tom", "Cruise", "engineer");
        System.out.println("New Engineer Cruise has been created");
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
        // launch();

        System.out.println();
        System.out.println("TEXT MENU");
        System.out.println();

        System.out.println("---------- SECRETARY ----------");
        System.out.println();

        secretaryMenu();

        System.out.println("---------- Reception Engineer ----------");
        System.out.println();

        receptionEngineerMenu();

        System.out.println("---------- Supervisor Engineer ----------");
        System.out.println();

        supervisorEngineerMenu();

        System.out.println("---------- Engineer ----------");
        System.out.println();

        EngineerMenu();

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
                System.out.println("Secretary do not exist.");
            }
        } while (notFound);

        System.out.println("Login as " + secretaryObject.getSurname() + " successful.");

        System.out.println();

        userInputCode = Processes.options(1);
        while (userInputCode != 0) {
            Vehicle vehicle = null;
            Customer customer = null;
            Repairfile repairfile = null;
            String plateNumber = "";
            switch (userInputCode) {
                case 1:
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
                        } while (vehicle == null);
                        System.out.println("Vehicle found");
                    } else if (secretaryChoice == 2) {
                        vehicle = Processes.vehicleCreationProcess(1, secretaryObject);
                    }

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
                        } while (customer == null);

                    } else if (secretaryChoice == 2) {
                        customer = Processes.customerCreationProcess(secretaryObject);
                        System.out.println("Customer has been created");
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
                    System.out.println();

                    break;
                case 2:
                    vehicle = Processes.vehicleCreationProcess(1, secretaryObject);
                    break;
                case 3:
                    customer = Processes.customerCreationProcess(secretaryObject);
                    break;
                case 4:
                    System.out.println("Change RepairFile Status.");

                    do {
                        System.out.print("Enter Vehicle plate number: ");
                        plateNumber = in.nextLine();
                        repairfile = secretaryObject.searchRepairfile(plateNumber);
                    } while (repairfile == null);

                    System.out.println("Repairfile found");

                    System.out.print("Change repairfile status to (Accepted/Declined): ");
                    String choice = in.nextLine();
                    repairfile.setStatus(choice);

                    System.out.print("Repairfile status has been changed.");

                    break;
                case 5:
                    System.out.println("Print repairfile.");

                    System.out.print("Enter Vehicle plate number: ");
                    plateNumber = in.nextLine();

                    repairfile = secretaryObject.searchRepairfile(plateNumber);

                    if (repairfile == null) {
                        System.out.println("Reparifile not found.");
                    } else {
                        System.out.printf("\n> Repair File:\nn %-25s  %-10s  %-13s  %-10s  %-8s  %-8s  %-4s\n",
                                "Repair duration in days", "Status",
                                "Plate number", "Type", "Est Jobs", "Assign J", "Total Cost");
                        repairfile.printData();
                        System.out.println();
                    }
                    break;

                case 6:
                    AppointmentCatalog.printData();
                    break;

                case 7:
                    System.out.printf("\nSelect Appointment to update:\n" +
                                    "n %-25s  %-15s  %-14s  %-20s  %-20s  %-20s  %-20s\n",
                            "Date","Name", "Surname", "Phone number", "Vehicle Plate", "Brand", "type");
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

                    System.out.printf("\nChoose appointment number: ");
                    int appointmentChoice = in.nextInt();
                    Appointment chosenAppointment = unfinishedAppointments.get(--appointmentChoice);
                    System.out.printf("n %-25s  %-15s  %-14s  %-20s  %-20s  %-20s  %-20s\n",
                            "Date","Name", "Surname", "Phone number", "Vehicle Plate", "Brand", "type");
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
                                    System.out.printf("\n");
                                    customer = Processes.customerCreationProcess(secretaryObject);
                                    chosenAppointment.setCustomerId(customer.getId());

                                    System.out.printf("\nAppointment updated:\n" +
                                                    "n %-25s  %-15s  %-14s  %-20s  %-20s  %-20s  %-20s\n",
                                            "Date","Name", "Surname", "Phone number", "Vehicle Plate", "Brand", "type");
                                    System.out.printf("%d", appointmentChoice);
                                    chosenAppointment.printData();
                                    break;

                                case 2:
                                    System.out.printf("\n");
                                    vehicle = Processes.vehicleCreationProcess(1, secretaryObject);
                                    chosenAppointment.setVehiclePlateNumber(vehicle.getPlateNumber());

                                    System.out.printf("\nAppointment updated:\n" +
                                                    "n %-25s  %-15s  %-14s  %-20s  %-20s  %-20s  %-20s\n",
                                            "Date","Name", "Surname", "Phone number", "Vehicle Plate", "Brand", "type");
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
                                    System.out.printf("\n");
                                    customer = Processes.customerCreationProcess(secretaryObject);
                                    chosenAppointment.setCustomerId(customer.getId());

                                    System.out.printf("\nAppointment updated:\n" +
                                                    "n %-25s  %-15s  %-14s  %-20s  %-20s  %-20s  %-20s\n",
                                            "Date","Name", "Surname", "Phone number", "Vehicle Plate", "Brand", "type");
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
                                    System.out.printf("\n");
                                    vehicle = Processes.vehicleCreationProcess(1, secretaryObject);
                                    chosenAppointment.setVehiclePlateNumber(vehicle.getPlateNumber());

                                    System.out.printf("\nAppointment updated:\n" +
                                                    "n %-25s  %-15s  %-14s  %-20s  %-20s  %-20s  %-20s\n",
                                            "Date","Name", "Surname", "Phone number", "Vehicle Plate", "Brand", "type");
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
        // Secretary log in
        do {
            System.out.print("Engineer surname: ");
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
                System.out.println("Engineer do not exist");
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

                if (engineerChoice == 0) {
                    break;
                }

                System.out.println();
                do {
                    System.out.print("Enter vehicle plateNumber: ");
                    plateNumber = in.nextLine();
                    vehicle = receptionEngineerObject.searchVehicle(plateNumber);
                } while (vehicle == null);
                System.out.println("Vehicle found");

                System.out.println("Vehicle not found.");
                System.out.println();
                System.out.println("Create vehicle - 2");
                System.out.println("Exit - 0");

                engineerChoice = Processes.checkInputData(0, 2);

                if (engineerChoice == 0) {
                    break;
                }

                vehicle = Processes.vehicleCreationProcess(2, receptionEngineerObject);

                int job = 0;
                ArrayList<Job> jobs = new ArrayList<Job>();

                do {
                    System.out.println("Choose a Job (1,2,ect...): ");
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

                System.out.print("add estimated hours: ");
                estDays = in.nextInt();

                receptionEngineerObject.createRepairFile(vehicle, jobs, estDays);

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
        // Secretary log in
        do {
            System.out.print("Engineer surname: ");
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
                System.out.println("Engineer do not exist.");
            }
        } while (notFound);

        System.out.println("Login as " + supervisorEngineerObject.getSurname() + " successful.");

        System.out.println();
        Vehicle vehicle;

        userInputCode = Processes.options(3);
        while (userInputCode != 0) {
            int repairfileChoice;
            String plateNumber = "";
            Repairfile repairfile = null;
            int jobNumber, engineerNumber;

            switch (userInputCode) {
                case 1:

                    System.out.println();
                    System.out.println("Search vehicle by plateNumber - 1");
                    System.out.println("Exit - 0");

                    engineerChoice = Processes.checkInputData(0, 1);

                    if (engineerChoice == 0) {
                        break;
                    }

                    do {
                        System.out.print("Enter Vehicle plate number: ");
                        plateNumber = in.nextLine();
                        repairfile = supervisorEngineerObject.searchRepairfile(plateNumber);
                    } while (repairfile == null);

                    ArrayList<Engineer> engineers = new ArrayList<>();
                    ArrayList<Job> jobs = repairfile.getJobs();

                    System.out.println();
                    System.out.println("------------ Set job to engineer ------------");

                    for (Job job : jobs) {
                        engineers.add(null);
                    }

                    do {

                        System.out.println("Available engineers:");

                        int counter = 1;
                        for (Engineer engineer : EngineerCatalog.fetchEngineers()) {
                            System.out.println(counter + ") " + engineer.getName() + " " + engineer.getSurname());
                            counter++;
                        }
                        System.out.println();

                        System.out.println("Repairfile Jobs:");

                        counter = 1;
                        for (Job job : jobs) {
                            if (engineers.get(counter - 1) != null) {
                                System.out.println(
                                        counter + ") " + job.getName() + " -> "
                                                + engineers.get(counter - 1).getSurname());
                            } else {
                                System.out.println(counter + ") " + job.getName());
                            }
                            counter++;
                        }

                        System.out.println();
                        System.out.println("Set job to engineer - 1");
                        System.out.println("Add new job - 2");

                        repairfileChoice = Processes.checkInputData(1, 2);

                        System.out.println();
                        if (repairfileChoice == 1) {
                            System.out.print("Choose Job (1,...): ");
                            jobNumber = in.nextInt();

                            System.out.print("Choose engineer (1,...): ");
                            engineerNumber = in.nextInt();

                            engineers.add(jobNumber - 1, EngineerCatalog.fetchEngineers().get(engineerNumber - 1));

                        }

                        if (repairfileChoice == 2) {
                            counter = 1;
                            for (Job job : JobCatalog.fetchJobs()) {
                                if (!jobs.contains(job)) {
                                    System.out.println(counter + ") " + job.getName());
                                }
                            }
                            System.out.println();

                            System.out.print("Add a job: ");
                            int jobNum = in.nextInt();

                            jobs.add(JobCatalog.fetchJobs().get(jobNum));
                        }

                    } while (engineers.contains(null));
                    break;
                case 2:
                    boolean found = true;

                    do {

                        System.out.println("Enter Vehicle plate number");
                        System.out.println("Exit - 0");

                        plateNumber = in.nextLine();
                        if (plateNumber.equals("0")) {
                            break;
                        }
                        repairfile = supervisorEngineerObject.searchRepairfile(plateNumber);

                        for (Assignment assignment : repairfile.getAssignments()) {
                            if (!assignment.getStatus()) {
                                System.out.println("Repairfile not found");
                                found = false;
                                break;
                            }
                        }

                    } while (!found);

                    System.out.println("Change repairfile status: 'Completed': ");
                    String status = in.nextLine();

                    repairfile.setStatus(status);

                    break;
            }

        }
        userInputCode = Processes.options(3);
    }

    public static void EngineerMenu() {
        Engineer EngineerObject = null;

        int userInputCode; // engineer menu
        Scanner in = new Scanner(System.in);
        boolean notFound;
        int engineerChoice;
        int counter;

        String engineerUserName;
        // Secretary log in
        do {
            System.out.print("Engineer user name: ");
            engineerUserName = in.nextLine();
            notFound = true;
            for (Engineer eng : EngineerCatalog.fetchEngineers()) {
                if (engineerUserName.equalsIgnoreCase(eng.getName()) && eng.getRole().equalsIgnoreCase("engineer")) {
                    EngineerObject = eng;
                    notFound = false;
                    break;
                }
            }

            if (notFound) {
                System.out.println("Engineer do not exist");
            }
        } while (notFound);

        System.out.println("Login as " + EngineerObject.getSurname() + " successful");

        System.out.println();

        userInputCode = Processes.options(4);

        while (userInputCode != 0) {
            switch (userInputCode) {
                case 1:
                    for (Assignment assignment : EngineerObject.getAssignments()) {
                        assignment.printData();
                    }
                    break;
                case 2:
                    System.out.println("Choose assignment");
                    counter = 1;

                    for (Assignment assignment : EngineerObject.getAssignments()) {
                        String plateNumber = assignment.getRepairfile().getVehicle().getPlateNumber();
                        System.out.println(counter + ") Car: " + plateNumber + " with assignment: "
                                + assignment.getJob().getName());
                        counter++;
                    }
                    System.out.println("Exit - 0");

                    engineerChoice = Processes.checkInputData(0, counter);

                    if (engineerChoice == 0) {
                        break;
                    }

                    int engineerSparePartChoice, numberOfSparePart, assignmentWorktime;
                    Assignment currentAssignment = EngineerObject.getAssignments().get(engineerChoice - 1);
                    HashMap<SparePart, Integer> spareParts = new HashMap<SparePart, Integer>();

                    do {
                        System.out.println("Choose sparePart");
                        System.out.printf("\n> Spare Parts:\nn %-25s  |%-4s %10s\n", "Name", "A-Q", "Price per unit");
                        for (SparePart sparePart : SparePartsCatalog.fetchSpareParts()) {
                            if (!spareParts.containsKey(spareParts)) {
                                sparePart.printData();
                            }
                        }

                        System.out.print("your choice: ");
                        engineerSparePartChoice = in.nextInt();

                        SparePart sparePart = SparePartsCatalog.fetchSpareParts().get(engineerSparePartChoice);

                        System.out.println("Set number of sparePart");

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

                    currentAssignment.setWorktime(assignmentWorktime);

                    currentAssignment.setStatus(true);

                    break;
            }

            userInputCode = Processes.options(4);
        }
    }
}