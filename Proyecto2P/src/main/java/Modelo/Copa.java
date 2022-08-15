/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author leoan
 */
public class Copa {
    private String year;
    private String pais;
    private String ganador;
    private String segundo;
    private String tercero;
    private String cuarto;
    private int golesAnotados;
    private int equiposCalificados;
    private int partidosJugados;
    private String asistencia;

    public Copa(String year, String pais, String ganador, String segundo, String tercero, String cuarto, int golesAnotados, int equiposCalificados, int partidosJugados, String asistencia) {
        this.year = year;
        this.pais = pais;
        this.ganador = ganador;
        this.segundo = segundo;
        this.tercero = tercero;
        this.cuarto = cuarto;
        this.golesAnotados = golesAnotados;
        this.equiposCalificados = equiposCalificados;
        this.partidosJugados = partidosJugados;
        this.asistencia = asistencia;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getGanador() {
        return ganador;
    }

    public void setGanador(String ganador) {
        this.ganador = ganador;
    }

    public String getSegundo() {
        return segundo;
    }

    public void setSegundo(String segundo) {
        this.segundo = segundo;
    }

    public String getTercero() {
        return tercero;
    }

    public void setTercero(String tercero) {
        this.tercero = tercero;
    }

    public String getCuarto() {
        return cuarto;
    }

    public void setCuarto(String cuarto) {
        this.cuarto = cuarto;
    }

    public int getGolesAnotados() {
        return golesAnotados;
    }

    public void setGolesAnotados(int golesAnotados) {
        this.golesAnotados = golesAnotados;
    }

    public int getEquiposCalificados() {
        return equiposCalificados;
    }

    public void setEquiposCalificados(int equiposCalificados) {
        this.equiposCalificados = equiposCalificados;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    public String getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(String asistencia) {
        this.asistencia = asistencia;
    }

    @Override
    public String toString() {
        return "Copa{" + "year=" + year + ", pais=" + pais + ", ganador=" + ganador + ", segundo=" + segundo + ", tercero=" + tercero + ", cuarto=" + cuarto + ", golesAnotados=" + golesAnotados + ", equiposCalificados=" + equiposCalificados + ", partidosJugados=" + partidosJugados + ", asistencia=" + asistencia + '}';
    }
    
}
