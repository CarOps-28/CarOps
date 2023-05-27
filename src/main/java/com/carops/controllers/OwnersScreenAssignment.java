package com.carops.controllers;

import com.carops.Job;
import com.carops.Repairfile;
import com.carops.RepairfileCatalog;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class OwnersScreenAssignment implements Initializable {
    private ArrayList<Repairfile> repairfiles = new ArrayList<>();
    private final ObservableList<AssignmentData> ast = FXCollections.observableArrayList();

    @FXML private TableView<AssignmentData>              tableView;
    @FXML private TableColumn<AssignmentData, String>    jobID;
    @FXML private TableColumn<AssignmentData, String>    vehicleModelID;
    @FXML private TableColumn<AssignmentData, String>    vehiclePanelID;
    @FXML private TableColumn<AssignmentData, String>    statusID;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        jobID.setCellValueFactory           (new PropertyValueFactory<>("jobID"));
        vehicleModelID.setCellValueFactory  (new PropertyValueFactory<>("vehicleModelID"));
        vehiclePanelID.setCellValueFactory  (new PropertyValueFactory<>("vehiclePanelID"));
        statusID.setCellValueFactory        (new PropertyValueFactory<>("statusID"));


        repairfiles = (ArrayList<Repairfile>) RepairfileCatalog.fetchRepairfiles();
        for (Repairfile rp : repairfiles)
            for (Job j : rp.getJobs())
                ast.add(new AssignmentData(j.getName(), rp.getVehicle().getModel(), rp.getVehicle().getPlateNumber(), "NaN"));

        tableView.getItems().setAll(ast);
    }


    public class AssignmentData {
        private final String jobID;
        private final String vehicleModelID;
        private final String vehiclePanelID;
        private final String statusID;

        public AssignmentData(String jobID, String vehicleModelID, String vehiclePanelID, String statusID) {
            this.jobID =  (jobID);
            this.vehicleModelID =  (vehicleModelID);
            this.vehiclePanelID =  (vehiclePanelID);
            this.statusID =  (statusID);
        }

        public String getJobID() {
            return jobID;
        }

        public String getVehicleModelID() {
            return vehicleModelID;
        }

        public String getVehiclePanelID() {
            return vehiclePanelID;
        }

        public String getStatusID() {
            return statusID;
        }

        public String toString(){
            return jobID +", "+ vehicleModelID +", "+ vehiclePanelID +", "+ statusID +"\n";
        }

    }
}
