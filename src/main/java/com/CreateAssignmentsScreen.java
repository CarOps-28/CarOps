package com;

import com.carops.Assignment;
import com.carops.Engineer;
import com.carops.Job;
import com.carops.Repairfile;
import com.catalogs.EngineerCatalog;
import com.catalogs.RepairfileCatalog;
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
import java.util.HashMap;

public class CreateAssignmentsScreen {
    @FXML
    private AnchorPane background;
    @FXML
    private AnchorPane messageBox;
    @FXML
    private Text messageBoxText;
    @FXML
    private Button closeBtn;
    @FXML
    private TextField jobNumber, engineerId, engineer1, engineer2, engineer3, engineer4, engineer5;

    @FXML
    private Button goBackBtn,setAssignment ;

    @FXML
    private TableView<TempJobObject> jobTable;
    @FXML
    private TableColumn<TempJobObject, String> tableJobNumber, jobName;
    private ObservableList<TempJobObject> jobsModel;
    private ArrayList<TempJobObject> temp = new ArrayList<>();
    private TextField[] engineersNameFields;

    private HashMap<Job, Boolean> jobs = new HashMap<>();
    @FXML
    void mouseClicked(MouseEvent event) throws IOException {

        if (event.getSource() == goBackBtn){
            StartScreenController.sceneGenerator("SupervisorScreenController-view.fxml", event, "Supervisor Screen");
        }
        else if (event.getSource() == setAssignment) {
            Engineer engineer = EngineerCatalog.fetchEngineerById(engineerId.getText());
            Job job = SupervisorScreenController.r.getJobs().get(Integer.parseInt(jobNumber.getText()) - 1);
            Repairfile rp = SupervisorScreenController.r;

            for (Engineer eng : EngineerCatalog.fetchEngineers()){
                for (Assignment ass : eng.getAssignments()){
                    if (ass.getJob().getName().equals(job.getName()) && ass.getRepairfile().getVehicle().getPlateNumber().equals(rp.getVehicle().getPlateNumber())){
                        jobs.put(job, true);
                    }
                }
            }
            if (!jobs.get(job)){
                jobs.put(job, true);
                StartScreenController.supervisorEngineer.createAssignment(engineer,job,rp);
                messageBoxText.setText("Successfully added.");
                RepairfileCatalog.save();
                EngineerCatalog.save();

            }else{
                messageBoxText.setText("Assignment has been already created.");
            }
            background.setDisable(true);
            messageBox.setVisible(true);

        } else if (event.getSource() == closeBtn){
            messageBox.setVisible(false);
            background.setDisable(false);
        }
    }
    public void loadAppointmentToTable(){

        int i = 1;
        for (Job job : SupervisorScreenController.r.getJobs()){
            jobs.put(job, false);
            temp.add(new TempJobObject(job.getName(), job.getPrice(), job.getDescription(),new CheckBox()));
            temp.get(i - 1).setId(String.valueOf(i));
            i ++;
        }

        jobsModel = FXCollections.observableArrayList(temp);

        tableJobNumber.setCellValueFactory(new PropertyValueFactory<>("Id"));
        jobName.setCellValueFactory(new PropertyValueFactory<>("Name"));

        jobTable.setItems(jobsModel);

        engineersNameFields = new TextField[]{ engineer1, engineer2, engineer3, engineer4, engineer5 };
        i = 0;
        for (Engineer eng : EngineerCatalog.fetchEngineers()){
            engineersNameFields[i].setText(eng.getId() + " - " + eng.getSurname());
            i++;
        }

    }

    @FXML
    void initialize() {
        assert background != null : "fx:id=\"background\" was not injected: check your FXML file 'VehicleCreationScreen-view.fxml'.";

        assert goBackBtn != null : "fx:id=\"goBackBtn\" was not injected: check your FXML file 'CreateAssignmentsScreen-view.fxml'.";
        assert setAssignment != null : "fx:id=\"setAssignment\" was not injected: check your FXML file 'CreateAssignmentsScreen-view.fxml'.";

        // Job Table
        assert jobTable != null : "fx:id=\"jobTable\" was not injected: check your FXML file 'CreateAssignmentsScreen-view.fxml'.";
        assert jobName != null : "fx:id=\"jobName\" was not injected: check your FXML file 'CreateAssignmentsScreen-view.fxml'.";
        assert tableJobNumber != null : "fx:id=\"tableJobNumber\" was not injected: check your FXML file 'CreateAssignmentsScreen-view.fxml'.";

        // Engineer fields
        assert engineerId != null : "fx:id=\"engineerId\" was not injected: check your FXML file 'CreateAssignmentsScreen-view.fxml'.";
        assert engineer1 != null : "fx:id=\"engineer1\" was not injected: check your FXML file 'CreateAssignmentsScreen-view.fxml'.";
        assert engineer2 != null : "fx:id=\"engineer2\" was not injected: check your FXML file 'CreateAssignmentsScreen-view.fxml'.";
        assert engineer3 != null : "fx:id=\"engineer3\" was not injected: check your FXML file 'CreateAssignmentsScreen-view.fxml'.";
        assert engineer4 != null : "fx:id=\"engineer4\" was not injected: check your FXML file 'CreateAssignmentsScreen-view.fxml'.";
        assert engineer5 != null : "fx:id=\"engineer5\" was not injected: check your FXML file 'CreateAssignmentsScreen-view.fxml'.";
        assert jobNumber != null : "fx:id=\"jobNumber\" was not injected: check your FXML file 'CreateAssignmentsScreen-view.fxml'.";

        assert closeBtn != null : "fx:id=\"closeBtn\" was not injected: check your FXML file 'CreateAssignmentsScreen-view.fxml'.";
        assert messageBox != null : "fx:id=\"messageBox\" was not injected: check your FXML file 'CreateAssignmentsScreen-view.fxml'.";
        assert messageBoxText != null : "fx:id=\"messageBoxText\" was not injected: check your FXML file 'CreateAssignmentsScreen-view.fxml'.";

        loadAppointmentToTable();
    }
}
