<%-- 
    Document   : editarPro
    Created on : 10/05/2023, 8:38:41 p. m.
    Author     : APRENDIZ
--%>

<%@page import="modelodao.ProgramaDao"%>
<%@page import="modelo.Programa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="../controladorPrograma">
                 <h1>Registro de programa</h1>
                <%Programa pro = new Programa();
                ProgramaDao prodao = new ProgramaDao();
                int codpro = Integer.parseInt((String)request.getAttribute("codpro"));
                pro = prodao.listar(codpro);
                
                
                
                %>
                <div>
                <label for="codigoPro">Codigo del programa: </label>
                <input type="number" name="codigoPro" id="codigoPro" disabled="true" value="<%=pro.getCodpro()%>">
                </div>
                <div>
                <label for="nombrePro">nombre del programa: </label>
                <input type="text" name="nombrePro" id="nombrePro"" value="<%=pro.getNompro()%>">
                </div>
                
                 <div>
                <input type="submit" name="accion" value="actualizar">
                </div>
                
                
            </form>
    </body>
</html>
