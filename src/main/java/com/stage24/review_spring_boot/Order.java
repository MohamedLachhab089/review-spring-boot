package com.stage24.review_spring_boot;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Order {

    @JsonProperty("c-name")
    private String customName;
    @JsonProperty("p-name")
    private String productName;
    @JsonProperty("qte")
    private int quantity;

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customName='" + customName + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
