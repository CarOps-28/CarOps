package com.carops;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

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

        // Create Secretary
        Secretary tampouris = new Secretary("SEC1", "Efthimios", "Tampouris");
        System.out.println("New Secretary Tampouris has been created");
        System.out.println();

        //  ---------------------------------------- Create Customer  ----------------------------------------

        tampouris.createCustomer("Dimitra", "Tzhka", "1234567890", "tzhka@gmail.com","t12345");
        System.out.println("New Customer Tzhka has been created");
        System.out.println();

        tampouris.createCustomer("Vasileios", "Tsolakidis", "6996986610", "bill@gmail.com","t12346");
        System.out.println("New Customer Tsolakidis has been created");
        System.out.println();

        tampouris.createCustomer("Dimitris", "Foulidis", "1234567893", "jimmy@gmail.com","t12347");
        System.out.println("New Customer Foulidis has been created");
        System.out.println();

        tampouris.createCustomer("Erjola", "Hajdari", "1234567894", "eri@gmail.com","t12348");
        System.out.println("New Customer Hajdari has been created");
        System.out.println();

        tampouris.createCustomer("Vasileios", "Xamalidis", "1234567895", "bill2@gmail.com","t12349");
        System.out.println("New Customer Xamalidis has been created");
        System.out.println();

        //  ---------------------------------------- Create Vehicles by Tampouris ----------------------------------------
        tampouris.createVehicle("KTR4456", "TOYOTA", "90Turbo", 1989, "Truck", 500);
        System.out.println("New Vehicle KTR4456 has been created");
        System.out.println();

        //  ---------------------------------------- Create Reception Engineer.  ----------------------------------------
        ReceptionEngineer vergidis = new ReceptionEngineer("MHX1", "Konstantinos", "Vergidis", "reception");
        System.out.println("New ReceptionEngineer Vergidis has been created");
        System.out.println();

        //  ---------------------------------------- Crete Vehicles by Vergidis  ----------------------------------------
        vergidis.createVehicle("NIK3745", "Land", "LandRover Range Rover HSE", 2014, "Vehicle", 0);
        System.out.println("New Vehicle NIK3745 has been created");
        System.out.println();

        //  ---------------------------------------- 3 job objects  ----------------------------------------
        Job job1 = new Job("Oil change", 20, "");
        System.out.println("New Job 'Oil change' has been created");
        System.out.println();

        Job job2 = new Job("Cabin filter change", 5, "");
        System.out.println("New Job 'Cabin filter change' has been created");
        System.out.println();

        Job job3 = new Job("Brake maintenance", 30, "");
        System.out.println("New Job 'Brake maintenance' has been created");
        System.out.println();

        //  ---------------------------------------- 6 spareParts Objects  ----------------------------------------
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
        Vehicle vehicle3 = tampouris.searchVehicle("NIK3745");
        tampouris.createAppointment(customer1.getId(),vehicle3.getPlateNumber(), new Date());
        System.out.println("New Appointment with customer: "+customer1.getId() +" has been created");
        System.out.println();

        Customer customer3 = tampouris.searchCustomer("6996986610");
        Vehicle vehicle4 = tampouris.searchVehicle("NIK3745");
        tampouris.createAppointment(customer1.getId(),vehicle3.getPlateNumber(), new Date());
        System.out.println("New Appointment with customer: " + customer1.getId() +" has been created");
        System.out.println();

        // -------------- /Create appointment ------------------

        // ------------------ 2 Repairfile Objects ------------------

        Vehicle vehicle1 = vergidis.searchVehicle("KTR4456");

        ArrayList<Job> estJobs1 = new ArrayList<>();
        estJobs1.add(job1);
        estJobs1.add(job2);
        vergidis.createRepairFile(vehicle1, estJobs1, 8);
        System.out.println("New Repairfile with vehicle: "+ vehicle1.getPlateNumber() + " has been created");
        System.out.println();

        Vehicle vehicle2 = vergidis.searchVehicle("NIK3745");

        ArrayList<Job> estJobs2 = new ArrayList<>();
        estJobs1.add(job3);
        vergidis.createRepairFile(vehicle2, estJobs1, 16);
        System.out.println("New Repairfile with vehicle "+ vehicle1.getPlateNumber() + " has been created");
        System.out.println();

        // ------------------ Create Supervisor engineer ------------------
        SupervisorEngineer supervisorEngineer = new SupervisorEngineer("MHX2", "Bruce", "Lee", "supervisor");
        System.out.println("New supervisorEngineer Lee has been created");
        System.out.println();

        //------------------ Create Engineers ------------------
        Engineer engineer1 = new Engineer("MHX3", "Martha", "Caephile", "engineer");
        System.out.println("New Engineer Caephile has been created");
        System.out.println();

        Engineer engineer2 = new Engineer("MHX4", "Tome", "Cruise", "engineer");
        System.out.println("New Engineer Cruise has been created");
        System.out.println();

        //  ------------------ Add assignments ------------------
        // ------------------ supervisor set assignments ------------------
        Vehicle vehicle5 = supervisorEngineer.searchVehicle("KTR4456");

        supervisorEngineer.createAssignment(engineer1, job1, RepairfileCatalog.fetchRepairfilebyVehicle(vehicle5.getPlateNumber()));
        System.out.println("New Assignment in engineer: " + engineer1.getName() + " has been created");
        System.out.println();

        supervisorEngineer.createAssignment(engineer2, job2, RepairfileCatalog.fetchRepairfilebyVehicle(vehicle5.getPlateNumber()));
        System.out.println("New Assignment in engineer: " + engineer2.getName() + " has been created");
        System.out.println();

        Vehicle vehicle6 = supervisorEngineer.searchVehicle("NIK3745");
        supervisorEngineer.createAssignment(engineer1, job3, RepairfileCatalog.fetchRepairfilebyVehicle(vehicle6.getPlateNumber()));
        System.out.println("New Assignment in engineer: " + engineer1.getName() + " has been created");
        System.out.println();

        // ------------------ Engineers set spareParts ------------------


        // ------------------ engineer1 add sparepart to assignment2 - Repairfile 1 ------------------
        Assignment assignment1 = engineer1.getAssignments().get(0);

        engineer1.addSpaceParts(assignment1, sparePart1, 1);
        engineer1.addSpaceParts(assignment1, sparePart2, 1);
        engineer1.setAssignmentWorktime(assignment1, 4);

        // ------------------ engineer2 add sparepart to assignment2 - Repairfile 1 ------------------
        Assignment assignment2 = engineer2.getAssignments().get(0);
        engineer2.addSpaceParts(assignment2, sparePart3, 1);
        engineer2.setAssignmentWorktime(assignment2, 4);


        // ------------------ engineer1 add sparepart to assignment2 - Repairfile 2 ------------------
        Assignment assignment3 = engineer1.getAssignments().get(1);
        engineer1.addSpaceParts(assignment3, sparePart4, 4);
        engineer1.addSpaceParts(assignment3, sparePart5, 4);
        engineer1.addSpaceParts(assignment3, sparePart6, 1);
        engineer1.setAssignmentWorktime(assignment3, 16);


        // ------------------ supervisor ------------------
        supervisorEngineer.callRecordTotalSparePartsFromRepairfile(RepairfileCatalog.fetchRepairfilebyVehicle("KTR4456"));

        supervisorEngineer.callRecordTotalSparePartsFromRepairfile(RepairfileCatalog.fetchRepairfilebyVehicle("NIK3745"));

        // ------------------ PRINT STATISTICS ------------------
        JobCatalog.printData();
        SparePartsCatalog.printData();
        RepairfileCatalog.printData();

//        launch();

    }
}