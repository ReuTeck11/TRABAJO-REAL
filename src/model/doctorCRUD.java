
package model;
import java.sql.*;
import javax.swing.JOptionPane;

public class doctorCRUD extends conexion {
    conexion c = new conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean modificarDoctor(doctor doc){
      PreparedStatement ps = null;
       Connection con = getConexion();
       
       try{
       ps = con.prepareStatement("UPDATE doctor SET  nombre=?,apellidoPaterno=?,apellidoMaterno=?,"
               + "fechaNacimiento=?,especialidad=?,nombreHospital=?,direccionHospital=? WHERE idDoctor = ?");
            
            ps.setString(1,doc.getNombre());
            ps.setString(2,doc.getApellidoPaterno());
            ps.setString(3,doc.getApellidoMaterno());
            ps.setString(4,doc.getFechaNacimiento());
            ps.setString(5,doc.getEspecialidad());
            ps.setString(6,doc.getNombreHospital());
            ps.setString(7,doc.getDireccionHospital());
            ps.setInt(8,doc.getIdDoctor());
            ps.execute();
            return true;
                 
       }catch(SQLException e){
           System.err.println(e.getMessage());
           return false;
       }finally{
           try{
               con.close();
            }catch(SQLException e){
               System.err.println(e.getMessage());
            }
       }
       
    } 
    
    public boolean guardarDoctor(doctor doc){
      PreparedStatement ps = null;
       Connection con = getConexion();
       
       try{
       ps = con.prepareStatement("INSERT INTO doctor (nombre,apellidoPaterno,apellidoMaterno,fechaNacimiento,especialidad,nombreHospital,direccionHospital)"
                    + "VALUES (?,?,?,?,?,?,?)");
           
            ps.setString(1,doc.getNombre());
            ps.setString(2,doc.getApellidoPaterno());
            ps.setString(3,doc.getApellidoMaterno());
            ps.setString(4,doc.getFechaNacimiento());
            ps.setString(5,doc.getEspecialidad());
            ps.setString(6,doc.getNombreHospital());
            ps.setString(7,doc.getDireccionHospital());
            ps.execute();
            return true;        
                 
       }catch(Exception e){
           System.err.println(e.getMessage());
           return false;
       }finally{
           try{
               con.close();
            }catch(Exception e){
               System.err.println(e.getMessage());
            }
       }
    } 
    
    public boolean eliminarDoctor(doctor doc){
      PreparedStatement ps = null;
       Connection con = getConexion();
       
       try{
       ps = con.prepareStatement("DELETE  FROM doctor WHERE idDoctor = ?");
            
            ps.setInt(1,doc.getIdDoctor());
            ps.execute();
            return true;        
                 
       }catch(Exception e){
           System.err.println(e.getMessage());
           return false;
       }finally{
           try{
               con.close();
            }catch(Exception e){
               System.err.println(e.getMessage());
            }
       }
    } 
    
    public boolean buscarDoctor(doctor doc){
      PreparedStatement ps = null;
       Connection con = getConexion();
       ResultSet rs = null;
       
       try{
       ps = con.prepareStatement("SELECT * FROM doctor WHERE idDoctor = ?");
            
            ps.setInt(1,doc.getIdDoctor());
            rs = ps.executeQuery();
            
            if(rs.next()){
                doc.setIdDoctor(Integer.parseInt(rs.getString("idDoctor")));               
                doc.setNombre(rs.getString("nombre"));
                doc.setApellidoPaterno(rs.getString("apellidoPaterno"));
                doc.setApellidoMaterno(rs.getString("apellidoMaterno"));
                doc.setFechaNacimiento(rs.getString("fechaNacimiento"));
                doc.setEspecialidad(rs.getString("especialidad"));
                doc.setNombreHospital(rs.getString("nombreHospital"));
                doc.setDireccionHospital(rs.getString("direccionHospital"));
                return true;
            }
                return false;
            
       }catch(Exception e){
           System.err.println(e.getMessage());
           return false;
       }finally{
           try{
               con.close();
            }catch(Exception e){
               System.err.println(e.getMessage());
            }
       }
    }
    
    public boolean guardarMedio(doctor doc){
      PreparedStatement ps = null;
       Connection con = getConexion();
       try{
       ps = con.prepareStatement("INSERT INTO medioscontactodoctor (medio,numeroMedio,Doctor_idDoctor)"
                    + "VALUES (?,?,?)");
           
            ps.setString(1,doc.getMedio());
            ps.setInt(2,doc.getNumeroMedio());
            ps.setInt(3,doc.getIdDoctor());       
            ps.execute();
            return true;        
                 
       }catch(Exception e){
           System.err.println(e.getMessage());
           return false;
       }finally{
           try{
               con.close();
            }catch(Exception e){
               System.err.println(e.getMessage());
            }
       }
    }
    
     public boolean buscarMedio(doctor doc){
      PreparedStatement ps = null;
       Connection con = getConexion();
       ResultSet rs = null;
       
       try{
       ps = con.prepareStatement("SELECT * FROM medioscontactodoctor WHERE Doctor_idDoctor = ?");
            
            ps.setInt(1,doc.getIdDoctor());
            rs = ps.executeQuery();
            
            if(rs.next()){
                              
                doc.setMedio(rs.getString("medio"));
                doc.setNumeroMedio(Integer.parseInt(rs.getString("numeroMedio")));
                doc.setIdDoctor(Integer.parseInt(rs.getString("Doctor_idDoctor")));
                
                return true;
            }
                return false;
            
       }catch(Exception e){
           System.err.println(e.getMessage());
           return false;
       }finally{
           try{
               con.close();
            }catch(Exception e){
               System.err.println(e.getMessage());
            }
       }
    }
    
}
