package com;

import com.catalogs.CustomerCatalog;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import java.io.IOException;

public class CustomerCreationScreen {

    @FXML
    private AnchorPane background;
    @FXML
    private Button goBackBtn, customerCreationBtn, closeBtn;
    @FXML
    private AnchorPane messageBox;
    @FXML
    private Text messageBoxText;
    @FXML
    public Text nameErr, surnameErr, phoneErr, emailErr, addressErr;
    @FXML
    private TextField customerName, customerSurname, customerPhone, customerEmail, customerAddress;
    private String errorMessage;

    @FXML
    void mouseClicked(MouseEvent event) throws IOException {
        if (event.getSource() == goBackBtn){
            StartScreenController.sceneGenerator("SecretaryScreenController-view.fxml", event, "Secretary Screen");
        }else if (event.getSource() == customerCreationBtn){

            if( checkInputFields() ){
                messageBoxText.setText("Successfully created.");

                StartScreenController.secretary.createCustomer(customerName.getText(),customerSurname.getText(),customerPhone.getText(), customerEmail.getText(),customerAddress.getText());
                CustomerCatalog.save();
            }else{
                messageBoxText.setText(errorMessage);
            }

            background.setDisable(true);

            messageBox.setVisible(true);
        }else if (event.getSource() == closeBtn){
            background.setDisable(false);
            messageBox.setVisible(false);
        }
    }

    private void emptyTextFields(){
        customerName.setText("");
        customerSurname.setText("");
        customerPhone.setText("");
        customerEmail.setText("");
        customerAddress.setText("");
        messageBoxText.setText("");
    }

    private boolean checkInputFields(){
        boolean flag = true;
        errorMessage = "Invalid Customer fields.";

        if (customerName.getText().equals("") ) { nameErr.setText("* this field cannot be empty."); flag = false; }
        else { nameErr.setText("*"); }

        if (customerSurname.getText().equals("") ) { surnameErr.setText("* this field cannot be empty."); flag = false; }
        else { surnameErr.setText("*"); }

        if (customerPhone.getText().equals("") ) { phoneErr.setText("* this field cannot be empty."); flag = false; }
        else { phoneErr.setText("*"); }

        if (customerEmail.getText().equals("") ) { emailErr.setText("* this field cannot be empty."); flag = false; }
        else { emailErr.setText("*"); }

        if (customerAddress.getText().equals("") ) { addressErr.setText("* this field cannot be empty."); flag = false; }
        else { addressErr.setText("*"); }

        if ( CustomerCatalog.fetchCustomerByPhoneNumber(customerPhone.getText()) != null) { errorMessage = "Customer already exist."; flag = false; }

        return flag;
    }
    @FXML
    void initialize() {
        assert background != null : "fx:id=\"background\" was not injected: check your FXML file 'VehicleCreationScreen-view.fxml'.";

        assert goBackBtn != null : "fx:id=\"goBackBtn\" was not injected: check your FXML file 'CustomerCreationScreen-view.fxml'.";
        assert customerCreationBtn != null : "fx:id=\"customerCreationBtn\" was not injected: check your FXML file 'CustomerCreationScreen-view.fxml'.";
        assert customerName != null : "fx:id=\"customerName\" was not injected: check your FXML file 'CustomerCreationScreen-view.fxml'.";
        assert customerSurname != null : "fx:id=\"customerSurname\" was not injected: check your FXML file 'CustomerCreationScreen-view.fxml'.";
        assert customerPhone != null : "fx:id=\"customerPhone\" was not injected: check your FXML file 'CustomerCreationScreen-view.fxml'.";
        assert customerEmail != null : "fx:id=\"customerEmail\" was not injected: check your FXML file 'CustomerCreationScreen-view.fxml'.";
        assert customerAddress != null : "fx:id=\"customerAddress\" was not injected: check your FXML file 'CustomerCreationScreen-view.fxml'.";

        assert closeBtn != null : "fx:id=\"closeBtn\" was not injected: check your FXML file 'CustomerCreationScreen-view.fxml'.";
        assert messageBox != null : "fx:id=\"messageBox\" was not injected: check your FXML file 'CustomerCreationScreen-view.fxml'.";
        assert messageBoxText != null : "fx:id=\"messageBoxText\" was not injected: check your FXML file 'CustomerCreationScreen-view.fxml'.";

        assert nameErr != null : "fx:id=\"nameErr\" was not injected: check your FXML file 'CustomerCreationScreen-view.fxml'.";
        assert surnameErr != null : "fx:id=\"surnameErr\" was not injected: check your FXML file 'CustomerCreationScreen-view.fxml'.";
        assert phoneErr != null : "fx:id=\"phoneErr\" was not injected: check your FXML file 'CustomerCreationScreen-view.fxml'.";
        assert emailErr != null : "fx:id=\"emailErr\" was not injected: check your FXML file 'CustomerCreationScreen-view.fxml'.";
        assert addressErr != null : "fx:id=\"addressErr\" was not injected: check your FXML file 'CustomerCreationScreen-view.fxml'.";

    }

}