/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author leoan
 */
public class Jugador {

    private int roundID;
    private int matchID;
    private String inicialesEquipo;
    private String entrenador;
    private char alineacion;
    private int numero;
    private String nombre;
    private String posicion;
    private String evento;

    public Jugador(int roundID, int matchID, String inicialesEquipo, String entrenador, char alineacion, int numero, String nombre, String posicion, String evento) {
        this.roundID = roundID;
        this.matchID = matchID;
        this.inicialesEquipo = inicialesEquipo;
        this.entrenador = entrenador;
        this.alineacion = alineacion;
        this.numero = numero;
        this.nombre = nombre;
        this.posicion = posicion;
        this.evento = evento;
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

    public String getInicialesEquipo() {
        return inicialesEquipo;
    }

    public void setInicialesEquipo(String inicialesEquipo) {
        this.inicialesEquipo = inicialesEquipo;
    }

    public String getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(String entrenador) {
        this.entrenador = entrenador;
    }

    public char getAlineacion() {
        return alineacion;
    }

    public void setAlineacion(char alineacion) {
        this.alineacion = alineacion;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

}
