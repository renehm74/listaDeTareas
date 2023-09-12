/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.emergentes.controlador;

import com.emergentes.listadetareas.Tareas;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rene
 */
@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String op = request.getParameter("op");
       Tareas objtar = new Tareas();
       int id, pos;
       
       HttpSession ses = request.getSession();
       ArrayList<Tareas> lista = (ArrayList<Tareas>)ses.getAttribute("listatar");
       switch(op){
           case"nuevo":
               request.setAttribute("miobjtar", objtar);
               request.getRequestDispatcher("editar.jsp").forward(request, response);
               break;
           case "editar":
               id = Integer.parseInt(request.getParameter("id"));
               pos = buscarPorIndice(request,id);
               
               objtar = lista.get(pos);
               request.setAttribute("miobjtar", objtar);
               request.getRequestDispatcher("editar.jsp").forward(request, response);
               break;
           case "eliminar":
               id = Integer.parseInt(request.getParameter("id"));
               pos = buscarPorIndice(request,id);
               if(pos >= 0){
                   lista.remove(pos);
               }
               request.setAttribute("listatar", lista);
               response.sendRedirect("index.jsp");
               break;
           default:
       }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession ses = request.getSession();
        ArrayList<Tareas> lista = (ArrayList)ses.getAttribute("listatar");
        Tareas objtar = new Tareas();
        objtar.setId(id);
        objtar.setTarea(request.getParameter("tareas"));
        objtar.setCompletado(true);
        if (id == 0){
            int idNuevo = obtenerId(request);
            objtar.setId(idNuevo);
            lista.add(objtar);
        }
        else{
            int pos= buscarPorIndice(request,id);
            lista.set(pos,objtar);
        }
        request.setAttribute("listatar",lista);
        response.sendRedirect("index.jsp");
    }

   public int buscarPorIndice(HttpServletRequest request,int id){
       HttpSession ses = request.getSession();
       ArrayList<Tareas> lista = (ArrayList)ses.getAttribute("listatar");
       
       int pos = -1;
       if(lista != null){
           for(Tareas ele : lista){
               ++pos;
               if(ele.getId() == id){
                   break;
               }
           }
       }
       return pos;
   }
   public int obtenerId(HttpServletRequest request){
       HttpSession ses= request.getSession();
       ArrayList<Tareas> lista = (ArrayList<Tareas>)ses.getAttribute("listatar");
       int idn = 0;
       for (Tareas ele : lista){
           idn = ele.getId();
           
       }
       return idn + 1;
   }

}
