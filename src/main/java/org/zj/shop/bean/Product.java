package org.zj.shop.bean;

public class Product {
    //产品ID
    private int id;
    //产品名
    private String name;
    //图片链接
    private String picLink;
    //价格
    private Double price;

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", picLink='" + picLink + '\'' +
                ", price=" + price +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicLink() {
        return picLink;
    }

    public void setPicLink(String picLink) {
        this.picLink = picLink;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Product(int id, String name, String picLink, Double price) {
        this.id = id;
        this.name = name;
        this.picLink = picLink;
        this.price = price;
    }
}
