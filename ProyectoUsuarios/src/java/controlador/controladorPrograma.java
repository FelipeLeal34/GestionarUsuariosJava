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
import modelo.Programa;
import modelodao.ProgramaDao;

/**
 *
 * @author APRENDIZ
 */
@WebServlet(name = "controladorPrograma", urlPatterns = {"/controladorPrograma"})
public class controladorPrograma extends HttpServlet {
    
    
    String agregarpro = "view/FPrograma.jsp";
    String listarpro = "view/ListaPro.jsp";
    String editarpro = "view/editarPro.jsp";
    
    Programa pro=  new Programa();
    ProgramaDao prodao = new ProgramaDao();
    

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
            out.println("<title>Servlet controladorPrograma</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet controladorPrograma at " + request.getContextPath() + "</h1>");
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
        if(action.equalsIgnoreCase("agregar")){
            acceso = agregarpro;
        } else if(action.equalsIgnoreCase("listar")){
            acceso = listarpro;
        } else  if(action.equalsIgnoreCase("registrar")){
            int codpro = Integer.parseInt(request.getParameter("codigoPro"));
            String nombrepro = request.getParameter("nombrePro");
            pro.setCodpro(codpro);
            pro.setNompro(nombrepro);
            prodao.registrapro(pro);
            acceso = listarpro;
       
  
        } else if(action.equalsIgnoreCase("eliminar")){
            int codpro = Integer.parseInt(request.getParameter("codpro"));
            pro.setCodpro(codpro);
            prodao.eliminarpro(codpro);
            acceso = listarpro;
            
        }
        
        else if(action.equalsIgnoreCase("editar")){
          request.setAttribute("codpro", request.getParameter("codpro"));
            acceso = editarpro;
            
        }
        
         if(action.equalsIgnoreCase("actualizar")){
          int codpro = Integer.parseInt(request.getParameter("codpro"));
           String nombrepro = request.getParameter("nombrepro");
           pro.setCodpro(codpro);
           pro.setNompro(nombrepro);
           prodao.actualizarpro(pro);
           acceso = listarpro;
           
            
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
