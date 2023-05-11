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
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
   
    </head>
    <body>
       
         
        
            <form action="../controladorPrograma">
                 <h1>Registro de programa</h1>
                <div>
                <label for="codigoPro">Codigo del programa: </label>
                <input type="number" name="codigoPro" id="codigoPro">
                </div>
                <div>
                <label for="nombrePro">nombre del programa: </label>
                <input type="text" name="nombrePro id="nombrePro"">
                </div>
                
                 <div>
                <input type="submit" name="accion" value="AgregarP">
                </div>
                
                
            </form>
            
            
           
       
        
         <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" i
    </body>
    
    
</html>
