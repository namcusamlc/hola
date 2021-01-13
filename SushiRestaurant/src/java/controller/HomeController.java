/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.DataConfig;
import dal.EntryDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Entry;
import util.Pagger;

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
            Entry banner = db.getBanner();
            request.setAttribute("banner", banner);
            request.setAttribute("active", "home");
            String productId = request.getParameter("id");
            if (productId != null) {
                //product detail
                int id = Integer.parseInt(productId);
                Entry product = db.getProduct(id);
                request.setAttribute("detail", "true");
                request.setAttribute("product", product);
                request.getRequestDispatcher("view/productDetail.jsp").forward(request, response);
            } else {
                int pageSize = DataConfig.getPageSize();
                String rawIndex = request.getParameter("page");
                if (rawIndex == null) {
                    rawIndex = "1";
                }
                int pageIndex = Integer.parseInt(rawIndex);
                int gap = DataConfig.getPageGap();
                ArrayList<Entry> products = db.getProducts(pageSize, pageIndex);
                request.setAttribute("products", products);
                int total = db.getTotalProducts();
                String paging = Pagger.generate(pageIndex, pageSize, total, "?page=", gap);
                request.setAttribute("pagingProduct", paging);
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
