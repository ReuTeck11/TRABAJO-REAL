/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesBaseDeDatos;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author carlo
 */
public class conDeportista {
    public void registrarDeportista(deportista Deportista){
	Conexion conex= new Conexion();
		
	try{
            String consulta="insert into Deportista (nombre,apellidoPaterno,"
                    + "apellidoMaterno,genero,fechaNacimiento,deporte) values "
                    + "( ? , ? , ? , ? , ? , ? ); ";
            PreparedStatement estatuto;
            estatuto = conex.getConnection().prepareStatement(consulta);
			
            estatuto.setString(1, Deportista.getNombre());
            estatuto.setString(2, Deportista.getApellidoPaterno());
            estatuto.setString(3, Deportista.getApellidoMaterno());
            estatuto.setString(4, Deportista.getGenero());
            estatuto.setString(5, Deportista.getFechaNacimiento());
            estatuto.setString(6, Deportista.getDeporte());
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
    
    public void modificarDeportista(deportista Deportista){
	Conexion conex= new Conexion();
	try{
            String consulta="UPDATE Deportista SET idDeportista= ? "
                    + ",nombre = ? , apellidoPaterno=? , apellidoMaterno= ? "
                    + ", genero= ? , fechaNacimiento= ? , deporte= ?  WHERE idDeportista= ? ";
            PreparedStatement estatuto;
            estatuto = conex.getConnection().prepareStatement(consulta);
			
            estatuto.setInt(1, Deportista.getIdDeportista());
            estatuto.setString(2, Deportista.getNombre());
            estatuto.setString(3, Deportista.getApellidoPaterno());
            estatuto.setString(4, Deportista.getApellidoMaterno());
            estatuto.setString(5, Deportista.getGenero());
            estatuto.setString(6, Deportista.getFechaNacimiento());
            estatuto.setString(7, Deportista.getDeporte());
            estatuto.setInt(8, Deportista.getIdDeportista());
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
    public void eliminarDeportista(String codigo){
        Conexion conex= new Conexion();
	try{
            String consulta="DELETE FROM Deportista WHERE idDeportista = ? ";
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
