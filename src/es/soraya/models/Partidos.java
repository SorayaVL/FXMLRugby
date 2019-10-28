package es.soraya.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Partidos {

    private String equipoLocal;
    private String equipoVisitante;
    private String division;
    private String resultado;
    private LocalDate fechaPartido = LocalDate.now();


    public String getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(String equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public String getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(String equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public LocalDate getFechaPartido() {
        return fechaPartido;
    }

    public String getFechaPartidoFormateado() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd'-'MM'-'yyyy");
        String fechaPartidoFormateado =getFechaPartido().format(f);
        return fechaPartidoFormateado;
    }
    public void setFechaPartido(LocalDate fechaPartido) {

        this.fechaPartido = fechaPartido;
    }


    public Partidos(String equipoLocal, String equipoVisitante, String division, String resultado, LocalDate fechaPartido) {

        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.division = division;
        this.resultado = resultado;
        this.fechaPartido = fechaPartido;


    }
}
