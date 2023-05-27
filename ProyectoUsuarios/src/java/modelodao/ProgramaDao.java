/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelodao;

import config.Conexion;
import interfaz.MePrograma;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Programa;

/**
 *
 * @author APRENDIZ
 */
public class ProgramaDao implements MePrograma{
    
    
    

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Programa pro = new Programa();
    
    

    @Override
    public Programa listar(int codpro) {
      String sql = "select * from programa where codpro="+codpro;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                pro.setCodpro(rs.getInt("codpro"));
                pro.setNompro(rs.getString("nombrepro"));
            }
        } catch (Exception e) {
        }
      
      return pro;
    
    }

    @Override
    public List listadoPro() {
        ArrayList<Programa> lista = new ArrayList<>();
        String sql = "select * from programa";
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Programa pro = new Programa();
                pro.setCodpro(rs.getInt("codpro"));
                pro.setNompro(rs.getString("nombrepro"));
                lista.add(pro);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProgramaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    @Override
    public boolean registrapro(Programa pro) {
        String sql = "insert into programa(codpro,nombrepro)values('"+pro.getCodpro()+"','"+pro.getNompro()+"')";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
             JOptionPane.showMessageDialog(null,"Programa registrado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Programa no registrado");
        }
        return false;
    }

    @Override
    public boolean actualizarpro(Programa pro) {
       String sql = "update programa set nombrepro='"+pro.getNompro()+"' where codpro = "+pro.getCodpro();
       try{
             con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Programa actualizado");
       }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Programa no actualizado");
       }
       return false;
    }

    @Override
    public boolean eliminarpro(int codpro) {
        String sql = "delete from programa where codpro="+codpro;
        try {
              con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
             JOptionPane.showMessageDialog(null,"Programa eliminado");
        } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null,"Programa no eliminado"+e);
        }
        return false;
    }
    
}
