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
import modelo.Ficha;
import modelodao.FichaDao;

/**
 *
 * @author APRENDIZ
 */
@WebServlet(name = "controladorFicha", urlPatterns = {"/controladorFicha"})
public class controladorFicha extends HttpServlet {

    
        Ficha ficha = new Ficha();
        FichaDao fichadao = new FichaDao();
        
        String listaFi = "view/ListaFi.jsp";
        String editarFi = "view/editarFi.jsp";
        String agregarFi = "view/FFicha.jsp";
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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet controladorFicha</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet controladorFicha at " + request.getContextPath() + "</h1>");
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
        
        if(action.equalsIgnoreCase("listar")){
                acceso=listaFi;
            }
        
        if(action.equalsIgnoreCase("agregar")){
                acceso=agregarFi;
            }
        if(action.equalsIgnoreCase("registrar")){
            int codficha = Integer.parseInt(request.getParameter("txtCodFicha"));
       
            int cantapre = Integer.parseInt(request.getParameter("txtCantApre"));
            int codpro = Integer.parseInt(request.getParameter("txtCodpro"));
            String[] aprendicesFicha = request.getParameterValues("txtIdap");
            int[] aprendicesFichaint = new int[aprendicesFicha.length];
            
           
            for(int i = 0; i < aprendicesFicha.length; i++){
                aprendicesFichaint[i] = Integer.parseInt(aprendicesFicha[i]);
            }
            
            
            ficha.setCodpro(codpro);
            ficha.setCodficha(codficha);
            ficha.setCantapre(cantapre);
            ficha.setIdA(aprendicesFichaint);
            fichadao.registrarFicha(ficha);
            
            
            acceso=listaFi;
            
                   
        }
        
        else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("codficha", request.getParameter("codficha"));
            acceso = editarFi;
        }
        
        else if(action.equalsIgnoreCase("eliminar")){
            int codficha = Integer.parseInt(request.getParameter("codficha") );
            ficha.setCodficha(codficha);
            fichadao.eliminarFicha(codficha);
            acceso = listaFi;
        }
        
        else if(action.equalsIgnoreCase("actualizar")){
            int codficha = Integer.parseInt(request.getParameter("txtCodficha") );
            int cantapre = Integer.parseInt(request.getParameter("txtCantapre"));
            int codpro = Integer.parseInt(request.getParameter("txtCodpro"));
            ficha.setCodficha(codficha);
            ficha.setCantapre(cantapre);
            ficha.setCodpro(codpro);
            fichadao.actualizarFicha(ficha);
            
            acceso = listaFi;
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
