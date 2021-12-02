/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trungtran.cart;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import trungtran.product.ProductDTO;

/**
 *
 * @author trung
 */
public class CartObject implements Serializable {

    private  Map<String, Integer> items ;

    public Map<String, Integer> getItems() {
        return items;
    }
//    private ArrayList items = new ArrayList();
//
//    public ArrayList getItems() {
//        return items;
//    }

    public void addItemtoCart(String id) {
        // 1.check Item's item is existed
        if (id == null) {
            return;
        }
        if (id.trim().isEmpty()) {
            return;
        }
        //2. item is existed
        if (this.items == null) {
            this.items = new HashMap<>();
        }
        //3. when item is existed, checking existed id
        int quantity = 1;
        if (this.items.containsKey(id)) {
            quantity = this.items.get(id) + 1;
        }
        //4.update items
        this.items.put(id, quantity);
    }

    public void removeItemFromCart(String id) {
        //1. check selected item
        if (this.items == null) {
            return;
        }
        //checked item has existed, check existed id
        if (this.items.containsKey(id)) {
            this.items.remove(id);
            if (this.items.isEmpty()) {
                this.items = null;
            }
        }
    }

}
//    private ArrayList list = new ArrayList();
//    private float total;
//
//    public void setList(ArrayList list) {
//        this.list = list;
//    }
//    
//    public ArrayList getList() {
//        return list;
//    }
//
//    public void setTotal(float total) {
//        this.total = total;
//    }
//
//    public float getTotal() {
//        return total;
//    }

