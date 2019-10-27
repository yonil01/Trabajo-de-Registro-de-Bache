/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Baches;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author rojas
 */
public class Persona {
    private String Nombre;
    private String direccion;
    private String Telefono;

    public Persona(String Nombre, String direccion, String Telefono) {
        this.Nombre = Nombre;
        this.direccion = direccion;
        this.Telefono = Telefono;
    }

    public Persona() {
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    @Override
    public String toString() {
        return Nombre + "\t"+ direccion + "\t" + Telefono;
    }
    
    
}

class ArchivoPersona{
    private ArrayList<Persona> per;
    public ArchivoPersona(){
        per=new ArrayList<Persona>();
        cargar();
    }
    public void agregar(Persona bac){
        per.add(bac);
        grabar();
    }
    public Persona obtener(int i){
        return per.get(i);
    }
    public String Listar(){
        String cad="";
        for(int i=0;i<per.size();i++){
            cad+=per.get(i).toString()+"\n";
        }
        
        return cad;
    }
    public int tamaño(){
        return per.size();
    }

    public void cargar(){
        try{
            File archivoBache=new File("archivoCiudadano.txt");
            if(archivoBache.exists()){
                BufferedReader br=new BufferedReader(new FileReader("archivoCiudadano.txt"));
                String linea;
                while((linea=br.readLine())!=null){
                    StringTokenizer st=new StringTokenizer(linea,",");
                    String nombre=st.nextToken().trim();
                    String direccion=st.nextToken().trim();
                    String telefono=st.nextToken().trim();
                    Persona x=new Persona(nombre,direccion,telefono);
                    agregar(x);
                }
                br.close();
            }else{
                JOptionPane.showMessageDialog(null, "El archivo No existe");
            }
        }catch(Exception x){
            JOptionPane.showMessageDialog(null, "Se produjo un error="+x);
        }
    }
    public void grabar(){
        try{
            PrintWriter pw=new PrintWriter(new FileWriter("archivoCiudadano.txt"));
            for(int i=0;i<per.size();i++){
                pw.println(obtener(i).getNombre()+","+obtener(i).getDireccion()+","+obtener(i).getTelefono());
            }
            pw.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Se produjo un error="+e);
        }
        
    }
}