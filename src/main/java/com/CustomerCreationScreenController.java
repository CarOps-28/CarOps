package com;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerCreationScreenController {

    public Button customerCreationBtn;
    private Stage stage;
    private Parent root;

    @FXML
    private Button goBackBtn;

    @FXML
    private TextField customerName;
    @FXML
    private TextField customerSurname;
    @FXML
    private TextField customerPhone;
    @FXML
    private TextField customerEmail;
    @FXML
    private TextField customerAddress;
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
            sceneGenerator("SecretaryScreen-view.fxml", event, "Secretary Screen");
        }else if (event.getSource() == customerCreationBtn){
            StartScreenController.secretary.createCustomer(customerName.getText(),customerSurname.getText(),customerPhone.getText(), customerEmail.getText(),customerAddress.getText());

            customerName.setText("Successful creation");
            customerSurname.setText("");
            customerPhone.setText("");
            customerEmail.setText("");
            customerAddress.setText("");
        }
    }

    @FXML
    void initialize() {
        assert goBackBtn != null : "fx:id=\"goBackBtn\" was not injected: check your FXML file 'CustomerCreationScreen-view.fxml'.";
        assert customerCreationBtn != null : "fx:id=\"customerCreationBtn\" was not injected: check your FXML file 'CustomerCreationScreen-view.fxml'.";
        assert customerName != null : "fx:id=\"customerName\" was not injected: check your FXML file 'CustomerCreationScreen-view.fxml'.";
        assert customerSurname != null : "fx:id=\"customerSurname\" was not injected: check your FXML file 'CustomerCreationScreen-view.fxml'.";
        assert customerPhone != null : "fx:id=\"customerPhone\" was not injected: check your FXML file 'CustomerCreationScreen-view.fxml'.";
        assert customerEmail != null : "fx:id=\"customerEmail\" was not injected: check your FXML file 'CustomerCreationScreen-view.fxml'.";
        assert customerAddress != null : "fx:id=\"customerAddress\" was not injected: check your FXML file 'CustomerCreationScreen-view.fxml'.";
    }

}