package com;

import com.carops.*;
import com.catalogs.AppointmentCatalog;
import com.catalogs.CustomerCatalog;
import com.catalogs.VehicleCatalog;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class SecretaryScreenController {
    private Stage stage;
    private Parent root;

    @FXML
    private Button customerCreationBtn, vehicleCreationBtn, goBackBtn, createAppointment;

    @FXML
    private  TextField secretaryName;

    public TextArea appointmentsView;


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
        if (event.getSource() == customerCreationBtn){
            sceneGenerator("CustomerCreationScreen-view.fxml", event, "Customer Creation Screen");
        }else if (event.getSource() == vehicleCreationBtn){
            sceneGenerator("VehicleCreationScreen-view.fxml", event, "Vehicle Creation Screen");
        }else if (event.getSource() == goBackBtn){
            sceneGenerator("StartScreenController-view.fxml", event, "CarOps Information System");
        }
        else if(event.getSource() == createAppointment){
            sceneGenerator("AppointmentCreationScreen-view.fxml", event, "Appointment Creation Screen");
        }
    }

    public void initializeTexts(){
        this.secretaryName.setText(StartScreenController.secretary.getSurname().toUpperCase());
        appointmentsView.appendText( "---------- Appointments ----------\n");

        for(Appointment appointment : AppointmentCatalog.fetchAppointments()){
            appointmentsView.appendText(appointment.toString() + "\n");
        }

        appointmentsView.appendText( "\n---------- Customers ----------\n");
        for(Customer customer : CustomerCatalog.fetchCustomers()){
            appointmentsView.appendText(customer.toString() + "\n");
        }

        appointmentsView.appendText( "\n---------- Vehicles ----------\n");
        for(Vehicle vehicle : VehicleCatalog.getVehicles()){
            appointmentsView.appendText(vehicle.toString() + "\n");
        }
    }


    @FXML
    void initialize() {
        assert customerCreationBtn != null : "fx:id=\"customerCreationBtn\" was not injected: check your FXML file 'SecretaryScreenController-view.fxml'.";
        assert vehicleCreationBtn != null : "fx:id=\"vehicleCreationBtn\" was not injected: check your FXML file 'SecretaryScreenController-view.fxml'.";
        assert createAppointment != null : "fx:id=\"createAppointment\" was not injected: check your FXML file 'SecretaryScreenController-view.fxml'.";
        assert goBackBtn != null : "fx:id=\"goBackBtn\" was not injected: check your FXML file 'SecretaryScreenController-view.fxml'.";
        assert secretaryName != null : "fx:id=\"secretaryName\" was not injected: check your FXML file 'SecretaryScreenController-view.fxml'.";
        assert appointmentsView != null : "fx:id=\"appointmentsView\" was not injected: check your FXML file 'SecretaryScreenController-view.fxml'.";

        customerCreationBtn.setBackground(Background.fill(Color.LIGHTBLUE));
        customerCreationBtn.setStyle("-fx-text-fill: black;");

        vehicleCreationBtn.setBackground(Background.fill(Color.LIGHTBLUE));
        vehicleCreationBtn.setStyle("-fx-text-fill: black;");

        createAppointment.setBackground(Background.fill(Color.LIGHTBLUE));
        createAppointment.setStyle("-fx-text-fill: black;");

        goBackBtn.setBackground(Background.fill(Color.RED));
        goBackBtn.setStyle("-fx-text-fill: white;");

        initializeTexts();
    }
}