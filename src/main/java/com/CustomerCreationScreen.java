package com;

import com.catalogs.CustomerCatalog;
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

public class CustomerCreationScreen {

    private Stage stage;
    private Parent root;

    @FXML
    private Button goBackBtn, customerCreationBtn, closeBtn;

    @FXML
    private AnchorPane messageBox;
    @FXML
    private Text messageBoxText;

    @FXML
    private TextField customerName, customerSurname, customerPhone, customerEmail, customerAddress;
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
        }else if (event.getSource() == customerCreationBtn){

            if( checkInputFields() ){
                closeBtn.setBackground(Background.fill(Color.GREEN));
                closeBtn.setStyle("-fx-text-fill: white;");
                messageBoxText.setText("Successfully created.");

                StartScreenController.secretary.createCustomer(customerName.getText(),customerSurname.getText(),customerPhone.getText(), customerEmail.getText(),customerAddress.getText());

            }else{
                closeBtn.setBackground(Background.fill(Color.RED));
                closeBtn.setStyle("-fx-text-fill: white;");
                messageBoxText.setText("Invalid Customer fields.");
            }
            messageBoxText.setStyle("-fx-text-fill: white;");
            messageBox.setVisible(true);
        }else if (event.getSource() == closeBtn){
            emptyTextFields();
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
        if ( customerName.getText().equals("") ||
                customerSurname.getText().equals("") ||
                customerPhone.getText().equals("") ||
                customerEmail.getText().equals("") ||
                customerAddress.getText().equals("")
        ){
            return false;
        }
        if ( CustomerCatalog.fetchCustomerByPhoneNumber(customerPhone.getText()) != null){
            return false;
        }

        return true;
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

        assert closeBtn != null : "fx:id=\"closeBtn\" was not injected: check your FXML file 'CustomerCreationScreen-view.fxml'.";
        assert messageBox != null : "fx:id=\"messageBox\" was not injected: check your FXML file 'CustomerCreationScreen-view.fxml'.";
        assert messageBoxText != null : "fx:id=\"messageBoxText\" was not injected: check your FXML file 'CustomerCreationScreen-view.fxml'.";


        goBackBtn.setBackground(Background.fill(Color.RED));
        goBackBtn.setStyle("-fx-text-fill: white;");

        customerCreationBtn.setBackground(Background.fill(Color.GREEN));
        customerCreationBtn.setStyle("-fx-text-fill: white;");

    }

}