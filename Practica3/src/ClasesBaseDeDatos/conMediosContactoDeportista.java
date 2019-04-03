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
public class conMediosContactoDeportista {
    public void registrarMediosContactoDeportista(medioscontactodeportista Medios){
	Conexion conex= new Conexion();
		
	try{
            String consulta="insert into MediosContactoDeportista (medio,numeroMedio,"
                    + "Deportista_idDeportista) values "
                    + "( ? , ? , ? ); ";
            PreparedStatement estatuto;
            estatuto = conex.getConnection().prepareStatement(consulta);
			
            estatuto.setString(1, Medios.getMedio());
            estatuto.setInt(2, Medios.getNumeroMedio());
            estatuto.setInt(3, Medios.getDeportista_idDeportista());
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
    
    public void modificarMediosContactoDeportista(medioscontactodeportista Medios){
	Conexion conex= new Conexion();
	try{
            String consulta="UPDATE MediosContactoDeportista SET medio= ? "
                    + ",numeroMedio = ? , Deportista_idDeportista=? "
                    + "WHERE Deportista_idDeportista= ? AND numeroMedio = ?";
            PreparedStatement estatuto;
            estatuto = conex.getConnection().prepareStatement(consulta);
			
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
    public void eliminarMediosContactoDeportista(String codigo,String numeroMedio){
        Conexion conex= new Conexion();
	try{
            String consulta="DELETE FROM MediosContactoDeportista WHERE Deportista_idDeportista = ? AND numeroMedio = ?";
            PreparedStatement estatuto;
            estatuto = conex.getConnection().prepareStatement(consulta);
            estatuto.setInt(1,Integer.parseInt(codigo));
            estatuto.setInt(2,Integer.parseInt(numeroMedio));
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
