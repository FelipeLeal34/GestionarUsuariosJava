/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelodao;

import config.Conexion;
import interfaz.MeAprendizFicha;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Aprendiz;
import modelo.AprendizFicha;

/**
 *
 * @author APRENDIZ
 */
public class AprendizFichaDao implements MeAprendizFicha {

    
    PreparedStatement ps;
    Connection cn;
    Conexion con = new Conexion();
    ResultSet rs;
    Aprendiz ap = new Aprendiz();
    AprendizFicha apficha = new AprendizFicha();
    
    
    
    @Override
    public boolean registrarAprendizFicha(AprendizFicha apficha) {
       String sql = "insert into aprendiz_ficha(codficha,idA)values(?,?)";
        try {
            cn = con.getConnection();
            
             ps = cn.prepareStatement(sql);
            
            
          
            
            for(int idAp:apficha.getIdA()){
                
           
              
                ps.setInt(1,apficha.getCodficha());
                ps.setInt(2,idAp);
                ps.executeUpdate();
            }
            
            
            JOptionPane.showMessageDialog(null, "Aprendices registrados");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Aprendices no registrados"+e);
        }
        return false;
    }

    @Override
    public ArrayList listarAp(int codficha) {
        ArrayList<Aprendiz> listaAp = new ArrayList<>();
        
      
      String sql = "select aprendiz.* from aprendiz join aprendiz_ficha on aprendiz.idA = aprendiz_ficha.idA where aprendiz_ficha.codficha= "+codficha;
        try {
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Aprendiz ap = new Aprendiz();
                ap.setIdA(rs.getInt("idA"));
                ap.setDocumentoA(rs.getInt("documentoA"));
                ap.setNombreA(rs.getString("nombreA"));
                ap.setApellidoA(rs.getString("apellidoA"));
                ap.setEmailA(rs.getString("emailA"));
                ap.setTelefonoA(rs.getInt("telefonoA"));
                
                listaAp.add(ap);
             
            }
            
            
            
        } catch (Exception e) {
            
        }
        
        return listaAp;
        
      
      
    }

    @Override
    
    public boolean eliminarAprendizFicha() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override

    
    public AprendizFicha listarApFicha(int codficha) {
          
          String sql = "select aprendiz_ficha.* from aprendiz_ficha join aprendiz on aprendiz_ficha.idA = aprendiz.idA where aprendiz_ficha.codficha= "+codficha;
        try {
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
           
                apficha.setCodficha(rs.getInt("codficha"));
  
                
              
            }
            
            
            
        } catch (Exception e) {
            
        }
        
        return apficha;
    }
    
}
