package com.carops;

import java.io.IOException;
import java.util.ArrayList;

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

        // Create Vehicles by tampouris
        tampouris.createVehicle("KTR4456", "TOYOTA", "90Turbo", 1989, "Truck", 500);

        // Create Reception Engineer.
        ReceptionEngineer vergidis = new ReceptionEngineer("MHX1", "Konstantinos", "Vergidis", "reception");

        // Crete Vehicles by vergidis
        vergidis.createVehicle("NIK3745", "Land", "LandRover Range Rover HSE", 2014, "Vehicle", 0);

        // 3 job objects
        Job job1 = new Job("Oil change", 20, "");
        Job job2 = new Job("Cabin filter change", 5, "");
        Job job3 = new Job("Brake maintenance", 30, "");

        // 6 spareParts Objects
        SparePart sparePart1 = new SparePart("Oil package 4lt", 34, 30);
        SparePart sparePart2 = new SparePart("Oil filter", 55, 20);
        SparePart sparePart3 = new SparePart("Cabin filter", 90, 30);
        SparePart sparePart4 = new SparePart("Front wheel brake pad", 44, 5);
        SparePart sparePart5 = new SparePart("Back wheel brake pad", 22, 5);
        SparePart sparePart6 = new SparePart("Break oil", 37, 10);

        // 2 Repairfile Objects

        Vehicle vehicle1 = vergidis.searchVehicle("KTR4456");

        ArrayList<Job> estJobs1 = new ArrayList<>();
        estJobs1.add(job1);
        estJobs1.add(job2);
        vergidis.createRepairFile(vehicle1, estJobs1, 8);

        // 2 Repairfile Objects
        Vehicle vehicle2 = vergidis.searchVehicle("NIK3745");

        ArrayList<Job> estJobs2 = new ArrayList<>();
        estJobs1.add(job3);
        vergidis.createRepairFile(vehicle2, estJobs1, 16);


        // Add assignments

        // Create Supervisor engineer
        SupervisorEngineer supervisorEngineer = new SupervisorEngineer("MHX2", "Bruce", "Lee", "supervisor");

        //Create Engineers
        Engineer engineer1 = new Engineer("MHX3", "Martha", "Caephile", "engineer");
        Engineer engineer2 = new Engineer("MHX4", "Tome", "Cruise", "engineer");


        // supervisor set assignments
        supervisorEngineer.createAssignment(engineer1, job1, RepairfileCatalog.fetchRepairfilebyVehicle("KTR4456"));
        supervisorEngineer.createAssignment(engineer2, job2, RepairfileCatalog.fetchRepairfilebyVehicle("KTR4456"));

        supervisorEngineer.createAssignment(engineer1, job3, RepairfileCatalog.fetchRepairfilebyVehicle("NIK3745"));
        // engineers set spareParts


        //engineer1 add sparepart to assignment2 - Repairfile 1
        Assignment assignment1 = engineer1.getAssignments().get(0);

        engineer1.addSpaceParts(assignment1, sparePart1, 1);
        engineer1.addSpaceParts(assignment1, sparePart2, 1);
        engineer1.setAssignmentWorktime(assignment1, 4);

        // engineer2 add sparepart to assignment2 - Repairfile 1
        Assignment assignment2 = engineer2.getAssignments().get(0);
        engineer2.addSpaceParts(assignment2, sparePart3, 1);
        engineer2.setAssignmentWorktime(assignment2, 4);


        // engineer1 add sparepart to assignment2 - Repairfile 2
        Assignment assignment3 = engineer1.getAssignments().get(1);
        engineer1.addSpaceParts(assignment3, sparePart4, 4);
        engineer1.addSpaceParts(assignment3, sparePart5, 4);
        engineer1.addSpaceParts(assignment3, sparePart6, 1);
        engineer1.setAssignmentWorktime(assignment3, 16);


        // supervisor
        supervisorEngineer.callRecordTotalSparePartsFromRepairfile(RepairfileCatalog.fetchRepairfilebyVehicle("KTR4456"));

        supervisorEngineer.callRecordTotalSparePartsFromRepairfile(RepairfileCatalog.fetchRepairfilebyVehicle("NIK3745"));

        // PRINT STATISTICS
        JobCatalog.printData();
        SparePartsCatalog.printData();
        RepairfileCatalog.printData();

//        launch();

    }
}