/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Baches;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author rojas
 */
public class Interfaz extends JFrame implements ActionListener{
    JPanel panel;
    JLabel etiketa1,id,calle,tamaño,ubicacion,distrito,nombre,direccion,telefono,Horas_reparacion,
                Estado_Bache,Cantidad_Material,Costo_Reparacion,lblBache,lblRegistroequipo,lblIdEquipo,lblNroPersonas,lblNombreEquipo;
    JTextField txtId,txtCalle,txtTamaño,txtUbicacion,txtDistrito,txtNombre,txtDireccion,txtTelefono,
                txtHoras_reparacion,txtMaterial,txtCosto_Reparacion,txtMostar,txtIdEquipo,txtNroPersonas,txtNobreEquipo;
    JComboBox combo,txttamanio,txtEstado,SelecBache;
    JTextArea area,area1;
    JScrollPane scroll,scroll1;
    JButton btnprocesar,btnRegistarCiudadano,btnRegistrar,btninicio,btnHacerOrden,btnatras;
    Archivo a1=new Archivo();
     ListaBache l1=new ListaBache();
     Orden_trabajo O1;
     String cadena="",S1;
     ArchivoPersona ar1=new ArchivoPersona();
    public Interfaz(){
        this.setTitle("Baches");
        this.setSize(600, 500);
        this.setLocationRelativeTo(this);
        panel();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void panel(){
        panel=new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
        primeraEtiqueta();
        
    }
    public void primeraEtiqueta(){
        
        etiketa1=new JLabel("Opciones");
        etiketa1.setBounds(100, 20, 120, 20);
        panel.add(etiketa1);
        
        combo=new JComboBox();
        combo.setBounds(100, 40, 120, 20);
        combo.addItem("Registar Bache");
        combo.addItem("Lista bache");
        combo.addItem("Realizar una Orden");
        combo.addItem("Mostrar archivo");
        combo.addActionListener(this);
        panel.add(combo);
        
        btnprocesar=new JButton("Procesar");
        btnprocesar.setBounds(280, 40, 100, 20);
        btnprocesar.addActionListener(this);
        panel.add(btnprocesar);
        
        area=new JTextArea();
        area.setEditable(false);
        scroll=new JScrollPane(area);
        scroll.setBounds(30, 120, 500, 300);
        panel.add(scroll);
        
        
        
    }
    public void RealizarOrden(){
        etiketa1.setVisible(false);
        combo.setVisible(false);
        btnprocesar.setVisible(false);
        scroll.setVisible(false);
        
        Horas_reparacion=new JLabel("Horas dedicadas");
        Horas_reparacion.setBounds(100, 20, 120, 20);
        panel.add(Horas_reparacion);
        
        txtHoras_reparacion=new JTextField();
        txtHoras_reparacion.setBounds(100, 40, 120, 20);
        panel.add(txtHoras_reparacion);
        
        Estado_Bache=new JLabel("Estado del Bache:");
        Estado_Bache.setBounds(100, 60, 120, 20);
        panel.add(Estado_Bache);
        
        txtEstado=new JComboBox();
        txtEstado.addItem("Proceso");
        txtEstado.addItem("Reparado");
        txtEstado.addItem("Temporal");
        txtEstado.addItem("No reparado");
        txtEstado.setBounds(100, 80, 120, 20);
        
        txtEstado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numero=txtEstado.getSelectedIndex();
                switch(numero){
                    case 0:
                       cadena="proceso";
                        break;
                    case 1:
                        cadena="Reparado";
                        break;
                    case 2:
                        cadena="Temporal";
                        break;
                    default:
                        cadena="No reparado";
                }
            }
        });
        panel.add(txtEstado);
        
        Cantidad_Material=new JLabel("Cantidad de Material:");
        Cantidad_Material.setBounds(100, 100, 120, 20);
        panel.add(Cantidad_Material);
        
        txtMaterial=new JTextField();
        txtMaterial.setBounds(100, 120, 120, 20);
        panel.add(txtMaterial);
        
        lblBache=new JLabel("Selecciona Id del Bache:");
        lblBache.setBounds(100, 140, 150, 20);
        panel.add(lblBache);
        
        ArrayList<String> nombre = new ArrayList<String>();
        for(int i=0;i<l1.tamaño();i++){
            nombre.add(Integer.toString(l1.obtener(i).getId()));
        }
        String[] Nombre1=new String[nombre.size()];
        for(int i=0;i<Nombre1.length;i++){
            Nombre1[i]=nombre.get(i);
        }
        SelecBache = new JComboBox (Nombre1);
        SelecBache.setBounds(100,160, 120, 20);
        SelecBache.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            area1.setText("");
        S1 = (String) SelecBache.getSelectedItem();
        
            area1.append("Id \t Calle \t tamaño\t Ubicacion\t Distrito \n"+l1.Buscar(Integer.parseInt(S1)).toString());
        
        }});
        panel.add(SelecBache);
        
        area1=new JTextArea();
        area1.setEditable(false);
        scroll1=new JScrollPane(area1);
        scroll1.setBounds(100,190, 400, 50);
        panel.add(scroll1);
        
        lblRegistroequipo=new JLabel("REGISTRO DE EQUIPO:");
        lblRegistroequipo.setBounds(100, 250, 150, 20);
        panel.add(lblRegistroequipo);
        
        lblIdEquipo=new JLabel("Id equipo:");
        lblIdEquipo.setBounds(100, 270, 150, 20);
        panel.add(lblIdEquipo);
        
        txtIdEquipo=new JTextField();
        txtIdEquipo.setBounds(100, 290, 120, 20);
        panel.add(txtIdEquipo);
        
        lblNroPersonas=new JLabel("Numero de personas en el equipo:");
        lblNroPersonas.setBounds(100, 310, 220, 20);
        panel.add(lblNroPersonas);
        
        txtNroPersonas=new JTextField();
        txtNroPersonas.setBounds(100, 330, 120, 20);
        panel.add(txtNroPersonas);
        
        lblNombreEquipo=new JLabel("Nombre del equipo:");
        lblNombreEquipo.setBounds(100, 350, 150, 20);
        panel.add(lblNombreEquipo);
        
        txtNobreEquipo=new JTextField();
        txtNobreEquipo.setBounds(100, 370, 120, 20);
        panel.add(txtNobreEquipo);
        
        btnHacerOrden=new JButton("Hacer una Orden");
        btnHacerOrden.setBounds(390, 390, 150, 20);
        btnHacerOrden.addActionListener(this);
        btnHacerOrden.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                Equipo e1=new Equipo(Integer.parseInt(txtIdEquipo.getText()), Integer.parseInt(txtNroPersonas.getText()), txtNobreEquipo.getText());
                O1=new Orden_trabajo(Integer.parseInt(txtHoras_reparacion.getText()), cadena, Integer.parseInt(txtMaterial.getText()), l1.Buscar(Integer.parseInt(S1)));
                O1.setEquipo(e1);
                a1.agregar(O1);
                visible2();
                Visible1();
                JOptionPane.showMessageDialog(null, "La orden fue registrado");
            }
});
        panel.add(btnHacerOrden);
        
        btnatras=new JButton("Atras");
        btnatras.setBounds(280, 390, 100, 20);
        btnatras.addActionListener(this);
        btnatras.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                visible2();
                Visible1();
            }
});
        panel.add(btnatras);
    }
    public void visible2(){
                Horas_reparacion.setVisible(false);
                Estado_Bache.setVisible(false);
                Cantidad_Material.setVisible(false);
                lblBache.setVisible(false);
                lblRegistroequipo.setVisible(false);
                lblNroPersonas.setVisible(false);
                lblNombreEquipo.setVisible(false);
                lblIdEquipo.setVisible(false);
   
                txtHoras_reparacion.setVisible(false);
                txtMaterial.setVisible(false);
                txtIdEquipo.setVisible(false);
                txtNroPersonas.setVisible(false);
                txtNobreEquipo.setVisible(false);
                area1.setVisible(false);
                btnHacerOrden.setVisible(false);
                btnatras.setVisible(false);
                txtEstado.setVisible(false);
               scroll1.setVisible(false);
                SelecBache.setVisible(false);
    }
    
    public void Visible1(){
        etiketa1.setVisible(true);
        combo.setVisible(true);
        btnprocesar.setVisible(true);
        scroll.setVisible(true);
    }
    
    public void registroBache(){
        etiketa1.setVisible(false);
        combo.setVisible(false);
        btnprocesar.setVisible(false);
        scroll.setVisible(false);
        
        id=new JLabel("Id:");
        id.setBounds(100, 20, 120, 20);
        panel.add(id);
        
        txtId=new JTextField();
        txtId.setBounds(100, 40, 120, 20);
        panel.add(txtId);
        
        calle=new JLabel("Calle:");
        calle.setBounds(100, 60, 120, 20);
        panel.add(calle);
        
        txtCalle=new JTextField();
        txtCalle.setBounds(100, 80, 120, 20);
        panel.add(txtCalle);
        
        tamaño=new JLabel("Tamaño:");
        tamaño.setBounds(100, 100, 120, 20);
        panel.add(tamaño);
        
        JTextField t1=new JTextField();
        t1.setBounds(100, 300, 100, 20);
        t1.setVisible(false);
        panel.add(t1);
        
        txttamanio=new JComboBox();
        txttamanio.setBounds(100, 120, 120, 20);
        for(int i=1;i<=10;i++){
            txttamanio.addItem(i);
        }
        txttamanio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numero=txttamanio.getSelectedIndex();
                switch(numero){
                     case 0:
                        t1.setText("1");
                        break;
                    case 1:
                        t1.setText("2");
                        break;
                    case 2:
                        t1.setText("3");
                        break;
                    case 3:
                        t1.setText("4");
                        break;
                    case 4:
                        t1.setText("5");
                        break;
                    case 5:
                        t1.setText("6");
                        break;
                    case 6:
                        t1.setText("7");
                        break;
                    case 7:
                        t1.setText("8");
                        break;
                    case 8:
                        t1.setText("9");
                        break;
                    default:
                      t1.setText("10");  
                }
            }
        });
        
        panel.add(txttamanio);
        
        
        ubicacion=new JLabel("Ubicacion:");
        ubicacion.setBounds(100, 140, 120, 20);
        panel.add(ubicacion);
        
        txtUbicacion=new JTextField();
        txtUbicacion.setBounds(100, 160, 120, 20);
        panel.add(txtUbicacion);
        
        distrito=new JLabel("Distrito:");
        distrito.setBounds(100, 180, 120, 20);
        panel.add(distrito);
        
        txtDistrito=new JTextField();
        txtDistrito.setBounds(100,200, 120, 20);
        panel.add(txtDistrito);
        
        btnRegistarCiudadano=new JButton("Registrar Ciudadano");
        btnRegistarCiudadano.setBounds(100,230, 170, 20);
        btnRegistarCiudadano.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                if(l1.Buscar(Integer.parseInt(txtId.getText()))!=null){
                    JOptionPane.showMessageDialog(null, "El id ya existe!!");
                }else{
                RegitroCiudadano();
                Bache b1=new Bache(Integer.parseInt(txtId.getText()), txtCalle.getText(), Integer.parseInt(t1.getText()), txtUbicacion.getText(), txtDistrito.getText());
                
                 l1.agregar(b1);
                JOptionPane.showMessageDialog(null, "El Bache fue registrado");
                }
            }
            
});
        btnRegistarCiudadano.addActionListener(this);
        panel.add(btnRegistarCiudadano);
        
    }
    
    public void RegitroCiudadano(){
        id.setVisible(false);
        txtId.setVisible(false);
        txtCalle.setVisible(false);
        calle.setVisible(false);
        tamaño.setVisible(false);
        txttamanio.setVisible(false);
        ubicacion.setVisible(false);
        txtUbicacion.setVisible(false);
        distrito.setVisible(false);
        txtDistrito.setVisible(false);
        btnRegistarCiudadano.setVisible(false);
        
        nombre=new JLabel("Nombre:");
        nombre.setBounds(100, 20, 120, 20);
        panel.add(nombre);
        
        txtNombre=new JTextField();
        txtNombre.setBounds(100, 40, 120, 20);
        panel.add(txtNombre);
        
        direccion=new JLabel("Direccion:");
        direccion.setBounds(100, 60, 120, 20);
        panel.add(direccion);
        
        txtDireccion=new JTextField();
        txtDireccion.setBounds(100, 80, 120, 20);
        panel.add(txtDireccion);
        
        telefono=new JLabel("Telefono:");
        telefono.setBounds(100, 100, 120, 20);
        panel.add(telefono);
        
        txtTelefono=new JTextField();
        txtTelefono.setBounds(100, 120, 120, 20);
        panel.add(txtTelefono);
        
        btnRegistrar=new JButton("Registrar");
        btnRegistrar.setBounds(100,150, 100, 20);
        btnRegistrar.addActionListener(this);
        btnRegistrar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                Persona p1=new Persona(txtNombre.getText(), txtDireccion.getText(), txtTelefono.getText());
                ar1.agregar(p1);
                nombre.setVisible(false);
                txtNombre.setVisible(false);
                direccion.setVisible(false);
                txtDireccion.setVisible(false);
                telefono.setVisible(false);
                txtTelefono.setVisible(false);
                btnRegistrar.setVisible(false);
                
                etiketa1.setVisible(true);
        combo.setVisible(true);
        btnprocesar.setVisible(true);
        scroll.setVisible(true);
               
            }
});
        panel.add(btnRegistrar);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        int numero=combo.getSelectedIndex();
        if(e.getSource()==btnprocesar){
            switch(numero){
            case 0:
                registroBache();
                break;
            case 1:
                
                area.setText("");
                if(l1.Listar()==""){
                    area.append("No hay registro de bache");
                }else{
                    
                area.append("Id \t Calle \t tamaño\t Ubicacion\t Distrito \n"+l1.Listar());
                }
                break;
            case 2:
                RealizarOrden();
            break;
            default:
                area.setText("");
                
               
                area.append("Estado \t Costo \n"+a1.Lista());
        }
        }
        
    }
    
}
