/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.Serializable;

/**
 *
 * @author leoan
 */
public class Jugador implements Serializable {

    private String roundID;
    private String matchID;
    private String inicialesEquipo;
    private String entrenador;
    private String alineacion;
    private String numero;
    private String nombre;

    public Jugador(String roundID, String matchID, String inicialesEquipo, String entrenador, String alineacion, String numero, String nombre) {
        this.roundID = roundID;
        this.matchID = matchID;
        this.inicialesEquipo = inicialesEquipo;
        this.entrenador = entrenador;
        this.alineacion = alineacion;
        this.numero = numero;
        this.nombre = nombre;
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

    public String getAlineacion() {
        return alineacion;
    }

    public void setAlineacion(String alineacion) {
        this.alineacion = alineacion;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Jugador{" + "roundID=" + roundID + ", matchID=" + matchID + ", inicialesEquipo=" + inicialesEquipo + ", entrenador=" + entrenador + ", alineacion=" + alineacion + ", numero=" + numero + ", nombre=" + nombre + '}';
    }
    
}
