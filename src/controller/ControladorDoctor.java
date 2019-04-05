
package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.doctor;
import model.doctorCRUD;
import view.FDoctor;


public class ControladorDoctor implements ActionListener {
    private doctorCRUD CRUDdoctor;
    private FDoctor    Form;
    private doctor     modeloDoctor;

    
    public ControladorDoctor(doctorCRUD CRUDdoctor,FDoctor Form, doctor modeloDoctor){
       
        this.CRUDdoctor = CRUDdoctor;
        this.Form = Form;
        this.modeloDoctor = modeloDoctor;
        this.Form.btnRegistrar.addActionListener(this);
        this.Form.btnEliminar.addActionListener(this);
        this.Form.btnActualizar.addActionListener(this);
        this.Form.btnConsultar.addActionListener(this);
        this.Form.btnInsertarMedio.addActionListener(this);
        this.Form.btnConsultarMedio.addActionListener(this);
    } 
    
    public void iniciar(){
        //Form.txtIdDoctor.setVisible(false);  
        Form.setVisible(true);
        
    }
   
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == Form.btnRegistrar){
           if(Form.txtNombre.getText().equals("") || Form.txtApPat.getText().equals("")||Form.cbEspecialidad.getSelectedItem().toString().equals("")){   
                JOptionPane.showMessageDialog(null, "Debes ingresar los campos obligatorios");
            }else{
                modeloDoctor.setNombre(Form.txtNombre.getText());
                modeloDoctor.setApellidoPaterno(Form.txtApPat.getText());
                modeloDoctor.setApellidoMaterno(Form.txtApMat.getText());
                modeloDoctor.setFechaNacimiento(Form.txtFechaNac.getText());
                modeloDoctor.setEspecialidad(Form.cbEspecialidad.getSelectedItem().toString());
                modeloDoctor.setNombreHospital(Form.txtNomHospital.getText());
                modeloDoctor.setDireccionHospital(Form.txtDireHospital.getText());
                

                if(CRUDdoctor.guardarDoctor(modeloDoctor)){

                    JOptionPane.showMessageDialog(null,"Registro exitoso");
                    limpiar();
                }else{
                    JOptionPane.showMessageDialog(null,"Registro no exitoso");
                    limpiar();
                }
            }
        }
        
        if(e.getSource() == Form.btnActualizar){
           modeloDoctor.setIdDoctor(Integer.parseInt(Form.txtIdDoctor.getText()));
           modeloDoctor.setNombre(Form.txtNombre.getText());
           modeloDoctor.setApellidoPaterno(Form.txtApPat.getText());
           modeloDoctor.setApellidoMaterno(Form.txtApMat.getText());
           modeloDoctor.setFechaNacimiento(Form.txtFechaNac.getText());
           modeloDoctor.setEspecialidad(Form.cbEspecialidad.getSelectedItem().toString());
           modeloDoctor.setNombreHospital(Form.txtNomHospital.getText());
           modeloDoctor.setDireccionHospital(Form.txtDireHospital.getText());
           
           if(CRUDdoctor.modificarDoctor(modeloDoctor)){
               JOptionPane.showMessageDialog(null,"Se ha modificado");
               limpiar();
           }else{
               JOptionPane.showMessageDialog(null,"No se ha modificado");
               limpiar();
           }
        }
        
        if(e.getSource() == Form.btnEliminar){
            if(Form.txtIdDoctor.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Debes ingresar un id para eliminar");
            }else{
                modeloDoctor.setIdDoctor(Integer.parseInt(Form.txtIdDoctor.getText()));

                if(CRUDdoctor.eliminarDoctor(modeloDoctor)){
                    JOptionPane.showMessageDialog(null,"Se elimino");
                    limpiar();
                }else{
                    JOptionPane.showMessageDialog(null,"No se elimino");
                    limpiar();
                }
            }
        }
        
        if(e.getSource() == Form.btnConsultar){
            if(Form.txtIdDoctor.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Debes ingresar un id para hacer la consulta");
            }else{
                modeloDoctor.setIdDoctor(Integer.parseInt(Form.txtIdDoctor.getText()));

                if(CRUDdoctor.buscarDoctor(modeloDoctor)){
                    Form.txtIdDoctor.setText(String.valueOf(modeloDoctor.getIdDoctor()));
                    Form.txtNombre.setText(String.valueOf(modeloDoctor.getNombre()));
                    Form.txtApPat.setText(String.valueOf(modeloDoctor.getApellidoPaterno()));
                    Form.txtApMat.setText(String.valueOf(modeloDoctor.getApellidoMaterno()));
                    Form.txtFechaNac.setText(String.valueOf(modeloDoctor.getFechaNacimiento()));               
                    Form.txtEspecialidad.setText(String.valueOf(modeloDoctor.getEspecialidad()));
                    Form.txtNomHospital.setText(String.valueOf(modeloDoctor.getNombreHospital()));
                    Form.txtDireHospital.setText(String.valueOf(modeloDoctor.getDireccionHospital()));

                }else{
                    JOptionPane.showMessageDialog(null,"No se encontro el resultado");
                    limpiar();
                }
             }
        }
        
        if(e.getSource() == Form.btnLimpiar){
           limpiar();
        }  
        
         if(e.getSource() == Form.btnInsertarMedio){
           
            modeloDoctor.setMedio(Form.txtMedio.getText());
            modeloDoctor.setNumeroMedio(Integer.parseInt(Form.txtNumMedio.getText()));
            modeloDoctor.setIdDoctor(Integer.parseInt(Form.txtIdDoctor.getText()));
    
            if(CRUDdoctor.guardarMedio(modeloDoctor)){
                JOptionPane.showMessageDialog(null,"Registro de medio exitoso");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null,"Registro de medio no exitoso");
                limpiar();
            }  
        }
         
         if(e.getSource() == Form.btnConsultarMedio){
            if(Form.txtIdDoctor.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Debes ingresar un id para hacer la consulta para el medio");
            }else{
                modeloDoctor.setIdDoctor(Integer.parseInt(Form.txtIdDoctor.getText()));

                if(CRUDdoctor.buscarMedio(modeloDoctor)){
                    Form.txtAreaMedios.setText(Form.txtMedio.getText());
 
                }else{
                    JOptionPane.showMessageDialog(null,"No se encontro el resultado");
                    limpiar();
                }
             }
        }
         
         
    }
    
    
   
    public void limpiar(){
        Form.txtIdDoctor.setText(null);
        Form.txtNombre.setText(null);
        Form.txtApPat.setText(null);
        Form.txtApMat.setText(null);
        Form.txtFechaNac.setText(null);
        Form.txtEspecialidad.setText(null);
        Form.txtNomHospital.setText(null);
        Form.txtDireHospital.setText(null);
    }
}
