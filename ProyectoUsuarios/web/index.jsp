<%-- 
    Document   : index
    Created on : 24/04/2023, 8:55:47 p. m.
    Author     : APRENDIZ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="view/css/estilos.css"/>

        
    </head>
    <body>

        <form action="ControladorAprendiz">
            <h1>SISTEMA DE REGISTRO</h1>
            <div class="campo">
            <label for="documento">numero de documento: </label>
            <input type="text" id="documento" name="documento">
            </div>
             <div class="campo">
            <label for="nombre">Nombre: </label>
            <input type="text" id="nombre" name="nombre">
            </div>
            <div class="campo">
             <label for="apellido">Apellido:</label>
            <input type="text" id="apellido" name="apellido">
            </div>
  
           
            <div class="campo">
             <label for="email">Correo electronico: </label>
            <input type="text" id="email" name="email">
            </div>
            <div class="campo">
             <label for="telefono">Telefono: </label>
            <input type="text" id="telefono" name="telefono">
            
            </div>
            
            <div id="registrar">
            
            <input id="boton" type="submit" name="accion" value="registrar">
            
            </div>
            
        </form>
    </body>
</html>
