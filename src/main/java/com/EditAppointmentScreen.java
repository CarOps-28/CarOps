package com;

import com.carops.Appointment;
import com.carops.Customer;
import com.catalogs.AppointmentCatalog;
import com.catalogs.CustomerCatalog;
import com.catalogs.VehicleCatalog;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EditAppointmentScreen {
    @FXML
    private TextField appointmentIdField, customerPhoneNumber, vehiclePlateNumber;
    @FXML
    private Text appointmentErr, customerErr, vehicleErr;
    @FXML
    private TableView<Appointment> appointmentTable;
    @FXML
    private TableColumn<Appointment, String> appointmentId, appointmentDate, appointmentTime, appointmentCustomer, appointmentVehicle, appointmentCost, appointmentStatus;

    @FXML
    private Button goBackBtn,changeApp;

    private ObservableList<Appointment> appointmentModel = FXCollections.observableArrayList(AppointmentCatalog.fetchAppointments());

    public void mouseClicked(MouseEvent event) throws IOException {
        if(event.getSource() == goBackBtn){
            StartScreenController.sceneGenerator("SecretaryScreenController-view.fxml", event,"Secretary Screen");
        }
        else if ( event.getSource() == changeApp){
            String ploneNumber = customerPhoneNumber.getText();
            String plateNumber = vehiclePlateNumber.getText();

            Appointment app = AppointmentCatalog.getAppointmentById(appointmentIdField.getText());

            Customer c = CustomerCatalog.fetchCustomerByPhoneNumber(ploneNumber);

            if (c == null && !ploneNumber.equals("")){
                customerErr.setText("Customer does not exist");
            }else if (!ploneNumber.equals("")){
                customerErr.setText("");
                if (app != null){
                    app.setCustomerId(c.getId());
                    appointmentErr.setText("");
                }else{
                    appointmentErr.setText("Incorrect Id");
                }
            }

            if(VehicleCatalog.fetchVehicleByPlateNumber(plateNumber) == null && !plateNumber.equals("")){
                vehicleErr.setText("Vehicle does not exist");
            }else if (!plateNumber.equals("")){
                vehicleErr.setText("");
                if (app != null){
                    app.setVehiclePlateNumber(plateNumber);
                    appointmentErr.setText("");
                }else{
                    appointmentErr.setText("Incorrect Id");
                }
            }

            AppointmentCatalog.save();
            appointmentTable.refresh();
        }
    }

    private void loadAppointmentToTable(){
        appointmentId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        appointmentDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
        appointmentTime.setCellValueFactory(new PropertyValueFactory<>("Time"));
        appointmentCustomer.setCellValueFactory(new PropertyValueFactory<>("CustomerName"));
        appointmentVehicle.setCellValueFactory(new PropertyValueFactory<>("vehiclePlateNumber"));
        appointmentCost.setCellValueFactory(new PropertyValueFactory<>("Cost"));
        appointmentStatus.setCellValueFactory(new PropertyValueFactory<>("Status"));
        appointmentTable.setItems(appointmentModel);
    }


    @FXML
    void initialize() {

        assert goBackBtn != null : "fx:id=\"goBackBtn\" was not injected: check your FXML file 'EditAppointmentScreen-view.fxml'.";
        assert appointmentTable != null : "fx:id=\"appointmentTable\" was not injected: check your FXML file 'EditAppointmentScreen-view.fxml'.";

        // Table cols
        assert appointmentId != null : "fx:id=\"appointmentId\" was not injected: check your FXML file 'EditAppointmentScreen-view.fxml'.";
        assert appointmentDate != null : "fx:id=\"appointmentDate\" was not injected: check your FXML file 'EditAppointmentScreen-view.fxml'.";
        assert appointmentTime != null : "fx:id=\"appointmentTime\" was not injected: check your FXML file 'EditAppointmentScreen-view.fxml'.";
        assert appointmentCustomer != null : "fx:id=\"appointmentCustomer\" was not injected: check your FXML file 'EditAppointmentScreen-view.fxml'.";
        assert appointmentVehicle != null : "fx:id=\"appointmentVehicle\" was not injected: check your FXML file 'EditAppointmentScreen-view.fxml'.";
        assert appointmentCost != null : "fx:id=\"appointmentCost\" was not injected: check your FXML file 'EditAppointmentScreen-view.fxml'.";
        assert appointmentStatus != null : "fx:id=\"appointmentStatus\" was not injected: check your FXML file 'EditAppointmentScreen-view.fxml'.";

        assert customerPhoneNumber != null : "fx:id=\"customerPhoneNumber\" was not injected: check your FXML file 'EditAppointmentScreen-view.fxml'.";
        assert vehiclePlateNumber != null : "fx:id=\"vehiclePlateNumber\" was not injected: check your FXML file 'EditAppointmentScreen-view.fxml'.";
        assert changeApp != null : "fx:id=\"appointmentStatus\" was not injected: check your FXML file 'EditAppointmentScreen-view.fxml'.";
        assert customerErr != null : "fx:id=\"customerErr\" was not injected: check your FXML file 'EditAppointmentScreen-view.fxml'.";
        assert vehicleErr != null : "fx:id=\"vehicleErr\" was not injected: check your FXML file 'EditAppointmentScreen-view.fxml'.";
        assert appointmentIdField != null : "fx:id=\"appointmentIdField\" was not injected: check your FXML file 'EditAppointmentScreen-view.fxml'.";
        assert appointmentErr != null : "fx:id=\"appointmentErr\" was not injected: check your FXML file 'EditAppointmentScreen-view.fxml'.";

        loadAppointmentToTable();

    }
}
