package com.example.propertymanagement;

public class PropertyModel {
    String plot;
    String cust;
    String price;
    String cell;

    public PropertyModel() {
    }

    public PropertyModel(String plot, String cust, String price, String cell) {
        this.plot = plot;
        this.cust = cust;
        this.price = price;
        this.cell = cell;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getCust() {
        return cust;
    }

    public void setCust(String cust) {
        this.cust = cust;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }
}
