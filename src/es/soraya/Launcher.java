package es.soraya;

import es.soraya.logica.Logica;
import es.soraya.models.Partidos;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.time.LocalDate;

public class Launcher extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("views/MainWindow.fxml"));
        stage.setTitle("Pantalla Principal");
        stage.setScene(new Scene(root, 551, 400));
        stage.show();
    }

    public static void main(String[] args) {
        Partidos partido1 = new Partidos("Local 1", "Visitante 1", "Primera", "2-1", LocalDate.now());
        Partidos partido2 = new Partidos("Local 2", "Visitante 2", "Primera", "2-1", LocalDate.now());
        Logica.getINSTANCE().aniadirPartidos(partido1);
        Logica.getINSTANCE().aniadirPartidos(partido2);
        launch(args);
    }
}
