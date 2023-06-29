package com;

import com.carops.Job;
import com.carops.Vehicle;
import com.catalogs.JobCatalog;
import com.catalogs.RepairfileCatalog;
import com.catalogs.VehicleCatalog;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.ArrayList;

public class ReceptionScreenController {

    @FXML
    private AnchorPane background, messageBox;
    @FXML
    private TextField vehiclePlateNumber, estimatedHours;
    @FXML
    private Text plateNumberErr;
    @FXML
    private Text messageBoxText;
    @FXML
    private Button closeBtn,repairfileCreationBtn,goBackBtn,vehicleCreationBtn,searchBtn;

    @FXML
    private TableView<TempJobObject> jobTable;
    @FXML
    private TableColumn<TempJobObject, String> jobPrice, jobName;
    @FXML
    private TableColumn<TempJobObject, CheckBox>jobCheckBox;
    private ObservableList<TempJobObject> jobsModel;
    private ArrayList<TempJobObject> temp = new ArrayList<>();

    Vehicle v = null;
    @FXML
    void mouseClicked(MouseEvent event) throws IOException {
        if (event.getSource() == goBackBtn){
            StartScreenController.sceneGenerator("StartScreenController-view.fxml", event, "CarOps Information System");
        }else if (event.getSource() == vehicleCreationBtn) {
            StartScreenController.sceneGenerator("VehicleCreationScreen-view.fxml", event, "Vehicle Creation Screen");
        }else if (event.getSource() == searchBtn){

            if (!checkVehicle()){
                plateNumberErr.setText("* Vehicle does not exist.");
            }else{
                plateNumberErr.setText("* Vehicle exist!");
            }
        } else if (event.getSource() == repairfileCreationBtn) {

            ArrayList<Job> j = new ArrayList<>();

            for (int i =0; i< temp.size(); i++){
                if(temp.get(i).getCheckBox().isSelected()){

                    j.add(JobCatalog.fetchJobs().get(i));
                }
            }

            if (checkVehicle() && !estimatedHours.getText().equals("")){
                plateNumberErr.setText("*");
                messageBoxText.setText("Successfully created.");
                background.setDisable(true);
                messageBox.setVisible(true);

                StartScreenController.receptionEngineer.createRepairFile(this.v,j, Integer.parseInt(estimatedHours.getText()));

                RepairfileCatalog.save();

            }
            if (!checkVehicle()){
                plateNumberErr.setText("* Vehicle does not exist.");
            }
            if (estimatedHours.getText().equals("")){
                messageBoxText.setText("Estimated hours cannot be empty.");
                messageBox.setVisible(true);
                background.setDisable(true);

            }

        }else if (event.getSource() == closeBtn){
            messageBox.setVisible(false);
            background.setDisable(false);
        }
    }
    public void loadAppointmentToTable(){

        for (Job job : JobCatalog.fetchJobs()){
            temp.add(new TempJobObject(job.getName(), job.getPrice(), job.getDescription(),new CheckBox()));
        }

        jobsModel = FXCollections.observableArrayList(temp);

        jobName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        jobPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        jobCheckBox.setCellValueFactory(new PropertyValueFactory<>("CheckBox"));

        jobTable.setItems(jobsModel);

    }
    private boolean checkVehicle(){
        this.v = VehicleCatalog.fetchVehicleByPlateNumber(vehiclePlateNumber.getText());

        if (v == null){
            return false;
        }else{
          return true;
        }
    }
    @FXML
    void initialize() {
        assert background != null : "fx:id=\"background\" was not injected: check your FXML file 'ReceptionScreenController-view.fxml'.";
        assert messageBox != null : "fx:id=\"messageBox\" was not injected: check your FXML file 'ReceptionScreenController-view.fxml'.";

        assert goBackBtn != null : "fx:id=\"goBackBtn\" was not injected: check your FXML file 'ReceptionScreenController-view.fxml'.";
        assert vehicleCreationBtn != null : "fx:id=\"vehicleCreationBtn\" was not injected: check your FXML file 'ReceptionScreenController-view.fxml'.";
        assert searchBtn != null : "fx:id=\"searchBtn\" was not injected: check your FXML file 'ReceptionScreenController-view.fxml'.";
        assert closeBtn != null : "fx:id=\"closeBtn\" was not injected: check your FXML file 'ReceptionScreenController-view.fxml'.";

        assert plateNumberErr != null : "fx:id=\"plateNumberErr\" was not injected: check your FXML file 'ReceptionScreenController-view.fxml'.";
        assert vehiclePlateNumber != null : "fx:id=\"vehiclePlateNumber\" was not injected: check your FXML file 'ReceptionScreenController-view.fxml'.";
        assert estimatedHours != null : "fx:id=\"estimatedHours\" was not injected: check your FXML file 'ReceptionScreenController-view.fxml'.";

        // Job Table
        assert jobTable != null : "fx:id=\"jobTable\" was not injected: check your FXML file 'ReceptionScreenController-view.fxml'.";
        assert jobName != null : "fx:id=\"jobName\" was not injected: check your FXML file 'ReceptionScreenController-view.fxml'.";
        assert jobPrice != null : "fx:id=\"jobPrice\" was not injected: check your FXML file 'ReceptionScreenController-view.fxml'.";
        assert jobCheckBox != null : "fx:id=\"jobCheckBox\" was not injected: check your FXML file 'ReceptionScreenController-view.fxml'.";

        loadAppointmentToTable();
    }
}
