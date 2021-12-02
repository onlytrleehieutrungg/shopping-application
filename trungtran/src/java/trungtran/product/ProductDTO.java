/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trungtran.product;

import java.io.Serializable;

/**
 *
 * @author trung
 */
public class ProductDTO implements Serializable{
    private int sku;
    private String productName;
    private float price;
    private String desciption;
    private int quantity;

    public ProductDTO() {
    }

    public ProductDTO(int sku, String productName, float price, String desciption, int quantity) {
        this.sku = sku;
        this.productName = productName;
        this.price = price;
        this.desciption = desciption;
        this.quantity = quantity;
    }

    
    
    /**
     * @return the sku
     */
    public int getSku() {
        return sku;
    }

    /**
     * @param sku the sku to set
     */
    public void setSku(int sku) {
        this.sku = sku;
    }

    /**
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * @return the desciption
     */
    public String getDesciption() {
        return desciption;
    }

    /**
     * @param desciption the desciption to set
     */
    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
    
    
}
