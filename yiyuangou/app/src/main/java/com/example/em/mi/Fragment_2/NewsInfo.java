package com.example.em.mi.Fragment_2;

/**
 * Created by pc on 2017/6/22.
 */

public class NewsInfo {
    //图片
    private int img;
    //标题
    private String title;
    //期数
    private int number;
    //获奖者
    private String winners;
    //参与人数
    private int peoplenumbers;
    //幸运号码
    private String luckynumber;
    //时间
    private String time;
    public NewsInfo(){

    }

    public NewsInfo(int img, String title, int number, String winners, int peoplenumbers, String luckynumber, String time) {
        this.img=img;
        this.title = title;
        this.number = number;
        this.winners = winners;
        this.peoplenumbers = peoplenumbers;
        this.luckynumber = luckynumber;
        this.time = time;
    }

    public int getImg() {
        return img;
    }

    public String getTitle() {
        return title;
    }

    public String getWinners() {
        return winners;
    }

    public int getPeoplenumbers() {
        return peoplenumbers;
    }

    public int getNumber() {
        return number;
    }

    public String getLuckynumber() {
        return luckynumber;
    }

    public String getTime() {
        return time;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public void setWinners(String winners) {
        this.winners = winners;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setPeoplenumbers(int peoplenumbers) {
        this.peoplenumbers = peoplenumbers;
    }

    public void setLuckynumber(String luckynumber) {
        this.luckynumber = luckynumber;
    }
}
