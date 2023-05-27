/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelodao;

import config.Conexion;
import interfaz.MeFicha;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Ficha;

/**
 *
 * @author APRENDIZ
 */
public class FichaDao implements MeFicha {
    Conexion con = new Conexion();
    
    Connection cn;
    PreparedStatement ps;

    @Override
    public boolean registrarFicha(Ficha ficha) {
    
        String sql = "insert into ficha(codficha,cantapre,codpro,idA)values('"+ficha.getCodficha()+"','"+ficha.getCantapre()+"','"+ficha.getCodpro()+"','"+ficha.getIdA()+"')";
        try {
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Ficha registrada");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ficha no registrada");
        }
        return false;
    }

    @Override
    public List listarFichas() {
        Arraylist<Programa> listapro = new Array<>;
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
