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

    @Override
    public boolean registrarFicha(Ficha ficha) {
        
        
    
        String sql = "insert into ficha(codficha,cantapre,codpro,idA)values(?,?,?,?)";
        try {
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            ps.setInt(1,ficha.getCodficha());
            ps.setInt(2,ficha.getCantapre());
            ps.setInt(3,ficha.getCodpro());
           
            
          
            
            for(int idAp:ficha.getIdA()){
              
                ps.setInt(4,idAp);
                ps.executeUpdate();
            }
            
            
            JOptionPane.showMessageDialog(null, "Ficha registrada");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ficha no registrada"+e);
        }
        return false;
    }

    @Override
    
    public List listarFichas() {
          throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
          /*
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
                ficha.setIdA(rs.getInt("idA"));
                listaFi.add(ficha);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Fichas no mostradas");
        }
        return listaFi;*/
    }

    @Override
    public Ficha listarFicha(int codficha) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean actualizarFicha(Ficha ficha) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminarFicha(int codficha) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
