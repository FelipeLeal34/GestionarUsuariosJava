/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelodao;

import config.Conexion;
import interfaz.MeAprendiz;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
    

    @Override
    public Aprendiz listar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List listadoAp() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
            JOptionPane.showMessageDialog(null,"Aprendiz no registrado");
        }
        
        
        return false;
        
    }

    @Override
    public boolean actualizarAp(Aprendiz apre) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminarAp(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
