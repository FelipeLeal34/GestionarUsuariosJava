/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaz;

import java.util.List;
import modelo.Ficha;

/**
 *
 * @author APRENDIZ
 */
public interface MeFicha {
    public boolean registrarFicha(Ficha ficha);
    public List listarFichas();
    public Ficha listarFicha(int codficha);
    public boolean actualizarFicha(Ficha ficha);
    public boolean eliminarFicha(int codficha);
    
    
    
}
