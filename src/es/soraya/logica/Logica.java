package es.soraya.logica;

import es.soraya.models.Partidos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.*;

public class Logica {
    private static Logica INSTANCE = null;

    private ObservableList<Partidos> oListaPartidos = FXCollections.observableArrayList();
    private List<Partidos> partidosList = new ArrayList<Partidos>();
    private  ObservableList<String> listaDivision = FXCollections.observableArrayList("Primera","Segunda","Tercera", "");


    private Logica() {
    }

    public static Logica getINSTANCE() {
        if (INSTANCE == null)
            INSTANCE = new Logica();
        return INSTANCE;
    }


    public static void setINSTANCE(Logica INSTANCE) {
        Logica.INSTANCE = INSTANCE;
    }

    public ObservableList<Partidos> getoListaPartidos() {
        return oListaPartidos;
    }

    public ObservableList<String> getListaDivision() {
        return listaDivision;
    }


    public void aniadirPartidos(Partidos partido) {
        oListaPartidos.add(partido);

    }

    public void verListaPartidos() {
        for (Partidos p : oListaPartidos) {
            System.out.println(p);
        }

    }

    public void borrarPartido(Partidos partido) {

        oListaPartidos.remove(partido);
      /*  Iterator<Partidos> it = listaPartidos.iterator();
        while (it.hasNext()){
            int id = it.next().getIdPartido();
            if (borrar== id)
                it.remove();*/
    }

    public void modificarPartido(Partidos partidoM) {
        int indice = oListaPartidos.indexOf(partidoM);
        oListaPartidos.set(indice, partidoM);

    }

    public void guardarFichero() {
        partidosList=new ArrayList<Partidos>(oListaPartidos);

        try {
            ObjectOutputStream fichero = new ObjectOutputStream(new FileOutputStream("./partidos.txt"));
            fichero.writeObject(partidosList);
            fichero.close();
        } catch (IOException e) {

        }
    }

    public void abreFichero() {
        try {
            ObjectInputStream cargaFichero = new ObjectInputStream(new FileInputStream("./partidos.txt"));
            partidosList = (ArrayList) cargaFichero.readObject();
            cargaFichero.close();
            for (Partidos p : partidosList){
                aniadirPartidos(p);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
