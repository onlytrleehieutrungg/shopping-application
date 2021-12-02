<%-- 
    Document   : viewcart
    Created on : Jun 20, 2021, 11:55:09 PM
    Author     : trung
--%>

<%@page import="trungtran.product.ProductDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="trungtran.cart.CartObject"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Online Shopping</title>
    </head>
    <body>
        <h1>Your Cart Includes</h1>
        <%//1. Customer goes to his/her cart place
            if (session != null) {
                CartObject cart = (CartObject) session.getAttribute("CART");
                if (cart != null) {
                    //3.  Customer takes items from cart
                    Map<String, Integer> items = cart.getItems();
                    if (items != null) {
                        //show items
        %>
        <form action="DispatchController">
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Name</th>
                        <th>Quantity</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        int count = 0;
                        for (String key : items.keySet()) {
                    %>
                    <tr>
                        <td>
                            <%= count++%>
                        </td>
                        <td>
                            #<%= key%>
                        </td>
                        <td>
                            <%= items.get(key)%>
                        </td>
                        <td>
                            <input type="checkbox" value="<%= key%>" name="chkItem" />
                        </td>
                    </tr>
                    <% }// end get each item from item
                    %>
                    <tr>
                        <td colspan="3"> 
                            <a href="DispatchController?btAction=Show+Product">Add more Item to Cart</a> 
                        </td>
                        <td>
                            <input type="submit" value="Remove Selected Items" name="btAction" />
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
        <%
        } else { %>
        <h2>No cart is existed</h2>
        <a href="DispatchController?btAction=Show+Product">Click here to back to Online Shopping</a>
        <%}
                }
            }
        %>

    </body>
</html>
