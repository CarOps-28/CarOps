package com.carops;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

public class Main extends Application {
//    Create GUI
    @Override
    public void start(Stage stage) throws IOException {

        Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("start-screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), visualBounds.getWidth() * 0.7, visualBounds.getHeight() * 0.7);
        stage.setTitle("CarOps Information System");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        // Create objects here
        // create secretary
        LinkedList<Secretary> sec = new LinkedList<>();
        LinkedList<Engineer> eng = new LinkedList<>();
        sec.add(new Secretary("@sec1", "Johana", "Ajax"));
        sec.add(new Secretary("@sec2", "John", "super apt update"));
        // steps tha a secretary may follow to create a vehicle
        Secretary.createVehicle("2YFZ101", "TOYOTA", "90Turbo", 1989, "Vehicle");
        Secretary.createVehicle("2YD601", "Lincoln", "Wyoming", 2008, "Vehicle");
        Secretary.createVehicle("IX0495", "Land", "LandRover Range Rover HSE", 2014, "Vehicle");
        Secretary.createTruck("SQR216", "CHEVROLET", "CHEVROLETCOLORADO", 2005, "Vehicle", 159);
        // Create some engineer
        eng.add(new Engineer("@eng1", "Martha", "Caephile", ""));
        eng.add(new ReceptionEngineer("@eng2", "Edvin", "Brice", "reception"));
        eng.add(new SupervisorEngineer("@eng3", "Bruce", "Lee", "supervisor"));
        eng.add(new Engineer("@eng4", "Tome", "Cruise", ""));
        eng.add(new Engineer("@eng5", "Bill", "Chan", ""));
        // all spare parts
        SparePartsCatalog.addSparePart(new SparePart("oil package", 34, 30));
        SparePartsCatalog.addSparePart(new SparePart("oil filter", 55, 20));
        SparePartsCatalog.addSparePart(new SparePart("cabin filter", 90, 30));
        SparePartsCatalog.addSparePart(new SparePart("Front wheel brake pad", 44, 5));
        SparePartsCatalog.addSparePart(new SparePart("Back wheel brake pad", 22, 5));
        SparePartsCatalog.addSparePart(new SparePart("Break oil", 37, 10));
        // Jobs available
        //JobCatalog jobCatalog = new JobCatalog();
        JobCatalog.addJob(new Job("Oil change", 20, ""));
        JobCatalog.addJob(new Job("Cabin filter change", 5, ""));
        JobCatalog.addJob(new Job("Brake maintenance", 30, ""));
        // Create repair file catalog
        // a vehicle has many repair files,
        // a repair file has (one or more) assignments (repairs to be done)
        // A assignment also may have spare parts to be used in the repairs
        Repairfile rp1 = new Repairfile();
        sec.get(1).searchVehicle("IX0495").addRepairfiles(rp1);
        HashMap<SparePart, Integer> sparePartHashMap = new HashMap<SparePart, Integer>();

        for (int i=0; i<=3; i++) {
            sparePartHashMap.put(SparePartsCatalog.fetchSpareParts().get(i), 1);
        }
        // work time in hours
        rp1.setWorktime(24);
        rp1.addAssignment(new Assignment(0, false, sparePartHashMap));
        rp1.addJobs(JobCatalog.findJobByName("Oil change"));
        rp1.addJobs(JobCatalog.findJobByName("CaBin filtEr chaNge"));

        Repairfile rp2 = new Repairfile();
        sec.get(0).searchVehicle("2YFZ101").addRepairfiles(rp2);
        rp2.addJobs(JobCatalog.findJobByName("Brake maintenance"));
        rp2.setWorktime(48);
        HashMap<SparePart, Integer> sparePartHashMap2 = new HashMap<SparePart, Integer>();
        sparePartHashMap2.put(SparePartsCatalog.findSpareByName("Front wHeel brake pad"), 4);
        sparePartHashMap2.put(SparePartsCatalog.findSpareByName("Back wheel brake pad"), 4);
        sparePartHashMap2.put(SparePartsCatalog.findSpareByName("Break oil"), 1);
        rp2.addAssignment(new Assignment(0, false, sparePartHashMap2));

        RepairfileCatalog.addRepairfile(rp1);
        RepairfileCatalog.addRepairfile(rp2);
        // PRINT STATISTICS
        JobCatalog.printData();
        SparePartsCatalog.printData();
        RepairfileCatalog.printData();

        launch();
    }
}