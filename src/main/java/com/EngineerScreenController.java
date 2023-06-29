package com;

import com.carops.Assignment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.ArrayList;

public class EngineerScreenController {
    @FXML
    private TextField assId,EngineerName;
    @FXML
    private Text assignmentIdErr;

    @FXML
    private Button goBackBtn,editAssignmentBtn ;

    @FXML
    private TableView<AssignmentObject> assignmentTable;
    @FXML
    private TableColumn<AssignmentObject, String> assignmentId, jobName,plateNumber,assignmentStatus,cost;
    private ObservableList<AssignmentObject> assignmentModel;

    private ArrayList<AssignmentObject> assObj;
    public static Assignment engineerCurrAss = null;
    @FXML
    void mouseClicked(MouseEvent event) throws IOException {

        if (event.getSource() == goBackBtn){
            StartScreenController.sceneGenerator("StartScreenController-view.fxml", event, "CarOps Information System");
        }
        else if (event.getSource() == editAssignmentBtn) {
            boolean flag = false;

            for (AssignmentObject ass : assObj){
                if (ass.getId().equals(assId.getText())){
                    flag = true;
                    break;
                }
            }

            if (flag){
                engineerCurrAss = StartScreenController.engineer.getAssignments().get( Integer.parseInt(assId.getText()) - 1);
                assignmentIdErr.setText("*");
                StartScreenController.sceneGenerator("AddSparePartsScreen-view.fxml", event, "Engineer Screen");

            }else{
                assignmentIdErr.setText("Assignment Id does not exist.");
                engineerCurrAss = null;
            }

        }
    }
    public void loadAppointmentToTable(){
        assObj = new ArrayList<>();
        int i = 1;
        for (Assignment ass : StartScreenController.engineer.getAssignments()){

            assObj.add(new AssignmentObject(String.valueOf(i),
                    ass.getRepairfile().getVehicle().getPlateNumber(),
                    ass.getJob().getName(),
                    String.valueOf(ass.getStatus()),
                    String.valueOf(ass.getRepairfile().getTotalCost())
                )
            );

            i++;
        }
        assignmentModel = FXCollections.observableArrayList(assObj);

        assignmentId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        plateNumber.setCellValueFactory(new PropertyValueFactory<>("PlateNumber"));
        jobName.setCellValueFactory(new PropertyValueFactory<>("JobName"));
        assignmentStatus.setCellValueFactory(new PropertyValueFactory<>("AssignmentStatus"));
        cost.setCellValueFactory(new PropertyValueFactory<>("Cost"));

        assignmentTable.setItems(assignmentModel);
    }

    @FXML
    void initialize() {
        assert EngineerName != null : "fx:id=\"EngineerName\" was not injected: check your FXML file 'EngineerScreenController-view.fxml'.";

        assert assId != null : "fx:id=\"assId\" was not injected: check your FXML file 'EngineerScreenController-view.fxml'.";

        // table
        assert assignmentTable != null : "fx:id=\"assignmentTable\" was not injected: check your FXML file 'EngineerScreenController-view.fxml'.";
        assert assignmentId != null : "fx:id=\"assignmentId\" was not injected: check your FXML file 'EngineerScreenController-view.fxml'.";
        assert plateNumber != null : "fx:id=\"plateNumber\" was not injected: check your FXML file 'EngineerScreenController-view.fxml'.";
        assert jobName != null : "fx:id=\"jobName\" was not injected: check your FXML file 'EngineerScreenController-view.fxml'.";
        assert assignmentStatus != null : "fx:id=\"assignmentStatus\" was not injected: check your FXML file 'EngineerScreenController-view.fxml'.";
        assert cost != null : "fx:id=\"cost\" was not injected: check your FXML file 'EngineerScreenController-view.fxml'.";

        assert editAssignmentBtn != null : "fx:id=\"editAssignmentBtn\" was not injected: check your FXML file 'EngineerScreenController-view.fxml'.";
        assert goBackBtn != null : "fx:id=\"goBackBtn\" was not injected: check your FXML file 'EngineerScreenController-view.fxml'.";
        assert assignmentIdErr != null : "fx:id=\"assignmentIdErr\" was not injected: check your FXML file 'EngineerScreenController-view.fxml'.";

        EngineerName.setText(StartScreenController.engineer.getSurname().toUpperCase());

        loadAppointmentToTable();

    }
}
