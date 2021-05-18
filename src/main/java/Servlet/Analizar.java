/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controladores.Captchas;
import POJOS.Captcha;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author willi
 */
public class Analizar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Analizar</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Analizar at " + request.getParameter("contenido") + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        //response.setContentType("text/plain;charset=UTF-8");
        HttpSession s = request.getSession();
        String prueba = new String(request.getParameter("contenido-archivo").getBytes(), "UTF-8");
        Captchas analizar = new Captchas();
        int temporal = analizar.crear_temporal(prueba);
        if (temporal != -1) {
            int resultado = analizar.analizar();
            if (resultado == -1) {
                s.setAttribute("errores", analizar.errores);
                s.setAttribute("texto", prueba);
                response.sendRedirect("http://localhost:8080/GCIC/pages/errores.jsp");
            } else {
                Captcha en = analizar.retorno;
                ArrayList<Captcha> lis = analizar.obtener_listado();
                boolean escribir = false;
                for (int i = 0; i < lis.size(); i++) {
                    if (lis.get(i).getId().equalsIgnoreCase(en.getId())) {
                        escribir = true;
                        break;
                    }
                }
                if (!escribir) {
                    String tex = new String(analizar.cuerpo.write().getBytes(), "UTF-8");
                    int r = analizar.crear_jsp(tex, en.getId());
                    if (r == 1) {
                        analizar.actualizar(en);
                        s.setAttribute("link", "generados/" + en.getId() + ".jsp");
                        s.setAttribute("id", en.getId());
                        s.setAttribute("nombre", en.getNombre());
                        s.setAttribute("url", en.getUrl());
                        s.setAttribute("temp", tex);
                        response.sendRedirect("http://localhost:8080/GCIC/pages/captcha.jsp");
                    } else {
                        response.sendRedirect("http://localhost:8080/GCIC/pages/captchas.jsp");
                    }
                } else {
                    response.sendRedirect("http://localhost:8080/GCIC/pages/captchas.jsp");
                }
            }
        } else {
            response.sendRedirect("http://localhost:8080/GCIC/pages/errores.jsp");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
