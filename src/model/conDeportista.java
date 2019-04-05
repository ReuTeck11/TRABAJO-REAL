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
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author carlo
 */
public class conDeportista {
    public void registrarDeportista(deportista Deportista){
	conexion conex= new conexion();
		
	try{
            String consulta="insert into deportista (idDeportista,nombre,apellidoPaterno,"
                    + "apellidoMaterno,genero,fechaNacimiento,deporte) values "
                    + "( ? , ? , ? , ? , ? , ? , ? ); ";
            PreparedStatement estatuto;
            estatuto = conex.getConexion().prepareStatement(consulta);
            estatuto.setInt(1, Deportista.getIdDeportista());
            estatuto.setString(2, Deportista.getNombre());
            estatuto.setString(3, Deportista.getApellidoPaterno());
            estatuto.setString(4, Deportista.getApellidoMaterno());
            estatuto.setString(5, Deportista.getGenero());
            estatuto.setString(6, Deportista.getFechaNacimiento());
            estatuto.setString(7, Deportista.getDeporte());
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
    
    public void modificarDeportista(deportista Deportista){
	conexion conex= new conexion();
	try{
            String consulta="UPDATE deportista SET idDeportista= ? "
                    + ",nombre = ? , apellidoPaterno=? , apellidoMaterno= ? "
                    + ", genero= ? , fechaNacimiento= ? , deporte= ?  WHERE idDeportista= ? ";
            PreparedStatement estatuto;
            estatuto = conex.getConexion().prepareStatement(consulta);
			
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
    public void eliminarDeportista(String codigo){
        conexion conex= new conexion();
	try{
            String consulta="DELETE FROM deportista WHERE idDeportista = ? ";
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
    public String buscarDeportista(deportista deportista){
        conexion conex= new conexion();
        String resultado ="";
	try{
            String consulta="select * FROM deportista WHERE idDeportista = ? ";
            PreparedStatement estatuto;
            estatuto = conex.getConexion().prepareStatement(consulta);
            estatuto.setInt(1,deportista.getIdDeportista());
            ResultSet rs = estatuto.executeQuery();
            while (rs.next())
            {
                String id =Integer.toString(rs.getInt("idDeportista"));
                String nombre = rs.getString("nombre");
                String APaterno = rs.getString("apellidoPaterno");
                String AMaterno = rs.getString("apellidoMaterno");
                String genero = rs.getString("genero");
                Date fecha = rs.getDate("fechaNacimiento");
                String deporte = rs.getString("deporte");
                resultado = resultado+id+",  "+nombre+",  "+APaterno+",  "+AMaterno+",  "+genero+",  "+fecha+",  "+deporte+" \n ";
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
