/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelodao;

import config.Conexion;
import interfaz.MeFicha;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Ficha;
import modelo.Programa;

/**
 *
 * @author APRENDIZ
 */
public class FichaDao implements MeFicha {
    Conexion con = new Conexion();
    
    Connection cn;
    PreparedStatement ps;
    ResultSet rs;
    Ficha ficha = new Ficha();

    @Override
    public boolean registrarFicha(Ficha ficha) {
        
        
        
        String sqlficha = "insert into ficha(codficha,cantapre,codpro)values(?,?,?)";
        String sqlaf = "insert into aprendiz_ficha(codficha,idA)values(?,?)";
        
        try {
            cn = con.getConnection();
            PreparedStatement psficha = cn.prepareStatement(sqlficha);
            PreparedStatement psaf = cn.prepareStatement(sqlaf);
            psficha.setInt(1,ficha.getCodficha());
            psficha.setInt(2,ficha.getCantapre());
            psficha.setInt(3,ficha.getCodpro());
            psficha.executeUpdate();
            
           
            
          
            
            for(int idAp:ficha.getIdA()){
                
            
               
              
                psaf.setInt(1,ficha.getCodficha());
                psaf.setInt(2,idAp);
                psaf.executeUpdate();
            }
            
            
            JOptionPane.showMessageDialog(null, "Ficha registrada");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ficha no registrada"+e);
        }
        return false;
    }

    @Override
    
    public List listarFichas() {
        
          
        ArrayList<Ficha> listaFi = new ArrayList<>();
        String sql = "select * from ficha";
        try {
           cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Ficha ficha = new Ficha();
                ficha.setCodficha(rs.getInt("codficha"));
                ficha.setCantapre(rs.getInt("cantapre"));
                ficha.setCodpro(rs.getInt("codpro"));
                
        
                listaFi.add(ficha);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Fichas no mostradas");
        }
        return listaFi;
    }

    @Override
    public Ficha listarFicha(int codficha) {
        String sql = "select * from ficha where codficha="+codficha;
        try{
        cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                ficha.setCodficha(rs.getInt("codficha"));
                ficha.setCantapre(rs.getInt("cantapre"));
                ficha.setCodpro(rs.getInt("codpro"));
            }
        } catch(Exception e){
            
        }
        
        return ficha;
        
    }

    @Override
    public boolean actualizarFicha(Ficha ficha) {
      String sql = "update ficha set cantapre='"+ficha.getCantapre()+"', codpro = '"+ficha.getCodpro()+"' where codficha = "+ficha.getCodficha();
       try {
         
                cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Ficha actualizado");
                
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Ficha no actualizada"+e);
        }
     
      return false;
    }

    @Override
    public boolean eliminarFicha(int codficha) {
     String sql = "delete from ficha where codficha="+codficha;
     try{
        cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            ps.executeUpdate();
    JOptionPane.showMessageDialog(null,"Ficha eliminada");
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"Ficha no eliminada"+e);
        }
     
     return false;
    }

  
}
