/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author HoaPC
 */
public class BillDetail extends BaseModel{

    private int billID;
    private int productID;
    private float price;
    private int quantity;

    public BillDetail() {
    }

    public BillDetail(int billID, int productID, float price, int quantity) {
        this.billID = billID;
        this.productID = productID;
        this.price = price;
        this.quantity = quantity;
    }
    
    public int getBillID() {
        return billID;
    }

    public void setBillID(int billID) {
        this.billID = billID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
