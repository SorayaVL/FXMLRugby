package es.soraya.views;

import es.soraya.logica.Logica;
import es.soraya.models.Partidos;
import es.soraya.views.Filters.FilterDivision;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainWindowController extends BaseController implements Initializable {

        private FilterDivision filterDivision;

        @FXML
        private ComboBox<String> cbFiltroDivision;
        @FXML
        private MenuItem menuAlta;

        @FXML
        private TableView<Partidos> tvPartidos;

        @FXML
        void altaPartido(ActionEvent event) {

               cargarDialogo("DialogoPartido.fxml", 600, 300);
               abrirDialogo(true);
        }

        @FXML
        void modificarPartido(ActionEvent event) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DialogoPartido.fxml"));
                Parent root = fxmlLoader.load();
                DialogoPartido dialogoPartido = fxmlLoader.getController();
                Partidos partido = tvPartidos.getSelectionModel().getSelectedItem();
                dialogoPartido.setPartidoModificar(partido);
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(new Scene(root, 550, 250));
                stage.showAndWait();
                filtrar();

            } catch (IOException e) {
                e.printStackTrace();
            }


        }

        private void filtrar(){

            tvPartidos.setItems(filterDivision.filtrar(cbFiltroDivision.getSelectionModel().getSelectedItem()));
        }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            tvPartidos.setItems(Logica.getINSTANCE().getoListaPartidos());
            filterDivision = new FilterDivision(Logica.getINSTANCE().getoListaPartidos());
            cbFiltroDivision.setItems(Logica.getINSTANCE().getListaDivision());
            cbFiltroDivision.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                    tvPartidos.setItems(filterDivision.filtrar(t1));
                }
            });
        }


}
