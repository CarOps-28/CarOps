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
import org.jetbrains.annotations.NotNull;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ResourceBundle;

public class OwnersScreenAssignment implements Initializable {
    private ArrayList<Repairfile> repairfiles = new ArrayList<>();
    private ObservableList<AssignmStatus> assignmStatuses =  FXCollections.observableArrayList();
    @FXML
    private TableView<AssignmStatus> tableView;
    @FXML private TableColumn<AssignmStatus, String> job;
    @FXML private TableColumn<AssignmStatus, String> vehicle;
    @FXML private TableColumn<AssignmStatus, String> vehicleId;
    @FXML private TableColumn<AssignmStatus, String> status;

    public OwnersScreenAssignment() {
        repairfiles = (ArrayList<Repairfile>) RepairfileCatalog.fetchRepairfiles();


        for (Repairfile rp : repairfiles) {
            String vmodel = rp.getVehicle().getModel();
            String vid = rp.getVehicle().getPlateNumber();
            for (Job j : rp.getJobs()) {
                assignmStatuses.add(new AssignmStatus(j.getName(), vmodel, vid, "NAN"));
            }
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        job.setCellValueFactory(new PropertyValueFactory<AssignmStatus, String>("job"));
        vehicle.setCellValueFactory(new PropertyValueFactory<AssignmStatus, String>("vehicle"));
        vehicleId.setCellValueFactory(new PropertyValueFactory<AssignmStatus, String>("vehicleId"));
        status.setCellValueFactory(new PropertyValueFactory<AssignmStatus, String>("status"));

        tableView.getItems().setAll(assignmStatuses);

    }

    public class AssignmStatus{
        private String job;
         private String vehicle;
         private String vehicleId;
         private String status;

        public AssignmStatus(String job, String vehicle, String vehicleId, String status) {
            this.job = job;
            this.vehicle = vehicle;
            this.vehicleId = vehicleId;
            this.status = status;
        }

        public String getJob() {
            return job;
        }


        public String getvehicle() {
            return vehicle;
        }


        public String getVehicleId() {
            return vehicleId;
        }


        public String getStatus() {
            return status;
        }

    }

}
