package com;

import java.io.IOException;

import com.carops.Engineer;
import com.carops.Owner;
import com.carops.ReceptionEngineer;
import com.carops.Secretary;
import com.carops.SupervisorEngineer;
import com.catalogs.EngineerCatalog;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class StartScreenController {
    private Stage stage;
    private Parent root;

    // Input TextField
    @FXML
    private TextField ownerLastname, secretaryLastname, receptionLastname, supervisorLastname, engineerLastname;

    @FXML
    private Button ownerBtn, secretaryBtn, receptionBtn, supervisorBtn, engineerBtn;

    public static Owner owner;
    public static Secretary secretary;
    public static ReceptionEngineer receptionEngineer;
    public static SupervisorEngineer supervisorEngineer;
    public static Engineer engineer;


    // Listener
    @FXML
    void mouseClicked(MouseEvent event) throws IOException {

        this.textFieldClicked(event);

        this.buttonsClicked(event);

    }

    private void textFieldClicked(MouseEvent e) {

        Object source = e.getSource();
        if (source.equals(ownerLastname)) {
            ownerLastname.setText("");
        } else if (source.equals(secretaryLastname)) {
            secretaryLastname.setText("");
        } else if (source.equals(receptionLastname)) {
            receptionLastname.setText("");
        } else if (source.equals(supervisorLastname)) {
            supervisorLastname.setText("");
        } else if (source.equals(engineerLastname)) {
            engineerLastname.setText("");
        }
    }

    private void buttonsClicked(MouseEvent e) throws IOException {
        Object source = e.getSource();

        if (source.equals(ownerBtn)) {
            owner = Owner.searchOwner(ownerLastname.getText());
            if (owner != null) {
                ownerLastname.setText("");
                sceneGenerator("OwnerScreenController-view.fxml", e, "Owner Screen");

            } else {
                ownerLastname.setText(ownerLastname.getText() + " not found");
            }
        } else if (source.equals(secretaryBtn)) {
            secretary = Secretary.searchSecretary(secretaryLastname.getText());

            if (secretary != null) {
                secretaryLastname.setText("");
                sceneGenerator("SecretaryScreenController-view.fxml", e, "Secretary Screen");

            } else {
                secretaryLastname.setText(secretaryLastname.getText() + " not found");
            }
        } else if (source.equals(receptionBtn)) {
            receptionEngineer = (ReceptionEngineer) EngineerCatalog
                    .searchEngineerByRole(receptionLastname.getText(), "reception");

            if (receptionEngineer != null) {
                receptionLastname.setText("");
                sceneGenerator("ReceptionEngineerScreen-view.fxml", e, "Reception Screen");

            } else {
                receptionLastname.setText(receptionLastname.getText() + " not found");
            }
        } else if (source.equals(supervisorBtn)) {
            supervisorEngineer = (SupervisorEngineer) EngineerCatalog
                    .searchEngineerByRole(supervisorLastname.getText(), "supervisor");

            if (supervisorEngineer != null) {
                supervisorLastname.setText("");
                sceneGenerator("SupervisorScreenController-view.fxml", e, "Supervisor Screen");

            } else {
                supervisorLastname.setText(supervisorLastname.getText() + " not found");
            }
        } else if (source.equals(engineerBtn)) {
            engineer = (Engineer) EngineerCatalog
                    .searchEngineerByRole(engineerLastname.getText(), "engineer");

            if (engineer != null) {
                engineerLastname.setText("");
                sceneGenerator("EngineerScreenController-view.fxml", e, "Engineer Screen");

            } else {
                engineerLastname.setText(engineerLastname.getText() + " not found");
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

    @FXML
    void initialize() {
        // OWNER FIELDS
        assert ownerLastname != null
                : "fx:id=\"ownerLastname\" was not injected: check your FXML file 'StartScreenController-view.fxml'.";
        assert ownerBtn != null
                : "fx:id=\"ownerBtn\" was not injected: check your FXML file 'StartScreenController-view.fxml'.";

        // SECRETARY FIELDS
        assert secretaryLastname != null
                : "fx:id=\"secretaryLastname\" was not injected: check your FXML file 'StartScreenController-view.fxml'.";
        assert secretaryBtn != null
                : "fx:id=\"secretaryBtn\" was not injected: check your FXML file 'StartScreenController-view.fxml'.";

        // RECEPTION FIELDS
        assert receptionLastname != null
                : "fx:id=\"receptionLastname\" was not injected: check your FXML file 'StartScreenController-view.fxml'.";
        assert receptionBtn != null
                : "fx:id=\"receptionBtn\" was not injected: check your FXML file 'StartScreenController-view.fxml'.";

        // SUPERVISOR FIELDS
        assert supervisorLastname != null
                : "fx:id=\"supervisorLastname\" was not injected: check your FXML file 'StartScreenController-view.fxml'.";
        assert supervisorBtn != null
                : "fx:id=\"supervisorBtn\" was not injected: check your FXML file 'StartScreenController-view.fxml'.";

        // ENGINEER FIELDS
        assert engineerLastname != null
                : "fx:id=\"engineerLastname\" was not injected: check your FXML file 'StartScreenController-view.fxml'.";
        assert engineerBtn != null
                : "fx:id=\"engineerBtn\" was not injected: check your FXML file 'StartScreenController-view.fxml'.";


        ownerBtn.setBackground(Background.fill(Color.GREEN));
        secretaryBtn.setBackground(Background.fill(Color.GREEN));
        receptionBtn.setBackground(Background.fill(Color.GREEN));
        supervisorBtn.setBackground(Background.fill(Color.GREEN));
        engineerBtn.setBackground(Background.fill(Color.GREEN));

    }

}