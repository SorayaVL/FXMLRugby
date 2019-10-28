package es.soraya.views;

import es.soraya.logica.Logica;
import es.soraya.models.Partidos;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class DialogoPartido extends BaseController implements Initializable {

        private Partidos partidoModificar;

        @FXML
        private ComboBox<String> cbDivision;

        @FXML
        private DatePicker dpFecha;

        @FXML
        private TextField tfEquipoLocal;

        @FXML
        private TextField tfEquipoVisitante;

        @FXML
        private TextField tfResultado;

        @FXML
        private Button btnAceptar;

        public void initialize(URL url, ResourceBundle resourceBundle) {

               cbDivision.setItems(Logica.getINSTANCE().getListaDivision());
               cbDivision.getSelectionModel().selectFirst();
               dpFecha.setValue(LocalDate.now());
               ValidationSupport  validationSupport = new ValidationSupport();
               validationSupport.registerValidator(tfEquipoLocal, Validator.createEmptyValidator("Inserte el equipo local"));
               /*validationSupport.registerValidator(tfEquipoVisitante, Validator.createEmptyValidator("Inserte el equpipo visitante"));
               validationSupport.registerValidator(tfResultado, Validator.createEmptyValidator("Inserte el resultado del partido en el formato correcto"));*/
       }


        @FXML
        void aceptarPartido(ActionEvent event) {
             if (partidoModificar!=null)
             {
                 partidoModificar.setEquipoLocal(tfEquipoLocal.getText());
                 partidoModificar.setEquipoVisitante(tfEquipoVisitante.getText());
                 partidoModificar.setDivision(cbDivision.getSelectionModel().getSelectedItem());
                 partidoModificar.setResultado(tfResultado.getText());
                 partidoModificar.setFechaPartido(dpFecha.getValue());
                 Logica.getINSTANCE().modificarPartido(partidoModificar);
             }
            else
             {
                 Partidos partido = new Partidos(tfEquipoLocal.getText(), tfEquipoVisitante.getText(), cbDivision.getSelectionModel().getSelectedItem(), tfResultado.getText(), dpFecha.getValue());
                 Logica.getINSTANCE().aniadirPartidos(partido);
             }

            //Obtener un Stage de un evento (los stage están creados por SceneBuilder y no tenemos acceso a ellos
            Stage stage = ((Stage)((Node) event.getSource()).getScene().getWindow());
            stage.close();

        }

        void setPartidoModificar (Partidos partidoModificar){

                this.partidoModificar = partidoModificar;
                tfEquipoLocal.setText(partidoModificar.getEquipoLocal());
                tfEquipoVisitante.setText(partidoModificar.getEquipoVisitante());
                cbDivision.getSelectionModel().select(partidoModificar.getDivision());
                tfResultado.setText(partidoModificar.getResultado());
                dpFecha.setValue(partidoModificar.getFechaPartido());

        }


}
