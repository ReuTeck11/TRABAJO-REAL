/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author carlo
 */
public class Logica {
    conDeportista conDeportista=new conDeportista();
    conEstudiante conEstudiante=new conEstudiante();
    conMediosContactoDeportista mediosDeportista = new conMediosContactoDeportista();
    conMediosContactoEstudiante mediosEstudiante = new conMediosContactoEstudiante();
    public void ingresarDeportista(deportista deportista,medioscontactodeportista medio){
        if(deportista.getNombre()!=""){
            conDeportista.registrarDeportista(deportista);
            mediosDeportista.registrarMediosContactoDeportista(medio);
        }
    }
    public void modificarDeportista(deportista deportista){
        if(deportista.getNombre()!=""){
            conDeportista.modificarDeportista(deportista);
        }
    }
    public void eliminarDeportista(int deportista){
        if(deportista!=0){
            mediosDeportista.eliminarMediosContactoDeportista(Integer.toString(deportista));
            conDeportista.eliminarDeportista(Integer.toString(deportista));
        }
    }
    public String buscarDeportista(deportista deportista){
        if(deportista.getIdDeportista()!=null){
            return conDeportista.buscarDeportista(deportista);
        }
        return "";
    }
    
    public void ingresarEstudiante(estudiante estudiante,medioscontactoestudiante medio){
        if(estudiante.getNombre()!=""){
            conEstudiante.registrarEstudiante(estudiante);
            mediosEstudiante.registrarMediosContactoEstudiante(medio);
        }
    }
    public void modificarEstudiante(estudiante estudiante){
        if(estudiante.getNombre()!=""){
            conEstudiante.modificarEstudiante(estudiante);
        }
    }
    public void eliminarEstudiante(int estudiante){
        if(estudiante!=0){
            mediosEstudiante.eliminarEstudiante(Integer.toString(estudiante));
            conEstudiante.eliminarEstudiante(Integer.toString(estudiante));
        }
    }
    public String buscarEstudiante(estudiante estudiante){
        if(estudiante.getIdEstudiante()!=null){
            return conEstudiante.buscarEstudiante(estudiante);
        }
        return "";
    }
}
