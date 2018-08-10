package com.example.hoangminhk4b.project.Model;

public class RecycleViewProductHomeModel {
    private String img;
    private String nameProduct;
    private int price;

    public RecycleViewProductHomeModel(String img, String nameProduct, int price) {
        this.img = img;
        this.nameProduct = nameProduct;
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
