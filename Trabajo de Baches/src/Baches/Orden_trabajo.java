/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Baches;

/**
 *
 * @author rojas
 */
public class Orden_trabajo {
    private int Horas;
    private String Estado;
    private int cantidad_material;
    private Bache bache;
    private Equipo equipo;
    public Orden_trabajo(int Horas, String Estado, int cantidad_material, Bache bache) {
        this.Horas = Horas;
        this.Estado = Estado;
        this.cantidad_material = cantidad_material;
        this.bache=new Bache();
    }

    public Orden_trabajo() {
    }
    
    

    public int getHoras() {
        return Horas;
    }

    public void setHoras(int Horas) {
        this.Horas = Horas;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public int getCantidad_material() {
        return cantidad_material;
    }

    public void setCantidad_material(int cantidad_material) {
        this.cantidad_material = cantidad_material;
    }

    public Bache getBache() {
        return bache;
    }

    public void setBache(Bache bache) {
        this.bache = bache;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
    
    
    

    @Override
    public String toString() {
        return Estado + "\t" + Costo();
    }
    
    public int Costo(){
        return ((Horas*20)+(equipo.getNro_personas()*12)+(cantidad_material*5));
    }
    
}
