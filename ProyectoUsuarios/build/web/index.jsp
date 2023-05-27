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

        <form action="controladorAprendiz">
            <h1>SISTEMA DE REGISTRO</h1>
            <div class="campo">
            <label for="documento">numero de documento: </label>
            <input type="text" id="documento" name="txtDocumento">
            </div>
             <div class="campo">
            <label for="nombre">Nombre: </label>
            <input type="text" id="nombre" name="txtNombre">
            </div>
            <div class="campo">
             <label for="apellido">Apellido:</label>
            <input type="text" id="apellido" name="txtApellido">
            </div>
  
           
            <div class="campo">
             <label for="email">Correo electronico: </label>
            <input type="email" id="email" name="txtEmail">
            </div>
            <div class="campo">
             <label for="telefono">Telefono: </label>
            <input type="number" id="telefono" name="txtTelefono">
            
            </div>
            
            <div id="registrar">
            
            <input id="boton" type="submit" name="accion" value="registrarA">
            
            </div>
            
        </form>
    </body>
</html>
