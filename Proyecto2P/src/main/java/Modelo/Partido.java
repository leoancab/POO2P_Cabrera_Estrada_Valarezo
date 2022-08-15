/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author leoan
 */
public class Partido {

    private int year;
    private String dateTime;
    private String grupo;
    private String estadio;
    private String ciudad;
    private String local;
    private int golesLocalTotal;
    private int golesVisitaTotal;
    private String visitante;
    private String condicionVictoria;
    private int asistencia;
    private int golesLocalMT;
    private int golesVisitaMT;
    private String arbitro;
    private String asistente1;
    private String asistente2;
    private int roundID;
    private int matchID;
    private String inicialLocal;
    private String inicialVisita;

    public Partido(int year, String dateTime, String grupo, String estadio, String ciudad, String local, int golesLocalTotal, int golesVisitaTotal, String visitante, String condicionVictoria, int asistencia, int golesLocalMT, int golesVisitaMT, String arbitro, String asistente1, String asistente2, int roundID, int matchID, String inicialLocal, String inicialVisita) {
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
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

    public int getGolesLocalTotal() {
        return golesLocalTotal;
    }

    public void setGolesLocalTotal(int golesLocalTotal) {
        this.golesLocalTotal = golesLocalTotal;
    }

    public int getGolesVisitaTotal() {
        return golesVisitaTotal;
    }

    public void setGolesVisitaTotal(int golesVisitaTotal) {
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

    public int getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(int asistencia) {
        this.asistencia = asistencia;
    }

    public int getGolesLocalMT() {
        return golesLocalMT;
    }

    public void setGolesLocalMT(int golesLocalMT) {
        this.golesLocalMT = golesLocalMT;
    }

    public int getGolesVisitaMT() {
        return golesVisitaMT;
    }

    public void setGolesVisitaMT(int golesVisitaMT) {
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

    public int getRoundID() {
        return roundID;
    }

    public void setRoundID(int roundID) {
        this.roundID = roundID;
    }

    public int getMatchID() {
        return matchID;
    }

    public void setMatchID(int matchID) {
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
    
}
