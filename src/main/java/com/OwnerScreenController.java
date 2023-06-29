package com;

import com.carops.Engineer;
import com.catalogs.EngineerCatalog;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class OwnerScreenController {
    @FXML
    private ToggleGroup eng, newRole;
    @FXML
    private RadioButton engineer, reception, supervisor, engineer1Btn, engineer2Btn, engineer3Btn, engineer4Btn, engineer5Btn;
    @FXML
    private Button changeRole, goBackBtn;
    @FXML
    private TextField engineer1, engineer2, engineer3, engineer4, engineer5, engineerRole1, engineerRole2, engineerRole3,engineerRole4, engineerRole5;

    private String selectedEngineerId;

    public void mouseClicked(MouseEvent event) throws IOException {
        if (event.getSource() == goBackBtn){
            StartScreenController.owner = null;
            StartScreenController.sceneGenerator("StartScreenController-view.fxml", event, "CarOps Information System");
        }else if (event.getSource() == changeRole){
            RadioButton rb = (RadioButton) newRole.getSelectedToggle();

            Engineer eng = EngineerCatalog.fetchEngineerById(selectedEngineerId);

            StartScreenController.owner.changeRole(eng, rb.getId());

            EngineerCatalog.sortedEngineers();

            setEngineers();
            changeDisabledRoleRadioButton();

            EngineerCatalog.save();

        }
    }

    private void setEngineers(){
        TextField[] engineersNameFields = { engineer1, engineer2, engineer3, engineer4, engineer5 };
        TextField[] engineersRoleFields = { engineerRole1, engineerRole2, engineerRole3, engineerRole4, engineerRole5 };
        int i = 0;
        for (Engineer eng : EngineerCatalog.fetchEngineers()){
            engineersNameFields[i].setText(eng.getId() + " - " + eng.getSurname());
            engineersRoleFields[i].setText(eng.getRole());
            i++;
        }
    }

    private void changeDisabledRoleRadioButton(){
        TextField[] engineersNameFields = { engineer1, engineer2, engineer3, engineer4, engineer5 };

        RadioButton rb = (RadioButton) eng.getSelectedToggle();

        int id = 0;
        switch (rb.getId()){
            case "engineer1Btn" -> id = 0;
            case "engineer2Btn" -> id = 1;
            case "engineer3Btn" -> id = 2;
            case "engineer4Btn" -> id = 3;
            case "engineer5Btn" -> id = 4;
        }

        selectedEngineerId = engineersNameFields[id].getText().split(" - ")[0];

        reception.setDisable(false);
        supervisor.setDisable(false);
        engineer.setDisable(false);

        for (Engineer eng : EngineerCatalog.fetchEngineers()){
            if (eng.getId().equals(selectedEngineerId)){
                switch (eng.getRole()) {
                    case "reception" -> { reception.fire(); reception.setDisable(true);  }
                    case "supervisor" ->{ supervisor.fire(); supervisor.setDisable(true); }
                    case "engineer" -> { engineer.fire(); engineer.setDisable(true); }
                }
            }
        }
    }
    public void radioButtonsAction(){
        changeDisabledRoleRadioButton();
    }
    @FXML
    void initialize() {
        // Toggle Groups
        assert eng != null
                : "fx:id=\"eng\" was not injected: check your FXML file 'OwnerScreenController-view.fxml'.";
        assert newRole != null
                : "fx:id=\"newRole\" was not injected: check your FXML file 'OwnerScreenController-view.fxml'.";

        // Engineers name Fields
        assert engineer1 != null
                : "fx:id=\"engineer1\" was not injected: check your FXML file 'OwnerScreenController-view.fxml'.";
        assert engineer2 != null
                : "fx:id=\"engineer2\" was not injected: check your FXML file 'OwnerScreenController-view.fxml'.";
        assert engineer3 != null
                : "fx:id=\"engineer3\" was not injected: check your FXML file 'OwnerScreenController-view.fxml'.";
        assert engineer4 != null
                : "fx:id=\"engineer4\" was not injected: check your FXML file 'OwnerScreenController-view.fxml'.";
        assert engineer5 != null
                : "fx:id=\"engineer5\" was not injected: check your FXML file 'OwnerScreenController-view.fxml'.";

        // Engineers role Fields
        assert engineerRole1 != null
                : "fx:id=\"engineerRole1\" was not injected: check your FXML file 'OwnerScreenController-view.fxml'.";
        assert engineerRole2 != null
                : "fx:id=\"engineerRole2\" was not injected: check your FXML file 'OwnerScreenController-view.fxml'.";
        assert engineerRole3 != null
                : "fx:id=\"engineerRole3\" was not injected: check your FXML file 'OwnerScreenController-view.fxml'.";
        assert engineerRole4 != null
                : "fx:id=\"engineerRole4\" was not injected: check your FXML file 'OwnerScreenController-view.fxml'.";
        assert engineerRole5 != null
                : "fx:id=\"engineerRole5\" was not injected: check your FXML file 'OwnerScreenController-view.fxml'.";

        assert engineer != null
                : "fx:id=\"engineer\" was not injected: check your FXML file 'OwnerScreenController-view.fxml'.";
        assert reception != null
                : "fx:id=\"reception\" was not injected: check your FXML file 'OwnerScreenController-view.fxml'.";
        assert supervisor != null
                : "fx:id=\"supervisor\" was not injected: check your FXML file 'OwnerScreenController-view.fxml'.";

        assert engineer1Btn != null
                : "fx:id=\"engineer1Btn\" was not injected: check your FXML file 'OwnerScreenController-view.fxml'.";
        assert engineer2Btn != null
                : "fx:id=\"engineer2Btn\" was not injected: check your FXML file 'OwnerScreenController-view.fxml'.";
        assert engineer3Btn != null
                : "fx:id=\"engineer3Btn\" was not injected: check your FXML file 'OwnerScreenController-view.fxml'.";
        assert engineer4Btn != null
                : "fx:id=\"engineer4Btn\" was not injected: check your FXML file 'OwnerScreenController-view.fxml'.";
        assert engineer5Btn != null
                : "fx:id=\"engineer5Btn\" was not injected: check your FXML file 'OwnerScreenController-view.fxml'.";

        assert goBackBtn != null
                : "fx:id=\"goBackBtn\" was not injected: check your FXML file 'OwnerScreenController-view.fxml'.";
        assert changeRole != null
                : "fx:id=\"changeRole\" was not injected: check your FXML file 'OwnerScreenController-view.fxml'.";

        setEngineers();

        changeDisabledRoleRadioButton();
    }
}
