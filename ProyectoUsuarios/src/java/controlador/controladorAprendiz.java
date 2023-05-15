/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Aprendiz;
import modelodao.AprendizDao;

/**
 *
 * @author OSCAR
 */
@WebServlet(name = "controladorAprendiz", urlPatterns = {"/controladorAprendiz"})
public class controladorAprendiz extends HttpServlet {
    
    String listarapre = "view/ListaAp.jsp";
    String agregarapre = "index.jsp";
    String editarapre = "view/editarAp.jsp";
    
    Aprendiz apre = new Aprendiz();
    AprendizDao apredao = new AprendizDao();
    int id;
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet controladorAprendiz</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet controladorAprendiz at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String acceso = "";
        String action = request.getParameter("accion");
        if(action.equalsIgnoreCase("listarapre")){
            acceso = listarapre;
        } else if(action.equalsIgnoreCase("agregarapre")){
                acceso = agregarapre;
        } else if(action.equalsIgnoreCase("registrarA")){
                int documento = Integer.parseInt(request.getParameter("txtDocumento"));
                String nombre = request.getParameter("txtNombre");
                String apellido = request.getParameter("txtApellido");
                String email = request.getParameter("txtEmail");
                int telefono = Integer.parseInt(request.getParameter("txtTelefono"));
                
                apre.setDocumentoA(documento);
                apre.setNombreA(nombre);
                apre.setApellidoA(apellido);
                apre.setEmailA(email);
                apre.setTelefonoA(telefono);
                apredao.registrarAp(apre);
                acceso = listarapre;
              
             
        }  
        
        else if(action.equalsIgnoreCase("eliminar")){
           int id = Integer.parseInt(request.getParameter("idA"));
            
            apre.setIdA(id);
            apredao.eliminarAp(id);
            acceso=listarapre;
            

       
        }
        
        else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idA", request.getParameter("idA"));
            acceso = editarapre;
            
          
            
           
        } else if(action.equalsIgnoreCase("actualizar")){
            
            int id = Integer.parseInt(request.getParameter("txtId"));
            int documento = Integer.parseInt(request.getParameter("txtDocumento"));
                String nombre = request.getParameter("txtNombre");
                String apellido = request.getParameter("txtApellido");
                String email = request.getParameter("txtEmail");
                int telefono = Integer.parseInt(request.getParameter("txtTelefono"));
                
                apre.setDocumentoA(documento);
                apre.setNombreA(nombre);
                apre.setApellidoA(apellido);
                apre.setEmailA(email);
                apre.setTelefonoA(telefono);
                apredao.actualizarAp(apre);
                acceso = listarapre;
        }
        

        
                                  RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
