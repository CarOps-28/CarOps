package com;

import com.carops.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class SecretaryScreenController {
    public TextArea appointmentsView;
    private Stage stage;
    private Parent root;

    @FXML
    private Button customerCreationBtn;

    @FXML
    private Button vehicleCreationBtn;

    @FXML
    private Button goBackBtn;

    @FXML
    private  TextField secretaryName;

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
            sceneGenerator("StartScreen-view.fxml", event, "CarOps Information System");
        }
    }

    @FXML
    void initialize() {
        assert customerCreationBtn != null : "fx:id=\"customerCreationBtn\" was not injected: check your FXML file 'SecretaryScreen-view.fxml'.";
        assert vehicleCreationBtn != null : "fx:id=\"vehicleCreationBtn\" was not injected: check your FXML file 'SecretaryScreen-view.fxml'.";
        assert goBackBtn != null : "fx:id=\"goBackBtn\" was not injected: check your FXML file 'SecretaryScreen-view.fxml'.";
        assert secretaryName != null : "fx:id=\"secretaryName\" was not injected: check your FXML file 'SecretaryScreen-view.fxml'.";
        assert appointmentsView != null : "fx:id=\"appointmentsView\" was not injected: check your FXML file 'SecretaryScreen-view.fxml'.";

        initializeTexts();
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

}