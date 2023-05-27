<%-- 
    Document   : LAprendiz
    Created on : 3/05/2023, 7:17:46 p. m.
    Author     : APRENDIZ
--%>

<%@page import="modelo.Programa"%>
<%@page import="modelodao.ProgramaDao"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/lista.css" rel="stylesheet" type="text/css"/>
        <link href="view/css/lista.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div>
            <h1>PROGRAMAS REGISTRADOS</h1>
            <table border="1"  >
                <thead>
                    <tr>
                        <th>Codigo</th>
                        <th>Nombre</th>
                        
                    </tr>
                </thead>
                <tbody>
                    
                
                    <%
                    ProgramaDao prodao = new ProgramaDao();
                    List<Programa>lista = prodao.listadoPro();
                    Iterator<Programa>it=lista.iterator();
                    Programa pro = null;
                    while (it.hasNext()) {                            
                            pro=it.next();
                            
                        
                    
                    
                    %>
                    
            
                    <tr>
                       
                        
                        <td class="btn"><%=pro.getCodpro()%></td>
                        <td class="btn"><%=pro.getNompro()%></td>
                         
                        <td>
                            <a href="controladorPrograma?accion=editar&codpro=<%=pro.getCodpro()%>">editar</a>
                            <a href="controladorPrograma?accion=eliminar&codpro=<%=pro.getCodpro()%>">eliminar</a>
                       
                        </td>
                            
                            
                        
                    </tr>
                    
                    
                    <% }%>  
                   
                    
                </tbody>
            </table>

            
        </div>
        
    </body>
</html>