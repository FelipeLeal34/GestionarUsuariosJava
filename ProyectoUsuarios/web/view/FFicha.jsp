<%-- 
    Document   : FLibro
    Created on : 15/05/2023, 6:34:19 p. m.
    Author     : APRENDIZ
--%>

<%@page import="modelo.Aprendiz"%>
<%@page import="modelo.Aprendiz"%>
<%@page import="modelodao.AprendizDao"%>
<%@page import="modelo.Programa"%>
<%@page import="java.util.List"%>
<%@page import="modelodao.ProgramaDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
        <link href="view/css/estilos.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <form action="controladorFicha">
            <h1>AGREGAR FICHA</h1>
            <div>
                <label for="codficha">Código de ficha: </label>
                <input type="number" name="txtCodFicha" id="codficha">
               
            </div>
            
            <div>
                <label for="cantapre">Cantidad de aprendices:  </label>
                <input type="text" name="txtCantApre" id="cantapre">
               
            </div>
            
            
             <div>
                <label for="cantapre">Programa:  </label>
                <select id="cantapre" name="txtCodpro">
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
                    
                    <div>
                    <details>
                <summary for="idAp">Aprendices:  </summary>
                <select id="idAp" name="txtIdap" multiple>
                    <option value="0"></option>
                    <% AprendizDao apredao = new AprendizDao() ;
                    Aprendiz ap = new Aprendiz();
                    List<Aprendiz> listaAp = apredao.listadoAp();
                    
                    
                    
                    
                        for(Aprendiz li:listaAp){%>
                        <option value="<%=li.getIdA()%>"><%=li.getNombreA()+li.getApellidoA()%></option>
                        
                        
                        <%
                        }

                    %>
                    
                </select>
              </details>
                    </div>
               
            </div>
            
            
            <div>
            
            <input type="submit" name="accion" value="registrar">
            <a href="controladorFicha?accion=listar">Listar Fichas</a>
            
            </div>
                
                
                
               
            
        </form>
    </body>
</html>
