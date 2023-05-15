<%-- 
    Document   : editarAp
    Created on : 8/05/2023, 8:50:01 p. m.
    Author     : APRENDIZ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
   
    <body>
        <div>
           
        
           
            <form action="action">
                 <h1>SISTEMA DE EDICIÓN DE USUARIO</h1>
                 <div class="campo">
            <label for="id">Id: </label>
            <input type="text" id="id" name="txtId" disabled="true">
            </div>
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
            
            <input id="boton" type="submit" name="accion" value="actualizar">
            </form>
        
        </div>
    </body>
</html>
