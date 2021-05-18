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
public class Mostrar extends HttpServlet {

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
        response.setContentType("text/gcic;charset=UTF-8");
        System.out.println(request.getParameter("id"));
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println(request.getParameter("id"));
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
        HttpSession s = request.getSession();
        Captchas c = new Captchas();
        if (request.getParameter("id") != null) {
            ArrayList<Captcha> caps = c.obtener_listado();
            if (!caps.isEmpty()) {
                Captcha en = new Captcha();
                for (int i = 0; i < caps.size(); i++) {
                    if (caps.get(i).getId().equalsIgnoreCase(request.getParameter("id"))) {
                        en = caps.get(i);
                        break;
                    }
                }
                System.out.println(en.getId());
                s.setAttribute("link", "generados/" + en.getId() + ".jsp");
                s.setAttribute("id", en.getId());
                s.setAttribute("nombre", en.getNombre());
                s.setAttribute("url", en.getUrl());
                s.setAttribute("titulo", en.getTitulo());
                response.sendRedirect("http://localhost:8080/GCIC/pages/captcha.jsp");
            } else {
                response.sendRedirect("http://localhost:8080/GCIC/pages/captchas.jsp");
            }
        } else {
            s.setAttribute("link", null);
            s.setAttribute("id",null);
            s.setAttribute("nombre", null);
            s.setAttribute("url",null);
            s.setAttribute("titulo", null);
            response.sendRedirect("http://localhost:8080/GCIC/pages/captcha.jsp");
        }
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
