/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author leoan
 */
public class Partido implements Comparable<Partido> {

    private String year;
    private String dateTime;
    private String grupo;
    private String estadio;
    private String ciudad;
    private String local;
    private String golesLocalTotal;
    private String golesVisitaTotal;
    private String visitante;
    private String condicionVictoria;
    private String asistencia;
    private String golesLocalMT;
    private String golesVisitaMT;
    private String arbitro;
    private String asistente1;
    private String asistente2;
    private String roundID;
    private String matchID;
    private String inicialLocal;
    private String inicialVisita;

    public Partido(String year, String dateTime, String grupo, String estadio, String ciudad, String local, String golesLocalTotal, String golesVisitaTotal, String visitante, String condicionVictoria, String asistencia, String golesLocalMT, String golesVisitaMT, String arbitro, String asistente1, String asistente2, String roundID, String matchID, String inicialLocal, String inicialVisita) {
        this.year = year;
        this.dateTime = dateTime;
        this.grupo = grupo;
        this.estadio = estadio;
        this.ciudad = ciudad;
        this.local = local;
        this.golesLocalTotal = golesLocalTotal;
        this.golesVisitaTotal = golesVisitaTotal;
        this.visitante = visitante;
        this.condicionVictoria = condicionVictoria;
        this.asistencia = asistencia;
        this.golesLocalMT = golesLocalMT;
        this.golesVisitaMT = golesVisitaMT;
        this.arbitro = arbitro;
        this.asistente1 = asistente1;
        this.asistente2 = asistente2;
        this.roundID = roundID;
        this.matchID = matchID;
        this.inicialLocal = inicialLocal;
        this.inicialVisita = inicialVisita;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getGolesLocalTotal() {
        return golesLocalTotal;
    }

    public void setGolesLocalTotal(String golesLocalTotal) {
        this.golesLocalTotal = golesLocalTotal;
    }

    public String getGolesVisitaTotal() {
        return golesVisitaTotal;
    }

    public void setGolesVisitaTotal(String golesVisitaTotal) {
        this.golesVisitaTotal = golesVisitaTotal;
    }

    public String getVisitante() {
        return visitante;
    }

    public void setVisitante(String visitante) {
        this.visitante = visitante;
    }

    public String getCondicionVictoria() {
        return condicionVictoria;
    }

    public void setCondicionVictoria(String condicionVictoria) {
        this.condicionVictoria = condicionVictoria;
    }

    public String getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(String asistencia) {
        this.asistencia = asistencia;
    }

    public String getGolesLocalMT() {
        return golesLocalMT;
    }

    public void setGolesLocalMT(String golesLocalMT) {
        this.golesLocalMT = golesLocalMT;
    }

    public String getGolesVisitaMT() {
        return golesVisitaMT;
    }

    public void setGolesVisitaMT(String golesVisitaMT) {
        this.golesVisitaMT = golesVisitaMT;
    }

    public String getArbitro() {
        return arbitro;
    }

    public void setArbitro(String arbitro) {
        this.arbitro = arbitro;
    }

    public String getAsistente1() {
        return asistente1;
    }

    public void setAsistente1(String asistente1) {
        this.asistente1 = asistente1;
    }

    public String getAsistente2() {
        return asistente2;
    }

    public void setAsistente2(String asistente2) {
        this.asistente2 = asistente2;
    }

    public String getRoundID() {
        return roundID;
    }

    public void setRoundID(String roundID) {
        this.roundID = roundID;
    }

    public String getMatchID() {
        return matchID;
    }

    public void setMatchID(String matchID) {
        this.matchID = matchID;
    }

    public String getInicialLocal() {
        return inicialLocal;
    }

    public void setInicialLocal(String inicialLocal) {
        this.inicialLocal = inicialLocal;
    }

    public String getInicialVisita() {
        return inicialVisita;
    }

    public void setInicialVisita(String inicialVisita) {
        this.inicialVisita = inicialVisita;
    }
    /**
     * Este método se encarga de comparar 2 objetos tipo Partido. Éste es el
     * método que nos ayuda a ordenar alfabeticamente los equipos de los
     * partidos. Lo hace obteniendo el primer caracter de cada equipo,
     * obteniendo su valor y comparandolos el uno al otro para saber cual es
     * mayor alfabeticamente.
     *
     * @return int
     */
    @Override
    public int compareTo(Partido o) {
        if (Character.valueOf(this.getLocal().charAt(0)) > Character.valueOf(o.getVisitante().charAt(0))) {
            return 1;
        } else if (Character.valueOf(this.getLocal().charAt(0)) == Character.valueOf(o.getVisitante().charAt(0))) {
            return 0;
        } else {
            return -1;
        }
    }

}
