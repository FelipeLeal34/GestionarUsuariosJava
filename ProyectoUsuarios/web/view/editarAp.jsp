<%-- 
    Document   : editarAp
    Created on : 8/05/2023, 8:50:01 p. m.
    Author     : APRENDIZ
--%>

<%@page import="modelo.Aprendiz"%>
<%@page import="modelodao.AprendizDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="view/css/estilos.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
   
    <body>
        <div>
            <%
                 AprendizDao apredao = new AprendizDao();
                 Aprendiz ap = new Aprendiz();
                 int idA = Integer.parseInt((String)request.getAttribute("idA"));
                 ap = apredao.listar(idA);
                 
                 
                 %>
        
           
            <form action="controladorAprendiz">
                 <h1>SISTEMA DE EDICIÓN DE USUARIO</h1>
                 
                 
                
              <div class="campo">
            <label for="idA">Id Aprendiz: </label>
            <input type="text" id="idA" name="txtIdA" value="<%=ap.getIdA()%>" readonly>
            </div>    
                <div class="campo">
            <label for="documento">numero de documento: </label>
            <input type="text" id="documento" name="txtDocumento" value="<%=ap.getDocumentoA()%>">
            </div>
             <div class="campo">
            <label for="nombre">Nombre: </label>
            <input type="text" id="nombre" name="txtNombre" value="<%=ap.getNombreA()%>">
            </div>
            <div class="campo">
             <label for="apellido">Apellido:</label>
            <input type="text" id="apellido" name="txtApellido" value="<%=ap.getApellidoA()%>">
            </div>
  
            <div class="campo">
             <label for="email">Correo electronico: </label>
            <input type="email" id="email" name="txtEmail" value="<%=ap.getEmailA()%>">
            </div>
            <div class="campo">
             <label for="telefono">Telefono: </label>
            <input type="number" id="telefono" name="txtTelefono" value="<%=ap.getTelefonoA()%>">
            
            </div>
            
            <div id="registrar">
            
            <input id="boton" type="submit" name="accion" value="actualizar">
            <a href="controladorAprendiz?accion=listar">Listar </a>
            </form>
        
        </div>
    </body>
</html>
