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
public class Bache {
    private int Id;
    private String calle;
    private int tamanio;
    private String Ubicacion;
    private String Distrito;

    public Bache(int Id, String calle, int tamanio, String Ubicacion, String Distrito) {
        this.Id = Id;
        this.calle = calle;
        this.tamanio = tamanio;
        this.Ubicacion = Ubicacion;
        this.Distrito = Distrito;
    }

    public Bache() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String Ubicacion) {
        this.Ubicacion = Ubicacion;
    }

    public String getDistrito() {
        return Distrito;
    }

    public void setDistrito(String Distrito) {
        this.Distrito = Distrito;
    }

    @Override
    public String toString() {
        return Id + "\t" + calle + "\t" + tamanio + "\t" + Ubicacion + "\t" + Distrito;
    }
    public String cadena(){
        return "Id: "+Id+" Calle: "+calle+" Tamaño: "+tamanio+" Ubicacion: "+Ubicacion+" Distrito: "+Distrito;
    }
    
    
    
}

class ListaBache{
    private ArrayList<Bache> bach;
    public ListaBache(){
        bach=new ArrayList<Bache>();
        cargar();
    }
    public void agregar(Bache bac){
        bach.add(bac);
        grabar();
    }
    public Bache obtener(int i){
        return bach.get(i);
    }
    public String Listar(){
        String cad="";
        for(int i=0;i<bach.size();i++){
            cad+=bach.get(i).toString()+"\n";
        }
        
        return cad;
    }
    public int tamaño(){
        return bach.size();
    }
    public Bache Buscar(int indice){ 
        for(int i=0;i<bach.size();i++){
            if(bach.get(i).getId()==indice){
                return bach.get(i);
            }
        }
        return null;
    }
    public int indice(int id){
        for(int i=0;i<bach.size();i++){
            if(bach.get(i).getId()==id){
                return i;
            }
        }
      return -1;
    }
    public void cargar(){
        try{
            File archivoBache=new File("archivoBache.txt");
            if(archivoBache.exists()){
                BufferedReader br=new BufferedReader(new FileReader("archivoBache.txt"));
                String linea;
                while((linea=br.readLine())!=null){
                    StringTokenizer st=new StringTokenizer(linea,",");
                    int id=Integer.parseInt(st.nextToken().trim());
                    String calle=st.nextToken().trim();
                    int tamanio=Integer.parseInt(st.nextToken().trim());
                    String ubicacion=st.nextToken().trim();
                    String distrito=st.nextToken().trim();
                    Bache b=new Bache(id, calle, tamanio, ubicacion, distrito);
                    agregar(b);
                }
                br.close();
            }else{
                JOptionPane.showMessageDialog(null, "El archivo No existe");
            }
        }catch(Exception b){
            JOptionPane.showMessageDialog(null, "Se produjo un error="+b);
        }
    }
    public void grabar(){
        try{
            PrintWriter pw=new PrintWriter(new FileWriter("archivoBache.txt"));
            for(int i=0;i<bach.size();i++){
                pw.println(obtener(i).getId()+","+obtener(i).getCalle()+","+obtener(i).getTamanio()+","+obtener(i).getUbicacion()+","+obtener(i).getDistrito());
            }
            pw.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Se produjo un error="+e);
        }
        
    }
}