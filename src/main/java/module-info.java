module com.example.carops {
    requires javafx.controls;
    requires javafx.fxml;
            
        requires org.controlsfx.controls;
            requires com.dlsc.formsfx;
            requires net.synedra.validatorfx;
                requires org.kordamp.bootstrapfx.core;
                requires com.almasb.fxgl.all;
    requires annotations;

    opens com.carops to javafx.fxml;
    exports com.carops;
    exports com.carops.controllers;
    opens com.carops.controllers to javafx.fxml;
}