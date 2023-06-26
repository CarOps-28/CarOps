package com;

import com.catalogs.CustomerCatalog;
import com.catalogs.VehicleCatalog;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class VehicleCreationScreen {


    private Stage stage;
    private Parent root;


    @FXML
    private AnchorPane background;

    @FXML
    private TextField vehiclePlatenumber, vehicleBrand, vehicleModel, vehicleProdYear, vehicleType;
    @FXML
    private TextField vehicleTypeValue;

    public Button goBackBtn, vehicleCreationBtn, closeBtn;
    public AnchorPane messageBox;
    public Text messageBoxText;

    @FXML
    public Text plateNumberErr, brandErr, modelErr, prodYearErr, vehicleTypeErr;

    private String errorMessage = "Invalid Vehicle fields.";
    private void sceneGenerator(String Screen_Name, MouseEvent event, String Screen_Title) throws IOException {
        root = FXMLLoader.load(getClass().getResource(Screen_Name));

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.getScene().setRoot(root);
        stage.setHeight(700);
        stage.setWidth(900);
        stage.setTitle(Screen_Title);
        stage.show();
    }


    @FXML
    void mouseClicked(MouseEvent event) throws IOException {
        if (event.getSource() == goBackBtn){
            sceneGenerator("SecretaryScreenController-view.fxml", event, "Secretary Screen");
        }else if (event.getSource() == vehicleCreationBtn){

            if( checkInputFields() ){
                closeBtn.setBackground(Background.fill(Color.GREEN));
                closeBtn.setStyle("-fx-text-fill: white;");
                messageBoxText.setText("Successfully created.");

                StartScreenController.secretary.createVehicle(vehiclePlatenumber.getText(),vehicleBrand.getText(),vehicleModel.getText(), Integer.parseInt(vehicleProdYear.getText()),vehicleType.getText(), Float.parseFloat(vehicleTypeValue.getText()));
                VehicleCatalog.save();
            }else{
                closeBtn.setBackground(Background.fill(Color.RED));
                closeBtn.setStyle("-fx-text-fill: white;");
                messageBoxText.setText(errorMessage);

                errorMessage = "Invalid Vehicle fields.";
            }
            messageBoxText.setStyle("-fx-text-fill: white;");

            background.setDisable(true);

            messageBox.setVisible(true);
        }else if (event.getSource() == closeBtn){
            messageBox.setVisible(false);
            background.setDisable(false);
        }
    }

    private void emptyTextFields(){
        vehicleBrand.setText("");
        vehicleBrand.setText("");
        vehicleModel.setText("");
        vehicleProdYear.setText("");
        vehicleType.setText("");
        vehicleTypeValue.setText("");

        messageBoxText.setText("");
    }

    private boolean checkInputFields(){
        boolean flag = true;
        errorMessage = "Invalid Customer fields.";

        if (vehiclePlatenumber.getText().equals("") ) { plateNumberErr.setText("* this field cannot be empty."); flag = false; }
        else { plateNumberErr.setText("*"); }

        if (vehicleBrand.getText().equals("") ) { brandErr.setText("* this field cannot be empty."); flag = false; }
        else { brandErr.setText("*"); }

        if (vehicleModel.getText().equals("") ) { modelErr.setText("* this field cannot be empty."); flag = false; }
        else { modelErr.setText("*"); }

        if (vehicleProdYear.getText().equals("") ) { prodYearErr.setText("* this field cannot be empty."); flag = false; }
        else { prodYearErr.setText("*"); }

        if (vehicleType.getText().equals("") ) { vehicleTypeErr.setText("* this field cannot be empty."); flag = false; }
        else if ( !vehicleType.getText().equalsIgnoreCase("Vehicle") && !vehicleType.getText().equalsIgnoreCase("Truck") && !vehicleType.getText().equalsIgnoreCase("Motorcycle"))
        { vehicleTypeErr.setText("* this field must be 'Vehicle'/'Truck'/'Motorcycle'" ); flag = false; }
        else { vehicleTypeErr.setText("*"); }

        if ( VehicleCatalog.fetchVehicleByPlateNumber(vehiclePlatenumber.getText()) != null){ errorMessage = "Vehicle already exist."; flag = false; }

        return flag;
    }

    @FXML
    void initialize() {
        assert background != null : "fx:id=\"background\" was not injected: check your FXML file 'VehicleCreationScreen-view.fxml'.";
        
        assert goBackBtn != null : "fx:id=\"goBackBtn\" was not injected: check your FXML file 'VehicleCreationScreen-view.fxml'.";
        assert vehiclePlatenumber != null : "fx:id=\"vehiclePlatenumber\" was not injected: check your FXML file 'VehicleCreationScreen-view.fxml'.";
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

        goBackBtn.setBackground(Background.fill(Color.RED));
        goBackBtn.setStyle("-fx-text-fill: white;");

        vehicleCreationBtn.setBackground(Background.fill(Color.GREEN));
        vehicleCreationBtn.setStyle("-fx-text-fill: white;");

        vehicleTypeValue.setText("0");
    }


}