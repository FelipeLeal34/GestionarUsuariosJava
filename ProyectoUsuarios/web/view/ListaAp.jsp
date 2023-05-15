<%-- 
    Document   : LAprendiz
    Created on : 3/05/2023, 7:17:46 p. m.
    Author     : APRENDIZ
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="modelo.Aprendiz"%>
<%@page import="modelodao.AprendizDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/lista.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div>
            <h1>APRENDICES REGISTRADOS</h1>
            <table border="1"  >
                <thead>
                    <tr>
                        <th>id</th>
                        <th>documento</th>
                        <th>nombre</th>
                        <th>apellido</th>
                        <th>email</th>
                        <th>telefono</th>
                    </tr>
                </thead>
                <tbody>
                    
                
                    <%
                    AprendizDao apredao = new AprendizDao();
                    List<Aprendiz>lista = apredao.listadoAp();
                    Iterator<Aprendiz>it=lista.iterator();
                    Aprendiz ap = null;
                    while (it.hasNext()) {                            
                            ap=it.next();
                            
                        
                    
                    
                    %>
                    
            
                    <tr>
                       
                        
                        <td><%=ap.getIdA()%></td>
                        <td><%=ap.getDocumentoA()%></td>
                        <td> <%=ap.getNombreA()%></td>
                        <td><%=ap.getApellidoA()%></td>
                        <td><%=ap.getEmailA()%></td>
                        <td><%=ap.getTelefonoA()%></td>
                         
                        <td class="botones">
                            <a href="">editar</a>
                            <a href="../controladorAprendiz?accion=eliminar&idA="<%=ap.getIdA()%>>eliminar</a>
                        </td>
                            
                            
                        
                    </tr>
                    
                    
                    <% }%>  
                   
                    
                </tbody>
            </table>

            
        </div>
        
    </body>
</html>