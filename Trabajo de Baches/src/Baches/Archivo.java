/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Baches;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author rojas
 */
public class Archivo {
    private ArrayList <Orden_trabajo> orden;
 
   
    public Archivo(){
        orden=new ArrayList<Orden_trabajo>();
        
        cargar();
    }
     
    
    public void agregar(Orden_trabajo orde){
        orden.add(orde);
        grabar();
    }
    public String Lista(){
        String cad="";
        for(int i=0;i<tamanio();i++){
            cad+=orden.toString()+"\n";
        }
        return cad;
    }
    public int tamanio(){
        return orden.size();
    }
    public Orden_trabajo obtener(int id){
        return orden.get(id);
    }
    public void cargar(){
        try{
            File archivoBache=new File("archivo.txt");
            if(archivoBache.exists()){
                BufferedReader br=new BufferedReader(new FileReader("archivo.txt"));
                String linea;
                while((linea=br.readLine())!=null){
                    StringTokenizer st=new StringTokenizer(linea,",");
                    int Horas=Integer.parseInt(st.nextToken().trim());
                    String Estado=st.nextToken().trim();
                    int cantidad_material=Integer.parseInt(st.nextToken().trim());
                    int costo=Integer.parseInt(st.nextToken().trim());
                    
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
            PrintWriter pw=new PrintWriter(new FileWriter("archivo.txt"));
            for(int i=0;i<tamanio();i++){
               pw.println(obtener(i).getHoras()+","+obtener(i).getEstado()+","+obtener(i).getCantidad_material()+","+obtener(i).Costo());
            }
            pw.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Se produjo un error="+e);
        }
        
    }
}

 


