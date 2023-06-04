module com.example.carops {
    requires javafx.controls;
    requires javafx.fxml;
            
        requires org.controlsfx.controls;
            requires com.dlsc.formsfx;
            requires net.synedra.validatorfx;
                requires org.kordamp.bootstrapfx.core;
                requires com.almasb.fxgl.all;
    requires annotations;

    exports com;
    exports com.carops;
    opens com.carops to javafx.fxml;
    opens com to javafx.fxml;

}