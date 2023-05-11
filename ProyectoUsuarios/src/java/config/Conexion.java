/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author APRENDIZ
 */
public class Conexion {
    
    private final String user = "root";
    private final String password = "";
    private final String url = "jdbc:mysql://localhost:3306/tecnologos2023";
    
    
    Connection con =null;
    
    public Conexion()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=(Connection) DriverManager.getConnection(url,user,password);
            JOptionPane.showMessageDialog(null,"Conexion exitosa");
        
        
        }catch(SQLException e)
        {
         
         JOptionPane.showMessageDialog(null,"Conexion no exitosa : "+e);
         
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Connection getConnection()
    {
        return con;
    }
    
    }