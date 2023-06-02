package com.carops;

import java.io.IOException;
import java.util.ArrayList;
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
        Secretary tampouris = new Secretary( "Efthimios", "Tampouris");
        System.out.println("New Secretary Tampouris has been created");
        System.out.println();

        Secretary mantas = new Secretary( "Mixail", "Mantas");
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
        ReceptionEngineer vergidis = new ReceptionEngineer( "Konstantinos", "Vergidis", "reception");
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

        Customer customer1 = tampouris.searchCustomer("6996986610");
        Vehicle vehicle3 = tampouris.searchVehicle("KTR4456");

        tampouris.createAppointment(customer1.getId(), vehicle3.getPlateNumber(), new DateTime("16/7/2024 - 15:00"));
        System.out.println("New Appointment with customer: " + customer1.getId() + " has been created");
        System.out.println();

        Customer customer2 = tampouris.searchCustomer("1234567893");
        Vehicle vehicle4 = tampouris.searchVehicle("NIK3745");
        tampouris.createAppointment(customer2.getId(), vehicle3.getPlateNumber(), new DateTime("16/7/2024 - 16:00"));
        System.out.println("New Appointment with customer: " + customer1.getId() + " has been created");
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

        Engineer engineer2 = new Engineer( "Tom", "Cruise", "engineer");
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

        engineer1.addSpaceParts(assignment1, sparePart1, 1);
        engineer1.addSpaceParts(assignment1, sparePart2, 1);
        engineer1.setAssignmentWorktime(assignment1, 4);

        // ------------------ engineer2 add sparepart to assignment2 - Repairfile 1
        // ------------------
        Assignment assignment2 = engineer2.getAssignments().get(0);
        engineer2.addSpaceParts(assignment2, sparePart3, 1);
        engineer2.setAssignmentWorktime(assignment2, 4);

        // ------------------ engineer1 add sparepart to assignment2 - Repairfile 2
        // ------------------
        Assignment assignment3 = engineer1.getAssignments().get(1);
        engineer1.addSpaceParts(assignment3, sparePart4, 4);
        engineer1.addSpaceParts(assignment3, sparePart5, 4);
        engineer1.addSpaceParts(assignment3, sparePart6, 1);
        engineer1.setAssignmentWorktime(assignment3, 16);

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

        System.out.println("TEXT MENU");
        System.out.println();

        System.out.println("---------- SECRETARY ----------");
        System.out.println();

        secretaryMenu();

        System.out.println("---------- Reception Engineer ----------");
        System.out.println();

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
            System.out.print("Secretary user name: ");
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
                System.out.println("Secretary do not exist");
            }
        } while (notFound);

        System.out.println("Login as " + secretaryObject.getSurname() + " successful");

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
                    do{
                        System.out.println("your choice: ");
                        secretaryChoice = in.nextInt();
                    }while (secretaryChoice < 0 || secretaryChoice > 3);

                    if (secretaryChoice == 0) {
                        break;
                    }

                    if (secretaryChoice == 1) {
                        do {
                            System.out.println("Enter vehicle plateNumber: ");
                            plateNumber = in.nextLine();
                            vehicle = secretaryObject.searchVehicle(plateNumber);
                        } while (vehicle == null);

                    } else if (secretaryChoice == 2) {
                        vehicle = Processes.vehicleCreationProcess(1, secretaryObject);
                    }

                    System.out.println("Search Customer - 1");
                    System.out.println("Make Customer - 2");
                    System.out.println("Appointment without Customer - 3");
                    System.out.println("Exit - 0");

                    do {
                        System.out.println("your choice: ");
                        secretaryChoice = in.nextInt();
                    }while(secretaryChoice < 0 || secretaryChoice > 3);

                    if (secretaryChoice == 0) {
                        break;
                    }

                    if (secretaryChoice == 1) {
                        do {
                            System.out.println("Enter Customer phone: ");
                            String phoneNumber = in.nextLine();
                            customer = secretaryObject.searchCustomer(phoneNumber);
                        } while (customer == null);

                    } else if (secretaryChoice == 2) {
                        customer = Processes.customerCreationProcess(secretaryObject);
                    }

                    System.out.println("Give DateTime (XX/XX/XXXX - XX:XX)");
                    String inputDatetime = in.nextLine();
                    DateTime dateTime = new DateTime(inputDatetime);

                    if (vehicle == null && customer == null) {
                        secretaryObject.createAppointment("", "", dateTime);
                    } else if (vehicle == null) {
                        secretaryObject.createAppointment(customer.getPhoneNumber(), "", dateTime);
                    } else if (customer == null) {
                        secretaryObject.createAppointment("", vehicle.getPlateNumber(), dateTime);
                    } else {
                        secretaryObject.createAppointment(customer.getPhoneNumber(), vehicle.getPlateNumber(),
                                dateTime);
                    }
                    System.out.println("New Appointment has been created");
                    break;
                case 2:
                    vehicle = Processes.vehicleCreationProcess(1, secretaryObject);
                    break;
                case 3:
                    customer = Processes.customerCreationProcess(secretaryObject);
                    break;
                case 4:
                    System.out.println("Change RepairFile Status");

                    System.out.println("Enter Vehicle plate number");
                    plateNumber = in.nextLine();

                    repairfile = secretaryObject.searchRepairfile(plateNumber);

                    if (repairfile == null) {
                        System.out.println("Reparifile not found");
                    } else {
                        System.out.println("Change repairfile status to (Accepted/Declined) :");
                        String choice = in.nextLine();
                        repairfile.setStatus(choice);
                    }
                    break;
                case 5:
                    System.out.println("Print repairfile");

                    System.out.println("Enter Vehicle plate number");
                    plateNumber = in.nextLine();

                    repairfile = secretaryObject.searchRepairfile(plateNumber);

                    if (repairfile == null) {
                        System.out.println("Reparifile not found");
                    } else {
                        repairfile.printData();
                    }
                    break;
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

        String engineerUserName;
        // Secretary log in
        do {
            System.out.print("Engineer user name: ");
            engineerUserName = in.nextLine();
            notFound = true;
            for (Engineer eng : EngineerCatalog.fetchEngineers()) {
                if (engineerUserName.equalsIgnoreCase(eng.getName()) && eng.getRole().equalsIgnoreCase("reception")) {
                    receptionEngineerObject = (ReceptionEngineer) eng;
                    notFound = false;
                    break;
                }
            }

            if (notFound) {
                System.out.println("Engineer do not exist");
            }
        } while (notFound);

        System.out.println("Login as " + receptionEngineerObject.getSurname() + " successful");

        System.out.println();

        userInputCode = Processes.options(2);
        while (userInputCode != 0) {
            Vehicle vehicle = null;
            String plateNumber = "";
            int estDays = 0;

            if (userInputCode == 1) {

                System.out.println("Search vehicle - 1");
                System.out.println("Exit - 0");
                do {
                    System.out.println("your choice: ");
                    engineerChoice = in.nextInt();
                }while(engineerChoice != 0 && engineerChoice!= 1);

                if (engineerChoice == 0) {
                    break;
                }

                System.out.println("Vehicle plate number: ");
                plateNumber = in.nextLine();

                vehicle = receptionEngineerObject.searchVehicle(plateNumber);

                if (vehicle == null) {
                    System.out.println("Vehicle not found.");
                    System.out.println();
                    System.out.println("Create vehicle - 2");
                    System.out.println("Exit - 0");

                    do{
                        System.out.println("your choice: ");
                        engineerChoice = in.nextInt();
                    }while(engineerChoice != 0 && engineerChoice != 2);

                    if (engineerChoice == 0) {
                        break;
                    }

                    vehicle = Processes.vehicleCreationProcess(2, receptionEngineerObject);
                }

                int job = 0;
                ArrayList<Job> jobs = new ArrayList<Job>();

                do {
                    System.out.println("add Job");
                    System.out.println("Choose a Job (1,2,ect...)");
                    // Emfanisi ton doyleioyn

                    int counter = 1;
                    for(Job jb : JobCatalog.fetchJobs()){
                        if(!jobs.contains(jb)){
                            System.out.println(counter + ") " + jb.getName());
                        }
                        counter ++;
                    }

                    System.out.println("stop adding jobs - 0");

                    System.out.println("your choice: ");
                    job = in.nextInt();

                    for (int i = 0; i < JobCatalog.fetchJobs().size(); i++) {
                        if (job == (i + 1)) {
                            jobs.add(JobCatalog.fetchJobs().get(i));
                        }
                    }


                } while (job != 0);

                System.out.println("add estimated hours: ");
                estDays = in.nextInt();

                receptionEngineerObject.createRepairFile(vehicle,jobs,estDays);

            }

            userInputCode = Processes.options(2);
        }
    }

    private static void supervisorEngineerMenu(){
        ReceptionEngineer supervisorEngineerObject = null;

        int userInputCode; // engineer menu
        Scanner in = new Scanner(System.in);
        boolean notFound;
        int engineerChoice;

        String engineerUserName;
        // Secretary log in
        do {
            System.out.print("Engineer user name: ");
            engineerUserName = in.nextLine();
            notFound = true;
            for (Engineer eng : EngineerCatalog.fetchEngineers()) {
                if (engineerUserName.equalsIgnoreCase(eng.getName()) && eng.getRole().equalsIgnoreCase("supervisor")) {
                    supervisorEngineerObject = (ReceptionEngineer) eng;
                    notFound = false;
                    break;
                }
            }

            if (notFound) {
                System.out.println("Engineer do not exist");
            }
        } while (notFound);

        System.out.println("Login as " + supervisorEngineerObject.getSurname() + " successful");

        System.out.println();


        userInputCode = Processes.options(3);
        while (userInputCode != 0) {
            int repairfileChoice;
            String plateNumber = "";
            Repairfile repairfile = null;
            int jobNumber, engineerNumber;

            System.out.println("Search vehicle by plateNumber - 1");
            System.out.println("Exit - 0");

            do {
                System.out.println("your choice: ");
                engineerChoice = in.nextInt();
            } while (engineerChoice != 0 && engineerChoice != 1);

            System.out.println("Vehicle plateNumber: ");
            plateNumber = in.nextLine();

            repairfile = supervisorEngineerObject.searchRepairfile(plateNumber);

            ArrayList<Engineer> engineers = new ArrayList<>();
            ArrayList<Job> jobs = repairfile.getJobs();

            System.out.println("------------ Set job to engineer ------------");

            do {

                for (Job job : jobs) {
                    engineers.add(null);
                }

                System.out.println("Available engineers:");
                int counter = 1;

                for (Engineer engineer : EngineerCatalog.fetchEngineers()) {
                    System.out.println(counter + ") " + engineer.getName());
                    counter++;
                }
                System.out.println();

                System.out.println("Repairfile Jobs:");
                counter = 1;
                for (Job job : jobs) {
                    if (engineers.get(counter - 1) != null) {
                        System.out.println(counter + ") " + job.getName() + " -> " + engineers.get(counter - 1).getName());
                    } else {
                        System.out.println(counter + ") " + job.getName());
                    }
                    counter++;
                }

                System.out.println("set job to engineer - 1");
                System.out.println("add new job - 2");
                repairfileChoice = in.nextInt();

                if (repairfileChoice == 1) {
                    System.out.println("Choose Job (1,2...)");
                    jobNumber = in.nextInt();

                    System.out.println("Choose engineer (1,2...)");
                    engineerNumber = in.nextInt();

                    counter = 1;

                    for (Job job : jobs) {
                        if (counter == jobNumber) {
                            int counterEng = 1;
                            for (Engineer engineer : EngineerCatalog.fetchEngineers()) {
                                if (engineerNumber == counterEng) {
                                    engineers.add(counterEng - 1, engineer);
                                }
                                counterEng++;
                            }

                        }
                        counter++;
                    }


                }

                if (repairfileChoice == 2) {
                    counter = 1;
                    for (Job job : JobCatalog.fetchJobs()) {
                        if (!jobs.contains(job)) {
                            System.out.println(counter + ") " + job.getName());
                        }
                    }
                    System.out.println("add a job: ");
                    int jobNum = in.nextInt();

                    for (int i = 0; i < JobCatalog.fetchJobs().size(); i++) {
                        if (jobNum == i) {
                            jobs.add(JobCatalog.fetchJobs().get(i));
                        }
                    }
                }

            }while (engineers.contains(null)); // maybe error

            userInputCode = Processes.options(3);
        }
    }
}