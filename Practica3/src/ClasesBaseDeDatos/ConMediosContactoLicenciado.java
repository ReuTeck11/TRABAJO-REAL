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
public class ConMediosContactoLicenciado {

    public void registrarMediosContactoLicenciado(medioscontactolicenciado Medios) {
        Conexion conex = new Conexion();

        try {
            String consulta = "insert into MediosContactoLicenciado (medio,numeroMedio,"
                    + "licenciado_idLicenciado) values "
                    + "( ? , ? , ? ); ";
            PreparedStatement estatuto;
            estatuto = conex.getConnection().prepareStatement(consulta);

            estatuto.setString(1, Medios.getMedio());
            estatuto.setInt(2, Medios.getNumeroMedio());
            estatuto.setInt(3, Medios.getLicenciado_idLicenciado());
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

    public void modificarMediosContactoLicenciado(medioscontactolicenciado Medios) {
        Conexion conex = new Conexion();
        try {
            String consulta = "UPDATE MediosContactoLicenciado SET medio= ? "
                    + ",numeroMedio = ? , licenciado_idLicenciado=? "
                    + "WHERE licenciado_idLicenciado= ? AND numeroMedio = ?";
            PreparedStatement estatuto;
            estatuto = conex.getConnection().prepareStatement(consulta);

            estatuto.setString(1, Medios.getMedio());
            estatuto.setInt(2, Medios.getNumeroMedio());
            estatuto.setInt(3, Medios.getLicenciado_idLicenciado());
            estatuto.setInt(4, Medios.getLicenciado_idLicenciado());
            estatuto.setInt(5, Medios.getNumeroMedio());
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
    public void eliminarMediosContactoLicenciado(String codigo, String numeroMedio) {
        Conexion conex = new Conexion();
        try {
            String consulta = "DELETE FROM MediosContactoLicenciado WHERE licenciado_idLicenciado = ? AND numeroMedio = ?";
            PreparedStatement estatuto;
            estatuto = conex.getConnection().prepareStatement(consulta);
            estatuto.setInt(1, Integer.parseInt(codigo));
            estatuto.setInt(2, Integer.parseInt(numeroMedio));
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
