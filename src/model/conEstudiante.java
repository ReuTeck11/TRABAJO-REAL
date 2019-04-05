/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author carlo
 */
public class conEstudiante {
    public void registrarEstudiante(estudiante Estudiante){
	conexion conex= new conexion();
		
	try{
            String consulta="insert into estudiante (idEstudiante,nombre,apellidoPaterno,"
                    + "apellidoMaterno,lugarNacimiento,fechaNacimiento,carrera,email) values "
                    + "( ? , ? , ? , ? , ? , ? , ? , ? ); ";
            PreparedStatement estatuto;
            estatuto = conex.getConexion().prepareStatement(consulta);
            estatuto.setInt(1, Estudiante.getIdEstudiante());
            estatuto.setString(2, Estudiante.getNombre());
            estatuto.setString(3, Estudiante.getApellidoPaterno());
            estatuto.setString(4, Estudiante.getApellidoMaterno());
            estatuto.setString(5, Estudiante.getLugarNacimiento());
            estatuto.setString(6, Estudiante.getFechaNacimiento());
            estatuto.setString(7, Estudiante.getCarrera());
            estatuto.setString(8, Estudiante.getEmail());
            estatuto.execute();

            JOptionPane.showMessageDialog(null, 
                    " Se han insertado Correctamente ",
                    "Confirmación",
                    JOptionPane.INFORMATION_MESSAGE);
                conex.close();
			
	} catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "No se Registro"+e.toString());
        }
    }
    
    public void modificarEstudiante(estudiante Estudiante){
	conexion conex= new conexion();
	try{
            String consulta="UPDATE estudiante SET idEstudiante= ? "
                    + ",nombre = ? , apellidoPaterno=? , apellidoMaterno= ? "
                    + ", lugarNacimiento= ? , fechaNacimiento= ? , carrera= ? , email= ? WHERE idEstudiante= ? ";
            PreparedStatement estatuto;
            estatuto = conex.getConexion().prepareStatement(consulta);
			
            estatuto.setInt(1, Estudiante.getIdEstudiante());
            estatuto.setString(2, Estudiante.getNombre());
            estatuto.setString(3, Estudiante.getApellidoPaterno());
            estatuto.setString(4, Estudiante.getApellidoMaterno());
            estatuto.setString(5, Estudiante.getLugarNacimiento());
            estatuto.setString(6, Estudiante.getFechaNacimiento());
            estatuto.setString(7, Estudiante.getCarrera());
            estatuto.setString(8, Estudiante.getEmail());
            estatuto.setInt(9, Estudiante.getIdEstudiante());
            estatuto.executeUpdate();

            JOptionPane.showMessageDialog(null, 
                    " Se ha Modificado Correctamente ",
                    "Confirmación",
                    JOptionPane.INFORMATION_MESSAGE);
            estatuto.close();
            conex.close();
            
        }catch(SQLException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, 
                    "Error al Modificar",
                    "Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
    * permite eliminar datos de la persona asociada a su clave
    * @param codigo 
    */
    public void eliminarEstudiante(String codigo){
        conexion conex= new conexion();
	try{
            String consulta="DELETE FROM estudiante WHERE idEstudiante = ? ";
            PreparedStatement estatuto;
            estatuto = conex.getConexion().prepareStatement(consulta);
            estatuto.setInt(1,Integer.parseInt(codigo));
            estatuto.executeUpdate();
            JOptionPane.showMessageDialog(null,
                    "Se ha Eliminado Correctamente",
                    "Información",JOptionPane.INFORMATION_MESSAGE);
            estatuto.close();
            conex.close();
			
	} catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "No se Elimino");
	}
    }
    public String buscarEstudiante(estudiante estudiante){
        conexion conex= new conexion();
        String resultado ="";
	try{
            String consulta="select * FROM estudiante WHERE idEstudiante = ? ";
            PreparedStatement estatuto;
            estatuto = conex.getConexion().prepareStatement(consulta);
            estatuto.setInt(1,estudiante.getIdEstudiante());
            ResultSet rs = estatuto.executeQuery();
            while (rs.next())
            {
                String id =Integer.toString(rs.getInt("idEstudiante"));
                String nombre = rs.getString("nombre");
                String APaterno = rs.getString("apellidoPaterno");
                String AMaterno = rs.getString("apellidoMaterno");
                String lugarNacimiento = rs.getString("lugarNacimiento");
                Date fecha = rs.getDate("fechaNacimiento");
                String carrera = rs.getString("carrera");
                String email = rs.getString("email");
                resultado = resultado+id+",  "+nombre+",  "+APaterno+",  "+AMaterno+",  "+lugarNacimiento+",  "+fecha+",  "+carrera+",  "+email+" \n ";
            }
            estatuto.close();
            conex.close();
			
	} catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "No se encontro");
	}
        return resultado;
    }
}
