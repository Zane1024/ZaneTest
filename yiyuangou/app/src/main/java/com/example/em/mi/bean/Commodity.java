package com.example.em.mi.bean;

/**
 * Created by pc on 2017/6/26.
 * 购物车entity
 */

public class Commodity {
    //标题
    private String title;
    //图片
    private int img;
    //总量
    private int sum;
    //剩余
    private int surplus;
    //价格
    private double Price;
    //数量
    private int buy_number;
    public  void setBuy_number(int buy_number) {
        this.buy_number = buy_number;
    }public void setPrice(double price) {
        Price = price;
    }

    public double getPrice() {
        return Price;
    }

    public int getBuy_number() {
        return buy_number;
    }

    public String getTitle() {
        return title;
    }

    public int getImg() {
        return img;
    }

    public int getSum() {
        return sum;
    }

    public int getSurplus() {
        return surplus;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public void setSurplus(int surplus) {
        this.surplus = surplus;
    }

    public Commodity(String title, int img, int sum, int surplus) {
        this.title = title;
        this.img = img;
        this.sum = sum;
        this.surplus = surplus;
    }
}
