package es.soraya.views.Filters;

import es.soraya.models.Partidos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FilterDivision {
    private ObservableList<Partidos> listaPartidos;
    private ObservableList<Partidos> listaFiltrada;

    public FilterDivision (ObservableList<Partidos> listaPartidos){
        this.listaPartidos = listaPartidos;
        listaFiltrada = FXCollections.observableArrayList();

    }

    public ObservableList<Partidos> filtrar (String divisionFiltrar){
        if (divisionFiltrar!=null)
        {
            listaFiltrada.clear();
            for (Partidos partido : listaPartidos){
                if (partido.getDivision().contains(divisionFiltrar))
                    listaFiltrada.add(partido);
            }
            return listaFiltrada;
        }
        else return listaPartidos;

    }


}
