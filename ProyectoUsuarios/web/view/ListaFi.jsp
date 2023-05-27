<%-- 
    Document   : ListaFi
    Created on : 19/05/2023, 8:09:54 p. m.
    Author     : APRENDIZ
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Ficha"%>
<%@page import="modelodao.FichaDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/lista.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        
        
        <table border="1">
            <thead>
                <tr>
                    <th>codficha</th>
                    <th>cantapre</th>
                    <th>codpro</th>
                    <th>idA</th>
               
               
               </tr>
            </thead>
            <tbody>
                
                
        <%FichaDao fichadao = new FichaDao();
        Ficha ficha = null;
        List<Ficha> listaFi = fichadao.listarFichas();
        Iterator<Ficha> it = listaFi.iterator();
        
    while(it.hasNext()){
            ficha = it.next();
            }
        
            
        %>
        <tr>
            <td><%=ficha.getCodficha()%></td>
            <td><%=ficha.getCantapre()%></td>
            <td><%=ficha.getCodpro()%></td>
            <td><%=ficha.getIdA()%></td>
            <td>
                <a href="../controladorFicha?accion=editar&codficha=<%=ficha.getCodficha()%>">editar</a>
                <a href="../controladorFicha?accion=eliminar&codficha=<%=ficha.getCodficha()%>">eliminar</a>
                
            </td>
            
      
     
       </tr>
                
            </tbody>
        </table>
        
        
    </body>
</html>
