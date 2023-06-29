package com;

import com.carops.*;
import com.catalogs.CustomerCatalog;
import com.catalogs.VehicleCatalog;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import java.io.IOException;

public class SecretaryScreenController {

    private final ObservableList<Customer> customersModel = FXCollections.observableArrayList(CustomerCatalog.fetchCustomers());
    private final ObservableList<Vehicle> vehiclesModel = FXCollections.observableArrayList(VehicleCatalog.getVehicles());

    @FXML
    private TableView<Vehicle> vehicleTable;
    @FXML
    private TableView<Customer> customerTable;
    @FXML
    public TableColumn<Customer, String> customerEmail, customerPhoneNumber, customerSurname, customerName, customerId;
    @FXML
    public TableColumn<Vehicle, String> vehicleData, vehicleType, vehicleModel, vehicleBrand, vehiclePlateNumber, vehicleId;

    @FXML
    private Button customerCreationBtn, vehicleCreationBtn, goBackBtn, createAppointment, editAppointment;
    @FXML
    private  TextField secretaryName;

    @FXML
    void mouseClicked(MouseEvent event) throws IOException {
        if (event.getSource() == customerCreationBtn){
            StartScreenController.sceneGenerator("CustomerCreationScreen-view.fxml", event, "Customer Creation Screen");
        }else if (event.getSource() == vehicleCreationBtn){
            StartScreenController.sceneGenerator("VehicleCreationScreen-view.fxml", event, "Vehicle Creation Screen");
        }else if (event.getSource() == goBackBtn){
            StartScreenController.secretary = null;
            StartScreenController.sceneGenerator("StartScreenController-view.fxml", event, "CarOps Information System");
        }
        else if(event.getSource() == createAppointment){
            StartScreenController.sceneGenerator("AppointmentCreationScreen-view.fxml", event, "Secretary Screen");
        }else if (event.getSource() == editAppointment){
            StartScreenController.sceneGenerator("EditAppointmentScreen-view.fxml", event, "Secretary Screen");
        }
    }

    public void loadAppointmentToTable(){
        this.secretaryName.setText(StartScreenController.secretary.getSurname().toUpperCase());

        customerId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        customerName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        customerSurname.setCellValueFactory(new PropertyValueFactory<>("Surname"));
        customerPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("PhoneNumber"));
        customerEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
        customerTable.setItems(customersModel);

        vehicleId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        vehiclePlateNumber.setCellValueFactory(new PropertyValueFactory<>("PlateNumber"));
        vehicleBrand.setCellValueFactory(new PropertyValueFactory<>("Brand"));
        vehicleModel.setCellValueFactory(new PropertyValueFactory<>("Model"));
        vehicleType.setCellValueFactory(new PropertyValueFactory<>("VehicleType"));
        vehicleData.setCellValueFactory(new PropertyValueFactory<>("Value"));

        vehicleTable.setItems(vehiclesModel);

    }


    @FXML
    void initialize() {
        assert customerCreationBtn != null : "fx:id=\"customerCreationBtn\" was not injected: check your FXML file 'SecretaryScreenController-view.fxml'.";
        assert vehicleCreationBtn != null : "fx:id=\"vehicleCreationBtn\" was not injected: check your FXML file 'SecretaryScreenController-view.fxml'.";
        assert createAppointment != null : "fx:id=\"createAppointment\" was not injected: check your FXML file 'SecretaryScreenController-view.fxml'.";
        assert goBackBtn != null : "fx:id=\"goBackBtn\" was not injected: check your FXML file 'SecretaryScreenController-view.fxml'.";
        assert secretaryName != null : "fx:id=\"secretaryName\" was not injected: check your FXML file 'SecretaryScreenController-view.fxml'.";
        assert editAppointment != null : "fx:id=\"editAppointment\" was not injected: check your FXML file 'SecretaryScreenController-view.fxml'.";

        // Customer Table
        assert customerTable != null : "fx:id=\"customerTable\" was not injected: check your FXML file 'SecretaryScreenController-view.fxml'.";
        assert customerId != null : "fx:id=\"customerId\" was not injected: check your FXML file 'SecretaryScreenController-view.fxml'.";
        assert customerName != null : "fx:id=\"customerName\" was not injected: check your FXML file 'SecretaryScreenController-view.fxml'.";
        assert customerSurname != null : "fx:id=\"customerSurname\" was not injected: check your FXML file 'SecretaryScreenController-view.fxml'.";
        assert customerPhoneNumber != null : "fx:id=\"customerPhoneNumber\" was not injected: check your FXML file 'SecretaryScreenController-view.fxml'.";
        assert customerEmail != null : "fx:id=\"customerEmail\" was not injected: check your FXML file 'SecretaryScreenController-view.fxml'.";

        // Vehicle Table
        assert vehicleTable != null : "fx:id=\"vehicleTable\" was not injected: check your FXML file 'SecretaryScreenController-view.fxml'.";
        assert vehicleId != null : "fx:id=\"vehicleId\" was not injected: check your FXML file 'SecretaryScreenController-view.fxml'.";
        assert vehiclePlateNumber != null : "fx:id=\"vehiclePlateNumber\" was not injected: check your FXML file 'SecretaryScreenController-view.fxml'.";
        assert vehicleBrand != null : "fx:id=\"vehicleBrand\" was not injected: check your FXML file 'SecretaryScreenController-view.fxml'.";
        assert vehicleModel != null : "fx:id=\"vehicleModel\" was not injected: check your FXML file 'SecretaryScreenController-view.fxml'.";
        assert vehicleType != null : "fx:id=\"vehicleType\" was not injected: check your FXML file 'SecretaryScreenController-view.fxml'.";
        assert vehicleData != null : "fx:id=\"vehicleData\" was not injected: check your FXML file 'SecretaryScreenController-view.fxml'.";
        loadAppointmentToTable();
    }


}