/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trungtran.product;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import trungtran.utils.DBHelpers;

/**
 *
 * @author trung
 */
public class ProductDAO implements Serializable {

    private List<ProductDTO> products;

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void showProduct() throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelpers.makeConnection();
            String sql = "Select sku, productName, price, description, quantity "
                    + "From Product";
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();;

            while (rs.next()) {
                int sku = rs.getInt("sku");
                String productName = rs.getString("productName");
                float price = rs.getFloat("price");
                String description = rs.getString("description");
                int quantity = rs.getInt("quantity");

                ProductDTO pdto = new ProductDTO(sku, productName, price, description, quantity);

                if (this.products == null) {
                    this.products = new ArrayList<>();
                }
                this.products.add(pdto);
            }
        } finally {
            if (con != null) {
                con.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
    }

}
