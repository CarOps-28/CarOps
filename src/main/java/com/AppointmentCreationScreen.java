package com;

import com.carops.DateTime;
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

public class AppointmentCreationScreen {
    private Stage stage;
    private Parent root;

    @FXML
    private TextField plateNumber, date, phoneNumber;

    @FXML
    private Button vehicleCreationBtn, customerCreationBtn, appointmentCreationBtn, closeBtn, goBackBtn;

    @FXML
    private AnchorPane messageBox;
    @FXML
    private Text plateNumberErr, phoneNumberErr, dateErr, messageBoxText;

    private String customerId_ifCustomerExist = "";
    private void sceneGenerator(String Screen_Name, MouseEvent event, String Screen_Title) throws IOException {
        root = FXMLLoader.load(getClass().getResource(Screen_Name));

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.getScene().setRoot(root);
        stage.setHeight(700);
        stage.setWidth(900);
        stage.setTitle(Screen_Title);
        stage.show();
    }
    public void mouseClicked(MouseEvent event) throws IOException {
        if (event.getSource() == goBackBtn){
            sceneGenerator("SecretaryScreenController-view.fxml", event, "Secretary Screen");
        }else if (event.getSource() == customerCreationBtn){
            sceneGenerator("CustomerCreationScreen-view.fxml", event, "Customer Creation Screen");
        }else if (event.getSource() == vehicleCreationBtn){
            sceneGenerator("VehicleCreationScreen-view.fxml", event, "Vehicle Creation Screen");
        } else if (event.getSource() == appointmentCreationBtn){

            if( checkInputFields() ){

                closeBtn.setBackground(Background.fill(Color.GREEN));
                closeBtn.setStyle("-fx-text-fill: white;");
                messageBoxText.setText("Successfully created.");

                StartScreenController.secretary.createAppointment(customerId_ifCustomerExist, plateNumber.getText(),new DateTime(date.getText()));

                customerId_ifCustomerExist = "";
            }else{
                closeBtn.setBackground(Background.fill(Color.RED));
                closeBtn.setStyle("-fx-text-fill: white;");
                messageBoxText.setText("Invalid Appointment fields.");

            }
            messageBoxText.setStyle("-fx-text-fill: white;");

            messageBox.setVisible(true);
        }else if (event.getSource() == closeBtn){
            messageBox.setVisible(false);
        }
    }


    private boolean checkInputFields(){
        boolean flag = true ;
        if ( VehicleCatalog.fetchVehicleByPlateNumber(plateNumber.getText()) == null && !plateNumber.getText().equals("")){
            plateNumberErr.setText("* " + plateNumber.getText() + " does not exist");
            flag = false;
        }else{
            plateNumberErr.setText("* ");
        }
        if ( CustomerCatalog.fetchCustomerByPhoneNumber(phoneNumber.getText()) == null && !phoneNumber.getText().equals("")){
            phoneNumberErr.setText("* " + phoneNumber.getText() + " does not exist");
            flag = false;
        }else{
            phoneNumberErr.setText("* ");
            try{
                customerId_ifCustomerExist = CustomerCatalog.fetchCustomerByPhoneNumber(phoneNumber.getText()).getId();
            }catch (NullPointerException e){

            }
        }

        if(date.getText().equals("")){ dateErr.setText("* this field cannot be empty."); flag = false; }
        else { dateErr.setText("* "); }

        return flag;
    }

    private void emptyTextFields(){
        plateNumber.setText("");
        date.setText("");
        phoneNumber.setText("");
    }

    @FXML
    void initialize() {
        assert plateNumber != null : "fx:id=\"plateNumber\" was not injected: check your FXML file 'AppointmentCreationScreen-view.fxml'.";
        assert date != null : "fx:id=\"date\" was not injected: check your FXML file 'AppointmentCreationScreen-view.fxml'.";
        assert phoneNumber != null : "fx:id=\"phoneNumber\" was not injected: check your FXML file 'AppointmentCreationScreen-view.fxml'.";
        assert vehicleCreationBtn != null : "fx:id=\"vehicleCreationBtn\" was not injected: check your FXML file 'AppointmentCreationScreen-view.fxml'.";
        assert customerCreationBtn != null : "fx:id=\"customerCreationBtn\" was not injected: check your FXML file 'AppointmentCreationScreen-view.fxml'.";
        assert appointmentCreationBtn != null : "fx:id=\"appointmentCreationBtn\" was not injected: check your FXML file 'AppointmentCreationScreen-view.fxml'.";
        assert goBackBtn != null : "fx:id=\"goBackBtn\" was not injected: check your FXML file 'AppointmentCreationScreen-view.fxml'.";

        assert closeBtn != null : "fx:id=\"closeBtn\" was not injected: check your FXML file 'AppointmentCreationScreen-view.fxml'.";
        assert messageBox != null : "fx:id=\"messageBox\" was not injected: check your FXML file 'AppointmentCreationScreen-view.fxml'.";
        assert messageBoxText != null : "fx:id=\"messageBoxText\" was not injected: check your FXML file 'AppointmentCreationScreen-view.fxml'.";

        assert plateNumberErr != null : "fx:id=\"plateNumberErr\" was not injected: check your FXML file 'AppointmentCreationScreen-view.fxml'.";
        assert phoneNumberErr != null : "fx:id=\"phoneNumberErr\" was not injected: check your FXML file 'AppointmentCreationScreen-view.fxml'.";
        assert dateErr != null : "fx:id=\"dateErr\" was not injected: check your FXML file 'AppointmentCreationScreen-view.fxml'.";

        customerCreationBtn.setBackground(Background.fill(Color.LIGHTBLUE));
        customerCreationBtn.setStyle("-fx-text-fill: black;");

        vehicleCreationBtn.setBackground(Background.fill(Color.LIGHTBLUE));
        vehicleCreationBtn.setStyle("-fx-text-fill: black;");

        appointmentCreationBtn.setBackground(Background.fill(Color.GREEN));
        appointmentCreationBtn.setStyle("-fx-text-fill: white;");

        goBackBtn.setBackground(Background.fill(Color.RED));
        goBackBtn.setStyle("-fx-text-fill: white;");
    }

}