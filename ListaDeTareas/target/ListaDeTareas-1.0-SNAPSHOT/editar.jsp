<%@page import="com.emergentes.listadetareas.Tareas"%>
<%
    Tareas reg = (Tareas) request.getAttribute("miobjtar");
   
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registro de persona</h1>
        <form action="MainServlet" method="post">
            <table>
                <tr>
                    <td>ID</td>
                    <td><input type="text" name="id" value="<%= reg.getId()%>" size="2" readonly></td>
                </tr>
                <tr>
                    <td>tarea</td>
                    <td><input type="text" name="tarea" vaule="<%= reg.getTarea() %>"></td>
                </tr> 
                <tr>
                    <td>completado</td>
                    <td><input type="checkbox" name="completado" value="1"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Enviar"></td>
                </tr>
            </table>
        </form>
        
    </body>
</html>
