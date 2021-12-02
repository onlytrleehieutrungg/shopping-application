<%-- 
    Document   : onlineShopping
    Created on : Jun 28, 2021, 2:51:34 AM
    Author     : trung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Online Shopping</title>
    </head>
    <body>
        <h1>Book Store</h1>
        <c:set var="result" value="${requestScope.RESULT_SHOW}"/>
        <c:if test="${not empty result}">
            <table border="1">
                <thead>
                    <tr>                       
                        <th>Sku</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Description</th>
                        <th>Quantity</th>
                        <th>Add Item To Your Cart</th>                        
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="pdto" items="${result}" varStatus="counter">
                    <form action="DispatchController">
                        <tr>      
                            <td>
                                #${pdto.sku}
                            </td>
                            <td>
                                ${pdto.productName}
                            </td>
                            <td>
                                ${pdto.price}
                            </td>
                            <td>
                                ${pdto.desciption}
                            </td>
                            <td>
                                <input type="text" name="quant" value="${pdto.quantity}" />
                                
                            </td>
                            <td>
                                <input type="submit" value="Add Item To Your Cart" name="btAction"/>                
                                <input type="hidden" name="productSku" value="${pdto.sku}"/>                                
                            </td>                        
                        </tr>
                    </form>
                </c:forEach>
            </tbody>
        </table>

    </c:if>
    <form action="DispatchController"> 
        <input type="reset" value="Reset" name="reset" />
        <input type="submit" value="View Your Cart" name="btAction" />
    </form>

</body>
</html>
