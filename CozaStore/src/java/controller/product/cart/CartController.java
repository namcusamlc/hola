/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.product.cart;

import dal.ProductDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cart;
import model.Item;
import model.Product;

/**
 *
 * @author HoaPC
 */
public class CartController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private boolean checkLogin(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cooky : cookies) {
            if (cooky.getName().equals("customer")) {
                return true;
            }
        }
        return false;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (checkLogin(request, response)) {
            HttpSession session = request.getSession();
            String command = request.getParameter("command");
            String productID = request.getParameter("productID");
            Cart cart = (Cart) session.getAttribute("cart");

            try {
                int idProduct = Integer.parseInt(productID);
                Product product = new ProductDAO().get(idProduct);
                switch (command) {
                    case "plus":
                        if (cart.getCartItems().containsKey(idProduct)) {
                            cart.plusToCart(idProduct, new Item(product,
                                    cart.getCartItems().get(idProduct).getQuantity()));
                        } else {
                            cart.plusToCart(idProduct, new Item(product, 1));
                        }
                        break;
                    case "remove":
                        cart.removeToCart(idProduct);
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
                response.sendRedirect("home");
            }
            session.setAttribute("cart", cart);
            Thread thread = new Thread();
            try {
                thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(CartController.class.getName()).log(Level.SEVERE, null, ex);
            }
            response.sendRedirect("productdetail?productID=" + productID);
        }else{
            response.sendRedirect("login");
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
