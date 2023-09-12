<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.listadetareas.Tareas"%>
<%
    if(session.getAttribute("listatar")== null){
    ArrayList<Tareas>lisaux = new ArrayList<Tareas>();
    session.setAttribute("listatar", lisaux);
    }
   ArrayList<Tareas>lista = (ArrayList<Tareas>) session.getAttribute("listatar");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center><h1>Gestor de tareas</h1>
        <sub>Nombre: Rene Huanca Mamani</sub>
    </center>
    <a href="MainServlet?op=nuevo">Nueva Tarea</a>
    <table border="1">
        <tr>
            <th>Id</th>
            <th>Tarea</th>
            <th>Complado</th>
            <th>Opciones</th>
        </tr>
        <%
            if(lista !=null){
            for(Tareas item : lista){
            
            
         %>
         <tr>
             <td><%= item.getId() %></td>
             <td><%= item.getTarea() %></td>
             <td><%= item.isCompletado() %></td>
             <td>
                 <a href="MainServlet?op=editar&id=<%=item.getId()%>">Editar</a>
             </td>
             <td>
                 <a href="MainServlet?op=eliminar&id=<%= item.getId() %>" onclick="return(confirm('Esta seguro de eliminar??'))">Eliminar</a>
             </td>
            

             
         <%
            }
            }

         %>
         </tr>
    </table>
    
    </center>
    
    </body>
</html>
