/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.sql.*;
import View.*;
import model.Logica;
import model.conMediosContactoDeportista;
import model.conMediosContactoEstudiante;
import model.deportista;
import model.estudiante;
import model.medioscontactodeportista;
import model.medioscontactoestudiante;
import view.VistaDeportista;
import view.VistaEstudiante;
/**
 *
 * @author carlo
 */
public class Controlador implements ActionListener{
    private VistaDeportista VistaDeportista;
    private VistaEstudiante VistaEstudiante;
    private Logica miLogica;
    deportista deportista = new deportista();
    estudiante estudiante = new estudiante();
    private medioscontactodeportista mediosDeportista = new medioscontactodeportista();
    private medioscontactoestudiante mediosEstudiante = new medioscontactoestudiante();
    private conMediosContactoDeportista MediosDeportista = new conMediosContactoDeportista();
    private conMediosContactoEstudiante MediosEstudiante = new conMediosContactoEstudiante();
    //En el constructor inicializamos nuestros objetos 
    public Controlador(VistaDeportista deportista,VistaEstudiante estudiante,Logica miLogica){
        this.VistaDeportista = deportista;
        this.VistaEstudiante = estudiante;
        this.miLogica= miLogica;
        
        this.VistaDeportista.btnAgregar.addActionListener(this);
        this.VistaDeportista.btnBuscar.addActionListener(this);
        this.VistaDeportista.btnEliminar.addActionListener(this);
        this.VistaDeportista.btnModificar.addActionListener(this);
        
        this.VistaEstudiante.btnAgregar.addActionListener(this);
        this.VistaEstudiante.btnBuscar.addActionListener(this);
        this.VistaEstudiante.btnEliminar.addActionListener(this);
        this.VistaEstudiante.btnModificar.addActionListener(this);
    }
    
    /*
    METODOS UTILES PARA VENTANAS 
    */
    public void limpiarDeportista(){
        VistaDeportista.txtApellidoMaterno.setText("");
        VistaDeportista.txtApellidoPaterno.setText("");
        VistaDeportista.txtIdDeportista.setText("");
        VistaDeportista.txtNombre.setText("");
        VistaDeportista.txtDeporte.getItemAt(0);
        VistaDeportista.txtAño.getItemAt(0);
        VistaDeportista.txtDia.getItemAt(0);
        VistaDeportista.txtGenero.getItemAt(0);
        VistaDeportista.txtMes.getItemAt(0);
        VistaDeportista.txtMedioContacto.setText("");
    }
    /*
    Lógica de los botones y eventos
    */
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == VistaDeportista.btnAgregar ){
            deportista.setIdDeportista(Integer.parseInt(VistaDeportista.txtIdDeportista.getText()));
            deportista.setNombre(VistaDeportista.txtNombre.getText());
            deportista.setApellidoPaterno(VistaDeportista.txtApellidoPaterno.getText());
            deportista.setApellidoMaterno(VistaDeportista.txtApellidoMaterno.getText());
            deportista.setGenero((String)VistaDeportista.txtGenero.getSelectedItem());
            String fechaNacimiento =(String)VistaDeportista.txtAño.getSelectedItem();
            fechaNacimiento = fechaNacimiento+"-"+(String)VistaDeportista.txtMes.getSelectedItem();
            fechaNacimiento = fechaNacimiento+"-"+(String)VistaDeportista.txtDia.getSelectedItem();
            deportista.setFechaNacimiento(fechaNacimiento);
            deportista.setDeporte((String)VistaDeportista.txtDeporte.getSelectedItem());
            mediosDeportista.setDeportista_idDeportista(Integer.parseInt(VistaDeportista.txtIdDeportista.getText()));
            mediosDeportista.setMedio(VistaDeportista.txtMedioContacto.getText());
            mediosDeportista.setNumeroMedio(MediosDeportista.NumeroDatos(deportista));
            miLogica.ingresarDeportista(deportista,mediosDeportista);
        }
        if(e.getSource() == VistaDeportista.btnModificar){
            deportista.setIdDeportista(Integer.parseInt(VistaDeportista.txtIdDeportista.getText()));
            deportista.setNombre(VistaDeportista.txtNombre.getText());
            deportista.setApellidoPaterno(VistaDeportista.txtApellidoPaterno.getText());
            deportista.setApellidoMaterno(VistaDeportista.txtApellidoMaterno.getText());
            deportista.setGenero((String)VistaDeportista.txtGenero.getSelectedItem());
            String fechaNacimiento =(String)VistaDeportista.txtAño.getSelectedItem();
            fechaNacimiento = fechaNacimiento+"-"+(String)VistaDeportista.txtMes.getSelectedItem();
            fechaNacimiento = fechaNacimiento+"-"+(String)VistaDeportista.txtDia.getSelectedItem();
            deportista.setFechaNacimiento(fechaNacimiento);
            deportista.setDeporte((String)VistaDeportista.txtDeporte.getSelectedItem());
            miLogica.modificarDeportista(deportista);
        }
        if(e.getSource() == VistaDeportista.btnEliminar){
            int eliminar = Integer.parseInt(VistaDeportista.txtIdDeportista.getText());
            miLogica.eliminarDeportista(eliminar);
        }
        if(e.getSource() == VistaDeportista.btnBuscar){
           deportista.setIdDeportista(Integer.parseInt(VistaDeportista.txtIdDeportista.getText()));
           String resultado = miLogica.buscarDeportista(deportista);
           resultado = resultado+MediosDeportista.buscarDeportista(deportista);
           VistaDeportista.texto.setText(resultado);
        }
        
        
        if(e.getSource() == VistaEstudiante.btnAgregar ){
            estudiante.setIdEstudiante(Integer.parseInt(VistaEstudiante.txtIdEstudiante.getText()));
            estudiante.setNombre(VistaEstudiante.txtNombre.getText());
            estudiante.setApellidoPaterno(VistaEstudiante.txtApellidoPaterno.getText());
            estudiante.setApellidoMaterno(VistaEstudiante.txtApellidoMaterno1.getText());
            estudiante.setLugarNacimiento((String)VistaEstudiante.txtLugarNacimiento.getText());
            String fechaNacimiento =(String)VistaEstudiante.txtAño.getSelectedItem();
            fechaNacimiento = fechaNacimiento+"-"+(String)VistaEstudiante.txtMes.getSelectedItem();
            fechaNacimiento = fechaNacimiento+"-"+(String)VistaEstudiante.txtDia.getSelectedItem();
            estudiante.setFechaNacimiento(fechaNacimiento);
            estudiante.setCarrera((String)VistaEstudiante.txtCarrera.getText());
            estudiante.setEmail((String)VistaEstudiante.txtEmail1.getText());
            mediosEstudiante.setEstudiante_idEstudiante(Integer.parseInt(VistaEstudiante.txtIdEstudiante.getText()));
            mediosEstudiante.setMedio(VistaEstudiante.txtMedioContacto1.getText());
            mediosEstudiante.setNumeroMedio(MediosEstudiante.NumeroDatos(estudiante));
            miLogica.ingresarEstudiante(estudiante,mediosEstudiante);
        }
        if(e.getSource() == VistaEstudiante.btnModificar){
            estudiante.setIdEstudiante(Integer.parseInt(VistaEstudiante.txtIdEstudiante.getText()));
            estudiante.setNombre(VistaEstudiante.txtNombre.getText());
            estudiante.setApellidoPaterno(VistaEstudiante.txtApellidoPaterno.getText());
            estudiante.setApellidoMaterno(VistaEstudiante.txtApellidoMaterno1.getText());
            estudiante.setLugarNacimiento((String)VistaEstudiante.txtLugarNacimiento.getText());
            String fechaNacimiento =(String)VistaEstudiante.txtAño.getSelectedItem();
            fechaNacimiento = fechaNacimiento+"-"+(String)VistaEstudiante.txtMes.getSelectedItem();
            fechaNacimiento = fechaNacimiento+"-"+(String)VistaEstudiante.txtDia.getSelectedItem();
            estudiante.setFechaNacimiento(fechaNacimiento);
            estudiante.setCarrera((String)VistaEstudiante.txtCarrera.getText());
            estudiante.setEmail((String)VistaEstudiante.txtEmail1.getText());
            miLogica.modificarEstudiante(estudiante);
        }
        if(e.getSource() == VistaEstudiante.btnEliminar){
            int eliminar = Integer.parseInt(VistaEstudiante.txtIdEstudiante.getText());
            miLogica.eliminarEstudiante(eliminar);
        }
        if(e.getSource() == VistaEstudiante.btnBuscar){
           estudiante.setIdEstudiante(Integer.parseInt(VistaEstudiante.txtIdEstudiante.getText()));
           String resultado = miLogica.buscarEstudiante(estudiante);
           resultado = resultado+MediosEstudiante.buscarEstudiante(estudiante);
           VistaEstudiante.texto.setText(resultado);
        }
    }// fin de actionPerformed
}
