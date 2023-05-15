/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelodao;

import config.Conexion;
import interfaz.MeAprendiz;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Aprendiz;

/**
 *
 * @author OSCAR
 */
public class AprendizDao implements MeAprendiz {
    
    Conexion co = new Conexion();
    Connection cn;
    PreparedStatement ps;
    ResultSet rs;
    Aprendiz ap = new Aprendiz();
    

    @Override
    public Aprendiz listar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List listadoAp() {
        ArrayList<Aprendiz> lista = new ArrayList<>();
        String sql = "select * from aprendiz";
        try {
            cn = co.getConnection();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Aprendiz usu = new Aprendiz();
                usu.setIdA(rs.getInt("idA"));
                usu.setDocumentoA(rs.getInt("documentoA"));
                usu.setNombreA(rs.getString("nombreA"));
                usu.setApellidoA(rs.getString("apellidoA"));
                usu.setEmailA(rs.getString("emailA"));
                usu.setTelefonoA(rs.getInt("telefonoA"));
                lista.add(usu);
                
                
                
                
            }
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null,"Lista no mostrada: "+e.getMessage());
        }
       
        return lista;
    }

    @Override
    public boolean registrarAp(Aprendiz apre) {
        
        String sql = "insert into aprendiz(documentoA,nombreA,apellidoA,emailA,telefonoA)values('"+apre.getDocumentoA()+"','"+apre.getNombreA()+
                "','"+apre.getApellidoA()+"','"+apre.getEmailA()+"','"+apre.getTelefonoA()+"')";
        
        
        try {
            cn = co.getConnection();
            ps = cn.prepareStatement(sql);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Aprendiz registrado");
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"Aprendiz no registrado: "+e.getMessage());
        }
        
        
        return false;
        
    }

    @Override
    public boolean actualizarAp(Aprendiz apre) {
     String sql = "update aprendriz set documentoA='"+ap.getDocumentoA()+"',nombreA='"+ap.getNombreA()+"',apellidoA='"+ap.getApellidoA()+"',emailA=´"+ap.getEmailA()+
             "'telefonoA='"+ap.getTelefonoA()+"' where idA = "+ap.getIdA();
     try {
            cn = co.getConnection();
            ps = cn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean eliminarAp(int id) {
       String sql = "delete * from aprendiz where id = "+id;
        try {
            cn = co.getConnection();
            ps = cn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
}
