module RugbyFXML {

    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    exports es.soraya;
    exports es.soraya.models;
    exports es.soraya.logica;
    exports es.soraya.views;

    opens es.soraya.views to javafx.fxml;

}