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
public class conMediosContactoDeportista {
    public void registrarMediosContactoDeportista(medioscontactodeportista Medios){
	conexion conex= new conexion();
		
	try{
            String consulta="insert into medioscontactodeportista (medio,numeroMedio,"
                    + "Deportista_idDeportista) values "
                    + "( ? , ? , ? ); ";
            PreparedStatement estatuto;
            estatuto = conex.getConexion().prepareStatement(consulta);	
            estatuto.setString(1, Medios.getMedio());
            estatuto.setInt(2, Medios.getNumeroMedio());
            estatuto.setInt(3, Medios.getDeportista_idDeportista());
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
    
    public void modificarMediosContactoDeportista(medioscontactodeportista Medios){
	conexion conex= new conexion();
	try{
            String consulta="UPDATE medioscontactodeportista SET medio= ? "
                    + ",numeroMedio = ? , Deportista_idDeportista=? "
                    + "WHERE Deportista_idDeportista= ? AND numeroMedio = ?";
            PreparedStatement estatuto;
            estatuto = conex.getConexion().prepareStatement(consulta);
			
            estatuto.setString(1, Medios.getMedio());
            estatuto.setInt(2, Medios.getNumeroMedio());
            estatuto.setInt(3, Medios.getDeportista_idDeportista());
            estatuto.setInt(4, Medios.getDeportista_idDeportista());
            estatuto.setInt(5, Medios.getNumeroMedio());
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
    public void eliminarMediosContactoDeportista(String codigo){
        conexion conex= new conexion();
	try{
            String consulta="DELETE FROM medioscontactodeportista WHERE Deportista_idDeportista = ?";
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
        String resultado ="Los medio para contactar al deportista son: \n ";
	try{
            String consulta="select * FROM medioscontactodeportista WHERE Deportista_idDeportista = ? ";
            PreparedStatement estatuto;
            estatuto = conex.getConexion().prepareStatement(consulta);
            estatuto.setInt(1,deportista.getIdDeportista());
            ResultSet rs = estatuto.executeQuery();
            while (rs.next())
            {
                String medio =rs.getString("medio");
                int numero = rs.getInt("numeroMedio");
                int id = rs.getInt("Deportista_idDeportista");
                resultado = resultado+medio +" \n ";
            }
            estatuto.close();
            conex.close();
			
	} catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se encontro");
	}
        return resultado;
    }
    public int NumeroDatos(deportista deportista){
        conexion conex= new conexion();
        int i=1;
	try{
            String consulta="select * FROM medioscontactodeportista WHERE Deportista_idDeportista = ? ";
            PreparedStatement estatuto;
            estatuto = conex.getConexion().prepareStatement(consulta);
            estatuto.setInt(1,deportista.getIdDeportista());
            ResultSet rs = estatuto.executeQuery();
            while (rs.next())
            {
                i++;
            }
            estatuto.close();
            conex.close();
			
	} catch (SQLException e) {
            
	}
        return i;
    }
}
