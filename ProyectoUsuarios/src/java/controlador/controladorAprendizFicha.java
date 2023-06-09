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
import modelo.AprendizFicha;
import modelodao.AprendizFichaDao;

/**
 *
 * @author APRENDIZ
 */
@WebServlet(name = "controladorAprendizFicha", urlPatterns = {"/controladorAprendizFicha"})
public class controladorAprendizFicha extends HttpServlet {
    
    AprendizFicha apficha = new AprendizFicha();
    AprendizFichaDao apfichadao = new AprendizFichaDao();
    String acceso = "";
    

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
            out.println("<title>Servlet controladorAprendizFicha</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet controladorAprendizFicha at " + request.getContextPath() + "</h1>");
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
        
        AprendizFicha Apficha = new AprendizFicha();
        
        
        String listaApficha = "view/ListaFiAp.jsp";
        String action = request.getParameter("accion");
        if(action.equalsIgnoreCase("listar")){
            acceso = listaApficha;
            request.setAttribute("codficha",request.getParameter("codficha"));
            
        }
        
        if(action.equalsIgnoreCase("agregar")){
           int codficha = Integer.parseInt(request.getParameter("txtCodficha"));
           String[] aprendicesNuevos = request.getParameterValues("txtIdap");
           int[] aprendicesNuevosint = new int[aprendicesNuevos.length];
           for(int i = 0 ; i < aprendicesNuevos.length; i++){
               aprendicesNuevosint[i] = Integer.parseInt(aprendicesNuevos[i]);
           }
           
           apficha.setIdA(aprendicesNuevosint);
           apficha.setCodficha(codficha);
           apfichadao.registrarAprendizFicha(apficha);
           request.setAttribute("codficha",request.getParameter("txtCodficha"));
           acceso = listaApficha;
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
