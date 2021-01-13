/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.DataConfig;
import dal.MenuDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Menu;
import util.Pagger;

/**
 *
 * @author hoaktse05446
 */
public class MenuController extends HttpServlet {

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
        try {
            request.setAttribute("active", "menu");
            MenuDAO db = new MenuDAO();
            String menuId = request.getParameter("menuId");
            if (menuId != null) {
                int id = Integer.parseInt(menuId);
                Menu menu = db.getMenu(id);
                request.setAttribute("detail", "true");
                request.setAttribute("menu", menu);
                request.getRequestDispatcher("view/menuDetail.jsp").forward(request, response);
            } else {
                int pageSize = DataConfig.getPageSize();
                String rawIndex = request.getParameter("page");
                if (rawIndex == null) {
                    rawIndex = "1";
                }
                int pageIndex = Integer.parseInt(rawIndex);
                int gap = DataConfig.getPageGap();
                int total = db.getTotal();
                ArrayList<Menu> list = db.getMenu(pageSize, pageIndex);
                String paging = Pagger.generate(pageIndex, pageSize, total, "?page=", gap);
                request.setAttribute("paging", paging);
                request.setAttribute("list", list);
                request.getRequestDispatcher("view/aboutcake.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.getRequestDispatcher("view/error.jsp").forward(request, response);
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
        processRequest(request, response);
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
