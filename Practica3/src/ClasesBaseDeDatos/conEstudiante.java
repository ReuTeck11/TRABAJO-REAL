/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesBaseDeDatos;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author carlo
 */
public class conEstudiante {
    public void registrarEstudiante(estudiante Estudiante){
	Conexion conex= new Conexion();
		
	try{
            String consulta="insert into Deportista (nombre,apellidoPaterno,"
                    + "apellidoMaterno,lugarNacimiento,fechaNacimiento,carrera,email) values "
                    + "( ? , ? , ? , ? , ? , ? , ? ); ";
            PreparedStatement estatuto;
            estatuto = conex.getConnection().prepareStatement(consulta);
			
            estatuto.setString(1, Estudiante.getNombre());
            estatuto.setString(2, Estudiante.getApellidoPaterno());
            estatuto.setString(3, Estudiante.getApellidoMaterno());
            estatuto.setString(4, Estudiante.getLugarNacimiento());
            estatuto.setString(5, Estudiante.getFechaNacimiento());
            estatuto.setString(6, Estudiante.getCarrera());
            estatuto.setString(7, Estudiante.getEmail());
            estatuto.execute();

            JOptionPane.showMessageDialog(null, 
                    " Se han insertado Correctamente ",
                    "Confirmación",
                    JOptionPane.INFORMATION_MESSAGE);
                conex.desconectar();
			
	} catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "No se Registro"+e.toString());
        }
    }
    
    public void modificarEstudiante(estudiante Estudiante){
	Conexion conex= new Conexion();
	try{
            String consulta="UPDATE Estudiante SET idEstudiante= ? "
                    + ",nombre = ? , apellidoPaterno=? , apellidoMaterno= ? "
                    + ", lugarNacimiento= ? , fechaNacimiento= ? , carrera= ? , email= ? WHERE idEstudiante= ? ";
            PreparedStatement estatuto;
            estatuto = conex.getConnection().prepareStatement(consulta);
			
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
            conex.desconectar();
            
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
        Conexion conex= new Conexion();
	try{
            String consulta="DELETE FROM Estudiante WHERE idEstudiante = ? ";
            PreparedStatement estatuto;
            estatuto = conex.getConnection().prepareStatement(consulta);
            estatuto.setInt(1,Integer.parseInt(codigo));
            estatuto.executeUpdate();
            JOptionPane.showMessageDialog(null,
                    "Se ha Eliminado Correctamente",
                    "Información",JOptionPane.INFORMATION_MESSAGE);
            estatuto.close();
            conex.desconectar();
			
	} catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "No se Elimino");
	}
    }
}
