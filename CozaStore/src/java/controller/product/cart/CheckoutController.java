/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.product.cart;

import dal.BillDAO;
import dal.BillDetailDAO;
import dal.CustomerDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Bill;
import model.BillDetail;
import model.Cart;
import model.Customer;
import model.Item;

/**
 *
 * @author HoaPC
 */
public class CheckoutController extends HttpServlet {

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
            String payment = request.getParameter("payment");
            String address = request.getParameter("address");
            HttpSession session = request.getSession(true);
            Cart cart = (Cart) session.getAttribute("cart");
            String username = "";
            String password = "";
            Cookie[] cookies = request.getCookies();
            for (Cookie cooky : cookies) {
                if (cooky.getName().equals("customer")) {
                    username = cooky.getValue();
                } else if (cooky.getName().equals("password")) {
                    password = cooky.getValue();
                }
            }
            CustomerDAO db1 = new CustomerDAO();

            Customer customer = db1.get(username, password);
            int ID = (int) new Date().getTime();
            Bill bill = new Bill();
            bill.setId(ID);
            bill.setAddress(address);
            bill.setPayment(payment);
            bill.setCustomerID(customer.getId());
            LocalDate todayLocalDate = LocalDate.now(ZoneId.of("America/Montreal"));
            bill.setDate(java.sql.Date.valueOf(todayLocalDate));
            bill.setTotal(cart.totalCart());
            BillDAO db = new BillDAO();
            db.insertBill(bill);
            for (Map.Entry<Integer, Item> list : cart.getCartItems().entrySet()) {
                new BillDetailDAO().insertBillDetail(new BillDetail(ID,
                        list.getValue().getProduct().getId(),
                        list.getValue().getProduct().getPrice(),
                        list.getValue().getQuantity()));
            }
            cart = new Cart();
            session.setAttribute("cart", cart);
            response.sendRedirect("home");
        } catch (SQLException ex) {
            response.sendRedirect("viewcart");
            Logger.getLogger(CheckoutController.class.getName()).log(Level.SEVERE, null, ex);
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
