
package model;
import java.sql.*;
import javax.swing.JOptionPane;

public class conexion {
    //Aquí va la conexión a la base de datos
    private final String base = "contactos";
    private final String user = "root";
    private final String password = "";
    private final String url = "jdbc:mysql://localhost:3306/"+base;
    private Connection conn = null;
    
    public Connection getConexion(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(this.url,this.user,this.password);
          
            //JOptionPane.showMessageDialog(null,"se conecto");
          
        }catch(Exception e){
            System.out.println("Error de conexión");
        }
        return conn;
    } 

    void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
