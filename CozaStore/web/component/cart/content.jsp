<%-- 
    Document   : content
    Created on : Jul 17, 2018, 9:34:02 AM
    Author     : HoaPC
--%>

<%@page import="model.Cart"%>
<%@page import="model.Cart"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Map"%>
<%@page import="model.Item"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    </head>
    <body>
        <%
            Cart cart = (Cart) request.getSession(true).getAttribute("cart");
            if (cart == null) {
                cart = new Cart();
                request.getSession(true).setAttribute("cart", cart);
            }
        %>
        
        <script>
            function checkout(){
                document.getElementById('checkout').submit();
            }
        </script>

        <!-- breadcrumb -->
        <div class="container">
            <div class="bread-crumb flex-w p-l-25 p-r-15 p-t-30 p-lr-0-lg">
                <a href="home" class="stext-109 cl8 hov-cl1 trans-04">
                    Home
                    <i class="fa fa-angle-right m-l-9 m-r-10" aria-hidden="true"></i>
                </a>

                <span class="stext-109 cl4">
                    Shopping Cart
                </span>
            </div>
        </div>
        <form></form>
        <!-- Shoping Cart -->
        <div class="bg0 p-t-75 p-b-85" >
            <div class="container">
                <div class="row">
                    <div class="col-lg-10 col-xl-7 m-lr-auto m-b-50">
                        <div class="m-l-25 m-r--38 m-lr-0-xl">
                            <div class="wrap-table-shopping-cart">
                                <table class="table-shopping-cart">
                                    <tr class="table_head">
                                        <th class="column-1">Product</th>
                                        <th class="column-2"></th>
                                        <th class="column-3">Price</th>
                                        <th class="column-4">Quantity</th>
                                        <th class="column-5">Total</th>
                                    </tr>
                                    <% for (Map.Entry<Integer, Item> list : cart.getCartItems().entrySet()) {%>
                                    <tr class="table_row">
                                        <td class="column-1">
                                            <div class="how-itemcart1">
                                                <img src="<%=list.getValue().getProduct().getUrl()%>" alt="IMG">
                                            </div>
                                        </td>
                                        <td class="column-2"><%=list.getValue().getProduct().getName()%></td>
                                        <td class="column-3">$<%=list.getValue().getProduct().getPrice()%></td>
                                        <td class="column-4">
                                            <div class="wrap-num-product flex-w m-l-auto m-r-0">
                                                <input class="mtext-104 cl3 txt-center num-product" type="number"
                                                       value="<%=list.getValue().getQuantity()%>"/>
                                            </div>
                                        </td>
                                        <td class="column-5">$
                                            <%=list.getValue().getQuantity() * list.getValue().getProduct().getPrice()%></td>
                                    </tr>
                                    <%}%>
                                </table>
                            </div>


                        </div>
                    </div>

                    <div class="col-sm-10 col-lg-7 col-xl-5 m-lr-auto m-b-50">
                        <div class="bor10 p-lr-40 p-t-30 p-b-40 m-l-63 m-r-40 m-lr-0-xl p-lr-15-sm">
                            <h4 class="mtext-109 cl2 p-b-30">
                                Cart Totals
                            </h4>

                            <div class="flex-w flex-t bor12 p-t-15 p-b-30">
                                <div class="size-208 w-full-ssm">
                                    <span class="stext-110 cl2">
                                        Shipping:
                                    </span>
                                </div>

                                <div class="size-209 p-r-18 p-r-0-sm w-full-ssm">
                                    <p class="stext-111 cl6 p-t-2">
                                        Contact us if you need any help.
                                    </p>
                                </div>
                            </div>

                            <form action="checkout" method="GET" id="checkout">
                                <div class="bor8 bg0 m-b-12">
                                    <input class="stext-111 cl8 plh3 size-111 p-lr-15" type="text" name="address" placeholder="Your address">
                                </div>

                                <div class="bor8 bg0 m-b-22">
                                    <input class="stext-111 cl8 plh3 size-111 p-lr-15" type="text" name="payment" placeholder="Payment method">
                                </div>
                            </form>

                            <div class="flex-w flex-t p-t-27 p-b-33">
                                <div class="size-208">
                                    <span class="mtext-101 cl2">
                                        Total:
                                    </span>
                                </div>

                                <div class="size-209 p-t-1">
                                    <span class="mtext-110 cl2">
                                        $<%=cart.totalCart()%>
                                    </span>
                                </div>
                            </div>

                            <button class="flex-c-m stext-101 cl0 size-116 bg3 bor14 hov-btn3 p-lr-15 trans-04 pointer"
                                    onclick="checkout()">
                                Proceed to Checkout
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>


    </body>
</html>
