package com;

import com.carops.Processes;
import com.carops.Secretary;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class StartScreenController {
    private Stage stage;
    private Parent root;
    @FXML
    private TextField secretaryNameField;
    @FXML
    private Button searchBtn;

    public static Secretary secretary;
    @FXML
    void initialize() {
        assert secretaryNameField != null : "fx:id=\"secretaryNameField\" was not injected: check your FXML file 'StartScreen-view.fxml'.";
        assert searchBtn != null : "fx:id=\"searchBtn\" was not injected: check your FXML file 'StartScreen-view.fxml'.";


        initializeTexts();
    }

    public void initializeTexts(){
        secretaryNameField.setText("Enter Secretary Surname");
    }

    //Listeners

    @FXML
    void mouseClicked(MouseEvent event) throws IOException {
        if (event.getSource() == secretaryNameField){
            this.secretaryNameField.setText("");

        }else if (event.getSource() == searchBtn){
            boolean found = false;
            for(Secretary secretary : Secretary.secretaryList ){

                if (Processes.removeTones(secretary.getSurname()).equalsIgnoreCase(Processes.removeTones(secretaryNameField.getText()))){

                    this.secretary = secretary;
                    found = true;
                }
            }
            if(found){
                secretaryNameField.setText("");
                sceneGenerator("SecretaryScreen-view.fxml", event, "Secretary Screen");

            }else{
                secretaryNameField.setText(secretaryNameField.getText() + " not found");
            }
        }
    }


    private void sceneGenerator(String Screen_Name, MouseEvent event, String Screen_Title) throws IOException {
        root = FXMLLoader.load(getClass().getResource(Screen_Name));

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.getScene().setRoot(root);
        stage.setHeight(700);
        stage.setWidth(900);
        stage.setTitle(Screen_Title);
        stage.show();
    }

}