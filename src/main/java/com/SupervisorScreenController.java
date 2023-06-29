package com;

import com.carops.*;
import com.catalogs.JobCatalog;
import com.catalogs.RepairfileCatalog;
import com.catalogs.VehicleCatalog;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import java.io.IOException;
import java.util.ArrayList;

public class SupervisorScreenController {
    @FXML
    private TextField vehiclePlateNumber;
    @FXML
    private Text plateNumberErr;
    @FXML
    private Button moveBtn,goBackBtn,searchBtn;

    @FXML
    private TableView<TempJobObject> jobTable;
    @FXML
    private TableColumn<TempJobObject, String> jobPrice, jobName;
    @FXML
    private TableColumn<TempJobObject, CheckBox>jobCheckBox;
    private ObservableList<TempJobObject> jobsModel;
    private ArrayList<TempJobObject> temp = new ArrayList<>();

    Vehicle v = null;
    public static Repairfile r = null;
    @FXML
    void mouseClicked(MouseEvent event) throws IOException {
        if (event.getSource() == goBackBtn){
            StartScreenController.sceneGenerator("StartScreenController-view.fxml", event, "CarOps Information System");
        }
        else if (event.getSource() == searchBtn){

            if (!checkVehicle()){
                plateNumberErr.setText("* Vehicle does not exist.");
            }else{
                plateNumberErr.setText("* Vehicle exist!");
                loadAppointmentToTable();
            }

        } else if (event.getSource() == moveBtn) {
            ArrayList<Job> checkJobs = new ArrayList<>();
            for (int i =0; i< temp.size(); i++){
                if(temp.get(i).getCheckBox().isSelected()){
                    checkJobs.add(JobCatalog.fetchJobs().get(i));
                }
            }

            r.setJobs(checkJobs);

            StartScreenController.sceneGenerator("CreateAssignmentsScreen-view.fxml", event, "Supervisor Screen");
        }

    }
    public void loadAppointmentToTable(){
        int i = 0;
        for (Job job : JobCatalog.fetchJobs()){
            temp.add(new TempJobObject(job.getName(), job.getPrice(), job.getDescription(),new CheckBox()));
            for (Job rJob : r.getJobs()){
                if (rJob.getName().equals(job.getName())){
                    temp.get(i).setFired();
                }
            }
            i++;
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
        }

        for (Repairfile rp : RepairfileCatalog.fetchRepairfiles() ){
            if (rp.getVehicle().getPlateNumber().equals(v.getPlateNumber()) && !rp.getStatus().equals("Completed")){
                System.out.println(rp.getVehicle().getPlateNumber().equals(v.getPlateNumber()) + "  " +  !rp.getStatus().equals("Completed"));
                r = rp;
                return true;
            }

        }
        return false;
    }
    @FXML
    void initialize() {

        assert goBackBtn != null : "fx:id=\"goBackBtn\" was not injected: check your FXML file 'ReceptionScreenController-view.fxml'.";
        assert moveBtn != null : "fx:id=\"moveBtn\" was not injected: check your FXML file 'ReceptionScreenController-view.fxml'.";
        assert searchBtn != null : "fx:id=\"searchBtn\" was not injected: check your FXML file 'ReceptionScreenController-view.fxml'.";

        assert plateNumberErr != null : "fx:id=\"plateNumberErr\" was not injected: check your FXML file 'ReceptionScreenController-view.fxml'.";
        assert vehiclePlateNumber != null : "fx:id=\"vehiclePlateNumber\" was not injected: check your FXML file 'ReceptionScreenController-view.fxml'.";

        // Job Table
        assert jobTable != null : "fx:id=\"jobTable\" was not injected: check your FXML file 'ReceptionScreenController-view.fxml'.";
        assert jobName != null : "fx:id=\"jobName\" was not injected: check your FXML file 'ReceptionScreenController-view.fxml'.";
        assert jobPrice != null : "fx:id=\"jobPrice\" was not injected: check your FXML file 'ReceptionScreenController-view.fxml'.";
        assert jobCheckBox != null : "fx:id=\"jobCheckBox\" was not injected: check your FXML file 'ReceptionScreenController-view.fxml'.";

    }
}