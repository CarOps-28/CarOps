package com;

import com.carops.SparePart;
import com.carops.Vehicle;
import com.catalogs.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class AddSparePartsScreenView {

    @FXML
    private AnchorPane background, messageBox;
    @FXML
    private TextField hours, jobName;
    @FXML
    private Text messageBoxText;
    @FXML
    private Button closeBtn,completedAss,goBackBtn;

    @FXML
    private TableView<TempJobObject> sparePartTable;
    @FXML
    private TableColumn<TempJobObject, String> TableSparePartName, price,amount;
    @FXML
    private TableColumn<TempJobObject, CheckBox> partCheckBox;
    private ObservableList<TempJobObject> sparePartModel;
    private ArrayList<TempJobObject> temp = new ArrayList<>();

    Vehicle v = null;
    @FXML
    void mouseClicked(MouseEvent event) throws IOException {
        if (event.getSource() == goBackBtn){
            StartScreenController.sceneGenerator("EngineerScreenController-view.fxml", event, "CarOps Information System");
        }else if (event.getSource() == completedAss) {

            HashMap<SparePart, Integer> spareParts = new HashMap<>();

            for (int i =0; i< temp.size(); i++){
                if(temp.get(i).getCheckBox().isSelected()){

                    spareParts.put(SparePartsCatalog.findSpareByName(temp.get(i).getName()), Integer.getInteger(temp.get(i).getAmount()));

                }
            }

            if (!hours.getText().equals("")){
                messageBoxText.setText("Successfully created.");
                background.setDisable(true);
                messageBox.setVisible(true);

                EngineerScreenController.engineerCurrAss.setSpareParts(spareParts);

                StartScreenController.engineer.setAssignmentWorktime(EngineerScreenController.engineerCurrAss, Integer.parseInt(hours.getText()));
                StartScreenController.engineer.setAssignmentStatus(EngineerScreenController.engineerCurrAss,true);


                RepairfileCatalog.save();
                EngineerCatalog.save();
                SparePartsCatalog.save();

            }

            if (hours.getText().equals("")){
                messageBoxText.setText("Hours cannot be empty.");
                messageBox.setVisible(true);
                background.setDisable(true);

            }

        }else if (event.getSource() == closeBtn){
            messageBox.setVisible(false);
            background.setDisable(false);
        }
    }
    public void loadAppointmentToTable(){

        for (SparePart sp : SparePartsCatalog.fetchSpareParts()){
            temp.add(new TempJobObject(sp.getName(), sp.getPrice(), new CheckBox(), "0"));
        }

        sparePartModel = FXCollections.observableArrayList(temp);

        TableSparePartName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        price.setCellValueFactory(new PropertyValueFactory<>("Price"));
        partCheckBox.setCellValueFactory(new PropertyValueFactory<>("CheckBox"));
        amount.setCellValueFactory(new PropertyValueFactory<>("Amount"));

        sparePartTable.setItems(sparePartModel);

    }

    private void editableCols(){
        amount.setCellFactory(TextFieldTableCell.forTableColumn());
        amount.setOnEditCommit(e->e.getTableView().getItems().get(e.getTablePosition().getRow()).setId(e.getNewValue()));

        sparePartTable.setEditable(true);
    }

    @FXML
    void initialize() {
        assert background != null : "fx:id=\"background\" was not injected: check your FXML file 'AddSparePartsScreen-view.fxml'.";
        assert messageBox != null : "fx:id=\"messageBox\" was not injected: check your FXML file 'AddSparePartsScreen-view.fxml'.";

        assert goBackBtn != null : "fx:id=\"goBackBtn\" was not injected: check your FXML file 'AddSparePartsScreen-view.fxml'.";
        assert jobName != null : "fx:id=\"jobName\" was not injected: check your FXML file 'AddSparePartsScreen-view.fxml'.";
        assert hours != null : "fx:id=\"hours\" was not injected: check your FXML file 'AddSparePartsScreen-view.fxml'.";

        // SparePart Table
        assert sparePartTable != null : "fx:id=\"sparePartTable\" was not injected: check your FXML file 'AddSparePartsScreen-view.fxml'.";
        assert TableSparePartName != null : "fx:id=\"TableSparePartName\" was not injected: check your FXML file 'AddSparePartsScreen-view.fxml'.";
        assert price != null : "fx:id=\"price\" was not injected: check your FXML file 'AddSparePartsScreen-view.fxml'.";
        assert partCheckBox != null : "fx:id=\"partCheckBox\" was not injected: check your FXML file 'AddSparePartsScreen-view.fxml'.";
        assert amount != null : "fx:id=\"amount\" was not injected: check your FXML file 'AddSparePartsScreen-view.fxml'.";


        assert completedAss != null : "fx:id=\"completedAss\" was not injected: check your FXML file 'AddSparePartsScreen-view.fxml'.";

        jobName.setText(EngineerScreenController.engineerCurrAss.getJob().getName().toUpperCase());
        loadAppointmentToTable();

        editableCols();
    }
}
