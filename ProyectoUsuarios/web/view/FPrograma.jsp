<%-- 
    Document   : FPrograma
    Created on : 26/04/2023, 6:39:28 p. m.
    Author     : APRENDIZ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario programa</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css crossorigin="anonymous"">
   
    </head>
    <body>
        <h1>Registro de programa</h1>
         <div class="contenedor">
        
        <div class="col-lg-6">
            <form action="../controladorPrograma">
                <h2>Codigo del programa: </h2><br>
                <input type="number" class="form-control" name="codigoPro">
                <h2>nombre del programa: </h2><br>
                <input type="text" class="form-control" name="nombrePro"><br>
                
                
                <input type="submit" id="id" name="accion" value="AgregarP">
                
                
                
            </form>
            
            
           
        </div>
    </div>
        
         <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" i
    </body>
    
    
</html>
