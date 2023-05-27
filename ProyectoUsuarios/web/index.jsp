<%-- 
    Document   : index
    Created on : 26/05/2023, 6:50:42 p. m.
    Author     : APRENDIZ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="view/css/index.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="index">
            <h1>Bienvenido al sistema</h1>
            <div id="botones">
            
            <a href="controladorAprendiz?accion=agregar">Aprendiz</a>
            <a href="controladorPrograma?accion=agregar">Programa</a>
            <a href="controladorFicha?accion=agregar">Ficha</a>
            
            </div>
        </div>
    </body>
</html>
