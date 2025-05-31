package entity;

import enums.ManageStatus;

public class Management {
    private String title;
    private double price;
    private ManageStatus manageStatus;

    public ManageStatus getManageStatus() {
        return manageStatus;
    }

    public void setManageStatus(ManageStatus manageStatus) {
        this.manageStatus = manageStatus;
    }

    public Management(String title, double price, ManageStatus manageStatus) {
        this.title = title;
        this.price = price;
        this.manageStatus = manageStatus;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
