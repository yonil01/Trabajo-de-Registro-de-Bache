/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Baches;

/**me llamo yonil y soy  gay
 *
 * @author rojas
 */
public class Equipo {
    private int id;
    private int nro_personas;
    private String nombre;

    public Equipo(int id, int nro_personas, String nombre) {
        this.id = id;
        this.nro_personas = nro_personas;
        this.nombre = nombre;
    }

    public Equipo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNro_personas() {
        return nro_personas;
    }

    public void setNro_personas(int nro_personas) {
        this.nro_personas = nro_personas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Equipo{" + "id=" + id + ", nro_personas=" + nro_personas + ", nombre=" + nombre + '}';
    }
    
    
}
