<%-- 
    Document   : ListaFiAp
    Created on : 25/05/2023, 6:55:20 p. m.
    Author     : APRENDIZ
--%>

<%@page import="java.util.List"%>
<%@page import="modelodao.AprendizDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelodao.AprendizFichaDao"%>
<%@page import="modelo.AprendizFicha"%>
<%@page import="modelo.Aprendiz"%>
<%@page import="modelodao.FichaDao"%>
<%@page import="modelo.Ficha"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="view/css/lista.css" rel="stylesheet" type="text/css"/>
  
    </head>
    <body>
        
        <%
            Ficha ficha = new Ficha();
            
            AprendizFichaDao apfichadao = new AprendizFichaDao();
            
            
            int codficha = Integer.parseInt((String)request.getAttribute("codficha"));
            ArrayList<Aprendiz> ListaAp = apfichadao.listarAp(codficha);
            AprendizFicha apficha = apfichadao.listarApFicha(codficha);
           
            
            
            
        %>
        
        <div>
            <form action="controladorAprendizFicha">
                 <div id="ficha"><label for="codficha">Aprendices de la ficha:  </label>
                <input id="codficha" name="txtCodficha" value="<%=apficha.getCodficha()%>" readonly></div>
                
                <div id="selectt">
                
                <details>
                
                <summary for="idAp">Agregar aprendices:  </summary>
                <select id="idAp" name="txtIdap" multiple>
                    <option value="0"></option>
                    <% AprendizDao apredao = new AprendizDao() ;
                    Aprendiz ap = new Aprendiz();
                    List<Aprendiz> lista = apredao.listadoAp();
                    
                    
                    
                    
                        for(Aprendiz li:lista){%>
                        <option value="<%=li.getIdA()%>"><%=li.getNombreA()+li.getApellidoA()%></option>
                        
                        
                        <%
                        }

                    %>
                </select>
                </details>
                </div>
                
                
               
                <input type="submit" name="accion" id="agregar" value="agregar">
            </form>
            
            
            
        
        
        <table border="1">
            <thead>
                <tr>
                  
                 
                    <th>idA</th>
                    <th>documento</th>
                    <th>nombre</th>
                    <th>apellido</th>
                    <th>email</th>
                    <th>telefono</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for(Aprendiz it:ListaAp){ %>
                    <tr>
                   
                        <td><%=it.getIdA()%></td>
                        <td><%=it.getDocumentoA()%></td>
                        <td><%=it.getNombreA()%></td>
                        <td><%=it.getApellidoA()%></td>
                        <td><%=it.getEmailA()%></td>
                        <td><%=it.getTelefonoA()%></td>
                       
                    </tr>
                        
                   <% }
                %>
            </tbody>
        </table>
            </div>
    </body>
</html>
