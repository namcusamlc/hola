/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.EntryDAO;
import dal.InformationDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Entry;
import model.Information;

/**
 *
 * @author hoaktse05446
 */
public class HomeController extends HttpServlet {

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
            EntryDAO db = new EntryDAO();
            String productId = request.getParameter("productId");
            request.setAttribute("active", "home");
            if (productId != null) {
                int id = Integer.parseInt(productId);
                Entry product = db.getProduct(id);
                request.setAttribute("detail", "true");
                request.setAttribute("p", product);
                request.getRequestDispatcher("view/productDetail.jsp").forward(request, response);
            } else {
                Information info = new InformationDAO().getInfo();
                ArrayList<Entry> products = db.getLatestProduct();
                Entry intro = db.getIntroduction();
                request.setAttribute("intro", intro);
                request.setAttribute("info", info);
                request.setAttribute("products", products);
                request.getRequestDispatcher("view/home.jsp").forward(request, response);
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
