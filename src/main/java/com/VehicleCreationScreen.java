package com;

import com.catalogs.VehicleCatalog;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;

public class VehicleCreationScreen {
    @FXML
    private AnchorPane background,messageBox;
    @FXML
    private TextField vehiclePlateNumber, vehicleBrand, vehicleModel, vehicleProdYear, vehicleType;
    @FXML
    private TextField vehicleTypeValue;

    public Button goBackBtn, vehicleCreationBtn, closeBtn;
    @FXML
    public Text messageBoxText, plateNumberErr, brandErr, modelErr, prodYearErr, vehicleTypeErr;
    private String errorMessage = "Invalid Vehicle fields.";

    @FXML
    void mouseClicked(MouseEvent event) throws IOException {
        if (event.getSource() == goBackBtn){
            if (StartScreenController.secretary != null) {
                StartScreenController.sceneGenerator("SecretaryScreenController-view.fxml", event, "Secretary Screen");
            }else{
                StartScreenController.sceneGenerator("ReceptionScreenController-view.fxml", event, "Reception Screen");
            }
        }else if (event.getSource() == vehicleCreationBtn){

            if( checkInputFields() ){
                messageBoxText.setText("Successfully created.");

                if (StartScreenController.secretary != null){
                    StartScreenController.secretary.createVehicle(vehiclePlateNumber.getText(),vehicleBrand.getText(),vehicleModel.getText(), Integer.parseInt(vehicleProdYear.getText()),vehicleType.getText(), Float.parseFloat(vehicleTypeValue.getText()));
                }else {
                    StartScreenController.receptionEngineer.createVehicle(vehiclePlateNumber.getText(),vehicleBrand.getText(),vehicleModel.getText(), Integer.parseInt(vehicleProdYear.getText()),vehicleType.getText(), Float.parseFloat(vehicleTypeValue.getText()));
                }
                VehicleCatalog.save();
            }else{
                messageBoxText.setText(errorMessage);

                errorMessage = "Invalid Vehicle fields.";
            }

            background.setDisable(true);

            messageBox.setVisible(true);
        }else if (event.getSource() == closeBtn){
            messageBox.setVisible(false);
            background.setDisable(false);
        }
    }

    private boolean checkInputFields(){
        boolean flag = true;
        errorMessage = "Invalid Vehicle fields.";

        if (vehiclePlateNumber.getText().equals("") ) { plateNumberErr.setText("* this field cannot be empty."); flag = false; }
        else { plateNumberErr.setText("*"); }

        if (vehicleBrand.getText().equals("") ) { brandErr.setText("* this field cannot be empty."); flag = false; }
        else { brandErr.setText("*"); }

        if (vehicleModel.getText().equals("") ) { modelErr.setText("* this field cannot be empty."); flag = false; }
        else { modelErr.setText("*"); }

        if (vehicleProdYear.getText().equals("") ) { prodYearErr.setText("* this field cannot be empty."); flag = false; }
        else { prodYearErr.setText("*"); }

        if (vehicleType.getText().equals("") ) { vehicleTypeErr.setText("* this field cannot be empty."); flag = false; }
        else if ( !vehicleType.getText().equalsIgnoreCase("Car") && !vehicleType.getText().equalsIgnoreCase("Truck") && !vehicleType.getText().equalsIgnoreCase("Motorcycle"))
        { vehicleTypeErr.setText("* this field must be 'Car'/'Truck'/'Motorcycle'" ); flag = false; }
        else { vehicleTypeErr.setText("*"); }

        if ( VehicleCatalog.fetchVehicleByPlateNumber(vehiclePlateNumber.getText()) != null){ errorMessage = "Vehicle already exist."; flag = false; }

        return flag;
    }

    @FXML
    void initialize() {
        assert background != null : "fx:id=\"background\" was not injected: check your FXML file 'VehicleCreationScreen-view.fxml'.";
        
        assert goBackBtn != null : "fx:id=\"goBackBtn\" was not injected: check your FXML file 'VehicleCreationScreen-view.fxml'.";
        assert vehiclePlateNumber != null : "fx:id=\"vehiclePlateNumber\" was not injected: check your FXML file 'VehicleCreationScreen-view.fxml'.";
        assert vehicleBrand != null : "fx:id=\"vehicleBrand\" was not injected: check your FXML file 'VehicleCreationScreen-view.fxml'.";
        assert vehicleModel != null : "fx:id=\"vehicleModel\" was not injected: check your FXML file 'VehicleCreationScreen-view.fxml'.";
        assert vehicleProdYear != null : "fx:id=\"vehicleProdYear\" was not injected: check your FXML file 'VehicleCreationScreen-view.fxml'.";
        assert vehicleType != null : "fx:id=\"vehicleType\" was not injected: check your FXML file 'VehicleCreationScreen-view.fxml'.";
        assert vehicleTypeValue != null : "fx:id=\"vehicleTypeValue\" was not injected: check your FXML file 'VehicleCreationScreen-view.fxml'.";
        assert vehicleCreationBtn != null : "fx:id=\"vehicleCreationBtn\" was not injected: check your FXML file 'VehicleCreationScreen-view.fxml'.";

        assert closeBtn != null : "fx:id=\"closeBtn\" was not injected: check your FXML file 'CustomerCreationScreen-view.fxml'.";
        assert messageBox != null : "fx:id=\"messageBox\" was not injected: check your FXML file 'CustomerCreationScreen-view.fxml'.";
        assert messageBoxText != null : "fx:id=\"messageBoxText\" was not injected: check your FXML file 'CustomerCreationScreen-view.fxml'.";


        assert plateNumberErr != null : "fx:id=\"plateNumberErr\" was not injected: check your FXML file 'CustomerCreationScreen-view.fxml'.";
        assert brandErr != null : "fx:id=\"brandErr\" was not injected: check your FXML file 'CustomerCreationScreen-view.fxml'.";
        assert modelErr != null : "fx:id=\"modelErr\" was not injected: check your FXML file 'CustomerCreationScreen-view.fxml'.";
        assert prodYearErr != null : "fx:id=\"prodYearErr\" was not injected: check your FXML file 'CustomerCreationScreen-view.fxml'.";
        assert vehicleTypeErr != null : "fx:id=\"vehicleTypeErr\" was not injected: check your FXML file 'CustomerCreationScreen-view.fxml'.";

        vehicleTypeValue.setText("0");
    }


}