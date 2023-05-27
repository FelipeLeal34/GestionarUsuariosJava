<%-- 
    Document   : editarFi
    Created on : 26/05/2023, 1:35:28 a. m.
    Author     : OSCAR
--%>

<%@page import="modelodao.FichaDao"%>
<%@page import="modelo.Ficha"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Programa"%>
<%@page import="modelodao.ProgramaDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="view/css/estilos.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <form action="controladorFicha">
            <h1>EDITAR FICHA</h1>
            <%
            Ficha ficha = new Ficha();
            FichaDao fichadao = new FichaDao();
            int codficha = Integer.parseInt((String)request.getAttribute("codficha"));
            ficha = fichadao.listarFicha(codficha);
            
            %>
            <div>
                <label for="codficha">Código de ficha: </label>
                <input type="number" name="txtCodficha" id="codficha" value="<%=ficha.getCodficha()%>" readonly>
               
            </div>
            
            <div>
                <label for="cantapre">Cantidad de aprendices:  </label>
                <input type="text" name="txtCantapre" id="cantapre" value="<%=ficha.getCantapre()%>">
               
            </div>
            
            
             <div>
                <label for="codpro">Programa:  </label>
                <select id="codpro" name="txtCodpro">
                    <option value="0"></option>
                    <% ProgramaDao prodao = new ProgramaDao() ;
                    Programa pro = new Programa();
                    List<Programa> lista = prodao.listadoPro();
                    
                    
                    
                    
                        for(Programa li:lista){%>
                        <option value="<%=li.getCodpro()%>"><%=li.getNompro()%></option>
                        
                        <%
                        }

                    %>
                    
                </select>
                    
              
               
            </div>
            
            
            <div>
            
            <input type="submit" name="accion" value="actualizar">
            <a href="controladorFicha?accion=listar">Listar Fichas</a>
            
            </div>
                
                
                
               
            
        </form>
    </body>
</html>
