/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaz;

import java.util.List;
import modelo.Aprendiz;
import modelo.AprendizFicha;

/**
 *
 * @author APRENDIZ
 */
public interface MeAprendizFicha {
    public boolean registrarAprendizFicha(AprendizFicha apficha);
    public List listarAp(int codficha);
    public AprendizFicha listarApFicha(int codficha);
    public boolean eliminarAprendizFicha();
    
}
