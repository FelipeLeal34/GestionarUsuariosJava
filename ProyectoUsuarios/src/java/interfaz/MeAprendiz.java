/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaz;

import java.util.List;
import modelo.Aprendiz;

/**
 *
 * @author OSCAR
 */
public interface MeAprendiz{
    public Aprendiz listar(int id);
    public List listadoAp();
    public boolean registrarAp(Aprendiz apre);
    public boolean actualizarAp(Aprendiz apre);
    public boolean eliminarAp(int id);
}
