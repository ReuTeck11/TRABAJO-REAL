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
 * @author Alex
 */
public class ConLicenciado {
    
    public void registrarLicenciado(Licenciado licenciado) {
        Conexion conex = new Conexion();

        try {
            String consulta = "inser into Licenciado (nombre,apellidoPaterno,"
                    + "apellidoMaterno,telefonoOficina,horarioAtencion) values "
                    + "( ? , ? , ? , ? , ? , ? ); ";
            PreparedStatement estatuto;
            estatuto = conex.getConnection().prepareStatement(consulta);

            estatuto.setString(1, licenciado.getNombre());
            estatuto.setString(2, licenciado.getApellidoPaterno());
            estatuto.setString(3, licenciado.getApellidoMaterno());
            estatuto.setString(4, licenciado.getTelefonoOficina());
            estatuto.setString(5, licenciado.getHorarioAtencion());
            estatuto.execute();

            JOptionPane.showMessageDialog(null,
                    " Se han insertado Correctamente ",
                    "Confirmación",
                    JOptionPane.INFORMATION_MESSAGE);
            conex.desconectar();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "No se Registro" + e.toString());
        }
    }

    public void modificarLicenciado(Licenciado licenciado) {
        Conexion conex = new Conexion();
        try {
            String consulta = "UPDATE Licenciado SET idLicenciado= ? "
                    + ",nombre = ? , apellidoPaterno=? , apellidoMaterno= ? "
                    + ", telefonoOficina= ? , horarioAtencion= ? WHERE idLicenciado= ? ";
            PreparedStatement estatuto;
            estatuto = conex.getConnection().prepareStatement(consulta);

            estatuto.setInt(1, licenciado.getIdLicenciado());
            estatuto.setString(2, licenciado.getNombre());
            estatuto.setString(3, licenciado.getApellidoPaterno());
            estatuto.setString(4, licenciado.getApellidoMaterno());
            estatuto.setString(5, licenciado.getTelefonoOficina());
            estatuto.setString(6, licenciado.getHorarioAtencion());
            estatuto.setInt(7, licenciado.getIdLicenciado());
            estatuto.executeUpdate();

            JOptionPane.showMessageDialog(null,
                    " Se ha Modificado Correctamente ",
                    "Confirmación",
                    JOptionPane.INFORMATION_MESSAGE);
            estatuto.close();
            conex.desconectar();

        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null,
                    "Error al Modificar",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * permite eliminar datos de la persona asociada a su clave
     *
     * @param codigo
     */
    public void eliminarLicenciado(String codigo) {
        Conexion conex = new Conexion();
        try {
            String consulta = "DELETE FROM Licenciado WHERE idLicenciado = ? ";
            PreparedStatement estatuto;
            estatuto = conex.getConnection().prepareStatement(consulta);
            estatuto.setInt(1, Integer.parseInt(codigo));
            estatuto.executeUpdate();
            JOptionPane.showMessageDialog(null,
                    "Se ha Eliminado Correctamente",
                    "Información", JOptionPane.INFORMATION_MESSAGE);
            estatuto.close();
            conex.desconectar();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "No se Elimino");
        }
    }


}
