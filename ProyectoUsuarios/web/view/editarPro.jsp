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
        <link href="view/css/estilos.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <form action="controladorPrograma">
                 <h1>Edicion de programa</h1>
                <%Programa pro = new Programa();
                ProgramaDao prodao = new ProgramaDao();
                int codpro = Integer.parseInt((String)request.getAttribute("codpro"));
                pro = prodao.listar(codpro);
                
                
                
                %>
                <div>
                <label for="codigoPro">Codigo del programa: </label>
                <input type="number" name="codpro" id="codigoPro" readonly value="<%=pro.getCodpro()%>">
                </div>
                <div>
                <label for="nombrePro">nombre del programa: </label>
                <input type="text" name="nombrepro" id="nombrePro"" value="<%=pro.getNompro()%>">
                </div>
                
                <div id="botones">
                <input type="submit" name="accion" value="actualizar">
                <a href="controladorPrograma?accion=listar">Listar Programas</a>
                </div>
                
                
            </form>
    </body>
</html>
