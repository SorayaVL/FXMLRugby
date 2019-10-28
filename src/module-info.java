module RugbyFXML {

    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires  org.controlsfx.controls;

    exports es.soraya;
    exports es.soraya.models;
    exports es.soraya.logica;
    exports es.soraya.views;

    opens es.soraya.views to javafx.fxml; // para que un paquete tenga acceso a otro

}